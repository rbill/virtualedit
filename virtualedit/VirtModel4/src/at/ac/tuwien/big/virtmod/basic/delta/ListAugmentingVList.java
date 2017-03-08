package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.SimpleEntry;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleListEditState;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposList;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class ListAugmentingVList<T> implements VEditableList<T> {
	
	private VEditableBag<T> base;
	private VEditableList<T> positionInfo;
	
	public ListAugmentingVList(VEditableBag<T> bag, VEditableList<T> positionInfo) {
		this.base = bag;
		this.positionInfo = positionInfo;
	}

	@Override
	public TreeposList getIndices(T forValue) {
		
		TreeposList ret = positionInfo.getIndices(forValue);

		return new TreeposList() {

			@Override
			public Iterable<? extends TreeposState> getExistingEntries() {
				ContainState targetState = base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
				ensureState(targetState);
				return ret.getExistingEntries();
			}
			
			
			private void ensureState(ContainState state) {
				if (state == ContainState.CONTAINS) {
					if (isEmpty()) {
						positionInfo.append(forValue);
					}
				} else {
					if (!isEmpty()) {
						for (TreeposState st: getExistingEntries()) {
							ret.addEdit(getEditState().advEditId(), st.treepos(), ContainState.NOT_CONTAINS);
						}
					}
				}
			}
			
			private ContainState baseState() {
				return base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
			}
			
			public Iterable<? extends TreeposState> getNotExistingEntries() {
				ContainState targetState = base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
				ensureState(targetState);
				return ret.getNotExistingEntries();
			}
			
			public Iterable<TreeposState> getAllEntries() {
				ContainState targetState = baseState();
				ensureState(targetState);
				return ()->IteratorUtils.filterType(ret.getAllEntries().iterator(), (x)->{return x.state() == targetState;});
				
			}
			
			public Iterable<? extends TreeposState> getAllStoredEntries() {
				ContainState targetState = base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
				ensureState(targetState);
				return ret.getAllStoredEntries();
			}
			
			public TreeposState getAtEditOrNull(long editId) {
				ContainState targetState = base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
				TreeposState r = ret.getAtEditOrNull(editId);
				if (r.state() == targetState) {
					return r;
				}
				return null;
			}
			
			public void addEdit(long editId, Treepos pos, ContainState state) {
				ContainState currentState = base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
				if (state != currentState) {
					base.ensure(forValue,state);
				}
				ret.addEdit(editId, pos, currentState);
				
			}
			
			private void changeBase() {
				ContainState currentState = base.contains(forValue)?ContainState.CONTAINS:ContainState.NOT_CONTAINS;
				if (isEmpty()) {
					if (currentState == ContainState.CONTAINS) {
						base.ensure(forValue, ContainState.NOT_CONTAINS);
					}
				} else {
					if (currentState == ContainState.NOT_CONTAINS) {
						base.ensure(forValue, ContainState.CONTAINS);
					}
				}
			}
			
			public boolean removeEdit(long editId) {
				boolean ret_ = ret.removeEdit(editId);
				changeBase();
				return ret_;
			}

			public boolean removeSpecificEdit(long editId, Treepos pos) {
				boolean ret_ = ret.removeSpecificEdit(editId, pos);
				changeBase();
				return ret_;
			}

			/**Clear all entries*/
			public void clear() {
				ret.clear();
			}
			
			public void clean() {
				ret.clean();
				ContainState currentState = baseState();
				if (currentState == ContainState.NOT_CONTAINS) {
					ret.clear();
				} else {
					List<TreeposState> toRemove = new ArrayList<TreeposState>();
					TreeposState last = null;
					for (TreeposState st: getAllEntries()) {
						if (st.state() != currentState) {
							toRemove.add(st);
						} else {
							if (last != null) {
								toRemove.add(last);
							}
							last = st;
						}
					}
					for (TreeposState st: toRemove) {
						remove(st.editId(), st.treepos());
					}
				}
				ensureState(currentState);
			}


			public List<? extends TreeposState> getEdits(Treepos pos) {
				ensureState(baseState());
				return ret.getEdits(pos);
			}
			
			public ContainState getState(Treepos pos) {
				ContainState base = baseState();
				if (base != ContainState.CONTAINS) {
					return base;
				}
				return ret.getState(pos);
			}
			
			public Long getLastEdit(Treepos pos) {
				ensureState(baseState());
				return ret.getLastEdit(pos);
			}

			/**Let all entries be nonexistant. Gives a different result than clear() for Delta-Lists!*/
			public void removeClear() {
				ensureState(ContainState.NOT_CONTAINS);
				base.ensure(forValue, ContainState.NOT_CONTAINS);
			}
			
			public void clearAll(Treepos pos) {
				ret.clearAll(pos);
				changeBase();
			}
				
		};
	}

	@Override
	public Iterable<Entry<T, TreeposList>> treeposForValues() {
		return ()->new Iterator<Entry<T, TreeposList>>(){
			Iterator<T> baseIter = base.iterator();

			@Override
			public boolean hasNext() {
				return baseIter.hasNext();
			}

			@Override
			public Entry<T, TreeposList> next() {
				T ret = baseIter.next();
				TreeposList retLit = getIndices(ret);
				if (retLit.isEmpty()) {
					append(ret);
				}
				return new SimpleEntry(ret, retLit);
			}
			
		};
	}

	@Override
	public boolean containsSpecific(Treepos pos, T value, long editId) {
		return getIndices(value).hasEdit(pos,editId);
	}

	@Override
	public int size() {
		return base.size();
	}

	@Override
	public boolean contains(T entry) {
		return base.contains(entry);
	}

	@Override
	public boolean addSet(T entry) {
		if (base.addSet(entry)) {
			append(entry);
			return true;
		}
		return false;
	}

	@Override
	public void removeAll(T entry) {
		base.removeAll(entry);
		positionInfo.removeAll(entry);
	}

	@Override
	public void clear() {
		base.clear();
		positionInfo.clear();
	}

	@Override
	public void clean() {
		base.clean();
		positionInfo.clean();
		
	}

	@Override
	public boolean addDefault(T value) {
		boolean ret = !contains(value);
		addList(value);
		return ret;
	}

	@Override
	public ListEditState getEditState() {
		return positionInfo.getEditState();
	}

	@Override
	public void ensure(T forValue, ContainState state) {
		base.ensure(forValue, state);
		positionInfo.ensure(forValue, state);
	}

	@Override
	public Object getSpecificSource(Treepos pos, T value, ContainState type) {
		return positionInfo.getSpecificSource(pos, value, type);
	}

	@Override
	public boolean containsSpecificEdit(Treepos pos, T value, long editId, ContainState cont) {
		ContainState state = base.getState(value);
		if (state != cont) {
			return false;
		}
		return positionInfo.containsSpecificEdit(pos, value, editId, cont);
	}

	

}
