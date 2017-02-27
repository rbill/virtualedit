package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposValue;

public class SimpleTreeposBak implements Treepos {
	
	private Map<Integer, TreeposValue> map = new HashMap<>();
	
	
	private static Set<Treepos> allSet = new HashSet<>();
	
	
	@Override
	public Set<Entry<Integer, TreeposValue>> getEntries() {
		return map.entrySet();
	}

	@Override
	public TreeposValue getValueOrNull(Integer i) {
		return map.get(i);
	}

	@Override
	public void setValue(Integer i, TreeposValue val) {
		map.put(i, val);
	}
	
	@Override
	public int hashCode() {
		return Treepos.super.hashCodeT();
	}
	
	public static SimpleTreepos staticAugmented(Treepos from, TreeposValue newLast) {
		int newIndex = 0;
		SimpleTreepos ret = new SimpleTreepos();
		for (Entry<Integer, TreeposValue> entr: from.getEntries()) {
			ret.setValue(entr.getKey(), entr.getValue());
			newIndex = Math.max(newIndex, entr.getKey()+1);
		}
		ret.setValue(newIndex, newLast);
		if (allSet.add(ret)) {
			new Exception().printStackTrace();
			System.out.println("Introduced "+ret);
		}
		return ret;
	}
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Treepos && equalTreeposMap(((Treepos)other)));
	}

	public static SimpleTreepos ROOT() {
		SimpleTreepos ROOT = new SimpleTreepos();
		ROOT.setValue(0, new UnspecifiedTreeposValue());
		return ROOT;
	}

	
	public String toString() {
		int maxInt = -1;
		for (Integer i: map.keySet()) {
			maxInt = Math.max(i, maxInt);
		}
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i <= maxInt; ++i) {
			if (i > 0) {ret.append(",");}
			TreeposValue tv = map.get(i);
			if (tv != null) {
				ret.append(tv.value());
			} else {
				ret.append("0");
			}
		}
		return ret.toString();
	}

}