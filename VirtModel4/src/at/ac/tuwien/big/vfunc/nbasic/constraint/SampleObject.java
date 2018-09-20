package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import Citizen.Burger;
import at.ac.tuwien.big.vfunc.nbasic.ConstantValue;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclAssignment;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class SampleObject extends SamplePupil {
	
	//Virtual objects
	private Burger cit;
	
	
	public SampleObject() {
		
	}
	public String getInclass_derived() {
		return null;
	}


	public String getName_derived() {
		OclAssignment assignment = new OclAssignment(this.name, featureName, oclExpression, manager)
		return null;
	}

	public void init(Burger cit) {
		this.cit = cit;
	}

}
