package at.ac.tuwien.big.vfunc.wrapper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Supplier;

public class BasicListWrapper<T,U> implements ListWrapper<T> {
	
	private Function<T,U> wrap;
	private Function<U,T> unwrap;
	
	private List<U> baseFunc;
	
	private List<U> baseFunc() {
		return baseFunc;
	}
	
	private Supplier<List<U>> recalcBaseFunc;
	
	private void recalc() {
		baseFunc = recalcBaseFunc.get();
	}

	@Override
	public void move(int newPosition, T object) {
		int oldPos = indexOf(object);
		if (oldPos >= 0) {
			move(newPosition, oldPos);
		}
	}

	@Override
	public T move(int newPosition, int oldPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return baseFunc.size();
	}

	@Override
	public boolean isEmpty() {
		return baseFunc.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o)>=0;
	}

	@Override
	public Iterator<T> iterator() {
		return baseFunc.stream().map(x->unwrap.apply(x)).iterator();
	}

	@Override
	public Object[] toArray() {
		return toArray(new Object[]{});
	}

	@Override
	public <T> T[] toArray(T[] a) {
		T[] ret = Arrays.copyOf(a, size());
		int index = 0;
		for (Object o: this) {
			ret[index] = (T)o;
			++index;
		}
		return ret;
	}

	@Override
	public boolean add(T e) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
