package at.ac.tuwien.big.xtext.annotation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.vmodel.general.WrappedElementSource;
import at.ac.tuwien.big.vmodel.general.impl.WrappedInfo;

public interface SourcedEObject extends EObject {
	
	public Iterable<? extends ElementSourceInfo>  getObjectSource();
	
	public default WrappedElementSource getWrappedObjectSource() {
		return new WrappedInfo(getObjectSource());
	}
	
	//Source für Object Annotation
	
	/**The source for each value of the feature*/
	public List<? extends Iterable<? extends ElementSourceInfo> > getFeatureSource(EStructuralFeature feat);
	
	public default List<? extends WrappedElementSource> getWrappedFeatureSource(EStructuralFeature feat) {
		List<? extends Iterable<? extends ElementSourceInfo>> preRet = getFeatureSource(feat);
		List<WrappedElementSource> ret = new ArrayList<>(preRet.size());
		for (Iterable<? extends ElementSourceInfo> it: preRet) {
			ret.add(new WrappedInfo(it));
		}
		return ret;
	}
	
	
	/*public default ObjectAnnotation getObjectAnnotation() {
		return new SimpleObjectAnnotation(this, getSource());
	}*/
	
}
