package at.ac.tuwien.big.virtmod.ecore;

import java.util.Set;

public interface DualUnorderedMap<X,Y> {

	public Set<X> getX(Y forY);
	
	public Set<Y> getY(X forX);
	
	public boolean add(X x, Y y);
	
	public boolean remove(X x, Y y);
}
