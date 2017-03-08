package at.ac.tuwien.big.vmod.ecore;

import java.security.spec.ECField;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.vmod.type.Symbol;

public interface VMEObject extends EObject {
	
	public void setEClass(EClass newClass);
	
	public Symbol getUUID();

}
