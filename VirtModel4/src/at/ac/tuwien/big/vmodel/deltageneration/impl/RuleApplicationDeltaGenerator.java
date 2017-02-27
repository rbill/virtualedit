package at.ac.tuwien.big.vmodel.deltageneration.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import at.ac.tuwien.big.vmodel.deltageneration.DeltaGenerator;
import at.ac.tuwien.big.vmodel.deltageneration.EObjectModification;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.VModelView;

public class RuleApplicationDeltaGenerator implements DeltaGenerator {
	
	private Map<String,List<EObjectModification>> modificationsPerClass = new HashMap<>();
	private VEcoreFile ecoreFile;
	
	public RuleApplicationDeltaGenerator(VEcoreFile ecoreFile) {
		this.ecoreFile = ecoreFile;
	}
	
	public void clearModifications() {
		modificationsPerClass.clear();
	}
	
	private List<EObjectModification> getModifications(String name) {
		List<EObjectModification> ret = modificationsPerClass.get(name);
		if (ret == null) {
			modificationsPerClass.put(name, ret = new ArrayList<EObjectModification>());
		}
		return ret;
	}
	
	public void addModification(EClass cl, EObjectModification modification) {
		for (EClass subcl: ecoreFile.getAllClasses()) {
			if (cl.isSuperTypeOf(subcl) || cl.equals(subcl)) {
				List<EObjectModification> curMod = getModifications(subcl.getName());
				curMod.add(modification);
			}
		}
	}
	

	@Override
	public void applyChanges(VModelView baseModel, VModelView editModel, VModelView deltaModel) {
		List<String> instances = new ArrayList<String>();
		for (String instance: baseModel.getInstances()) {
			instances.add(instance);
		}
		for (String instance: instances) { //TODO: Warum verändert sich das Base-Model? oder ist das ein spurious change?
			String cl = baseModel.getInstances().getClass(instance);
			List<EObjectModification> modifications = getModifications(cl);
			for (EObjectModification mod: modifications) {
				mod.modify(instance,deltaModel.getEObject(instance),baseModel,editModel,deltaModel);
			}
		}
		
	}

}
