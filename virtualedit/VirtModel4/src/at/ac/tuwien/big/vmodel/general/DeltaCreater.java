package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.structure.VObject;

public interface DeltaCreater<U1 extends VObject,U2 extends VObject,U3 extends DeltaBuilt<U1, U2>> {
	
	public U3 create(U1 delta, U2 base);

}
