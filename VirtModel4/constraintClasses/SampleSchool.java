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

public class SampleSchool extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements school.School {
	public static final EClass $SampleSchool_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleSchool_CLASS);
	CEobjectManager.addSupplier($SampleSchool_CLASS,()->new SampleSchool());
	CEobjectManager.addSupplier(school.SchoolPackage.eINSTANCE.getSchool(),()->new SampleSchool());
	$SampleSchool_CLASS.getESuperTypes().add(school.SchoolPackage.eINSTANCE.getSchool());
	$SampleSchool_CLASS.setName("School_single");
	}
	public static final EReference $School_pupils = school.SchoolPackage.eINSTANCE.getSchool_Pupils();
	protected NotifyingList<school.impl.PupilImpl> pupils = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	{pupils.addListChangeListener(new ListRepeater<>((java.util.List)super_eGet($School_pupils)));}
	public org.eclipse.emf.common.util.EList<school.impl.PupilImpl> getPupils() {
		return this.pupils;
	}
	public void setPupils(org.eclipse.emf.common.util.EList<school.impl.PupilImpl> newValue) {
		super_eSet($School_pupils,newValue);
		PatchUtil.applyPatch(this.pupils,newValue);
	}
	public static final EReference $School_courses = school.SchoolPackage.eINSTANCE.getSchool_Courses();
	protected NotifyingList<school.Course> courses = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	{courses.addListChangeListener(new ListRepeater<>((java.util.List)super_eGet($School_courses)));}
	public org.eclipse.emf.common.util.EList<school.Course> getCourses() {
		return this.courses;
	}
	public void setCourses(org.eclipse.emf.common.util.EList<school.Course> newValue) {
		super_eSet($School_courses,newValue);
		PatchUtil.applyPatch(this.courses,newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $School_pupils) {
	return getPupils();
	} else 	if (feature == $School_courses) {
	return getCourses();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $School_pupils) {
	setPupils((org.eclipse.emf.common.util.EList<school.impl.PupilImpl>)newValue);
	} else 	if (feature == $School_courses) {
	setCourses((org.eclipse.emf.common.util.EList<school.Course>)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $School_pupils) {
	this.pupils.clear();
	} else 	if (feature == $School_courses) {
	this.courses.clear();
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $School_pupils) {
	pupils.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $School_courses) {
	courses.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleSchool_CLASS;
}
public void initDerived() {


}
}
