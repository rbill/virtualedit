package at.ac.tuwien.big.vmod.registry;

import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.TransformationExecutor;

public interface TransformatorGeneratorGenerator {
	
	public TransformationExecutor getExecutor(Resource res);

}
