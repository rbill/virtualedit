package at.ac.tuwien.big.virtmod.basic.wrapper.impl;

import java.util.Collection;
import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.wrapper.SetWrapper;

public class SetWrapperImpl<T> implements SetWrapper<T> {
	
	private VBag<T> bag;
	
	public SetWrapperImpl(VBag<T> bag) {
		this.bag = bag;
	}
	
	@Override
	public VBag<T> getDelegate() {
		return bag;
	}

}
