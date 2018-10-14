package at.ac.tuwien.big.virtmod.basic.col.impl;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.virtmod.basic.col.Converter;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingCollection;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingList;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingList.MyListIterator;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.NoInverse;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmodel.ecore.FakeInternalEList;

public class ConvertingListImpl<E,F> extends FakeInternalEList<E> implements ConvertingList<E, F>, InternalEList<E>, BasicChangeNotifyer {

	private Converter<E,F> toDelegate;
	private Converter<F,E> fromDelegate;
	private List<F> delegate;
	private List<E> basicList;
	
	private List<WeakReference<BasicListenable>> changeListeners = new ArrayList<>();
	
	
	public ConvertingListImpl(List<F> delegate, Function<E,F> toDelegate, Function<F,E> fromDelegate) {
		this.toDelegate = Converter.from(toDelegate);
		this.fromDelegate = Converter.from(fromDelegate);
		this.delegate = delegate;
		//TODO: Manchmal darf man nicht, aber muss man manchmal ?
		//Ist gar nicht so leicht zu erkennen
		if (delegate instanceof InternalEList && ((InternalEList) delegate).basicList() != delegate) {
			System.err.println("Check when necessary!");
			if (false) {
				this.basicList = new ConvertingListImpl(((InternalEList) delegate).basicList(), toDelegate, fromDelegate);
			} else {
				this.basicList = this;
			}
		} else {
			this.basicList = this;
		}
	}
	
	@Override
	public boolean add(E element) {
		boolean ret = getDelegate().add(convertE(element));
		if (ret) {
			changed();
		}
		return ret;
	}
	
	
	
	@Override
	public void add(int index, E element) {
		getDelegate().add(index, convertE(element));
		changed();
	}
	
	@Override
	public  boolean addAll(int index, Collection<? extends E> c) {
		List<F> newList = new ArrayList<>(c.size());
		for (E e: c) {
			newList.add(convertE(e));
		}
		boolean ret = getDelegate().addAll(newList);
		if (ret) {
			changed();
		}
		return ret;
	}

	@Override
	public List<E> basicList() {
		return this.basicList;
	}

	@Override
	public void clear() {
		ConvertingList.super.clear();
		changed();
	}

	@Override
	public boolean contains(Object o) {
		return ConvertingList.super.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return ConvertingList.super.containsAll(c);
	}

	@Override 
	public Converter<F, E> fromDelegate() {
		return this.fromDelegate;
	}


	@Override
	public  E get(int index) {
		return convertF(getDelegate().get(index));
	}
	
	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return this.changeListeners;
	};

	@Override
	public List<F> getDelegate() {
		return this.delegate;
	};

	@Override
	public List<ExactDerivationStatus> getDerivationStatus(Collection<ModelResource> userModels) {
		if (this.delegate instanceof NoInverse) {
			return ((NoInverse) this.delegate).getDerivationStatus(userModels);
		}
		return Collections.emptyList();
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
	public boolean isEmpty() {
		return ConvertingList.super.isEmpty();
	}	
	
	@Override 
	public Iterator<E> iterator() {
		Iterator<F> sub = this.delegate.iterator();
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				return sub.hasNext();
			}

			@Override
			public E next() {
				return convertF(sub.next());
			}
			
			@Override
			public void remove() {
				sub.remove();
				changed();
			}
		};
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
	public ListIterator<E> listIterator() {
		return new MyListIterator<>(this,0);
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		return new MyListIterator<>(this,index);
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
		if (oldPosition == newPosition) {
			return get(newPosition);
		}
		E ret = removeNoChange(oldPosition);
		if (oldPosition < newPosition) {
			--newPosition;
		}
		add(newPosition,ret);
		return ret;
	}

	@Override
	public EList<E> noInverse() {
		List<F> delegate = getDelegate();
		if (delegate instanceof NoInverse) {
			return new ConvertingListImpl(((NoInverse<List<F>>) delegate).noInverse(),this.toDelegate,this.fromDelegate);
		}
		return this;
	}

	
	@Override
	public  E remove(int index) {
		E ret = convertF(getDelegate().remove(index));
		changed();
		return ret;
	}

	@Override
	public boolean remove(Object c) {
		boolean ret = ConvertingList.super.remove(c);
		if (ret) {
			changed();
		}
		return ret;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean ret = ConvertingList.super.removeAll(c);
		if (ret) {
			changed();
		}
		return ret;
	}

	private  E removeNoChange(int index) {
		E ret = convertF(getDelegate().remove(index));
		return ret;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return ConvertingList.super.retainAll(c);
	}
	
	@Override
	public  E set(int index, E element) {
		E ret = convertF(getDelegate().set(index, convertE(element)));
		changed();
		return ret;
	}

	@Override
	public int size() {
		return ConvertingList.super.size();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> This = this;
		return new AbstractList<E>() {

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
			public int size() {
				return toIndex-fromIndex;
			}
		};
	}
	

	@Override
	public <T> T[] toArray(T[] a) {
		return ConvertingList.super.toArray(a);
	}

	@Override
	public Converter<E, F> toDelegate() {
		return this.toDelegate;
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}

}
