package at.ac.tuwien.big.vmodel.general;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.impl.FakeEntry;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface VAssoc<X,Y,E extends IntegerValueElement> extends ParameterInvertibleFunc<X, Y, E> {

	public default boolean contains(X x, Y y) {
		return get(x,y).getValue() > 0;
	}
	
	public default Iterable<Entry<X,Y>> getExistingEntries() {
		return ()->new Iterator<Entry<X,Y>>() {
			
			Iterator<? extends Entry<? extends X,? extends VEntryIterableFunc<Y, ? extends E>>> entrIter = getEntries().iterator();
			X curX = null;
			Iterator<? extends Entry<? extends Y, ? extends E>> otherIter = null;
			Y nextY = null;
			
			@Override
			public boolean hasNext() {
				if (nextY != null) {
					return true;
				}
				for(;;) {
					while (otherIter == null || !otherIter.hasNext()) {
						if (!entrIter.hasNext()) {
							return false;
						}
						Entry<? extends X, ? extends VEntryIterableFunc<Y, ? extends E>> nextEntry = entrIter.next();
						curX = nextEntry.getKey();
						otherIter = nextEntry.getValue().getEntries().iterator();
					}
					while (otherIter.hasNext()) {
						Entry<? extends Y,? extends E> nextTry = otherIter.next();
						if (nextTry.getValue().getValue()>0) {
							nextY = nextTry.getKey();
							return true;
						}
					}
				}
			}

			@Override
			public Entry<X, Y> next() {
				if (hasNext()) {
					try {
						return new FakeEntry<>(curX,nextY);
					} finally {
						nextY = null;
					}
				}
				throw new NoSuchElementException();
			}
		};
	}
	

	//public VAssoc<X,Y,E,UF,TF> baseClone(VContainer newCont, DoubleCreater<X, Y, E> newCreator);
}
