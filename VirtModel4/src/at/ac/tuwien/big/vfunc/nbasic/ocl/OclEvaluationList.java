package at.ac.tuwien.big.vfunc.nbasic.ocl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.values.TupleValue;

import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.VObjectModelFactory;

import java.util.Objects;
import java.util.Set;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vfunc.nbasic.ecore.DeltaVMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;

public class OclEvaluationList {

	private List<OclAssignment> assignments = new ArrayList<>();
	
	private Map<String, OclAssignment> assignmentMap = new HashMap<>();
	private DeltaVMEObject targetObject;

	private Resource source;
	
	public OclEvaluationList() {
	}
	
	//Automatically flattens. Is that good or not?
	public List<Object> convertOcl(Object start) {
		List<Object> ret = new ArrayList<>();
		if (start instanceof Collection) {
			for (Object o: ((Collection)start)) {
				ret.addAll(convertOcl(o));
			}
		} else {
			//Tuples have special meaning
			if (start instanceof VMEObject) {
				//It's ok
				ret.add(start);
			} else if (start instanceof EObject) { //Not vmeobject
				//wrap into VMEobject
				VMEObject converted = getManager().getFakeVirtual((EObject)start);
				ret.add(converted);
			} else if (start instanceof TupleValue) {
				//Tuple, can be something where objects should be created
				EObjectManager man = getManager();
				Identifier id = man.getIdentifier((TupleValue)start, this);
				ret.add(man.getObject(id));
			} else {
				ret.add(start);
			}
		}
		return ret;
	}

	public void evaluateAll() {
		for (OclAssignment assignment : this.assignments) {
			assignment.refresh();
		}
	}

	public OclAssignment getAssignment(String a) {
		return this.assignmentMap.get(a);
	}

	public EObjectManager getManager() {
		return this.targetObject.getManager();
	}

	public String getNamespace() {
		return this.source==null?null:(this.source.getURI().toString());
	}
	
	public DeltaVMEObject getTarget() {
		return this.targetObject;
	}

	public void init(DeltaVMEObject targetObject, Map<String, Object> initValues, List<OclAssignment> assignments, Resource sourceRes) {
		this.targetObject = targetObject;
		this.source = sourceRes;
		this.assignments.addAll(assignments);
		this.assignments.replaceAll(x->x.basicClone(this));
		Map<String,Object> lastValues = new HashMap<>(initValues);
		for (OclAssignment ass: this.assignments) {
			this.assignmentMap.put(ass.getName(), ass);
			ass.setLastValues(lastValues);
			Map<String,Object>  values = new HashMap<>();
			ass.setValues(values);
			lastValues = values;
		}
	}

}
