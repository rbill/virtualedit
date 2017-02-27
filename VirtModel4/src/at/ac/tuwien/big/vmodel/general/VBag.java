package at.ac.tuwien.big.vmodel.general;

import java.util.Map.Entry;

import at.tuwien.big.virtmod.datatype.IteratorUtils;
import at.tuwien.big.virtmod.datatype.IteratorUtils.Filter;

public interface VBag<X,E extends IntegerValueElement> extends VEntryIterableFunc<X, E> {
	
	public default boolean contains(X x) {
		return get(x).getValue()>0;
	}

	public default int size() {
		int ret = 0;
		for (Entry<? extends X,? extends E> entr: getEntries()) {
			if (entr.getValue().exists()) {
				++ret;
			}
		}
		return ret;
	}
	
	public default Iterable<? extends Entry<? extends X,? extends E>> getExistingEntries() {
		return ()->IteratorUtils.filterType(getEntries().iterator(), (x)->x.getValue().exists());
	}
	
	public default Iterable<? extends X> getExistingKeys() {
		return IteratorUtils.convert(()->IteratorUtils.filterType(getEntries().iterator(), (x)->x.getValue().exists()),(x)->x.getKey());
	}
	
	public default Iterable<? extends E> getExistingValues() {
		return IteratorUtils.convert(()->IteratorUtils.filterType(getEntries().iterator(), (x)->x.getValue().exists()),(x)->x.getValue());
	}
	
	public default boolean isEmpty() {
		for (Entry<? extends X,? extends E> entr: getEntries()) {
			if (entr.getValue().exists()) {
				return false;
			}
		}
		return true;
	}
}
