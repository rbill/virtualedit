package at.ac.tuwien.big.verocl.parameterdesc.impl;

import java.util.Arrays;

import at.ac.tuwien.big.verocl.parameterdesc.MultiModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRef;

public class MultiModelPointImpl extends AbstractPoint implements MultiModelPoint {

	public MultiModelPointImpl(PointDesc desc, Iterable<PseudoModelRef> refs) {
		super(desc);
		this.refs = refs;
	}
	
	private Iterable<PseudoModelRef> refs;

	@Override
	public Iterable<PseudoModelRef> getModelValues() {
		return refs;
	}

	@Override
	public boolean contains(Object[] pointValues) {
		for (PseudoModelRef pmr: refs) {
			if (Arrays.equals(pmr.getValues(),pointValues))  {
				return true;
			}
		}
		return false;
	}

}
