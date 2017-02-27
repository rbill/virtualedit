package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.TreeposType;

public class SimplePosEditState implements PosEditState {

	private int[] index = new int[TreeposType.values().length];
	
	@Override
	public int getIndex(TreeposType type) {
		return index[type.ordinal()];
	}

	@Override
	public int popIndex(TreeposType type) {
		return ++index[type.ordinal()];
	}

}
