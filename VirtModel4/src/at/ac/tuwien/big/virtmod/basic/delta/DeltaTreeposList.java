package at.ac.tuwien.big.virtmod.basic.delta;

import java.awt.Component.BaselineResizeBehavior;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface DeltaTreeposList extends TreeposList {
	
	
	public TreeposList baseList();
	
	public TreeposList deltaList();
	
	public Editstate editState();

	@Override
	public default Iterable<TreeposState> getExistingEntries() {
		return IteratorUtils.shallowUnion(deltaList().getExistingEntries(),()->{return IteratorUtils.filterType(baseList().getExistingEntries().iterator(),
				(x)->{return !deltaList().hasEdit(x.treepos());});});
	}

	@Override
	public default Iterable<TreeposState> getNotExistingEntries() {
		return IteratorUtils.shallowUnion(deltaList().getNotExistingEntries(),()->{return IteratorUtils.filterType(baseList().getNotExistingEntries().iterator(),
				(x)->{return !deltaList().hasEdit(x.treepos());});});
	}

	@Override
	public default Iterable<TreeposState> getAllEntries() {
		return IteratorUtils.shallowUnion(deltaList().getAllEntries(),()->{return IteratorUtils.filterType(baseList().getAllEntries().iterator(),
				(x)->{return !deltaList().hasEdit(x.treepos());});});
	}

	@Override
	public default Iterable<TreeposState> getAllStoredEntries() {
		return IteratorUtils.shallowUnion(deltaList().getAllStoredEntries(),()->{return IteratorUtils.filterType(baseList().getAllStoredEntries().iterator(),
				(x)->{return !deltaList().hasEdit(x.treepos());});});
	}
	

	@Override
	public default TreeposState getAtEditOrNull(long editId) {
		TreeposState state = deltaList().getAtEditOrNull(editId);
		if (state != null) {
			return state;
		}
		return baseList().getAtEditOrNull(editId);
	}

	@Override
	public default void addEdit(long editId, Treepos pos, ContainState state) {
		deltaList().addEdit(editId, pos, state);		
	}

	@Override
	public default boolean removeEdit(long editId) {
		return deltaList().removeEdit(editId);
	}

	@Override
	public default void clear() {
		deltaList().clear();
	}

	@Override
	public default void clean() {
		// TODO Auto-generated method stub
		deltaList().clean();
		List<TreeposState> toRemove = new ArrayList<>();
		for (TreeposState st: getNotExistingEntries()) {
			if (!baseList().hasEdit(st.treepos())) {
				toRemove.add(st);
			}
		}
		for (TreeposState st: toRemove) {
			deltaList().removeSpecificEdit(st.editId(), st.treepos());
		}
	}

	@Override
	public default boolean removeSpecificEdit(long editId, Treepos pos) {
		return deltaList().removeSpecificEdit(editId, pos);
	}

	@Override
	public default List<? extends TreeposState> getEdits(Treepos pos) {
		List<? extends TreeposState> ret = deltaList().getEdits(pos);
		if (ret == null || ret.isEmpty()) {
			return baseList().getEdits(pos);
		}
		return ret;
	}

	@Override
	public default ContainState getState(Treepos pos) {
		ContainState ret = deltaList().getState(pos);
		ContainState baseState = baseList().getState(pos);
		if (ret == null) {
			ret = baseState;
		} else {
			if (baseState != null) {
				ret = ret.mergeWith(baseState);
			}
		}
		return ret;
	}

	@Override
	public default Long getLastEdit(Treepos pos) {
		Long ret = deltaList().getLastEdit(pos);
		if (ret == null) {
			ret = baseList().getLastEdit(pos);
		}
		return ret;
	}

	@Override
	public default void removeClear() {
		deltaList().removeClear();
		// TODO Auto-generated method stub
		for (TreeposState state: baseList().getExistingEntries()) {
			deltaList().addEdit(editState().advEditId(), state.treepos(), state.state().inverse());
		}
		
	}

	public default DeltaTreeposList baseEdit(TreeposList superBase) {
		DeltaTreeposList $This = this;
		return new DeltaTreeposList() {

			
			public TreeposList baseList() {
				return $This.baseList();
			}
			
			public TreeposList deltaList() {
				return $This.deltaList();
			}
			
			public Editstate editState() {
				return $This.editState();
			}
			

			@Override
			public void addEdit(long editId, Treepos pos, ContainState state) {
				superBase.addEdit(editId, pos, state);		
			}

			@Override
			public boolean removeEdit(long editId) {
				return superBase.removeEdit(editId);
			}


			@Override
			public boolean removeSpecificEdit(long editId, Treepos pos) {
				return superBase.removeSpecificEdit(editId, pos);
			}


			@Override
			public void removeClear() {
				superBase.removeClear();				
			}
			

			@Override
			public void clear() {
				superBase.clear();
			}

			@Override
			public void clean() {
				// TODO Auto-generated method stub
				superBase.clean();
			}
			
			public DeltaTreeposList baseEdit() {
				return this;
			}

			@Override
			public void clearAll(Treepos otherValue) {
				superBase.clearAll(otherValue);				
			}
			
		};
	}
	
	/*
	@Override
	public default default Iterable<Entry<Long, Treepos>> getEntries() {
		Iterator<Entry<Long, Treepos>> baseIter = baseList().getEntries().iterator();
		Iterator<Entry<Long, Treepos>> addIter = addList().getEntries().iterator();
		return ()->DeltaIteratorUtils.iterator(baseIter, addIter, (candidate)->deleteList().getAtEditOrNull(candidate.getKey()) != null);
	}
	
	
	@Override
	public default default void add(long editId, Treepos pos) {
		deleteList().removeSpecificEdit(editId,pos);
		addList().add(editId, pos);
	}
	
	@Override
	public default default boolean removePosition(Treepos pos) {
		boolean ret = addList().removePosition(pos);
		List<Long> edits = baseList().getEdits(pos);
		for (Long l: edits) {
			deleteList().add(l, pos);
			ret = true;
		}
		return ret;
	}
	@Override
	public default default boolean removeEdit(long editId) {
		boolean ret = addList().removeEdit(editId);
		Treepos cur = baseList().getAtEditOrNull(editId);
		if (cur != null) {
			deleteList().add(editId, cur);
			return true;
		}
		return ret;
	}
	
	
	@Override
	public default default void clear() {
		List<Long> toDelete = new ArrayList<>();
		for (Entry<Long,Treepos> entr: getEntries()) {
			toDelete.add(entr.getKey());
		}
		for (Long l: toDelete) {
			removeEdit(l);
		}
	}
	
	@Override
	public default default boolean removeSpecificEdit(long editId, Treepos pos) {
		boolean ret = addList().removeSpecificEdit(editId, pos);
		Treepos cur = baseList().getAtEditOrNull(editId);
		if (cur != null && cur.equalTreeposValue(pos)) {
			deleteList().add(editId, pos);
			ret = true;
		}
		return ret;
	}
	


	
*/


}
