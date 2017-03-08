package at.ac.tuwien.big.util;

import at.ac.tuwien.big.util.MyHashMapImpl.EntryClass;

public interface HashMapIteratorNode<T,U> extends IteratorNode<T,U> {
	
	public void setNext(HashMapIteratorNode<T,U> next);
	
	public void setPrevious(HashMapIteratorNode<T,U> previous);
	
	public HashMapIteratorNode<T,U> getNext();
	
	public HashMapIteratorNode<T,U> getPrevious();
	
	public HashMapIteratorNode<T,U> getNextExisting();
	
	public HashMapIteratorNode<T,U> getPreviousExisting();
	
	public EntryClass<T, U> getEntry();
	
	/**Returns false if this element was deleted from the collection*/
	public boolean doesExist();
	
	public void setNotExisting();
	
	public MyHashMap<T,U> owningMap();

}
