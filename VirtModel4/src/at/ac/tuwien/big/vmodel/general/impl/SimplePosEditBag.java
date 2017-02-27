package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class SimplePosEditBag<E extends EditableIntegerValueElement> extends SimpleVFunc<Treepos, E> implements VPosEditBag<E> {
	
	private VEditableList<?,?> list;

	public SimplePosEditBag(VContainer store, VEditableList<?,?> list, Creater<? extends E, ? super Treepos> creator) {
		super(store, creator);
		this.list = list;
	}
	
	
	public ListEditState getEditState() {
		return list.getEditState();
	}

}
