package at.ac.tuwien.big.vmod.impl;

import java.util.List;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.CountType;

public class NullifyingCounter extends SimpleGeneralElement<CountType> implements Counter {
	
	Counter base;
	
	public NullifyingCounter(Counter base) {
		super(base.getType());
		this.base = base;
	}

	@Override
	public void editAdd(int value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getValue() {
		return 0;
	}
	
	public String toString() {
		return "Nullified " + base;
	}
	

	@Override
	public void priv_getNonnullProvider(List<ModelProvider> prov) {
		//This never provides anything
	}
	
	@Override
	public void priv_getNonnullResources(List<ModelResource> prov) {
		//This never provides anything
	}

}
