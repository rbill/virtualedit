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

public class SampleProvider extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements router.Provider {
	public static final EClass $SampleProvider_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleProvider_CLASS);
	CEobjectManager.addSupplier($SampleProvider_CLASS,()->new SampleProvider());
	CEobjectManager.addSupplier(router.RouterPackage.eINSTANCE.getProvider(),()->new SampleProvider());
	$SampleProvider_CLASS.getESuperTypes().add(router.RouterPackage.eINSTANCE.getProvider());
	$SampleProvider_CLASS.setName("Provider_single");
	}
	public static final EAttribute $Agent_name = router.RouterPackage.eINSTANCE.getAgent_Name();
	protected ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		super_eSet($Agent_name,newValue);
		this.name.setValue(newValue);
	}
	public static final EAttribute $Agent_speed = router.RouterPackage.eINSTANCE.getAgent_Speed();
	protected ConstantValue<java.math.BigInteger> speed = new ConstantValue<>(null);
	public java.math.BigInteger getSpeed() {
		return this.speed.value();
	}
	public void setSpeed(java.math.BigInteger newValue) {
		super_eSet($Agent_speed,newValue);
		this.speed.setValue(newValue);
	}
	public static final EReference $Provider_rightserv = router.RouterPackage.eINSTANCE.getProvider_Rightserv();
	protected ConstantValue<router.Server> rightserv = new ConstantValue<>(null);
	public router.Server getRightserv() {
		return this.rightserv.value();
	}
	public void setRightserv(router.Server newValue) {
		super_eSet($Provider_rightserv,newValue);
		this.rightserv.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Agent_name) {
	return getName();
	} else 	if (feature == $Agent_speed) {
	return getSpeed();
	} else 	if (feature == $Provider_rightserv) {
	return getRightserv();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Agent_name) {
	setName((java.lang.String)newValue);
	} else 	if (feature == $Agent_speed) {
	setSpeed((java.math.BigInteger)newValue);
	} else 	if (feature == $Provider_rightserv) {
	setRightserv((router.Server)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Agent_name) {
	setName(null);
	} else 	if (feature == $Agent_speed) {
	setSpeed(null);
	} else 	if (feature == $Provider_rightserv) {
	setRightserv(null);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Agent_name) {
	name.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Agent_speed) {
	speed.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Provider_rightserv) {
	rightserv.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleProvider_CLASS;
}
public void initDerived() {


}
}
