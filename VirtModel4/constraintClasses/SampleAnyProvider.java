package constraintClasses;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import at.ac.tuwien.big.vfunc.nbasic.ConstantValue;
import at.ac.tuwien.big.vfunc.nbasic.constraint.NotifyingList;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ListRepeater;
import org.eclipse.emf.ecore.EcoreFactory;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;

public class SampleAnyProvider extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements requirements.AnyProvider {
	public static final EClass $SampleAnyProvider_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleAnyProvider_CLASS);
	CEobjectManager.addSupplier($SampleAnyProvider_CLASS,()->new SampleAnyProvider());
	CEobjectManager.addSupplier(requirements.RequirementsPackage.eINSTANCE.getAnyProvider(),()->new SampleAnyProvider());
	$SampleAnyProvider_CLASS.getESuperTypes().add(requirements.RequirementsPackage.eINSTANCE.getAnyProvider());
	$SampleAnyProvider_CLASS.setName("AnyProvider_single");
	}
	public static final EAttribute $SomeDevice_name = requirements.RequirementsPackage.eINSTANCE.getSomeDevice_Name();
	protected ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		super_eSet($SomeDevice_name,newValue);
		this.name.setValue(newValue);
	}
	public static final EAttribute $SomeDevice_speed = requirements.RequirementsPackage.eINSTANCE.getSomeDevice_Speed();
	protected ConstantValue<java.lang.Integer> speed = new ConstantValue<>(null);
	public java.lang.Integer getSpeed() {
		return this.speed.value();
	}
	public void setSpeed(java.lang.Integer newValue) {
		super_eSet($SomeDevice_speed,newValue);
		this.speed.setValue(newValue);
	}
	public static final EReference $AnyProvider_providedServices = requirements.RequirementsPackage.eINSTANCE.getAnyProvider_ProvidedServices();
	protected NotifyingList<requirements.Service> providedServices = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	{providedServices.addListChangeListener(new ListRepeater<>((java.util.List)super_eGet($AnyProvider_providedServices)));}
	public org.eclipse.emf.common.util.EList<requirements.Service> getProvidedServices() {
		return this.providedServices;
	}
	public void setProvidedServices(org.eclipse.emf.common.util.EList<requirements.Service> newValue) {
		super_eSet($AnyProvider_providedServices,newValue);
		PatchUtil.applyPatch(this.providedServices,newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $SomeDevice_name) {
	return getName();
	} else 	if (feature == $SomeDevice_speed) {
	return getSpeed();
	} else 	if (feature == $AnyProvider_providedServices) {
	return getProvidedServices();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $SomeDevice_name) {
	setName((java.lang.String)newValue);
	} else 	if (feature == $SomeDevice_speed) {
	setSpeed((java.lang.Integer)newValue);
	} else 	if (feature == $AnyProvider_providedServices) {
	setProvidedServices((org.eclipse.emf.common.util.EList<requirements.Service>)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $SomeDevice_name) {
	setName(null);
	} else 	if (feature == $SomeDevice_speed) {
	setSpeed(null);
	} else 	if (feature == $AnyProvider_providedServices) {
	this.providedServices.clear();
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $SomeDevice_name) {
	name.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $SomeDevice_speed) {
	speed.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $AnyProvider_providedServices) {
	providedServices.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleAnyProvider_CLASS;
}
public void initDerived() {


}
}
