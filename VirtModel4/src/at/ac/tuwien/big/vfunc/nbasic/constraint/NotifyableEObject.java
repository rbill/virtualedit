package at.ac.tuwien.big.vfunc.nbasic.constraint;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;

public interface NotifyableEObject extends EObject {
	

	public void addListener(EStructuralFeature resf, BasicListenable refreshMyself);
	
	

}
