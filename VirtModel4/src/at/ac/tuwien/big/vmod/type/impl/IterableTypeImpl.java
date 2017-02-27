package at.ac.tuwien.big.vmod.type.impl;

import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.IterableType;
import at.ac.tuwien.big.vmod.type.ValueType;

public class IterableTypeImpl extends SimpleMappedType implements IterableType {
	
	private GeneralType range;
	
	public IterableTypeImpl() {
		
	}
	
	public IterableTypeImpl(GeneralType range) {
		this.range = range;
	}

	@Override
	public boolean isTreeposIterator() {
		return ValueType.Treepos.equals(getRange());
	}

	@Override
	public boolean isExtensible() {
		return false;
	}

	@Override
	public GeneralType getRange() {
		return range;
	}
	
	public void setRange(GeneralType range) {
		this.range = range;
	}

}
