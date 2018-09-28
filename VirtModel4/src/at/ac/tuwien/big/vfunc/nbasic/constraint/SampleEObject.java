package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import VObjectModel.Identifier;
import at.ac.tuwien.big.vfunc.nbasic.ecore.AttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectUtil;
import at.ac.tuwien.big.vfunc.nbasic.ecore.MultiAttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.SingleAttributeHandler;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;

public abstract class SampleEObject extends MinimalEObjectImpl implements NotifyableEObject, EObjectUtil {
	
	//protected Identifier $id;
	protected MyResource res;
	protected List<?> parameters;
	protected boolean wasInitialized = false;
	protected CEobjectManager cmanager;
	
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
	

	//Just ensure I don't forget it
	public abstract void initDerived();


	public void initMyResource(MyResource res, CEobjectManager manager) {
		this.res = res;
		this.cmanager = manager;
	}
	
	public void initParameters(List<?> parameters) {
		this.parameters = parameters;
	}


	/*public void initIdentifier(Identifier id) {
		this.$id = id;
	}*/		
	
	public void makeInitialized() {
		this.wasInitialized = true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(eClass().getName()+":\n");
		TreeSet<EStructuralFeature> fSet = new TreeSet<>((x,y)->{
			return (x.getEContainingClass().getName()+"."+x.getName()).compareTo(
					y.getEContainingClass().getName()+"."+y.getName()
					);
			
		});
		fSet.addAll(eClass().getEAllStructuralFeatures());
		fSet.forEach(x->{
			builder.append("\t"+x.getEContainingClass().getName()+"."+x.getName()+": ");
			builder.append(printFeatureValues(x));
			builder.append("\n");
		});
		return builder.toString();
	}
	
	
	public boolean wasInitialized() {
		return this.wasInitialized;
	}

}
