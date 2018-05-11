package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.FunctionType;

public class BasicFunctionType<Src, Target> implements FunctionType<Src, Target> {

	private Class<Src> srcClass;
	private Class<Target> trgClass;
	 
	public BasicFunctionType(Class<Src> srcClass, Class<Target> trgClass) {
		this.srcClass = srcClass;
		this.trgClass = trgClass;
	}
	
	@Override
	public Class<Src> getSourceType() {
		return srcClass;
	}

	@Override
	public Class<Target> getTargetType() {
		return trgClass;
	}

}
