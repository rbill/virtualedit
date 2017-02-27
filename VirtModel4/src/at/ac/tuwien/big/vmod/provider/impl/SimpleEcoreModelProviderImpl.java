package at.ac.tuwien.big.vmod.provider.impl;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.EcoreFuncUtil;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.impl.EcoreModelResource;
import at.ac.tuwien.big.vmod.impl.SimpleGeneralElement;
import at.ac.tuwien.big.vmod.impl.SimpleGenerator;
import at.ac.tuwien.big.vmod.impl.SimpleResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.SimpleModelProvider;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.impl.ModelProviderTypeImpl;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public class SimpleEcoreModelProviderImpl extends SimpleGeneralElement<ModelProviderType> implements SimpleModelProvider {
	
	
	private int index;
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	public SimpleEcoreModelProviderImpl(ModelProviderType type, String symbol, Resource ecore) {
		super(type);
		this.symbol = symbol;
		URI myUri = URI.createFileURI(symbol+".vmod");
		Generator generator = new SimpleGenerator<>();
		this.realResource = new EcoreModelResource(this, ecore, myUri, generator);
	}
	
	private static WeakHashMap<Resource, ModelProviderType> resourceToModelProvider = new WeakHashMap<>();
	
	public static SimpleEcoreModelProviderImpl createModelProvider(String symbol, Resource ecore) {
		ModelProviderType type = resourceToModelProvider.get(ecore);
		if (type == null) {
			type = new ModelProviderTypeImpl();
			resourceToModelProvider.put(ecore, type);
		}
		return new SimpleEcoreModelProviderImpl(type, symbol, ecore);
	}
	
	private EcoreModelResource realResource;
	private String symbol;

	@Override
	public ModelResource getResultModel() {
		return realResource;
	}

	@Override
	public ModelResource getUserEditModel() {
		return realResource;
	}

	@Override
	public List<ModelProvider> getPrevious() {
		return Collections.emptyList();
	}

	@Override
	public String getSymbolName() {
		return symbol;
	}

	@Override
	public SymbolRegistry getParent() {
		return (SymbolRegistry)super.getParent();
	}

	@Override
	public ModelProvider withRedirectedInput(List<ModelProvider> newInputs) {
		//Don't do anything
		return this;
	}
}
