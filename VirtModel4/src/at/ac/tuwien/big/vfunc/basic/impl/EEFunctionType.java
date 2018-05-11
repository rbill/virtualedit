package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;

import at.ac.tuwien.big.vfunc.basic.FunctionType;

public class EEFunctionType implements FunctionType<BasicEE, BasicEE> {

	private final List<Class<?>> srcClasses;
	private final List<Class<?>> trgClasses;
	 
	public EEFunctionType(List<Class<?>> srcClasses, List<Class<?>> trgClasses) {
		this.srcClasses = srcClasses;
		this.trgClasses = trgClasses;
	}
	
	@Override
	public Class<BasicEE> getSourceType() {
		return BasicEE.class;
	}

	@Override
	public Class<BasicEE> getTargetType() {
		return BasicEE.class;
	}
	
	@Override
	public boolean doesMatch(Object srcObj) {
		if (!FunctionType.super.doesMatch(srcObj)) {
			return false;
		}
		BasicEE bee = (BasicEE)srcObj;
		for (int i = srcClasses.size()-1; i >= 0; ++i) {
			if (!bee.has(i)) {
				return false;
			}
			Object obj = bee.get(i);
			if (obj == null || !srcClasses.get(i).isInstance(obj)) {
				return false;
			}
		}
		return true;
	}

}
