package at.ac.tuwien.big.vfunc.nbasic;

public interface WeakObject<T> {
	
	public T source();
	
	public QueryResultCache<T, ? extends WeakObject<T>> container();
	
	public void init(T source, QueryResultCache<T, ? extends WeakObject<T>> container);
	
	/**Always call me before finalizing!*/
	public default void doFinalize() {
		container().remove(source());
	}

}
