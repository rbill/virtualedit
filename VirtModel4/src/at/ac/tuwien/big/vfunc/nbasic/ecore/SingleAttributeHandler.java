package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;

public interface SingleAttributeHandler<T> extends AttributeHandler<T,T> {
	
	public T get();
	
	@Override
	public default T getObject() {
		return get();
	}
	
	@Override
	public boolean isSet();
	
	@Override	
	public default Collection<? extends T> readOnlyValues() {
		T val = get();
		if (val == null) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(val);
		}
	}
	
	public void set(T newObj);

	@Override
	public void unset();
	
	@Override
	public default T value() {
		return get();
	}

}
