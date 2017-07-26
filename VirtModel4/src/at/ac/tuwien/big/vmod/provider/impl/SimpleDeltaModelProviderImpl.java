package at.ac.tuwien.big.vmod.provider.impl;


import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.generator.UnionGenerator;
import at.ac.tuwien.big.vmod.impl.EcoreModelResource;
import at.ac.tuwien.big.vmod.impl.EcoreModelResourceUtil;
import at.ac.tuwien.big.vmod.impl.GenericUnionGenerator;
import at.ac.tuwien.big.vmod.impl.SimpleGeneralElement;
import at.ac.tuwien.big.vmod.impl.SimpleGenerator;
import at.ac.tuwien.big.vmod.impl.SimpleResource;
import at.ac.tuwien.big.vmod.impl.UnionModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.SimpleModelProvider;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;

public class SimpleDeltaModelProviderImpl extends SimpleGeneralElement<ModelProviderType> implements SimpleModelProvider {
	
private int index;
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public SimpleDeltaModelProviderImpl(String symbol, Resource ecore, ModelProvider inputProvider) {
		this(Symbol.from(symbol),ecore,inputProvider);
	}
	
	public SimpleDeltaModelProviderImpl(Symbol symbol, Resource ecore, ModelProvider inputProvider) {
		super(inputProvider.getType());
		this.symbol = symbol;
		this.inputProvider = inputProvider;
		this.input = inputProvider.getResultModel();
		Generator simpleGenerator = new SimpleGenerator<>();
		URI deltaURI = URI.createFileURI(symbol+"_delta.vmod");
		URI wholeResultURI = URI.createFileURI(symbol+"_result.vmod");
		this.userDelta = new EcoreModelResource(this,ecore,deltaURI,simpleGenerator);
		ModelResourceType restype = EcoreModelResourceUtil.getModelResource(ecore);
		UnionGenerator generator = new GenericUnionGenerator();
		this.completeResult = new UnionModelResource(this,wholeResultURI, restype, input, userDelta, generator, false);
	}
	
	
	
	public SimpleDeltaModelProviderImpl(Symbol symbol, Resource ecore, ModelProvider inputProvider,
			ModelResource transformationDelta) {
		super(inputProvider.getType());
		this.symbol = symbol;
		this.inputProvider = inputProvider;
		this.input = inputProvider.getResultModel();
		Generator simpleGenerator = new SimpleGenerator<>();
		URI wholeResultURI = URI.createFileURI(symbol+"_deltaresult.vmod");
		this.userDelta = transformationDelta;
		ModelResourceType restype = EcoreModelResourceUtil.getModelResource(ecore);
		UnionGenerator generator = new GenericUnionGenerator();
		this.completeResult = new UnionModelResource(this,wholeResultURI, restype, input, userDelta, generator, false);
	}
	
	
	public SimpleDeltaModelProviderImpl(SimpleDeltaModelProviderImpl This, List<ModelProvider> newInputs) {
		super(This.type);
		this.symbol = This.symbol;
		this.inputProvider = newInputs.get(0);
		this.input = inputProvider.getResultModel();
		Generator simpleGenerator = new SimpleGenerator<>();
		URI deltaURI = URI.createFileURI(symbol+"_delta.vmod");
		URI wholeResultURI = URI.createFileURI(symbol+"_result.vmod");
		this.userDelta = This.userDelta;
		ModelResourceType restype = This.completeResult.getType();
		UnionGenerator generator = new GenericUnionGenerator();
		this.completeResult = new UnionModelResource(this,wholeResultURI, restype, input, userDelta, generator, false);		
	}
	

	@Override
	public ModelProvider withRedirectedInput(List<ModelProvider> newInputs) {
		return new SimpleDeltaModelProviderImpl(this,newInputs);
	}
	
	public void setInputProvider(ModelProvider inputProvider) {
		this.inputProvider = inputProvider;
		this.input = inputProvider.getResultModel();
		this.completeResult.setBase(input);
	}

	private UnionModelResource completeResult;
	private ModelResource userDelta;
	private ModelResource input;
	private ModelProvider inputProvider;
	private Symbol symbol;
	

	@Override
	public ModelResource getResultModel() {
		return completeResult;
	}

	@Override
	public ModelResource getUserEditModel() {
		return userDelta;
	}

	@Override
	public List<ModelProvider> getPrevious() {
		return Collections.singletonList(inputProvider);
	}

	@Override
	public Symbol getMainSymbol() {
		return symbol;
	}
	
	@Override
	public void setParentLoc(ParentLocation parent) {
		super.setParentLoc(parent);
		SymbolRegistry sr = (SymbolRegistry)parent.getParent();
		if (sr != null) {
			setIndex(sr.getIndexFor(this));
		}
	}

	@Override
	public SymbolRegistry getParent() {
		return (SymbolRegistry)super.getParent();
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
