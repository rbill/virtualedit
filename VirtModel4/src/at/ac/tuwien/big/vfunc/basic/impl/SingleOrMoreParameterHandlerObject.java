package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import uk.ac.york.cs.ecss.learn.learnformat.MyPair;

public abstract class SingleOrMoreParameterHandlerObject<This extends SingleOrMoreParameterHandlerObject<This,Source,Target,FuncSource>, Source, Target,FuncSource> extends ParameterHandlerObject<This, Target,FuncSource> {

	private final Class<Source> sourceClass;
	
	public SingleOrMoreParameterHandlerObject(
			BiFunction<? super This,MyPair<FuncSource,List<Supplier<?>>>,? extends Target> func,
			Class<Source> sourceClass
			) {
		super(func);
		this.sourceClass = sourceClass;
	}
	
	protected<T> T getTypedParameter(List<Supplier<?>> supplierList, int index, Class<T> clazz) {
		Object ret = getParameter(supplierList,index);
		if (ret == null || clazz.isAssignableFrom(ret.getClass())) {
			return (T) ret;
		}
		throw new RuntimeException("Could not correctly retrieve parameter " +index+": Expected "+clazz+" but got object "+ret );
	}
	 
	public Source getSource(List<Supplier<?>> supplierList) {
		return getTypedParameter(supplierList, 0, sourceClass);
	}

}
