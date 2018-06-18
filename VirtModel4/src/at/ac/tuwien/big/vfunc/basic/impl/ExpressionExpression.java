package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.vfunc.basic.AnyParameterModifier;
import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.FourParameterModifier;
import at.ac.tuwien.big.vfunc.basic.FunctionApplicator;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.VFunction;

public class ExpressionExpression<Source,Target> implements Expression<Source, Target> {

	private List<? extends FunctionApplicator<? super Source, ?, ?>> functionApplicators = new ArrayList<>();
	private BiFunction<? super Source,List<Supplier<?>>, ? extends Target> combiner;
	
	/**The combiner should only call the supply method once, and only if it needs the result*/
	public ExpressionExpression(List<? extends FunctionApplicator<? super Source, ?, ?>> functionApplicators, BiFunction<? super Source, List<Supplier<?>>, ? extends Target> combiner) {
		this.functionApplicators = functionApplicators;
		this.combiner = combiner;
	}
	
	public static class EEExtraction<SubSource,SubTarget> implements FunctionApplicator<BasicEE, SubSource, SubTarget> {
		private final int[] indices;
		private final FunctionApplicator<? super BasicEE, SubSource,SubTarget> applicator;
		
		public EEExtraction(FunctionApplicator<? super BasicEE, SubSource,SubTarget> applicator, int... indices) {
			this.indices = indices;
			this.applicator = applicator;
		}

		@Override
		public VFunction<SubSource, SubTarget> function() {
			return applicator.function();
		}

		@Override
		public Function<BasicEE, SubSource> extractor() {
			return (origEE)->{
				BasicEE newEE = origEE.extract(indices);
				SubSource ret = applicator.extractor().apply(newEE);
				return ret;
			};
		}
	}
	
	public static<SubSource,SubTarget> FunctionApplicator<BasicEE, SubSource,SubTarget> wrapExtractor(FunctionApplicator<BasicEE, SubSource,SubTarget> applicator, int... indices) {
		return new EEExtraction<>(applicator, indices);
	}
	
	public static ExpressionExpression<BasicEE, BasicEE> getEEModifier(List<EEExtraction<?,?>> eeExtractorVariables, Consumer<? super AnyParameterModifier> modifier, int... indices) {
		BiFunction<BasicEE, List<Supplier<?>>, BasicEE> combiner = BasicEE.getEEModifier(modifier,indices);
		ExpressionExpression<BasicEE, BasicEE> ret = new ExpressionExpression<>(eeExtractorVariables, combiner);
		return ret; 
	}
	
	@Override
	public Target calcResult(AssignmentSourceInfo<Source, Target> src, List<FunctionNotifyer<?, ?, ?>> subResultInfos) {
		Source source = src.source();
		List<Supplier<?>> supplierList = new ArrayList<>();
		functionApplicators.forEach(x->{
			supplierList.add(()->{
				CompleteResult<?, ?> result = x.getResult(source);	
				subResultInfos.add(result);
				return result;
			});
		});
		Target outerSource = combiner.apply(source,supplierList);
		return outerSource;
	}

}
