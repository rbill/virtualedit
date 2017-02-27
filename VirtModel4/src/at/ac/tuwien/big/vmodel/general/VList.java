package at.ac.tuwien.big.vmodel.general;

import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.impl.SimpleVListList;

public interface VList<X,E extends IntegerValueElement> extends VAssoc<Treepos, X, E> {

	/*public default X get(int idx) {
		return getEntry(idx).getValue();
	}*/
	
	public default VEditableList<X,?> asEditableOrNull() {
		return null;
	}

	
	public static final Treepos ROOT = Treepos.ROOT();
	
	public default Treepos getRoot() {
		return ROOT;
	}
	
	
	/*private*/ static WeakHashMap<VList<?,?>,List<?>> asListMap = new WeakHashMap<>();
	
	public default void synchronizeVListList() {
		asList().synchronizeList();
	}
	
	public default SimpleVListList<X> asList() {
		SimpleVListList<X> ret = (SimpleVListList)asListMap.get(this);
		if (ret == null) {
			asListMap.put(this, ret = new SimpleVListList(this));
		}
		return ret;
	}

	public default VEditableList<X,?> asEditableOrFail() {
		VEditableList<X,?> ret = asEditableOrNull();
		if (ret == null) {
			throw new UnsupportedOperationException();
		}
		return ret;
	}
	

	public default Treepos getLastPos() {
		Entry<Treepos,X> ret = getLastEntry();
		if (ret != null) {
			return ret.getKey();
		}
		return ROOT;
	}
	
	public default Treepos getFirstPos() {
		Entry<Treepos,X> ret = getFirstEntry();
		if (ret != null) {
			return ret.getKey();
		}
		return ROOT;
	}
	
	public default Entry<Treepos,X> getLastEntry() {
		Entry<Treepos,X> ret = null;
		Iterator<Entry<Treepos,X>> iter = getExistingEntries().iterator();
		while (iter.hasNext()) {
			Entry<Treepos,X> next = iter.next();
			if (ret == null || ret.getKey().compareTo(next.getKey()) <= 0) {
				ret = next;
			}
		}
		return ret;
	}
	
	public default Entry<Treepos,X> getFirstEntry() {
		Entry<Treepos,X> ret = null;
		Iterator<Entry<Treepos,X>> iter = getExistingEntries().iterator();
		while (iter.hasNext()) {
			Entry<Treepos,X> next = iter.next();
			if (ret == null || ret.getKey().compareTo(next.getKey()) > 0) {
				ret = next;
			}
		}
		return ret;
	}
	

	
	/*public default Entry<Treepos,X> getEntry(int index) {
		int curInd = 0;
		Iterator<Entry<Treepos,X>> iter = getExistingEntries().iterator();
		while (iter.hasNext()) {
			if (curInd == index) {
				return iter.next();
			}
			iter.next();
			++curInd;
		}
		throw new IndexOutOfBoundsException("Index " +index+" is out of bounds. This list only contains "+curInd+" elements.");
	}*/

	public default int size() {
		int ret = 0;
		for (Entry<Treepos,X> entr: getExistingEntries()) {
			++ret;
		}
		return ret;
	}

	public default boolean containsAny(Object o) {
		VEntryIterableFunc<?,E> func = (VEntryIterableFunc)((ParameterInvertibleFunc)parameterInvert()).get(o);
		return !VEntryIterableFunc.isEmpty(func);
	}
	

	//public VList<X,E,UF,TF> baseClone(VContainer newCont, DoubleCreater<Treepos, X, E> newCreator);
	
}
