package at.ac.tuwien.big.vmod.ecore;

import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;

public interface NoInverse<T> {
	
	public T noInverse();
	
	public List<ExactDerivationStatus> getDerivationStatus(Collection<ModelResource> userModels);

}
