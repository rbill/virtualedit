package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopedValueCache;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.ValueCache;

public class WrapperValueCache<Src,OldTrg,NewTrg> implements ScopedValueCache<Src, NewTrg> {
	
	private Collection<VFunction<Src, OldTrg>> oldCaches = new ArrayList<>();
	private boolean isSorted;
	private Function<Collection<CompleteResult<Src, OldTrg>>, CompleteResult<Src, NewTrg>> wrapper;
	private BiConsumer<Collection<CompleteResult<Src, OldTrg>>, CompleteResult<Src, NewTrg>> updater;
	private VFunction<Src, NewTrg> parent;
	private ValueCache<Src, NewTrg> editCache;
	private boolean customEditCache = false;
	
	private Map<Src, CompleteResult<Src, NewTrg>> calculatedResults = new HashMap<>();
	
	public Map<Src, CompleteResult<Src,NewTrg>> getDirectMap() {
		return calculatedResults;
	}
	
	private ChangeListenable<CompleteResult<Src, NewTrg>, Src, NewTrg> changeListenable = new ChangeListenable<CompleteResult<Src, NewTrg>, Src, NewTrg>() {

		@Override
		public void changed(Change<? extends CompleteResult<Src, NewTrg>, ? extends Src, ? extends NewTrg> change) {
			notifyChanged(change.source(), change.oldValue(), change.newValue());
		}
	};
	
	private ChangeListenable<Scope<Src>, Src, Boolean> subScopeChangeListenable = new ChangeListenable<Scope<Src>, Src, Boolean>() {

		@Override
		public void changed(Change<? extends Scope<Src>, ? extends Src, ? extends Boolean> change) {
			if (change.source() == null) {
				recalcEverything();
			} else {
				recalcSource(change.source());
			}
		}
	};
	
	public WrapperValueCache(Collection<VFunction<Src, OldTrg>> oldCaches, Function<Collection<CompleteResult<Src, OldTrg>>, CompleteResult<Src, NewTrg>> wrapper,
			BiConsumer<Collection<CompleteResult<Src, OldTrg>>, CompleteResult<Src, NewTrg>> updater,
			VFunction<Src, NewTrg> editCache) {
		this.oldCaches = new ArrayList<>(oldCaches);
		this.wrapper = wrapper;
		this.updater = updater;
		isSorted = true;
		for (VFunction<Src, OldTrg> oldCache: oldCaches) {
			isSorted&= oldCache.cache().isSorted();
		}
		if (editCache == null) {
			editCache = new BasicValueCache<>(isSorted);
			customEditCache = true;
			oldCaches.add(editCache);
		}
		for (VFunction<Src, OldTrg> func: oldCaches) {
			func.getScope().addChangeListener(subScopeChangeListenable);
		}
		this.editCache = editCache;
	}

	@Override
	public boolean isSorted() {
		return this.isSorted;
	}
	
	public void initFunction(VFunction<Src, NewTrg> parent) {
		this.parent = parent;
		if (customEditCache) {
			((BasicValueCache)editCache).initFunction(parent);
		}
	}

	@Override
	public VFunction<Src, NewTrg> function() {
		return parent;
	}

	@Override
	public CompleteResult<Src, NewTrg> put(Src src, CompleteResult<Src, NewTrg> result) {
		//TODO: Run checking etc.
		calculatedResults.put(src, result);
		return result;
	}

	@Override
	public CompleteResult<Src, NewTrg> getOrNull(Src src) {
		CompleteResult<Src, NewTrg> ret = calculatedResults.get(src);
		if (ret == null) {
			//Nein, nicht, hier kommt nur rein was schon berechnet wurde!
		}
		return ret;
	}
	
	public void recalcSource(Src src) {
		calculatedResults.computeIfPresent(src, (k,v)->{
			Collection<CompleteResult<Src, OldTrg>> oldCol = getCol(src);
			updater.accept(oldCol, v);
			return v;
		});
	}
	

	
	public void recalcEverything() {
		calculatedResults.forEach((src,value)->{
			Collection<CompleteResult<Src, OldTrg>> oldCol = getCol(src);
			updater.accept(oldCol, value);
		});
	}
	
	private Collection<CompleteResult<Src, OldTrg>> getCol(Src src) {
		//Wenn der Scope statisch ist (...), dann sollte auch das ergebnis statisch sein
		//aber was, wenn er nicht statisch ist?
		Collection<CompleteResult<Src, OldTrg>> oldCol = new ArrayList<>();
		for (VFunction<Src, OldTrg> old: oldCaches) {
			if (old.getScope().contains(src)) {
				oldCol.add(old.evaluate(src));
			}
		}
		return oldCol;
	}
	

	@Override
	public CompleteResult<Src, NewTrg> getOrCreate(Src src) {
		CompleteResult<Src, NewTrg> ret = calculatedResults.get(src);
		if (ret == null) {
			Collection<CompleteResult<Src, OldTrg>> oldCol = getCol(src);
			ret = this.wrapper.apply(oldCol);
			put(src, ret);
		}
		return ret;
	}


	@Override
	public void getConstraintViolations(List<ConstraintViolation<Src, NewTrg>> violations) {
		// TODO Auto-generated method stub
		//TODO: Implement me (check editCache VS was sonst rausgekommen wäre)
	}
	

	private List<WeakReference<ChangeListenable<? super ValueCache<Src, NewTrg>, ? super Src,? super NewTrg>>> changeListeners = new ArrayList<>();

	@Override
	public List<WeakReference<ChangeListenable<? super ValueCache<Src, NewTrg>, ? super Src, ? super NewTrg>>> getChangeListeners() {
		return changeListeners;
	}
	
	private FixedFinitScope<Src> scope = new FixedFinitScope<Src>() {

		@Override
		public boolean contains(Src src) {
			if (customEditCache && ((ScopedValueCache)editCache).getScope().contains(src)) {
				return true;
			}
			for (VFunction<Src, OldTrg> ssf: oldCaches) {
				Scope<Src> ss = ssf.getScope();
				if (ss.contains(src)) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public Collection<Src> getValues() {

			Set<Src> ret = isSorted?new TreeSet<Src>():new HashSet<Src>();
			if (customEditCache) {
				ret.addAll(((ScopedValueCache)editCache).getScope().getValues());
			}
			for (VFunction<Src, OldTrg> ssf: oldCaches) {
				Scope<Src> ss = ssf.getScope();
				if (ss instanceof FixedFinitScope) {
					ret.addAll(((FixedFinitScope) ss).getValues());
				}
			}
			return ret;
		}

		List<WeakReference<ChangeListenable<? super Scope<Src>, ? super Src, ? super Boolean>>> changeListeners = new ArrayList<>();
		
		@Override
		public List<WeakReference<ChangeListenable<? super Scope<Src>, ? super Src, ? super Boolean>>> getChangeListeners() {
			return changeListeners;
		}
	};

	@Override
	public FixedFinitScope<Src> getScope() {
		return scope;
	}

}
