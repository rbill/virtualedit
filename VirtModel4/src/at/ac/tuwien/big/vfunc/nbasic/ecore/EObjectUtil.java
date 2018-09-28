package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface EObjectUtil extends EObject {


	default String printFeatureValues(EStructuralFeature feature) {
		if (feature.isMany()) {
			return simpleStringValue(eGet(feature));
		} else {
			return simpleStringValue(eGet(feature));
		}
	}
	

	default String simpleStringValue(Object obj) {
		if (obj instanceof EObject) {
			if (obj instanceof VMEObject) {
				return String.valueOf(((VMEObject)obj).getIdentificator());
			} else {
				if (this instanceof VMEObject) {
					return "@"+((VMEObject)this).getManager().getObjName((EObject)obj);
				} else {
					return ""+(obj);
				}
			}
		} else {
			if (obj instanceof Collection) {
				Collection col = (Collection)obj;
				StringBuilder ret = new StringBuilder();
				ret.append("[");
				boolean first = true;
				for (Object sobj: col) {
					if (first) {first=false;} else {ret.append(",");}
					ret.append(simpleStringValue(sobj));
				}
				ret.append("]");
				return ret.toString();
			} else {
				return String.valueOf(obj);
			}
		}
	}

}
