package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.virtmod.ecore.ClassObject;

public class ClassObjectImpl<A> implements ClassObject<A> {
	
	private Map<A,String> classMap = new HashMap<>();

	@Override
	public void setClass(A object, String cl) {
		classMap.put(object, cl);
	}

	@Override
	public String getClass(A uuid) {
		return classMap.get(uuid);
	}

}
