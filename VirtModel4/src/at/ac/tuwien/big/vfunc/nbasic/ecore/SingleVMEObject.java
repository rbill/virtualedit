package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;

public class SingleVMEObject extends MinimalEObjectImpl implements InternalEObject, VMEObject {

	

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
		//System.out.println("Object with id "+id+" has now resource "+resource );
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
			values.isEmpty();
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
