package at.ac.tuwien.big.virtmod.basic.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;

public interface EditableSetWrapper<T> extends SetWrapper<T>, EditableCollectionWrapper<T> {

	public VEditableBag<T> getDelegate();
	
	public default boolean add(T o) {
		return getDelegate().addSet(o);
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
		getDelegate().clear();
	}
	
	@Override
	public default boolean remove(Object o) {
		if (((VEditableBag)getDelegate()).contains(o)) {
			((VEditableBag)getDelegate()).removeAll(o);
			return true;
		}
		return false;
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
		boolean ret = false;
		for (Object o: c) {
			ret|= remove(o);
		}
		return ret;
	}

	@Override
	public default boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean ret = false;
		for (T val: getDelegate().getValues()) {
			if (contains(val) && !c.contains(val)) {
				getDelegate().removeAll(val);
				ret = true;
			}
		}
		return ret;		
	}
	
	@Override
	default Iterator<T> iterator() {
		return SetWrapper.super.iterator();
	}

	@Override
	default int size() {
		return SetWrapper.super.size();
	}

	

}
