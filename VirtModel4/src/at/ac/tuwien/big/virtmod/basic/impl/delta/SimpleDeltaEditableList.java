package at.ac.tuwien.big.virtmod.basic.impl.delta;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.VList;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaEditableVList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleListEditState;

public class SimpleDeltaEditableList<T> implements DeltaEditableVList<T>{

	private VList<T> base;
	private VEditableList<T> delta;
	private ListEditState state = new SimpleListEditState();
	private Object source;
	
	public Object source() {
		return source;
	}
	
	public SimpleDeltaEditableList(VList<T> base, VEditableList<T> delta, Object source) {
		this.base = base;
		this.delta = delta;
		this.source = source;
	}
	
	public VList<T> baseList() {
		return base;
	}
	
	public VEditableList<T> deltaList() {
		return delta;
	}
	
	public ListEditState getEditState() {
		if (base instanceof VEditableList) {
			return ((VEditableList) base).getEditState();
		}
		return state;
	}


}

