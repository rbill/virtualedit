package at.ac.tuwien.big.vfunc.basic;

import java.util.function.Function;

public interface SemiUnaryFunction<Source,Target> extends ArbitraryFunction {
	
	public Class<Source> sourceClass();
	
	public Function<Source, Target> func();
	
	@Override
	public default Object apply(Object[] src) {
		if (src.length == 1 && (src[0] == null || sourceClass().isAssignableFrom(src[0].getClass()))) {
			return get((Source)src[0]);
		}
		if (src.length != 1) {
			throw new RuntimeException("Wrong parameters: required 1 " + sourceClass()+", got "+src.length+" parameters");
		}
		throw new RuntimeException("Wrong parameters: required 1 " + sourceClass()+", got "+src[0]+" as parameter");
	}
	
	public default Target get(Source src)  {
		return func().apply(src);
	}

}
