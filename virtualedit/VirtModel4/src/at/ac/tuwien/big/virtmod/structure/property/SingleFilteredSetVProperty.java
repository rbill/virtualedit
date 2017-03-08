package at.ac.tuwien.big.virtmod.structure.property;

import java.util.Objects;

public interface SingleFilteredSetVProperty<T> extends SingleSetVProperty<T>{
	
	public default void set(T newVal) {
		T curVal = get();
		if (Objects.equals(curVal, newVal)) {
			return;
		}
		internalSet(newVal);
		
	}
	
	public void internalSet(T newVal);

}
