package at.ac.tuwien.big.vfunc.basic.impl;

import java.awt.image.FilteredImageSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FilteredScopeChange;
import at.ac.tuwien.big.vfunc.basic.IterableScopeChange;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChange;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;

public class BasicUnionScope<Src, CollectionType extends Scope<Src>> implements Scope<Src> {

	protected Collection<? extends CollectionType> scopes;
	
	
	private boolean notInAnyScopeOtherThan(Src added, Object excludedScope) {
		for (CollectionType scope: scopes) {
			if (scope == excludedScope) {continue;}
			if (scope.contains(added)) {
				return false;
			}
		}
		return true;
	}
	
	private  ScopeChangeListenable<? super Scope<Src>, ? super Src> subScopeListener = new ScopeChangeListenable<Scope<Src>, Src>() {

		@Override
		public void changed(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			if (change instanceof IterableScopeChange) {
				IterableScopeChange<? extends Scope<Src>, ? extends Src> isc = (IterableScopeChange)change;
				List<Src> addedList = new ArrayList<Src>();
				List<Src> deletedList = new ArrayList<Src>();
				Scope<Src> source = isc.source();
				isc.getAdded().forEach(x->{
					if (notInAnyScopeOtherThan(x, source)) {
						addedList.add(x);
					}
				});
				isc.getDeleted().forEach(x->{
					if (notInAnyScopeOtherThan(x, source)) {
						deletedList.add(x);
					}
				});
				if (!addedList.isEmpty() || !deletedList.isEmpty()) {
					notifyChanged(addedList, deletedList);
				}
			} else { 
				//Everything may have changed ...
				if (change instanceof FilteredScopeChange) {
					FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc = (FilteredScopeChange)change;
					BasicUnionScope.this.notifyChanged(
							//added only if it was not already there
							(added)->{
								if (!fsc.wasAdded(added)) {
									return false;
								}
								for (CollectionType scope: scopes) {
									if (scope == fsc.source()) {continue;}
									if (scope.contains(added)) {
										return false;
									}
								}
								return true;
							}
							, 
							//Deleted only if not in any other scope
							(deleted)->{
								if (!fsc.wasDeleted(deleted)) {
									return false;
								}
								for (CollectionType scope: scopes) {
									if (scope == fsc.source()) {continue;}
									if (scope.contains(deleted)) {
										return false;
									}
								}
								return true;
							}
							);
				} else {
					BasicUnionScope.this.notifyChanged();
				}
			}
		}

	};
	
	public BasicUnionScope(Collection<? extends CollectionType> scopes) {
		this.scopes = scopes;
		for (Scope<Src> sc: scopes) {
			sc.addChangeListener(subScopeListener);
		}
	}
	
	
	@Override
	public boolean contains(Src src) {
		for (CollectionType col: scopes) {
			if (col.contains(src)) {
				return true;
			}
		}
		return false;
	}

	
	private List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> changeListeners = new ArrayList<>();

	@Override
	public List<WeakReference<ScopeChangeListenable<? super Scope<Src>, ? super Src>>> getChangeListeners() {
		return changeListeners;
	}

}
