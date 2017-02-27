package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VEObject;
import at.ac.tuwien.big.virtmod.ecore.impl.FakeEListImpl;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.VFakeEList;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.modelview.ModelView;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.impl.FilteredList;
import at.tuwien.big.virtmod.basic.Converter;
import at.tuwien.big.virtmod.basic.ProxyList;

public class SimpleVMEObject extends MinimalEObjectImpl implements VMEObject, InternalEObject {
	private Function<String, ? extends Counter> classFunc;
	private Map<EStructuralFeature, List<?>> myValues = new HashMap<>();
	private Symbol id;
	private VModelView model;
	private EClass myClass;
	
	public SimpleVMEObject(VModelView view, Symbol id) {
		this.id = id;
		this.model = view;
		this.classFunc = view.getInstances().getClassFunc(id);
		this.myValues = new HashMap<>();
	}

	@Override
	public void setEClass(EClass newClass) {
		model.getInstances().setClass(id, newClass);
	}

	@Override
	public Symbol getUUID() {
		return id;
	}

	public boolean equals(Object o) {
		return (o instanceof VMEObject) && Objects.equals(getUUID(),((VMEObject)o).getUUID());
	}
	
	public int hashCode() {
		return Objects.hashCode(getUUID());
	}

	public VModelView getModel() {
		return model;
	}
	
	private List<?> getValues(EStructuralFeature feat) {
		List<?> ret = myValues.get(feat);
		if (ret == null) {
			try {
				ret = model.getFeatureValues(feat.getEContainingClass().getName(), feat.getName()).getEcoreValue(getUUID());
				
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println("NPE when getting values for "+ feat);
				throw e;
			}
			myValues.put(feat, ret );
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
		if (this.myClass == null) {
			EClass myClass = model.getInstances().getClass(getUUID());
			this.myClass = myClass;
		}
		return myClass;
	}


	@Override
	public EObject eContainer() {
		return model.getContainingObject(id);
	}
	
	public InternalEObject eInternalContainer() {
	   return (InternalEObject)model.getContainingObject(id);
	}
	
	

	  @Override
	  public int eContainerFeatureID()
	  {
		  super.eContainerFeatureID();
		  EStructuralFeature feat = eContainingFeature();
		  if (feat == null) {
			  return -1;
		  }
		  if (feat instanceof EReference) {
			  EReference ref = (EReference)feat;
			  EReference op = ref.getEOpposite();
			  if (op != null) {
				  return op.getFeatureID();
			  }
		  }
		  return -feat.getFeatureID()-1;
	  }
	  
	  	
	  protected void eBasicSetContainerFeatureID(int newContainerFeatureID)
	  {
	    
	  }
	
	  @Override
	  protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID)
	  {
		  System.out.println("Set container to "+newContainer);
	  }

	protected void eBasicSetContainer(InternalEObject newContainer) {
		//???
		System.out.println("Set container to "+newContainer);
		
	}
	
	@Override
	public NotificationChain eSetResource(Resource.Internal resource, NotificationChain notifications) {
		System.out.println("Object with id "+id+" has now resource "+resource );
		return super.eSetResource(resource, notifications);
		
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return model.getContainingFeature(id);
	}

	@Override
	public EReference eContainmentFeature() {
		return model.getContainingFeature(id);
	}
	

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		List<?> values = getValues(feature);
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
		List<?> values = getValues(feature);
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
		return (cl==null?"??":cl.getName())+" with id "+id;
	}


}
