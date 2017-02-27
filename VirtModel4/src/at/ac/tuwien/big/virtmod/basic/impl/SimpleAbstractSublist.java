package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.ValueList;
import at.ac.tuwien.big.virtmod.basic.ValueState;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public abstract class SimpleAbstractSublist<X,Y extends ValueState<X>> implements ValueList<X> {

	
	private Map<X, List<Y>> map = new HashMap<>();

	@Override
	public Iterable<Y> getAllStoredEntries() {
		return IteratorUtils.shallowUnionCol(map.values());
	}
	
	private List<Y> getOrCreate(X forPos) {
		List<Y> ret = map.get(forPos);
		if (ret == null) {
			map.put(forPos, ret = new ArrayList<Y>());
		}
		return ret;
	}

	@Override
	public void add(long editId, X pos) {
		List<Y> state = getOrCreate(pos);
		state.add(createValueState(editId,pos,ContainState.CONTAINS));
	}

	/*@Override
	public boolean removePositionEdit(X pos) {
		List<Long> removeInd = new ArrayList<>();
		for (Entry<Long,X> entr: map.entrySet()) {
			if (entr.getValue().equalXValue(pos)) {
				removeInd.add(entr.getKey());
			}
		}
		for (Long l: removeInd) {
			map.remove(l);
		}
		return !removeInd.isEmpty();
	}*/

	@Override
	public boolean removeEdit(long editId) {
		boolean ret = false;
		for (List<Y> tl: map.values()) {
			Iterator<Y> iter = tl.iterator();
			while (iter.hasNext()) {
				if (iter.next().editId() == editId) {
					iter.remove();
					ret = true;
				}
			}
		}
		return ret; 
	}

	@Override
	public void clearAll(X value) {
		List ret = map.remove(value);
	}
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Y getAtEditOrNull(long editId) {
		
		for (List<Y> tl: map.values()) {
			Iterator<Y> iter = tl.iterator();
			while (iter.hasNext()) {
				Y ret = iter.next();
				if (ret.editId() == editId) {
					return ret;
				}
			}
		}
		return null; 
	}

	@Override
	public boolean removeSpecificEdit(long editId, X pos) {
		if (pos == null) {
			return false;
		}
		List<Y> tl = map.get(pos);
		boolean ret = false;
		Iterator<Y> iter = tl.iterator();
		while (iter.hasNext()) {
			if (iter.next().editId() == editId) {
				iter.remove();
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public void removeClear() {
		clear();
	}
	
	@Override
	public Iterable<Y> getExistingEntries() {
		return ()->IteratorUtils.filterType(allEntriesIterator(), (x)->(x.state() == ContainState.CONTAINS));
	}

	@Override
	public Iterable<Y> getNotExistingEntries() {
		return ()->IteratorUtils.filterType(allEntriesIterator(), (x)->(x.state() == ContainState.NOT_CONTAINS));
	}

	private Iterator<Y> allEntriesIterator() {
		return IteratorUtils.convert(IteratorUtils.filterType(map.entrySet().iterator(),(x)->{return !x.getValue().isEmpty();}),
				(x)->x.getValue().get(x.getValue().size()-1));
	}
	
	@Override
	public Iterable<Y> getAllEntries() {
		return ()->allEntriesIterator();
	}
	
	public abstract Y createValueState(long editId, X pos, ContainState state);

	@Override
	public void addEdit(long editId, X pos, ContainState state) {
		this.getOrCreate(pos).add(createValueState(editId,pos,state));
	}

	@Override
	public void clean() {
		
	}

	@Override
	public ContainState getState(X pos) {
		Y ret = getLastState(pos);
		if (ret != null) {
			return ret.state();
		}
		return null;
	}
	
	public Y getLastState(X pos) {
		List<Y> lastState = map.get(pos);
		if (lastState == null || lastState.isEmpty()) {
			return null;
		}
		return lastState.iterator().next();
	}

	@Override
	public Long getLastEdit(X pos) {
		Y ret = getLastState(pos);
		if (ret != null) {
			return ret.editId();
		}
		return null;
	}

	@Override
	public List<Y> getEdits(X pos) {
		return getOrCreate(pos);
	}
	
	public String toString() {
		List<ValueState<X>> stored = new ArrayList<>();
		for (ValueState<X> cur: getExistingEntries()) {
			stored.add(cur);
		}
		List<ValueState<X>> notstored = new ArrayList<>();
		for (ValueState<X> cur: getNotExistingEntries()) {
			notstored.add(cur);
		}
		if (stored.isEmpty() && notstored.isEmpty()) {
			return "Empty: []";
		}
		StringBuilder ret = new StringBuilder();
		if (!stored.isEmpty()) {
			ret.append("Stored: [");
			boolean first = true;
			for (ValueState<X> cur: stored) {
				if (first) {first = false;} else {ret.append(",");}
				ret.append(String.valueOf(cur.value()));
			}
			ret.append("]");
			if (!notstored.isEmpty()) {
				ret.append(", ");
			}
		}
		if (!notstored.isEmpty()) {
			ret.append("Not Stored: [");
			boolean first = true;
			for (ValueState<X> cur: notstored) {
				if (first) {first = false;} else {ret.append(",");}
				ret.append(String.valueOf(cur.value()));
			}
			ret.append("]");			
		}
		return ret.toString();
	}
}
