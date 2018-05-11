package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Scope;

public class BasicInfiniteScope<Src> implements Scope<Src> {
	public static final BasicInfiniteScope<Object> EVERYTHING = new BasicInfiniteScope<>(x->true);
	
	public static final<Src> BasicInfiniteScope<Src> EVERYTHING() {
		return (BasicInfiniteScope<Src>) EVERYTHING;
	}
	
	private Function<Src,Boolean> func;
	
	public BasicInfiniteScope(Function<Src,Boolean> func) {
		this.func = func;
	}

	@Override
	public boolean contains(Src src) {
		Boolean ret = func.apply(src);
		return ret != null && ret;
	}
	

}
