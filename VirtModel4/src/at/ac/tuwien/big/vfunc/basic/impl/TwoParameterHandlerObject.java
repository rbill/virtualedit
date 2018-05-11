package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vfunc.basic.OneParameterSupplier;
import at.ac.tuwien.big.vfunc.basic.TwoParameterSupplier;

public class TwoParameterHandlerObject<Source,Param1,Target,FuncSource> extends TwoOrMoreParameterHandlerObject<TwoParameterHandlerObject<Source,Param1,Target,FuncSource>, Source, Param1, Target,FuncSource> {

	public TwoParameterHandlerObject(
			BiFunction<? super TwoParameterHandlerObject<Source, Param1, Target, FuncSource>,Pair<FuncSource,List<Supplier<?>>>,? extends Target> func,
			Class<Source> sourceClass,
			Class<Param1> param1Class
			) {
		super(func, sourceClass, param1Class);
	}
	
	public static<Source,Param1,Target,FuncSource> TwoParameterHandlerObject<Source,Param1,Target,FuncSource> get(Function<? super TwoParameterSupplier<Source, Param1>,
				Target> function, Class<Source> sourceClass, Class<Param1> param1Class) {
		
		BiFunction<? super TwoParameterHandlerObject<Source, Param1, Target,FuncSource>, Pair<FuncSource,List<Supplier<?>>>, Target> biFunc = 
				(thisObj, supplierListPair)->{
				TwoParameterSupplier<Source,Param1> supplier = new TwoParameterSupplier<Source,Param1>() {

					@Override
					public Source getSource() {
						return thisObj.getSource(supplierListPair.getB());
					}
					
					@Override
					public Param1 getParam1() {
						return thisObj.getParam1(supplierListPair.getB());
					}
					
				};
				return function.apply(supplier);
		};
		
		TwoParameterHandlerObject<Source, Param1, Target,FuncSource> ret = new TwoParameterHandlerObject<Source, Param1, Target, FuncSource>(biFunc, sourceClass, param1Class);
		return ret;
	}

	
	public static<Source,Param1,Target,FuncSource> TwoParameterHandlerObject<Source, Param1, Target,FuncSource> getBinaryOp(BiFunction<Source, Param1, Target> func, Class<Source> sourceClass, Class<Param1> param1Class) {
		return get((supplier)->func.apply(supplier.getSource(), supplier.getParam1()), sourceClass, param1Class);
	}
	
}
