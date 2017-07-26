package at.ac.tuwien.big.vmod.impl;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;

public abstract class SimpleResource extends SimpleGeneralElement<ModelResourceType> implements ModelResource  {
	
	
	private ModelProvider provider;
	private URI uri;
	private Generator generator;
	private ParentLocation parent;
	private Resource fakeResource;
	private Map<Symbol, GeneralElement> storedFuncs = new HashMap<Symbol, GeneralElement>();
	
	public SimpleResource(ModelProvider provider2, URI myUri, Generator generator) {
		super(null);
		this.provider = provider2;
		this.uri = myUri;
		this.fakeResource = new ResourceImpl(myUri);
		this.generator = generator;
		this.setParentLoc(new ParentLocationImpl(provider, uri, this));
	}
	
	public Resource getFakeResource() {
		return fakeResource;
	}


	@Override
	public void setParentLoc(ParentLocation parent) {
		this.parent = parent;
		this.provider = (ModelProvider)parent.getParent();
	}
	

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public ModelProvider getParent() {
		return provider;
	}


	@Override
	public Iterator<Symbol> getStoredElements() {
		return storedFuncs.keySet().iterator();
	}

	@Override
	public void addElement(Symbol symbol, GeneralElement element) {
		storedFuncs.put(symbol, element);
	}

	@Override
	public Generator getMainGenerator() {
		return generator;
	}


	@Override
	public Object getMetaInfo(String key) {
		if ("uri".equals(key)) {
			return getURI().toString();
		} 
		return super.getMetaInfo(key);
	}


	@Override
	public GeneralElement getElement(Symbol symbol) {
		GeneralElement ret = storedFuncs.get(symbol);
		if (ret == null) {
			storedFuncs.put(symbol, ret = (GeneralElement)generator.generate(this, symbol));
		}                
		return ret;
	}
	
	

}
