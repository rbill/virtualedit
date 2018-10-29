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

public class SampleConsumer extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements requirements.Consumer {
	public static final EClass $SampleConsumer_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleConsumer_CLASS);
	CEobjectManager.addSupplier($SampleConsumer_CLASS,()->new SampleConsumer());
	CEobjectManager.addSupplier(requirements.RequirementsPackage.eINSTANCE.getConsumer(),()->new SampleConsumer());
	$SampleConsumer_CLASS.getESuperTypes().add(requirements.RequirementsPackage.eINSTANCE.getConsumer());
	$SampleConsumer_CLASS.setName("Consumer_single");
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
	public static final EReference $Consumer_requiredServices = requirements.RequirementsPackage.eINSTANCE.getConsumer_RequiredServices();
	protected ConstantValue<requirements.Service> requiredServices = new ConstantValue<>(null);
	public requirements.Service getRequiredServices() {
		return this.requiredServices.value();
	}
	public void setRequiredServices(requirements.Service newValue) {
		super_eSet($Consumer_requiredServices,newValue);
		this.requiredServices.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $SomeDevice_name) {
	return getName();
	} else 	if (feature == $SomeDevice_speed) {
	return getSpeed();
	} else 	if (feature == $Consumer_requiredServices) {
	return getRequiredServices();
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
	} else 	if (feature == $Consumer_requiredServices) {
	setRequiredServices((requirements.Service)newValue);
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
	} else 	if (feature == $Consumer_requiredServices) {
	setRequiredServices(null);
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
	} else 	if (feature == $Consumer_requiredServices) {
	requiredServices.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleConsumer_CLASS;
}
public void initDerived() {


}
}
