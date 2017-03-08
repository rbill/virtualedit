package at.ac.tuwien.big.virtmod.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.EditableListWrapperImpl;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.ListWrapperImpl;

public interface VList<T> extends VFunc<T,Treepos> {
	
	public TreeposList getIndices(T forValue);
	
	public default TreeposList getValues(T forKey) {
		return getIndices(forKey);
	}
	
	
	public static final Treepos ROOT = Treepos.ROOT();
	
	public default Treepos getRoot() {
		return ROOT;
	}
	
	
	public Iterable<Entry<T, TreeposList>> treeposForValues();
	
	@Override
	public default Iterable<Entry<T, TreeposList>> allValues() {
		return treeposForValues();
	}
	

	
	public default List<Object> getAllSources() {
		List<Object> ret = new ArrayList<Object>();
		for (Entry<Treepos,T> fe: this.sortedIterable()) {
			ret.add(getSpecificSource(fe.getKey(), fe.getValue(), ContainState.CONTAINS));
		}
		return ret;
	}

	
	public default Map<Treepos,List<T>> reverseMap() {
		Map<Treepos,List<T>> reverseMap = new TreeMap<>();
		for (Entry<T,TreeposList> entr: treeposForValues()) {
			for (TreeposState tpentr: entr.getValue().getExistingEntries()) {
				List<T> subMap = reverseMap.get(tpentr.treepos().positionNormalize());
				if (subMap == null) {
					reverseMap.put(tpentr.treepos().positionNormalize(), subMap = new ArrayList<T>());
				}
				if (!subMap.contains(entr.getKey())) {
					subMap.add(entr.getKey());
				}
			}
		}	
		return reverseMap;
	}
	
	public default Iterator<Entry<Treepos, T>> sortedIterator( Map<Treepos,List<T>> reverseMap) {
		List<Entry<Treepos,T>> list = new ArrayList<>();
		for (Entry<Treepos,List<T>> map: reverseMap.entrySet()) {
			Treepos pos = map.getKey().positionUnnormalized();
			for (T val: map.getValue()) {
				list.add(new Entry<Treepos, T>() {

					@Override
					public Treepos getKey() {
						return pos;
					}

					@Override
					public T getValue() {
						return val;
					}

					@Override
					public T setValue(T newVal) {
						if (Objects.equals(val, newVal)) {
							return val;
						}
						if (!(VList.this instanceof VEditableList)) {
							throw new RuntimeException("Read-Only-List!");
						}
						VEditableList<T> This = (VEditableList<T>)VList.this;
						TreeposList oldPos = getIndices(val);
						
						oldPos.remove(This.getEditState().advEditId(), pos);
						TreeposList newPos = getIndices(newVal);
						newPos.add(This.getEditState().advEditId(), pos);
						return val;
					}
				});
			}
		}
		Iterator<Entry<Treepos,T>> baseIter = list.iterator();
		return new Iterator<Entry<Treepos,T>>() {

			@Override
			public boolean hasNext() {
				return baseIter.hasNext();
			}
			
			Entry<Treepos,T> last;

			@Override
			public Entry<Treepos, T> next() {
				return last = baseIter.next();
			}
			
			@Override
			public void remove() {
				if (VList.this instanceof VEditableList) {
					((VEditableList<T>)VList.this).remove(last.getKey(),last.getValue());
				} else {
					throw new UnsupportedOperationException("You cannot remove anything here!");
				}
				
			}
			
		};
	}
	
	public default Iterable<Entry<Treepos, T>> sortedIterable() {
		return ()->sortedIterator();
	}
	
	public default Iterator<Entry<Treepos, T>> sortedIterator() {
		//First Treepos, then edit number, then T - if comparable
		Map<Treepos,List<T>> reverseMap = reverseMap();
		return sortedIterator(reverseMap);
	}


	/*
	public default Iterable<Entry<Long, T>> get(Treepos pos) {
		List<Entry<Long,T>> ret = new ArrayList<Map.Entry<Long,T>>();
		for (Entry<T, TreeposList> entr: treeposForValues()) {
			for (TreeposState eval: entr.getValue().getExistingEntries()) {
				Long val = eval.editId();
				ret.add(new Entry<Long, T>() {

					@Override
					public Long getKey() {
						return val;
					}

					@Override
					public T getValue() {
						return entr.getKey();
					}

					@Override
					public T setValue(T value) {
						T oldVal = getValue();
						TreeposList oldPos = getIndices(oldVal);
						oldPos.removeEdit(val);
						TreeposList newPos = getIndices(value);
						newPos.add(val, pos);
						return oldVal;
					}
				});
			}
		}
		return ret;
	}
	*/
	
	
	
	public default Treepos getLastPos() {
		Entry<Treepos,T> ret = getLastEntry();
		if (ret != null) {
			return ret.getKey();
		}
		return ROOT;
	}
	
	public default Treepos getFirstPos() {
		Entry<Treepos,T> ret = getFirstEntry();
		if (ret != null) {
			return ret.getKey();
		}
		return ROOT;
	}
	
	public default Entry<Treepos,T> getLastEntry() {
		Entry<Treepos,T> ret = null;
		Iterator<Entry<Treepos,T>> iter = sortedIterator();
		while (iter.hasNext()) {
			ret = iter.next();
		}
		return ret;
	}
	
	public default Entry<Treepos,T> getFirstEntry() {
		Entry<Treepos,T> ret = null;
		Iterator<Entry<Treepos,T>> iter = sortedIterator();
		if (iter.hasNext()) {
			ret = iter.next();
		}
		return ret;
	}
	
	
	public default Iterator<T> iterator() {
		Iterator<Entry<Treepos,T>> base = sortedIterator();
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return base.hasNext();
			}

			@Override
			public T next() {
				return base.next().getValue();
			}
		};
	}
	
	public default Entry<Treepos,T> getEntry(int index) {
		int curInd = 0;
		Iterator<Entry<Treepos,T>> iter = sortedIterator();
		while (iter.hasNext()) {
			if (curInd == index) {
				return iter.next();
			}
			iter.next();
			++curInd;
		}
		throw new IndexOutOfBoundsException("Index " +index+" is out of bounds. This list only contains "+curInd+" elements.");
	}
	
	/***This is super-slow!*/
	public default T get(int index) {
		return getEntry(index).getValue();		
	}
	
	/**This is super-slow again!*/
	public default int size() {
		int ret = 0;
		for (T val: this) {
			++ret;
		}
		return ret;
	}

	public default List<T> asCollection() {
		return new ListWrapperImpl(this);
	}


}
