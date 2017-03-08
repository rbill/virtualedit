package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.NoInverse;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;

public abstract class FakeEList<T> implements EList<T>, NoInverse<FakeEList<T>> {
	
	public abstract List<T> getDelegate();

	@Override
	public List<ExactDerivationStatus> getDerivationStatus(Collection<ModelResource> userModels) {
		List<T> delegate = getDelegate();
		if (delegate instanceof NoInverse) {
			return ((NoInverse) delegate).getDerivationStatus(userModels);
		}
		return Collections.emptyList();
	}

	@Override
	public boolean add(T e) {
		return getDelegate().add(e);
	}

	@Override
	public void add(int index, T e) {
		getDelegate().add(index,e);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return getDelegate().addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return getDelegate().addAll(index,c);
	}

	@Override
	public void clear() {
		try {
			getDelegate().clear();
		} catch (UnsupportedOperationException e)  {
			System.err.println("Unsupported clear in "+getDelegate().getClass());
			while (!getDelegate().isEmpty()) {
				getDelegate().removeAll(getDelegate());
			}
		}
	}

	@Override
	public boolean contains(Object o) {
		return getDelegate().contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return getDelegate().containsAll(c);
	}

	@Override
	public T get(int index) {
		return getDelegate().get(index);
	}

	@Override
	public int indexOf(Object o) {
		return getDelegate().indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return getDelegate().isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return getDelegate().iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return getDelegate().lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return getDelegate().listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return getDelegate().listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		return getDelegate().remove(o);
	}

	@Override
	public T remove(int index) {
		return getDelegate().remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return getDelegate().removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return getDelegate().retainAll(c);
	}

	@Override
	public T set(int index, T element) {
		return getDelegate().set(index, element);
	}

	@Override
	public int size() {
		return getDelegate().size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return getDelegate().subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return getDelegate().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return getDelegate().toArray(a);
	}

	@Override
	public void move(int newPosition, T object) {
		int curIndex = indexOf(object);
		if (curIndex == -1) {
			return;
		}
		if (curIndex != newPosition) {
			remove(curIndex);
			add(newPosition,object);
		}
	}

	@Override
	public T move(int newPosition, int oldPosition) {
		T curObj = get(oldPosition);
		remove(oldPosition);
		add(newPosition,curObj);
		return curObj;
	} 

}
