package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vfunc.basic.Refreshable;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicMetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.BasicResultImpl;
import at.ac.tuwien.big.vfunc.nbasic.Replacer;
import at.ac.tuwien.big.vfunc.nbasic.ecore.DeltaVMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclAssignment;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.EvaluationState;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.impl.OCLExpressionEvaluable;
import at.ac.tuwien.big.xmlintelledit.intelledit.evaluate.impl.OCLExpressionEvaluationState;
import at.ac.tuwien.big.xmlintelledit.intelledit.fixer.impl.MakeTrueImpl;
import at.ac.tuwien.big.xmlintelledit.intelledit.oclvisit.EvalResult;
import at.ac.tuwien.big.xmlintelledit.intelledit.oclvisit.RejectingFilterManager;
import at.ac.tuwien.big.xmlintelledit.intelledit.oclvisit.TracingEvaluationVisitor;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class OclDerivationEvaluableState extends BasicResultImpl<Object> implements EvaluationState<OclDerivationEvaluableState>, Refreshable {

	private OclDerivationEvaluable eval;
	private EObject obj;
	private RejectingFilterManager man;
	private Map extents;
	private EvaluationEnvironment env;
	private static final EcoreEnvironmentFactory fact = EcoreEnvironmentFactory.INSTANCE;
	private Map<String, Object> initParms = new HashMap<>();
	private MyResource res;

	public OclDerivationEvaluableState(MyResource res, OclDerivationEvaluable eval, EObject obj) {
		super(new BasicMetaInfo());
		this.eval = eval;
		this.obj = obj;
		this.res = res;
	}
	
	public void initParam() {
		man = new RejectingFilterManager();
		man.initDefault();
		
		env = fact.createEvaluationEnvironment();
		//Replace can always be called!
		env.replace(Environment.SELF_VARIABLE_NAME, obj);
		extents = env.createExtentMap(obj);
	};

	TracingEvaluationVisitor evalVisitor = null;
	Object returnedValue = null;
	Double quality = null;
	boolean fullEval = false;

	private BasicListenable refreshMyself = new BasicListenable() {

		@Override
		public void changed(BasicChangeNotifyer bcm) {
			OclDerivationEvaluableState.this.refresh();
		}
		
	};
	
	@Override
	public Object evaluateBasic() {
		EvaluationVisitor ev = fact
				.createEvaluationVisitor(fact.createEnvironment(), env, extents);			
		evalVisitor = new TracingEvaluationVisitor(ev);
		OCLExpression expr = eval.getExpression(obj);
		Object ret = expr.accept(evalVisitor);
		returnedValue = ret;
		
		at.ac.tuwien.big.vfunc.nbasic.ocl.TracingEvaluationVisitor<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> refreshVisitor = new at.ac.tuwien.big.vfunc.nbasic.ocl.TracingEvaluationVisitor<>(evalVisitor);
		expr.accept(refreshVisitor);
		
		//Ignore for now
		/*
		for (Pair<String, Object> pair : refreshVisitor.getVariableValues()) {
			OclAssignment depOn = this.manager.getAssignment(pair.getA()); 
			if (depOn == null) {continue;}
			if (pair.getB() == null || Objects.equals(pair.getB(), myMap.get(pair.getA()))) {
				// Assume it is relevant?
				depOn.addBasicChangeListener(this.refreshMyself);
			} else {
				depOn.removeBasicChangeListener(this.refreshMyself);
			}
		}*/

		for (Entry<Object, ?> props : refreshVisitor.getPropertiesPerObject().entrySet()) {
			if (!(props.getKey() instanceof NotifyableEObject)) {
				// Can't do anything
				continue;
			}
			NotifyableEObject vme = (NotifyableEObject) props.getKey();
			for (Object esf: (Set<?>)props.getValue()) {
				//If this changes, re-evaluate this!
				if (!(esf instanceof EStructuralFeature)) {
					System.err.println("Strange property: "+esf);
					continue;
				}
				EStructuralFeature resf = (EStructuralFeature)esf;
				vme.addListener(resf, this.refreshMyself);
			}
		}
		return ret;
	}


	@Override
	public Object evaluateFull() {
		if (evalVisitor == null) {
			evaluateBasic();
		}
		/*if (eval.toString().contains("self.designSpeed.<=(self.providedBy.designSpeed).and(if self.type.=(serviceexample::ServiceType::IMPORTANT) then self.designSpeed.<=(self.providedBy.backup.designSpeed) else self.type.=(serviceexample::ServiceType::WEAKCONTRACT).or(self.providedBy.backup.<>(null)) endif)")) {
			System.out.println("Expression!");
		}*/
		man.calculateEverything(res,evalVisitor.getTopResult());
		fullEval = true;
		return returnedValue;
	}


	@Override
	public EvalResult getResult() {
		return evalVisitor.getTopResult();
	}


	@Override
	public double getQuality() {
		if (quality == null) {
			try {
				if (!fullEval) {
					evaluateFull();
				}
				quality = man.calculateSingleQuality(getResult(), MakeTrueImpl.INSTANCE);
			} catch (Exception e) {
				return 0.0;
			}
		}
		return quality;
	}

	@Override
	public void reuseParam(OclDerivationEvaluableState from) {
		man = from.man;
		extents = from.extents;
		env = fact.createEvaluationEnvironment();
		env.add(Environment.SELF_VARIABLE_NAME, obj);		
	}

	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		throw new UnsupportedOperationException();
	}


	@Override
	public Object calcValue() {
		return evaluateBasic();
	}

	


}