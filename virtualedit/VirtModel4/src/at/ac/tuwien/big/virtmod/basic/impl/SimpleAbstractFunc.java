package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Objects;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.VEditableFunc;
import at.ac.tuwien.big.virtmod.basic.VFunc;
import at.ac.tuwien.big.virtmod.basic.ValueList;
import at.ac.tuwien.big.virtmod.basic.ValueState;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaEditableList;

public abstract class SimpleAbstractFunc<T,U,K extends ValueList<U>> implements VEditableFunc<T, U> {

	
	private Map<T, K> treeposForValue = new HashMap<>();
	
	protected Map<T,K> map() {
		return treeposForValue;
	}
	
	protected ListEditState ls = new SimpleListEditState();
	protected Object source;
	
	@Override
	public Object source() {
		return source;	
	}
	
	public void setSource(Object source) {
		this.source = source;
	}

	@Override
	public Object getSpecificSource(U pos, T value, ContainState type) {
		return source;
	}

	@Override
	public boolean containsSpecificEdit(U pos, T value, long editId, ContainState cont) {
		ValueState<U> state = getValues(value).getAtEditOrNull(editId);
		return state != null && state.editId() == editId && state.state() == cont;
	}


	public Set<Entry<T, K>> allValues() {
		return map().entrySet();
	}
	
	protected abstract K createValueList(T forValue);
	
	@Override
	public K getValues(T forValue) {
		K ret = map().get(forValue);
		if (ret == null) {
			map().put(forValue, ret = createValueList(forValue));
		}
		return ret;
	}
	
	public interface FakeEntry<K,V> extends Map.Entry<K, V> {
		public long getEditId();
	}


	public boolean containsSpecific(U pos, T value, long editId) {
		ValueList<U> list = map().get(value);
		ValueState<U> cont = list.getAtEditOrNull(editId);
		if (cont == null || pos == null) {
			return false;
		}
		return Objects.equals(cont.value(),value);
	}


	@Override
	public int size() {
		int ret = 0;
		for (K v: map().values()) {
			ret+= v.size();
		}
		return ret;
	}

	@Override
	public boolean contains(T entry) {
		K tp = map().get(entry);
		return tp == null || tp.isEmpty();
	}


	@Override
	public ContainState getState(T entry) {
		K tp = map().get(entry);
		return tp.getState();
	}
	
	@Override
	public void removeAll(T entry) {
		K cur = map().get(entry);
		if (cur != null) {
			cur.clear();
		}
	}

	@Override
	public void clear() {
		for (K tp: map().values()) {
			tp.clear();
		}
	}

	@Override
	public ListEditState getEditState() {
		return ls;
	}
	
	@Override
	public void clean() {
		Set<T> removeSet = new HashSet<>();
		for (Entry<T, K> entr: map().entrySet()) {
			if (entr.getValue().isEmpty()) {
				removeSet.add(entr.getKey());
			}
		}
		for (T t: removeSet) {
			map().remove(t);
		}
	}
	
	@Override
	public String toString() {
		return asCollection().toString();
	}
	
	
}
