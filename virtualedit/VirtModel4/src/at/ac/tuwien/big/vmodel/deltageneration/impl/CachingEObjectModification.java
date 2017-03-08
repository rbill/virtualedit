package at.ac.tuwien.big.vmodel.deltageneration.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.vmodel.deltageneration.EObjectModification;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.VModelView;

public abstract class CachingEObjectModification implements EObjectModification {
	
	private Map<String,List<List<String>>> createdUUIDs = new HashMap<>();
	
	
	private List<String> getCreatedUUIDs(String forUUID, int type) {
		List<List<String>> list = createdUUIDs.get(forUUID);
		if (list == null) {
			createdUUIDs.put(forUUID, list = new ArrayList<>());
		}
		while (list.size() <= type) {
			list.add(new ArrayList<String>());
		}
		return list.get(type);
	}
	
	public String getCreatedId(String parameter, int type, int index) {
		List<String> uuids = getCreatedUUIDs(parameter,type);
		while (uuids.size()<=index) {
			uuids.add(UUID.randomUUID().toString());
		}
		return uuids.get(index);
	}
	
	public EObject createObject(String parameter, EClass cl, int type, int index, VModelView deltaModel) {
		String createdId = getCreatedId(parameter, type, index);
		deltaModel.getInstances().add(createdId);
		deltaModel.getInstances().setClass(createdId, deltaModel.getEcore().getName(cl));
		return deltaModel.getEObject(createdId);
	}

	@Override
	public abstract void modify(String uuid, EObject eobj, VModelView baseModel, VModelView editModel, VModelView deltaModel);

}
