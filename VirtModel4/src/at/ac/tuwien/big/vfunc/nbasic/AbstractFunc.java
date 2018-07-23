package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import at.ac.tuwien.big.util.Util;
import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FilteredScopeChange;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.IterableScopeChange;
import at.ac.tuwien.big.vfunc.basic.ModifiedScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChange;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.impl.BasicChange;
import at.ac.tuwien.big.vfunc.basic.io.BasicStatement.CJmpStatement;

public abstract class AbstractFunc<Src, Target, QR extends QueryResult<Src, Target>> implements Function<Src, Target> {

	private QueryResultCache<Src, QueryResult<Src, Target>> cache;
	private Function<Src, BasicResult<Target>> func;
	private BiFunction<? super Src, ? super QueryResult<Src, Target>, ? extends Target> valueUpdater;
	private CompleteChangeNotifyer globalChangeListener;

	private class CompleteChangeNotifyer extends AbstractFunctionNotifyer<CompleteChangeNotifyer, Src, Target> {

		private Map<Src, QueryResult<Src, Target>> completeMap = new HashMap<>();
		private Map<Src, NewValueListenable> vcnMap = new HashMap<Src, NewValueListenable>();

		private ChangeListenable<at.ac.tuwien.big.vfunc.basic.FunctionNotifyer<?, Src, Target>, Src, Target> cl = new ChangeListenable<at.ac.tuwien.big.vfunc.basic.FunctionNotifyer<?, Src, Target>, Src, Target>() {

			@Override
			public void changed(
					Change<? extends FunctionNotifyer<?, Src, Target>, ? extends Src, ? extends Target> change) {
				notifyChanged(change.source(), change.oldValue(), change.newValue());
			}

		};

		public CompleteChangeNotifyer() {
			FixedFinitScope<Src> scope = Util.as(getScope(), FixedFinitScope.class);
			ScopeChangeListenable<Scope<Src>, Src> scl = new ModifiedScopeChangeListenable<Scope<Src>, Src>() {

				@Override
				public void changeIterable(IterableScopeChange<? extends Scope<Src>, ? extends Src> fsc,
						Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
					fsc.getAdded().forEach(x -> addToScope(x));
					fsc.getDeleted().forEach(x -> deleteFromScope(x, null));
				}

				@Override
				public void changedFiltered(FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc) {
					System.err.println("Not yet implemented!");
					fullRefresh();
				}

				@Override
				public void changedGeneric(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
					System.err.println("Not yet implemented!");
					fullRefresh();
				}
			};
			scope.addChangeListener(scl);
			fullRefresh();
		}

		protected void deleteFromScope(Src k, QueryResult<Src, Target> qr) {
			if (qr == null) {
				qr = completeMap.get(k);
			}
			if (qr instanceof BasicQueryResult) {
				BasicQueryResult<Src, Target> bqr = (BasicQueryResult<Src, Target>) qr;
				bqr.removeChangeListener(cl);
			} else if (qr instanceof ValueChangeNotifyer) {
				ValueChangeNotifyer vcn = (ValueChangeNotifyer) qr;
				NewValueListenable nvl = vcnMap.remove(k);
				if (nvl != null) {
					vcn.removeChangeListener(nvl);
				}
			} else {
				// System.err.println("Not good!");
			}
			// Bekommt er die Änderung mit? Ich denke schon
		}

		private QueryResult<Src, Target> addToScope(Src src) {
			QueryResult<Src, Target> qr = evaluate(src);
			if (qr instanceof BasicQueryResult) {
				BasicQueryResult<Src, Target> bqr = (BasicQueryResult<Src, Target>) qr;
				bqr.addChangeListener(cl);
			} else if (qr instanceof ValueChangeNotifyer) {
				ValueChangeNotifyer<?, Target> vcn = (ValueChangeNotifyer) qr;
				System.err.println("Not good (I think this will get deleted instantly!)");
				NewValueListenable<Target> nvl = new NewValueListenable<Target>() {

					@Override
					public void changed(Target oldValue, Target newValue) {
						notifyChanged(src, oldValue, newValue);
					}
				};
				vcnMap.put(src, nvl);
				vcn.addChangeListener(nvl);
			} else {
				System.err.println("Not good!");
			}
			notifyChanged(src, null, qr.value());
			return qr;
		}

