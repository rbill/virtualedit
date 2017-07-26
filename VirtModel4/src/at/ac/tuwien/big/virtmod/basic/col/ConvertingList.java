package at.ac.tuwien.big.virtmod.basic.col;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.vmod.ecore.NoInverse;

public interface ConvertingList<E, F> extends ConvertingCollection<E, F>, EList<E>, NoInverse<EList<E>> {

	@Override 
	default Iterator<E> iterator() {
		return ConvertingCollection.super.iterator();
	}
	
	@Override
	public default <T> T[] toArray(T[] a) {
		return ConvertingCollection.super.toArray(a);
	}
	
	@Override
	public default  Object[] toArray() {
		return ConvertingCollection.super.toArray();
	}
	
	@Override
	public default boolean removeAll(Collection<?> col) {
		return ConvertingCollection.super.removeAll(col);
	}
	
	@Override
	public default boolean remove(Object c) {
		return ConvertingCollection.super.remove(c);
	}
	

	@Override
	public default boolean containsAll(Collection<?> c) {
		return ConvertingCollection.super.containsAll(c);
	}
	

	@Override
	public default int size() {
		return ConvertingCollection.super.size();
	}
	
	@Override
	public default boolean isEmpty() {
		return ConvertingCollection.super.isEmpty();
	}

	@Override
	public default void clear() {
		ConvertingCollection.super.clear();
	}
	

	@Override
	public default boolean contains(Object o) {
		return ConvertingCollection.super.contains(o);
	}
	
	@Override
	public default boolean retainAll(Collection<?> c) {
		return ConvertingCollection.super.retainAll(c);
	}
	
	
	public static class MyListIterator<E> implements ListIterator<E>{
		private int index;
		private ConvertingList<E,?> This;
		
		public MyListIterator(ConvertingList<E, ?> This, int index) {
			this.This = This;
			this.index = index;
		}

		@Override
		public void add(E e) {
			This.add(index,e);
			++index;
		}

		@Override
		public boolean hasNext() {
			return index < This.size();
		}

		@Override
		public boolean hasPrevious() {
			return index>0;
		}

		@Override
		public E next() {
			return This.get(index++);
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public E previous() {
			return This.get(--index);
		}

		@Override
		public int previousIndex() {
			return index-1;
		}

		@Override
		public void remove() {
			This.remove(index-1);
			--index;
		}

		@Override
		public void set(E e) {
			This.set(index-1, e);
		}
		
	}
	@Override
	public List<F> getDelegate();

}
 