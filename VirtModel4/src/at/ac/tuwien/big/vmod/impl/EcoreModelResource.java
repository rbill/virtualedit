package at.ac.tuwien.big.vmod.impl;


import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.ValueType;
import at.ac.tuwien.big.vmod.type.impl.CountTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.FunctionTypeImpl;

public class EcoreModelResource extends SimpleResource implements ModelResource {

	private Resource ecoreFile;
	
	public EcoreModelResource(ModelProvider provider, Resource ecoreFile, URI myUri, Generator generator) {
		super(provider,myUri,generator);
		this.ecoreFile = ecoreFile;
		parseEcore(ecoreFile);
	}
	
	private void parseEcore(Resource ecoreResource) {
		this.type = EcoreModelResourceUtil.getModelResource(ecoreResource);
	}

}
