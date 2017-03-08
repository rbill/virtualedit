package at.ac.tuwien.big.virtmod.basic.impl.delta;

import java.util.Arrays;
import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaListEditState;

public class SimpleDeltaListEditState implements DeltaListEditState {


	private Iterable<? extends ListEditState> iterable;
	
	public SimpleDeltaListEditState(Iterable<? extends ListEditState> iterable) {
		this.iterable = iterable;
	}
	

	public SimpleDeltaListEditState(ListEditState... editState) {
		this(Arrays.asList(editState));
	}

	@Override
	public Iterator<? extends ListEditState> iterator() {
		return iterable.iterator();
	}

}
