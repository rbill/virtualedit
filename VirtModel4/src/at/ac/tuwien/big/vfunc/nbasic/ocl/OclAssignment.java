package at.ac.tuwien.big.vfunc.nbasic.ocl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicMetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.BasicResultImpl;
import at.ac.tuwien.big.vfunc.nbasic.Replacer;
import at.ac.tuwien.big.vfunc.nbasic.ecore.DeltaVMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class OclAssignment extends BasicResultImpl<Object> {

	private String name;
	private String oclExpression;
	private EStructuralFeature featureName;
	private Map<String,Object> lastMap = new HashMap<>();
	private Map<String,Object> curMap = new HashMap<>();
	private OclEvaluationList manager;
	private boolean firstEval = true;
	private List objectList;
	
	private Object valueRefresher;
	
	private BasicListenable refreshMyself = new BasicListenable() {

		@Override
		public void changed(BasicChangeNotifyer bcm) {
			OclAssignment.this.refresh();
		}
		
	};
	
	public OclAssignment(String name, EStructuralFeature featureName, String oclExpression, OclEvaluationList manager) {
		super(new BasicMetaInfo());
		this.name = name;
		this.featureName = featureName;
		this.oclExpression = oclExpression;
		this.manager = manager;
	}
	
	public OclAssignment basicClone(OclEvaluationList newManager) {
		return new OclAssignment(this.name, this.featureName, this.oclExpression, newManager);
	}
	
	@Override
	public Object calcValue() {
		String variable = getName();
		String expr = getOclExpression();
		
		Map<String, Object> myMap = getLastMap();
		OCLExpressionEvaluationState state = new OCLExpressionEvaluationState(expr, myMap);
		Object ret = state.evaluate();
		Map<String, Object> nextMap = getCurMap();
		nextMap.putAll(myMap);
		nextMap.put(variable, ret);
		
		for (Pair<String, Object> pair : state.getVariableObjects()) {
			OclAssignment depOn = this.manager.getAssignment(pair.getA()); 
			if (depOn == null) {continue;}
			if (pair.getB() == null || Objects.equals(pair.getB(), myMap.get(pair.getA()))) {
				// Assume it is relevant?
				depOn.addBasicChangeListener(this.refreshMyself);
			} else {
				depOn.removeBasicChangeListener(this.refreshMyself);
			}
		}

		for (Entry<Object, Set> props : state.getProperties().entrySet()) {
			if (!(props.getKey() instanceof VMEObject)) {
				// Can't do anything
				continue;
			}
			VMEObject vme = (VMEObject) props.getKey();
			for (Object esf: props.getValue()) {
				//If this changes, re-evaluate this!
				if (!(esf instanceof EStructuralFeature)) {
					System.err.println("Strange property: "+esf);
					continue;
				}
				EStructuralFeature resf = (EStructuralFeature)esf;
				vme.addListener(resf, this.refreshMyself);
			}
		}
		if (this.firstEval && this.featureName != null) {
			this.firstEval = false;
			//Ich brauche eine liste die, wenn ich sie patche, die untenliegende Liste patcht
			DeltaVMEObject dv = this.manager.getTarget();
			this.objectList = dv.addBasicListFeature(this.featureName);
			//TODO: Brauche ich hier noch einmal einen Listener? ich glaube nicht
		}
		if (this.objectList != null) {
			List<Object> convertedList = this.manager.convertOcl(ret);
			PatchUtil.applyPatch(this.objectList, convertedList);
		}
		return ret;
	}

	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		System.err.println("NOT Implemented");
		return null;
	}

	public Map<String,Object> getCurMap() {
		return this.curMap;
	}
	
	public Map<String,Object> getLastMap() {
		return this.lastMap;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getOclExpression() {
		return this.oclExpression;
	}

	public void setLastValues(Map<String, Object> lastValues) {
		this.lastMap = lastValues;
	}

	public void setValues(Map<String, Object> values) {
		this.curMap = values;
	}
}
