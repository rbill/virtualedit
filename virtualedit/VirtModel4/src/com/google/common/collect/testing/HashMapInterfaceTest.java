package com.google.common.collect.testing;

import java.util.Map;

import at.ac.tuwien.big.util.MyHashMapImpl;

public class HashMapInterfaceTest extends MapInterfaceTest<String, String> {

	public HashMapInterfaceTest() {
		super(true,true,true,true,true);
	}

	@Override	
	protected Map<String, String> makeEmptyMap() throws UnsupportedOperationException {
		return new MyHashMapImpl<>();
	}

	@Override
	protected Map<String, String> makePopulatedMap() throws UnsupportedOperationException {
		Map<String,String> test = makeEmptyMap();
		test.put("asdf", "kfi");
		test.put("df", "kffdi");
		test.put("fder", "cverf");
		return test;
	}

	int curInt = 0;

	@Override
	protected String getKeyNotInPopulatedMap() throws UnsupportedOperationException {
		return String.valueOf(curInt++);
	}

	@Override
	protected String getValueNotInPopulatedMap() throws UnsupportedOperationException {
		return String.valueOf(curInt++);
	}

}
