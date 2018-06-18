package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CollectionScope;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.VFunc;
import at.ac.tuwien.big.vfunc.basic.impl.AbstractMapFunction.SingleAssignment;

public class BasicMapFunctionC<Src,Target> extends AbstractMapFunction<Src,Target> {

	

	public BasicMapFunctionC(FunctionType<Src, Target> type, boolean isSorted) {
		super(type, isSorted);
	}

	public void addHardAssignment(Assignment<Src, Target> ass) {
		
		//Finite scope, finite values - add directly in the map
		Scope<Src> scope = ass.getScope();
		if (!(scope instanceof FixedFinitScope)) {
			System.err.println("Error: Hard assignment scope must be fixed and finite");
		} else {
			FixedFinitScope<Src> ffs = (FixedFinitScope<Src>)scope;
			for (Src src: ffs) {
				boolean hadAssignment = scope.contains(src);
				SingleAssignment assignment = getOrCreateAssignment(src);
				AssignmentSourceInfo<Src, Target> asi = new BasicAssignmentSourceInfo<Src, Target>(ass, src);
				assignment.setMyAssignment(ass.getExpression().apply(asi));
				if (!hadAssignment) {
					this.scope.notifyAdded(src);
				}
			}
		}

	}
	

	public CompleteResult<Src, Target> putStaticValue(Src src, Target target) {
		CompleteResult<Src, Target> result = getOrCreate(src);
		BasicCompleteResult<Src, Target> temp = new BasicCompleteResult<Src, Target>(null, src, target,  new BasicSubResultInfo(new ArrayList<>()));
		result.mergeWithCurrent(temp);
		return result;
	}

	

	public CompleteResult<Src, Target> put(Src src, CompleteResult<Src, Target> result) {
		boolean currentlyInScope = getScope().contains(src);
		SingleAssignment ass = map.computeIfAbsent(src, x->new SingleAssignment(src));
		Target oldValue = ass.getTarget();
		ass.setMyAssignment(result);
		if (!Objects.equals(oldValue, result.value())) {
			//TODO: ich weiﬂ nicht was ich mache ... k.A. ob das hier sinnvoll ist
			notifyChanged(src, oldValue, result.value());
		}
		if (!currentlyInScope) {
			scope.notifyAdded(src);
		}
		return ass.myAssignment;
	}
	

	
	public CompleteResult<Src, Target> getOrCreate(Src src) {
		SingleAssignment ret = map.get(src);
		if (ret == null) {
			CompleteResult<Src, Target> retV = null;
			SingleFunction<Src, Target> lastFunc = null;
			if (retV == null) {
				retV = BasicCompleteResult.NO_RESULT(src);
				put(src, retV);
			}
			return retV;
		} else {
			return ret.getResult();
		}
	}
	

	
	
	@Override
	public CompleteResult<Src, Target> priv_calcResult(Src source) {
		System.err.println("Map functions should never have to calculate the result!");
		return getOrCreate(source);
	}
	

	private CollectionScope<Src> scope = new CollectionScope<Src>() {

		@Override
		public boolean contains(Src src) {
			if (map.keySet().contains(src)) {
				return true;
			}
			return false;
		}
		
		@Override
		public Collection<Src> getValues() {
			return map.keySet();
		}
		
		List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> changeListeners = new ArrayList<>();

		@Override
		public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
			return changeListeners;
		}

		@Override
		public Class<Src> getSourceClass() {
			return getType().getSourceType();
		}
	};

	public FixedFinitScope<Src> getScope() {
		return scope;
	}


}
