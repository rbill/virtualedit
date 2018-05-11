package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.generalutil.Pair;

public abstract class TwoOrMoreParameterHandlerObject<This extends TwoOrMoreParameterHandlerObject<This,Source,Param1,Target,FuncSource>, Source, Param1, Target,FuncSource> extends SingleOrMoreParameterHandlerObject<This, Source, Target,FuncSource> {

	private final Class<Param1> param1Class;
	
	public TwoOrMoreParameterHandlerObject(
			BiFunction<? super This,Pair<FuncSource,List<Supplier<?>>>,? extends Target> func,
			Class<Source> sourceClass,
			Class<Param1> param1Class
			) {
		super(func, sourceClass);
		this.param1Class = param1Class;
	}
	
	 
	public Param1 getParam1(List<Supplier<?>> supplierList) {
		return getTypedParameter(supplierList, 1, param1Class);
	}

}
