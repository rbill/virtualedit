package at.ac.tuwien.big.vfunc.basic;

import java.util.Collection;
import java.util.Iterator;

public interface CollectionScope<Src> extends FixedFinitScope<Src> {

	public Collection<? extends Src> getValues();
	
	@Override
	public default Iterator<Src> iterator() {
		return ((Collection<Src>)getValues()).iterator();
	}
	
	public default boolean contains(Src src) {
		return getValues().contains(src);
	}

}
