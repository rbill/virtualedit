package at.ac.tuwien.big.vfunc.basic;

import java.lang.ref.WeakReference;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.impl.BasicChange;

public interface Notifyer<This extends Notifyer<This,Source,Target>, Source, Target> {
	
	public default void addChangeListener(ChangeListenable<? super This,? super Source, ? super Target> src) {
		getChangeListeners().add(new WeakReference<ChangeListenable<? super This,? super Source,? super Target>>(src));
	}
	
	public default void removeChangeListener(ChangeListenable<?,?,?> src) {
		while (getChangeListeners().removeIf(x->x.get()==src));
	}
	
	public List<WeakReference<ChangeListenable<? super This,? super Source,? super Target>>> getChangeListeners();
	
	public default void notifyChanged(Source source, Target oldValue, Target newValue) {
		List<WeakReference<ChangeListenable<? super This,? super Source,? super Target>>> changeListeners = getChangeListeners();
		BasicChange<This, Source, Target> bc = new BasicChange<>((This)this, source, oldValue, newValue);
		changeListeners.forEach(x->{
			ChangeListenable<? super This,? super Source,? super Target> cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.changed(bc);
			}
		});
		changeListeners.removeIf(x->x.get()==null);		
	}

}