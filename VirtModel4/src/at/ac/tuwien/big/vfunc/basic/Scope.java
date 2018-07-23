package at.ac.tuwien.big.vfunc.basic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Source;

import at.ac.tuwien.big.vfunc.basic.impl.BasicFilteredScopeChange;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunctionNotifyer;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

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
			notifyChanged(newAdded, deleted);
		}

		@Override
		public void changedFiltered(FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc) {
			notifyChanged(filter.andThen(x->fsc.wasAdded(x)), (y)->fsc.wasDeleted(y));
		}

		@Override
		public void changedGeneric(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			notifyChanged();
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
	

	class FunctionFilteredScope<Src> implements Scope<Src>, ModifiedScopeChangeListenable<Scope<Src>, Src> {

		protected final AbstractFunc<Src,Boolean,?> filter;
		protected final Scope<Src> baseScope;
		private List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> changeListeners = new ArrayList<>();
		
		
		//Und zusaetzlich die Werte
		
		
		//Das ist der Scope - er setzt nur fest, ob etwas hinzugefuegt oder entfernt wird, aber wenn hier etwas hinzugefuegt wird, kann es
		//in wirklichkeit auch entfernt werden!
		private ModifiedScopeChangeListenable<Scope<Src>, Src> filterChangeNotifyer = new ModifiedScopeChangeListenable<Scope<Src>, Src>() {

			//If something was added, it is easy: Just check the base scope and filter
			@Override
			public void changeIterable(IterableScopeChange<? extends Scope<Src>, ? extends Src> fsc,
					Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
				List<Src> newAdded = new ArrayList<>();
				List<Src> newDeleted = new ArrayList<>();
				for (Src add: added) {
					//Value is important
					Boolean bool = filter.evaluateBasic(add);
					if (bool == null) {
						System.err.println("Null for thing in scope?!");
					} else {
						if (bool) {
							//Should be added
							if (baseScope.contains(add)) {
								//Was added already, so no change
							} else {
								newAdded.add(add);
							}
						} else {
							//Should be deleted
							if (baseScope.contains(add)) {
								//Delete
								newDeleted.add(add);
							} else {
								//Was not there already, so no change
							}
						}
					}
				}
				for (Src del: deleted) {
					//Unfortunately we don't know the previous value any more
					//For safety we assume everything changed
					if (baseScope.contains(del)) {
						newAdded.add(del);
					} else {
						newDeleted.add(del);
					}
				}
				FunctionFilteredScope.this.notifyChanged(newAdded, newDeleted);
			}

			@Override
			public void changedFiltered(FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc) {
				FunctionFilteredScope.this.notifyChanged(
						x->(baseScope.contains(x)?fsc.wasDeleted(x):filter.evaluateBasic(x, false)),
						x->(baseScope.contains(x)?!filter.evaluateBasic(x, true):fsc.wasDeleted(x)));
			}

			@Override
			public void changedGeneric(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
				FunctionFilteredScope.this.notifyChanged();
			}
		};
		
		private ChangeListenable<?, Src, Boolean> valueChange = new ChangeListenable<AbstractFunctionNotifyer<?, Src, Boolean>, Src, Boolean>() {

			@Override
			public void changed(Change<? extends AbstractFunctionNotifyer<?, Src, Boolean>, ? extends Src, ? extends Boolean> change) {
				Boolean ov = change.oldValue();
				Boolean nv = change.newValue();
				Src src = change.source();
				boolean oldInScope = baseScope.contains(src);
				if (ov == null) {
					if (nv == null) {
						//Nothing ..
						return;
					} else if (nv) {
						if (oldInScope) {
							//Nothing changed
							return;
						} else {
							//Force thing is scope
							FunctionFilteredScope.this.notifyAdded(src);
						}
					} else {
						//!nv
						if (oldInScope) {
							//Force thing is not in scope
							FunctionFilteredScope.this.notifyDeleted(src);
						} else {
							//Nothing changed
						}
					}
				} else if (ov) {
					//It was in the scope
					if (nv == null) {
						if (oldInScope) {
							//Nothing really changed
						} else {
							//Now it is deleted
							FunctionFilteredScope.this.notifyDeleted(src);
						}
					} else if (nv) {
						//Nothing ..
						return;						
					} else {
						//!nv
						FunctionFilteredScope.this.notifyDeleted(src);
					}
				} else {
					//!ov
					if (nv == null) {
						if (oldInScope) {
							//Now it is added
							FunctionFilteredScope.this.notifyAdded(src);
						} else {
							//Nothing really changed
						}
					} else if (nv) {
						FunctionFilteredScope.this.notifyAdded(src);
					} else {
						//!nv
						//Nothing ..
						return;	
					}
				}
				
			}
		};
		
		public FunctionFilteredScope(AbstractFunc<Src,Boolean,?> filter, Scope<Src> baseScope) {
			this.filter = filter;
			this.baseScope = baseScope;
			baseScope.addChangeListener(this);
			filter.getScope().addChangeListener(filterChangeNotifyer);
			filter.getChangeNotifyer().addChangeListener((ChangeListenable)valueChange);
		}
		
		@Override
		public boolean contains(Src src) {
			Boolean ret = filter.evaluate(src).value();
			return ret == null?baseScope.contains(src):ret;
		}

		@Override
		public Class<Src> getSourceClass() {
			return baseScope.getSourceClass();
		}

		@Override
		public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
			return changeListeners;
		}

		
		//Ich glaube da passt ewtas nicht
		@Override
		public void changeIterable(IterableScopeChange<? extends Scope<Src>, ? extends Src> fsc,
				Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
			notifyChanged(IteratorUtils.filterType(added, x->filter.isUndef(x)),
					IteratorUtils.filterType(deleted, x->filter.isUndef(x)));
		}

		@Override
		public void changedFiltered(FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc) {
			notifyChanged(x->filter.evaluate(x) == null && fsc.wasAdded(x), (y)->filter.evaluate(y) == null && fsc.wasDeleted(y));
		}

		@Override
		public void changedGeneric(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			notifyChanged();
		}
		
		public void finalize() throws Throwable {
			super.finalize();
			try {
				if (baseScope != null) {
					baseScope.removeChangeListener(this);
				}
				if (filter != null && filter.getScope() != null) {
					filter.getScope().removeChangeListener(filterChangeNotifyer);
				}
			} catch (Exception e) {
				
			}
		}

	};
	
	public default FilteredScope<Src> filter(Function<Src,Boolean> filter) {
		return new FilteredScope<>(filter, this);
	}
	
	/**Leider brauche ich bald auch etwas, was keine 'normale', aber eine sich aendernde funktion als filter nimmt ...*/
}
