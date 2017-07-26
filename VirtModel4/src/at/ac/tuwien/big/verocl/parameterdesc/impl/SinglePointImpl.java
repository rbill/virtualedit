package at.ac.tuwien.big.verocl.parameterdesc.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.virtmod.multiref.ModelRef;

public class SinglePointImpl extends AbstractPoint implements SinglePoint {
	
	public SinglePointImpl(PointDesc desc) {
		super(desc);
		this.values = new Object[desc.getParameterDescs().size()];
		this.hashCode = Arrays.hashCode(values);
	}

	public SinglePointImpl(PointDesc desc, Object... x) {
		super(desc);
		this.values = x;
		this.hashCode = Arrays.hashCode(values);
	}
	
	public void initModelRef(ModelRef ref) {
		this.modelRef = ref;
	}

	private Object[] values;
	private int hashCode;
	private ModelRef modelRef;
	

	@Override
	public Object[] getValues() {
		return values;
	}

	@Override
	public boolean contains(Object[] pointValues) {
		return Arrays.equals(values, pointValues);
	}
	
	public boolean equals(Object other) {
		return (other instanceof SinglePoint) && equals((SinglePoint)other);
	}
	
	public boolean equals(SinglePoint other) {
		return Arrays.equals(values, other.getValues());
	}
	
	public int hashCode() {
		return hashCode;
	}

	public String toString() {
		return Arrays.toString(values);
	}

	@Override
	public Collection<? extends SinglePoint> getNext() {
		Set<SinglePoint> ret = new HashSet<SinglePoint>();
		for (ModelRef nxt: modelRef.getNext()) {
			ret.add(nxt.getPoints());
		}
		return ret;
	}

	
}
