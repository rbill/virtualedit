package at.ac.tuwien.big.virtmod.basic.wrapper;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;

public interface EditableCollectionWrapper<T> extends CollectionWrapper<T> {

	

	public VEditableBag<T> getDelegate();
	

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
	
	
}
