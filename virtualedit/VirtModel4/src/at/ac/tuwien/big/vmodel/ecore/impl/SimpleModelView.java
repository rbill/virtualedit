package at.ac.tuwien.big.vmodel.ecore.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObjectProxy;
import at.ac.tuwien.big.virtmod.structure.impl.VDeltaContainer;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.VFeatureValues;
import at.ac.tuwien.big.vmodel.ecore.VModelView;
import at.ac.tuwien.big.vmodel.ecore.VObjectValues;
import at.ac.tuwien.big.xtext.annotation.SourcedEObject;

public class SimpleModelView implements VModelView {
	
	private VContainer cont;
	
	private Map<String,VFeatureValues> featureValuesCache = new HashMap<>();
	private Map<String,SourcedEObject> containedObjects = new HashMap<String, SourcedEObject>();
	
	@Override
	public void selfClear() {
		Set<String> allInstances = new HashSet<>();
		for (String str: getInstances()) {
			allInstances.add(str);
		}
		for (EStructuralFeature feat: ecoreFile.getAllFeatures()) {
			getFeatureValues(feat).nullifyClear();
		}
		getInstances().nullifyClear();
	}
	
	private VObjectValues instances;
	private VEcoreFile ecoreFile;

	public SimpleModelView(VContainer cont, VEcoreFile ecore) {
		this.cont = cont;
		this.ecoreFile = ecore;
		if (cont instanceof VDeltaContainer) {
			//TODO: Das ist nicht schön ... aber ich weiß noch nicht, wie ich das "ordentlich" mache
			new SimpleModelView(((VDeltaContainer) cont).getEdit(), ecore);
			new SimpleModelView(((VDeltaContainer) cont).getBase(), ecore);
		}
		initModelForEdit();
	
	}
	
	public VContainer rootContainer() {
		return cont;
	}
	

	public VEcoreFile getEcore() {
		return ecoreFile;
	}
	
	
	public void setContainer(VContainer cont) {
		if (!Objects.equals(this.cont,cont)) {
			this.cont = cont;
			reload();
			
		}
	}
	
	public String toString() {
		return printModel();
	}
	
	
	@Override
	public VFeatureValues getFeatureValues(String classname, String featureName) {
		VFeatureValues ret = featureValuesCache.get(classname+"."+featureName);
		if (ret == null) {
			EStructuralFeature feat = getEcore().getFeature(classname, featureName);
			VContainer assocCont = null;
			boolean isInverse = false;
			boolean isContainment = false;
			
			if (feat != null && feat instanceof EReference) {
				String useClass = classname;
				String useFeature = featureName;
				EReference ref = (EReference)feat;
				if (ref.getEOpposite() != null) {
					//Store association in alphabetically first
					EReference opposite = ((EReference)feat).getEOpposite();
					String myString = feat.getEContainingClass().getName()+"."+feat.getName();
					String oppositeString = opposite.getEContainingClass().getName()+"."+opposite.getName();
					if (myString.compareTo(oppositeString) < 0) {
						//No inverse
						isInverse = false;
					} else {
						isInverse = true;
						useClass = opposite.getEContainingClass().getName();
						useFeature = opposite.getName();
					}
				}
				if (ref.isContainment()) {
					isContainment = true;
				}
				assocCont = cont.createChild("associations").createChild(useClass).createChild(useFeature);
			}
			featureValuesCache.put(classname+"."+featureName, ret = new ContainerFeatureValue(cont.createChild("attributes").createChild(classname).createChild(featureName),assocCont,isInverse,isContainment));
		}
		return ret;
	}

	@Override
	public VObjectValues getInstances() {
		if (instances == null) {
			instances = new ContainerObjectValues(cont.createChild("objects"));
		}
		return instances;
	}

	@Override
	public void reload() {
		instances = null;
		featureValuesCache = new HashMap<String, VFeatureValues>();
	}
	
	

	@Override
	public SourcedEObject getEObject(String uuid) {
		SourcedEObject ret = containedObjects.get(uuid);
		if (ret == null) {
			containedObjects.put(uuid, ret = new VEObjectImpl(uuid, this, null));
		}
		return ret;
	}

	@Override
	public String getContainingObjectUuid(String uuid) {
		List<EReference> candidateReferences = ecoreFile.getReverseContainments(instances.getClass(uuid));
		for (EReference ref: candidateReferences) {
			VFeatureValues vals = getFeatureValues(ref.getEContainingClass().getName(), ref.getName());
			for (String cont: vals.getValueListInv(uuid)) {
				return cont;
			}
		}
		return null;
	}

	@Override
	public EReference getContainingFeature(String uuid) {
		List<EReference> candidateReferences = ecoreFile.getReverseContainments(instances.getClass(uuid));
		for (EReference ref: candidateReferences) {
			VFeatureValues vals = getFeatureValues(ref.getEContainingClass().getName(), ref.getName());
			if (vals.getValueListInv(uuid).iterator().hasNext()) {
				return ref;
			}
		}
		return null;
	}

	

}
