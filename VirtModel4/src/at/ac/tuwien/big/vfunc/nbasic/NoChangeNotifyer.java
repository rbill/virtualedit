package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class NoChangeNotifyer<Target> implements BasicValuedChangeNotifyer<Target> {

	private List<WeakReference<BasicListenable>> changeListeners = new ArrayList<WeakReference<BasicListenable>>();


	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return changeListeners;
	}

	@Override
	public Target value() {
		return null;
	}


	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		return this;
	}
}
