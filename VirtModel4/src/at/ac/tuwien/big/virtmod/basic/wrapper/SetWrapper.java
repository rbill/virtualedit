package at.ac.tuwien.big.virtmod.basic.wrapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;

public interface SetWrapper<T> extends CollectionWrapper<T>, Set<T> {
	
	public VBag<T> getDelegate();
	
	public default boolean add(T o) {
		throw new UnsupportedOperationException();
	}
	

	@Override
	public default boolean addAll(Collection<? extends T> c) {
		boolean ret = !c.isEmpty();
		for (T t: c) {
			add(t);
		}
		return ret;
	}

	@Override
	public default void clear() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public default boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public default boolean contains(Object o) {
		return ((VEditableList)getDelegate()).contains(o);		
	}

	@Override
	public default boolean containsAll(Collection<?> c) {
		for (Object o: c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public default boolean isEmpty() {
		return getDelegate().isEmpty();
	}


	@Override
	public default boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public default boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	default Iterator<T> iterator() {
		return CollectionWrapper.super.iterator();
	}

	@Override
	default int size() {
		return CollectionWrapper.super.size();
	}

	@Override
	public default Object[] toArray() {
		return CollectionWrapper.super.toArray();
	}

	@Override
	public default <U> U[] toArray(U[] a) {
		return CollectionWrapper.super.toArray(a);
	}
	

}
