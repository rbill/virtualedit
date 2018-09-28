package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EvaluationVisitorImpl;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.Visitable;

import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.Evaluable;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.EvaluationState;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.impl.OCLExpressionEvaluable;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.impl.OCLExpressionEvaluationState;

public class OclDerivationEvaluable implements Evaluable<OclDerivationEvaluable, OclDerivationEvaluableState>{

	private static final EcoreEnvironmentFactory fact = EcoreEnvironmentFactory.INSTANCE;
	private static Map<String,Map<EClass, OCLExpression<?>>> knownExpressions = new HashMap<>();
	private String expr;
	
	private String messageExpr;
	
	 
	
	public OclDerivationEvaluable(String expr, String messageExpr) {
		this.expr = expr;
		this.messageExpr = messageExpr;
	}
	

	@Override
	public OclDerivationEvaluable clone() {
		return new OclDerivationEvaluable(this.expr,this.messageExpr);
	}
	

	@Override
	public boolean equals(Object o) {
		return (o instanceof OclDerivationEvaluable) && Objects.equals(this.expr, ((OclDerivationEvaluable)o).expr);
	}
	
	public String evaluateMessage(EObject context) {
		if (this.messageExpr == null) {
			return null;
		}
		EvaluationEnvironment env = fact.createEvaluationEnvironment();
		env.add(Environment.SELF_VARIABLE_NAME, context);
		Map extents = env.createExtentMap(context);
		EvaluationVisitorImpl evi = new EvaluationVisitorImpl(fact.createEnvironment(), env, extents);
		Object ret = evi.visitExpression(getExpression(this.messageExpr,context));
		if (ret instanceof String) {
			return (String)ret;
		}
		return null;
	}

	public OCLExpression getExpression(EObject obj) {
		return getExpression(this.expr, obj);
	}

	public OCLExpression getExpression(String expr, EObject eobj) {
		return knownExpressions.computeIfAbsent(expr, x->new HashMap<>()).computeIfAbsent(eobj.eClass(),
				x->OclExpressionGetter.getExpression(eobj, expr, Collections.emptyMap())
				);
	}
	
	public String getExpressionString() {
		return this.expr;
	}
	
	@Override
	public OclDerivationEvaluableState getState(MyResource res, EObject obj) {
		return new OclDerivationEvaluableState(res,this,obj);
	}


	@Override
	public int hashCode() {
		return Objects.hashCode(this.expr);
	}


	@Override
	public String toString() {
		return String.valueOf(this.expr);
	}

}
