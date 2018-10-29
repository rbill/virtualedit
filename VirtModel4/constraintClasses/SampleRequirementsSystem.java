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

public class SampleRequirementsSystem extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements requirements.RequirementsSystem {
	public static final EClass $SampleRequirementsSystem_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleRequirementsSystem_CLASS);
	CEobjectManager.addSupplier($SampleRequirementsSystem_CLASS,()->new SampleRequirementsSystem());
	CEobjectManager.addSupplier(requirements.RequirementsPackage.eINSTANCE.getRequirementsSystem(),()->new SampleRequirementsSystem());
	$SampleRequirementsSystem_CLASS.getESuperTypes().add(requirements.RequirementsPackage.eINSTANCE.getRequirementsSystem());
	$SampleRequirementsSystem_CLASS.setName("RequirementsSystem_single");
	}
	public static final EReference $RequirementsSystem_provider = requirements.RequirementsPackage.eINSTANCE.getRequirementsSystem_Provider();
	protected NotifyingList<requirements.AnyProvider> provider = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	{provider.addListChangeListener(new ListRepeater<>((java.util.List)super_eGet($RequirementsSystem_provider)));}
	public org.eclipse.emf.common.util.EList<requirements.AnyProvider> getProvider() {
		return this.provider;
	}
	public void setProvider(org.eclipse.emf.common.util.EList<requirements.AnyProvider> newValue) {
		super_eSet($RequirementsSystem_provider,newValue);
		PatchUtil.applyPatch(this.provider,newValue);
	}
	public static final EReference $RequirementsSystem_consumer = requirements.RequirementsPackage.eINSTANCE.getRequirementsSystem_Consumer();
	protected NotifyingList<requirements.AnyConsumer> consumer = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	{consumer.addListChangeListener(new ListRepeater<>((java.util.List)super_eGet($RequirementsSystem_consumer)));}
	public org.eclipse.emf.common.util.EList<requirements.AnyConsumer> getConsumer() {
		return this.consumer;
	}
	public void setConsumer(org.eclipse.emf.common.util.EList<requirements.AnyConsumer> newValue) {
		super_eSet($RequirementsSystem_consumer,newValue);
		PatchUtil.applyPatch(this.consumer,newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $RequirementsSystem_provider) {
	return getProvider();
	} else 	if (feature == $RequirementsSystem_consumer) {
	return getConsumer();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $RequirementsSystem_provider) {
	setProvider((org.eclipse.emf.common.util.EList<requirements.AnyProvider>)newValue);
	} else 	if (feature == $RequirementsSystem_consumer) {
	setConsumer((org.eclipse.emf.common.util.EList<requirements.AnyConsumer>)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $RequirementsSystem_provider) {
	this.provider.clear();
	} else 	if (feature == $RequirementsSystem_consumer) {
	this.consumer.clear();
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $RequirementsSystem_provider) {
	provider.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $RequirementsSystem_consumer) {
	consumer.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleRequirementsSystem_CLASS;
}
public void initDerived() {


}
}
