package at.ac.tuwien.big.virtmod.structure.impl;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VLocation;

public class VSimpleLocation implements VLocation {
	
	private VContainer parent;
	private VContainer child;
	private String name;
	
	public VSimpleLocation(VContainer parent, String name) {
		this.parent = parent;
		this.name = name;
		this.child = new VSimpleContainer(this);
	}

	@Override
	public VContainer parent() {
		return parent;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public VContainer child() {
		return child;
	}

}
