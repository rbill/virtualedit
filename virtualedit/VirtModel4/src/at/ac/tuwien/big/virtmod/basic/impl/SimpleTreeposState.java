package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposState;

public class SimpleTreeposState extends SimpleValueState<Treepos> implements TreeposState {
	
	
	public SimpleTreeposState(long editId, Treepos treepos, ContainState state) {
		super(editId,treepos,state);
	}
	
	

	@Override
	public Treepos treepos() {
		return super.value();
	}
	
}
