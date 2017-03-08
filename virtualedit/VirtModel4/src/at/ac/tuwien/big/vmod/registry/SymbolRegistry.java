package at.ac.tuwien.big.vmod.registry;

import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolRegistryType;

public interface SymbolRegistry extends GeneralElement {
	


	public default void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status) {
		//Do ntohing
	}
	
	public ModelProvider getProvider(Symbol forSymbol);
	
	public void addProvider(ModelProvider res);
	

	public default SymbolRegistryType getType() {
		return SymbolRegistryType.INSTANCE;
	}

	public int getIndexFor(ModelProvider provider);

	public void removeProviders(Iterable<? extends ModelProvider> tpis);
}
