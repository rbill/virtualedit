package at.ac.tuwien.big.virtmod.basic.wrapper.impl;

import java.util.Collection;
import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.wrapper.EditableSetWrapper;

public class EditableSetWrapperImpl<T> implements EditableSetWrapper<T> {
	private VEditableBag<T> bag;
	
	public EditableSetWrapperImpl(VEditableBag<T> bag) {
		this.bag = bag;
	}
	
	@Override
	public VEditableBag<T> getDelegate() {
		return bag;
	}


}
