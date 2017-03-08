package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.DoubleParameterIFace;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.MergedNotifier;
import at.ac.tuwien.big.vmodel.general.Merger;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;

public class PosMergerWrapFunc<Y1 extends EditableIntegerValueElement, Y2 extends MergedNotifier & EditableIntegerValueElement, 
	YO extends EditableIntegerValueElement> 
	extends MergerWrapFunc<Treepos, Y1, Y2, YO> implements VPosEditBag<Y2> {
	
	private ListEditState editState;

	public PosMergerWrapFunc(VContainer cont, VEntryIterableFunc<Treepos, Y1> base, VEntryIterableFunc<Treepos, ? extends Y1> edit, Merger<Treepos, Y1, YO> merger,
			YO target, DoubleParameterIFace<Treepos, Y1, Y2> creator, ListEditState baseEdit) {
		super(cont, base, edit, merger, target, creator);
		this.editState = baseEdit;
	}
	
	public ListEditState getEditState() {
		return editState; 
	}

}
