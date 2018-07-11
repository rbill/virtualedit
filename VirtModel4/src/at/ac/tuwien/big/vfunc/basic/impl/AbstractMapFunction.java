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
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.VFunc;

public abstract class  AbstractMapFunction<Src,Target> implements FunctionNotifyer<BasicMapFunctionC<Src, Target>, Src, Target>, VFunc<Src, Target> {

	
	private boolean isSorted;
	private FunctionType<Src, Target> type;

	
	protected Map<Src,SingleAssignment> map;
	private List<WeakReference<ChangeListenable<? super BasicMapFunctionC<Src, Target>, ? super Src, ? super Target>>> changeListeners = new ArrayList<>();
	
	
	
	
	protected class SingleAssignment {
		public CompleteResult<Src, Target> myAssignment;
		public TreeMap<Integer,CompleteResult<Src, Target>> otherResults = new TreeMap<>();
		public Src src;
		
		
		
		public SingleAssignment(Src src) {
			this.src = src;
		}

		public void setMyAssignment(CompleteResult<Src, Target> myAssignment) {
			Target oldTarget = getTarget();
			if (myAssignment != this.myAssignment) {
				CompleteResult<Src, Target> oldAssignment = this.myAssignment;
				if (myAssignment == null) {
					this.myAssignment = null;
					if (isEmpty()) {	
						map.remove(src);
					}
				} else {
					CompleteResult<Src, Target> cur = getResult();
					//Don't replace the existing object if possible ...
					if (this.myAssignment == null) {
						this.myAssignment = myAssignment;
					}
				}
				switchAssignment(oldAssignment, myAssignment);
			}
			checkChanged(oldTarget);
		}
		
		//Problem: Wenn ich change mache, ist er schon angewendet und das alte Resultat ist vielleicht schon das "neue"
		
		
		private void switchAssignment(CompleteResult<Src, Target> from, CompleteResult<Src, Target> result) {
			if (from == result) {return;}
			if (from != null) {
				if (result != null) {
					from.mergeWithCurrent(result);
				}
			} else {
				from = result;
				result.addChangeListener(changeListenable);
			}
		}
		
		private void checkChanged(Target oldTarget) {
			Target newTarget = getTarget();
			if (!Objects.equals(oldTarget,newTarget)) {
				notifyChanged(src, oldTarget, newTarget);
			}
		}
		
		public void addCompleteResult(Integer key, Target old, CompleteResult<Src, Target> result) {
			Target oldTarget = getTarget(key,old);
			CompleteResult<Src, Target> from = otherResults.put(key, result);
			switchAssignment(from, result);
			checkChanged(oldTarget);
		}
		
		public void removeCompleteResult(Integer key) {
			Target oldTarget = getTarget();
			CompleteResult<Src, Target> from = otherResults.remove(key);
			switchAssignment(from, null);
			checkChanged(oldTarget);
			if (isEmpty()) {
				map.remove(src);
			}
		}
		
		public Target getTarget() {
			CompleteResult<Src, Target> result = getResult();
			if (result == null) {
				return null;
			}
			return result.value();
		}
		
		
		public Target getTarget(Integer key, Target hasOldValue) {
			if (myAssignment != null) {
				return myAssignment.value();
			}
			if (otherResults.isEmpty() || key >= otherResults.lastKey()) {
				return hasOldValue;
			}
			CompleteResult<Src, Target> cr = otherResults.lastEntry().getValue();
			if (cr == null) {
				return null;
			}
			return cr.value();
		}
		
		public CompleteResult<Src, Target> getResult() {
			if (myAssignment != null) {
				return myAssignment;
			}
			if (!otherResults.isEmpty()) {
				return otherResults.lastEntry().getValue();
			}
			return null;
		}
		
		public boolean isEmpty() {
			return myAssignment == null && otherResults.isEmpty();
		}

		public void removeChangeListener(ChangeListenable<CompleteResult<Src, Target>, Src, Target> changeListenable) {
			if (myAssignment != null) {
				myAssignment.removeChangeListener(changeListenable);
			}
			otherResults.values().forEach(x->{if (x != null) {x.removeChangeListener(changeListenable);}});
		}

