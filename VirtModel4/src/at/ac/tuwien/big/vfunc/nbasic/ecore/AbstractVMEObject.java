package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

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
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;

public abstract class AbstractVMEObject  extends MinimalEObjectImpl implements InternalEObject, VMEObject {
	
	protected EObjectCreator creator;
	protected Identifier identificator;
	protected EObjectManager owner;
	private int hashCode;
	protected List<ContainmentThing> containments = new ArrayList<>();
	
	protected Function<EObject, EObject> convertToVirtual = (eobj)->{
		if (eobj  instanceof VMEObject) {
			return (VMEObject)eobj;
		}
		return getManager().getFakeVirtual(eobj);
	};


	protected Function<EObject, EObject> convertFromVirtual = (virtObj)->{
		if (virtObj instanceof VMEObject) {
			return getManager().getInvVirtual((VMEObject)virtObj);
		}
		return virtObj;
	};
	

	public AbstractVMEObject(EObjectManager manager, EObjectCreator creator, Identifier id) {
		this.creator = creator;
		this.owner = manager;
		this.identificator = id;
		this.hashCode = Objects.hash(this.creator.getName(),this.identificator);
	}
	

	@Override
	public void addListener(EStructuralFeature resf, BasicListenable refreshMyself) {
		AttributeHandler<?> handler = getHandler(resf);
		handler.addBasicChangeListener(refreshMyself);
	}



	@Override
	protected void eBasicSetContainer(InternalEObject newContainer) {
		//???
		System.out.println("Set container to "+newContainer);
		
	}

	@Override
	  protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID)
	  {
		  System.out.println("Set container to "+newContainer);
	  }

	@Override
	protected void eBasicSetContainerFeatureID(int newContainerFeatureID)
	  {
	    
	  }

	@Override
	public abstract EClass eClass();

	@Override
	public EObject eContainer() {
		for (ContainmentThing thing: this.containments) {
			return thing.container;
		}
		return null;
	}

	@Override
	public int eContainerFeatureID() {
		EReference ref = eContainmentFeature();
		if (ref == null) {
			return -1;
		}
		return ref.getFeatureID();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		for (ContainmentThing thing: this.containments) {
			return thing.containmentFeature;
		}
		return null;
	}
	


	@Override
	public EReference eContainmentFeature() {
		for (ContainmentThing thing: this.containments) {
			return thing.containmentFeature;
		}
		return null;
	}
	
	@Override
	public Object eGet(EStructuralFeature feature) {
		AttributeHandler<?> handler = getHandler(feature);
		if (handler == null) {
			return feature.isMany() ? Collections.emptyList() : null;
		}
		return handler.getObject();
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return eGet(feature);
	}
	

	
	 @Override
	public InternalEObject eInternalContainer() {
		for (ContainmentThing thing: this.containments) {
			return (InternalEObject)thing.container;
		}
		return null;
	}

	
	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		AttributeHandler<?> handler = getHandler(feature);
		if (handler != null) {
			return handler.isSet();
		}
		return false;
	}

		

	@Override
	public boolean equals(Object other) {
		return (other instanceof VMEObject) && equals((VMEObject)other);
	}

	public boolean equals(VMEObject other) {
		return Objects.equals(this.creator, other.getSourceOrNull()) && Objects.equals(this.identificator, other.getIdentificator());
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {

		AttributeHandler<?> handler = getHandler(feature);
		if (handler instanceof SingleAttributeHandler) {
			((SingleAttributeHandler) handler).set(newValue);
		} else if (handler instanceof MultiAttributeHandler) {
			MultiAttributeHandler mah = (MultiAttributeHandler) handler;
			if (newValue instanceof Collection) {
				((MultiAttributeHandler) handler).setValues((Collection) newValue);
			} else {
				System.err.println("Expected collection instead of " + newValue + " for " + feature.getName() + "!");
			}
		} else if (handler != null) {
			System.err.println("Wrong handler for " + feature.getName() + ": " + hashCode());
		}

	}
	
	@Override
	public NotificationChain eSetResource(Resource.Internal resource, NotificationChain notifications) {
		//System.out.println("Object with id "+id+" has now resource "+resource );
		return super.eSetResource(resource, notifications);
		
	}


	@Override
	public void eUnset(EStructuralFeature feature) {
		AttributeHandler<?> handler = getHandler(feature);
		if (handler != null) {
			handler.unset();
		}

	}

	public Collection<?> getAsCol(EStructuralFeature feat) {
		if (feat.isMany()) {
			return (Collection)eGet(feat);
		} else {
			Object ret = eGet(feat);
			if (ret == null) {
				return Collections.emptyList();
			} else {
				return Collections.singletonList(ret);
			}
		}
	}
	public abstract AttributeHandler<?> getHandler(EStructuralFeature feature);

	@Override
	public Identifier getIdentificator() {
		return this.identificator;
	}
	


	public EObjectManager getManager() {
		return this.owner;
	}

	@Override
	public EObjectCreator getSourceOrNull() {
		return this.creator;
	}

	
	
	@Override
	public int hashCode() {
		return this.hashCode;
	}
	protected String printFeatureValues(EStructuralFeature feature) {
		if (feature.isMany()) {
			return simpleStringValue(eGet(feature));
		} else {
			return simpleStringValue(eGet(feature));
		}
	}
	

	protected String simpleStringValue(Object obj) {
		if (obj instanceof EObject) {
			if (obj instanceof VMEObject) {
				return String.valueOf(((VMEObject)obj).getIdentificator());
			} else {
				return "@"+getManager().getObjName((EObject)obj);
			}
		} else {
			if (obj instanceof Collection) {
				Collection col = (Collection)obj;
				StringBuilder ret = new StringBuilder();
				ret.append("[");
				boolean first = true;
				for (Object sobj: col) {
					if (first) {first=false;} else {ret.append(",");}
					ret.append(simpleStringValue(sobj));
				}
				ret.append("]");
				return ret.toString();
			} else {
				return String.valueOf(obj);
			}
		}
	}

	
	protected <T> AttributeHandler<T> wrapFor(EStructuralFeature feature, MultiAttributeHandler<T> ah) {
		if (feature.isMany()) {
			return ah;
		} else {
			return new MultiSingleAttributeHandler<>(ah);
		}
	}

}
