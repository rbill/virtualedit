package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FilteredScopeChange;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.IterableScopeChange;
import at.ac.tuwien.big.vfunc.basic.ModifiedScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChange;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.ScopeNotifyer;
import at.ac.tuwien.big.virtmod.basic.Treepos;

public class BasicDeltaFunc<Src,Target> extends AbstractFunc<Src, Target, BasicQueryResult<Src,Target>> {

	public class DeltaResult extends BasicResultImpl<Target> {
		
		private Src src;
		private QueryResult<Src, Target> finiteResult;
		private BasicListenable bl;

		public DeltaResult(MetaInfo mi, Src src) {
			super(mi);
			this.src = src;
			this.finiteResult = BasicDeltaFunc.this.bfuf.evaluate(src);
			this.bl = new BasicListenable() {
				
				@Override
				public void changed(BasicChangeNotifyer bcm) {
					DeltaResult.this.refresh();
				}
			};
			this.finiteResult.addBasicChangeListener(this.bl);
			Reason reason = mi.getReason();
			if (reason instanceof ComposedReason) {
				ComposedReason cr = (ComposedReason)reason;
				cr.initSourceInfos(()->{
					List<BasicValuedChangeNotifyer<?>> ret = new ArrayList<>();
					Boolean filterValue = BasicDeltaFunc.this.filterScope.evaluateBasic(src);
					if (filterValue != null) {
						ret.add(BasicDeltaFunc.this.filterScope.evaluate(src));
						if (filterValue) {
							ret.add(BasicDeltaFunc.this.addMap.evaluate(src));
						}
					} else {
						ret.add(BasicDeltaFunc.this.originalFunc.evaluate(src));
					}
					
					return ret;
				});
			}
		}

		@Override
		public Target calcValue() {
			boolean inScope = getScope().contains(this.src);
			if (!inScope) {
				return null;
			}
			return this.finiteResult.value();
		}

		@Override
		public Object evaluateNew(Replacer replacer, boolean[] changed) {
			throw new UnsupportedOperationException();
		}

				
	}
	private AbstractFunc<Src, Target, ?> originalFunc;
	private BasicMapFunc<Src, Target> addMap;
	private BasicMapFunc<Src, Boolean> filterScope;
	private Class<Src> sourceClass;
	
	private Scope<Src> filteredScope;
	private ScopeChangeListenable<? super Scope<Src>, ? super Src> scl;
	private BasicFiniteUnionFunc<Src, Target> bfuf; 
	
	private ChangeListenable<?, Src, Target> listenable;
	
	public BasicDeltaFunc(Class<Src> sourceClass, AbstractFunc<Src, Target, ?> originalFunc) {
		this(sourceClass, originalFunc, new BasicMapFunc<>(sourceClass),new BasicMapFunc<>(sourceClass));
	}
	
	
	public BasicDeltaFunc(Class<Src> sourceClass, AbstractFunc<Src, Target, ?> originalFunc, BasicMapFunc<Src,Target> addMap, BasicMapFunc<Src,Boolean> filterScope) {
		this.originalFunc = originalFunc;
		this.addMap =  addMap;
		this.filterScope = filterScope;
		this.filteredScope = originalFunc.getScope().filteredFunc(this.filterScope);
		this.sourceClass = sourceClass;
		
		List<AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>> baseFunc = new ArrayList<>();
		baseFunc.add(this.addMap);
		baseFunc.add(originalFunc);
		this.bfuf = new BasicFiniteUnionFunc<>(sourceClass, baseFunc);
		
		this.listenable = new ChangeListenable<FunctionNotifyer<?,Src,Target>, Src, Target>() {

			@Override
			public void changed(
					Change<? extends FunctionNotifyer<?, Src, Target>, ? extends Src, ? extends Target> change) {
				if (filterScope.evaluateBasic(change.source(), Boolean.TRUE)) {
					QueryResult<Src, Target> thing  = getCacheIfExists(change.source());
					if (thing != null) {
						thing.refresh();
						BasicDeltaFunc.this.getChangeNotifyer().notifyChanged(change.source(), change.oldValue(), change.newValue());
					}
				}
			}
		};
		this.bfuf.getChangeNotifyer().addChangeListener((ChangeListenable)this.listenable);
		
		this.scl = new ModifiedScopeChangeListenable<ScopeNotifyer<?, Src>,Src>() {

			@Override
			public void changedFiltered(FilteredScopeChange<? extends ScopeNotifyer<?, Src>, ? extends Src> fsc) {
				fullRecalc();
			}

			@Override
			public void changedGeneric(ScopeChange<? extends ScopeNotifyer<?, Src>, ? extends Src> change) {
				fullRecalc();
			}

			@Override
			public void changeIterable(IterableScopeChange<? extends ScopeNotifyer<?, Src>, ? extends Src> fsc,
					Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
				for (Src add: added) {
					QueryResult<Src, Target> cacheIfExists = getCacheIfExists(add);
					if (cacheIfExists == null) {continue; }
					cacheIfExists.refresh();
				}
				for (Src del: deleted) {
					QueryResult<Src, Target> cacheIfExists = getCacheIfExists(del);
					if (cacheIfExists == null) {continue; }
					cacheIfExists.refresh();
				}
			}


			
		};
		this.filteredScope.addChangeListener(this.scl);
		
		setBasicMetaInfoCreater(CREATE_COMPOSED_REASON);
		
		Function<Src, BasicResult<Target>> func = (src)->{
			MetaInfo mi = createMetaInfo(src);
			//So wie merged things ...
			DeltaResult ret = new DeltaResult(mi , src);
			ret.refresh();
			return ret;
		};
		setModificator(new SetValueModificator<AbstractFunc<Src,Target,?>, Src, Target>() {

			@Override
			public void setValue(AbstractFunc<Src, Target, ?> func, Src src, Target newValue) {
				if (func instanceof BasicDeltaFunc) {
					BasicDeltaFunc<Src, Target> bdf = (BasicDeltaFunc<Src, Target>)func;
					if (newValue == null) {
						//Delete 
						bdf.filterScope.putBasic(src, false);
						bdf.addMap.putBasic(src, null);
					} else {
						bdf.addMap.putBasic(src, newValue);
						bdf.filterScope.putBasic(src, true);
					}
				}
			}

			@Override
			public void unsetValue(AbstractFunc<Src, Target, ?> func, Src src) {
				setValue(originalFunc, src, null);
			}
		});
		init(func, null);
	}
	
	
	public void clearCustom() {
		this.filterScope.clear();
		this.addMap.clear();
	}
	
