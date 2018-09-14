package at.ac.tuwien.big.virtmod.basic.wrapper.impl;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.wrapper.EditableListWrapper;

public class BasicEditableListWrapper<T> extends AbstractList<T> implements EList<T>, BasicChangeNotifyer {
	
	private List<T> delegate;
	
	public BasicEditableListWrapper(List<T> delegate) {
		this.delegate = delegate;
	}

	public List<T> getDelegate() {
		return delegate;
	}

	@Override
	public T get(int index) {
		return delegate.get(index);
	}

	@Override
	public int size() {
		return delegate.size();
	}



	@Override
	public T remove(int arg0) {
		T ret = getDelegate().remove(arg0);
		changed();
		return ret;
	}
	
	private T removeNoChange(int arg0) {
		T ret = getDelegate().remove(arg0);
		return ret;
	}

	@Override
	public T set(int arg0, T arg1) {
		T ret = getDelegate().set(arg0, arg1);
		if (!Objects.equals(arg1, ret)) {
			changed();
		}
		return ret;
	}


	@Override
	public void add(int pos, T value) {
		getDelegate().add(pos, value);
		changed();
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
		if (newPosition == oldPosition) {
			return get(newPosition);
		}
		T val = removeNoChange(oldPosition);
		add(newPosition,val);
		return val;
	}


	private List<WeakReference<BasicListenable>> changeListeners = new ArrayList<>();
	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return changeListeners;
	}
}
