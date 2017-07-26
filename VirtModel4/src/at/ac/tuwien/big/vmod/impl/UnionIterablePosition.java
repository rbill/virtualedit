package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.type.IterableType;

public class UnionIterablePosition<Type extends IterableType,T> extends SimpleUnionGeneralElement<Type, IterablePosition<T>, IterablePosition<T>> implements IterablePosition<T>{

	public UnionIterablePosition(GeneralElement parent, Type type, IterablePosition<T> base, IterablePosition<T> edit, boolean isUserEdit) {
		super(type, base, edit, isUserEdit);
		setParent(parent);
	}
	
	

	@Override
	public T getObject() {
		if (getBase().hasElement()) {
			return getBase().getObject();
		}
		return getEdit().getObject();
	}

	@Override
	public boolean hasElement() {
		return getBase().hasElement() || getEdit().hasElement();
	}

	@Override
	public void remove() {
	/*//Cannot delete: If you don't delete everything, things might remain. However, you should not delete everything ...
		IterablePosition<T> editObject = getEditObject();
		if (editObject.hasElement()) {
			editObject.remove();
		}*/
	}

	@Override
	public IterablePosition<T> getNextOrNull() {
		if (getBase().isEnd()) {
			IterablePosition<T> next = getEdit().getNextOrNull();
			if (next == null) {
				return null;
			}
			return new UnionIterablePosition(getParent(),getType(), getBase(), next, isUserEdit());
		} 
		IterablePosition<T> next = getBase().getNext();
		return new UnionIterablePosition(getParent(),getType(), next, getEdit(), isUserEdit());
	}


	@Override
	public IterablePosition<T> getPreviousOrNull() {
		if (getEdit().isStart()) {
			IterablePosition<T> previous = getBase().getPreviousOrNull();
			if (previous == null) {
				return null;
			}
			return new UnionIterablePosition(getParent(),getType(), previous, getEdit(), isUserEdit());
		} 
		IterablePosition<T> previous = getEdit().getPrevious();
		return new UnionIterablePosition(getParent(),getType(), getBase(), previous, isUserEdit());
	}

	@Override
	public void add(T obj) {
		IterablePosition<T> editObject = getEditObject();
		editObject.add(obj);
	}

}
