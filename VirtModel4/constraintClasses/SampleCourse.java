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

public class SampleCourse extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements school.Course {
	public static final EClass $SampleCourse_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleCourse_CLASS);
	CEobjectManager.addSupplier($SampleCourse_CLASS,()->new SampleCourse());
	CEobjectManager.addSupplier(school.SchoolPackage.eINSTANCE.getCourse(),()->new SampleCourse());
	$SampleCourse_CLASS.getESuperTypes().add(school.SchoolPackage.eINSTANCE.getCourse());
	$SampleCourse_CLASS.setName("Course_single");
	}
	public static final EAttribute $Course_name = school.SchoolPackage.eINSTANCE.getCourse_Name();
	protected ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		super_eSet($Course_name,newValue);
		this.name.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Course_name) {
	return getName();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Course_name) {
	setName((java.lang.String)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Course_name) {
	setName(null);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Course_name) {
	name.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleCourse_CLASS;
}
public void initDerived() {


}
}
