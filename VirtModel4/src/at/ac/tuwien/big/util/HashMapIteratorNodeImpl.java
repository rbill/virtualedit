package at.ac.tuwien.big.util;

import at.ac.tuwien.big.util.MyHashMapImpl.EntryClass;

public class HashMapIteratorNodeImpl<T,U> implements HashMapIteratorNode<T, U> {
	
	private HashMapIteratorNode<T,U> previous;
	private HashMapIteratorNode<T,U> next;
	private EntryClass<T,U> entry;
	private boolean doesExist = true;
	private MyHashMap<T,U> owningMap;
	
	public HashMapIteratorNodeImpl(MyHashMap<T,U> owningMap) {
		this.owningMap = owningMap;
	}
	
	public void initEntry(EntryClass<T, U> entry) {
		this.entry = entry;
	}

	@Override
	public void setNext(HashMapIteratorNode<T, U> next) {
		this.next = next;
	}

	@Override
	public void setPrevious(HashMapIteratorNode<T, U> previous) {
		this.previous = previous;
	}

	@Override
	public HashMapIteratorNode<T, U> getNext() {
		return next;
	}

	@Override
	public HashMapIteratorNode<T, U> getPrevious() {
		return previous;
	}

	@Override
	public EntryClass<T, U> getEntry() {
		return entry;
	}

	@Override
	public boolean doesExist() {
		return doesExist;
	}

	@Override
	public void setNotExisting() {
		this.doesExist = false;
	}

	@Override
	public MyHashMap<T,U> owningMap() {
		return owningMap;
	}

	@Override
	public HashMapIteratorNode<T, U> getNextExisting() {
		HashMapIteratorNode<T,U> ret = next;
		if (ret != null) {
			if (!ret.doesExist()) {
				next = ret.getNextExisting();
				return next;
			}
		}
		return ret;
	}
	
	@Override
	public HashMapIteratorNode<T, U> getPreviousExisting() {
		HashMapIteratorNode<T,U> ret = previous;
		if (ret != null) {
			if (!ret.doesExist()) {
				previous = ret.getPreviousExisting();
				return next;
			}
		}
		return ret;
	}

	@Override
	public void remove() {
		owningMap.removeNode(this);
	} 

}
