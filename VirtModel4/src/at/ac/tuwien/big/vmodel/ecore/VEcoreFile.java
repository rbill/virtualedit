package at.ac.tuwien.big.vmodel.ecore;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface VEcoreFile {

	public EStructuralFeature getFeature(String className, String featureName);
	
	public EClass getClass(String className);
	
	public Collection<EStructuralFeature> getAllFeatures();
	
	public Collection<EClass> getAllClasses();
	
	public default List<EReference> getReverseContainments(String className) {
		return getReverseContainments(getClass(className));
	}
	
	/**Features where the specified class could be contained in*/
	public List<EReference> getReverseContainments(EClass cl);

	public default String getName(EClass cl) {
		return cl.getName();
	}

	public EStructuralFeature getFeature(String featName);
}
