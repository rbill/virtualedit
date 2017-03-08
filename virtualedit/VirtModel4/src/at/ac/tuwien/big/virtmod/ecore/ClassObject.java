package at.ac.tuwien.big.virtmod.ecore;

import java.util.Set;

public interface ClassObject<A> {
	
	public void setClass(A object, String cl);

	public String getClass(A uuid);

}
