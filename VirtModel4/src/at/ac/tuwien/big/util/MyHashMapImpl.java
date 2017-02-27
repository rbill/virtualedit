package at.ac.tuwien.big.util;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

import at.ac.tuwien.big.xtext.util.IteratorUtils;

import java.util.Objects;
import java.util.Set;

public class MyHashMapImpl<T,U> implements MyHashMap<T,U>, Map<T,U>, Iterable<MyHashMapImpl.EntryClass<T,U>> {
	
	private double maxFillRate = 0.3;
	private int size;
	private int realSize;
	private int maxSize = 16;
	private int capacity = (int)(maxSize*maxFillRate); 
	private EntryClass<T,U>[] entries = new EntryClass[16];
	private HashMapIteratorNode<T, U> curLast;
	private HashMapIteratorNode<T, U> curFirst;
	
	public boolean equals(Object o) {
		return Objects.equals(o,new HashMap<>(this));
	}
	
	public HashMapIteratorNode<T, U> getFirst() {
		HashMapIteratorNode<T, U> ret = curFirst;
		if (ret == null) {
			return null;
		}
		ret = curFirst.getPreviousExisting();
		if (ret != null) {
			curFirst = ret;
		} else {
			if (!curFirst.doesExist()) {
				curFirst = curFirst.getNextExisting();
			}
			ret = curFirst;
		}
		return ret;
	}
	
	
	
	public static class EntryClass<T,U> implements Entry<T, U>{
		private T key;
		private U value;
		private int hashCode;
		private boolean exists = true;
		private HashMapIteratorNode<T,U> node;
		
		public boolean equals(Object o) {
			if (o instanceof Entry) {
				Entry e = (Entry)o;
				return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
			}
			return false;
		}
		
		public int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}
		
		public String toString() {
			return String.valueOf(key)+" => "+String.valueOf(value);
		}
		
		public EntryClass(T key, U value, int hashCode, HashMapIteratorNode<T,U> node) {
			this.key = key;
			this.value = value;
			this.hashCode = hashCode;
			this.node = node;
		}
		
		public void remove() {
			this.value = null;
			this.exists = false;
			HashMapIteratorNode<T,U> prev = node.getPrevious();
			HashMapIteratorNode<T,U> next = node.getNext();
			if (next != null) {
				if (prev != null) {
					prev.setNext(next);
					next.setPrevious(prev);
				} else {
					next.setPrevious(null);
				}
			} else {
				if (prev != null) {
					prev.setNext(null);
				}
				((MyHashMapImpl<T,U>)node.owningMap()).curLast = prev;
			}
			getNode().setNotExisting();
		}
		
		public boolean exists() {
			return exists;
		}
		
		@Override
		public T getKey() {
			return key;
		}
		@Override
		public U getValue() {
			return value;
		}
		
		@Override
		public U setValue(U value) {
			U ret = this.value;
			this.value = value;
			return ret;
		}
		
		public HashMapIteratorNode<T,U> getNode() {
			return node;
		}

