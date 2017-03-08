package at.ac.tuwien.big.vmod.type.impl;

import java.util.Collections;

import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.GeneralType;

public class CountTypeImpl implements CountType {
	
	private boolean isEditable; 

	@Override
	public Iterable<String> getSupportedMetaInfo() {
		return Collections.emptyList();
	}

	@Override
	public GeneralType getType(String metainfoElement) {
		return NO_TYPE;
	}
	
	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	@Override
	public boolean isEditable() {
		return isEditable;
	}

}
