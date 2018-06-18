package at.ac.tuwien.big.vfunc.nbasic;

public class WeakObjectImpl<T> implements WeakObject<T>{
	
	private T source;
	private QueryResultCache<T, ? extends WeakObject<T>> container;

	@Override
	public T source() {
		return source;
	}

	@Override
	public QueryResultCache<T, ? extends WeakObject<T>> container() {
		return container;
	}

	@Override
	public void init(T source, QueryResultCache<T, ? extends WeakObject<T>> container) {
		this.source = source;
		this.container = container;
	}

	
	public void finalize() {
		doFinalize();
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
