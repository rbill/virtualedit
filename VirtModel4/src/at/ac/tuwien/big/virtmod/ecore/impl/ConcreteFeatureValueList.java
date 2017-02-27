package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.SimpleEntry;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.TreeposValue;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.VList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleListEditState;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposList;

public class ConcreteFeatureValueList<T> implements VEditableList<T> {
	
	private ListEditState ls = new SimpleListEditState();
	
	public ListEditState getEditState() {
		System.err.println("This should not be called, this list is supposed to be unmodified!");
		new Exception().printStackTrace();
		return ls;
	}
	
	public List<T> getDelegate() {
		return null;
	}

	@Override
	public int size() {
		return getDelegate().size();
	}

	@Override
	public boolean contains(T entry) {
		return getDelegate().contains(entry);
	}

	@Override
	public EList<T> asCollection() {
		return new FakeEListImpl<>(getDelegate());
	}

	@Override
	public Iterator<T> iterator() {
		return getDelegate().iterator();
	}

	@Override
	public TreeposList getIndices(T forValue) {
		SimpleTreeposList ret = new SimpleTreeposList();
		int i = 0;
		for (T val: this) {
			if (Objects.equals(val, forValue)) {
				ret.add(0, IntegerTreePos.forValue(i));
			}
			++i;
		}
		return ret;
	}

	@Override
	public Iterable<Entry<T, TreeposList>> treeposForValues() {
		Iterator<T> baseIter = iterator();
		return ()->new Iterator<Entry<T, TreeposList>>() {
			int curInd = 0;
			
			@Override
			public boolean hasNext() {
				return baseIter.hasNext();
			}

			@Override
			public Entry<T, TreeposList> next() {
				SimpleTreeposList stl = new SimpleTreeposList();
				stl.add(0, IntegerTreePos.forValue(curInd++));
				return new SimpleEntry<>(baseIter.next(), stl);
			}
		};
	}

	@Override
	public boolean containsSpecific(Treepos pos, T value, long editId) {
		if (editId != 0) {return false;}
		int index = -1;
		if (pos instanceof IntegerTreePos) {
			index = ((IntegerTreePos)pos).getValue();
		} else {
			TreeposValue val = pos.getValue(0);
			if (val.type() == TreeposType.PREPEND_NEAR) {
				index = pos.getValue(0).value();
			}
		}
		if (index < 0 || index >= size()) {
			return false;
		}
		return Objects.equals(get(index), value);		
	}
	

	@Override
	public boolean containsSpecificEdit(Treepos pos, T value, long editId, ContainState cont) {
		if (editId != 0) {return false;}
		int index = -1;
		if (pos instanceof IntegerTreePos) {
			index = ((IntegerTreePos)pos).getValue();
		} else {
			TreeposValue val = pos.getValue(0);
			if (val.type() == TreeposType.PREPEND_NEAR) {
				index = pos.getValue(0).value();
			}
		}
		if (index < 0 || index >= size()) {
			return cont == ContainState.NOT_CONTAINS;
		}		
		return Objects.equals(get(index), value) == (cont == ContainState.CONTAINS);		
	}

	@Override
	public boolean addSet(T entry) {
		if (!contains(entry)) {
			getDelegate().add(entry);
			return true;
		}
		return false;
	}

	@Override
	public void removeAll(T entry) {
		while (getDelegate().remove(entry));
	}

	@Override
	public void clear() {
		getDelegate().clear();
	}

	@Override
	public void clean() {
	}

	@Override
	public boolean addDefault(T value) {
		return getDelegate().add(value);
	}

	@Override
	public Object getSpecificSource(Treepos pos, T value, ContainState type) {
		return null;
	}


	@Override
	public ContainState getState(T entry) {
		return getDelegate().indexOf(entry) == -1?ContainState.NOT_CONTAINS:ContainState.CONTAINS;
	}

	@Override
	public void ensure(T forValue, ContainState state) {
		
		if (state == ContainState.CONTAINS) {
			if (!getDelegate().contains(forValue)) {
				getDelegate().add(forValue);
			}
		} else {
			try {
				getDelegate().removeIf((x)->Objects.equals(x, forValue));
			} catch (UnsupportedOperationException e) {
				while (getDelegate().contains(forValue)) {
					getDelegate().remove(forValue);
				}
			}
		}
	}

	/*@Override
	public boolean removeSpecific(Treepos pos, T value, long editId) {
		if (editId != 0) {
			return false;
		}
		Set<Entry<Integer,TreeposValue>> keys = pos.getEntries();
		if (keys.size() == 1) {
			Entry<Integer,TreeposValue> entr = keys.iterator().next();
			if (entr.getKey() == 0 && entr.getValue().type() == TreeposType.PREPEND_NEAR) {
				int index = entr.getValue().value();
				if (index >= 0 && index < size()) {
					getDelegate().remove(index);
					return true;
				}
			}
		}
		return false;
		
	}*/

}
