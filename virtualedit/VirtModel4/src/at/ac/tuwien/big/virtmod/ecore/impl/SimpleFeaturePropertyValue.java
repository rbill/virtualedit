package at.ac.tuwien.big.virtmod.ecore.impl;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;

public class SimpleFeaturePropertyValue<T> implements VListFeaturePropertyValue<T> {

	private VEditableList<T> delegate;
	
	public SimpleFeaturePropertyValue(VEditableList<T> delegate) {
		this.delegate = delegate;
	}
	

	@Override
	public VEditableList<T> getDelegate() {
		return delegate;
	}

}
