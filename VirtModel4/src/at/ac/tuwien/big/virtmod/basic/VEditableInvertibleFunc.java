package at.ac.tuwien.big.virtmod.basic;

import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.wrapper.impl.EditableSetWrapperImpl;

public interface VEditableInvertibleFunc<T, U> extends VEditableFunc<T, U>, VInvertibleFunc<T, U> {

	public VEditableInvertibleFunc<U,T> inverse();
	
	public VEditableInvertibleFunc<T,U> simple();
	
	public default VEditableInvertibleFunc<U,T> inverseSimple() {
		return inverse().simple();
	}
	
	

	public default Set<T> asCollection() {
		return new EditableSetWrapperImpl<T>(this);
	}



}
