package at.ac.tuwien.big.util;

public interface MyHashMap<T,U> extends MyMap<T,U> {

	
	public void removeNode(HashMapIteratorNode<T, U> node);
}
