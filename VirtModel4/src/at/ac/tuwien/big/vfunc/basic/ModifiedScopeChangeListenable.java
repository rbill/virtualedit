package at.ac.tuwien.big.vfunc.basic;

public interface ModifiedScopeChangeListenable<N extends ScopeNotifyer<?,Source>,Source> extends ScopeChangeListenable<N, Source>{
	
	@Override
	public default void changed(ScopeChange<? extends  N, ? extends Source> change) {
		if (change instanceof IterableScopeChange) {
			IterableScopeChange<? extends N, ? extends Source> fsc = (IterableScopeChange)change;
			changeIterable(fsc,fsc.getAdded(),fsc.getDeleted());
		} else {
			if (change instanceof FilteredScopeChange) {
				FilteredScopeChange<? extends N, ? extends Source> fsc = (FilteredScopeChange)change;
				changedFiltered(fsc);
			} else {
				changedGeneric(change);
			}
		}
	}

	public void changeIterable(IterableScopeChange<? extends N, ? extends Source> fsc, Iterable<? extends Source> added,
			Iterable<? extends Source> deleted);

	public void changedFiltered(FilteredScopeChange<? extends N, ? extends Source> fsc);

	public void changedGeneric(ScopeChange<? extends N, ? extends Source> change);

}
