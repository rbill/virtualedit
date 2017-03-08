package at.ac.tuwien.big.vmodel.general;

import java.util.Map.Entry;

import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVReusableBag;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public interface VReusableBag<X,E extends EditableIntegerValueElement> extends VEditableBag<X, E> {
	
	public Creater<X, Void> creater();
	
	public static <X, E extends EditableIntegerValueElement> VReusableBag<X, E> ensureReusableBag(VEntryIterableFunc<X, E> func, Creater<X,Void> creater) {
		if (func instanceof VReusableBag) {
			return (VReusableBag<X, E>)func;
		}
		return SimpleAbstractDelegatingVReusableBag.createBagFrom(func, creater);
	}
	
	public default X insert() {
		for (Entry<? extends X, ? extends E> entr: getEntries()) {
			if (!entr.getValue().exists()) {
				entr.getValue().setMin(1);
				return entr.getKey();
			}
		}
		
		X ret;
		do {
			ret = creater().create(null);
		}
		while (!insert(ret));
		return ret;
	}

	public default X insertEntry() {
		X ret;
		do {
			ret = creater().create(null);
		}
		while (get(ret).exists());
		return ret;
	}

}
