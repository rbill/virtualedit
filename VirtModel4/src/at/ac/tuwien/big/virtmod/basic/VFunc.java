package at.ac.tuwien.big.virtmod.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public interface VFunc<T,U> extends VBag<T> {

	public ValueList<U> getValues(T key);
	

	public Iterable<? extends Entry<T, ? extends ValueList<U>>> allValues();
	
		

	
	public default Object getSpecificSource(long editId, U value, T key, ContainState type) {
		return null;
	}
	
	public Object getSpecificSource(U value, T key, ContainState type);
	

	
	public default Map<U,List<T>> reverseMap() {
		Map<U,List<T>> reverseMap = new HashMap<>();
		for (Entry<T,? extends ValueList<U>> entr: allValues()) {
			for (ValueState<U> tpentr: entr.getValue().getExistingEntries()) {
				List<T> subMap = reverseMap.get(tpentr.value());
				if (subMap == null) {
					reverseMap.put(tpentr.value(), subMap = new ArrayList<T>());
				}
				if (!subMap.contains(entr.getKey())) {
					subMap.add(entr.getKey());
				}
			}
		}	
		return reverseMap;
	}

	public default boolean containsSpecific(U pos, T value, long editId) {
		ValueList<U> vl = getValues(value);
		if (vl == null) {
			return false;
		}
		ValueState<U> state = vl.getAtEditOrNull(editId);
		if (state == null) {
			return false;
		}
		return state.state().isContains();
	}
	


	public default boolean containsEdit(U pos, T value) {
		return getValues(value).getState(pos) != null;
	}

	public default ContainState getState(U pos, T value) {
		return getValues(value).getState(pos);
	}

	public default boolean containsSpecific(U treepos, T key) {
		return getState(treepos, key) == ContainState.CONTAINS;
	}
	
	@Override
	public default ContainState getState(T entry) {
		return getValues(entry).getState();
	}
	
	public default boolean containsSpecificEdit(U pos, T value, long editId, ContainState cont) {
		ValueList<U> vl = getValues(value);
		if (vl == null) {
			return false;
		}
		ValueState<U> state = vl.getAtEditOrNull(editId);
		if (state == null) {
			return false;
		}
		return state.state().equals(cont);
	}


	
}
