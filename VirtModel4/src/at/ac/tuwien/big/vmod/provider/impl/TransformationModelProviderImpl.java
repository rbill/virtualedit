package at.ac.tuwien.big.vmod.provider.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.generator.UnionGenerator;
import at.ac.tuwien.big.vmod.impl.EcoreModelResource;
import at.ac.tuwien.big.vmod.impl.EcoreModelResourceUtil;
import at.ac.tuwien.big.vmod.impl.GenericUnionGenerator;
import at.ac.tuwien.big.vmod.impl.SimpleGeneralElement;
import at.ac.tuwien.big.vmod.impl.SimpleGenerator;
import at.ac.tuwien.big.vmod.impl.SimpleResource;
import at.ac.tuwien.big.vmod.impl.UnionModelResource;
import at.ac.tuwien.big.vmod.modelview.ModelView;
import at.ac.tuwien.big.vmod.provider.DerivationModelProvider;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;

public class TransformationModelProviderImpl extends SimpleGeneralElement<ModelProviderType> implements DerivationModelProvider {


	private int index;
	private DerivationModelProvider delegate;
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public static interface TransformationExecutor {
		public void executeOn(VModelView view);
	}
	
	public static class MultiTransformationExecutor implements TransformationExecutor {
		List<TransformationExecutor> base = new ArrayList<TransformationModelProviderImpl.TransformationExecutor>();
				
		public MultiTransformationExecutor(TransformationExecutor... base) {
			this.base.addAll(Arrays.asList(base));
		}

		
		public MultiTransformationExecutor(List<TransformationExecutor> base) {
			this.base = base;
		}
		
		public void addExecutor(TransformationExecutor te) {
			this.base.add(te);
		}

		@Override
		public void executeOn(VModelView view) {
			for (TransformationExecutor te: base) {
				te.executeOn(view);
			}
		}
		
	}
	
	protected Resource ecore;
	
	public TransformationModelProviderImpl(ModelProviderType type, String symbol, Resource ecore, ModelProvider inputProvider,
			TransformationExecutor executor, ModelResource userDelta) {
		this(type,Symbol.from(symbol),ecore,inputProvider,executor,userDelta);
	}
	
	public TransformationModelProviderImpl(ModelProviderType type, Symbol symbol, Resource ecore, ModelProvider inputProvider,
			TransformationExecutor executor, ModelResource userDelta) {
		super(type);
		this.ecore = ecore;
		this.symbol = symbol;
		this.inputProvider = inputProvider;
		this.input = inputProvider.getResultModel();
		Generator simpleGenerator = new SimpleGenerator<>();
		URI deltaURI = URI.createFileURI(symbol+"_user.vmod");
		URI wholeResultURI = URI.createFileURI(symbol+"_result.vmod");
		URI transdeltaURI = URI.createFileURI(symbol+"_transdelta.vmod");
		URI intermediateResultURI = URI.createDeviceURI(symbol+"_intermediate.vmod");
		this.transformationDelta =  new EcoreModelResource(this,ecore,transdeltaURI,simpleGenerator);
		if (userDelta == null) {
			this.userDelta = new EcoreModelResource(this,ecore,deltaURI,simpleGenerator);	
		} else {
			this.userDelta = userDelta;
		}
		ModelResourceType restype = EcoreModelResourceUtil.getModelResource(ecore);
		UnionGenerator generator = new GenericUnionGenerator();
		this.transformationResult = new UnionModelResource(this,wholeResultURI, restype, input, transformationDelta, generator, false);
		this.completeResult = new UnionModelResource(this,wholeResultURI, restype, transformationResult, this.userDelta, generator, true);
		this.executor = executor;
		SimpleDeltaModelProviderImpl subProvider = new SimpleDeltaModelProviderImpl(symbol, ecore, inputProvider, transformationDelta);
		VEcoreFile ecoreFile = new VEcoreFileImpl(ecore);
		this.view = new SimpleModelView(subProvider, ecoreFile);
	}
	
	public TransformationModelProviderImpl(TransformationModelProviderImpl This, List<ModelProvider> newInputs, boolean hide) {
		super(This.getType());
		this.delegate = This;
		this.ecore = This.ecore;
		this.symbol = This.symbol;
		this.inputProvider = newInputs.get(0);
		this.input = inputProvider.getResultModel();
		this.parentLoc = This.parentLoc;
		Generator simpleGenerator = new SimpleGenerator<>();
		URI deltaURI = URI.createFileURI(symbol+"_user.vmod");
		URI wholeResultURI = URI.createFileURI(symbol+"_result.vmod");
		URI transdeltaURI = URI.createFileURI(symbol+"_transdelta.vmod");
		URI intermediateResultURI = URI.createDeviceURI(symbol+"_intermediate.vmod");
		this.transformationDelta = This.transformationDelta;
		if (hide) {
			this.transformationDelta = this.transformationDelta.fakeNullified();
		}
		this.userDelta = This.userDelta;
		ModelResourceType restype = This.transformationResult.getType();
		UnionGenerator generator = new GenericUnionGenerator();
		this.transformationResult = new UnionModelResource(this,wholeResultURI, restype, input, transformationDelta, generator, false);
		this.completeResult = new UnionModelResource(this,wholeResultURI, restype, transformationResult, userDelta, generator, true);
		
		this.executor = (x)->{This.recalc();}; //Don't to anything ... - or do something but immediately hide it?
		ModelProvider subProvider = (hide)?inputProvider:new SimpleDeltaModelProviderImpl(symbol, ecore, inputProvider, transformationDelta);
		VEcoreFile ecoreFile = new VEcoreFileImpl(ecore);
		SimpleModelView smv = new SimpleModelView(new SimpleDeltaModelProviderImpl(symbol, ecore, inputProvider, transformationDelta), ecoreFile);
		this.view = new SimpleModelView(subProvider, ecoreFile);
	}
	
	public TransformationModelProviderImpl(ModelProviderType type,String symbol, Resource ecore, ModelProvider inputProvider,
			TransformationExecutor executor) {
		this(type,Symbol.from(symbol),ecore,inputProvider,executor);
	}
	
	public TransformationModelProviderImpl(ModelProviderType type, Symbol symbol, Resource ecore, ModelProvider inputProvider,
			TransformationExecutor executor) {
		this(type,symbol,ecore,inputProvider,executor,null);
	}
	
	private TransformationExecutor executor;
	private ModelResource completeResult;
	private ModelResource userDelta;
	private ModelResource transformationResult;
	private ModelResource transformationDelta;
	private ModelResource input;
	private ModelProvider inputProvider;
	private Symbol symbol;
	private VModelView view;

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
	public void recalc() {
		if (delegate != null) {
			delegate.recalc();
		} else {
			transformationDelta.clear();
			executor.executeOn(view);
		}
	}

	@Override
	public TransformationModelProviderImpl withRedirectedInput(List<ModelProvider> newInputs) {
		return withRedirectedInput(newInputs,false);
	}
	
	public TransformationModelProviderImpl withRedirectedInput(List<ModelProvider> newInputs, boolean hide) {
		return new TransformationModelProviderImpl(this, newInputs, hide);
	}
	
 
}
