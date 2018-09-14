package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;

import VObjectModel.Identifier;

public interface VMEObject extends Serializable {

	public EObjectCreator getSourceOrNull();
	
	public Identifier getIdentificator();
}
