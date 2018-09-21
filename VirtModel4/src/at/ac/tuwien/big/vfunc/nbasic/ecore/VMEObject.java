package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import VObjectModel.Identifier;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.constraint.NotifyableEObject;

public interface VMEObject extends Serializable, NotifyableEObject {

	
	public Identifier getIdentificator();
		
	public IdentifierInfo getIdentifierInfo();

	public EObjectCreator getSourceOrNull();

	public EObjectManager getManager();
}