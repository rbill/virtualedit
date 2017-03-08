package at.ac.tuwien.big.virtmod.basic;

import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.wrapper.impl.EditableSetWrapperImpl;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.SetWrapperImpl;

public interface VEditableSet<T> extends VSet<T>, VEditableBag<T> {
	


	public default Set<T> asCollection() {
		return new EditableSetWrapperImpl<T>(this);
	}
	
	public default boolean addDefault(T arg0) {
		return addSet(arg0);
	}
	

	public default VEditableSet<T> getBaseEditableSet() {
		return this;
	}
	

}
