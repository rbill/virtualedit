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
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;

public class SamplePupil extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements school.Pupil {
	public static final EClass $SamplePupil_CLASS = school.SchoolPackage.eINSTANCE.getPupil();
	public static final EAttribute $Pupil_name = school.SchoolPackage.eINSTANCE.getPupil_Name();
	private ConstantValue<java.lang.String> name = new ConstantValue<>(null);
	public java.lang.String getName() {
		return this.name.value();
	}
	public void setName(java.lang.String newValue) {
		this.name.setValue(newValue);
	}
	public static final EAttribute $Pupil_inclass = school.SchoolPackage.eINSTANCE.getPupil_Inclass();
	private ConstantValue<java.lang.String> inclass = new ConstantValue<>(null);
	public java.lang.String getInclass() {
		return this.inclass.value();
	}
	public void setInclass(java.lang.String newValue) {
		this.inclass.setValue(newValue);
	}
	public static final EReference $Pupil_grades = school.SchoolPackage.eINSTANCE.getPupil_Grades();
	private NotifyingList<school.Grade> grades = new NotifyingList<>(new org.eclipse.emf.common.util.BasicEList<>());
	public org.eclipse.emf.common.util.EList<school.Grade> getGrades() {
		return this.grades;
	}
	public void setGrades(org.eclipse.emf.common.util.EList<school.Grade> newValue) {
		PatchUtil.applyPatch(this.grades,newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Pupil_name) {
	return getName();
	} else 	if (feature == $Pupil_inclass) {
	return getInclass();
	} else 	if (feature == $Pupil_grades) {
	return getGrades();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Pupil_name) {
	setName((java.lang.String)newValue);
	} else 	if (feature == $Pupil_inclass) {
	setInclass((java.lang.String)newValue);
	} else 	if (feature == $Pupil_grades) {
	setGrades((org.eclipse.emf.common.util.EList<school.Grade>)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Pupil_name) {
	setName(null);
	} else 	if (feature == $Pupil_inclass) {
	setInclass(null);
	} else 	if (feature == $Pupil_grades) {
	this.grades.clear();
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Pupil_name) {
	name.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Pupil_inclass) {
	inclass.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Pupil_grades) {
	grades.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SamplePupil_CLASS;
}
public void initDerived() {


}
}
