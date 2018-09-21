package at.ac.tuwien.big.vfunc.nbasic.constraint;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import Citizen.Burger;
import Citizen.CitizenPackage;
import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;

public class SampleObject extends SamplePupil {
	
	//Virtual objects
	private Burger cit;
	
	public static final EClass $SAMPLE_OBJECT_CLASS = EcoreFactory.eINSTANCE.createEClass();
	public static final EReference $CIT_REFERENCE = EcoreFactory.eINSTANCE.createEReference();
	static {
		//Typedef funktioniert nicht bei derivtem
		//Da kann man einfach JavaObject nehmen, denke ich
		$SAMPLE_OBJECT_CLASS.setName("SampleObject");
		$SAMPLE_OBJECT_CLASS.getESuperTypes().add(SamplePupil.$PUPIL_CLASS);
		$CIT_REFERENCE.setName("cit");
		$CIT_REFERENCE.setEType(CitizenPackage.eINSTANCE.getBurger());
		
		//Variables are a bit more difficult ...
		//Let's ignore them for now
		
		//And add them to the expression
		//I can have an expression generator which generates based on the actual types
		
		//If multi
		$CIT_REFERENCE.setUpperBound(-1);
		$SAMPLE_OBJECT_CLASS.getEReferences().add($CIT_REFERENCE);
	}
	
	public SampleObject() {

	}
	
	
	public void initDerived() {
		super.initDerived();
		
		this.cit = (Burger)parameters.get(0);
		
		{
			OclDerivationEvaluable evaluable = new OclDerivationEvaluable("cit.name", null);
			OclDerivationEvaluableState state = evaluable.getState(res, this);
			state.addChangeListener(newNameListener);
			//Brauche ich das?
		}
		{
			OclDerivationEvaluable evaluable = new OclDerivationEvaluable("cit.address", null);
			OclDerivationEvaluableState state = evaluable.getState(res, this);
			state.addChangeListener(newInclassListener);
		}
	}
	
	private NewValueListenable<Object> newInclassListener = new NewValueListenable<Object>() {

		@Override
		public void changed(Object oldValue, Object newValue) {
			//For every simple attribute
			if (newValue == null || newValue instanceof String) {
				name_inclass = (String)newValue;
				//This is only for simple things, for other things it gets more complex
				//Multi-Attributes:
				// PatchUtil.applyPatch(name_inclass, newValue);
				//Single-Valued references:
				//I must convert the type, i.e. not check it before
				// name_inclass = convertTupleValue(newValue);
				//Multi-valued references:
				//Again I must convert, but make both
				// List newList = convertTupleValueList(newValue);
				// PatchUtil.applyPatch(name_inclass, newList);
				
				//Hier brauche ich ja auch einen Manager, aber anders ...
				
			} else {
				System.err.println("Got wrong type "+newValue);
			}
			
		}
	};

	private String name_inclass;
	
	
	public String getInclass_derived() {
		return name_inclass;
	}

	private String name_derived;
	
	private NewValueListenable<Object> newNameListener = new NewValueListenable<Object>() {

		@Override
		public void changed(Object oldValue, Object newValue) {
			//For every simple attribute
			if (newValue == null || newValue instanceof String) {
				name_derived = (String)newValue;
			} else {
				System.err.println("Got wrong type "+newValue);
			}
			
		}
	};

	public String getName_derived() {
		return name_derived;
	}

	
	public EClass eClass() {
		return $SAMPLE_OBJECT_CLASS;
	}

}
