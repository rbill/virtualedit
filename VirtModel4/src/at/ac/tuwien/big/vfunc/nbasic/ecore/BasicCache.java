package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.Function;

public class BasicCache<A,B> implements Map<A,B> {
	
	private Map<A,B> map;
	private Function<A,B> calculation;
	private Class<A> cl;
	
	public static enum CacheType {
		FIX, SOFT, WEAK
	}
	
	public BasicCache(Class<A> cl, CacheType ct, Function<A, B> calculation) {
		switch(ct) {
		case FIX:
			this.map = new HashMap<>();
			break;
		case WEAK:
			this.map = new WeakHashMap<>();
			break;
		case SOFT:
			System.err.println("Soft hash maps not implemented yet");
			this.map = new WeakHashMap<>();
			break;
		}
		this.cl = cl;
		this.calculation = calculation;
	}	

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public B get(Object key) {
		if (key == null || cl.isInstance(key)) {
			return map.computeIfAbsent((A)key, calculation);
		}
		return null;
	}

	@Override
	public B put(A key, B value) {
		return map.put(key, value);
	}

	@Override
	public B remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends A, ? extends B> m) {
		map.putAll(m);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<A> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<B> values() {
		return map.values();
	}

	@Override
	public Set<java.util.Map.Entry<A, B>> entrySet() {
		return map.entrySet();
	}

}
