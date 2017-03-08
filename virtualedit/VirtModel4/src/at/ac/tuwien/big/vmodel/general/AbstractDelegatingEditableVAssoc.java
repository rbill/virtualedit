package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;

public interface AbstractDelegatingEditableVAssoc<X,Y,E extends EditableIntegerValueElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,E>>>
	extends AbstractDelegatingVAssoc<X,Y,E,F>{

	

	public static <X,Y,E extends EditableIntegerValueElement> VAssoc<X,Y,E> ensureVAssoc(VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,E>> func) {
		if (func instanceof VAssoc)  {
			return (VAssoc)func;
		} else {
			return new SimpleAbstractDelegatingVAssoc<>(func.store(),func);
		}
	}

	
}
