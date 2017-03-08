package at.ac.tuwien.big.virtmod.basic.wrapper.impl;

import java.util.AbstractList;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.wrapper.EditableListWrapper;

public class EditableListWrapperImpl<T> extends AbstractList<T> implements EditableListWrapper<T>, EList<T> {
	
	private VEditableList<T> delegate;
	
	public EditableListWrapperImpl(VEditableList<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public VEditableList<T> getDelegate() {
		return delegate;
	}

	@Override
	public T get(int index) {
		return EditableListWrapper.super.get(index);
	}

	@Override
	public int size() {
		return EditableListWrapper.super.size();
	}



	@Override
	public T remove(int arg0) {
		return getDelegate().remove(arg0);
	}

	@Override
	public T set(int arg0, T arg1) {
		return getDelegate().set(arg0, arg1);
	}


	@Override
	public void add(int pos, T value) {
		getDelegate().add(pos, value);
	}


	@Override
	public void move(int newPosition, T object) {
		int idx = indexOf(object);
		if (idx != -1) {
			move(newPosition,idx);
		}
	}

	@Override
	public T move(int newPosition, int oldPosition) {
		Entry<Treepos, T> entr = delegate.getEntry(oldPosition);
		delegate.remove(entr.getKey(), entr.getValue());
		if (newPosition >= size()) {
			delegate.append(entr.getValue());
		} else {
			add(newPosition,entr.getValue());
		}
		return entr.getValue();
	}
}
