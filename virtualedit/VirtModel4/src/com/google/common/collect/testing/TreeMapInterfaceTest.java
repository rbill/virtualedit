package com.google.common.collect.testing;

import java.util.Map;

import at.ac.tuwien.big.util.MyHashMapImpl;
import at.ac.tuwien.big.util.TreeposMapImpl;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;

public class TreeMapInterfaceTest extends MapInterfaceTest<Treepos, String> {

	public TreeMapInterfaceTest() {
		super(false,true,true,true,true);
	}

	@Override	
	protected Map<Treepos, String> makeEmptyMap() throws UnsupportedOperationException {
		return new TreeposMapImpl<String>();
	}

	@Override
	protected Map<Treepos, String> makePopulatedMap() throws UnsupportedOperationException {
		Map<Treepos,String> test = makeEmptyMap();
		test.put(new SimpleTreepos(-1,1), "kfi");
		test.put(new SimpleTreepos(-1,2), "kffdi");
		test.put(new SimpleTreepos(-1,1,-1), "cverf");
		return test;
	}

	int curInt = 10;

	@Override
	protected Treepos getKeyNotInPopulatedMap() throws UnsupportedOperationException {
		return new SimpleTreepos(curInt++);
	}

	@Override
	protected String getValueNotInPopulatedMap() throws UnsupportedOperationException {
		return String.valueOf(curInt++);
	}

}
