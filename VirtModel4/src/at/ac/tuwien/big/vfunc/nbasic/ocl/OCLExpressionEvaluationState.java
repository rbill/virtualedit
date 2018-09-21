package at.ac.tuwien.big.vfunc.nbasic.ocl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.impl.ExpressionsFactoryImpl;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.pivot.ids.BindingsId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdVisitor;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.ids.ParametersId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TemplateParameterId;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.TupleTypeImpl;
import org.eclipse.ocl.pivot.internal.ids.AbstractTypeId;
import org.eclipse.ocl.pivot.internal.ids.GeneralizedTupleTypeIdImpl;
import org.eclipse.ocl.pivot.internal.values.TupleValueImpl;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.OCLFactory;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.xmlintelledit.xmltext.ecoretransform.impl.TypeTransformatorStore;


public class OCLExpressionEvaluationState {
	
	private static final EcoreEnvironmentFactory fact = EcoreEnvironmentFactory.INSTANCE;
	static OCL ocl;
	static Helper oclHelper;
	static {
		ocl = OCL.newInstance();
		oclHelper = ocl.createOCLHelper();
	}
	private static TypeTransformatorStore tts = new TypeTransformatorStore();
	
	private static Object toOclCol(Collection col, TypeId[] typeId) {
		if (col instanceof Set) {
			typeId[0] = TypeId.SET;
			
		} else if (col instanceof List) {
			typeId[0] = TypeId.SEQUENCE;
		} else {
			//Bag
			typeId[0] = TypeId.BAG;
		}
		return col;
	}
	
	private String oclExpression;;
	

	private Map extents;
	private EvaluationEnvironment env;
	

	private Map<String,Object> values;
	
	TracingEvaluationVisitor evalVisitor = null;
	
	Object returnedValue = null;
	
	
	

	Double quality = null;
	boolean fullEval = false;
	public OCLExpressionEvaluationState(String oclExpression, Map<String, Object> values) {
		this.oclExpression = oclExpression;
		this.values = values;
	}
	public Object evaluate() {
		this.returnedValue = evaluate(this.oclExpression, this.values);
		return this.returnedValue;
	}
	
	public Object evaluate(String oclExpression, Map<String,Object> values) {
		EcoreFactory efact = EcoreFactory.eINSTANCE;
		EClass fakeClass = efact.createEClass();
		fakeClass.setName("Bla");
		@NonNull
		Collection<@NonNull TuplePartId> parts = new ArrayList<>();
		/*Map<TuplePartId, Object> tvaluesMap = new HashMap<>();
		{
			int index = 0;
			for (Entry<String,Object> entry: values.entrySet()) {
				Object obj = entry.getValue();
				TypeId typeId = null;
				if (obj instanceof EObject) {
					typeId = IdManager.getTypeId(((EObject)obj).eClass());
				} else if (obj instanceof Collection){
					TypeId[] typeIds = new TypeId[1];
					Object newVal = toOclCol((Collection)obj, typeIds);
					typeId = typeIds[0];
				} else  if (obj != null) {
					typeId = IdManager.getPrimitiveTypeId(obj.getClass().getSimpleName());
				}
				if (typeId == null) {
					typeId = TypeId.OCL_ANY;
				}
				@NonNull
				TuplePartId part = IdManager.getTuplePartId(index, entry.getKey(), typeId);
				parts.add(part);
				tvaluesMap.put(part, entry.getValue());
			}
		}
		@NonNull
		TupleTypeId tupleTypeId = IdManager.getTupleTypeId("myTuple", parts);
		TupleValueImpl tvi = new TupleValueImpl(tupleTypeId, tvaluesMap);*/
		
		
		OCLExpression query;
		try {
			oclHelper.setInstanceContext(null);
			Environment<?, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, ?, ?> environment = oclHelper.getEnvironment();
			for (Entry<String,Object> entr: values.entrySet()) {
				Variable<EClassifier, ?> elem = ExpressionsFactory.eINSTANCE.createVariable();
				elem.setName(entr.getKey());
				elem.setType(getEClassifier(entr.getValue()));
				environment.addElement(entr.getKey(), (Variable)elem, true);
			}
			query = oclHelper.createQuery(oclExpression);
		}  catch (ParserException e) {
			//System.err.println("Could not parse " + oclExpression + " for " + tvi+ ": " + e.getMessage());
			e.printStackTrace();
			return null;
		}
					
		this.env = fact.createEvaluationEnvironment();
		EvaluationVisitor ev = fact
				.createEvaluationVisitor(fact.createEnvironment(), this.env, this.extents);
		this.evalVisitor = new TracingEvaluationVisitor(ev);
		
		//TOOD: ...
		this.extents = this.env.createExtentMap(null);
		for (Entry<String,Object> entr: values.entrySet()) {
			this.env.add(entr.getKey(), entr.getValue());
		}
		Object ret = query.accept(this.evalVisitor);
		return ret;
	}
	
	public static EClassifier getEClassifier(Object value) {
		if (value == null) {
			//TODO???
			return null;
		}
		if (value instanceof EObject) {
			return ((EObject)value).eClass();
		}
		//DataTypes
		EDataType defaultDatatype = tts.getStandardDatatypeOrNull(value.getClass());
		if (defaultDatatype != null) {
			return defaultDatatype;
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	public Map<Object, Set> getProperties() {
		return this.evalVisitor.getPropertiesPerObject();
	}
	
	public Set<Pair<String,Object>> getVariableObjects() {
		return this.evalVisitor.getVariableValues();
	}


	

}