		public void getConstraintViolations(List<? super ConstraintViolation<Src, Target>> violations, List<? extends Assignment<Src, Target>> constraintFunctions) {
			Target thisResult = null;
			CompleteResult<Src, Target> thisCResult = null; 
			if (this.myAssignment != null) {
				thisCResult = this.myAssignment;
				thisResult = this.myAssignment.value();
				if (!otherResults.isEmpty()) {
					CompleteResult<Src, Target> alternateFunctionResult = otherResults.lastEntry().getValue();
					Target otherResult = alternateFunctionResult .value();
					if (!Objects.equals(thisResult, otherResult)) {
						violations.add(new BasicConstraintViolation<>(this.myAssignment, alternateFunctionResult));
					}
				}
			} else {
				if (!otherResults.isEmpty()) {
					CompleteResult<Src, Target> alternateFunctionResult = otherResults.lastEntry().getValue();
					thisCResult = alternateFunctionResult;
					thisResult = alternateFunctionResult .value();
				}
			}
			if (thisCResult != null) {
				for (Assignment<Src, Target> constraintAssignment: constraintFunctions) {					
					CompleteResult<Src, Target> result = constraintAssignment.evaluateIfApplicable(src);
					if (result != null) {
						Target otherResult = result.value();
						if (!Objects.equals(thisResult, otherResult)) {
							violations.add(new BasicConstraintViolation<>(thisCResult, result));	
						}
					}
				}
			}
		}
	}
	public AbstractMapFunction(FunctionType<Src, Target> type, boolean isSorted) {
		this.type = type;
		this.isSorted = isSorted;
		if (isSorted) {
			map = new TreeMap<>();
		} else {
			map = new HashMap<>();
		}
	}
	

	public boolean isSorted() {
		return isSorted;
	}

	protected SingleAssignment getOrCreateAssignment(Src src) {
		return map.computeIfAbsent(src, x->new SingleAssignment(src));
	}
		
	
	private ChangeListenable<CompleteResult<Src, Target>, Src, Target> changeListenable = new ChangeListenable<CompleteResult<Src, Target>, Src, Target>() {

		@Override
		public void changed(Change<? extends CompleteResult<Src, Target>, ? extends Src, ? extends Target> change) {
			notifyChanged(change.source(), change.oldValue(), change.newValue());
		}
	};
	

	public CompleteResult<Src, Target> getOrNull(Src src) {
		SingleAssignment ret = map.get(src);
		if (ret == null) {
			CompleteResult<Src, Target> retV = null;
			return retV;
		} else {
			return ret.getResult();
		}
	}

	public List<WeakReference<ChangeListenable<? super BasicMapFunctionC<Src, Target>, ? super Src, ? super Target>>> getChangeListeners() {
		return changeListeners;
	}
	
	public void finalize() throws Throwable {
		super.finalize();
		map.values().forEach(x->x.removeChangeListener(changeListenable));
	}

	public void getConstraintViolations(List<ConstraintViolation<Src, Target>> violations, List<? extends Assignment<Src, Target>> contraints) {
		map.values().forEach(x->x.getConstraintViolations(violations, contraints));
	}

	public Map<Src, CompleteResult<Src, Target>> getDirectMap() {
		Map<Src, CompleteResult<Src, Target>> ret = new HashMap<Src, CompleteResult<Src,Target>>();
		map.forEach((k,v)->{if (v.myAssignment != null) {ret.put(k, v.myAssignment);}});
		return ret;
	}


	@Override
	public void notifyChanged(Src src, Target oldTarget, Target newTarget) {
		FunctionNotifyer.super.notifyChanged(src,oldTarget,newTarget);
		//TODO: ScopeChange
		/*
		if ((oldTarget == null) != (newTarget == null)) {
			if (oldTarget == null) {
				
			} else {
				
			}
		}*/
	}


	@Override
	public FunctionType<Src, Target> getType() {
		return type;
	}
	
}
