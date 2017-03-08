package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVBag;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVPosEditBag;

public interface VPosEditBag<E extends EditableIntegerValueElement> extends VEditableBag<Treepos, E>{


	public ListEditState getEditState();

	public static<E extends EditableIntegerValueElement> VPosEditBag<E> ensurePosEditBag(VEntryIterableFunc<Treepos, E> func, ListEditState state) {
		if (func instanceof VPosEditBag) {
			return (VPosEditBag)func;
		} else {
			return new SimpleAbstractDelegatingVPosEditBag(func.store(), func, state);
		}
	}
	

	//public VPosEditBag<E> baseClone(VContainer newCont, Creater<E, Treepos> newCreator);
}
