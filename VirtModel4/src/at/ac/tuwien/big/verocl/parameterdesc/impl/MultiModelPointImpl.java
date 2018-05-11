package at.ac.tuwien.big.verocl.parameterdesc.impl;

import java.util.Arrays;

import at.ac.tuwien.big.verocl.parameterdesc.MultiModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRef;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;

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
	
	@Override
	public boolean equals(Object o) {
		//TODO: Stimmt so vielleicht nicht
		if (o instanceof MultiPoint) {
			return equals((MultiPoint)o);
		}
		if (o instanceof MultiModelPoint) {
			return equals((MultiModelPoint)o);
		}
		return false;
	}
	
	public boolean equals(MultiPoint mp) {
		for (SinglePoint p: mp.getPoints()) {
			if (!contains(p)) {
				return false;
			}
		}
		for (SinglePoint p: getPoints()) {
			if (!mp.contains(p)) {
				return false;
			}
		}
		return true;
	}

	public boolean equals(MultiModelPoint mp) {
		for (SinglePoint p: mp.getPoints()) {
			if (!contains(p)) {
				return false;
			}
		}
		for (SinglePoint p: getPoints()) {
			if (!mp.contains(p)) {
				return false;
			}
		}
		return true;
	}

	
	@Override
	public int hashCode() {
		int ret = 0;
		for (SinglePoint sp: getPoints()) {
			ret+= sp.hashCode();
		}
		return ret;
	}


	
	public String toString() {
		return _toString();
	}

}
