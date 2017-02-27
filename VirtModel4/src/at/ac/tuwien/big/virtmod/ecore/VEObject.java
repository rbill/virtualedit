package at.ac.tuwien.big.virtmod.ecore;

import org.eclipse.emf.ecore.EClass;

import at.ac.tuwien.big.xtext.annotation.SourcedEObject;

public interface VEObject<A> extends SourcedEObject {
	
	public A getUUID();
	
	public VirtualModel<A> getModel();

}