		private void fullRefresh() {
			Map<Src, QueryResult<Src, Target>> oldMap = new HashMap<>(completeMap);
			FixedFinitScope<Src> scope = Util.as(getScope(), FixedFinitScope.class);
			for (Src src : scope) {
				if (completeMap.containsKey(src)) {
					oldMap.remove(src);
					continue;
				}
				QueryResult<Src, Target> qr = addToScope(src);
				completeMap.put(src, qr);
				oldMap.remove(src);
			}
			oldMap.forEach((k, qr) -> {
				deleteFromScope(k, qr);
			});
		}

		private void checkEmpty() {
			if (changeListeners.isEmpty()) {
				// Delete
				globalChangeListener = null;
			}
		}

		public void removeChangeListener(ChangeListenable<?, ?, ?> src) {
			super.removeChangeListener(src);
			checkEmpty();
		}

		/**
		 * source == null: an undefined change occurred, have a more closer look
		 */
		public void notifyChanged(Src source, Target oldValue, Target newValue) {
			super.notifyChanged(source, oldValue, newValue);
			checkEmpty();
		}

	}

	private CompleteChangeNotifyer createChangeNotifyer() {
		// Go through the scope
		// Add listener to everything
		return new CompleteChangeNotifyer();
	}

	public AbstractFunctionNotifyer<?, Src, Target> getChangeNotifyer() {
		if (globalChangeListener == null) {
			globalChangeListener = createChangeNotifyer();
		}
		return globalChangeListener;
	}

	public AbstractFunc(Function<Src, BasicResult<Target>> func,
			BiFunction<? super Src, ? super QueryResult<Src, Target>, ? extends Target> valueUpdater) {
		init(func, valueUpdater);

	}

	// You need to call init!
	@Deprecated
	protected AbstractFunc() {

	}

	public void init(Function<Src, BasicResult<Target>> func,
			BiFunction<? super Src, ? super QueryResult<Src, Target>, ? extends Target> valueUpdater) {
		this.func = func;
		Function<Src, BasicQueryResult<Src, Target>> sfunc = (src) -> {
			BasicResult<Target> result = this.func.apply(src);
			BasicQueryResult<Src, Target> queryResult = new BasicQueryResult<>(this.cache, src, result);
			return queryResult;
		};
		this.valueUpdater = valueUpdater;
		BiConsumer<Src, QueryResult<Src, Target>> updater = null;
		if (valueUpdater != null) {
			updater = (src, qr) -> {
				Target newVal = valueUpdater.apply(src, qr);
				if (qr instanceof BasicQueryResult) {
					BasicQueryResult<Src, Target> bqr = (BasicQueryResult) qr;
					BasicResult<Target> result = bqr.getResult();
					result.setValue(newVal);
				}
			};
		}
		this.cache = new QueryResultCache<Src, QueryResult<Src, Target>>(sfunc, updater);
	}

	protected void updateCache(Src src, Target newValue) {
		QueryResult<Src, Target> result = cache.getIfExists(src);
		if (result instanceof BasicQueryResult) {
			BasicQueryResult<Src, Target> bqr = (BasicQueryResult) result;
			BasicResult<Target> br = bqr.getResult();
			Target oldValue = br.value();
			if (!Objects.equals(oldValue, newValue)) {
				br.setValueRaw(newValue);
				br.notifyChanged(oldValue, newValue);
			}
		}
	}

	protected QueryResult<Src, Target> getCacheIfExists(Src src) {
		return this.cache.getIfExists(src);
	}

	public QueryResult<Src, Target> evaluate(Src src) {
		return this.cache.get(src);
	}

	public abstract Scope<Src> getScope();

	public boolean contains(Src src) {
		return getScope().contains(src);
	}

	protected static <T> T ensure(Object o, Class<T> cl) {
		if (cl.isInstance(o)) {
			return (T) o;
		}
		throw new RuntimeException("Expected class " + cl + " for " + o + "!");
	}

	public Target evaluateBasic(Src src) {
		return evaluate(src).value();
	}

	public Target evaluateBasic(Src src, Target defaultvalue) {
		Target ret = evaluateBasic(src);
		if (ret == null) {
			ret = defaultvalue;
		}
		return ret;
	}

	public FunctionModificator getModificator() {
		return FunctionModificator.NO_MODIFICATOR;
	}

	public Target apply(Src src) {
		return evaluateBasic(src);
	}

	public boolean isUndef(Src src) {
		return evaluateBasic(src) == null;
	}

}
