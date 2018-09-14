package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import VObjectModel.Identifier;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;

public abstract class AbstractVMEObject  extends MinimalEObjectImpl implements InternalEObject, VMEObject {
	
	protected EObjectCreator creator;
	protected Identifier identificator;
	protected EObjectManager owner;
	private int hashCode;

	public AbstractVMEObject(EObjectManager manager, Identifier id) {
		this.creator = creator;
		this.owner = manager;
		this.identificator = id;
		this.hashCode = Objects.hash(this.creator.getName(),this.identificator);
	}
	
	@Override
	public EObjectCreator getSourceOrNull() {
		return creator;
	}

	@Override
	public Identifier getIdentificator() {
		return identificator;
	}
	
	
	public boolean equals(VMEObject other) {
		return Objects.equals(creator, other.getSourceOrNull()) && Objects.equals(identificator, other.getIdentificator());
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof VMEObject) && equals((VMEObject)other);
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public abstract EClass eClass();


	@Override
	public abstract EObject eContainer();
	
	public abstract InternalEObject eInternalContainer();
	
	
	
	 @Override
	  public abstract int eContainerFeatureID();
	  
	  	
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
	public abstract EStructuralFeature eContainingFeature();

	@Override
	public abstract EReference eContainmentFeature();
	

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public abstract Object eGet(EStructuralFeature feature);

	@Override
	public abstract Object eGet(EStructuralFeature feature, boolean resolve) ;
	
	@Override
	public abstract void eSet(EStructuralFeature feature, Object newValue);

	@Override
	public abstract boolean eIsSet(EStructuralFeature feature);

	@Override
	public abstract void eUnset(EStructuralFeature feature);

}
