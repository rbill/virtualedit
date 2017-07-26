package at.ac.tuwien.big.verocl.impl;

import at.ac.tuwien.big.verocl.SingleParameterDesc;

public abstract class AbstractSingleParameterDesc<T extends Comparable<T>> implements SingleParameterDesc<T> {
	
	public int hashCode() {
		return overrideHashCode();
	}
	

	public boolean equals(Object o) {
		try {
			return (o instanceof SingleParameterDesc) && (equals((SingleParameterDesc<T>)o));
		} catch (ClassCastException e) {
			return false;
		}
	}

}
