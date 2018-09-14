package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;

public interface SingleAttributeHandler<T> extends AttributeHandler<T> {
	
	public boolean isSet();
	
	public T get();
	
	public void set(T newObj);
	
	public void unset();

	@Override
	public default T getObject() {
		return get();
	}
	
	@Override	
	public default Collection<? extends T> readOnlyValues() {
		T val = get();
		if (val == null) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(val);
		}
	}

}
