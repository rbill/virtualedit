package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclAssignment;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclEvaluationList;
import at.ac.tuwien.big.virtlang.virtLang.BasicOCLExpression;
import at.ac.tuwien.big.virtlang.virtLang.ClassRef;
import at.ac.tuwien.big.virtlang.virtLang.Definition;
import at.ac.tuwien.big.virtlang.virtLang.Expression;
import at.ac.tuwien.big.virtlang.virtLang.FeatureAssignment;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.virtlang.virtLang.ParameterType;
import at.ac.tuwien.big.virtlang.virtLang.VarDefinition;

public class ObjectCreatorCreator implements EObjectCreator {
	
	public static String getExprString(Expression expr) {
		if (expr instanceof BasicOCLExpression) {
			return ((BasicOCLExpression)expr).getExpression();
		}
		throw new UnsupportedOperationException("Unknown expression type "+expr+"!");
	}
	ObjectCreator creator;
	
	EObjectManager manager;
	
	public ObjectCreatorCreator(EObjectManager manager, ObjectCreator creator) {
		this.creator = creator;
		this.manager = manager;
	}
	
	@Override
	public VMEObject createEObject(Identifier ide, Object... parameters) {
		Map<String,Object> valuesMap = new HashMap<>();
		for (int i = 0; i < Math.min(parameters.length, this.creator.getPars().size()); ++i) {
			ParameterType pt = this.creator.getPars().get(i);
			String name = pt.getName();
			valuesMap.put(name, parameters[i]);
		}
		ClassRef cr = this.creator.getClassName();
		EClass ecl = this.manager.getEClass(cr);
		List<OclAssignment> assignments = new ArrayList<>();
		OclEvaluationList oclman = new OclEvaluationList();
		for (Definition def: this.creator.getDef()) {
			if (def instanceof VarDefinition) {
				VarDefinition vd = (VarDefinition)def;
				String varName = vd.getName();
				OclAssignment oa = new OclAssignment(varName, null, getExprString(vd.getExpr()), oclman);
				assignments.add(oa);
			} else if (def instanceof FeatureAssignment) {
				FeatureAssignment fa = (FeatureAssignment)def;
				String featureName = fa.getName();
				EStructuralFeature feature = ecl.getEStructuralFeature(featureName);
				OclAssignment oa = new OclAssignment(null, feature, getExprString(fa.getExpr()), oclman);
				assignments.add(oa);
			} else {
				System.err.println("Unknown "+def);
			}
		}
		DeltaVMEObject targetObject = new DeltaVMEObject(this.manager, this, ide, ecl, Arrays.asList(parameters));
		oclman.init(targetObject, valuesMap, assignments, this.creator.eResource());
		oclman.evaluateAll();
		return targetObject;
	}

	public ObjectCreator getCreator() {
		return this.creator;
	}

	@Override
	public CreatorId getName() {
		CreatorId ret = VObjectModelFactory.eINSTANCE.createCreatorId();
		ret.setNamespace(this.creator.eResource().getURI().toString());
		ret.setName(this.creator.getName());
		return ret;
	}

}
