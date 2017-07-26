package at.ac.tuwien.big.vmod.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.CountType;

public class ParametizedCounter<T extends Iterable<U>,U> extends ParametizedElement<ParametizedCounter<T,U>,
	T, U, CountType> implements Counter {

	public ParametizedCounter(CountType type, T curParam, Projector<T, U> projector,
			FunctionMap<U, ? extends Counter> subFunc) {
		super(type, curParam, projector, subFunc);
	}

	@Override
	public void editAdd(int value) {
		for (Counter c: this.<Counter>getSubValues()) {
			c.editAdd(value);
		}
	}

	@Override
	public int getValue() {
		Iterator<Counter> counter = this.<Counter>getSubValues().iterator();
		if (!counter.hasNext()) {
			return 0;
		}
		int max = counter.next().getValue();
		while (counter.hasNext()) {
			max = Math.max(max, counter.next().getValue());
		}
		return max;
	}

	@Override
	public ParametizedCounter<T, U> clone() {
		return new ParametizedCounter<T,U>(type, getParam() , getProjector(), (FunctionMap<U,? extends Counter>)getSubFunc());
	}


	@Override
	public void priv_getNonnullProvider(List<ModelProvider> prov) {
		for (Counter c: this.<Counter>getSubValues()) {
			c.priv_getNonnullProvider(prov);
		}
	}

	@Override
	public void priv_getNonnullResources(List<ModelResource> prov) {
		for (Counter c: this.<Counter>getSubValues()) {
			c.priv_getNonnullResources(prov);
		}
	}

}
