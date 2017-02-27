package at.ac.tuwien.big.vmodel.general;

import java.util.Map.Entry;

import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;

public interface VEditableAssoc<X,Y,E extends EditableIntegerValueElement> extends VAssoc<X, Y, E> {
	
	
	public static<X,Y,E extends EditableIntegerValueElement> VEditableAssoc<X,Y,? extends E> ensureEditableAssocE(VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,? extends E>> func) {
		if (func instanceof VEditableAssoc) {
			return (VEditableAssoc)func;
		} else {
			return SimpleAbstractDelegatingVAssoc.createAssocFrom(func);
		}		
	}

	public static<X,Y,E extends EditableIntegerValueElement> VEditableAssoc<X,Y,E> ensureEditableAssoc(VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,E>> func) {
		if (func instanceof VEditableAssoc) {
			return (VEditableAssoc)func;
		} else {
			return SimpleAbstractDelegatingVAssoc.createAssocFrom(func);
		}
		
	}

	public default boolean insert(X x, Y y) {
		E e = get(x,y);
		if (e.getValue() > 0) {
			return false;
		} else {
			get(x,y).add(1-e.getValue());
			return true;
		}
	}
	
	public default void modify(X x, Y y, int value) {
		get(x,y).add(value);
	}
	
	public default void removeAllX(X x) {
		VEntryIterableFunc.clear(get(x));
	}
	
	public default void removeAllY(Y y) {
		VEntryIterableFunc.clear(parameterInvert().get(y));
	}
	
	public default void removeAll(X x, Y y) {
		get(x,y).clear();
	}

	public default void removeClear() {
		for (X x: getKeys()) {
			removeAllX(x);
		}
	}
	
	public default void nullifyClear() {
		for (Entry<? extends X, ? extends VEntryIterableFunc<Y, E>> x: getEntries()) {
			VEntryIterableFunc.nullify(x.getValue());
		}
	}
}
