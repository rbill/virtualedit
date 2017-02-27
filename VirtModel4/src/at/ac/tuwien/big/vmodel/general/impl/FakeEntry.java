package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map;

public class FakeEntry<K,V> implements Map.Entry<K,V> {
	
	private K key;
	private V value;
	
	public FakeEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V ret = this.value;
		this.value = value;
		return ret;
		//throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(key)+" -> "+String.valueOf(value);
	}

}
