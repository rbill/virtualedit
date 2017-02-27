package at.ac.tuwien.big.virtmod.structure;

import java.util.Iterator;

public interface VList<T> extends Iterable<T>{
	
	public T get(int index);
	
	public void swap(int firstIndex, int secondIndex);
	
	public void move(int index, int toBeforeIndex);
	
	public void add(int index, T value);
	
	public int size();
	
	public default void add(T value) {
		add(size(),value);
	}
	
	public void remove(int index);
	
	@Override
	public default Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = 0;
			
			@Override
			public void remove() {
				VList.this.remove(index);
			}
			
			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public T next() {
				T ret = get(index);
				++index;
				return ret;
			}
			
		};
	}

}
