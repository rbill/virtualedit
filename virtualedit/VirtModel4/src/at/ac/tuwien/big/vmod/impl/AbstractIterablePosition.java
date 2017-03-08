package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.type.IterableType;

public abstract class AbstractIterablePosition<T,Type extends IterableType> extends SimpleGeneralElement<Type> implements IterablePosition<T> {

	public AbstractIterablePosition(Type type) {
		super(type);
	}
	

}
