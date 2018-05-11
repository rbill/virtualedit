package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vfunc.basic.OneParameterSupplier;

public class SingleParameterHandlerObject<Source,Target,FuncSource> extends SingleOrMoreParameterHandlerObject<SingleParameterHandlerObject<Source,Target,FuncSource>, Source, Target,FuncSource> {

	public SingleParameterHandlerObject(
			BiFunction<? super SingleParameterHandlerObject<Source, Target, FuncSource>,Pair<FuncSource,List<Supplier<?>>>,? extends Target> func,
			Class<Source> sourceClass
			) {
		super(func, sourceClass);
	}
	
	public static<Source,Target,FuncSource> SingleParameterHandlerObject<Source,Target,FuncSource> get(Function<? super OneParameterSupplier<Source>,
				Target> function, Class<Source> sourceClass) {
		
		BiFunction<? super SingleParameterHandlerObject<Source, Target,FuncSource>, Pair<FuncSource,List<Supplier<?>>>, Target> biFunc = 
				(thisObj, supplierListPair)->{
				OneParameterSupplier<Source> supplier = new OneParameterSupplier<Source>() {

					@Override
					public Source getSource() {
						return thisObj.getSource(supplierListPair.getB());
					}
					
				};
				return function.apply(supplier);
		};
		
		SingleParameterHandlerObject<Source, Target,FuncSource> ret = new SingleParameterHandlerObject<Source, Target,FuncSource>(biFunc, sourceClass);
		return ret;
	}
	

	public static<Source,Target,FuncSource> SingleParameterHandlerObject<Source, Target,FuncSource> getUnaryOp(Function<Source, Target> func, Class<Source> sourceClass) {
		return get((supplier)->func.apply(supplier.getSource()), sourceClass);
	}

}
