package at.ac.tuwien.big.util;

import java.util.Objects;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;

public class TreeposIteratorNodeImpl<U> implements TreeposIteratorNode<U> {
	
	private TreeposIteratorNodeImpl<U> next;
	private TreeposIteratorNodeImpl<U> previous;
	private TreeposMapContent<U> map;
	private U value;
	
	public String toString() {
		return map.toString();
	}
	
	public TreeposIteratorNodeImpl(TreeposMapContent<U> content, boolean doesExist) {
		this.map = content;
		this.doesExist = doesExist;
		if (doesExist) {
			content.getMap().increaseSize();
		}
	}
	
	public TreeposIteratorNodeImpl(TreeposMapContent<U> content, U value) {
		this.map = content;
		this.value = value;
	}
	
	
	private boolean doesExist = false;
	private Entry<Treepos, U> fakeEntry = new Entry<Treepos, U>() {

		@Override
		public Treepos getKey() {
			return map.getMyPos();
		}

		@Override
		public U getValue() {
			return value;
		}

		@Override
		public U setValue(U value) {
			U ret = TreeposIteratorNodeImpl.this.value;
			TreeposIteratorNodeImpl.this.value = value;
			return ret;
		}
		
		public boolean equals(Object o) {
			return (o instanceof Entry) && Objects.equals(((Entry)o).getKey(), getKey()) && Objects.equals(((Entry)o).getValue(), getValue());  
		}
		
		public int hashCode() {
			return Objects.hashCode(getKey())^Objects.hashCode(getValue());
		}
	};
	
	public void setNext(TreeposIteratorNodeImpl<U> next) {
		if (next == this) {
			new Exception().printStackTrace();
		}
		this.next = next;
	}
	
	public void setPrevious(TreeposIteratorNodeImpl<U> previous) {
		if (previous == this) {
			new Exception().printStackTrace();
		}
		this.previous = previous;
	}

	@Override
	public TreeposIteratorNodeImpl<U> getNext() {
		return next;
	}
	
	@Override
	public TreeposIteratorNodeImpl<U> getNextExisting() {
		TreeposIteratorNodeImpl<U> ret = next;
		if (ret != null) {
			if (!ret.doesExist()) {
				next = next.getNextExisting();
				return next;
			}
		}
		return ret;
	}
	
	@Override
	public TreeposIteratorNodeImpl<U> getPreviousExisting() {
		TreeposIteratorNodeImpl<U> ret = previous;
		if (ret != null) {
			if (!ret.doesExist()) {
				previous = previous.getPreviousExisting();
				return previous;
			}
		}
		return ret;
	} 

	@Override
	public TreeposIteratorNodeImpl<U> getPrevious() {
		return previous;
	}

	@Override
	public Entry<Treepos, U> getEntry() {
		return fakeEntry;
	}

	@Override
	public boolean doesExist() {
		return doesExist;
	}

	@Override
	public void setNotExisting() {
		if (this.doesExist) {
			map.getMap().decreaseSize();
		}
		this.doesExist = false;
	}

	@Override
	public MyMap<Treepos, U> owningMap() {
		return map.getMap();
	}
	
	public U getValue() {
		return value;
	}

	public void remove() {
		if (doesExist()) {
			TreeposIteratorNodeImpl<U> next = getNext();
			TreeposIteratorNodeImpl<U> previous = getPrevious();
			if (next == null) { //Last node
				if (map.getMap().getLast() != this) {
					System.err.println("Wrong last!!");
					new Exception().printStackTrace();
				}
				map.getMap().setLast(previous);
			} else {
				next.setPrevious(previous);
			}
			if (previous == null) {
				if (map.getMap().getFirst() != this) {
					System.err.println("Wrong first!!");
					new Exception().printStackTrace();
				}
				map.getMap().setFirst(next);
			} else {
				previous.setNext(next);
			}
			setNotExisting();
		}
	}

	public void setValue(U value) {
		this.value = value;
	}

	public void setExisting() {
		if (!this.doesExist) {
			map.getMap().increaseSize();
		}
		this.doesExist = true;
	}
	
	@Override
	public void finalize() throws Throwable {
		try {
			if (doesExist) {
				System.err.println("Existing entry got out of scope!");
				map.getMap().decreaseSize();
			}
		} catch (Exception e) {
			
		} finally {
			super.finalize();
		}
	}

}
