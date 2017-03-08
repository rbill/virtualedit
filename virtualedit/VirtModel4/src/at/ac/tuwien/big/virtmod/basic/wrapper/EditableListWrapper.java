package at.ac.tuwien.big.virtmod.basic.wrapper;

import java.util.AbstractList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Objects;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.VEditableList;

public interface EditableListWrapper<T> extends EditableCollectionWrapper<T>, ListWrapper<T> {
	
	

	public VEditableList<T> getDelegate();
	
	@Override
	public default boolean add(T e) {
		getDelegate().addList(e);
		return true;
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
	public default boolean remove(Object o) {
		boolean ret = contains(o);
		((VEditableList)getDelegate()).removeFirst(o);
		return ret;
	}



	@Override
	public default void add(int pos, T value) {
		getDelegate().add(pos, value);
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
		Entry<Treepos,T> entr = getDelegate().getEntry(arg0);
		getDelegate().remove(entr.getKey(), entr.getValue());
		return entr.getValue();
	}

	@Override
	public default T set(int arg0, T arg1) {
		return getDelegate().set(arg0, arg1);
	}

	@Override
	default Iterator<T> iterator() {
		return ListWrapper.super.iterator();
	}

	@Override
	default boolean removeAll(Collection<?> c) {
		return EditableCollectionWrapper.super.removeAll(c);
	}

	@Override
	default boolean containsAll(Collection<?> c) {
		return EditableCollectionWrapper.super.containsAll(c);
	}

	@Override
	default int size() {
		return ListWrapper.super.size();
	}

	@Override
	default boolean isEmpty() {
		return EditableCollectionWrapper.super.isEmpty();
	}

	@Override
	default Object[] toArray() {
		return EditableCollectionWrapper.super.toArray();
	}

	@Override
	default <U> U[] toArray(U[] a) {
		return EditableCollectionWrapper.super.toArray(a);
	}

	@Override
	default void clear() {
		EditableCollectionWrapper.super.clear();
	}

	@Override
	default boolean retainAll(Collection<?> c) {
		return EditableCollectionWrapper.super.retainAll(c);
	}

	@Override
	default boolean contains(Object o) {
		return EditableCollectionWrapper.super.contains(o);
	}

}
