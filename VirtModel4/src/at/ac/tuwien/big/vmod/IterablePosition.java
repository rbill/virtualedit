package at.ac.tuwien.big.vmod;

import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.IterableType;

/**This iterable is not guaranteed to return each element only once*/
public interface IterablePosition<T> extends GeneralElement {
	
	public IterableType getType();
	
	public T getObject();
	
	public boolean hasElement();
	
	public void remove();


	public default void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status) {
		//Do nothing
	}

	@Override
	public default void clear() {
		remove();
	}
	
	public default boolean isEnd() {
		return getNextOrNull() == null;
	}
	
	public default boolean isStart() {
		return getPreviousOrNull() == null;
	}
	
	public default IterablePosition<T> getNext() {
		IterablePosition<T> ret = getNextOrNull();
		if (ret == null) {
			return this;
		}
		return ret;		
	}
	
	public IterablePosition<T> getNextOrNull();
	
	public default boolean hasNext() {
		return getNext().hasElement();
	}
	
	public default IterablePosition<T> getPrevious() {
		IterablePosition<T> ret = getPreviousOrNull();
		if (ret == null) {
			return this;
		}
		return ret;
	}
	
	public IterablePosition<T> getPreviousOrNull();
	
	public default boolean hasPrevious() {
		return getPrevious().hasElement();
	}
	
	//Add, not necessarily previously of afterwards
	public void add(T obj);

}
