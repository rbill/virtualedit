package at.ac.tuwien.big.vmodel.ecore.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaIteratorUtils.Filter;
import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VEObject;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VirtualModel;
import at.ac.tuwien.big.virtmod.ecore.impl.FakeEListImpl;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.vmodel.ecore.VModelView;
import at.ac.tuwien.big.vmodel.general.SourcedList;
import at.ac.tuwien.big.xtext.annotation.SourcedEObject;
import at.tuwien.big.virtmod.basic.Converter;
import at.tuwien.big.virtmod.basic.ProxyList;

public class VEObjectImpl extends MinimalEObjectImpl implements at.ac.tuwien.big.vmodel.ecore.VEObject, InternalEObject {
	private String uuid;
	private VModelView model;
	private Resource rs;
	private Map<EStructuralFeature, List<Object>> myValues = new HashMap<EStructuralFeature, List<Object>>();
	
	public VEObjectImpl(String uuid, VModelView model, Resource rs) {
		this.uuid = uuid;
		this.model = model;
		this.rs = rs;
	}
	
	public boolean equals(Object o) {
		return (o instanceof at.ac.tuwien.big.vmodel.ecore.VEObject) && Objects.equals(getUUID(),((at.ac.tuwien.big.vmodel.ecore.VEObject)o).getUUID());
	}
	
	public int hashCode() {
		return Objects.hashCode(getUUID());
	}

	@Override
	public Iterable<? extends ElementSourceInfo> getObjectSource() {
		//Hier muss ich eine Combined Source zurückliefern
		// TODO Auto-generated method stub
		return model.getInstances().getSource(uuid);
	}
	
	@Override
	public List<? extends Iterable<? extends ElementSourceInfo>> getFeatureSource(EStructuralFeature feat) {
		List<? extends Iterable<? extends ElementSourceInfo>> ret = model.getFeatureValues(feat).getSource(uuid);
		if (feat.getEType() instanceof EClass) {
			//Filter out non-existant
			List<Object> allObjs = model.getFeatureValues(feat.getEContainingClass().getName(), feat.getName()).getValueList(getUUID());
			
			
			//Something is filtered out
			List<Iterable<? extends ElementSourceInfo>> realRet = new ArrayList<>();
			at.ac.tuwien.big.xtext.util.IteratorUtils.Filter<String> objExists = model.getInstances().objectExistsFilter();
			Iterator<? extends Iterable<? extends ElementSourceInfo>> iter = ret.iterator();
			for (Object strO: allObjs)  {
				Iterable<? extends ElementSourceInfo> toAdd = iter.next();
				if (strO instanceof String && objExists.matches((String)strO)) {
					realRet.add(toAdd);
				}
			}
			return realRet;
		} else {
			return ret;
		}
	}
	

	public String getUUID() {
		return uuid;
	}

	public VModelView getModel() {
		return model;
	}
	
	private List<Object> getValues(EStructuralFeature feat) {
		List<Object> ret = myValues.get(feat);
		if (ret == null) {
			try {
				ret = model.getFeatureValues(feat.getEContainingClass().getName(), feat.getName()).getValueList(getUUID());
				if (feat.getEType() instanceof EClass) {
					List<String> stringRet = new FilteredList<String>((List<String>)(List)ret,model.getInstances().objectExistsFilter());
					List<Object> realRet= new ProxyList(new Converter<String, Object>(){
	
						@Override
						public Object getValue(String t) {
							return model.getEObject(t);
						}
	
						@Override
						public String getSource(Object v) {
							if (v instanceof at.ac.tuwien.big.vmodel.ecore.VEObject) {
								return ((at.ac.tuwien.big.vmodel.ecore.VEObject) v).getUUID();
							}
							throw new RuntimeException("Added EObject which was not a VEObject!");
						}
						
					}, stringRet);
					ret = realRet;
				}
			} catch (NullPointerException e) {
				System.err.println("NPE when getting values for "+ feat);
				throw e;
			}
			myValues.put(feat, FakeEListImpl.ensureEList(ret) );
		}
		return ret;
	}
	

	/*@Override
	public List<GlobalSource<?>> getSources(EStructuralFeature forFeature) {
		List<Object> values = getValues(forFeature);
		if (values instanceof SourcedList) {
			return ((SourcedList) values).getSources();
		}
		return null;
	}*/

	@Override
	public EClass eClass() {
		String myClass = model.getInstances().getClass(getUUID());
		EClass ret = model.getEcore().getClass(myClass);
		return ret;
	}


	@Override
	public EObject eContainer() {
		return model.getContainingObject(uuid);
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return model.getContainingFeature(uuid);
	}

	@Override
	public EReference eContainmentFeature() {
		return model.getContainingFeature(uuid);
	}

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		List<Object> values = getValues(feature);
		if (feature.isMany()) {
			return values;
		} else {
			if (values.isEmpty()) {
				return null;
			}
			return values.iterator().next();
		}
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		List<Object> values = getValues(feature);
		if (feature.isMany()) {
			return values;
		} else {
			if (values.isEmpty()) {
				return null;
			}
			return values.iterator().next();
		}
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		FeaturePropertyValue.setToValue(getValues(feature),newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return !getValues(feature).isEmpty();
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		getValues(feature).clear();
	}

	public String toString() {
		EClass cl = eClass();
		return (cl==null?"??":cl.getName())+" with id "+uuid;
	}


}
