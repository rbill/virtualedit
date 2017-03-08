package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ParentLocation;

public class ParentLocationImpl implements ParentLocation {
	
	private GeneralElement parent;
	private Object value;
	private GeneralElement child;
	
	public ParentLocationImpl(GeneralElement parent, Object value, GeneralElement child) {
		this.parent = parent;
		this.value = value;
		this.child = child;
	}

	@Override
	public GeneralElement getParent() {
		return parent;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public GeneralElement getChild() {
		return child;
	}

}
