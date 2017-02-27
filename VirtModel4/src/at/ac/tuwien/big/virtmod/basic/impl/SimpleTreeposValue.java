package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.TreeposValue;

public class SimpleTreeposValue implements TreeposValue {
	protected int value;


	public String toString() {
		return String.valueOf(value);
	}
	
	public SimpleTreeposValue(int value) {
		this.value = value;
	}
	
	@Override
	public int value() {
		return value;
	}


}
