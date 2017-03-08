package at.ac.tuwien.big.vmod.impl;


import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import at.ac.tuwien.big.vmod.DelegateBuilt;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.generator.UnionGenerator;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class DelegateModelResource extends SimpleDelegateGeneralElement<ModelResourceType, ModelResource> implements ModelResource {
	
	private Generator<? super DelegateModelResource, ? super Symbol, ? extends GeneralElement> generator;
	private URI uri;
	private ModelProvider provider;
	private Resource fakeResource;

	public DelegateModelResource(ModelProvider provider, URI uri, ModelResourceType type, ModelResource base, Generator<? super DelegateModelResource, ? super Symbol, ? extends GeneralElement> generator, boolean isUserEdit) {
		super(type, base, isUserEdit);
		this.generator = generator;
		this.provider = provider;
		this.fakeResource = new ResourceImpl(uri);
		this.setParentLoc(new ParentLocationImpl(provider, uri, this));
		this.uri = uri;
	}

	@Override
	public Resource getFakeResource() {
		return fakeResource;
	}


	@Override
	public Iterator<Symbol> getStoredElements() {
		return getBase().getStoredElements();
	}

	@Override
	public GeneralElement getElement(Symbol symbol) {
		return generator.generate(this, symbol);
	}

	@Override
	public void addElement(Symbol symbol, GeneralElement element) {
		if (element instanceof DelegateBuilt) {
			DelegateBuilt db = (DelegateBuilt)element;
			getBase().addElement(symbol, (GeneralElement)db.getBase());
		} else {
			System.err.println("Can't add an element which is not a delta built to a union resource!");
			throw new RuntimeException("Can't add an element which is not a delta built to a union resource!");
		}
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public Generator getMainGenerator() {
		return generator;
	}
	
	public void setParentLoc(ParentLocation loc) {
		super.setParentLoc(loc);
		if (loc != null) {
			this.provider = (ModelProvider)loc.getParent();
		}
	}

	@Override
	public ModelProvider getParent() {
		return this.provider;
	}

	


}
