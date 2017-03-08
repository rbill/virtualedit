package at.ac.tuwien.big.virtmod.basic.impl.delta;

import java.util.Arrays;
import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaEditState;

public class SimpleDeltaEditState implements DeltaEditState {

	private Iterable<? extends Editstate> iterable;
	
	public SimpleDeltaEditState(Editstate... editState) {
		this(Arrays.asList(editState));
	}
	
	public SimpleDeltaEditState(Iterable<? extends Editstate> iterable) {
		this.iterable = iterable;
	}

	@Override
	public Iterator<? extends Editstate> iterator() {
		return iterable.iterator();
	}

}
