package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.TreeposValue;

public class UnspecifiedTreeposValue implements TreeposValue {
	
	public static final UnspecifiedTreeposValue INSTANCE = new UnspecifiedTreeposValue();

	@Override
	public int value() {
		return 0;
	}

	@Override
	public TreeposType type() {
		return TreeposType.UNSPECIFIED;
	}

}
