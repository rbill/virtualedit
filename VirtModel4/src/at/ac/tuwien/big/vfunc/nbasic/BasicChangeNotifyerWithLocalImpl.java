package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class BasicChangeNotifyerWithLocalImpl implements BasicChangeNotifyerWithLocal {

	 List<WeakReference<BasicListenable>> bcl = new ArrayList<WeakReference<BasicListenable>>();
	 List<BasicListenable> lbcl = new ArrayList<>();
	 
	
	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return bcl;
	}

	@Override
	public List<BasicListenable> getLocalBasicChangeListeners() {
		return lbcl;
	}

	
}
