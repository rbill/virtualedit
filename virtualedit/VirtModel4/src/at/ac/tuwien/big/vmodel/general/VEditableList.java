package at.ac.tuwien.big.vmodel.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.SourceInfo;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaEditableVList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposValue;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleDeltaVFunc;

public interface VEditableList<X,E extends EditableIntegerValueElement> extends VList<X, E>,
	VEditableAssoc<Treepos, X, E> {
	
	public ListEditState getEditState();
	

	public static<X,E extends EditableIntegerValueElement> VEditableList<X,?> ensureEditableList(VEntryIterableFunc<Treepos, ? extends VEntryIterableFunc<X,E>> func) {
		if (func instanceof VEditableList) {
			return (VEditableList)func;
		} else {
			return SimpleAbstractDelegatingVList.createListFrom(func);
		}
	}
	
	public static<X,U1 extends EditableIntegerValueElement, U2 extends EditableIntegerValueElement> VEditableList<X,?> buildEditableDeltaList(
			VContainer cont,			
			VEntryIterableFunc<Treepos,? extends VEntryIterableFunc<X,U1>> constant,
			VEntryIterableFunc<Treepos,? extends VEntryIterableFunc<X,U2>> editable) {
		return ensureEditableList(SimpleDeltaVFunc.simpleEditableViewDF(cont,constant,editable));
	}


	public default boolean insert(Treepos pos, X value) {
		boolean isNull = pos ==null;
		if (isNull) {
			System.out.println("Inserting null!!!");
		}
		return get(pos, value).setMin(1);
	}
	
	
	public default void remove(Treepos pos, X value) {
		get(pos,value).clear();
	}
	

	public default void replace(Treepos key, X value, X e) {
		if (value != e) {
			remove(key,value);
			insert(key,e);
		}
	}



	
	public default void remove(Treepos pos) {
		VEntryIterableFunc.clear(get(pos));
	}
	

	public default VEditableList<X,E> asEditableOrNull() {
		return this;
	}

	
	
	
	public default List<WrappedElementSource> getAllSources() {
		List<WrappedElementSource> ret = new ArrayList<>();
		for (Entry<Treepos,X> entry: getExistingEntries()) {
			ret.add(get(entry.getKey(),entry.getValue()).getWrappedSourceInfos());
		}
		return ret;
	}
	
	public static enum InsertMode {
		APPEND(1),PREPEND(-1);
		
		private InsertMode(int value) {
			this.value = value;
		}
		
		public final int value;
	}
	
	
	//Default from VList


	public default void addAll(Entry<? extends Treepos,? extends X> afterEntry, Entry<? extends Treepos,? extends X> beforeEntry, Collection<? extends X> c) {
		if (beforeEntry == null) {
			Treepos last = getLastPos();
			List<X> list = new ArrayList<>(c);
			Collections.reverse(list);
			for (X x: list) {
				insert(last = last.after(), x);
			}
		} else if (afterEntry == null) {
			//Initial ... this may be a manual add, so add one index so that others may insert things at the end

			Treepos last = getFirstPos();
			for (X x: c) {
				insert(last = last.before(), x);
			}
		} else  {
			List<X> list = new ArrayList<>(c);
			
			//Normal before
			//List<WrappedElementSource> allSources = getAllSources();
			
			ElementSourceInfo sourceBefore = get(afterEntry.getKey(),afterEntry.getValue()).getWrappedRelevantSourceInfos();
			ElementSourceInfo sourceAfter = get(beforeEntry.getKey(),beforeEntry.getValue()).getWrappedRelevantSourceInfos();
			if (SourceInfo.betterUserEdit(sourceBefore, sourceAfter) < 0) {
				Entry<? extends Treepos, ? extends X> addAtEntry = afterEntry;
				//Reverse only when index decreases. It is confusing, but beforeEntry is the last entry ...
				Collections.reverse(list);
				Treepos curMiddle = beforeEntry.getKey();
				for (X value: list) {
					curMiddle = curMiddle.middle(afterEntry.getKey());
					insert(curMiddle, value);
				}
			} else {
				Entry<? extends Treepos, ? extends X> addAtEntry = beforeEntry;
				Treepos curMiddle = afterEntry.getKey();
				for (X value: list) {
					curMiddle = curMiddle.middle(beforeEntry.getKey());
					insert(curMiddle, value);
				}
			}
			
		}
	}
	
	
	/**TODO: This is super-slow!
	 * @return */
	public default Treepos add(Entry<? extends Treepos,? extends X> afterEntry, Entry<? extends Treepos,? extends X> beforeEntry, X value) {
		if (beforeEntry == null) {
			Treepos last = getLastPos().after();
			insert(last, value);
			return last;
		} else if (afterEntry == null) {
			//Initial ... this may be a manual add, so add one index so that others may insert things at the end

			Treepos last = getFirstPos().before();
			insert(last, value);
			return last;
			
		} else  {
			
			//Normal before
			//List<WrappedElementSource> allSources = getAllSources();
			
			ElementSourceInfo sourceBefore = get(afterEntry.getKey(),afterEntry.getValue()).getWrappedRelevantSourceInfos();
			ElementSourceInfo sourceAfter = get(beforeEntry.getKey(),beforeEntry.getValue()).getWrappedRelevantSourceInfos();
			if (SourceInfo.betterUserEdit(sourceBefore, sourceAfter) < 0) {
				Entry<? extends Treepos, ? extends X> addAtEntry = afterEntry;
				Treepos curMiddle = beforeEntry.getKey();
				curMiddle = curMiddle.middle(afterEntry.getKey());
				insert(curMiddle, value);
				return curMiddle;
			} else {
				Entry<? extends Treepos, ? extends X> addAtEntry = beforeEntry;
				//Reverse only when index decreases
				Treepos curMiddle = afterEntry.getKey();
				curMiddle = curMiddle.middle(beforeEntry.getKey());
				insert(curMiddle, value);
				return curMiddle;
			}
			
		}
	}
	

	
	public default Treepos append(X value) {
		Treepos last = getLastPos().after();
		insert(last, value);
		return last;
	}
	

	public default Treepos positionForAppend() {
		return getLastPos().after();
	}
	
	public default Treepos superAppend(X value) {
		Treepos last = getLastPos().superAfter();
		insert(last, value);
		return last;
	}
	
	public default Treepos prepend(X value) {
		Treepos last = getFirstPos().before();
		insert(last, value);
		return last;
	}
	
	public default Treepos superPrepend(X value) {
		Treepos last = getLastPos().superBefore();
		insert(last, value);
		return last;
	}

	public default void clear() {
		for (Entry<? extends Treepos, ? extends VEntryIterableFunc<X, E>> entr: getEntries()) {
			VEntryIterableFunc.clear(entr.getValue());
		}
	}




}
