package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;

public class SimpleListEditState extends SimpleEditState implements ListEditState {

	private Map<Treepos, PosEditState> map = new HashMap<Treepos, PosEditState>();

	@Override
	public PosEditState getEditState(Treepos pos) {
		PosEditState ret = map.get(pos);
		if (ret == null) {
			map.put(pos, ret = new SimplePosEditState());
		}
		return ret;
	}

}
