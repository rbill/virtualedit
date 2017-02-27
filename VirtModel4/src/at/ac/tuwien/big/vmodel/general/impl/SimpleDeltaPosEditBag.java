package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleListEditState;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.DeltaCreater;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;

public class SimpleDeltaPosEditBag<U extends EditableIntegerValueElement,U1,U2,TF extends VFunc<? super Treepos, ? extends U1>, UF extends VFunc<? super Treepos, ? extends U2>> 
	extends SimpleDeltaVFunc<Treepos, U, U1, U2, VFunc<? super Treepos,? extends U1>, VFunc<? super Treepos,? extends U2>> 
	implements VPosEditBag<U> {

	public SimpleDeltaPosEditBag(VContainer cont, VFunc<? super Treepos, ? extends U1> first,
			VFunc<? super Treepos, ? extends U2> second, OwnedFunc<Treepos, U> cache, DeltaCreater<U1, U2, ? extends U> creater) {
		super(cont, first, second, cache, creater);
	}
	
	private ListEditState editState = new SimpleListEditState();
	
	public ListEditState getEditState() {
		return editState;
	}

}
