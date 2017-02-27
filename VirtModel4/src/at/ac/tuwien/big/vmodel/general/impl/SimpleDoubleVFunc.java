package at.ac.tuwien.big.vmodel.general.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.AbstractParameterInvertibleFuncBase;
import at.ac.tuwien.big.vmodel.general.DoubleParameterVFunc;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.ParameterInvertibleFunc;
import at.ac.tuwien.big.vmodel.general.StaticElement;
import at.ac.tuwien.big.vmodel.general.StaticElementDoubleCreator;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class SimpleDoubleVFunc<X,Y,Z extends StaticElement, F extends VEntryIterableFunc<X, ? extends VEntryIterableFunc<Y, Z>>> extends BasicVObject 
	implements AbstractParameterInvertibleFuncBase<X, Y, Z,F> {
	
	private F base1Func;
	private Editstate editState = new SimpleEditState();

	public SimpleDoubleVFunc(VContainer store, F base1Func) {
		super(store);
		this.base1Func = base1Func;
	}
	
	public String toString() {
		return String.valueOf(base1Func);
	}

	@Override
	public F base1Func() {
		return this.base1Func;
	}

	@Override
	public Editstate getEditState() {
		return editState;
	}

	
	

}
