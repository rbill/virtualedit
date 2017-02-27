package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.helper.annotation.VProp;

public interface EditableIntegerValueElement extends IntegerValueElement {

	public void add(int value);
	
	public default void clear() {
		set(0);
	}
	

	public default void nullify() {
		set(0);
	}
	
	public default void set(int value) {
		add(value-getValue());
	}

	public default boolean setMax(int i) {
		if (getValue()>i) {
			set(i);
			return true;
		} else {
			return false;
		}
	}
	
	public default boolean setMin(int i) {
		if (getValue()<i) {
			set(i);
			return true;
		}
		return false;
	}
}
