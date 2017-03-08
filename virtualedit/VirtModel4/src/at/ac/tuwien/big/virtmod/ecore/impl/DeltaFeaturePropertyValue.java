package at.ac.tuwien.big.virtmod.ecore.impl;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaEditableList;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;

public class DeltaFeaturePropertyValue<T> implements VListFeaturePropertyValue<T> {

	private VListFeaturePropertyValue<T> base;
	private VListFeaturePropertyValue<T> delta;
	private VEditableList<T> commonList;
	
	public VListFeaturePropertyValue<T> getBase() {
		return base;
	}
	
	public VListFeaturePropertyValue<T> getDelta() {
		return delta;
	}
	
	public DeltaFeaturePropertyValue(VListFeaturePropertyValue<T> base, VListFeaturePropertyValue<T> delta) {
		this(base,delta,null);
	}
	
	public DeltaFeaturePropertyValue(VListFeaturePropertyValue<T> base, VListFeaturePropertyValue<T> delta, Object source) {
		this.base = base;
		this.delta = delta;
		commonList = new SimpleDeltaEditableList<T>(base.getDelegate(), delta.getDelegate(), source);
	}
	

	@Override
	public VEditableList<T> getDelegate() {
		return commonList;
	}
	
	


}
