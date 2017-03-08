package at.ac.tuwien.big.vmod.type.impl;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.vmod.type.GeneralType;

public class SimpleMappedType implements GeneralType {
	
	private Map<String,GeneralType> typeMap = new HashMap<>();
	

	@Override
	public Iterable<String> getSupportedMetaInfo() {
		return typeMap.keySet();
	}

	@Override
	public GeneralType getType(String metainfoElement) {
		return typeMap.getOrDefault(metainfoElement, NO_TYPE);
	}
	
	public void addType(String metainfoElement, GeneralType type) {
		typeMap.put(metainfoElement, type);
	}

}
