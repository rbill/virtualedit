package at.ac.tuwien.big.verocl.parameterdesc.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.Points;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class MultiPointImpl extends AbstractPoint implements MultiPoint {

	public MultiPointImpl(PointDesc desc) {
		super(desc);
	}
	
	public MultiPointImpl(PointDesc desc, SinglePoint... values) {
		this(desc,new ArrayList<>(Arrays.asList(values)));
	}
	
	public MultiPointImpl(PointDesc desc, List<SinglePoint> values) {
		super(desc);
		this.values = values;
	}
	
	private List<SinglePoint> values = new ArrayList<>();
	
	public void addValue(SinglePoint val) {
		this.values.add(val);
	}
	
	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public MultiPointImpl intersectWith(MultiPointImpl other) {
		if (values.size() > other.values.size()) {
			return other.intersectWith(this);
		}
		List<SinglePoint> newValues = new ArrayList<>();
		for (SinglePoint val: values) {
			for (SinglePoint ot: other.values) {
				if (Arrays.equals(val.getValues(), ot.getValues())) {
					newValues.add(val);
					break;
				}
			}
		}
		return new MultiPointImpl(getDesc(),newValues);
	}

	@Override
	public boolean contains(Object[] pointValues) {
		for (SinglePoint o: values) {
			if (Arrays.equals(o.getValues(), pointValues)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return IteratorUtils.buildString(values,(x)->Arrays.toString(x.getValues()),"{","}",",");
	}

	@Override
	public Iterator<SinglePoint> iterator() {
		return values.iterator();
	}

}
