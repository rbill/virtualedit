package at.ac.tuwien.big.vmodel.general;

import java.util.Objects;
import java.util.Map.Entry;

import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVBag;

public interface VEditableBag<X,E extends EditableIntegerValueElement> extends VBag<X, E> {
	
	
	
	
	public default void modify(X x, int value) {
		get(x).add(value);
	}
	
	public default boolean insert(X x) {
		E cur = get(x);
		if (cur.getValue() > 0) {
			return false;
		} else {
			cur.add(1-cur.getValue());
			return true;
		}
	}
	
	public default void removeAll(X x) {
		get(x).clear();
	}

	public default void clear() {
		for (Entry<? extends X,? extends E> entr: getEntries()) {
			entr.getValue().clear();
		}
	}

	public default void setTo(X element) {
		boolean added = false;
		for (Entry<? extends X,? extends E> entr: getEntries()) {
			if (Objects.equals(entr.getKey(), element)) {
				entr.getValue().setMin(1);
				added = true;
			} else {
				entr.getValue().clear();
			}
		}
		if (!added) {
			insert(element);
		}
	}

	public static <X,E extends EditableIntegerValueElement> 
		VEditableBag<X, E> ensureBag(VEntryIterableFunc<X, E> func) {
		if (func instanceof VEditableBag) {
			return (VEditableBag<X, E>)func;
		} else {
			return new SimpleAbstractDelegatingVBag<>(func.store(), func); 
		}
	}
	
	public default void nullifyClear() {
		for (E val: getValues()) {
			val.nullify();
		}
	}

}
