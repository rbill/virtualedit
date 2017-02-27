package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.impl.SimplePosEditState;

public class AugmentingEditState implements ListEditState {
	
	private Map<Treepos, PosEditState> map = new HashMap<Treepos, PosEditState>();
	private VEditableBag<?> baseBag;
	
	public AugmentingEditState(VEditableBag<?> baseBag) {
		this.baseBag = baseBag;
	}

	@Override
	public PosEditState getEditState(Treepos pos) {
		PosEditState ret = map.get(pos);
		if (ret == null) {
			map.put(pos, ret = new SimplePosEditState());
		}
		return ret;
	}


	@Override
	public long peekEditId() {
		return baseBag.getEditState().peekEditId();
	}

	@Override
	public long advEditId() {
		return baseBag.getEditState().advEditId();
	}

}