		public void cleared() {
			node.setNext(null);
			node.setPrevious(null);
			node.setNotExisting();
			this.exists = false;
			this.value = null;
		}		
	}
	
	public int size() {
		return realSize;
	}
	
	public void removeNode(HashMapIteratorNode<T, U> node) {
		remove(node.getKey());
	}
	
	public U remove(Object key) {
		int hashCode = Objects.hashCode(key);
		int position = mod(hashCode,maxSize);
		EntryClass<T,U> ret = entries[position];
		if (ret == null) {
			return null;
		}
		if (ret != null && entries[mod(position+1,maxSize)] == null) {
			entries[position] = null;
			U r = ret.getValue();
			ret.remove();
			--realSize;
			--size;
			return r;
		}
		
		ret = getEntry(key);		
		if (ret != null) {
			U r = ret.getValue();
			ret.remove();
			--realSize;
			return r;
		}
		return null;
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		List<EntryClass> reverseEntries = new ArrayList<>();
		HashMapIteratorNode curLast = this.curLast;
		while (curLast != null) {
			reverseEntries.add(curLast.getEntry());
			curLast = curLast.getPrevious();
		}
		Collections.reverse(reverseEntries);
		ret.append("{");
		{
			boolean first = true;
			for (EntryClass ec: reverseEntries) {
				if (first) {first = false;} else {ret.append(", ");}
				ret.append(ec.toString());
			}
		}
		ret.append("}");
		return ret.toString();
	}
	
	private static int mod(int a, int b) {
		int ret = a%b;
		if (ret < 0) {
			ret+= b;
		}
		return ret;
	}
	
	public EntryClass<T,U> getEntry(Object key) {
		int hashCode = Objects.hashCode(key);
		int position = mod(hashCode,maxSize);
		EntryClass<T,U> ret = entries[position];
		if (ret == null) {
			return null;
		}
		if (ret.hashCode == hashCode && Objects.equals(ret.key, key)) {
			return ret;
		}
		//Go further
		for (int i = position+1; i < entries.length; ++i) {
			ret = entries[i];
			if (ret == null) {
				return null;
			}
			if (ret.hashCode == hashCode && Objects.equals(ret.key, key)) {
				return ret;
			}
		}
		//Go in front
		for (int i = 0; i < position; ++i) {
			ret = entries[i];
			if (ret == null) {
				return null;
			}
			if (ret.hashCode == hashCode && Objects.equals(ret.key, key)) {
				return ret;
			}
		}
		//not found (and should not happen)
		return null;
	}
	
	public void putInArray(EntryClass[] entries, EntryClass newEntry, int pos) {
		int i = pos;
		for(;;) {
			if (entries[i] == null) {
				//System.out.println("Putting in entries["+i+"]: "+newEntry);
				entries[i] = newEntry;
				return;
			}
			if (++i >= entries.length) {
				for (i = 0; i < pos; ++i) {
					if (entries[i] == null) {
						//System.out.println("Putting in entries["+i+"]: "+newEntry);
						entries[i] = newEntry;
						return;
					}
				}
				throw new RuntimeException("HashMap is full but should not be!");
			}
		}
	}
	
	public boolean addKey(T key) {
		EntryClass<T, U> cur = getEntry(key);
		if (cur != null) {
			if (!cur.exists()) {
				cur.exists = true;
				++realSize;
				return true;
			}
			return false;
		}
		put(key,null);
		return true;
	}
	
	public U put(T key, U value) {
		int hashCode = Objects.hashCode(key);
		EntryClass<T, U> cur = getEntry(key);
		if (cur != null) {
			if (!cur.exists()) {
				cur.exists = true;
				++realSize;
			}
			return cur.setValue(value);
		}
		if (size >= capacity) {
			if (2*realSize >= size) {
				maxSize*= 2;
				capacity = (int)(maxFillRate*maxSize);
			}
			EntryClass[] newEntries = new EntryClass[maxSize];
			int newSize = 0;
			for (int i = 0; i < entries.length; ++i) {
				EntryClass entr = entries[i];
				if (entr == null || !entr.exists()) {
					continue;
				}
				++newSize;
				putInArray(newEntries,entr,mod(entr.hashCode,maxSize));
			}
			this.size = newSize;
			this.entries = newEntries;
		}
		HashMapIteratorNodeImpl<T,U> node = new HashMapIteratorNodeImpl<T,U>(this);
		if (curLast != null) {
			node.setPrevious(curLast);
			curLast.setNext(node);
		} else {
			curFirst = node;
		}
		curLast = node;
		EntryClass<T, U> newEntry = new EntryClass<>(key,value,hashCode,node);
		node.initEntry(newEntry);
		putInArray(entries,newEntry,mod(hashCode,maxSize));
		++size;
		++realSize;		
		return null;
	}
	
	
	public boolean containsKey(Object key) {
		EntryClass<T, U> entr = getEntry(key);
		return entr != null && entr.exists();
	}
	
	public U get(Object key) {
		EntryClass<T, U> ret = getEntry(key);
		if (ret != null) {
			return ret.getValue();
		}
		return null;
	}
	
	public Iterator<EntryClass<T, U>> iterator() {
		return new Iterator<EntryClass<T,U>>() {
			int curIndex = 0;
			EntryClass<T, U> next = null;
			EntryClass<T, U> last = null;

			@Override
			public boolean hasNext() {
				if (next == null) {
					while (curIndex < entries.length) {
						if (entries[curIndex] != null && entries[curIndex].exists()) {
							next = entries[curIndex];
							++curIndex;
							return true;
						}
						++curIndex;
					}
				}
				return next!=null;
			}

			@Override
			public EntryClass<T,U> next() {
				if (hasNext()) {
					try {
						return last=next;
					} finally {
						next = null;
					}
				}
				throw new NoSuchElementException();
			}
			
			@Override
			public void remove() {
				if (last != null && last.exists()) {
					last.remove();
					last = null;
					--realSize;
				} else {
					throw new IllegalStateException();
				}
			}
			
			@Override
			public int hashCode() {
				return MyHashMapImpl.this.hashCode();
			}
		};
	}
	

	@Override
	public void clear() {
		this.size = this.realSize = 0;
		this.curLast = null;
		for (int i = 0; i < this.entries.length; ++i) {
			EntryClass<T, U> entr = this.entries[i];
			if (entr != null) {
				entr.cleared();
				this.entries[i] = null;
			}
			
		}
	}
	
	@Override
	public boolean containsValue(Object value) {
		return values().contains(value);
	}

	@Override
	public Set<java.util.Map.Entry<T, U>> entrySet() {
		return ENTRY_SET;
	}

	@Override
	public boolean isEmpty() {
		return realSize==0;
	}
	
	private Set<java.util.Map.Entry<T, U>> ENTRY_SET = new Set<java.util.Map.Entry<T, U>>() {
		@Override
		public boolean add(java.util.Map.Entry<T, U> e) {
			if (true) throw new UnsupportedOperationException();
			boolean ret = !containsKey(e.getKey());
			if (ret) {
				put(e.getKey(),e.getValue());
			}
			return ret;
		}

		@Override
		public boolean addAll(Collection<? extends java.util.Map.Entry<T, U>> c) {
			if (true) throw new UnsupportedOperationException();
			boolean ret = false;
			for (java.util.Map.Entry<T, U> o: c) {
				ret|= add(o);
			}
			return ret;
		}

		@Override
		public void clear() {
			MyHashMapImpl.this.clear();
		}

		@Override
		public boolean contains(Object o) {
			if (o instanceof Entry) {
				Entry e = (Entry)o;
				EntryClass ec = getEntry(e.getKey());
				return ec != null && ec.exists() && Objects.equals(ec.getValue(), e.getValue());
			}
			return false;
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
			return MyHashMapImpl.this.isEmpty();
		}

		@Override
		public Iterator<java.util.Map.Entry<T, U>> iterator() {
			return IteratorUtils.convert(MyHashMapImpl.this.iterator(),(x)->x);
		}

		@Override
		public boolean remove(Object o) {
			if (o instanceof Entry) {
				Entry e = (Entry)o;
				EntryClass ec = getEntry(e.getKey());
				if (ec == null || !ec.exists()) {
					return false;
				}
				if (!Objects.equals(e.getValue(), ec.getValue())) {
					return false;
				}
				ec.remove();
				--realSize;
				return true;
			}
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			boolean ret = false;
			for (Object o: c) {
				ret|= remove(o);
			}
			return ret;
		}
		
		public boolean equals(Object o) {
			return new HashSet<>(this).equals(o);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			Iterator<java.util.Map.Entry<T, U>> iter = iterator();
			boolean ret = false;
			while (iter.hasNext()) {
				if (!c.contains(iter.next())) {
					ret = true;
					iter.remove();
				}
			}
			return ret;
		}

		@Override
		public int size() {
			return MyHashMapImpl.this.size();
		}

		@Override
		public Object[] toArray() {
			return toArray(new Object[]{});
		}

		@Override
		public <R> R[] toArray(R[] a) {
			
			R[] ret = a.length<size()?Arrays.copyOf(a, size()):a;
			int index = 0;
			for (Object obj: this) {
				ret[index] = (R)obj;
				++index;
			}
			while (index < ret.length) {
				ret[index] = null;
				++index;
			}
			return ret;
		}
		
		@Override
		public int hashCode() {
			return MyHashMapImpl.this.hashCode();
		}
	};
	
	private Set<T> KEY_SET = new Set<T>() {

		public boolean equals(Object o) {
			return new HashSet<>(this).equals(o);
		}

		
		@Override
		public boolean add(T e) {
			boolean ret = !containsKey(e);
			if (ret) {
				put(e,null);
			}
			return ret;
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			boolean ret = false;
			for (T o: c) {
				ret|= add(o);
			}
			return ret;
		}

		@Override
		public void clear() {
			MyHashMapImpl.this.clear();
		}

		@Override
		public boolean contains(Object o) {
			return MyHashMapImpl.this.containsKey(o);
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
			return MyHashMapImpl.this.isEmpty();
		}

		@Override
		public Iterator<T> iterator() {
			return IteratorUtils.convert(MyHashMapImpl.this.iterator(), (x)->x.getKey());
		}

		@Override
		public boolean remove(Object o) {
			boolean ret = containsKey(o);
			MyHashMapImpl.this.remove(o);
			return ret;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			boolean ret = false;
			for (Object o: c) {
				ret|= remove(o);
			}
			return ret;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			Iterator<T> iter = iterator();
			boolean ret = false;
			while (iter.hasNext()) {
				if (!c.contains(iter.next())) {
					ret = true;
					iter.remove();
				}
			}
			return ret;
		}

		@Override
		public int size() {
			return MyHashMapImpl.this.size();
		}

		@Override
		public Object[] toArray() {
			return toArray(new Object[]{});
		}

		@Override
		public <R> R[] toArray(R[] a) {
			
			R[] ret = a.length<size()?Arrays.copyOf(a, size()):a;
			int index = 0;
			for (T obj: this) {
				ret[index] = (R)obj;
				++index;
			}
			while (index < ret.length) {
				ret[index] = null;
				++index;
			}
			return ret;
		}
		
		@Override 
		public int hashCode() {
			int ret = 0;
			for (T obj: this) {
				ret += Objects.hashCode(obj);
			}
			return ret;
		}
	};

	@Override
	public Set<T> keySet() {
		return KEY_SET;
	}

	@Override
	public void putAll(Map<? extends T, ? extends U> m) {
		for (Entry<? extends T,? extends U> entr: m.entrySet()) {
			put(entr.getKey(),entr.getValue());
		}
		
	}

	@Override
	public Collection<U> values() {
		
		return new AbstractCollection<U>() {

			@Override
			public Iterator<U> iterator() {
				return IteratorUtils.convert(MyHashMapImpl.this.iterator(),(x)->x.getValue());
			}

			@Override
			public int size() {
				return realSize;
			}
		};
	}
	
	public int hashCode() {
		int ret = 0;
		for (Entry<T,U> entr: this) {
			ret+= Objects.hashCode(entr.getKey())^Objects.hashCode(entr.getValue());
		}
		return ret;
	}

	@Override
	public IteratorNode<T, U> getFirstNodeOrNull() {
		return curFirst;
	}

	@Override
	public IteratorNode<T, U> getLastNodeOrNull() {
		return curLast;
	}
}
