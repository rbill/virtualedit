package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class SimpleBag<X,E extends EditableIntegerValueElement> extends SimpleVFunc<X, E> implements VEditableBag<X, E> {

	public SimpleBag(VContainer store, Creater<? extends E, ? super X> creator) {
		super(store, creator);
	}
	

	public SimpleBag(VContainer store, Map<X,E> map, Creater<? extends E, ? super X> creator) {
		super(store,map,creator);
	}


	public static<X> VEditableBag<X, EditableIntegerValueElement> createBasicBag(VContainer child) {
		VFunc[] func = new VFunc[1];
		VEditableBag<X,EditableIntegerValueElement> ret = new SimpleBag<X, EditableIntegerValueElement>(child, (x)->new SimpleIntegerValueElement(child.createChild("int"+func[0].getEditState().advEditId())));
		func[0] = ret;
		return ret;
	}

}
