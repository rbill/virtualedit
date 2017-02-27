package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.VEditableSet;

public class SimpleVEditableVSet<T> implements VEditableSet<T> {
	
	private Map<T,Map<Long,ContainState>> contains = new HashMap<>();
	private Set<T> containsCache = new HashSet<>();
	private Set<T> noContainsCache = new HashSet<>();
	private Editstate editState = new SimpleEditState();

	@Override
	public int size() {
		return containsCache.size();
	}

	@Override
	public ContainState getState(T entry) {
		return containsCache.contains(entry)?ContainState.CONTAINS:(noContainsCache.contains(entry)?ContainState.NOT_CONTAINS:null);
	}

	@Override
	public Iterator<T> iterator() {
		return containsCache.iterator();
	}

	@Override
	public Editstate getEditState() {
		return editState;
	}

	@Override
	public boolean addSet(T entry) {
		if (containsCache.add(entry) || noContainsCache.remove(entry)) {
			addUncachedEdit(entry, ContainState.CONTAINS);
			return true;
		}
		return false;
	}
	
	private void addUncachedEdit(T entry, ContainState newState) {
		map(entry).put(getEditState().advEditId(), newState);
	}
	
	private Map<Long,ContainState> map(T forValue) {
		Map<Long,ContainState> map = contains.get(forValue);
		if (map == null) {
			contains.put(forValue, map = new HashMap<Long, ContainState>());
		}
		return map;
	}

	@Override
	public void removeAll(T entry) {
		if (containsCache.remove(entry) || noContainsCache.add(entry)) {
			addUncachedEdit(entry, ContainState.NOT_CONTAINS);
		}
		
	}

	@Override
	public void clear() {
		noContainsCache.addAll(containsCache);
		for (T val: containsCache) {
			addUncachedEdit(val, ContainState.NOT_CONTAINS);
		}
		containsCache.clear();
	}

	@Override
	public void clean() {
		noContainsCache.clear();
		contains.keySet().retainAll(containsCache);
		for (Map<Long,ContainState> map: contains.values()) {
			Long max = null;
			for (Long key: map.keySet()) {
				if (max == null || max < key) {
					max = key;
				}
			}
			map.keySet().retainAll(Collections.singleton(max));
		}
	}

	@Override
	public boolean addDefault(T value) {
		return addSet(value);
	}

	@Override
	public void ensure(T forValue, ContainState state) {
		ContainState cur = getState(forValue);
		if (cur != state) {
			if (state == ContainState.CONTAINS) {
				addSet(forValue);
			} else {
				removeAll(forValue);
			}
		}		
	}


}
 