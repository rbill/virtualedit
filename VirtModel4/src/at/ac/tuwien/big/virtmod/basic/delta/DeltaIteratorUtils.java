package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;


public class DeltaIteratorUtils {
	
	public static interface Filter<T> {
		public boolean matches(T entr);
	}

	public static <T extends Entry<K,V>,K,V> Iterator<T> iterator(Iterator<T> baseIter, Iterator<T> addIter, Filter<? super T> exclusion) {
		
		return new Iterator<T>() {
			private T next = null;
			Set<K> returnedKs = new HashSet<>();
			
			private void getNext() {
				while (baseIter.hasNext()) {
					T candidate = baseIter.next();
					if (!exclusion.matches(candidate)) {
						next = candidate;
						returnedKs.add(candidate.getKey());
						return;
					}
				} 
				if (next == null) {
					while (addIter.hasNext()) {
						T candidate = addIter.next();
						if (returnedKs.add(candidate.getKey())) {
							next = candidate;
							return;
						}
					}
				}
			}
	
			@Override
			public boolean hasNext() {
				if (next == null) {
					getNext();
				}
				return next != null;
			}
	
			@Override
			public T next() {
				if (hasNext()) {
					try {
						return next;
					} finally {
						next = null;
					}
				}
				throw new NoSuchElementException();
			}
		};
	}
}
