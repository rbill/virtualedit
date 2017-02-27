package at.ac.tuwien.big.vmod.impl;

import java.util.List;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.CountType;

public class SimpleCounter extends SimpleGeneralElement<CountType> implements Counter {
	
	private int value;

	public SimpleCounter(CountType type) {
		super(type);
	}

	@Override
	public void editAdd(int value) {
		this.value+=value;
	}

	@Override
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return "Counter: " + value;
	}
	
	@Override
	public void priv_getNonnullProvider(List<ModelProvider> prov) {
		if (getValue() != 0) {
			prov.add(getProvider());
		}
	}

	@Override
	public void priv_getNonnullResources(List<ModelResource> prov) {
		if (getValue() != 0) {
			prov.add(getResource());
		}
	}
}
