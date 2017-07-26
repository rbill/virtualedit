package at.ac.tuwien.big.vmod.impl;

import java.util.Collection;
import java.util.Map.Entry;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmodel.general.impl.FakeEntry;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public abstract class ParametizedElement<This extends ParametizedElement<This,T,U,Type>,T extends Iterable<U>,U,Type extends GeneralType> extends SimpleGeneralElement<Type> implements GeneralElement {
	
	public ParametizedElement(Type type, T curParam, Projector<T,U> projector, FunctionMap<U,? extends GeneralElement> subFunc
			) {
		super(type);
		this.param = curParam;
		this.projector = projector;
		this.subFunc = subFunc;
	}

	private T param;
	private Projector<T, U> projector;
	private FunctionMap<U, ? extends GeneralElement> subFunc; //Kann durchaus umfassender sein, statisch. Result type omitted for brevity??
	
	public T getParam() {
		return param;
	}
	
	public Projector<T, U> getProjector() {
		return projector;
	}
	
	public FunctionMap<U, ? extends GeneralElement> getSubFunc() {
		return subFunc;
	}
	

	@Override
	public void clear() {
		for (GeneralElement c: this.<GeneralElement>getSubValues()) {
			c.clear();
		}
	}

	
	@SuppressWarnings("unchecked")
	public<R> R getSubValue(U key) {
		return (R)subFunc.getValue(key);
	}
	
	public<R> Iterable<R> getSubValues() {
		return ()->IteratorUtils.convert(param.iterator(), (x)->getSubValue(x));
	}
	
	public<R> Iterable<Entry<U,R>> getSubEntries() {
		return ()->IteratorUtils.convert(param.iterator(), (x)->new FakeEntry<>(x,getSubValue(x)));
	}
	
	@Override
	public Object getMetaInfo(String key) {
		if ("param".equals(key)) {
			return param;
		}
		return super.getMetaInfo(key);
	}
	
	public abstract This clone();
	
	public void copyFrom(ParametizedElement<This, T, U, Type> from) {
		super.copyFrom(from);
		this.param = from.param;
		this.projector = from.projector;
	}
	
	
	protected void applyProjection(T intersect) {
		this.param = projector.project(param, intersect);
	}
	
	public This project(T intersect) {
		This clone = clone();
		clone.applyProjection(intersect);
		return clone;
	}


}
