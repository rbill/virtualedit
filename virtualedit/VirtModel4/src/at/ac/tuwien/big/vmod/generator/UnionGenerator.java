package at.ac.tuwien.big.vmod.generator;

import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.impl.SimpleUnionGeneralElement;

//Base + Edit, ModelName ist immer vom edit
public interface UnionGenerator<This extends Function<T,U> & DeltaBuilt<? extends Function<T,V>,? extends Function<T,W>>, T,U,V,W> extends Generator<This, T, U> { 

	public default U generate(This self, T key) {
		V valueBase = self.getBase().getValue(key);
		W valueEdit = self.getEdit().getValue(key);
		return generate(self,key,valueBase,valueEdit);
	}
	
	
	public U generate(This self, T key, V valueBase, W valueEdit);
	
}
