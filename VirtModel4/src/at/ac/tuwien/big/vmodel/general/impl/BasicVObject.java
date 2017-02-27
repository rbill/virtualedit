package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;

public class BasicVObject implements VObject {
	

	public BasicVObject(VContainer store) {
		this.store = store;
		store.initObject(this);
	}
	
	private VContainer store;

	@Override
	public VContainer store() {
		return store;
	}

	@Override
	public void destroy() {	
	}
}
