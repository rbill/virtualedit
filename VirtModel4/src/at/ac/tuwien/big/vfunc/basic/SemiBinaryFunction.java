package at.ac.tuwien.big.vfunc.basic;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface SemiBinaryFunction<Source,Param1,Target> extends ArbitraryFunction {

	
	public Class<Source> sourceClass();
	
	public Class<Param1> param1Class();
	
	public BiFunction<Source, Param1, Target> func();
	
	@Override
	public default Object apply(Object[] src) {
		if (src.length == 2 && (src[0] == null || sourceClass().isAssignableFrom(src[0].getClass()))
				&& (src[1] == null || param1Class().isAssignableFrom(src[1].getClass()))
				) {
			return get((Source)src[0],(Param1)src[1]);
		}
		if (src.length != 2) {
			throw new RuntimeException("Wrong parameters: required 2 " + sourceClass()+", " + param1Class()+", got "+src.length+" parameters");
		}
		throw new RuntimeException("Wrong parameters: required 2 " + sourceClass()+", " + param1Class()+", got "+src[0]+", "+src[1]);
	}
	
	public default Target get(Source src, Param1 param1)  {
		return func().apply(src,param1);
	}
	
}
