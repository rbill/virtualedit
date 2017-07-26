package at.ac.tuwien.big.vmod.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.vmod.type.parser.Parser;

public class SymbolImpl implements Symbol {
	
	private String name;
	private List<Object> contents = new ArrayList<>();
	
	public SymbolImpl() {
		
	}
	
	public SymbolImpl(String string) {
		if (string == null) {
			return;
		}
		Object copyFromO = Parser.SYMBOL_PARSER.unmarshal(string);
		if (copyFromO instanceof Symbol) {
			Symbol copyFrom = (Symbol)copyFromO;
			name = copyFrom.getName();
			contents.addAll(copyFrom.subObjects());
		} else if (copyFromO != null) {
			name = String.valueOf(copyFromO);
		}
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void addObject(Object subObject) {
		this.contents.add(subObject);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public List<Object> subObjects() {
		return contents;
	}
	
	public int hashCode() {
		return Objects.hashCode(name)+contents.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Symbol)) {
			return false;
		}
		Symbol sym = (Symbol)o;
		if (!Objects.equals(sym.getName(), getName())) {
			return false;
		}
		if (contents.size() != sym.subObjects().size()) {
			return false;
		}
		Iterator<Object> myIter = subObjects().iterator();
		Iterator<Object> otherIter = sym.subObjects().iterator();
		while (myIter.hasNext() && otherIter.hasNext()) {
			if (!Objects.equals(myIter.next(), otherIter.next())) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return Parser.SYMBOL_PARSER.marshal(this);
	}
	
	public SymbolImpl shallowClone() {
		SymbolImpl ret = new SymbolImpl();
		ret.setName(getName());
		ret.subObjects().addAll(subObjects());
		return ret;
	}
}
