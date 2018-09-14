package at.ac.tuwien.big.virtmod.basic.col;

import java.util.function.Function;

public interface Converter<X,Y> extends Function<X,Y>{

	public Y convert(X x);
	
	default Y apply(X x) {
		return convert(x);
	}

	public static<F,E> Converter<F, E> from(Function<F, E> fromDelegate) {
		if (fromDelegate instanceof Converter) { 
			return (Converter)fromDelegate;
		} else {
			return x->fromDelegate.apply(x);
		}
	}
}
