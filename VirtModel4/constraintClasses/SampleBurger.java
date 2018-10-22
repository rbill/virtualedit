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

public class SampleBurger extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements Citizen.Burger {
	public static final EClass $SampleBurger_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleBurger_CLASS);
	CEobjectManager.addSupplier($SampleBurger_CLASS,()->new SampleBurger());
	CEobjectManager.addSupplier(Citizen.CitizenPackage.eINSTANCE.getBurger(),()->new SampleBurger());
	$SampleBurger_CLASS.getESuperTypes().add(Citizen.CitizenPackage.eINSTANCE.getBurger());
	$SampleBurger_CLASS.setName("Burger_single");
	}
	public static final EAttribute $Burger_svnr = Citizen.CitizenPackage.eINSTANCE.getBurger_Svnr();
	protected ConstantValue<java.lang.String> svnr = new ConstantValue<>(null);
	public java.lang.String getSvnr() {
		return this.svnr.value();
	}
	public void setSvnr(java.lang.String newValue) {
		super_eSet($Burger_svnr,newValue);
		this.svnr.setValue(newValue);
	}
	public static final EAttribute $Burger_name = Citizen.CitizenPackage.eINSTANCE.getBurger_Name();
	protected ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		super_eSet($Burger_name,newValue);
		this.name.setValue(newValue);
	}
	public static final EAttribute $Burger_address = Citizen.CitizenPackage.eINSTANCE.getBurger_Address();
	protected ConstantValue<java.lang.String> address = new ConstantValue<>(null);
	public java.lang.String getAddress() {
		return this.address.value();
	}
	public void setAddress(java.lang.String newValue) {
		super_eSet($Burger_address,newValue);
		this.address.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Burger_svnr) {
	return getSvnr();
	} else 	if (feature == $Burger_name) {
	return getName();
	} else 	if (feature == $Burger_address) {
	return getAddress();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Burger_svnr) {
	setSvnr((java.lang.String)newValue);
	} else 	if (feature == $Burger_name) {
	setName((java.lang.String)newValue);
	} else 	if (feature == $Burger_address) {
	setAddress((java.lang.String)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Burger_svnr) {
	setSvnr(null);
	} else 	if (feature == $Burger_name) {
	setName(null);
	} else 	if (feature == $Burger_address) {
	setAddress(null);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Burger_svnr) {
	svnr.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Burger_name) {
	name.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Burger_address) {
	address.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleBurger_CLASS;
}
public void initDerived() {


}
}
