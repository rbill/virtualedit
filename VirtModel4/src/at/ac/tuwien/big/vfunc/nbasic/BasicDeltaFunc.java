package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
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
					thing.refresh();
					BasicDeltaFunc.this.getChangeNotifyer().notifyChanged(change.source(), change.oldValue(), change.newValue());
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
		
		Function<Src, BasicResult<Target>> func = (src)->{
			MetaInfo mi = new BasicMetaInfo();
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
						bdf.filterScope.putBasic(src, true);
						bdf.addMap.putBasic(src, newValue);
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
	
	
	private void fullRecalc() {
		super.refreshCache();
	}
	
	@Override
	public Scope<Src> getScope() {
		return this.filteredScope;
	}
	
	public BasicDeltaFunc<Src, Target> reapplyFor(AbstractFunc<Src, Target, ?> newOriginal) {
		return new BasicDeltaFunc<>(this.sourceClass, newOriginal, this.addMap, this.filterScope);
	}

}
