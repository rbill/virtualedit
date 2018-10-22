package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;

public interface MultiAttributeHandler<T> extends AttributeHandler<T, List<T>> {
	
	public EList<T> exposeList();
	
	@Override
	public default EList<T> getObject() {
		return exposeList();
	}
	
	@Override
	public default boolean isSet() {
		return !exposeList().isEmpty();
	}
	
	@Override
	public default EList<T> readOnlyValues() {
		return exposeList();
	}
	
	public default void setSingle(T val) {
		if (val == null) {
			setValues(Collections.emptyList());
		} else {
			setValues(Collections.singleton(val));
		}
	}
	

	public void setValues(Collection<T> newValues);
	
	@Override
	public void unset();
	
	@Override
	public default List<T> value() {
		return exposeList();
	}
	

}
