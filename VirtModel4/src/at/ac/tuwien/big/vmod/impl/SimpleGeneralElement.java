package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.type.GeneralType;

public abstract class SimpleGeneralElement<Type extends GeneralType> implements GeneralElement {
	protected ParentLocation parentLoc;
	protected Type type;
	
	public SimpleGeneralElement(Type type) {
		this.type = type;
	}
	
	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Object getMetaInfo(String key) {
		if ("parentloc".equals(key)) {
			return getParentLoc();
		}
		return null;
	}

	@Override
	public ParentLocation getParentLoc() {
		return parentLoc;
	}

	@Override
	public void setParentLoc(ParentLocation parent) {
		this.parentLoc = parent;
	}

	public void copyFrom(SimpleGeneralElement<Type> from) {
		this.type = from.type;
	}
	

}
