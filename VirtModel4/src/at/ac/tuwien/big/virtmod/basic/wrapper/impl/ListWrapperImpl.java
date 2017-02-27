package at.ac.tuwien.big.virtmod.basic.wrapper.impl;

import java.util.AbstractList;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.VList;
import at.ac.tuwien.big.virtmod.basic.wrapper.ListWrapper;

public class ListWrapperImpl<T> extends AbstractList<T> implements ListWrapper<T> {

	private VList<T> delegate;
	
	public ListWrapperImpl(VList<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public VList<T> getDelegate() {
		return delegate;
	}
	

	@Override
	public T get(int index) {
		return ListWrapper.super.get(index);
	}

	@Override
	public int size() {
		return ListWrapper.super.size();
	}


}
