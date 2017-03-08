package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.TreeposType;

public interface DeltaPosEditState extends PosEditState {

	public default int getIndex(TreeposType type) {
		int ret = 0;
		Iterator<? extends PosEditState> iter = iterator();
		while (iter.hasNext()) {
			PosEditState next = iter.next();
			ret = Math.max(next.getIndex(type),ret);
		}
		return ret;
	}
	
	public default int popIndex(TreeposType type)  {
		int ret = 0;
		Iterator<? extends PosEditState> iter = iterator();
		while (iter.hasNext()) {
			PosEditState next = iter.next();
			ret = Math.max(next.popIndex(type),ret);
		}
		return ret;
	}
	
	public Iterator<? extends PosEditState> iterator();
}
