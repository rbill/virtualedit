package at.ac.tuwien.big.verocl.parameterdesc;

import java.util.Collection;

import at.ac.tuwien.big.virtmod.multiref.ModelRef;

/**Reference to a single point*/
public interface SinglePoint  extends Points {
	
	public Object[] getValues();
	
	public Collection<? extends SinglePoint> getNext();

}
