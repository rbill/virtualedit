package at.ac.tuwien.big.virtmod.ecore;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ESFGetter<T> implements ValueGetter<T>, ValueSetter<T> {
	private EStructuralFeature feat;
	private EObject obj;
	
	public ESFGetter(EObject obj, EStructuralFeature feat) {
		this.obj = obj;
		this.feat = feat;
	}
	

	@Override
	public T get() {
		return (T)obj.eGet(feat);
	}


	@Override
	public void set(T val) {
		obj.eSet(feat, val);
	}

}

