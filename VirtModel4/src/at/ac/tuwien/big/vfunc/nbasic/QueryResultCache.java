package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class QueryResultCache<T, U extends WeakObject<T>> {
	
	private Map<T, WeakReference<U>> cacheMap = new HashMap<>();
	private Function<T, U> calculator;

	public QueryResultCache(Function<T, U> calculator) {
		this.calculator = calculator;
	}
	
	
	public U get(T key) {
		WeakReference<U> ret = cacheMap.get(key);
		U realRet = null;
		if (ret != null) {
			realRet = ret.get();
		}
		if (realRet == null) {
			realRet = create(key);
		} 
		return realRet;
	}
	
	public U create(T key) {
		U value = calculator.apply(key);
		if (value != null) {
			value.init(key, this);
			cacheMap.put(key, new WeakReference<U>(value));
		}
		return value;
	}

	public void remove(T source) {
		cacheMap.remove(source);
	}

}
