package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vfunc.nbasic.ecore.AttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectUtil;
import at.ac.tuwien.big.vfunc.nbasic.ecore.MultiAttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.SingleAttributeHandler;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.xmlintelledit.util.AddCopyable;
import at.ac.tuwien.big.xmlintelledit.util.CorrespondingGetter;
import at.ac.tuwien.big.xmlintelledit.util.Spawnable;

public abstract class SampleEObject extends MinimalEObjectImpl implements NotifyableEObject, EObjectUtil, AddCopyable {

	protected Identifier $id;
	protected MyResource res;
	protected List<?> parameters;
	protected boolean wasInitialized = false;
	protected CEobjectManager cmanager;
	private boolean supressSet = false;

	private boolean superGet;
	
	@Override
	public void addToPseudoContainment(Collection<EObject> addObjects) {
		if (this.parameters != null) {
			for (Object o : this.parameters) {
				if (o instanceof EObject) {
					addObjects.add((EObject) o);
				}
			}
		}
	}

	@Override
	public void copyFrom(AddCopyable other, CorrespondingGetter getter) {
		if (other instanceof SampleEObject) {
			SampleEObject so = (SampleEObject) other;
			if (so.parameters != null) {
				// TODO: Das passt nciht, aber hoffentlich egal??
				this.parameters = new ArrayList<>(so.parameters);
				((List) this.parameters).replaceAll((x) -> {
					if (x instanceof AddCopyable) {
						AddCopyable ac = (AddCopyable) x;
						return getter.getCorresponding(ac);
					} else {
						return x;
					}
				});
			}
			this.res = getter.getCorresponding(so.res);
			this.cmanager = getter.getCorresponding(so.cmanager);
			this.$id = so.$id;
			// initDerivedProt();
		}
	}

	@Override
	public Object dynamicGet(int dynamicFeatureID) {
		if (this.superGet) {
			return super.dynamicGet(dynamicFeatureID);
		}
		return eGet(eClass().getEAllStructuralFeatures().get(dynamicFeatureID));
	}
	
	@Override
	public void dynamicSet(int dynamicFeatureID, Object newValue) {
		eSet(eClass().getEAllStructuralFeatures().get(dynamicFeatureID), newValue);
	}

	@Override
	public void dynamicUnset(int dynamicFeatureID) {
		eUnset(eClass().getEAllStructuralFeatures().get(dynamicFeatureID));
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
			return !((Collection) obj).isEmpty();
		}
		return true;
	}

	@Override
	public abstract void eSet(EStructuralFeature feature, Object newValue);

	@Override
	public NotificationChain eSetResource(Resource.Internal resource, NotificationChain notifications) {
		// System.out.println("Object with id "+id+" has now resource "+resource
		// );
		return super.eSetResource(resource, notifications);

	}

	@Override
	public abstract void eUnset(EStructuralFeature feature);

	public Identifier getIdentifier() {
		return this.$id;
	}

	@Override
	public Collection<? extends Spawnable<?>> getSpawned() {
		return this.cmanager != null ? Collections.singleton(this.cmanager) : Collections.emptyList();
	}

	// Just ensure I don't forget it
	public abstract void initDerived();

	protected void initDerivedProt() {

	}

	public void initIdentifier(Identifier id) {
		this.$id = id;
	}

	public void initMyResource(MyResource res, CEobjectManager manager) {
		this.res = res;
		this.cmanager = manager;
	}

	/*
	 * public void initIdentifier(Identifier id) { this.$id = id; }
	 */

	public void initParameters(List<?> parameters) {
		this.parameters = parameters;
	}
	
	public void makeInitialized() {
		this.wasInitialized = true;
	}

	protected Object super_eGet(EStructuralFeature feature) {
		boolean oldSuperGet = this.superGet;
		this.superGet = true;
		Object ret = super.eGet(feature,true,true);
		this.superGet = oldSuperGet;
		return ret;
	}

	protected void super_eSet(EStructuralFeature feature, Object newVal) {
		if (this.supressSet) {
			return;
		}
		boolean curSup = this.supressSet;
		this.supressSet = true;
		super.eSet(feature, newVal);
		this.supressSet = curSup;
	}

	// TODO: ...
	protected void super_eUnset(EStructuralFeature feature) {
		super.eUnset(feature);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(eClass().getName() + ":\n");
		TreeSet<EStructuralFeature> fSet = new TreeSet<>((x, y) -> {
			return (x.getEContainingClass().getName() + "." + x.getName())
					.compareTo(y.getEContainingClass().getName() + "." + y.getName());

		});
		fSet.addAll(eClass().getEAllStructuralFeatures());
		fSet.forEach(x -> {
			builder.append("\t" + x.getEContainingClass().getName() + "." + x.getName() + ": ");
			builder.append(printFeatureValues(x));
			builder.append("\n");
		});
		return builder.toString();
	}

	public boolean wasInitialized() {
		return this.wasInitialized;
	}

}
