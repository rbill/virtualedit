package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.List;

public interface BasicChangeNotifyerWithLocal extends BasicChangeNotifyer{

	public default void changed() {
		List<WeakReference<BasicListenable>> changeListeners = getBasicChangeListeners();
		changeListeners.forEach(x->{
			BasicListenable cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.changed(this);
			}
		});
		changeListeners.removeIf(x->x.get()==null);		
		getLocalBasicChangeListeners().forEach(x->{
			x.changed(this);
		});
	}
	
	public default void addBasicChangeListener(BasicListenable src) {
		getBasicChangeListeners().add(new WeakReference<BasicListenable>(src));
	}
	
	public default void removeBasicChangeListener(BasicListenable src) {
		while (getBasicChangeListeners().removeIf(x->x.get()==src));
	}
	


	public default void addLocalBasicChangeListener(BasicListenable src) {
		getLocalBasicChangeListeners().add(src);
	}
	
	public default void removeLocalBasicChangeListener(BasicListenable src) {
		while (getLocalBasicChangeListeners().remove(src));
	}
	

	public List<WeakReference<BasicListenable>> getBasicChangeListeners();
	

	public List<BasicListenable> getLocalBasicChangeListeners();
}
