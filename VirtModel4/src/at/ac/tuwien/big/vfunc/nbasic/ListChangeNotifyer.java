package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.List;

public interface ListChangeNotifyer<T> extends BasicChangeNotifyer, List<T> {

	public default void added(int index, T object) {
		List<WeakReference<ListListenable<T>>> changeListeners = getListChangeListeners();
		changeListeners.forEach(x->{
			ListListenable<T> cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.added(index, object, this);
			}
		});
		changeListeners.removeIf(x->x.get()==null);
		changed();
	}
	
	public default void addListChangeListener(ListListenable<T> src) {
		getListChangeListeners().add(new WeakReference<>(src));
	}
	
	public default void changed(int index, T oldObject, T newObject) {
		List<WeakReference<ListListenable<T>>> changeListeners = getListChangeListeners();
		changeListeners.forEach(x->{
			ListListenable<T> cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.changed(index, oldObject, newObject, this);
			}
		});
		changeListeners.removeIf(x->x.get()==null);
		changed();
	}
	
	public List<WeakReference<ListListenable<T>>> getListChangeListeners();
	
	public default void removed(int index, T object) {
		List<WeakReference<ListListenable<T>>> changeListeners = getListChangeListeners();
		changeListeners.forEach(x->{
			ListListenable<T> cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.removed(index, object, this);
			}
		});
		changeListeners.removeIf(x->x.get()==null);
		changed();
	}
	

	public default void removeListChangeListener(ListListenable<T> src) {
		while (getListChangeListeners().removeIf(x->x.get()==src));
	}
}
