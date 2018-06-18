package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;

public class BasicInfiniteScope<Src> implements Scope<Src> {
	private static final Map<Class<?>, BasicInfiniteScope<?>> isMap = new HashMap<>();
	
	public static final<Src> BasicInfiniteScope<Src> EVERYTHING(Class<Src> srcClass) {
		return (BasicInfiniteScope<Src>) isMap.computeIfAbsent(srcClass, x->new BasicInfiniteScope<Src>(y->true, (Class<Src>)x));
	}
	
	private Function<Src,Boolean> func;
	private Class<Src> clazz;
	
	public BasicInfiniteScope(Function<Src,Boolean> func, Class<Src> clazz) {
		this.func = func;
		this.clazz = clazz;
	}

	@Override
	public boolean contains(Src src) {
		Boolean ret = func.apply(src);
		return ret != null && ret;
	}
	
	@Override
	public Class<Src> getSourceClass() {
		return clazz;
	}
	
	public static List superEmptyList = new List() {

		@Override
		public int size() {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Iterator iterator() {
			return Collections.emptyListIterator();
		}

		@Override
		public Object[] toArray() {
			return new Object[]{};
		}

		@Override
		public Object[] toArray(Object[] a) {
			return Arrays.copyOf(a, 0);
		}

		@Override
		public boolean add(Object e) {
			return false;
		}

		@Override
		public boolean remove(Object o) {
			return false;
		}

		@Override
		public boolean containsAll(Collection c) {
			return c.isEmpty();
		}

		@Override
		public boolean addAll(Collection c) {
			return false;
		}

		@Override
		public boolean addAll(int index, Collection c) {
			return false;
		}

		@Override
		public boolean removeAll(Collection c) {
			return false;
		}

		@Override
		public boolean retainAll(Collection c) {
			return false;
		}

		@Override
		public void clear() {
			
		}

		@Override
		public Object get(int index) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		@Override
		public Object set(int index, Object element) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		@Override
		public void add(int index, Object element) {
			//don't do anything
		}

		@Override
		public Object remove(int index) {
			return null;
		}

		@Override
		public int indexOf(Object o) {
			return -1;
		}

		@Override
		public int lastIndexOf(Object o) {
			return -1;
		}

		@Override
		public ListIterator listIterator() {
			return Collections.emptyListIterator();
		}

		@Override
		public ListIterator listIterator(int index) {
			return Collections.emptyListIterator();
		}

		@Override
		public List subList(int fromIndex, int toIndex) {
			return this;
		}
		
	};

	@Override
	public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
		return superEmptyList;
	}
	

}
