package at.ac.tuwien.big.vmodel.general;

import java.util.Collections;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface DeltaBuilt<A extends VObject,B extends VObject> extends VObject {
	
	public A getEdit();
	
	public B getBase();
	
	public default Iterable<VContainer> sourceStores() {
		return IteratorUtils.shallowUnion(getBase().sourceStores(),getEdit().sourceStores());
	}

}
