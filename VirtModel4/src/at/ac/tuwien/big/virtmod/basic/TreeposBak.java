package at.ac.tuwien.big.virtmod.basic;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.basic.impl.UnspecifiedTreeposValue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public interface TreeposBak extends Comparable<TreeposBak> {
	
	public Iterable<Entry<Integer,TreeposValue>> getEntries();
	
	public default SortedSet<? extends Integer> getKeys() {
		SortedSet<Integer> ret = new TreeSet<Integer>();
		for (Entry<Integer,TreeposValue> entr: getEntries()) {
			ret.add(entr.getKey());
		}
		return ret;
	}
	
	public default TreeposValue getValue(Integer i) {
		TreeposValue ret = getValueOrNull(i);
		if (ret == null) {
			return UnspecifiedTreeposValue.INSTANCE;
		}
		return ret;
	}
	
	public default TreeposBak getParent() {
		SortedSet<? extends Integer> allKeys = getKeys();
		if (allKeys.isEmpty()) {
			return new SimpleTreepos();
		}
		SimpleTreepos ret = new SimpleTreepos();
		Integer lastInt = null;
		Integer prevInt = null;
		Iterator<? extends Integer> iter = allKeys.iterator();
		while (iter.hasNext()) {
			if (lastInt != null) {
				TreeposValue lastVal = getValue(lastInt);
				ret.setValue(lastInt, lastVal);
			}
			prevInt = lastInt;
			lastInt = iter.next();
		}
		if (prevInt != null) {
			for (; prevInt < lastInt-1; ++prevInt) {
				ret.setValue(prevInt, UnspecifiedTreeposValue.INSTANCE);
			}	
		}
		return ret;
	}
	

	
	
	public default int getMaximumIndex() {
		SortedSet<? extends Integer> allKeys = getKeys();
		if (allKeys.isEmpty()) {
			return -1;
		}
		return allKeys.last();
	}
	
	
	
	public TreeposValue getValueOrNull(Integer i);
	
	public void setValue(Integer i, TreeposValue val);

	public default boolean equalTreeposValue(TreeposBak other) {
		return compareTo(other) == 0;
	}
	
	/**If you want to store it in a map ... this changes hashCode and equals*/
	public default TreeposBak positionNormalize() {
		return new NormalizedPosition(this);
	}
	
	public default boolean equalTreeposMap(TreeposBak other) {
		SortedSet<Integer> myInts = new TreeSet<Integer>(getKeys());
		SortedSet<Integer> otherInts = new TreeSet<Integer>(other.getKeys());
		if (myInts.size() != otherInts.size() || !myInts.containsAll(otherInts)) {
			return false;
		}
		myInts.addAll(otherInts);
		for (Integer pos: myInts) {
			TreeposValue myval = getValue(pos);
			TreeposValue otherval = other.getValue(pos);
			int ret = myval.compareTo(otherval);
			if (ret != 0) {
				return false;
			}
		}
		return true;
	}
	
	public default int hashCodeT() {
		int ret = 0;
		for (Entry<Integer,TreeposValue> entr: getEntries()) {
			int subHash = (entr.getKey()+65)*entr.getKey()+entr.getValue().hashCodeV();
			ret+= subHash;
		}
		return ret;
	}
	
	@Override
	public default int compareTo(TreeposBak other) {
		SortedSet<Integer> allInts = new TreeSet<Integer>(getKeys());
		allInts.addAll(other.getKeys());
		for (Integer pos: allInts) {
			TreeposValue myval = getValue(pos);
			TreeposValue otherval = other.getValue(pos);
			int ret = myval.compareTo(otherval);
			if (ret != 0) {
				return ret;
			}
		}
		return 0;
	}

	public default TreeposBak merged(TreeposBak other) {
		SimpleTreepos ret = new SimpleTreepos();
		SortedSet<Integer> allInts = new TreeSet<Integer>(getKeys());
		allInts.addAll(other.getKeys());
		Iterator<Integer> iter = allInts.iterator();
		while (iter.hasNext()) {
			Integer i = iter.next();
			TreeposValue myval = getValue(i);
			TreeposValue otherval = other.getValue(i);
			if (myval.type() == TreeposType.UNSPECIFIED) {
				//Take the other one from now on
				ret.setValue(i, otherval);
				while (iter.hasNext()) {
					ret.setValue(i, other.getValue(iter.next()));	
				}
			} else {
				//Take this
				ret.setValue(i, otherval);
				if (!myval.equalsTo(otherval)) {
					//Take all from me from now on
					while (iter.hasNext()) {
						ret.setValue(i, other.getValue(iter.next()));	
					}
				}
			}
		}
		return ret;
	}

	
	public default TreeposBak positionUnnormalized() {
		return this;
	}
}
