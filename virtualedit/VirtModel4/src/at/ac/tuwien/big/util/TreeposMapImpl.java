package at.ac.tuwien.big.util;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class TreeposMapImpl<U> implements TreeposMap<U>, Iterable<Entry<Treepos,U>> {

	TreeposIteratorNodeImpl<U> first;
	TreeposIteratorNodeImpl<U> last;
	TreeposMapContent<U> mainContent = new TreeposMapContent<>(this);
	protected int size;
	
	public synchronized void increaseSize() {
		++size;
	}
	
	public synchronized void decreaseSize() {
		--size;
	}
	
	
	@Override
	public void setFirst(TreeposIteratorNodeImpl<U> first) {
		this.first = first;
	}

	@Override
	public TreeposIteratorNodeImpl<U> getFirst() {
		return first;
	}

	@Override
	public void setLast(TreeposIteratorNodeImpl<U> last) {
		this.last = last;
	}

	@Override
	public TreeposIteratorNodeImpl<U> getLast() {
		return last;
	}
	
	@Override
	public void clear() {
		mainContent.clear();
		first = last = null;
		size = 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if (key instanceof Treepos) {
			Treepos tp = (Treepos)key;
			TreeposMapContent<U> content = mainContent.resolvePos(tp);
			return content.hasValue();
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return mainContent.hasValueOrSubHasValue(value);
	}


	@Override
	public U get(Object key) {
		if (key instanceof Treepos) {
			TreeposMapContent<U> content = mainContent.resolvePosOrNull((Treepos)key);
			if (content != null && content.hasValue()) {
				return content.getNode().getValue();
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return mainContent.isEmpty();
	}


	@Override
	public U put(Treepos key, U value) {
		//String display = String.valueOf(this);
		//System.out.println("Before put: "+display);
		try {
		TreeposMapContent<U> cont = mainContent.resolvePos(key);
		return cont.initValue(value);
		} finally {
			//System.out.println("After put: "+this);
		}
	}

	@Override
	public void putAll(Map<? extends Treepos, ? extends U> m) {
		for (java.util.Map.Entry<? extends Treepos, ? extends U> entr: m.entrySet()) {
			put(entr.getKey(), entr.getValue());
		}
		
	}

	@Override
	public U remove(Object key) {
		if (key instanceof Treepos) {
			TreeposMapContent<U> tmc = mainContent.resolvePosOrNull((Treepos)key);
			if (tmc != null) {
				U ret = tmc.getValueOrNull();
				tmc.removeNode();
				return ret;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<U> values() {
		return new AbstractCollection<U>() {

			@Override
			public Iterator<U> iterator() {
				return IteratorUtils.<Entry<Treepos,U>,U>convert(entrySet().iterator(), (x)->x.getValue());
			}

			@Override
			public int size() {
				return size;
			}
		};
	}

	public Iterator<TreeposIteratorNodeImpl<U>> iteratorNodes() {
		return new Iterator<TreeposIteratorNodeImpl<U>>() {
			
			TreeposIteratorNodeImpl<U> next = getFirst();
			TreeposIteratorNodeImpl<U> last = null;
			
			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public TreeposIteratorNodeImpl<U> next() {
				if (next != null) {
					try {
						return last=next;
					} finally {
						next = next.getNextExisting();
					}
				}
				throw new NoSuchElementException();
			}
			
			@Override 
			public void remove() {
				if (last != null) {
					last.remove();
					last = null;
					return;
				}
				throw new IllegalStateException();
			}
		};
	}
	
	public Iterator<Entry<Treepos,U>> iterator() {
		return IteratorUtils.convert(iteratorNodes(), (x)->x.getEntry());
	}

	
	private Set<java.util.Map.Entry<Treepos, U>> ENTRY_SET = new Set<java.util.Map.Entry<Treepos, U>>() {
		@Override
		public boolean add(java.util.Map.Entry<Treepos, U> e) {
			if (true) throw new UnsupportedOperationException();
			boolean ret = !containsKey(e.getKey());
			if (ret) {
				put(e.getKey(),e.getValue());
			}
			return ret;
		}

		@Override
		public boolean addAll(Collection<? extends java.util.Map.Entry<Treepos, U>> c) {
			if (true) throw new UnsupportedOperationException();
			boolean ret = false;
			for (java.util.Map.Entry<Treepos, U> o: c) {
				ret|= add(o);
			}
			return ret;
		}

		@Override
		public void clear() {
			TreeposMapImpl.this.clear();
		}

		@Override
		public boolean contains(Object o) {
			if (o instanceof Entry) {
				Entry e = (Entry)o;
				Object tpo = e.getKey();
				if (tpo instanceof Treepos) {
					TreeposMapContent<U> tmc = mainContent.resolvePos((Treepos)tpo);
					if (tmc != null && tmc.hasValue() && Objects.equals(tmc.getValueOrNull(),e.getValue())) {
						return true;
					}
				}
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
			return TreeposMapImpl.this.isEmpty();
		}

		@Override
		public Iterator<java.util.Map.Entry<Treepos, U>> iterator() {
			return IteratorUtils.convert(TreeposMapImpl.this.iterator(),(x)->x);
		}

		@Override
		public boolean remove(Object o) {
			if (o instanceof Entry) {
				Entry e = (Entry)o;
				Object tpo = e.getKey();
				if (tpo instanceof Treepos) {
					TreeposMapContent<U> tmc = mainContent.resolvePos((Treepos)tpo);
					if (tmc != null && Objects.equals(tmc.getValueOrNull(),e.getValue())) {
						tmc.removeNode();
						return true;
					}
				}
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
			Iterator<java.util.Map.Entry<Treepos, U>> iter = iterator();
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
			return TreeposMapImpl.this.size();
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
			return TreeposMapImpl.this.hashCode();
		}
	};
	
	public boolean equals(Object o) {
		return new HashMap<Treepos,U>(this).equals(o);
	}
	
	private Set<Treepos> KEY_SET = new Set<Treepos>() {

		public boolean equals(Object o) {
			return new HashSet<>(this).equals(o);
		}

		
		@Override
		public boolean add(Treepos e) {
			boolean ret = !containsKey(e);
			if (ret) {
				put(e,null);
			}
			return ret;
		}

		@Override
		public boolean addAll(Collection<? extends Treepos> c) {
			boolean ret = false;
			for (Treepos o: c) {
				ret|= add(o);
			}
			return ret;
		}

		@Override
		public void clear() {
			TreeposMapImpl.this.clear();
		}

		@Override
		public boolean contains(Object o) {
			return TreeposMapImpl.this.containsKey(o);
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
			return TreeposMapImpl.this.isEmpty();
		}

		@Override
		public Iterator<Treepos> iterator() {
			return IteratorUtils.convert(TreeposMapImpl.this.iterator(), (x)->x.getKey());
		}

		@Override
		public boolean remove(Object o) {
			boolean ret = containsKey(o);
			TreeposMapImpl.this.remove(o);
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
			Iterator<Treepos> iter = iterator();
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
			return TreeposMapImpl.this.size();
		}

		@Override
		public Object[] toArray() {
			return toArray(new Object[]{});
		}

		@Override
		public <R> R[] toArray(R[] a) {
			
			R[] ret = a.length<size()?Arrays.copyOf(a, size()):a;
			int index = 0;
			for (Treepos obj: this) {
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
			for (Treepos obj: this) {
				ret += Objects.hashCode(obj);
			}
			return ret;
		}
	};

	@Override
	public Set<Treepos> keySet() {
		return KEY_SET;
	}

	@Override
	public Set<java.util.Map.Entry<Treepos, U>> entrySet() {
		return ENTRY_SET;
	}
	
	public int hashCode() {
		int ret = 0;
		for (Entry<Treepos,U> entr: this) {
			ret+= Objects.hashCode(entr.getKey())^Objects.hashCode(entr.getValue());
		}
		return ret;
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Size "+size+": {");
		boolean first = true;
		for (Entry<Treepos,U> entr: this) {
			if (first) {first = false;} else {ret.append(", ");}
			ret.append(entr.getKey()+" => "+entr.getValue());
		}
		ret.append("}");
		return ret.toString();
	}
	
	private Comparator<? super Treepos> comparator = (x,y)->{
		return x.compareTo(y);
	};

	@Override
	public Comparator<? super Treepos> comparator() {
		return comparator;
	}

	@Override
	public Treepos firstKey() {
		TreeposIteratorNodeImpl<U> tmc = getFirst();
		return (tmc==null)?null:tmc.getEntry().getKey();
	}

	@Override
	public SortedMap<Treepos, U> headMap(Treepos arg0) {
		System.err.println("TODO: Implement me");
		new Exception().printStackTrace();
		throw new UnsupportedOperationException();
	}

	@Override
	public Treepos lastKey() {
		TreeposIteratorNodeImpl<U> tmc = getLast();
		return (tmc==null)?null:tmc.getEntry().getKey();
	}

	@Override
	public SortedMap<Treepos, U> subMap(Treepos arg0, Treepos arg1) {
		System.err.println("TODO: Implement me");
		new Exception().printStackTrace();
		throw new UnsupportedOperationException();
	}

	@Override
	public SortedMap<Treepos, U> tailMap(Treepos arg0) {
		System.err.println("TODO: Implement me");
		new Exception().printStackTrace();
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addKey(Treepos key) {
		if (containsKey(key)) {
			return false;
		}
		put(key,null);
		return true;
	}

	@Override
	public TreeposIteratorNode<U> getFirstNodeOrNull() {
		return first;
	}

	@Override
	public TreeposIteratorNode<U> getLastNodeOrNull() {
		return last;
	}
	
	public static void main(String[] args) {
		{
			TreeposMapImpl<String> test = new TreeposMapImpl<>();
			test.put(new SimpleTreepos(0,0), null);
			System.out.println(test);
			test.put(new SimpleTreepos(1,0), null);
			System.out.println(test);
			test.put(new SimpleTreepos(2,0), null);
			System.out.println(test);
			test.put(new SimpleTreepos(1,-3), null);
			System.out.println(test);
		}
		{
			TreeposMapImpl<String> test = new TreeposMapImpl<>();
			test.put(new SimpleTreepos(0,0), null);
			System.out.println(test);
			test.put(new SimpleTreepos(1,-3), null);
			System.out.println(test);
			test.put(new SimpleTreepos(1,0), null);
			System.out.println(test);
			test.put(new SimpleTreepos(2,0), null);
			System.out.println(test);
		}
		
		{
			TreeposMapImpl<String> test = new TreeposMapImpl<>();
			test.put(new SimpleTreepos(0,0), null);
			System.out.println(test);
			test.put(new SimpleTreepos(1,0), null);
			System.out.println(test);
			SimpleTreepos st = new SimpleTreepos(-1,0); 
			test.put(st, null);
			System.out.println(test);
		}
	}
}
