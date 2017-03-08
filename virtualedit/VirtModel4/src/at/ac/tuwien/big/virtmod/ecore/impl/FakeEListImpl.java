package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vmod.ecore.NoInverse;

public class FakeEListImpl<T> extends FakeEList<T> {
	
	private List<T> delegate;
	

	public FakeEList<T> noInverse() {
		if (delegate instanceof NoInverse) {
			return new FakeEListImpl(((NoInverse<List<T>>) delegate).noInverse());
		}
		return this;
	}
	
	public FakeEListImpl(List<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public List<T> getDelegate() {
		return delegate;
	}

	public static<T> EList<T> ensureEList(List<T> ret) {
		if (ret instanceof EList) {
			return (EList)ret;
		}
		return new FakeEListImpl<T>(ret);
	}
	
	public String toString() {
		return Arrays.toString(delegate.toArray());
	}
	
}
