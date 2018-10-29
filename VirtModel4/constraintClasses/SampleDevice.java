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

public class SampleDevice extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements router.Device {
	public static final EClass $SampleDevice_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleDevice_CLASS);
	CEobjectManager.addSupplier($SampleDevice_CLASS,()->new SampleDevice());
	CEobjectManager.addSupplier(router.RouterPackage.eINSTANCE.getDevice(),()->new SampleDevice());
	$SampleDevice_CLASS.getESuperTypes().add(router.RouterPackage.eINSTANCE.getDevice());
	$SampleDevice_CLASS.setName("Device_single");
	}
	public static final EReference $Device_outgoing = router.RouterPackage.eINSTANCE.getDevice_Outgoing();
	protected NotifyingList<router.Cable> outgoing = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	{outgoing.addListChangeListener(new ListRepeater<>((java.util.List)super_eGet($Device_outgoing)));}
	public org.eclipse.emf.common.util.EList<router.Cable> getOutgoing() {
		return this.outgoing;
	}
	public void setOutgoing(org.eclipse.emf.common.util.EList<router.Cable> newValue) {
		super_eSet($Device_outgoing,newValue);
		PatchUtil.applyPatch(this.outgoing,newValue);
	}
	public static final EReference $Device_incoming = router.RouterPackage.eINSTANCE.getDevice_Incoming();
	protected NotifyingList<router.Cable> incoming = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	public org.eclipse.emf.common.util.EList<router.Cable> getIncoming() {
		return this.incoming;
	}
	public void setIncoming(org.eclipse.emf.common.util.EList<router.Cable> newValue) {
		super_eSet($Device_incoming,newValue);
		PatchUtil.applyPatch(this.incoming,newValue);
	}
	public static final EAttribute $Device_name = router.RouterPackage.eINSTANCE.getDevice_Name();
	protected ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		super_eSet($Device_name,newValue);
		this.name.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Device_outgoing) {
	return getOutgoing();
	} else 	if (feature == $Device_incoming) {
	return getIncoming();
	} else 	if (feature == $Device_name) {
	return getName();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Device_outgoing) {
	setOutgoing((org.eclipse.emf.common.util.EList<router.Cable>)newValue);
	} else 	if (feature == $Device_incoming) {
	setIncoming((org.eclipse.emf.common.util.EList<router.Cable>)newValue);
	} else 	if (feature == $Device_name) {
	setName((java.lang.String)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Device_outgoing) {
	this.outgoing.clear();
	} else 	if (feature == $Device_incoming) {
	this.incoming.clear();
	} else 	if (feature == $Device_name) {
	setName(null);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Device_outgoing) {
	outgoing.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Device_incoming) {
	incoming.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Device_name) {
	name.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleDevice_CLASS;
}
public void initDerived() {


}
}
