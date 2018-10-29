package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.awt.color.CMMException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;
import at.ac.tuwien.big.util.SetUtils;
import at.ac.tuwien.big.vfunc.nbasic.constraint.OclExpressionGetter;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclAssignment;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclEvaluationList;
import at.ac.tuwien.big.vfunc.nbasic.ocl.TracingEvaluationVisitor;
import at.ac.tuwien.big.virtlang.virtLang.BasicOCLExpression;
import at.ac.tuwien.big.virtlang.virtLang.ClassRef;
import at.ac.tuwien.big.virtlang.virtLang.Definition;
import at.ac.tuwien.big.virtlang.virtLang.Expression;
import at.ac.tuwien.big.virtlang.virtLang.FeatureAssignment;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.virtlang.virtLang.ParameterType;
import at.ac.tuwien.big.virtlang.virtLang.Selection;
import at.ac.tuwien.big.virtlang.virtLang.VarDefinition;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class ObjectCreatorCreator implements EObjectCreator {
	
	static OCL ocl;
	static Helper oclHelper;
	
	static {
		ocl = OCL.newInstance();
		oclHelper = ocl.createOCLHelper();
	}
	
	private static final EcoreEnvironmentFactory fact = EcoreEnvironmentFactory.INSTANCE;
	
	
	public static String getExprString(Expression expr) {
		if (expr instanceof BasicOCLExpression) {
			return ((BasicOCLExpression)expr).getExpression();
		}
		throw new UnsupportedOperationException("Unknown expression type "+expr+"!");
	}
	
	ObjectCreator creator;
	EObjectManager manager;
	private Map<EClass, Map<String,OCLExpression>> oclExpressions = new HashMap<>();
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
		EClass ecl = getTargetClass();
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
		try {
			oclman.evaluateAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error evaluating: "+e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			System.err.println("Error evaluating: "+e.getMessage());
		}
		return targetObject;
	}
	
	public static Map<EClass, Set<EObject>> getExistingObjectMap(Iterable<EObject> existingObjects) {
		Map<EClass, Set<EObject>> existingObjectMap = new HashMap<>();
		for (EObject eobj: existingObjects) {
			existingObjectMap.computeIfAbsent(eobj.eClass(), x->new HashSet<>()).add(eobj);
			eobj.eClass().getEAllSuperTypes().forEach((sc)->{
				existingObjectMap.computeIfAbsent(sc, x->new HashSet<>()).add(eobj);
			});
		}
		return existingObjectMap;
	}
	
	public Collection<VMEObject> getAllAdmissible(Iterable<EObject> existingObjects) {
		Map<EClass, Set<EObject>> existingObjectMap = getExistingObjectMap(existingObjects);
		return getAllAdmissible(existingObjectMap);
	}
	
	
	public Collection<VMEObject> getAllAdmissible(Map<EClass, Set<EObject>> existingObjectMap ) {
		List<List<EObject>> admissiblePerParameters = new ArrayList<>();
		for (ParameterType pt: this.creator.getPars()) {
			List<EObject> toAdd = new ArrayList<>();
			ClassRef cr = pt.getType();
			EClass cl = this.manager.getEClass(cr);
			toAdd.addAll(existingObjectMap.getOrDefault(cl, Collections.emptySet()));
			admissiblePerParameters.add(toAdd);
		}
		List<List<EObject>> everyList = SetUtils.getAllLists(admissiblePerParameters);
		List<VMEObject> ret = new ArrayList<>();
		for (List<EObject> objList: everyList) {
			List<Identifier> ids = new ArrayList<>();
			for (EObject eobj: objList) {
				ids.add(this.manager.getObjIdentifier(eobj));
			}
			Identifier newId = getIdentifier(ids);
			VMEObject obj = this.manager.getObject(newId);
			if (isValid(obj)) {
				ret.add(obj);
			}
		}
		return ret;
	}
	
	public ObjectCreator getCreator() {
		return this.creator;
	}

	public Identifier getIdentifier(List<Identifier> subIds) {
		Identifier ret = VObjectModelFactory.eINSTANCE.createIdentifier();
		ret.setCreatorid(getName());
		for (Identifier sub: subIds) {
			IdentifierRef ir = VObjectModelFactory.eINSTANCE.createIdentifierRef();
			ir.setS_identifier(sub);
			ret.getIdentifierreforcmp().add(ir);
		}
		ret.init();
		return ret;
	}
	@Override
	public CreatorId getName() {
		CreatorId ret = VObjectModelFactory.eINSTANCE.createCreatorId();
		ret.setNamespace(this.creator.eResource().getURI().toString());
		ret.setName(this.creator.getName());
		return ret;
	}
	
	public EClass getTargetClass() {
		ClassRef cr = this.creator.getClassName();
		EClass ecl = this.manager.getEClass(cr);
		return ecl;
	}
	
	public boolean isValid(VMEObject eobj) {
		Map<String,OCLExpression> map;
		synchronized (oclHelper) {
			EClass ecl = eobj.eClass();
			map = this.oclExpressions.computeIfAbsent(ecl, x->new HashMap<>());
			Map<String,Object> values = new HashMap<>();
			Collection<?> parameters = eobj.getParameters();
			Iterator<?> iter = parameters.iterator();
			for (int i = 0; i < this.creator.getPars().size(); ++i)  {
				Object obj = null;
				if (iter.hasNext()) {
					obj = iter.next();
				}
				values.put(this.creator.getPars().get(i).getName(), obj);
			}
			for (Selection sel: this.creator.getSel()) {
				String eString = getExprString(sel.getExpr());
				oclHelper.setInstanceContext(eobj);
				OCLExpression oe = map.computeIfAbsent(eString, x->{
					return OclExpressionGetter.getExpression(eobj, x, values);
				});
				if (oe == null) {
					return false;
				}
				EvaluationEnvironment env = fact.createEvaluationEnvironment();
				Map extents = env.createExtentMap(null);
				EvaluationVisitor ev = fact
						.createEvaluationVisitor(fact.createEnvironment(), env, extents);
				env.add(Environment.SELF_VARIABLE_NAME, eobj);
				values.forEach((k,v)->{
					env.add(k, v);
				});
				Object ret = oe.accept(ev);
				if (!(ret instanceof Boolean) || !((Boolean)ret)) {
					return false;
				}
			}
		}
		return true;
	}

}
