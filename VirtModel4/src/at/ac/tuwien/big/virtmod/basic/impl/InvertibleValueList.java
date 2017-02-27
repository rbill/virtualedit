package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.VEditableInvertibleFunc;
import at.ac.tuwien.big.virtmod.basic.ValueList;
import at.ac.tuwien.big.virtmod.basic.ValueState;

public class InvertibleValueList<X,Y> implements ValueList<X>{
	
	private Y otherValue;
	private VEditableInvertibleFunc<X, Y> inverseSimpleThis;
	private ValueList<X> base;
	
	public InvertibleValueList(VEditableInvertibleFunc<X, Y> inverseSimpleThis, Y otherValue, ValueList<X> base) {
		this.otherValue = otherValue;
		this.inverseSimpleThis = inverseSimpleThis;
		this.base = base;
		
	}
	

	@Override
	public void addEdit(long editId, X value, ContainState state) {
		base.addEdit(editId, value, state);
		//Endlossschleife ...
		inverseSimpleThis.addEdit(editId, otherValue, value, state);
	}
	


	@Override
	public void clearAll(X otherValue) {
		base.clearAll(otherValue);
		inverseSimpleThis.remove(this.otherValue, otherValue);
	}

	@Override
	public boolean removeEdit(long editId) {
		for (ValueState<X> x: base.getAllEntries()) {
			inverseSimpleThis.getValues(x.value()).removeEdit(editId);
		}
		
		return base.removeEdit(editId);
	}

	@Override
	public void clear() {
		base.clear();
		for (ValueState<X> x: base.getAllEntries()) {
			inverseSimpleThis.clear(otherValue, x.value());
		}
	}

	@Override
	public void clean() {
		base.clean();
	}

	@Override
	public boolean removeSpecificEdit(long editId, X pos) {
		boolean ret = base.removeSpecificEdit(editId, pos);
		ret|= inverseSimpleThis.inverseSimple().removeSpecificEdit(pos, otherValue, editId);
		return ret;
	}

	@Override
	public void removeClear() {
		base.removeClear();
		inverseSimpleThis.inverseSimple().removeAll(otherValue);
	}


	@Override
	public Iterable<? extends ValueState<X>> getExistingEntries() {
		return base.getExistingEntries();
	}

	@Override
	public Iterable<? extends ValueState<X>> getNotExistingEntries() {
		return base.getNotExistingEntries();
	}

	@Override
	public Iterable<? extends ValueState<X>> getAllEntries() {
		return base.getAllEntries();
	}

	@Override
	public Iterable<? extends ValueState<X>> getAllStoredEntries() {
		return base.getAllStoredEntries();
	}

	@Override
	public ValueState<X> getAtEditOrNull(long editId) {
		return base.getAtEditOrNull(editId);
	}

	@Override
	public List<? extends ValueState<X>> getEdits(X pos) {
		return base.getEdits(pos);
	}

	@Override
	public ContainState getState(X pos) {
		return base.getState(pos);
	}

	@Override
	public Long getLastEdit(X pos) {
		return base.getLastEdit(pos);
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