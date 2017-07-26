package at.ac.tuwien.big.vmod.type;

import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.virtmod.basic.Treepos;

public interface Symbol {
	
	public String getName();
	
	public List<Object> subObjects();

	public default String debugString() {
		StringBuilder ret = new StringBuilder();
		ret.append("[Symbol] "+getName()+"(");
		boolean first = true;
		for (Object o: subObjects()) {
			if (first) {first = false;} else {ret.append(", ");}
			if (o == null) {
				ret.append("null");
				continue;
			}
			if (o instanceof Integer) {
				ret.append("[Integer] "+o);
			} else if (o instanceof Treepos) {
				ret.append("[Treepos] "+o);	
			} else if (o instanceof String ){
				ret.append("[String] "+o);
			} else if (o instanceof Symbol) {
				ret.append(((Symbol)o).debugString());
			} else {
				ret.append("[Unknown "+o.getClass().getSimpleName()+"] "+o);
			}
		}
		ret.append(")");
		return ret.toString();
	}

	public static Symbol from(String name) {
		SymbolImpl ret = new SymbolImpl();
		ret.setName(name);
		return ret;
	}

	public static Symbol buildFrom(Symbol base, Object... contained) {
		SymbolImpl ret = new SymbolImpl();
		ret.setName(base.getName());
		ret.subObjects().addAll(base.subObjects());
		for (Object o: contained) {
			ret.subObjects().add(o);
		}
		return ret;
	}
	
	public static Symbol buildFrom(String name, Object... contained) {
		return buildFrom(Symbol.from(name),contained);
	}

	public static Symbol fromFull(String key) {
		return new SymbolImpl(key);
	}

	public Symbol shallowClone();
}
