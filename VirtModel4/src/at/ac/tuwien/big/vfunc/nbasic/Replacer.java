package at.ac.tuwien.big.vfunc.nbasic;

import java.util.function.Function;

public interface Replacer {

	public Replacer push();
	
	//public Replacer pop();
	
	public Object get(Object from);
	
	public<T> Object get(T from, Function<? super T,?> supplier);
}
