package at.ac.tuwien.big.virtmod.basic;

import java.util.Map;
import java.util.Map.Entry;

public class SimpleEntry<K,V> implements Entry<K, V> {
	
	private K key;
	private V value;
	
	public SimpleEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public static<K,V> SimpleEntry<K,V> entry(K key, V value) {
		return new SimpleEntry<K, V>(key, value);
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
		throw new RuntimeException();
	}

}
