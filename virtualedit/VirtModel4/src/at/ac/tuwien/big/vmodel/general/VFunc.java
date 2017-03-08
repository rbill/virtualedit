package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.structure.VContainer;

public interface VFunc<X,Y> extends StaticElement {
	
	/**Gets the value associated to x.
	 * Depending on the type of function, this may return null or not
	 */
	public Y get(X x);
	
	
	//public VFunc<X,Y> baseClone(VContainer newCont, Creater<Y, X> newCreator);

}
