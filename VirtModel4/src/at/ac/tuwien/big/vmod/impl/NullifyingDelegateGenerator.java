package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.DelegateBuilt;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.DelegateGenerator;
import at.ac.tuwien.big.vmod.generator.SimpleModifyingDelegateGenerator;
import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.Symbol;

public class NullifyingDelegateGenerator implements SimpleModifyingDelegateGenerator {
	

	
	@Override
	public Counter generate(Function self, Object key, Counter valueBase) {
		return new NullifyingCounter(valueBase);
	}

}
