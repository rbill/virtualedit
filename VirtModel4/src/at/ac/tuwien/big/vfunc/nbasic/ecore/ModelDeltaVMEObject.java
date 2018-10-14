package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.DeltaVMEObjectStore;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;

public class ModelDeltaVMEObject extends DeltaVMEObject {
	
	public ModelDeltaVMEObject(EObjectManager manager, EObjectCreator creator, Identifier id, EClass eclass,
			DeltaVMEObjectStore store, List<?> parameters) {
		super(manager, creator, id, eclass, store, parameters);
	}
	

	public ModelDeltaVMEObject(EObjectManager manager, EObjectCreator creator, Identifier id, EClass eclass, List<?> parameters) {
		this(manager,creator,id,eclass,manager.getDeltaStore(id), parameters);
	}
	

	private List<VMEObject> baseEObjects = new ArrayList<>();
	private Map<EStructuralFeature, Map<AbstractFunc<?, ?, ? extends QueryResult<?, ?>>, Integer>> featureFuncMap = new HashMap<>(); 
	
	public void setBaseEObject(VMEObject newBase) {
		if (baseEObjects.isEmpty()) {
			addBaseEObject(newBase);
		} else if (baseEObjects.contains(newBase)) {
			for (VMEObject base: new ArrayList<>(baseEObjects)) { 
				if (!Objects.equals(base, newBase)) {
					removeBaseEObject(base);
				}
			}
		} else {
			for (VMEObject base: new ArrayList<>(baseEObjects)) {
				removeBaseEObject(base);
			}
			addBaseEObject(newBase);
		}
	}
	
	public void addBaseEObject(VMEObject base) {
		if (!(base instanceof DeltaVMEObject)) {
			System.err.println("I can only add DeltaVMEObjects as base!");
			throw new UnsupportedOperationException("I can only add DeltaVMEObjects as base!");
		}
		if (baseEObjects.contains(base)) {
			return;
		}
		baseEObjects.add(base);
		DeltaVMEObject avo = (DeltaVMEObject)base;
		for (EStructuralFeature feat: eClass().getEAllStructuralFeatures()) {
			AbstractFunc<?, ?, ? extends QueryResult<?, ?>> treeposFuncOrNull = avo.getHandler(feat).getTreeposFuncOrNull();
			if (treeposFuncOrNull != null) {
				if ((int)featureFuncMap.computeIfAbsent(feat, x->new HashMap<>()).merge(treeposFuncOrNull, 1, (x,y)->x+y) == 1) {
					addBasicFeature(feat, (AbstractFunc)treeposFuncOrNull);
				}
			} else {
				System.err.println("Function for "+feat+" for object "+avo.getIdentificator()+" not found!");
			}
		}
	}
	
	public void removeBaseEObject(VMEObject base) {
		if (!(base instanceof DeltaVMEObject)) {
			System.err.println("I can only add DeltaVMEObjects as base!");
			return;
		}
		if (baseEObjects.remove(base)) {
		DeltaVMEObject avo = (DeltaVMEObject)base;
		for (EStructuralFeature feat: eClass().getEAllStructuralFeatures()) {		
			AbstractFunc<?, ?, ? extends QueryResult<?, ?>> treeposFuncOrNull = avo.getHandler(feat).getTreeposFuncOrNull();
			if (treeposFuncOrNull != null) {
				if ((int)featureFuncMap.computeIfAbsent(feat, x->new HashMap<>()).merge(treeposFuncOrNull, -1, (x,y)->x+y) <= 0) {
					removeBasicFeature(feat, (AbstractFunc)treeposFuncOrNull);
				}
			} else {
				System.err.println("Function for "+feat+" for object "+avo.getIdentificator()+" not found!");
			}
		}
		}
	}


	public List<VMEObject> getBaseObjects() {
		return baseEObjects;
	}

}
