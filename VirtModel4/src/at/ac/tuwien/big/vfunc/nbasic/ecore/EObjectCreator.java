package at.ac.tuwien.big.vfunc.nbasic.ecore;

import VObjectModel.CreatorId;
import VObjectModel.Identifier;

public interface EObjectCreator {

	
	public VMEObject createEObject(Identifier ide, Object... parameters);
	
	public CreatorId getName();
	
}
