package at.ac.tuwien.big.xtext.annotation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.Annotation;

import at.ac.tuwien.big.virtmod.basic.SourceInfo;

public abstract class MyAnnotation extends Annotation {
	
	protected MyAnnotation(String type) {
		super(type,false,"Text is not important here");
	}

	public abstract EObject getObject();
	
	public boolean isGenerated() {
		return SourceInfo.isGenerated(getSource());
	}
	
	public abstract Object getSource();
}
