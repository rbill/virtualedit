package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.constraint.NotifyableEObject;

public interface VMEObject extends Serializable, NotifyableEObject {

	
	public Identifier getIdentificator();
		
	public IdentifierInfo getIdentifierInfo();

	public EObjectManager getManager();

	public Collection<?> getParameters();
	
	public EObjectCreator getSourceOrNull();

	//public void setEClass(EClass ecl); 
}
