package at.ac.tuwien.big.verocl;

public interface SingleParameterDesc<T extends Comparable<T>> {
	
	public SingleParameterDesc<T> union(SingleParameterDesc<T> other);
	
	public SingleParameterDesc<T> intersection(SingleParameterDesc<T> other);
	
	public SingleParameterDesc<T> without(SingleParameterDesc<T> other);
	
	public boolean isEmpty();
	
	public boolean equals(SingleParameterDesc<T> other);
	

	public int overrideHashCode();
}
