package at.ac.tuwien.big.virtmod.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface VirtualModel<A> {
	
	public ClassObject<A> getClassObjects();

	public Feature<A,?> getFeature(EStructuralFeature feat);

	public VirtualECore<A> getECore();

	public EObject getContainingObject(A uuid);

	public EReference getContainingFeature(A uuid);
	

	
	public VirtualModel<A> deltaModel(Object source);
}
