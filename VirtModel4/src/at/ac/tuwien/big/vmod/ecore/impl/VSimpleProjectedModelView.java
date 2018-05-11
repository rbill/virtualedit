package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.verocl.parameterdesc.MultiModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.ecore.VProjectedFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VProjectedModelView;
import at.ac.tuwien.big.vmod.impl.EcoreModelResourceUtil;
import at.ac.tuwien.big.vmod.impl.ParametizedCounter;
import at.ac.tuwien.big.vmod.impl.ParametizedFunction;
import at.ac.tuwien.big.vmod.impl.ParametizedModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;

public class VSimpleProjectedModelView implements VProjectedModelView {


	private Map<String,VProjectedFeatureValues<?>> featureValuesCache = new HashMap<>();
	private Map<Symbol,VMEObject> containedObjects = new HashMap<>();
	//private MultiPoint projection;
	
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
	private MultiPoint rootPoint;
	private ParametizedModelResource<MultiPoint, SinglePoint> modelResource;

	public VSimpleProjectedModelView(ModelProvider prov, ParametizedModelResource<MultiPoint,SinglePoint> modelResource, VEcoreFile ecore, MultiPoint basePoint) {
		this.prov = prov;
		this.modelResource = modelResource; 
		this.ecoreFile = ecore;		
		this.rootPoint = basePoint;
		initModelForEdit();
	}
	
	private VSimpleProjectedModelView() {
		
	}

	public VEcoreFile getEcore() {
		return ecoreFile;
	}
	
	public String toString() {
		return printModel();
	}
	
	
	
	@Override
	public VProjectedFeatureValues<?> getFeatureValues(String classname, String featureName) {
		String fullName = classname+"."+featureName;
		VProjectedFeatureValues<?> ret = featureValuesCache.get(fullName);
		if (ret == null) {
			ParametizedFunction<Symbol, ParametizedFunction<Treepos, ParametizedFunction<Object, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> featureVals = 
						EcoreModelResourceUtil.getProjectedFeatureValueFunc(modelResource, fullName);
			
			ret = new VProjectedFeatureValuesImpl<>(getEcore().getFeature(classname, featureName),  featureVals, this);
			featureValuesCache.put(fullName, ret);
		}
		return ret;
	}

	@Override
	public VObjectValues getInstances() {
		if (instances == null) {
			ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint, SinglePoint>, MultiPoint, SinglePoint> objectFunction = EcoreModelResourceUtil.getProjectedObjectFunc(modelResource);
			ParametizedFunction<Symbol, ParametizedFunction<String, ? extends ParametizedCounter<MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> classFunction = EcoreModelResourceUtil.getProjectedClassFunc(modelResource);
			ParametizedFunction<Symbol, ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> containerFunction = EcoreModelResourceUtil.getProjectedContainerFunc(modelResource);
			instances = new VProjectedObjectValuesImpl(objectFunction,containerFunction,classFunction,this, ecoreFile);
		}
		return instances;
	}

	@Override
	public void reload() {
		instances = null;
		featureValuesCache = new HashMap<>();
	}
	
	/*public void initProjection(MultiPoint projection) {
		this.projection = projection;
	}*/
	
	@Override
	public MultiModelPoint getProjection() {
		return (MultiModelPoint)this.modelResource.getParam();
	}
	


	@Override
	public MultiPoint getProjectionBase() {
		return rootPoint; 
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

	@Override
	public VProjectedModelView project(MultiPoint t) {
		VSimpleProjectedModelView ret = new VSimpleProjectedModelView();
		ret.prov = prov;
		ret.modelResource = modelResource.project(t);
		ret.ecoreFile = ecoreFile;
		ret.rootPoint = rootPoint;
		ret.initModelForEdit();
		//ret.initProjection(t);
		return ret;
	}

}
