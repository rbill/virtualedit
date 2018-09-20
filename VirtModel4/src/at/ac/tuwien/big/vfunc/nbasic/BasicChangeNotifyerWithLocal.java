package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public interface BasicChangeNotifyerWithLocal extends BasicChangeNotifyer{

	@Override
	public default void addBasicChangeListener(BasicListenable src) {
		getBasicChangeListeners().add(new WeakReference<>(src));
	}
	
	public default void addLocalBasicChangeListener(BasicListenable src) {
		getLocalBasicChangeListeners().add(src);
	}
	
	@Override
	public default void changed() {
		List<WeakReference<BasicListenable>> changeListeners = getBasicChangeListeners();
		new ArrayList<>(changeListeners).forEach(x->{
			BasicListenable cl = x.get();
			if (cl != null) {
				//wird schon passen, hoffe ich, oder nicht?!
				cl.changed(this);
			}
		});
		changeListeners.removeIf(x->x.get()==null);		
		new ArrayList<>(getLocalBasicChangeListeners()).forEach(x->{
			x.changed(this);
		});
	}
	


	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners();
	
	public List<BasicListenable> getLocalBasicChangeListeners();
	

	@Override
	public default void removeBasicChangeListener(BasicListenable src) {
		while (getBasicChangeListeners().removeIf(x->x.get()==src));
	}
	

	public default void removeLocalBasicChangeListener(BasicListenable src) {
		while (getLocalBasicChangeListeners().remove(src));
	}
}
