package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vfunc.basic.OneParameterSupplier;
import at.ac.tuwien.big.vfunc.basic.ThreeParameterSupplier;
import at.ac.tuwien.big.vfunc.basic.TwoParameterSupplier;

public class ThreeParameterHandlerObject<Source,Param1,Param2,Target,FuncSource> extends ThreeOrMoreParameterHandlerObject<ThreeParameterHandlerObject<Source,Param1,Param2,Target,FuncSource>, Source, Param1, Param2,Target,FuncSource> {

	public ThreeParameterHandlerObject(
			BiFunction<? super ThreeParameterHandlerObject<Source, Param1, Param2, Target, FuncSource>,Pair<FuncSource,List<Supplier<?>>>,? extends Target> func,
			Class<Source> sourceClass,
			Class<Param1> param1Class,
			Class<Param2> param2Class
			) {
		super(func, sourceClass, param1Class, param2Class);
	}
	
	public static<Source,Param1,Param2,Target,FuncSource> ThreeParameterHandlerObject<Source,Param1,Param2,Target,FuncSource> get(Function<? super ThreeParameterSupplier<Source, Param1, Param2>,
				Target> function, Class<Source> sourceClass, Class<Param1> param1Class, Class<Param2> param2Class) {
		
		BiFunction<? super ThreeParameterHandlerObject<Source, Param1, Param2, Target, FuncSource>, Pair<FuncSource,List<Supplier<?>>>, Target> biFunc = 
				(thisObj, supplierListPair)->{
				ThreeParameterSupplier<Source,Param1,Param2> supplier = new ThreeParameterSupplier<Source,Param1,Param2>() {

					@Override
					public Source getSource() {
						return thisObj.getSource(supplierListPair.getB());
					}
					
					@Override
					public Param1 getParam1() {
						return thisObj.getParam1(supplierListPair.getB());
					}
					

					@Override
					public Param2 getParam2() {
						return thisObj.getParam2(supplierListPair.getB());
					}
					
				};
				return function.apply(supplier);
		};
		
		ThreeParameterHandlerObject<Source, Param1, Param2, Target,FuncSource> ret = new ThreeParameterHandlerObject<>(biFunc, sourceClass, param1Class, param2Class);
		return ret;
	}

	public static<T,FuncSource> ThreeParameterHandlerObject<Boolean, T, T, T,FuncSource> getIf(Class<T> clazz) {
		return get((supplier)->{
			if (supplier.getSource()) {
				return supplier.getParam1();
			} else {
				return supplier.getParam2();
			}
		}, Boolean.class, clazz, clazz);
	}
	
}
