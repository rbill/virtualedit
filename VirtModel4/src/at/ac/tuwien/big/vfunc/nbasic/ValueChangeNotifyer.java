package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.impl.BasicChange;

public interface ValueChangeNotifyer<This extends ValueChangeNotifyer<This,Target>, Target> extends BasicValuedChangeNotifyer<Target>,  BasicChangeNotifyer {
	
	public default void addChangeListener(NewValueListenable<? super Target> src) {
		getChangeListeners().add(new WeakReference<NewValueListenable<? super Target>>(src));
	}
	
	public default void removeChangeListener(NewValueListenable<?> src) {
		while (getChangeListeners().removeIf(x->x.get()==src));
	}
	
	public List<WeakReference<NewValueListenable<? super Target>>> getChangeListeners();
	
	/**source == null: an undefined change occurred, have a more closer look*/
	public default void notifyChanged(Target oldValue, Target newValue) {
		List<WeakReference<NewValueListenable<? super Target>>> changeListeners = getChangeListeners();
		changeListeners.forEach(x->{
			NewValueListenable<? super Target> cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.changed(oldValue,newValue);
			}
		});
		changeListeners.removeIf(x->x.get()==null);		
		changed();
	}


}
