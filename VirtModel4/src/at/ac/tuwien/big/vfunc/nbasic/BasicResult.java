package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Objects;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.Refreshable;
import at.ac.tuwien.big.vfunc.basic.Value;

public interface BasicResult<Target> extends ValueRefreshable<Target>, 
	ChangeListenable<FunctionNotifyer<?,Object,Object>, Object, Object>,
	ValueChangeNotifyer<BasicResult<Target>, Target>,
	PartialResult {

	public MetaInfo getMetaInfo();
	
	public void setValueRaw(Target newValue);
	

	
	public default void checkNewValue(Target newValue) {
		Target curValue = value();
		if (!Objects.equals(curValue,newValue)) {
			setNewValue(curValue,newValue);
		}
	}
	
	@Override
	public default void setNewValue(Target oldValue, Target newValue) {
		setValueRaw(newValue);
		notifyChanged(oldValue, newValue);
	}
	
}
