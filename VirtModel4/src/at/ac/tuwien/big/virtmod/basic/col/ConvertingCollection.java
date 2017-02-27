package at.ac.tuwien.big.virtmod.basic.col;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface ConvertingCollection<E,F> extends Collection<E> {

	public Collection<F> getDelegate();
	
	public Converter<E,F> toDelegate();
	
	public Converter<F,E> fromDelegate();
	
	public default F convertE(E e) {
		return e==null?null:toDelegate().convert(e);
	}
	
	public default E convertF(F f) {
		return f==null?null:fromDelegate().convert(f);
	}

	@Override
	public default boolean add(E e) {
		return getDelegate().add(convertE(e));
	}

	@Override
	public default boolean addAll(Collection<? extends E> c) {
		boolean ret = false;
		for (E e: c) {
			ret|= getDelegate().add(convertE(e));
		}
		return ret;
	}

	@Override
	public default void clear() {
		getDelegate().clear();
	}

	@Override
	public default boolean contains(Object o) {
		return getDelegate().contains(convertE((E)o));
	}

	@Override
	public default boolean containsAll(Collection<?> c) {
		boolean ret = true;
		for (Object o: c) {
			ret&=contains(o);
		}
		return ret;
	}

	@Override
	public default boolean isEmpty() {
		return getDelegate().isEmpty();
	}

	@Override
	public default Iterator<E> iterator() {
		Iterator<F> baseIter = getDelegate().iterator();
		return new Iterator<E>() {
			@Override
			public boolean hasNext() {
				return baseIter.hasNext();
			}

			@Override
			public E next() {
				return convertF(baseIter.next());
			}
			
			@Override
			public void remove() {
				baseIter.remove();
			}
		};
	}

	@Override
	public default boolean remove(Object o) {
		return remove(convertE((E)o));
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
		List<F> l = new ArrayList<>(c.size());
		for (Object o: c) {
			l.add(convertE((E)c));
		}
		return getDelegate().retainAll(l);
	}

	@Override
	public default int size() {
		return getDelegate().size();
	}

	@Override
	public default Object[] toArray() {
		Object[] ret = getDelegate().toArray();
		for (int i = 0; i < ret.length; ++i) {
			ret[i] = convertF((F)ret[i]);
		}
		return ret;
	}

	@Override
	public default <T> T[] toArray(T[] a) {
		T[] ret = Arrays.copyOf(a,size());
		int idx = 0;
		for (F f: getDelegate()) {
			ret[idx++] = (T)convertF(f);
		}
		return ret;
	}
}
 