package at.ac.tuwien.big.verocl.parameterdesc;

import java.util.Collection;

public interface Points {
	

	public PointDesc getDesc();
	
	public boolean contains(Object[] pointValues);
	
	public default boolean contains(SinglePoint point) {
		return contains(point.getValues());
	}
	
	
	public Collection<? extends Points> getNext(); 

}
