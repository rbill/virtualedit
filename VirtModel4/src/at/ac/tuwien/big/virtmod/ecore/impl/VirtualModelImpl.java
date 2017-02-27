package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditableInvertibleFunc;
import at.ac.tuwien.big.virtmod.ecore.ClassObject;
import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VEObject;
import at.ac.tuwien.big.virtmod.ecore.VirtualECore;
import at.ac.tuwien.big.virtmod.ecore.VirtualModel;

public class VirtualModelImpl<A> implements VirtualModel<A> {
	
	private VirtualECore<A> ecore;
	private ClassObject<A> co;
	private Map<EStructuralFeature, Feature<A, ?>> allFeatures = new HashMap<EStructuralFeature, Feature<A,?>>();
	private Map<String, List<Feature<A,A>>> objectContainmentsPerClass = new HashMap<>();
	private Map<String, List<EReference>> objectContainmentFeaturesPerClass = new HashMap<>();
	private Map<A, VEObject<A>> existingEObjects = new HashMap<>();
	
	public VirtualModelImpl(VirtualECore<A> ecore) {
		this.ecore = ecore;
		this.co = new ClassObjectImpl<A>();
	}

	@Override
	public ClassObject<A> getClassObjects() {
		return co;
	}

	@Override
	public Feature<A, ?> getFeature(EStructuralFeature feat) {
		Feature<A, ?> ret = allFeatures.get(feat);
		if (ret == null) {
			if (feat instanceof EReference) {
				EReference ref = (EReference)feat;
				if (ref.getEOpposite() != null || ref.isContainment()) {
					//Per definition ist die auch noch nicht drin
					SimpleEditableInvertibleFunc<A, A> assocFunc = new SimpleEditableInvertibleFunc<>();
					SimpleBinaryAssociation<A, A> mainFunc = new SimpleBinaryAssociation<A, A>(assocFunc);
					allFeatures.put(feat, ret = mainFunc.getLeft());
					if (ref.getEOpposite() != null) {
						allFeatures.put(ref.getEOpposite(), mainFunc.getRight());
					}
					if (ref.isContainment()) {
						//Für die Klasse und alle SubTypen ...
						List<EClass> allTypes = new ArrayList<EClass>();
						allTypes.add(ref.getEReferenceType());
						allTypes.addAll(ecore.getSubclasses(ref.getEReferenceType()));
						for (EClass cl: allTypes) {
							String name = ecore.getName(cl);
							List<Feature<A,A>> fl = objectContainmentsPerClass.get(name);
							if (fl == null) {
								objectContainmentsPerClass.put(name, fl = new ArrayList<Feature<A,A>>());
							}
							List<EReference> er = objectContainmentFeaturesPerClass.get(name);
							if (er == null) {
								objectContainmentFeaturesPerClass.put(name, er = new ArrayList<EReference>());
							}
							fl.add(mainFunc.getRight());
							er.add(ref);
						}
						
					}
				} 
			}
		}
		return ret;
	}

	@Override
	public VirtualECore<A> getECore() {
		return ecore;
	}
	
	public VEObject<A> getOrCreate(A a) {
		VEObject<A> ret = existingEObjects.get(a);
		if (ret == null) {
			existingEObjects.put(a,  ret = new VEObjectImpl<A>(a, this, null));
		}
		return ret;
	}

	@Override
	public EObject getContainingObject(A uuid) {
		String cl = co.getClass(uuid);
		Collection<Feature<A,A>> cont = objectContainmentsPerClass.getOrDefault(cl, Collections.emptyList());
		for (Feature<A, A> feat: cont) {
			FeaturePropertyValue<A> val = feat.getValue(uuid);
			if (val.isSet()) {
				for (A a: val.getDelegateList()) {
					return getOrCreate(a);
				} 
			}
		}
		return null;
	}

	@Override
	public EReference getContainingFeature(A uuid) {
		String cl = co.getClass(uuid);
		Collection<Feature<A,A>> cont = objectContainmentsPerClass.getOrDefault(cl, Collections.emptyList());
		int ind = 0;
		for (Feature<A, A> feat: cont) {
			FeaturePropertyValue<A> val = feat.getValue(uuid);
			if (val.isSet()) {
				for (A a: val.getDelegateList()) {
					return objectContainmentFeaturesPerClass.get(cl).get(ind);
				}
			}
			++ind;
		}
		return null;
	}

}
