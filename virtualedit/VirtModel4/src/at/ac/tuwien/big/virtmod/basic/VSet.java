package at.ac.tuwien.big.virtmod.basic;

import java.util.Collection;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.wrapper.impl.SetWrapperImpl;

public interface VSet<T> extends VBag<T> {


	public default Set<T> asCollection() {
		return new SetWrapperImpl<T>(this);
	}
}
