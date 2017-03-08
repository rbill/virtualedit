package at.ac.tuwien.big.virtmod.basic.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;

public interface CollectionWrapper<T> extends Collection<T> {
	
	public VBag<T> getDelegate();
		

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
	public default Iterator<T> iterator() {
		return getDelegate().iterator();
	}

	@Override
	public default boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public default boolean removeAll(Collection<?> c) {
		boolean ret = false;
		for (Object o: c) {
			ret|= remove(o);
		}
		return ret;
	}

	@Override
	public default boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public default int size() {
		return getDelegate().size();
	}

	@Override
	public default Object[] toArray() {
		List<Object> ret = new ArrayList<Object>();
		for (T val: this) {
			ret.add(val);
		}
		return ret.toArray();
	}

	@Override
	public default <U> U[] toArray(U[] a) {
		List ret = new ArrayList();
		for (Object val: this) {
			ret.add(val);
		}
		return ((List<U>)ret).toArray(a);
	}
	

}
