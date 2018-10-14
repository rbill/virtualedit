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
import org.eclipse.emf.ecore.EcoreFactory;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;

public class SampleAlle extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements Citizen.Alle {
	public static final EClass $SampleAlle_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleAlle_CLASS);
	CEobjectManager.addSupplier($SampleAlle_CLASS,()->new SampleAlle());
	CEobjectManager.addSupplier(Citizen.CitizenPackage.eINSTANCE.getAlle(),()->new SampleAlle());
	$SampleAlle_CLASS.getESuperTypes().add(Citizen.CitizenPackage.eINSTANCE.getAlle());
	$SampleAlle_CLASS.setName("Alle_single");
	}
	public static final EReference $Alle_citizens = Citizen.CitizenPackage.eINSTANCE.getAlle_Citizens();
	protected NotifyingList<Citizen.Burger> citizens = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	public org.eclipse.emf.common.util.EList<Citizen.Burger> getCitizens() {
		return this.citizens;
	}
	public void setCitizens(org.eclipse.emf.common.util.EList<Citizen.Burger> newValue) {
		super_eSet($Alle_citizens,newValue);
		PatchUtil.applyPatch(this.citizens,newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Alle_citizens) {
	return getCitizens();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Alle_citizens) {
	setCitizens((org.eclipse.emf.common.util.EList<Citizen.Burger>)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Alle_citizens) {
	this.citizens.clear();
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Alle_citizens) {
	citizens.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleAlle_CLASS;
}
public void initDerived() {


}
}
