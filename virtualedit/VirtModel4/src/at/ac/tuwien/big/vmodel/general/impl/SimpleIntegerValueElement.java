package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.helper.annotation.VMethod;
import at.ac.tuwien.big.helper.annotation.VProp;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;

@VProp
public class SimpleIntegerValueElement extends SourcedObject implements EditableIntegerValueElement {
	
	
	public SimpleIntegerValueElement(VContainer store) {
		super(store);
	}

	private int value;
	
	@Override
	public int getValue() {
		return value;
	}

	@Override
	@VMethod(use=false)
	public boolean isSelfEmpty() {
		return value == 0;
	}

	@Override
	@VMethod(use=true)
	public boolean selfClear() {
		boolean ret = value!=0;
		value = 0;
		return ret;
	}

	@Override
	@VMethod(use=true)
	public void add(int value) {
		this.value+= value;
	}
	
	public String toString() {
		return String.valueOf(value);
	}

}
