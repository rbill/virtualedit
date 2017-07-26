package at.ac.tuwien.big.vmod.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;

public class ParametizedModelResource<T extends Iterable<U>,U> extends ParametizedElement<ParametizedModelResource<T,U>,
	T, U, ModelResourceType> implements ModelResource {

	private ParametizedGenerator<? super Symbol, ? extends GeneralElement, ? super T,? super U> generator;
	private URI uri;
	private Resource fakeResource;
	
	public ParametizedModelResource(ModelResourceType type, ModelProvider provider, T curParam, Projector<T, U> projector,
			FunctionMap<U, ? extends GeneralElement> subFunc,
			ParametizedGenerator<? super Symbol, ? extends GeneralElement, ? super T,? super U> generator,
			URI uri
			) {
		super(type, curParam, projector, subFunc);
		this.generator = generator;
		this.fakeResource = new ResourceImpl(uri);
		this.setParentLoc(new ParentLocationImpl(provider, uri, this));
		this.uri = uri;
	}
	
	public ParametizedModelResource(ParametizedModelResource<T, U> copyFrom) {
		super(copyFrom.getType(),copyFrom.getParam(),copyFrom.getProjector(),copyFrom.getSubFunc());
		this.generator = copyFrom.generator.clone();
		this.fakeResource = new ResourceImpl(copyFrom.uri);
		this.setParentLoc(new ParentLocationImpl(copyFrom.getProvider(), copyFrom.uri, this));
		this.uri = copyFrom.uri;
	}


	@Override
	public Iterator<Symbol> getStoredElements() {
		//Elements stored in any Resource
		Set<Symbol> ret = new HashSet<>();
		for (ModelResource mr: this.<ModelResource>getSubValues()) {
			for (Symbol sym: (Iterable<Symbol>)()->mr.getStoredElements()) {
				ret.add(sym);
			}
		}
		return ret.iterator();
	}

	@Override
	public GeneralElement getElement(Symbol symbol) {
		return generator.generate(this, symbol);
	}

	@Override
	public void addElement(Symbol symbol, GeneralElement element) {
		for (ModelResource mr: this.<ModelResource>getSubValues()) {
			mr.addElement(symbol, element);
		}
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public Resource getFakeResource() {
		return fakeResource;
	}

	@Override
	public Generator<?, ?, ?> getMainGenerator() {
		return generator;
	}

	@Override
	public ModelProvider getParent() {
		return (ModelProvider)super.getParent();
	}

	@Override
	public ParametizedModelResource<T, U> clone() {
		ParametizedModelResource<T, U> ret = new ParametizedModelResource<>(this);
		return ret;
	}


	public FunctionMap<U, ?> getSubFunc(Symbol key) {
		FunctionMap<U,?> newSubFunc = new FunctionMap<U,Object>() {

			@Override
			public Object getValue(U skey) {
				//Da muss der jeweils echte Funktions-Unterwert geliefert werden
				FunctionMap<U, ? extends GeneralElement> sf = getSubFunc();
				ModelResource res = ((ModelResource)sf.getValue(skey)); 
				return res.getElement(key);
			}
			
		};
		return newSubFunc;
	}

}
