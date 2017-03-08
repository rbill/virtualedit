package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.AbstractDelegatingVBag;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;

public class SimpleAbstractDelegatingVPosEditBag<E extends EditableIntegerValueElement> 
	extends SourcedObject implements VPosEditBag<E>, AbstractDelegatingVBag<Treepos,E> {

	private VEntryIterableFunc<Treepos,E> base1Func;


	public ListEditState editState;

	public SimpleAbstractDelegatingVPosEditBag(VContainer store, VEntryIterableFunc<Treepos, E> base1Func, ListEditState editState) {
		super(store);
		this.base1Func = base1Func;
		this.editState = editState;
	}

	@Override
	public VEntryIterableFunc<Treepos, E> base1Func() {
		return base1Func;
	}
	


	public ListEditState getEditState() {
		return editState;
	}

}
