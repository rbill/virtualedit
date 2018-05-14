package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.op.BasicObjectLoader;
import at.ac.tuwien.big.vfunc.op.BasicOperationManager;

public class GeneralParseContainer {
	
	private final BasicOperationManager loader;
	
	public GeneralParseContainer(BasicOperationManager loader) {
		this.loader = loader;
	}
	
	
	public BasicOperationManager loader() {
		return loader;
	}
	
	

}
