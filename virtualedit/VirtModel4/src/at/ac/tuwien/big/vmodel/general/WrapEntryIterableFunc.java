package at.ac.tuwien.big.vmodel.general;

import java.util.Iterator;
import java.util.Map.Entry;

import at.ac.tuwien.big.vmodel.general.impl.FakeEntry;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface WrapEntryIterableFunc<X, Y1, Y2> extends WrapFunc<X, Y1, Y2>, VEntryIterableFunc<X, Y2>, OwnedFunc<X, Y2> {
	

	public VEntryIterableFunc<X,? extends Y1> base();

	public default Iterable<Entry<? extends X, ? extends Y2>> getEntries() {
		return IteratorUtils.convert(base().getEntries(), (x)->new FakeEntry<>(x.getKey(),get(x.getKey())));
	}
}
