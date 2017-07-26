package at.ac.tuwien.big.verocl.parameterdesc.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRef;
import at.ac.tuwien.big.verocl.parameterdesc.SingleModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.virtmod.multiref.ModelRef;

public class SingleModelPointImpl extends SinglePointImpl implements SingleModelPoint {

	public SingleModelPointImpl(PseudoModelRef modelRef, PointDesc desc) {
		super(desc,modelRef.getValues());
		this.modelRef = modelRef;
	}

	private PseudoModelRef modelRef;
	
	public boolean equals(Object other) {
		return (other instanceof SinglePoint) && equals((SinglePoint)other);
	}
	
	@Override
	public PseudoModelRef getModelRef() {
		return modelRef;
	}
	
	@Override
	public Collection<SinglePoint> getNext() {
		return Collections.emptyList();
	}
}
