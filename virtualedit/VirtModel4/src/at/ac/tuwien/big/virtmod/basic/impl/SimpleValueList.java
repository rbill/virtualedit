package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.ValueState;

public class SimpleValueList<X> extends SimpleAbstractSublist<X, ValueState<X>> {

	@Override
	public ValueState<X> createValueState(long editId, X pos, ContainState state) {
		return new SimpleValueState(editId,pos,state);
	}

}
