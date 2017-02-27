package at.ac.tuwien.big.util;

public interface MyMap<T,U> {

	public boolean addKey(T key);
	
	public IteratorNode<T, U> getFirstNodeOrNull();

	public IteratorNode<T, ?> getLastNodeOrNull();

	public U get(Object key);
	

	public U put(T key, U ret);
}
