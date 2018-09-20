package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import VObjectModel.Identifier;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;

public interface VMEObject extends Serializable, EObject {

	public void addListener(EStructuralFeature resf, BasicListenable refreshMyself);
	
	public Identifier getIdentificator();

	public EObjectCreator getSourceOrNull();
}
