package at.ac.tuwien.big.virtmod.structure;

import java.util.UUID;

import at.ac.tuwien.big.virtmod.structure.impl.EditElementInfo;
import at.ac.tuwien.big.virtmod.structure.impl.VNamedObjectRef;
import at.ac.tuwien.big.virtmod.structure.impl.VRelativeObjectRefImpl;
import at.ac.tuwien.big.virtmod.structure.impl.VResourceObjectRef;

public interface VContainer {

	public VLocation parentLoc();
	
	public default VContainer parent() {
		VLocation pLoc = parentLoc();
		if (pLoc != null) {
			return pLoc.parent();
		}
		return null;
	}
	
	public VLocation childLoc(String name);
	
	public VObject object();
	
	public void removeChild(String name);	
	
	public VLocation getOrCreateChild(String name);
	
	public default VResource directResource() {
		return null;
	}
	
	public default VResource resource() {
		VResource ret = directResource();
		if (ret != null) {
			return ret;
		}
		VLocation parentLoc = parentLoc();
		if (parentLoc != null) {
			return parentLoc.parent().resource();
		}
		return null;
	}
	
	public default VObjectRef getObjectRef() {
		VResource directRes = directResource();
		if (directRes != null) {
			return new VResourceObjectRef(directRes);
		}
		VLocation pLoc = parentLoc();
		if (pLoc != null) {
			return new VNamedObjectRef(pLoc.parent().getObjectRef(),pLoc.name());
		}
		return new VRelativeObjectRefImpl(this);
	}
	
	public default VContainer child(String name) {
		VLocation cLoc = childLoc(name);
		if (cLoc != null) {
			return cLoc.child();
		}
		return null;
	}

	public default VContainer createChild(String string) {
		return getOrCreateChild(string).child();
	}

	public void initObject(VObject basicVObject);
	
	public Iterable<? extends ElementSourceInfo> getElementSource();

	public default VContainer createNewChild() {
		return createChild(UUID.randomUUID().toString());
	}
	
}
