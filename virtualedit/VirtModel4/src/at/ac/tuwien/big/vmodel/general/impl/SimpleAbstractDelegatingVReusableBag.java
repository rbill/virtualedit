package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.AbstractDelegatingVBag;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VReusableBag;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class SimpleAbstractDelegatingVReusableBag<X,E extends EditableIntegerValueElement> 
	extends SourcedObject implements VReusableBag<X, E>, AbstractDelegatingVBag<X,E> {

	private VEntryIterableFunc<X,E> base1Func;
	private Creater<X,Void> creater;
	

	public static<X,E extends EditableIntegerValueElement>  
			SimpleAbstractDelegatingVReusableBag<X,E> createBagFrom(VEntryIterableFunc<X, E> func, Creater<X,Void> creater) {
		return new SimpleAbstractDelegatingVReusableBag<>(func.store(),func,creater);
	}

	public SimpleAbstractDelegatingVReusableBag(VContainer store, VEntryIterableFunc<X, E> base1Func, Creater<X,Void> creater) {
		super(store);
		this.base1Func = base1Func;
		this.creater = creater;
	}


	@Override
	public Creater<X, Void> creater() {
		return creater;
	}

	@Override
	public VEntryIterableFunc<X, E> base1Func() {
		return base1Func;
	}

}
