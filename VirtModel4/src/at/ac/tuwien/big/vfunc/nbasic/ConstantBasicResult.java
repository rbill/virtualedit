package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Objects;

public class ConstantBasicResult<Target> extends BasicResultImpl<Target> {

	public ConstantBasicResult(MetaInfo mi) {
		super(mi);
	}
	
	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		return this;
	}

	@Override
	public Target calcValue() {
		return value();
	}
	
	public void setValue(Target newValue) {
		Target oldValue = value();
		if (!Objects.equals(oldValue, newValue)) {
			setNewValue(oldValue, newValue);
		}
	}

}
