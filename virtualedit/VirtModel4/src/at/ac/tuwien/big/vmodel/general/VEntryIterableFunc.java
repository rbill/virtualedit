package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface VEntryIterableFunc<X,Y> extends VFunc<X, Y> {
	
	public Iterable<? extends Entry<? extends X, ? extends  Y>> getEntries();

	public default Iterable<? extends Y> getValues() {
		return IteratorUtils.convert(getEntries(), (x)->x.getValue());
	}

	public default Iterable<? extends X> getKeys() {
		return IteratorUtils.convert(getEntries(), (x)->x.getKey());
	}
	
	public default String ToString() {
		StringBuilder ret = new StringBuilder();
		toString(ret);
		return ret.toString();
	}
	
	public default void toString(StringBuilder builder) {
		builder.append("{");
		boolean first = true;
		for (Entry<? extends X, ? extends Y> entry: getEntries()) {
			if (first) {first = false;} else {builder.append(", ");}
			builder.append(String.valueOf(entry.getKey())+" -> "+String.valueOf(entry.getValue()));
		}
		builder.append("}");
	}


	public static<X,E extends EditableIntegerValueElement> void clear(VEntryIterableFunc<X,E> func) {
		for (Entry<? extends X, ? extends E> entr: func.getEntries()) {
			entr.getValue().clear();
		}
	}
	


	public static<X,E extends EditableIntegerValueElement> void nullify(VEntryIterableFunc<X, E> func) {
		for (Entry<? extends X, ? extends E> entr: func.getEntries()) {
			entr.getValue().nullify();
		}
	}

	public static<X, E extends IntegerValueElement> boolean isEmpty(VEntryIterableFunc<?, E> func) {
		for (Entry<?, ? extends E> entr: func.getEntries()) {
			if (entr.getValue().getValue() > 0) {
				return false;
			}
		}
		return true;
	}

	//public VEntryIterableFunc<X,Y> baseClone(VContainer newCont, Creater<Y, X> newCreator);
}
