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

public class SampleCable extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements router.Cable {
	public static final EClass $SampleCable_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleCable_CLASS);
	CEobjectManager.addSupplier($SampleCable_CLASS,()->new SampleCable());
	CEobjectManager.addSupplier(router.RouterPackage.eINSTANCE.getCable(),()->new SampleCable());
	$SampleCable_CLASS.getESuperTypes().add(router.RouterPackage.eINSTANCE.getCable());
	$SampleCable_CLASS.setName("Cable_single");
	}
	public static final EAttribute $Cable_name = router.RouterPackage.eINSTANCE.getCable_Name();
	protected ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		super_eSet($Cable_name,newValue);
		this.name.setValue(newValue);
	}
	public static final EAttribute $Cable_speed = router.RouterPackage.eINSTANCE.getCable_Speed();
	protected ConstantValue<java.math.BigInteger> speed = new ConstantValue<>(null);
	public java.math.BigInteger getSpeed() {
		return this.speed.value();
	}
	public void setSpeed(java.math.BigInteger newValue) {
		super_eSet($Cable_speed,newValue);
		this.speed.setValue(newValue);
	}
	public static final EReference $Cable_source = router.RouterPackage.eINSTANCE.getCable_Source();
	protected ConstantValue<router.Device> source = new ConstantValue<>(null);
	public router.Device getSource() {
		return this.source.value();
	}
	public void setSource(router.Device newValue) {
		super_eSet($Cable_source,newValue);
		this.source.setValue(newValue);
	}
	public static final EReference $Cable_target = router.RouterPackage.eINSTANCE.getCable_Target();
	protected ConstantValue<router.Device> target = new ConstantValue<>(null);
	public router.Device getTarget() {
		return this.target.value();
	}
	public void setTarget(router.Device newValue) {
		super_eSet($Cable_target,newValue);
		this.target.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Cable_name) {
	return getName();
	} else 	if (feature == $Cable_speed) {
	return getSpeed();
	} else 	if (feature == $Cable_source) {
	return getSource();
	} else 	if (feature == $Cable_target) {
	return getTarget();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Cable_name) {
	setName((java.lang.String)newValue);
	} else 	if (feature == $Cable_speed) {
	setSpeed((java.math.BigInteger)newValue);
	} else 	if (feature == $Cable_source) {
	setSource((router.Device)newValue);
	} else 	if (feature == $Cable_target) {
	setTarget((router.Device)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Cable_name) {
	setName(null);
	} else 	if (feature == $Cable_speed) {
	setSpeed(null);
	} else 	if (feature == $Cable_source) {
	setSource(null);
	} else 	if (feature == $Cable_target) {
	setTarget(null);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Cable_name) {
	name.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Cable_speed) {
	speed.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Cable_source) {
	source.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Cable_target) {
	target.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleCable_CLASS;
}
public void initDerived() {


}
}
