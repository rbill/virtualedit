package at.ac.tuwien.big.virtmod.structure.impl;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObjectRef;
import at.ac.tuwien.big.virtmod.structure.VRelativeObjectRef;

public class VRelativeObjectRefImpl implements VRelativeObjectRef {
	
	private VContainer thisContainer;
	
	public VRelativeObjectRefImpl(VContainer thisContainer) {
		this.thisContainer = thisContainer;
	}

	@Override
	public VObjectRef parent() {
		return null;
	}

	@Override
	public VContainer thisContainer() {
		return thisContainer;
	}

}
