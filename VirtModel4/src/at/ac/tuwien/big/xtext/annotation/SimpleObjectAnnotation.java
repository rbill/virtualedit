package at.ac.tuwien.big.xtext.annotation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class SimpleObjectAnnotation extends ObjectAnnotation {

	private EObject context;
	private Object source;
	
	public SimpleObjectAnnotation(EObject obj, Object source) {
		this.context = obj;
		this.source = source;
	}

	@Override
	public EObject getObject() {
		return context;
	}

	@Override
	public Object getSource() {
		return source;
	}
}
