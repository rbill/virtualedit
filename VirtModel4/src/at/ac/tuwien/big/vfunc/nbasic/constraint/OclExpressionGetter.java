package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;

import at.ac.tuwien.big.vfunc.nbasic.ocl.OCLExpressionEvaluationState;
import at.ac.tuwien.big.xmlintelledit.intelledit.search.local.OCLExpressionState;

public class OclExpressionGetter {
	
	static OCL ocl;
	static Helper oclHelper;
	static {
		ocl = OCL.newInstance();
		oclHelper = ocl.createOCLHelper();
	}
	
	
	public static OCLExpression getExpression(EObject eobj, String oclExpression, Map<String,Object> values) {

		OCLExpression query;
		try {
			oclHelper.setInstanceContext(eobj);
			Environment<?, EClassifier, EOperation, EStructuralFeature, ?, ?, ?, ?, ?, Constraint, ?, ?> environment = oclHelper.getEnvironment();
			for (Entry<String,Object> entr: values.entrySet()) {
				Variable<EClassifier, ?> elem = ExpressionsFactory.eINSTANCE.createVariable();
				elem.setName(entr.getKey());
				elem.setType(OCLExpressionEvaluationState.getEClassifier(entr.getValue()));
				environment.addElement(entr.getKey(), (Variable)elem, true);
			}
			if (eobj != null) {
				Variable<EClassifier, ?> elem = ExpressionsFactory.eINSTANCE.createVariable();
				elem.setName(Environment.SELF_VARIABLE_NAME);
				elem.setType(eobj.eClass());
				environment.addElement(Environment.SELF_VARIABLE_NAME, (Variable)elem, true);
			}
			query = oclHelper.createQuery(oclExpression);
			return query;
		}  catch (ParserException e) {
			System.err.println("Could not parse " + oclExpression + " for " + eobj+ ": " + e.getMessage());
			e.printStackTrace();
			return null;
		}
					
	}

}
