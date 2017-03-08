package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.impl.SimpleDoubleVFunc;

public interface ParameterInvertibleFunc<X,Y,Z> 
	extends VEntryIterableFunc<X, VEntryIterableFunc<Y, Z>>, DoubleParameterFunc<X, Y, Z> {
	
	public ParameterInvertibleFunc<Y,X,Z> parameterInvert();
	
	@Override
	public default Z get(X x, Y y) {
		return get(x).get(y);
	}

	public static<X, Y, Z extends StaticElement, F extends VEntryIterableFunc<X, ? extends VEntryIterableFunc<Y, Z>>> ParameterInvertibleFunc<X, Y, Z> ensureInvertible(
			F func) {
		if (func instanceof ParameterInvertibleFunc) {
			return (ParameterInvertibleFunc<X, Y, Z>)func;
		} else {
			return new SimpleDoubleVFunc<X,Y,Z,F>(func.store(),func);
		}
	}
	

	//public ParameterInvertibleFunc<X,Y,Z,K,L> baseClone(VContainer newCont, DoubleCreater<X, Y, Z> newCreator);

}
