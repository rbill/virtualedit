package at.ac.tuwien.big.virtmod.ecore.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Internal;
import org.eclipse.emf.ecore.resource.ResourceSet;

import at.ac.tuwien.big.autoedit.ecore.util.MyEcoreUtil;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VEObject;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VirtualModel;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class VEObjectImpl<A> extends BasicEObjectImpl implements VEObject<A>, InternalEObject {
	private A uuid;
	private VirtualModel<A> model;
	private Resource rs;
	
	public VEObjectImpl(A uuid, VirtualModel<A> model, Resource rs) {
		this.uuid = uuid;
		this.model = model;
		this.rs = rs;
	}

	
	//Source für Object Annotation
	
	/**The source for each value of the feature*/
	public List<? extends Iterable<? extends ElementSourceInfo> > getFeatureSource(EStructuralFeature feat) {
		
	}
	

	@Override
	public A getUUID() {
		return uuid;
	}

	@Override
	public VirtualModel<A> getModel() {
		return model;
	}

	@Override
	public List<Object> getSources(EStructuralFeature forFeature) {
		Feature<A,?> feat = model.getFeature(forFeature);
		FeaturePropertyValue<?> myValue = feat.getValue(uuid);
		List<Object> ret = new ArrayList<Object>();
		if (myValue instanceof VListFeaturePropertyValue) {
			VListFeaturePropertyValue<?> vl = (VListFeaturePropertyValue<?>)myValue;
			VEditableList<?> list = vl.getDelegate();
			return list.getAllSources();
		} else {
			for (Object o: MyEcoreUtil.getAsCollection(this, forFeature)) {
				ret.add(null);
			}
		}
		return ret;
	}

	@Override
	public EClass eClass() {
		String myClass = model.getClassObjects().getClass(uuid);
		return model.getECore().getEClass(myClass);
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
		FeaturePropertyValue<?> val = model.getFeature(feature).getValue(uuid);
		if (feature.isMany()) {
			return val.getDelegateList();
		} else {
			List<?> l = val.getDelegateList();
			if (l.isEmpty()) {
				return null;
			}
			return l.get(0);
		}
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		FeaturePropertyValue<?> val = model.getFeature(feature).getValue(uuid);
		if (feature.isMany()) {
			return val.getDelegateList();
		} else {
			List<?> l = val.getDelegateList();
			if (l.isEmpty()) {
				return null;
			}
			Object ret = l.get(0);
			if (ret instanceof EObject) {
				EObject eret = (EObject)ret;
				if (eret.eIsProxy()) {
					//resolve??
				}
			}
			return l.get(0);
		}
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		FeaturePropertyValue<?> val = model.getFeature(feature).getValue(uuid);
		List<?> l = val.getDelegateList();
		val.setToValue(newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		FeaturePropertyValue<?> val = model.getFeature(feature).getValue(uuid);
		List<?> l = val.getDelegateList();
		return !l.isEmpty();
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		FeaturePropertyValue<?> val = model.getFeature(feature).getValue(uuid);
		List<?> l = val.getDelegateList();
		l.clear();
	}



}
