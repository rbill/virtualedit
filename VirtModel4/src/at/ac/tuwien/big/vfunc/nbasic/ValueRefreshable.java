package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Objects;

import at.ac.tuwien.big.vfunc.basic.Refreshable;
import at.ac.tuwien.big.vfunc.basic.Value;

public interface ValueRefreshable<Target> extends Refreshable, Value<Target> {

	public void setNewValue(Target oldValue, Target newValue);
	
	public Target calcValue();
	
	public default void refresh() {
		Target oldVal = value();
		Target val = calcValue();
		if (!Objects.equals(oldVal, val)) {
			setNewValue(oldVal, val);
		}
	}
}
