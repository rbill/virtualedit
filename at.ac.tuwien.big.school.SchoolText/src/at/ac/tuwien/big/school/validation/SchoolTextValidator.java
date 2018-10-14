package at.ac.tuwien.big.school.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;

public class SchoolTextValidator extends AbstractSchoolTextValidator {
	
	//TODO: should not be static ...
	private static HashMap<String, List<VMEObject>> admissibleObjects = new HashMap<>(); 
	
	public static final String CHANGE_ORIGIN ="CHANGE_ORIGIN";
	public static final String RESET ="RESET_VME";
	public static final String RESET_PARTIAL ="RESET_VME_PARTIAL";
	
	public static VMEObject getEObject(String name, String index) {
		try {
			return getEObject(name, Integer.valueOf(index));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static VMEObject getEObject(String name, int index) {
		List<VMEObject> ret = admissibleObjects.computeIfAbsent(name, x->new ArrayList<>());
		if (index >= 0 && index < ret.size()) {
			return ret.get(index);
		}
		return null;
	}
	
	@Check(CheckType.FAST)
	public void offerBindings(EObject eobj) {
		if (eobj == null) {return;}
		try {
			EClass cl = eobj.eClass();
			EObjectManager instance = EObjectManager.getInstance();
			List<VMEObject> admissible = instance.getAllAdmissible(cl);
			String name = cl.getEPackage().getName()+"_"+cl.getName();
			admissibleObjects.put(name,admissible);
			int index = 0;
			for (VMEObject vobj: admissible) {
				warning("Set origin to "+vobj.getIdentificator(),eobj,null,CHANGE_ORIGIN,name,""+index,eobj.eResource().getURIFragment(eobj));
				++index;
			}
			warning("Reset custom", eobj, null, RESET, name,""+index,eobj.eResource().getURIFragment(eobj));
			warning("Reset partial custom", eobj, null, RESET_PARTIAL, name,""+index,eobj.eResource().getURIFragment(eobj));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not offer: "+e.getMessage());
		}
	}
}
