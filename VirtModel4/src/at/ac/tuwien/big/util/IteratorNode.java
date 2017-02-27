package at.ac.tuwien.big.util;

import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.util.MyHashMapImpl.EntryClass;

public interface IteratorNode<T,U> {
	
	public IteratorNode<T,U> getNext();
	
	public IteratorNode<T,U> getPrevious();
	
	public Entry<T, U> getEntry();
	
	/**Returns false if this element was deleted from the collection*/
	public boolean doesExist();
	
	public void setNotExisting();
	
	public MyMap<T,U> owningMap();

	public IteratorNode<T,U> getPreviousExisting();
	
	public IteratorNode<T,U> getNextExisting();

	public default T getKey() {
		return getEntry().getKey();
	}
	
	public default U getValue() {
		return getEntry().getValue();
	}

	public void remove();

}
