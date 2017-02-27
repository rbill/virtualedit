package at.ac.tuwien.big.vmodel.ecore;

import at.ac.tuwien.big.xtext.annotation.SourcedEObject;

public interface VEObject extends SourcedEObject {
	
	public VModelView getModel();
	
	public String  getUUID();

}
