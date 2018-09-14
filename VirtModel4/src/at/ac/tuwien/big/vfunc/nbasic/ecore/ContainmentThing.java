package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ContainmentThing {
	public final EObject container;
	public final EReference containmentFeature;
	
	public ContainmentThing(EObject container, EReference containmentFeature) {
		this.container = container;
		this.containmentFeature = containmentFeature;
	}

	public EObject getContainer() {
		return container;
	}
	
	public EReference getContainmentFeature() {
		return containmentFeature;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(container,containmentFeature);
	}
	
	public boolean equals(ContainmentThing thing) {
		return Objects.equals(container, thing.container) && Objects.equals(containmentFeature, thing.containmentFeature);
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof ContainmentThing) && equals((ContainmentThing)o);
	}
}
