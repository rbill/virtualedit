package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunc;

public class UnionMapFunction<Src,Mid,Target> extends AbstractMapFunction<Src, Target> {

	public UnionMapFunction(FunctionType<Src, Target> type, boolean isSorted, Function<List<CompleteResult<Src,Mid>>,CompleteResult<Src,Target>> mergeFunction,
			List<VFunc<Src, Mid>> unionedFunctions) {
		super(type, isSorted);
		this.mergeFunction = mergeFunction;
		this.unionedFunctions = unionedFunctions;
	}
	
	private Function<List<CompleteResult<Src,Mid>>,CompleteResult<Src,Target>> mergeFunction;
	private List<VFunc<Src, Mid>> unionedFunctions;

	@Override
	public CompleteResult<Src, Target> priv_calcResult(Src source) {
		BasicAssignment<Src, Target> assignment = new BasicAssignment<>(parentFunction, scope, target, editor, type)
		asdf; //Mit BasicAssignment geht das nicht ... 
		CompleteResult<Src, Target> temp = BasicCompleteResult.WORKING_NO_RESULT(assignment,source);
		updateResult(temp);
		return temp;
	}
	
	private void updateResult(CompleteResult<Src, Target> result) {
		List<CompleteResult<Src, Mid>> srcResults = new ArrayList<>();
		Src src = result.source();
		for (VFunc<Src, Mid> vfunc: unionedFunctions) {
			if (vfunc.containsKey(src)) {
				srcResults.add(vfunc.evaluate(src));
			}
		}
		CompleteResult<Src, Target> evaluated = mergeFunction.apply(srcResults);
		result.mergeWithCurrent(evaluated);
	}

	@Override
	public Scope<Src> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

}
