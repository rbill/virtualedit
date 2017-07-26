package at.ac.tuwien.big.verocl.parameterdesc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiModelPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.SingleModelPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.SinglePointImpl;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public interface MultiModelPoint extends MultiPoint {
	public Iterable<PseudoModelRef> getModelValues();
	
	public default Iterable<Object[]> getValues() {
		return IteratorUtils.convert(getModelValues(), (x)->x.getValues());
	}
	
	public default Iterator<SingleModelPoint> modelIterator() {
		return IteratorUtils.convert(getModelValues().iterator(), (x)->new SingleModelPointImpl(x,getDesc()));
	}
	
	public default Iterator<SinglePoint> iterator() {
		return (Iterator)modelIterator();
	}
	

	public default MultiModelPoint intersectWith(Points other) {
		List<PseudoModelRef> retValues = new ArrayList<>();
		for (PseudoModelRef obj: getModelValues()) {
			if (other.contains(obj.getValues())) {
				retValues.add(obj);
			}
		}
		MultiModelPointImpl ret = new MultiModelPointImpl(getDesc(), retValues);
		return ret;
	}

	public default MultiModelPoint intersectWithOrSame(Points other) {
		List<PseudoModelRef> retValues = new ArrayList<>();
		boolean sameRet = true;
		for (PseudoModelRef obj: getModelValues()) {
			if (other.contains(obj.getValues())) {
				retValues.add(obj);
			} else {
				sameRet = false;
			}
		}
		if (sameRet) {
			return this;
		}
		MultiModelPointImpl ret = new MultiModelPointImpl(getDesc(), retValues);
		return ret;
	}
}
