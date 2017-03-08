package at.ac.tuwien.big.virtmod.basic;

import java.awt.Insets;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.delta.DeltaEditableVList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposValue;
import at.ac.tuwien.big.virtmod.basic.impl.UnspecifiedTreeposValue;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.EditableListWrapperImpl;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.SetWrapperImpl;

public interface VEditableList<T> extends VList<T>, VEditableFunc<T,Treepos> {
	
	public ListEditState getEditState();
	
	public default Treepos insert(Treepos pos, TreeposType type, T value) {
		ListEditState state = getEditState();
		PosEditState pstate = state.getEditState(pos);
		int addValue = pstate.popIndex(type);
		Treepos newPos = SimpleTreepos.staticAugmented(pos, new SimpleTreeposValue(type,addValue));
		long editId = state.advEditId();
		insert(editId, newPos, value);
		return newPos;
	}
	

	public default boolean removeFirst(Object o) {
		for (Entry<Treepos, T> ent: (Iterable<Entry<Treepos,T>>)()->sortedIterator()) {
			if (Objects.equals(ent.getValue(), o)) {
				addEdit(getEditState().advEditId(), ent.getKey(), ent.getValue(), ContainState.NOT_CONTAINS);
				return true;
			}
		}
		return false;
	}

	public default boolean addSet(T entry) {
		if (!contains(entry)) {
			addList(entry);
			return true;
		}
		return false;
	}
	
	public default void addList(T entry) {
		append(entry);
	}

	
	/**TODO: This is super-slow!*/
	public default void add(int pos, T value) {
		if (pos == size()) {
			append(value);
		} else if (pos == 0) {
			//Initial ... this may be a manual add, so add one index so that others may insert things at the end
			prepend(value);
		} else  {
			//Normal before
			List<Object> allSources = getAllSources();
			Object sourceBefore = allSources.get(pos-1);
			Object sourceAfter = allSources.get(pos);
			if (this instanceof DeltaEditableVList) {
				DeltaEditableVList This = (DeltaEditableVList)this;
				Object mySource = This.source();
				if (mySource == null) {
					mySource = This.baseList().source();
				}
				Object baseSource = This.baseList().source();
				if (SourceInfo.betterUserEdit(sourceBefore, sourceAfter) == SourceInfo.betterUserEdit(mySource, baseSource)) {
					Entry<Treepos, T> addAtEntry = getEntry(pos-1);
					insert(addAtEntry.getKey(), TreeposType.APPEND_NEAR, value);
				} else {
					Entry<Treepos, T> addAtEntry = getEntry(pos);
					insert(addAtEntry.getKey(), TreeposType.PREPEND_NEAR, value);					
				}
			} else {
				if (SourceInfo.betterUserEdit(sourceBefore, sourceAfter) < 0) {
					Entry<Treepos, T> addAtEntry = getEntry(pos-1);
					insert(addAtEntry.getKey(), TreeposType.APPEND_NEAR, value);
				} else {
					Entry<Treepos, T> addAtEntry = getEntry(pos);
					insert(addAtEntry.getKey(), TreeposType.PREPEND_NEAR, value);
				}
			}
			
		}
	}
	
	public default void append(T value) {
		Treepos last = getLastPos();
		insert(last, TreeposType.APPEND_NEAR, value);
	}
	
	public default void superAppend(T value) {
		insert(getRoot(), TreeposType.APPEND_FAR, value);
	}
	
	public default void prepend(T value) {
		Treepos last = getFirstPos();
		insert(last, TreeposType.PREPEND_NEAR, value);
	}
	
	public default void superPrepend(T value) {
		insert(getRoot(), TreeposType.PREPEND_FAR, value);
	}



	public default EList<T> asCollection() {
		return new EditableListWrapperImpl(this);
	}

	public default boolean addDefault(T arg0) {
		addList(arg0);
		return true;
	}


	public default VEditableList<T> getBaseEditableList() {
		return this;
	}

	public default boolean containsEdit(Treepos pos, T value) {
		return getIndices(value).getState(pos) != null;
	}

	public default ContainState getState(Treepos pos, T value) {
		return getIndices(value).getState(pos);
	}

	@Override
	public default void ensure(T value, ContainState state) {
		TreeposList l = getIndices(value);
		if (l.isEmpty()) {
			if (state == ContainState.CONTAINS) {
				append(value);
			}
		} else {
			l.removeClear();
		}
	}

	public default T set(int arg0, T arg1) {
		Entry<Treepos,T> entr = getEntry(arg0);
		replace(entr.getKey(), entr.getValue(), arg1);
		return entr.getValue();
	}

	public default T remove(int arg0) {
		Entry<Treepos,T> entr = getEntry(arg0);
		remove(entr.getKey(), entr.getValue());
		return entr.getValue();
	}

	

		
}
