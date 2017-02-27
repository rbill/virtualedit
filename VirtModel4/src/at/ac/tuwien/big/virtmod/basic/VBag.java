package at.ac.tuwien.big.virtmod.basic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public interface VBag<T> extends Iterable<T> {

	//public Set<? extends T> getEntries();

	
	public int size();
	
	
	
	public default boolean isEmpty() {
		return !iterator().hasNext();
	}
	
	public default boolean contains(T entry) {
		return getState(entry) == ContainState.CONTAINS;
	}
	

	public ContainState getState(T entry);
	
	public default Set<T> getValues() {
		Set<T> ret = new HashSet<T>();
		for (T v: this) {
			ret.add(v);
		}
		return ret;
	}
	
	public Collection<T> asCollection();



	public default Object source() {
		return null;
	}
}
