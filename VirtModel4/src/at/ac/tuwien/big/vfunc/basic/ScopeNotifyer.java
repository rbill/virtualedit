package at.ac.tuwien.big.vfunc.basic;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.impl.BasicChange;
import at.ac.tuwien.big.vfunc.basic.impl.BasicColScopeChange;
import at.ac.tuwien.big.vfunc.basic.impl.BasicFilteredScopeChange;
import at.ac.tuwien.big.vfunc.basic.impl.BasicScopeChange;

public interface ScopeNotifyer<This extends ScopeNotifyer<This,Source>, Source> {
	
	public Class<Source> getSourceClass();
	
	public default void addChangeListener(ScopeChangeListenable<? super This,? super Source> src) {
		getChangeListeners().add(new WeakReference<ScopeChangeListenable<? super This,? super Source>>(src));
	}
	
	public default void removeChangeListener(ScopeChangeListenable<?,?> src) {
		while (getChangeListeners().removeIf(x->x.get()==src));
	}
	
	public List<WeakReference<ScopeChangeListenable<? super This,? super Source>>> getChangeListeners();
	
	/**source == null: an undefined change occurred, have a more closer look*/
	public default void notifyChanged() {
		priv_notifyChange(new BasicScopeChange<This,Source>((This)this));
	}

	default void priv_notifyChange(ScopeChange<This,Source> change) {
		List<WeakReference<ScopeChangeListenable<? super This,? super Source>>> changeListeners = getChangeListeners();
		changeListeners.forEach(x->{
			ScopeChangeListenable<? super This,? super Source> cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.changed(change);
			}
		});
		changeListeners.removeIf(x->x.get()==null);		
	}
	
 	/**source == null: an undefined change occurred, have a more closer look*/
	public default void notifyChanged(Function<? super Source,Boolean> added, Function<? super Source,Boolean> deleted) {
		BasicFilteredScopeChange<This, Source> bfsc = new BasicFilteredScopeChange<This,Source>((This)this, getSourceClass(), added, deleted);
		priv_notifyChange(bfsc);
	}
	

 	/**source == null: an undefined change occurred, have a more closer look*/
	public default void notifyChanged(Iterable<? extends Source> added, Iterable<? extends Source> deleted) {
		BasicColScopeChange<This, Source> bfsc = new BasicColScopeChange<>((This)this, added, deleted);
		priv_notifyChange(bfsc);
	}

	
}
