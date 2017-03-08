package at.ac.tuwien.big.vmod.type.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.IterableType;
import at.ac.tuwien.big.vmod.type.ValueType;

public class FunctionTypeImpl extends SimpleMappedType implements FunctionType {
	
	private ValueType domain;
	private GeneralType range;
	private IterableType iterable;
	private boolean isAutocreate = true;	 

	@Override
	public ValueType getDomain() {
		return domain;
	}
	
	public void setDomain(ValueType domain) {
		this.domain = domain;
	}

	@Override
	public GeneralType getRange() {
		return range;
	}
	
	public void setRange(GeneralType range) {
		this.range = range;
	}
	

	@Override
	public GeneralType getType(String metainfoElement) {
		GeneralType exact = super.getType(metainfoElement);
		/*if (exact == null || exact == NO_TYPE) {
			return getRange();
		}*/
		return exact;
	}

	@Override
	public boolean isAutocreate() {
		return isAutocreate;
	}
	
	public void setAutocreate(boolean autocreate) {
		this.isAutocreate = autocreate;
	}

	@Override
	public IterableType getIterableTypeOrNull() {
		return iterable;
	}
	
	public void setIterableType(IterableType type) {
		this.iterable = type;
	}

	public void makeIterable() {
		this.iterable = new IterableTypeImpl(domain);
	}
}
