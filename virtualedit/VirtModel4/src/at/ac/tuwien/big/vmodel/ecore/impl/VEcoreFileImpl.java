package at.ac.tuwien.big.vmodel.ecore.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.autoedit.ecore.util.MyResource;
import at.ac.tuwien.big.autoedit.ecore.util.MyResource.EcoreInfo;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;

public class VEcoreFileImpl implements VEcoreFile {
	
	private Resource res;
	
	private Map<String,EClass> eclassPerName = new HashMap<String, EClass>();
	private Map<EClass,List<EReference>> reverseContainments = new HashMap<EClass, List<EReference>>();
	private Map<String,EStructuralFeature> featurePerName = new HashMap<String, EStructuralFeature>();
	
	
	public VEcoreFileImpl(Resource ecoreFile)  {
		this.res = ecoreFile;
		MyResource myres = MyResource.get(res);
		//TODO: This is really ugly - better implement it manually
		EcoreInfo info = myres.getOrBuildEcoreInfo(res);
		for (EObject eobj: (Iterable<EObject>)()->ecoreFile.getAllContents()) {
			if (eobj instanceof EClass) {
				EClass cl = (EClass)eobj;
				for (EStructuralFeature feat: cl.getEStructuralFeatures()) {
					featurePerName.put(cl.getName()+"."+feat.getName(), feat);
				}
				reverseContainments.put(cl, new ArrayList(myres.getContainersFor(cl)));
				eclassPerName.put(cl.getName(), cl);
			}
		}
	}
	
	@Override
	public Collection<EStructuralFeature> getAllFeatures() {
		return featurePerName.values();
	}
	
	@Override
	public Collection<EClass> getAllClasses() {
		return eclassPerName.values();
	}

	@Override
	public EStructuralFeature getFeature(String className, String featureName) {
		return getFeature(className+"."+featureName);
	}

	@Override
	public EStructuralFeature getFeature(String fullName) {
		return featurePerName.get(fullName);
	}

	@Override
	public EClass getClass(String className) {
		return eclassPerName.get(className);
	}

	@Override
	public List<EReference> getReverseContainments(EClass cl) {
		return reverseContainments.getOrDefault(cl, Collections.emptyList());
	}

}
