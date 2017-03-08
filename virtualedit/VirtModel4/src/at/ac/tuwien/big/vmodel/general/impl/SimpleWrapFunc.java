package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.DoubleParameterIFace;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;
import at.ac.tuwien.big.vmodel.general.WrapEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.WrappedEditableIntegerValueElement;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class SimpleWrapFunc<X, Y1, Y2> extends SourcedObject implements WrapEntryIterableFunc<X, Y1, Y2> {
	
	private DoubleParameterIFace<? super X, ? super Y1, ? extends Y2> wrapper;
	private VEntryIterableFunc<X, ? extends Y1> base;
	private OwnedFunc<X, Y2> cache;

	public SimpleWrapFunc(VContainer store, DoubleParameterIFace<? super X, ? super Y1, ? extends Y2> wrapper, VEntryIterableFunc<X, ? extends Y1> base) {
		super(store);
		this.base = base;
		this.wrapper = wrapper;
		this.cache = new SimpleVFunc<X, Y2>(store.createChild("cache"), (x)->wrapper.get(x, base().get(x)));
	}
	

	public String toString() {
		return ToString();
	}

	@Override
	public DoubleParameterIFace<? super X, ? super Y1, ? extends Y2> wrapper() {
		return wrapper;
	}

	@Override
	public boolean isSelfEmpty() {
		return true;
	}

	@Override
	public boolean selfClear() {
		return false;
	}


	@Override
	public VEntryIterableFunc<X, ? extends Y1> base() {
		return base;
	}

	@Override
	public void set(X t, Y2 u) {
		throw new RuntimeException("Should not be called!");
	}

	@Override
	public Y2 getOrNull(X t) {
		throw new RuntimeException("Should not be called!");
	}

	@Override
	public OwnedFunc<X, Y2> cache() {
		return cache;
	}

}
