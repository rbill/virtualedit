package at.ac.tuwien.big.vmod.impl;

import java.util.List;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.DelegateBuilt;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.CountType;

public class DelegateCounter extends SimpleDelegateGeneralElement<CountType, Counter> implements Counter, DelegateBuilt<Counter> {
	
	public DelegateCounter(CountType type, Counter base, boolean isUserEdit) {
		super(type,base,isUserEdit);
	}

	@Override
	public void editAdd(int value) {
		getBase().editAdd(value);
	}

	@Override
	public int getValue() {
		return getBase().getValue();
	}

	@Override
	public void priv_getNonnullProvider(List<ModelProvider> prov) {
		getBase().priv_getNonnullProvider(prov);
	}

	@Override
	public void priv_getNonnullResources(List<ModelResource> prov) {
		getBase().priv_getNonnullResources(prov);
	}

}
