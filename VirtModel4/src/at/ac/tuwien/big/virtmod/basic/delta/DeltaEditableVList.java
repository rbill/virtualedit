package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.SourceInfo;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.VList;
import at.ac.tuwien.big.virtmod.basic.VSet;
import at.ac.tuwien.big.virtmod.basic.impl.AbstractEditableList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleListEditState;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaTreeposList;

public interface DeltaEditableVList<T> extends AbstractEditableList<T> {
	
	public VList<T> baseList();
	
	public VEditableList<T> deltaList();
	
	public default Object getSpecificSource(long editId, Treepos pos, T value, ContainState type) {
		if (deltaList().containsSpecificEdit(pos, value, editId, type)) {
			return deltaList().getSpecificSource(editId, pos, value, type);
		}
		return baseList().getSpecificSource(editId, pos, value, type);
	}

	@Override
	public default Object getSpecificSource(Treepos pos, T value, ContainState state) {
		if (deltaList().containsEdit(pos,value)) {
			return deltaList().getSpecificSource(pos, value, state);
		}
		return baseList().getSpecificSource(pos, value, state);
	}

	@Override
	public default boolean containsSpecificEdit(Treepos pos, T value, long editId, ContainState cont) {
		return deltaList().containsSpecificEdit(pos, value, editId, cont) ||
				baseList().containsSpecificEdit(pos, value, editId, cont);
	}
	

	@Override
	public default boolean contains(T entry) {
		if (deltaList().contains(entry)) {
			return true;
		}
		TreeposList tpl = baseList().getIndices(entry);
		TreeposList deleteList = deltaList().getIndices(entry);
		for (TreeposState entr: tpl.getExistingEntries()) {
			ContainState state = deleteList.getState(entr.treepos());
			if (state != ContainState.NOT_CONTAINS) {
				return true;
			}
		}
		return false;
	}

	@Override
	public default DeltaTreeposList getIndices(T forValue) {
		TreeposList base = baseList().getIndices(forValue);
		TreeposList delta = deltaList().getIndices(forValue);
		return new SimpleDeltaTreeposList(base, delta, getEditState());
	}


	@Override
	public default void removeAllAtPos(Treepos pos) {
		deltaList().removeAllAtPos(pos);
		
		for (Entry<T, TreeposList> entr: baseList().treeposForValues()) {
			ContainState state = entr.getValue().getState(pos);
			if (state == ContainState.CONTAINS) {
				deltaList().addEdit(getEditState().advEditId(), pos, entr.getKey(), ContainState.NOT_CONTAINS);
			}
		}
		
	}
	@Override
	public default Iterable<Entry<T, TreeposList>> treeposForValues() {
		
		return ()-> new Iterator<Entry<T, TreeposList>>() {
			Iterator<Entry<T, TreeposList>> baseIter = baseList().treeposForValues().iterator();

			Entry<T, TreeposList> next = null;
			
			public void getNext() {
				while (baseIter.hasNext()) {
					Entry<T, TreeposList> entry = baseIter.next();
					TreeposList list = new SimpleDeltaTreeposList(entry.getValue(), deltaList().getIndices(entry.getKey()), getEditState());
					if (list.isEmpty()) {
						continue;
					}
					next = new Entry<T, TreeposList>() {

						@Override
						public T getKey() {
							return entry.getKey();
						}

						@Override
						public TreeposList getValue() {
							return list;
						}

						@Override
						public TreeposList setValue(TreeposList arg0) {
							throw new RuntimeException("Setting a value is not supported!");
						}
					};
					break;
				}
			}
			
			@Override
			public boolean hasNext() {
				if (next == null) {
					getNext();
				}
				return next != null;
			}

			@Override
			public Entry<T, TreeposList> next() {
				if (hasNext()) {
					try {
						return next;
					} finally {
						next = null;
					}
				}
				throw new NoSuchElementException();
			}
		};
	}


	@Override
	public default boolean containsSpecific(Treepos pos, T value, long editId) {
		ContainState delta = deltaList().getState(pos,value);
		return delta != ContainState.NOT_CONTAINS && baseList().containsSpecific(pos, value, editId);
	}


	@Override
	public default void removeAll(T entry) {
		deltaList().removeAll(entry);
		TreeposList l = baseList().getIndices(entry);
		deltaList().removeAll(entry,l);
	}

	@Override
	public default void clear() {
		deltaList().clear();
	}

	@Override
	public default void clean() {
		deltaList().clean();
		for (Entry<T,TreeposList> entr: treeposForValues()) {
			TreeposList tl = entr.getValue();
			tl.clean();
		}
	}


	public default VEditableBag<T> getBaseEditableBag() {
		VBag<T> base = baseList();
		if (base instanceof VEditableBag) {
			return ((VEditableBag<T>)base).getBaseEditableBag();
		}
		return this;
	}
	
	public default VEditableList<T> getBaseEditableList() {
		VList<T> base = baseList();
		if (base instanceof VEditableList) {
			return ((VEditableList<T>)base).getBaseEditableList();
		}
		return this;
	}
	

	
	public default DeltaEditableVList<T> withBase(VList<T> base) {
		DeltaEditableVList<T> $This = this;
		return new DeltaEditableVList<T>() {
			public VList<T> baseList()  {
				return base;
			}
			
			public VEditableList<T> deltaList() {
				return $This.deltaList();
			}
			
			public ListEditState getEditState() {
				if (base instanceof VEditableList) {
					return ((VEditableList<T>) base).getEditState();
				}
				return $This.getEditState();
			}

		};
	}
	
	public default DeltaEditableVList<T> userEdit() {
		DeltaEditableVList<T> $This = this;
		if (!(baseList() instanceof VEditableList)) {
			return this;
		}
		VEditableList<T> $Base = (VEditableList<T>)baseList();
		VEditableList<T> $UserBase = (VEditableList<T>)baseList();
		VList<T> $curTest = this;
		while ($curTest instanceof DeltaEditableVList) {
			if (!SourceInfo.isGenerated($curTest.source())) {
				$UserBase = (VEditableList<T>)$curTest;
			}
			$curTest = ((DeltaEditableVList<T>)$curTest).baseList();
		}
		VEditableList<T> $UserBaseF = $UserBase;
		return new DeltaEditableVList<T>() {

			@Override
			public ListEditState getEditState() {
				return $Base.getEditState();
			}
			
			@Override
			public VList<T> baseList() {
				return $Base;
			}

			@Override
			public VEditableList<T> deltaList() {
				return $This.deltaList();
			}
			
			@Override
			public DeltaTreeposList getIndices(T forValue) {
				DeltaTreeposList ret = $This.getIndices(forValue);
				ret = ret.baseEdit($UserBaseF.getIndices(forValue));
				return ret;
			}
			
		};
	}
}
