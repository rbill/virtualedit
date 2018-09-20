package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Refreshable;

public class QueryResultCache<T, U extends WeakObject<T>> {
	
	private Map<T, WeakReference<U>> cacheMap = new HashMap<>();
	private Function<? super T, ? extends U> calculator;
	private BiConsumer<? super T, ? super U> valueUpdater;

	public QueryResultCache(Function<? super T, ? extends U> calculator, BiConsumer<? super T, ? super U> valueUpdater) {
		this.calculator = calculator;
		this.valueUpdater = valueUpdater;
	}
	
	public U create(T key) {
		U value = this.calculator.apply(key);
		if (value != null) {
			value.init(key, this);
			this.cacheMap.put(key, new WeakReference<>(value));
			if (this.valueUpdater != null) {
				this.valueUpdater.accept(key, value);
			}
		}
		return value;
	}
	
	public U get(T key) {
		WeakReference<U> ret = this.cacheMap.get(key);
		U realRet = null;
		if (ret != null) {
			realRet = ret.get();
		}
		if (realRet == null) {
			realRet = create(key);
		} 
		return realRet;
	}
	
	public U getIfExists(T key) {
		WeakReference<U> ret = this.cacheMap.get(key);
		U realRet = null;
		if (ret != null) {
			realRet = ret.get();
		}
		return realRet;
	}

	public void refreshCompletely() {
		this.cacheMap.forEach((k,v)->{
			U u = v.get();
			if (u instanceof Refreshable) {
				((Refreshable)u).refresh();
			}
		});
	}

	public void remove(T source) {
		this.cacheMap.remove(source);
	}

}
