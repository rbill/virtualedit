package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.AbstractDelegatingVBag;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;

public class SimpleAbstractDelegatingVBag<X,E extends EditableIntegerValueElement> 
	extends SourcedObject implements VEditableBag<X, E>, AbstractDelegatingVBag<X,E> {

	private VEntryIterableFunc<X,E> base1Func;

	public SimpleAbstractDelegatingVBag(VContainer store, VEntryIterableFunc<X, E> base1Func) {
		super(store);
		this.base1Func = base1Func;
	}


	@Override
	public VEntryIterableFunc<X, E> base1Func() {
		return base1Func;
	}

}
