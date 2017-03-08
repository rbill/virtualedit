package at.ac.tuwien.big.virtmod.ecore.impl;

import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VListFeature;

public class DeltaFeature<A,T> implements Feature<A,T> {
	
	private VListFeature<A,T> base;
	private VListFeature<A,T> delta;
	
	public DeltaFeature(VListFeature<A,T> base, VListFeature<A,T> delta) {
		this.base = base;
		this.delta = delta;
	}

	@Override
	public FeaturePropertyValue<T> getValue(A object) {
		return new DeltaFeaturePropertyValue<T>(base.getValue(object),
				delta.getValue(object));
	}

}
