package at.ac.tuwien.big.virtmod.basic.impl.delta;

import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaPosEditState;

public class SimpleDeltaPosEditState implements DeltaPosEditState {



	private Iterable<? extends PosEditState> iterable;
	
	public SimpleDeltaPosEditState(Iterable<? extends PosEditState> iterable) {
		this.iterable = iterable;
	}

	@Override
	public Iterator<? extends PosEditState> iterator() {
		return iterable.iterator();
	}
}
