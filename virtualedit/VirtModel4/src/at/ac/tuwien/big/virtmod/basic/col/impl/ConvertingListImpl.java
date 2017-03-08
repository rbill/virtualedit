package at.ac.tuwien.big.virtmod.basic.col.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.virtmod.basic.col.Converter;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingCollection;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingList;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingList.MyListIterator;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.NoInverse;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmodel.ecore.FakeInternalEList;

public class ConvertingListImpl<E,F> extends FakeInternalEList<E> implements ConvertingList<E, F>, InternalEList<E> {

	private Converter<E,F> toDelegate;
	private Converter<F,E> fromDelegate;
	private List<F> delegate;
	private List<E> basicList;
	
	public ConvertingListImpl(List<F> delegate, Converter<E,F> toDelegate, Converter<F,E> fromDelegate) {
		this.toDelegate = toDelegate;
		this.fromDelegate = fromDelegate;
		this.delegate = delegate;
		if (delegate instanceof InternalEList && ((InternalEList) delegate).basicList() != delegate) {			
			basicList = new ConvertingListImpl(((InternalEList) delegate).basicList(), toDelegate, fromDelegate);
		} else {
			basicList = this;
		}
	}
	
	@Override
	public List<ExactDerivationStatus> getDerivationStatus(Collection<ModelResource> userModels) {
		if (delegate instanceof NoInverse) {
			return ((NoInverse) delegate).getDerivationStatus(userModels);
		}
		return Collections.emptyList();
	}
	
	@Override
	public EList<E> noInverse() {
		List<F> delegate = getDelegate();
		if (delegate instanceof NoInverse) {
			return new ConvertingListImpl(((NoInverse<List<F>>) delegate).noInverse(),toDelegate,fromDelegate);
		}
		return this;
	}
	
	@Override
	public Converter<E, F> toDelegate() {
		return toDelegate;
	}

	@Override 
	public Converter<F, E> fromDelegate() {
		return fromDelegate;
	}

	@Override
	public List<F> getDelegate() {
		return delegate;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return ConvertingList.super.toArray(a);
	}
	
	public String toString() {
		return Arrays.toString(toArray());
	}

	@Override
	public List<E> basicList() {
		return basicList;
	}


	
	@Override
	public ListIterator<E> listIterator() {
		return new MyListIterator<E>(this,0);
	};

	@Override
	public ListIterator<E> listIterator(int index) {
		return new MyListIterator<E>(this,index);
	};

	@Override
	public void clear() {
		ConvertingList.super.clear();
	}

	@Override
	public int size() {
		return ConvertingList.super.size();
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		return ConvertingList.super.removeAll(c);
	}	
	
	@Override
	public boolean remove(Object c) {
		return ConvertingList.super.remove(c);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return ConvertingList.super.containsAll(c);
	}

	@Override
	public boolean contains(Object o) {
		return ConvertingList.super.contains(o);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return ConvertingList.super.retainAll(c);
	}


	@Override
	public boolean isEmpty() {
		return ConvertingList.super.isEmpty();
	}

	

	@Override
	public boolean add(E element) {
		return getDelegate().add(convertE(element));
	}

	@Override
	public void add(int index, E element) {
		getDelegate().add(index, convertE(element));
	}

	
	@Override
	public  boolean addAll(int index, Collection<? extends E> c) {
		List<F> newList = new ArrayList<>(c.size());
		for (E e: c) {
			newList.add(convertE(e));
		}
		return getDelegate().addAll(newList);
	}

	@Override
	public  E get(int index) {
		return convertF(getDelegate().get(index));
	}

	@Override
	public  int indexOf(Object o) {
		try {
			return getDelegate().indexOf(convertE((E)o));
		} catch (Exception e){
			return -1;
		}
	}

	@Override
	public  int lastIndexOf(Object o) {
		try {
			return getDelegate().lastIndexOf(convertE((E)o));
		} catch (Exception e){
			return -1;
		}
	}
	@Override
	public  E remove(int index) {
		return convertF(getDelegate().remove(index));
	}

	@Override
	public  E set(int index, E element) {
		return convertF(getDelegate().set(index, convertE(element)));
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> This = this;
		return new AbstractList<E>() {

			@Override
			public E get(int index) {
				if (index -fromIndex > toIndex) {
					throw new IllegalArgumentException();
				}
				return This.get(index-fromIndex);
			}
			
			@Override
			public E set(int index, E newEl) {
				return This.set(index-fromIndex, newEl);
			}
			
			@Override
			public boolean add(E newEl) {
				This.add(toIndex,newEl);
				return true;
			}
			
			@Override
			public void add(int ind, E newEl) {
				This.add(fromIndex+ind,newEl);
			}

			@Override
			public int size() {
				return toIndex-fromIndex;
			}
		};
	}
	

	@Override
	public void move(int newPosition, E object) {
		int oldPos = indexOf(object);
		if (oldPos != -1) {
			move(newPosition,oldPos);
		}
	}

	@Override
	public E move(int newPosition, int oldPosition) {
		E ret = remove(oldPosition);
		if (oldPosition < newPosition) {
			--newPosition;
		}
		add(newPosition,ret);
		return ret;
	}
	
}
