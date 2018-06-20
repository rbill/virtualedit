package at.ac.tuwien.big.vfunc.nbasic;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.Refreshable;
import at.ac.tuwien.big.vfunc.basic.Value;

public interface BasicResult<Target> extends ValueRefreshable<Target>, 
	ChangeListenable<FunctionNotifyer<?,Object,Object>, Object, Object>,
	ValueChangeNotifyer<BasicResult<Target>, Target> {

	public MetaInfo getMetaInfo();
	
	public void setValueRaw(Target newValue);
	
	@Override
	public default void setNewValue(Target oldValue, Target newValue) {
		setValueRaw(newValue);
		notifyChanged(oldValue, newValue);
	}
	
}
