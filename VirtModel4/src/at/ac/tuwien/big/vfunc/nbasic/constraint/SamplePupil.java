package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vfunc.nbasic.ConstantValue;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;
import school.Pupil;
import school.SchoolFactory;
import school.SchoolPackage;

public abstract class SamplePupil extends SampleEObject {

	public static final ModelLoader modelLoader = new ModelLoader();

	public static final EClass $PUPIL_CLASS = EcoreFactory.eINSTANCE.createEClass();
	//oder?
	//public static final EClass $PUPIL_CLASS = SchoolPackage.eINSTANCE.getPupil();
	
	public static final EAttribute $NAME_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	public static final EAttribute $INCLASS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	public static final EReference $GRADES_FEATURE = EcoreFactory.eINSTANCE.createEReference();
	static {
		$NAME_FEATURE.setName("name");
		$NAME_FEATURE.setEType(SchoolPackage.eINSTANCE.getCourse_Name().getEAttributeType());
		$INCLASS_FEATURE.setName("inclass");
		$INCLASS_FEATURE.setEType(SchoolPackage.eINSTANCE.getCourse_Name().getEAttributeType());
		$PUPIL_CLASS.getEAttributes().addAll(Arrays.asList($NAME_FEATURE, $INCLASS_FEATURE));
		$PUPIL_CLASS.getEReferences().addAll(Arrays.asList($GRADES_FEATURE));
	}
			

	//Stored objects
	private ConstantValue<String> inclass = new ConstantValue<>(null);
	
	private ConstantValue<String> name = new ConstantValue<>(null);
		
	private NotifyingList<SampleGrade> grades = new NotifyingList<>(new ArrayList<>());
	
	//TODO: Das ist eigentlich subzeugs
	@Override
	public EClass eClass() {
		return $PUPIL_CLASS;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		if (feature == $NAME_FEATURE) {
			return getName();
		} else if (feature == $INCLASS_FEATURE) {
			return getInClass();
		} else if (feature == $GRADES_FEATURE) {
			return getGrades();
		} else {
			//if super is not sampleEObject
			//return super.eGet(feature,true);
			System.err.println("Unknown feature "+feature);
			return feature.isMany()?Collections.emptyList():null;
		} 
	}
	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		if (feature == $NAME_FEATURE) {
			setName((String)newValue);
		} else if (feature == $INCLASS_FEATURE) {
			setInClass((String)newValue);
		} else if (feature == $GRADES_FEATURE) {
			setGrades((List<SampleGrade>)newValue);
		} else {
			//if super is not sampleEObject
			//super.eSet(feature,newValue);
			System.err.println("Unknown feature "+feature);
		} 
	}
	@Override
	public void eUnset(EStructuralFeature feature) {
		if (feature == $NAME_FEATURE) {
			setName(null);
		} else if (feature == $INCLASS_FEATURE) {
			setInClass(null);
		} else if (feature == $GRADES_FEATURE) {
			setGrades(Collections.emptyList());
		} else {
			//if super is not sampleEObject
			//super.eUnset(feature);
			System.err.println("Unknown feature "+feature);
		}
	}
	

	
	public List<SampleGrade> getGrades() {
		return this.grades;
	}

	public String getInClass() {
		return this.inclass.value();
	}

	public String getName() {
		return this.name.value();
	}

	public void setGrades(List<SampleGrade> grades) {
		PatchUtil.applyPatch(this.grades, grades);
	}
	
	public void setInClass(String name) {
		this.inclass.setValue(name);
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public void initDerived() {
		
	}

		
}
