package at.ac.tuwien.big.virtmod.basic.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.VList;

public interface ListWrapper<T> extends List<T>, Collection<T> {

	


	public VList<T> getDelegate();
	
	@Override
	public default boolean add(T e) {
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

	@Override
	public default void add(int pos, T value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public default boolean addAll(int arg0, Collection<? extends T> arg1) {
		boolean ret = !arg1.isEmpty();
		List<T> reverse = new ArrayList<T>(arg1);
		Collections.reverse(reverse);
		for (T t: reverse) {
			add(arg0,t);
		}
		return ret;
	}

	@Override
	public default T get(int pos) {
		return getDelegate().get(pos);
	}

	@Override
	public default int indexOf(Object arg0) {
		int ret = 0;
		for (T t: this) {
			if (Objects.equals(t, arg0)) {
				return ret;
			}
			++ret;
		}
		return -1;
	}

	@Override
	public default int lastIndexOf(Object arg0) {
		int ret = -1;
		int ind = 0;
		for (T t: this) {
			if (Objects.equals(t, arg0)) {
				ret = ind; 
			}
			++ind;
		}
		return ret;
	}


	@Override
	public default T remove(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public default T set(int arg0, T arg1) {
		throw new UnsupportedOperationException();
	}
	
}
