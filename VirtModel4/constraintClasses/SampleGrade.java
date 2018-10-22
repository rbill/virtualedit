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

public class SampleGrade extends at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject implements school.Grade {
	public static final EClass $SampleGrade_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($SampleGrade_CLASS);
	CEobjectManager.addSupplier($SampleGrade_CLASS,()->new SampleGrade());
	CEobjectManager.addSupplier(school.SchoolPackage.eINSTANCE.getGrade(),()->new SampleGrade());
	$SampleGrade_CLASS.getESuperTypes().add(school.SchoolPackage.eINSTANCE.getGrade());
	$SampleGrade_CLASS.setName("Grade_single");
	}
	public static final EReference $Grade_course = school.SchoolPackage.eINSTANCE.getGrade_Course();
	protected ConstantValue<school.Course> course = new ConstantValue<>(null);
	public school.Course getCourse() {
		return this.course.value();
	}
	public void setCourse(school.Course newValue) {
		super_eSet($Grade_course,newValue);
		this.course.setValue(newValue);
	}
	public static final EAttribute $Grade_grade = school.SchoolPackage.eINSTANCE.getGrade_Grade();
	protected ConstantValue<java.math.BigInteger> grade = new ConstantValue<>(null);
	public java.math.BigInteger getGrade() {
		return this.grade.value();
	}
	public void setGrade(java.math.BigInteger newValue) {
		super_eSet($Grade_grade,newValue);
		this.grade.setValue(newValue);
	}
	public static final EAttribute $Grade_year = school.SchoolPackage.eINSTANCE.getGrade_Year();
	protected ConstantValue<java.math.BigInteger> year = new ConstantValue<>(null);
	public java.math.BigInteger getYear() {
		return this.year.value();
	}
	public void setYear(java.math.BigInteger newValue) {
		super_eSet($Grade_year,newValue);
		this.year.setValue(newValue);
	}
@Override
public Object eGet(EStructuralFeature feature) {
	if (feature == $Grade_course) {
	return getCourse();
	} else 	if (feature == $Grade_grade) {
	return getGrade();
	} else 	if (feature == $Grade_year) {
	return getYear();
	} else  {
		System.err.println("Unknown feature" + feature);
		return feature.isMany()?Collections.emptyList():null;

	}
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	if (feature == $Grade_course) {
	setCourse((school.Course)newValue);
	} else 	if (feature == $Grade_grade) {
	setGrade((java.math.BigInteger)newValue);
	} else 	if (feature == $Grade_year) {
	setYear((java.math.BigInteger)newValue);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void eUnset(EStructuralFeature feature) {
	if (feature == $Grade_course) {
	setCourse(null);
	} else 	if (feature == $Grade_grade) {
	setGrade(null);
	} else 	if (feature == $Grade_year) {
	setYear(null);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
	if (feature == $Grade_course) {
	course.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Grade_grade) {
	grade.addBasicChangeListener(refreshMyself);
	} else 	if (feature == $Grade_year) {
	year.addBasicChangeListener(refreshMyself);
	} else  {
		System.err.println("Unknown feature" + feature);
	}
}

@Override
public EClass eClass() {
	return $SampleGrade_CLASS;
}
public void initDerived() {


}
}
