package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import uk.ac.york.cs.ecss.learn.learnformat.MyPair;

public abstract class ThreeOrMoreParameterHandlerObject<This extends ThreeOrMoreParameterHandlerObject<This,Source,Param1,Param2,Target,FuncSource>, Source, Param1, Param2, Target,FuncSource> extends TwoOrMoreParameterHandlerObject<This, Source, Param1, Target,FuncSource> {

	private final Class<Param2> param2Class;
	
	public ThreeOrMoreParameterHandlerObject(
			BiFunction<? super This,MyPair<FuncSource,List<Supplier<?>>>,? extends Target> func,
			Class<Source> sourceClass,
			Class<Param1> param1Class,
			Class<Param2> param2Class
			) {
		super(func, sourceClass, param1Class);
		this.param2Class = param2Class;
	}
	
	 
	public Param2 getParam2(List<Supplier<?>> supplierList) {
		return getTypedParameter(supplierList, 2, param2Class);
	}

}
