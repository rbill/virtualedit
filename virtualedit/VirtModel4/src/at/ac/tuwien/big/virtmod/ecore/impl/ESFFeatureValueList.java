package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ESFFeatureValueList<T> extends ConcreteFeatureValueList<T> {
	
	private EObject eobj;
	private EStructuralFeature feat;
	
	public ESFFeatureValueList(EObject eobj, EStructuralFeature feat) {
		this.eobj = eobj;
		this.feat = feat;
	}

	@Override
	public List<T> getDelegate() {
		if (feat.isMany()) {
			return (List<T>)eobj.eGet(feat);
		} else {
			T ret = (T)eobj.eGet(feat);
			if (ret == null) {
				return Collections.emptyList();
			} else {
				return Collections.singletonList(ret);
			}
		}
	}

}
