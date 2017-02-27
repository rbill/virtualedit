package at.ac.tuwien.big.vmodel.general;

import java.util.WeakHashMap;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;

public interface DelegatingFunc<X extends VEntryIterableFunc<A,? extends B>, A, B> extends VEntryIterableFunc<A,B>{

	public abstract X base1Func();
	
	@Override
	public default Editstate getEditState() {
		return base1Func().getEditState();
	}
	
	@Override
	public default boolean isSelfEmpty() {
		return base1Func().isSelfEmpty();
	}

	@Override
	public default boolean selfClear() {
		return base1Func().selfClear();
	}
	
	public static WeakHashMap<Class<?>, Class<?>[]> interfaces = new WeakHashMap<Class<?>, Class<?>[]>();
	
	public default Iterable<? extends Entry<? extends A, ? extends B>> getEntries() {
		return base1Func().getEntries();
	}
	
	public default B get(A a) {
		return base1Func().get(a);
	}
}
