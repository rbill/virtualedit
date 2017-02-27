package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.Source;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.virtmod.structure.WrappedGlobalSource;
import at.ac.tuwien.big.vmodel.general.impl.WrappedInfo;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface StaticElement extends VObject {
	
	/**Whether this element is equal to the element which would
	 * have been created by newly calling a get(x)-call on
	 * a previously unassociated value
	 */
	public boolean isSelfEmpty();
	
	/**Change this element so that it is equal to the element which
	 * would have been created by newly calling a get(x)-call of this x
	 */
	public boolean selfClear();
	
	
	
	
	/**Actually this is for adding something*/
	public Editstate getEditState();
	/*
	public default void createdElement(VObject sub) {
		Editstate state = getEditState();
		String elementName = "ele"+state.advEditId();
		
	}*/
}
