package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.Value;

public class ConstantValue<Target> implements BasicResult<Target> {
	
	private Target value;
	private MetaInfo metaInfo;

	@Override
	public Target value() {
		return value;
	}
	
	public ConstantValue(Target value) {
		this.value = value;
	}
	
	public void setMetaInfo(MetaInfo metaInfo) {
		this.metaInfo = metaInfo;
	}

	public void setValue(Target newValue) {
		if (!Objects.equals(value, newValue)) {
			Target oldValue  = this.value;
			this.value = newValue;	
			notifyChanged(oldValue, newValue);
		}
		
	}

	@Override
	public Target calcValue() {
		return value;
	}
	
	List<WeakReference<BasicListenable>> basicListeners = new ArrayList<>();
	List<WeakReference<NewValueListenable<? super Target>>> changeListeners = new ArrayList<>();

	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return basicListeners;
	}

	@Override
	public List<WeakReference<NewValueListenable<? super Target>>> getChangeListeners() {
		return changeListeners;
	}

	@Deprecated
	@Override
	public void setNewValue(Target oldValue, Target newValue) {
		//cannot happen
		setValue(newValue);
		System.err.println("SetNewValue called when it should not be (call setValue!)");
		new Exception().printStackTrace();
	}

	@Override
	public void changed(Change<? extends FunctionNotifyer<?, Object, Object>, ? extends Object, ? extends Object> change) {
		// Whatever, does not use it
		System.err.println("changed called when it should not be (should not have been called)");
		new Exception().printStackTrace();
	}

	@Override
	public MetaInfo getMetaInfo() {
		return metaInfo;
	}

	@Override
	public void setValueRaw(Target newValue) {
		setValue(newValue);
	}


}
