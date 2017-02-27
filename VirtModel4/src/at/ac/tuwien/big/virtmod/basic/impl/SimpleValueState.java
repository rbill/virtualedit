package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.ValueState;

public class SimpleValueState<X> implements ValueState<X> {
	private X value;
	private ContainState state;
	private long editId;
	
	public SimpleValueState(long editId, X value, ContainState state) {
		this.editId = editId;
		this.value = value;
		this.state = state;
	}
	
	

	@Override
	public X value() {
		return value;
	}

	@Override
	public ContainState state() {
		return state;
	}

	@Override
	public long editId() {
		return editId;
	}

}
