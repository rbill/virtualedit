package at.ac.tuwien.big.vfunc.basic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.impl.BasicFilteredScopeChange;

public interface Scope<Src> extends ScopeNotifyer<Scope<Src>, Src> {

	boolean contains(Src src);
	

	public default void notifyAdded(Src src) {
		notifyChanged(Collections.singleton(src), Collections.emptyList());
	}
	
	public default void notifyAdded(Src... src) {
		notifyChanged(Arrays.asList(src), Collections.emptyList());
	}
	

	public default void notifyDeleted(Src src) {
		notifyChanged(Collections.emptyList(), Collections.singletonList(src));
	}

	public default void notifyDeleted(Src... src) {
		notifyChanged(Collections.emptyList(), Arrays.asList(src));
	}
	
	class FilteredScope<Src> implements Scope<Src>, ModifiedScopeChangeListenable<Scope<Src>, Src> {

		protected final Function<Src,Boolean> filter;
		protected final Scope<Src> baseScope;
		private List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> changeListeners = new ArrayList<>();
		
		
		public FilteredScope(Function<Src,Boolean> filter, Scope<Src> baseScope) {
			this.filter = filter;
			this.baseScope = baseScope;
			baseScope.addChangeListener(this);
		}
		
		@Override
		public boolean contains(Src src) {
			Boolean ret = filter.apply(src);
			return ret != null && ret && baseScope.contains(src);
		}

		@Override
		public Class<Src> getSourceClass() {
			return baseScope.getSourceClass();
		}

		@Override
		public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
			return changeListeners;
		}

		@Override
		public void changeIterable(IterableScopeChange<? extends Scope<Src>, ? extends Src> fsc,
				Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
			List<Src> newAdded = new ArrayList<>();
			for (Src old: added) {
				if (filter.apply(old)) {
					newAdded.add(old);
				}
			}
			baseScope.notifyChanged(newAdded, deleted);
		}

		@Override
		public void changedFiltered(FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc) {
			baseScope.notifyChanged(filter.andThen(x->fsc.wasAdded(x)), (y)->fsc.wasDeleted(y));
		}

		@Override
		public void changedGeneric(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			baseScope.notifyChanged();
		}
		
		public void finalize() throws Throwable {
			super.finalize();
			try {
				if (baseScope != null) {
					baseScope.removeChangeListener(this);
				}
			} catch (Exception e) {
				
			}
		}

	};
	
	public default FilteredScope<Src> filter(Function<Src,Boolean> filter) {
		return new FilteredScope<>(filter, this);
	}
}
