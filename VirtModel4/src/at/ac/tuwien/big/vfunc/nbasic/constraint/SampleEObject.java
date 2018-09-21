package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import VObjectModel.Identifier;
import at.ac.tuwien.big.vfunc.nbasic.ecore.AttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.MultiAttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.SingleAttributeHandler;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;

public abstract class SampleEObject extends MinimalEObjectImpl {
	
	//protected Identifier $id;
	protected MyResource res;
	protected List<?> parameters;
	protected boolean wasInitialized = false;
	
	public boolean wasInitialized() {
		return wasInitialized;
	}
	
	public void makeInitialized() {
		this.wasInitialized = true;
	}
	
	public void initMyResource(MyResource res) {
		this.res = res;
	}

	@Override
	public abstract EClass eClass();
	
	@Override
	public abstract Object eGet(EStructuralFeature feature);
	
	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return eGet(feature);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		Object obj = eGet(feature);
		if (obj == null) {
			return false;
		}
		if (feature.isMany()) {
			return !((Collection)obj).isEmpty();
		}
		return true;
	}
	

	@Override
	public abstract void eSet(EStructuralFeature feature, Object newValue);


	@Override
	public NotificationChain eSetResource(Resource.Internal resource, NotificationChain notifications) {
		//System.out.println("Object with id "+id+" has now resource "+resource );
		return super.eSetResource(resource, notifications);
		
	}
	
	@Override
	public abstract void eUnset(EStructuralFeature feature);


	/*public void initIdentifier(Identifier id) {
		this.$id = id;
	}*/		
	
	//Just ensure I don't forget it
	public abstract void initDerived();

	public void initParameters(List<?> parameters) {
		this.parameters = parameters;
	}

}