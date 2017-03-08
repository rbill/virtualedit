package at.ac.tuwien.big.vmod.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.general.WrappedElementSource;
import at.ac.tuwien.big.vmodel.general.impl.WrappedInfo;

public interface VFeatureValues<T> {

	public List<?> getEcoreValue(Symbol uuid);

	public void clear();

	public Function<Symbol, Function<Treepos, Function<T, ? extends Counter>>> getFunction();

	public List<?> getValueValue(Symbol myId);

	public default void setSingleValue(Symbol myId, Object curTypeName) {
		List l = getValueValue(myId);
		if (l.contains(curTypeName)) {
			l.retainAll(Collections.singleton(curTypeName));
		} else {
			l.clear();
			l.add(curTypeName);
		}
	}
	
}
