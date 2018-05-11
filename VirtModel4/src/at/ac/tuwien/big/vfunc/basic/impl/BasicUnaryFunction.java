package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.SemiUnaryFunction;

public class BasicUnaryFunction<Source,Target> implements SemiUnaryFunction<Source, Target> {

	private final Class<Source> sourceClass;
	private final Function<Source, Target> func;
	
	public BasicUnaryFunction(Class<Source> sourceClass, Function<Source, Target> func) {
		this.sourceClass = sourceClass;
		this.func = func;
	}
	
	@Override
	public Class<Source> sourceClass() {
		return sourceClass;
	}

	@Override
	public Function<Source, Target> func() {
		return func;
	}

}
