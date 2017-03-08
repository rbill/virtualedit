package at.ac.tuwien.big.virtmod.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.wrapper.impl.EditableSetWrapperImpl;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface ValueList<X> {

	
	public default VEditableBag<X> asBag(Editstate state) {
		return new VEditableBag<X>() {

			public Editstate getEditState() {
				return state;
			}
			
			
			public boolean addSet(X entry) {
				if (!contains(entry)) {
					add(state.advEditId(), entry);
					return true;
				}
				return false;
			}
			
			public void removeAll(X entry) {
				if (contains(entry)) {
					ValueList.this.remove(state.advEditId(), entry);
				}
			}
			
			public void clear() {
				ValueList.this.clear();
			}
			
			/**Call when you are sure nothing of your properties is floating around*/
			public void clean() {
				ValueList.this.clean();
			}
			
			public boolean addDefault(X value) {
				return addSet(value);
			}
			
			public VEditableBag<X> getBaseEditableBag() {
				return this;
			}
			
			@Override
			public boolean contains(X value) {
				return ValueList.this.getState(value) == ContainState.CONTAINS;
			}
			
			@Override
			public ContainState getState(X value) {
				return ValueList.this.getState(value);
			}
			
			public void ensure(X forValue, ContainState state) {
				if (state == ContainState.CONTAINS) {
					if (!contains(forValue)) {
						addDefault(forValue);
					}
				} else {
					if (contains(forValue)) {
						removeAll(forValue);
					}
				}
			}


			@Override
			public int size() {
				return ValueList.this.size();
			}

			@Override
			public Iterator<X> iterator() {
				return IteratorUtils.convert(ValueList.this.getExistingEntries().iterator(),(x)->{return x.value();});
			}


			@Override
			public Set<X> asCollection() {
				return new EditableSetWrapperImpl<X>(this);
			}


		};
	}
	
	public Iterable<? extends ValueState<X>> getExistingEntries();
	
	public Iterable<? extends ValueState<X>> getNotExistingEntries();
	
	public Iterable<? extends ValueState<X>> getAllEntries();
	
	public Iterable<? extends ValueState<X>> getAllStoredEntries();
	
	public ValueState<X> getAtEditOrNull(long editId);
	
	
	
	public void addEdit(long editId, X value, ContainState state);
	

	
	public boolean removeEdit(long editId);
	

	/**Clear all entries*/
	public void clear();
	
	public void clean();

	public boolean removeSpecificEdit(long editId, X pos);

	public List<? extends ValueState<X>> getEdits(X pos);
	
	public ContainState getState(X pos);
	
	public Long getLastEdit(X pos);

	/**Let all entries be nonexistant. Gives a different result than clear() for Delta-Lists!*/
	public void removeClear();
	
	public default void add(long editId, X value) {
		addEdit(editId, value, ContainState.CONTAINS);
	}
	
	public default void remove(long editId, X value) {
		addEdit(editId, value, ContainState.NOT_CONTAINS);
	}

	public void clearAll(X otherValue);

	public default ContainState getState() {
		for (ValueState<X> st: getExistingEntries()) {
			return ContainState.CONTAINS;
		}
		for (ValueState<X> st: getNotExistingEntries()) {
			return ContainState.NOT_CONTAINS;
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	public default int size() {
		int ret = 0;
		for (ValueState<X> entr: getExistingEntries()) {
			++ret;
		}
		return ret;
	}

	public default boolean isEmpty() {
		return size() == 0;
	}


	public default boolean hasEdit(X pos, long editId) {
		for (ValueState<X> st: getEdits(pos)) {
			if (st.editId() == editId) {
				return true;
			}
		}
		return false;
	}

	public default boolean hasEdit(X treepos) {
		return getState(treepos) != null;
	}

	


}
