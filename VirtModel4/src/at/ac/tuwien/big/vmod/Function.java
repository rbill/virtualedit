package at.ac.tuwien.big.vmod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.ValueType;
import at.ac.tuwien.big.vmodel.general.impl.FakeEntry;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public interface Function<T,U> extends GeneralElement {
	
	@Override
	public FunctionType getType();
	
	public U getValue(T key);
	
	public U getValueOrNull(T o);
	
	public default Iterable<Entry<T,U>> entryIterable() {
		return IteratorUtils.convert(keyIterable(), (x)->new FakeEntry<>(x, getValue(x)));
	}
	
	public default Iterable<U> valueIterable() {
		return IteratorUtils.convert(keyIterable(), (x)->getValue(x));
	}
	
	public static<T> Collection<T> getExistingValues(Function<T, ? extends Counter> func) {		
		List<T> ret = new ArrayList<>();
		for (Entry<T,? extends Counter> entry: func.entryIterable()) {
			if (entry.getValue().exists()) {
				ret.add(entry.getKey());
			}
		}
		return ret;
	}
	
	public default void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status) {
		for (U u: valueIterable()) {
			if (u instanceof GeneralElement) {
				GeneralElement ge = (GeneralElement)u;
				ge.getDerivationStatus(userModelResources,status);
			}
		}
	}
	
	public static<T> void setToVal(Function<T,? extends Counter> func, T val) {
		if (val == null) {
			func.clear();
		} else {
			for (T key: func.keyIterable()) {
				Counter c = func.getValue(key);
				Object v = key;
				if (!val.equals(key)) {
					//Es sollte da sein
					c.setMax(0);
				}
			}
			func.getValue(val).setMin(1);
		}
	}
	
	public static<T> void setToCol(Function<T,? extends Counter> func, Collection<T> col) {
		Set<T> toSet = new HashSet<>(col);
		for (T key: func.keyIterable()) {
			Counter c = func.getValue(key);
			if (!toSet.contains(key)) {
				//Es sollte da sein
				c.setMax(0);
			}
		}
		for (T key: toSet) {
			func.getValue(key).setMin(1);
		}
	}
	
	@Override
	public default Object getMetaInfo(String key) {
		if ("type".equals(key)) {
			return getType();
		} else if ("iterable".equals(key) && getType().getIterableTypeOrNull() != null) {
			return getIterableOrNull();
		}
		return GeneralElement.NO_ELEMENT;
		
	};
	
	public static interface ForEntry<T,U> {
		public void apply(Function<T,U> This, T key, U value);
	}
	
	public default void forEach(ForEntry<T,U> forEntry) {
		for (T key: (Iterable<T>)()->keyIterator()) {
			forEntry.apply(this,key,getValue(key));
		}
	}
	
	public default Iterator<T> keyIterator() {
		IterablePosition<T> pos = getIterableOrNull();
		if (pos == null) {return Collections.emptyIterator();}
		return new Iterator<T>() {
			
			IterablePosition<T> lastObject = pos.getNext();
			IterablePosition<T> lastRet = null;

			@Override
			public boolean hasNext() {
				return lastObject.hasElement();
			}

			@Override
			public T next() {
				try {
					T ret = lastObject.getObject();
					return ret;
				} finally {
					lastRet = lastObject;
					lastObject = lastObject.getNext();
				}
			}
			
			@Override
			public void remove() {
				if (lastRet != null) {
					lastRet.remove();
					lastRet = null;
				} else {
					throw new IllegalStateException();
				}
			}
		};
	}
	
	public default void clear() {
		if (!(getType().getRange() instanceof ValueType)) {
			for (T key: (Iterable<T>)()->keyIterator()) {
				((GeneralElement)getValue(key)).clear();
			}
		} else {
			//Try to remove ...
			
		}
	}

	
	@Override
	public default Object get(String key) {
		if (key.startsWith("$")) {
			return getMetaInfo(key.substring(1));
		}
		ValueType vt = getType().getDomain();
		try {
			T bla = (T)vt.parser().unmarshal(key);
			return getValue(bla);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not unmarshal "+key+" of type "+vt+": "+e.getMessage());
			return getMetaInfo(key);
		}
	}
	
	public IterablePosition getIterableOrNull();

	public default Iterable<T> keyIterable() {
		return ()->keyIterator();
	}

	public static<T> T getAnyVal(Function<T, ? extends Counter> value) {
		int maxVal = 0;
		T ret = null;
		for (Entry<T,? extends Counter> entr: value.entryIterable()) {
			int cv = entr.getValue().getValue();
			if (cv > maxVal) {
				maxVal = cv;
				ret = entr.getKey();
			}
		}
		return ret;
	}

	public static<T> void ensureNotContains(Function<Treepos, ? extends Function<T, ? extends Counter>> function, Symbol s) {
		for (Entry<Treepos, ? extends Function<?, ? extends Counter>> fent: function.entryIterable()) {
			for (Entry<?, ? extends Counter> subifo: fent.getValue().entryIterable()) {
				if (Objects.equals(subifo.getKey(),s)) {
					subifo.getValue().setMax(0);
				}
			}
		};
	}

	public static<T> void removeVal(Function<T, ? extends Counter> value, T remove) {
		Object v = remove;
		Counter c = value.getValueOrNull(remove);
		if (c != null) {
			c.setMax(0);
		}
	}

	public static boolean isEmpty(Function<Symbol, ? extends Counter> value) {
		for (Counter c: value.valueIterable()) {
			if (c.exists()) {
				return false;
			}
		}
		return true;
	}



}
