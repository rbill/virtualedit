package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.Value;
import at.ac.tuwien.big.vfunc.basic.ValueCache;

public class BasicValueCache<Src,Target> implements ValueCache<Src, Target> {

	private boolean isSorted;
	
	private List<Assignment<Src, Target>> constraintFunctions = new ArrayList<>(); 
	
	private class SingleAssignment {
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

		public void getConstraintViolations(List<ConstraintViolation<Src, Target>> violations) {
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
	
	private Map<ValueCache<Src, Target>,Integer> cacheId = new HashMap<ValueCache<Src,Target>, Integer>();
	private Map<Src,SingleAssignment> map;
	private VFunction<Src, Target> function;
	private List<WeakReference<ChangeListenable<? super ValueCache<Src, Target>, ? super Src,? super Target>>> changeListeners = new ArrayList<>();
	private List<ValueCache<Src, Target>> subCaches = new ArrayList<ValueCache<Src,Target>>();
	
	public int getCacheId(ValueCache<Src, Target> cache) {
		return cacheId.computeIfAbsent(cache, (x)->(cacheId.size()+1));
	}
	
	public BasicValueCache(boolean isSorted) {
		this.isSorted = isSorted;
		if (isSorted) {
			map = new TreeMap<>();
		} else {
			map = new HashMap<>();
		}
	}
	
	@Override
	public boolean isSorted() {
		return isSorted;
	}

	@Override
	public VFunction<Src, Target> function() {
		return function;
	}
	
	public void addAssignment(Assignment<Src, Target> ass, AssignmentType type) {
		if (type == null) {
			type = ass.getType();
		}
		switch (type) {
		case HARD:
			//Finite scope, finite values - add directly in the map
			Scope<Src> scope = ass.getScope();
			if (!(scope instanceof FixedFinitScope)) {
				System.err.println("Error: Hard assignment scope must be fixed and finite");
			} else {
				FixedFinitScope<Src> ffs = (FixedFinitScope<Src>)scope;
				for (Src src: ffs) {
					SingleAssignment assignment = getOrCreateAssignment(src);
					AssignmentSourceInfo<Src, Target> asi = new BasicAssignmentSourceInfo<Src, Target>(ass, src);
					assignment.setMyAssignment(ass.getExpression().apply(asi));
				}
			}
			break;
		case SOFT:
			//Finite scope, dynamic values - add as subfunction
			ValueCache<Src, Target> cache = ass.getCacheIfExists(); 
			if (cache != null) {
				addSubCache(cache);
			} else {
				System.err.println("Soft assignment must have a valueCache!");
			}
			break;
		case CONSTRAINT:
			//Probably there are two types: Constraints which can only be checked manually
			//and contraints which are checked automatically
			
			constraintFunctions.add(ass);
			break;
		}
	}
	
	private void addSubCache(ValueCache<Src, Target> subCache) {
		subCaches.add(subCache);
		subCache.addChangeListener(subCacheChangeListenable);
	}
	
	private void removeSubCache(ValueCache<Src, Target> subCache) {
		subCaches.remove(subCache);
		subCache.removeChangeListener(subCacheChangeListenable);
		Integer index = cacheId.get(subCache);
		if (index != null) {
			map.values().forEach(x->x.removeCompleteResult(index));
		}
	}
	
	public List<? extends ValueCache<Src, Target>> getSubCaches() {
		return subCaches;
	}
	

	ChangeListenable<? super ValueCache<Src, Target>, ? super Src, ? super Target> subCacheChangeListenable = new ChangeListenable<ValueCache<Src, Target>, Src, Target>() {

		@Override
		public void changed(Change<? extends ValueCache<Src, Target>, ? extends Src, ? extends Target> change) {
			CompleteResult<Src, Target> newResult = change.getThis().getOrNull(change.source());
			setCacheResult(change.getThis(),change.source(),change.oldValue(),newResult);
		}
		
	};
	
	
	private SingleAssignment getOrCreateAssignment(Src src) {
		return map.computeIfAbsent(src, x->new SingleAssignment(src));
	}
	
	private void setCacheResult(ValueCache<Src, Target> cache, Src src, Target oldValue, CompleteResult<Src, Target> newResult) {
		SingleAssignment ass = getOrCreateAssignment(src);
		Integer key = getCacheId(cache);
		ass.addCompleteResult(key, oldValue, newResult);
	}
	
	
	private ChangeListenable<CompleteResult<Src, Target>, Src, Target> changeListenable = new ChangeListenable<CompleteResult<Src, Target>, Src, Target>() {

		@Override
		public void changed(Change<? extends CompleteResult<Src, Target>, ? extends Src, ? extends Target> change) {
			notifyChanged(change.source(), change.oldValue(), change.newValue());
		}
	};

	@Override
	public CompleteResult<Src, Target> put(Src src, CompleteResult<Src, Target> result) {
		SingleAssignment ass = map.computeIfAbsent(src, x->new SingleAssignment(src));
		ass.setMyAssignment(result);
		return ass.myAssignment;
	}

	@Override
	public CompleteResult<Src, Target> getOrNull(Src src) {
		SingleAssignment ret = map.get(src);
		if (ret == null) {return null;}
		return ret.getResult();
	}

	@Override
	public List<WeakReference<ChangeListenable<? super ValueCache<Src, Target>, ? super Src, ? super Target>>> getChangeListeners() {
		return changeListeners;
	}
	
	public void finalize() throws Throwable {
		super.finalize();
		map.values().forEach(x->x.removeChangeListener(changeListenable));
	}

	@Override
	public void getConstraintViolations(List<ConstraintViolation<Src, Target>> violations) {
		map.values().forEach(x->x.getConstraintViolations(violations));
	}
	
	private FixedFinitScope<Src> scope = new FixedFinitScope<Src>() {

		@Override
		public Collection<Src> getValues() {
			return map.keySet();
		}
	};

	public Scope<Src> getScope() {
		return scope;
	}

}
