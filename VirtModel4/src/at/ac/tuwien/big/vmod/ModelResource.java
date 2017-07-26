package at.ac.tuwien.big.vmod;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.impl.DelegateModelResource;
import at.ac.tuwien.big.vmod.impl.NullifyingDelegateGenerator;
import at.ac.tuwien.big.vmod.impl.SimpleResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;

public interface ModelResource extends GeneralElement {


	public default void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status) {
		//DO nothing
	}
	
	
	@Override
	public ModelResourceType getType();
	
	public Iterator<Symbol> getStoredElements();
	
	public GeneralElement getElement(Symbol symbol);
	
	public void addElement(Symbol symbol, GeneralElement element);
	
	
	public URI getURI();
	
	public Resource getFakeResource();
	
	public Generator<?, ?, ?> getMainGenerator();
	
	public default ModelResource fakeNullified() {
		NullifyingDelegateGenerator generator = new NullifyingDelegateGenerator();
		return new DelegateModelResource(getProvider(), getURI(), getType(), this, generator, false);
	}
	


	public default boolean setValue(GeneralElement e) {
		if (e instanceof ModelResource) {
			ModelResource mr = (ModelResource)e;
			Iterator<Symbol> syms = mr.getStoredElements();
			boolean ret = true;
			while (syms.hasNext()) {
				Symbol sym = syms.next();
				GeneralElement curE = getElement(sym);
				GeneralElement curOE = mr.getElement(sym);
				if (curE == null || curOE == null) {
					ret = false;
				} else {
					curE.setValue(curOE);
				}
			}
			return ret;
		}
		return false;
	}
	
	/*public default SimpleResource getSimpleResource() {
		SimpleResource ret = new Simple   
		Iterator<Symbol> stored = resultModel.getStoredElements();
		while (stored.hasNext()) {
			Symbol next = stored.next();
			GeneralElement el = resultModel.getElement(next);
			copyFrom(null);
			addElement(next, resultModel.);
		}
		
	}*/
	
	public default Object get(String key) {
		if (key.startsWith("$")) {
			return getMetaInfo(key.substring(1));
		} else {
			return getElement(Symbol.fromFull(key));
		}
	}
	
	@Override
	public default Object getMetaInfo(String key) {
		if ("uri".equals(key)) {
			return getURI().toString();
		}
		return null;
	}
	
	public ModelProvider getParent();
	
	public default ModelProvider getProvider() {
		return getParent();
	}
	

	@Override
	public default void clear() {
		for (Symbol sym: (Iterable<Symbol>)()->getStoredElements()) {
			GeneralElement ge = getElement(sym);
			ge.clear();
		}
	}	

	@Override
	public default ModelResource getResource() {
		return this;
	}
	
	public static final Symbol NO_TYPE = new SymbolImpl("DEFAULT_ELEMENTS(noType)");
	
	public static final ModelResource DEFAULT_ELEMENTS = new ModelResource() {
		
		public final Iterable<Symbol> storedElements = Arrays.asList(NO_TYPE);
		public final URI uri = URI.createURI("at.ac.tuwien.big.nowhere");
		
		public Resource getFakeResource() {
			return null;
		}

		@Override
		public ParentLocation getParentLoc() {
			return null;
		}
		
		@Override
		public ModelProvider getParent() {
			return null;
		}
		
		@Override
		public void setParentLoc(ParentLocation parent) {
			throw new UnsupportedOperationException("Can't insert this resource in another resource!");
		}


		@Override
		public Iterator<Symbol> getStoredElements() {
			return storedElements.iterator();
		}

		@Override
		public GeneralElement getElement(Symbol symbol) {
			if (Objects.equals(symbol,NO_TYPE)) {
				return GeneralElement.NO_ELEMENT;
			}
			return null;
		}

		@Override
		public void addElement(Symbol symbol, GeneralElement element) {
			throw new UnsupportedOperationException("Cannot add elements to the default resource!");
		}

		@Override
		public URI getURI() {
			return uri;
		}
		
		public Generator<?, ?, ?> getMainGenerator() {
			return null;
		}
		
		@Override
		public ModelResourceType getType() {
			return ModelResourceType.SIMPLE_INSTANCE;
		}

		@Override
		public boolean setValue(GeneralElement e) {
			return this==e;
		}
	};

	public default GeneralElement getElement(String string) {
		return getElement(Symbol.fromFull(string));
	}


}
