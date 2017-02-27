package at.ac.tuwien.big.virtmod.basic;

import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaEditState;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaListEditState;

public interface Editstate {

	public long peekEditId();
	
	public long advEditId();

	public static Editstate merge(Editstate editState, Editstate editState2) {
		if (editState instanceof ListEditState && editState2 instanceof ListEditState) {
			return new SimpleDeltaListEditState((ListEditState)editState,(ListEditState)editState2);
		} else if (editState instanceof Editstate && editState2 instanceof Editstate) {
			return new SimpleDeltaEditState((Editstate)editState,(Editstate)editState2);
		} else {
			throw new RuntimeException("Incompatible types "+editState+", "+editState2);
		}
	}
	
}
