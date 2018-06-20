package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;

public abstract class BasicResultImpl<Target> implements BasicResult<Target> {

	private Target lastValue;
	private MetaInfo metaInfo;
	
	public BasicResultImpl(MetaInfo mi) {
		this.metaInfo = mi;
	}
	
	@Override
	public abstract Target calcValue();

	@Override
	public Target value() {
		return lastValue;
	}

	@Override
	public void changed(Change<? extends FunctionNotifyer<?, Object, Object>, ? extends Object, ? extends Object> change) {
		refresh();
	}
	
	List<WeakReference<NewValueListenable<? super Target>>> changeListeners = new ArrayList<>();
	List<WeakReference<BasicListenable>> basicChangeListeners = new ArrayList<>();

	@Override
	public List<WeakReference<NewValueListenable<? super Target>>> getChangeListeners() {
		return changeListeners;
	}
	

	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return basicChangeListeners;
	}

	@Override
	public MetaInfo getMetaInfo() {
		return metaInfo;
	}

	@Override
	public void setValueRaw(Target newValue) {
		this.lastValue = newValue;
	}

}
