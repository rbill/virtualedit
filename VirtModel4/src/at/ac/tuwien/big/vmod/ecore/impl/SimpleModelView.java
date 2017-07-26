package at.ac.tuwien.big.vmod.ecore.impl;

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

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObjectProxy;
import at.ac.tuwien.big.virtmod.structure.impl.VDeltaContainer;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.EcoreFuncUtil;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.impl.EcoreModelResourceUtil;
import at.ac.tuwien.big.xtext.annotation.SourcedEObject;

public class SimpleModelView implements VModelView {
	
	private Map<String,VFeatureValues> featureValuesCache = new HashMap<>();
	private Map<Symbol,VMEObject> containedObjects = new HashMap<>();
	

	
	@Override
	public void selfClear() {
		Set<Symbol> allInstances = new HashSet<>();
		for (Symbol str: getInstances()) {
			allInstances.add(str);
		}
		for (EStructuralFeature feat: ecoreFile.getAllFeatures()) {
			getFeatureValues(feat).clear();
		}
		getInstances().nullifyClear();
	}
	
	private VObjectValues instances;
	private VEcoreFile ecoreFile;
	private ModelProvider prov;

	public SimpleModelView(ModelProvider prov, VEcoreFile ecore) {
		this.prov = prov;
		this.ecoreFile = ecore;		
		initModelForEdit();
	}	

	public VEcoreFile getEcore() {
		return ecoreFile;
	}
	
	public String toString() {
		return printModel();
	}
	
	
	
	@Override
	public VFeatureValues getFeatureValues(String classname, String featureName) {
		String fullName = classname+"."+featureName;
		VFeatureValues ret = featureValuesCache.get(fullName);
		if (ret == null) {
			Function<Symbol, ? extends Function<Treepos, ? extends Function<?, ? extends Counter>>> featureVals = EcoreModelResourceUtil.getFeatureValueFunc(prov.getResultModel(), fullName);
			ret = new VFeatureValuesImpl(getEcore().getFeature(classname, featureName),  featureVals, this);
			featureValuesCache.put(classname+"."+featureName, ret);
		}
		return ret;
	}

	@Override
	public VObjectValues getInstances() {
		if (instances == null) {
			Function<Symbol, ? extends Counter> objectFunction = EcoreModelResourceUtil.getObjectFunc(prov.getResultModel());
			Function<Symbol, Function<String, ? extends Counter>> classFunction = EcoreModelResourceUtil.getClassFunc(prov.getResultModel());
			Function<Symbol, Function<Symbol, ? extends Counter>> containerFunction = EcoreModelResourceUtil.getContainerFunc(prov.getResultModel());
			instances = new VObjectValuesImpl(objectFunction,containerFunction,classFunction,this, ecoreFile);
		}
		return instances;
	}

	@Override
	public void reload() {
		instances = null;
		featureValuesCache = new HashMap<String, VFeatureValues>();
	}
	
	

	@Override
	public VMEObject getEObject(Symbol uuid) {
		VMEObject ret = containedObjects.get(uuid);
		if (ret == null) {
			containedObjects.put(uuid, ret = new SimpleVMEObject(this,uuid));
		}
		return ret;
	}

	@Override
	public Symbol getContainingObjectUuid(Symbol uuid) {
		return getInstances().getContainingObject(uuid);
	}

	@Override
	public EReference getContainingFeature(Symbol uuid) {
		String featName = getInstances().getContainingFeature(uuid);
		return (EReference)getEcore().getFeature(featName);
	}

	@Override
	public ModelProvider getMainProvider() {
		return prov;
	}

	

}
