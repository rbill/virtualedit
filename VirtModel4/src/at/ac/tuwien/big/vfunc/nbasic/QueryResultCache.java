package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class QueryResultCache<T, U extends WeakObject<T>> {
	
	private Map<T, WeakReference<U>> cacheMap = new HashMap<>();
	private Function<? super T, ? extends U> calculator;
	private BiConsumer<? super T, ? super U> valueUpdater;

	public QueryResultCache(Function<? super T, ? extends U> calculator, BiConsumer<? super T, ? super U> valueUpdater) {
		this.calculator = calculator;
		this.valueUpdater = valueUpdater;
	}
	
	public U getIfExists(T key) {
		WeakReference<U> ret = cacheMap.get(key);
		U realRet = null;
		if (ret != null) {
			realRet = ret.get();
		}
		return realRet;
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
			if (valueUpdater != null) {
				valueUpdater.accept(key, value);
			}
		}
		return value;
	}

	public void remove(T source) {
		cacheMap.remove(source);
	}

}
