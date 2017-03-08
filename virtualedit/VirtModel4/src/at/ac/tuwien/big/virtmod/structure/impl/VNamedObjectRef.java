package at.ac.tuwien.big.virtmod.structure.impl;

import at.ac.tuwien.big.virtmod.structure.CannotCreateUrlException;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObjectRef;
import at.ac.tuwien.big.virtmod.structure.VRelativeObjectRef;
import at.ac.tuwien.big.virtmod.structure.VUrlCreatorObjectRef;

public class VNamedObjectRef implements VRelativeObjectRef, VUrlCreatorObjectRef {
	private String name;
	private VObjectRef parent;
	private boolean isSelf = false;
	private boolean isParent = false;
	private boolean isChild = true;
	
	public VNamedObjectRef(VObjectRef parent, String name) {
		this.name = name;
		this.parent = parent;
		if (".".equals(name)) {
			isSelf = true;
			isChild = false;
		} else if ("..".equals(name)) {
			isParent = true;
			isChild = false;
		}
	}
	
	
	public String name() {
		return name;
	}

	@Override
	public VObjectRef parent() {
		return parent;
	}

	@Override
	public VContainer thisContainer() {
		VContainer parentCont = parent().thisContainer();
		if (isParent) {
			return parentCont.parent();
		} else if (isSelf) {
			return parentCont;
		}
		return parentCont.child(name);
	}
	
	public void createUrl(StringBuilder builder) throws CannotCreateUrlException {
		if (!(parent instanceof VUrlCreatorObjectRef)) {
			throw new CannotCreateUrlException();
		}
		((VUrlCreatorObjectRef)parent).createUrl(builder);
		builder.append("/");
		builder.append(name);
	}

}
