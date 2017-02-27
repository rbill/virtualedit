package at.ac.tuwien.big.xtext.annotation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.structure.GlobalSource;

public class SimpleFeatureValueAnnotation extends FeatureValueAnnotation {
	
	private EStructuralFeature esf;
	private int index;
	private EObject context;
	private GlobalSource<?> source;
	
	public SimpleFeatureValueAnnotation(EObject obj, EStructuralFeature feat, int index, GlobalSource<?> source) {
		this.context = obj;
		this.esf = feat;
		this.index = index;
		this.source = source;
	}
	

	@Override
	public EStructuralFeature getFeature() {
		return esf;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public EObject getObject() {
		return context;
	}

	@Override
	public GlobalSource<?> getSource() {
		return source;
	}

}
