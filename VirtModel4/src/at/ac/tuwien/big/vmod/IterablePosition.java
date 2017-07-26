package at.ac.tuwien.big.vmod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
	
	public default boolean has(T obj) {
		if (hasElement() && Objects.equals(obj,getObject())) {
			return true;
		}
		IterablePosition<T> next = getNextOrNull();
		if (next != null) {
			return next.has(obj);
		}
		return false;
	}
	
	//Add, not necessarily previously of afterwards
	public void add(T obj);
	
	public default List<T> getAllObjects() {
		Set<T> ret = new HashSet<T>();
		List<T> retList = new ArrayList<T>(); 
		priv_getAllObjects(retList,ret);
		return retList;
	}
	
	public default void priv_getAllObjects(List<T> list, Set<T> objs) {
		if (hasElement()) {
			T obj = getObject();
			if (objs.add(obj)) {
				list.add(obj);
			}
		}
		IterablePosition<T> next = getNextOrNull();
		if (next != null) {
			next.priv_getAllObjects(list,objs);
		}
	}
	
	public default boolean setValue(GeneralElement other) {
		if (other instanceof IterablePosition) {
			clear();
			IterablePosition<T> ip = (IterablePosition)other;
			List<T> allObjs = ip.getAllObjects();
			for (T t: allObjs) {
				add(t);
			}
			return true;
		}
		return false;
	}

}

