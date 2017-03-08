package at.ac.tuwien.big.virtmod.basic.delta;

import java.util.Iterator;

import at.ac.tuwien.big.virtmod.basic.Editstate;

public interface DeltaEditState extends Editstate {
	

	public default long peekEditId() {
		long ret = -1;
		Iterator<? extends Editstate> iter = iterator();
		while (iter.hasNext()) {
			Editstate es = iter.next();
			ret = Math.max(ret,es.peekEditId());
		}
		return ret;
	}
	
	public default long advEditId() {
		long ret = -1;
		Iterator<? extends Editstate> iter = iterator();
		while (iter.hasNext()) {
			Editstate es = iter.next();
			ret = Math.max(ret,es.advEditId());
		}
		return ret;
	}

	public Iterator<? extends Editstate> iterator();

}
