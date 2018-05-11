package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.function.BiFunction;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.SemiBinaryFunction;
import at.ac.tuwien.big.vfunc.basic.SemiUnaryFunction;

public class BasicBinaryFunction<Source,Param1,Target> implements SemiBinaryFunction<Source, Param1, Target> {

	private final Class<Source> sourceClass;
	private final Class<Param1> param1Class;
	private final BiFunction<Source, Param1, Target> func;
	
	public BasicBinaryFunction(Class<Source> sourceClass, Class<Param1> param1Class, BiFunction<Source, Param1, Target> func) {
		this.sourceClass = sourceClass;
		this.param1Class = param1Class;
		this.func = func;
	}
	
	@Override
	public Class<Source> sourceClass() {
		return sourceClass;
	}
	

	@Override
	public Class<Param1> param1Class() {
		return param1Class;
	}

	@Override
	public BiFunction<Source, Param1, Target> func() {
		return func;
	}

}
