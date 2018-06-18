package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.VFunc;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class ChainedFunction<Src, Mid, Target>
		implements FunctionNotifyer<ChainedFunction<Src, Mid, Target>, Src, Target>, VFunc<Src, Target> {

	private final VFunc<Src, Mid> first;
	private final VFunc<Mid, Target> second;
	private List<WeakReference<ChangeListenable<? super ChainedFunction<Src, Mid, Target>, ? super Src, ? super Target>>> changeListeners = new ArrayList<>();
	private Scope<Src> myScope;

	public ChainedFunction(VFunc<Src, Mid> first, VFunc<Mid, Target> second) {
		this.first = first;
		this.second = second;
		if (first.getScope() instanceof FixedFinitScope) {
			FixedFinitScope<Src> firstScope = (FixedFinitScope) first.getScope();

			myScope = new FixedFinitScope<Src>() {

				List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> changeListeners = new ArrayList<>();

				@Override
				public boolean contains(Src src) {
					if (!first.containsKey(src)) {
						return false;
					}
					//TODO: Extrem schlecht, aber wie mache ich es besser?
					Mid mid = first.evaluateReduced(src);
					return second.getScope().contains(mid);
				}

				@Override
				public Class<Src> getSourceClass() {
					return first.getScope().getSourceClass();
				}

				@Override
				public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
					return changeListeners;
				}

				@Override
				public Iterator<Src> iterator() {
					Function<Src, Boolean> filter = (src) -> {
						Mid mid = first.evaluateReduced(src);
						return second.getScope().contains(mid);
					};
					return IteratorUtils.filterType(firstScope.iterator(), filter);
				}

			};

		} else {
			myScope = new Scope<Src>() {

				List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> changeListeners = new ArrayList<>();

				@Override
				public boolean contains(Src src) {
					if (!first.containsKey(src)) {
						return false;
					}
					Mid mid = first.evaluateReduced(src);
					return second.getScope().contains(mid);
				}

				@Override
				public Class<Src> getSourceClass() {
					return first.getScope().getSourceClass();
				}

				@Override
				public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
					return changeListeners;
				}

			};
		}
	}

	@Override
	public List<WeakReference<ChangeListenable<? super ChainedFunction<Src, Mid, Target>, ? super Src, ? super Target>>> getChangeListeners() {
		return changeListeners;
	}

	// Scope ist ein Subscope von first .. n‰mlich wenn first etwas
	// zuruecklifert, was auch second versteht

	@Override
	public CompleteResult<Src, Target> priv_calcResult(Src source) {
		//Jetzt weiﬂ ich es wieder ... es war: Das reasoning umformulieren ...
		CompleteResult<Src, Target> ret = new BasicCompleteResult<ChainedFunction.Src, ChainedFunction.Target>(reason, source, target, usedResults)
		return second.g
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scope<Src> getScope() {
		return myScope;
	}

	@Override
	public FunctionType<Src, Target> getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompleteResult<Src, Target> getOrNull(Src src) {
		// TODO Auto-generated method stub
		return null;
	}

}
