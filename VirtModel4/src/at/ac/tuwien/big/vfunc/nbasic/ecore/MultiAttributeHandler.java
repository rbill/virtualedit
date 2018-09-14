package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;

public interface MultiAttributeHandler<T> extends AttributeHandler<T> {
	
	public void setValues(Collection<T> newValues);
	
	public void unset();
	
	public EList<T> exposeList();
	
	@Override
	public default EList<T> getObject() {
		return exposeList();
	}
	

	@Override
	public default EList<T> readOnlyValues() {
		return exposeList();
	}
	
	@Override
	public default boolean isSet() {
		return exposeList().isEmpty();
	}
	
	public default void setSingle(T val) {
		if (val == null) {
			setValues(Collections.emptyList());
		} else {
			setValues(Collections.singleton(val));
		}
	}
	

}
