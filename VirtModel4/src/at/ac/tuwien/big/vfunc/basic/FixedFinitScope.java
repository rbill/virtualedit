package at.ac.tuwien.big.vfunc.basic;

import java.util.Collection;
import java.util.Iterator;

public interface FixedFinitScope<Src> extends Scope<Src>, Iterable<Src> {

	public Collection<Src> getValues();
	
	@Override
	public default Iterator<Src> iterator() {
		return getValues().iterator();
	}
	
	public default boolean contains(Src src) {
		return getValues().contains(src);
	}
}