	private void fullRecalc() {
		super.refreshCache();
	}
	
	@Override
	public Scope<Src> getScope() {
		return this.filteredScope;
	}


	@SuppressWarnings("deprecation")
	public void mergeDelta(BasicDeltaFunc<Src, ? extends Target> deltaFunc) {
		Map<Src, ? extends BasicResult<? extends Target>> storedMap = deltaFunc.addMap.getStoredMap();
		storedMap.forEach((k,v)->{
			this.addMap.putBasic(k, v.value());
		});
		Map<Src, ? extends BasicResult<? extends Boolean>> filterMap = deltaFunc.filterScope.getStoredMap();
		filterMap.forEach((k,v)->{
			this.filterScope.putBasic(k, v.value());
		});
		
	}


	public void partialPushdown() {

		FunctionModificator fmod = this.originalFunc.getModificator();
		if (fmod instanceof SetValueModificator) {
			Map<Src, BasicResult<Target>> storedMap = this.addMap.getStoredMap();
		
		Map<Src, BasicResult<Boolean>> filterMap = this.filterScope.getStoredMap();
		Set<Src> deleteFilter = new HashSet<>();
		Set<Src> addFilter = new HashSet<>();
		
		filterMap.forEach((k,v)->{
			Boolean b = v.value();
			if (b  == null) {
				//Don't do anything
				deleteFilter.add(k);
			} else if (b) {
				if (!this.originalFunc.getScope().contains(k)) {
					addFilter.add(k);
				}
			} else {
				if (this.originalFunc.getScope().contains(k)) {
					deleteFilter.add(k);
				}
			}
		});
			SetValueModificator<AbstractFunc<Src,Target,?>, Src, Target> svf = (SetValueModificator)fmod;
			for (Src src: deleteFilter) {
				svf.unsetValue(this.originalFunc, src);
			}
			storedMap.forEach((k,v)->{
				//Delete what is not in scope or what is equal to the other value
				if (deleteFilter.contains(k)) {
					return; //Ignore what was deleted
				}
				if (addFilter.contains(k) || this.originalFunc.getScope().contains(k)) {
					svf.setValue(this.originalFunc, k, v.value());
				}
			});
		}
		partialReset();
	}
	
	public void partialReset() {
		Map<Src, BasicResult<Target>> storedMap = this.addMap.getStoredMap();
		Set<Src> deleteStored = new HashSet<>();
		storedMap.forEach((k,v)->{
			//Delete what is not in scope or what is equal to the other value
			boolean delete = !getScope().contains(k) || Objects.equals(this.originalFunc.evaluateBasic(k),v.value());
			if (delete) {
				deleteStored.add(k);
			}
		});
		Map<Src, BasicResult<Boolean>> filterMap = this.filterScope.getStoredMap();
		Set<Src> deleteFilter = new HashSet<>();  
		filterMap.forEach((k,v)->{
			Boolean b = v.value();
			if (b  == null) {
				deleteFilter.add(k);
			} else if (b) {
				if (this.originalFunc.getScope().contains(k)) {
					deleteFilter.add(k);
				}
			} else {
				if (!this.originalFunc.getScope().contains(k)) {
					deleteFilter.add(k);
				}
			}
		});
		for (Src ds: deleteStored) {
			this.addMap.putBasic(ds, null);
		}
		for (Src ds: deleteFilter) {
			this.filterScope.putBasic(ds, null);
		}
	}

	public BasicDeltaFunc<Src, Target> reapplyFor(AbstractFunc<Src, Target, ?> newOriginal) {
		return new BasicDeltaFunc<>(this.sourceClass, newOriginal, this.addMap, this.filterScope);
	}



}
