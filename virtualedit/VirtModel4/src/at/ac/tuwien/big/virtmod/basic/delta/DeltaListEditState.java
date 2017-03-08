package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaPosEditState;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface DeltaListEditState extends ListEditState, DeltaEditState {


	public default PosEditState getEditState(Treepos pos) {
		return new SimpleDeltaPosEditState(  ()->IteratorUtils.convert(iterator(),(x)->x.getEditState(pos)));
	}

	public Iterator<? extends ListEditState> iterator();
}
