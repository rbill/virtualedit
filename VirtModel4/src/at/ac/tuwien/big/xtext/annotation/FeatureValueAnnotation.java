package at.ac.tuwien.big.xtext.annotation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class FeatureValueAnnotation extends MyAnnotation {
		
	protected FeatureValueAnnotation() {
		super("ANNOT_FVAL");
	}

	public abstract EStructuralFeature getFeature();
	
	public abstract int getIndex();

}
