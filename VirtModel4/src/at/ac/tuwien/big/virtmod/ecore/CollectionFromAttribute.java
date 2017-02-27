package at.ac.tuwien.big.virtmod.ecore;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionFromAttribute<T> implements Collection<T> {
		private ValueGetter<T> getter;
		private ValueSetter<T> setter;
		
		public CollectionFromAttribute(ValueGetter<T> getter, ValueSetter<T> setter) {
			this.getter = getter;
			this.setter = setter;
		}
		
		@Override
		public boolean add(T e) {
			T my = getter.get();
			if (my == null) {
				if (e != null) {
					setter.set(e);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
				//TODO: Throw exception?
			}
			
		}
		@Override
		public boolean addAll(Collection<? extends T> c) {
			boolean ret = false;
			for (T t: c) {
				ret|=add(t);
			}
			return ret;
		}
		@Override
		public void clear() {
			setter.set(null);
		}
		@Override
		public boolean contains(Object o) {
			return (o!=null&& o.equals(getter.get()));
		}
		@Override
		public boolean containsAll(Collection<?> c) {
			for (Object o: c) {
				if (!contains(o)) {
					return false;
				}
			}
			return true;
		}
		@Override
		public boolean isEmpty() {
			return getter.get() == null;
		}
		@Override
		public Iterator<T> iterator() {
			Iterator<T> ret = new Iterator<T>() {
				private boolean returned = false;

				@Override
				public boolean hasNext() {
					return !returned && getter.get() != null;
				}

				@Override
				public T next() {
					returned = true;
					return getter.get();
				}
			};
			return ret;
		}
		@Override
		public boolean remove(Object o) {
			if (getter.get() != null && getter.get().equals(o)) {
				setter.set(null);
				return true;
			}
			return false;
		}
		@Override
		public boolean removeAll(Collection<?> c) {
			boolean ret = false;
			for (Object o: c) {
				ret |= remove(o);
			}
			return ret;
		}
		@Override
		public boolean retainAll(Collection<?> c) {
			T my = getter.get();
			if (my == null) {
				return false;
			}
			for (Object o: c) {
				if (o != null && o.equals(my)) {
					return false;
				}
			}
			setter.set(null);
			return true;
		}
		@Override
		public int size() {
			return (getter.get()==null)?0:1;
		}
		@Override
		public Object[] toArray() {
			T my = getter.get();
			if (my == null) {
				return new Object[0];
			} else {
				return new Object[]{my};
			}
		}
		@Override
		public<S> S[] toArray(S[] a) {
			T my = getter.get();
			if (my != null) {
				if (a.length > 0) {
					a[0] = (S)my;
					for (int i = 1; i < a.length; ++i) {
						a[i] = null;
					}
					return a;
				} else {
					S[] ret = Arrays.copyOf(a, 1);
					ret[0] = (S)my;
					return ret;
				}
			} else {
				for (int i = 0; i < a.length; ++i) {
					a[i] = null;
				}
				return a;
			}
		}
		

		public void setTo(Collection<T> other) {
			clear();
			addAll(other);
		}
		
	}

