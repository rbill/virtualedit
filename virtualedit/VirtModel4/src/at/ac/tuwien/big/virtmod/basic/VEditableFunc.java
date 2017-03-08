package at.ac.tuwien.big.virtmod.basic;

import java.util.Objects;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleAbstractFunc.FakeEntry;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
public interface VEditableFunc<T,U> extends VFunc<T, U>, VEditableBag<T> {

	
	public default void addEdit(long editId, U pos, T value, ContainState state) {
		ValueList<U> tp = getValues(value);
		tp.addEdit(editId, pos, state);	
	}
	
	public default VEditableBag<U> getValueBag(T key) {
		return getValues(key).asBag(getEditState());
	}

	
	public default void replace(long newEditId, U pos,  T newValue) {
		removeAllAtPos(pos);
		insert(newEditId, pos, newValue);
	}
	
	public default void replace(U key, T value, T arg1) {
		if (Objects.equals(value, arg1)) {
			return;
		}
		getValues(value).addEdit(getEditState().advEditId(), key, ContainState.NOT_CONTAINS);
		getValues(arg1).addEdit(getEditState().advEditId(), key, ContainState.CONTAINS);
	}


	public default void clear(U otherValue, T value) {
		ValueList<U> tp = getValues(value);
		tp.clearAll(otherValue);
	}
	

	public default void removeAll(T entry, ValueList<U> l) {
		ValueList<U> cur = getValues(entry);
		for (ValueState<U> st: l.getExistingEntries()) {
			cur.addEdit(getEditState().advEditId(), st.value(), st.state());
		}
	}
	

	public default void clearAll(T otherValue) {
		getValues(otherValue).clear();
	}
	
	
	public default void removeAll(T entry) {
		getValues(entry).removeClear();
	}
	
	public default void insert(long editId, U pos, T value) {
		addEdit(editId,pos,value,ContainState.CONTAINS);
	}
	
	public default void insertSpecific(FakeEntry<U, T> entr) {
		insert(entr.getEditId(), entr.getKey(), entr.getValue());
	}

	public default void removeAllAtPos(U pos) {
		for (Entry<T, ? extends ValueList<U>> entr: allValues()) {
			ContainState state = entr.getValue().getState(pos);
			if (state == ContainState.CONTAINS) {
				entr.getValue().addEdit(getEditState().advEditId(), pos, ContainState.NOT_CONTAINS);
			}
		}
	}
	
	public default boolean removeSpecificEdit(U pos, T value, long editId) {
		ValueList<U> tp = getValues(value);
		return tp.removeSpecificEdit(editId, pos);
	}

	public default void removeSpecific(U pos, T value, long editId) {
		ValueList<U> tp = getValues(value);
		tp.addEdit(editId, pos, ContainState.NOT_CONTAINS);
	}
	
	public default boolean removeSpecificEdit(FakeEntry<U, T> entr) {
		return removeSpecificEdit(entr.getKey(), entr.getValue(), entr.getEditId());
	}



	public default void mergeWith(T value, ValueList<U> l) {
		for (ValueState<U> entry: l.getAllEntries()) {
			addEdit(entry.editId(), entry.value(), value, entry.state());
		}
	}

	public default void mergeWith(VFunc<T,U> baseList) {
		for (Entry<T, ? extends ValueList<U>> entry: baseList.allValues()) {
			mergeWith(entry.getKey(), entry.getValue());
		}
	}

	public default void removeAllEdits(VFunc<T,U> removeList) {
		for (Entry<T, ? extends ValueList<U>> entry: removeList.allValues()) {
			
			for (ValueState<U> se: entry.getValue().getAllEntries()) {
				removeSpecificEdit(se.value(), entry.getKey(), se.editId());
			}
		}
	}

	public default void insert(U  val, T key) {
		insert(getEditState().advEditId(), val, key);
	}

	public default void remove(U value2, T key) {
		addEdit(getEditState().advEditId(), value2, key, ContainState.NOT_CONTAINS);
	}

	
}
