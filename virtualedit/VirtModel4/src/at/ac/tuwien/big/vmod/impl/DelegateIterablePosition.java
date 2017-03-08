package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.type.IterableType;

public class DelegateIterablePosition<Type extends IterableType,T> extends SimpleDelegateGeneralElement<Type, IterablePosition<T>> implements IterablePosition<T>{

	public DelegateIterablePosition(Type type, IterablePosition<T> base, boolean isUserEdit) {
		super(type, base, isUserEdit);
	}

	@Override
	public T getObject() {
		return getBase().getObject();
	}

	@Override
	public boolean hasElement() {
		return getBase().hasElement();
	}

	@Override
	public void remove() {
		//Cannot delete: If you don't delete everything, things might remain. However, you should not delete everything ...
		/*IterablePosition<T> editObject = getEditObject();
		if (editObject.hasElement()) {
			editObject.remove();
		}*/
	}

	@Override
	public IterablePosition<T> getNextOrNull() {
		if (getBase().isEnd()) {
			return new DelegateIterablePosition(getType(), getBase(), isUserEdit());
		} 
		IterablePosition<T> next = getBase().getNext();
		return new DelegateIterablePosition(getType(), next, isUserEdit());
	}


	@Override
	public IterablePosition<T> getPreviousOrNull() {
		IterablePosition<T> previous = getBase().getPreviousOrNull();
		if (previous == null) {
			return null;
		}
		return new DelegateIterablePosition(getType(), previous, isUserEdit());
	}

	@Override
	public void add(T obj) {
		IterablePosition<T> editObject = getEditObject();
		editObject.add(obj);
	}

}
