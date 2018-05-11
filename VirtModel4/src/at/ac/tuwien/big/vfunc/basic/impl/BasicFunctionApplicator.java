package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.FunctionApplicator;
import at.ac.tuwien.big.vfunc.basic.VFunction;

import java.util.function.Function;

public class BasicFunctionApplicator<Src, Subsource, Subtarget> implements FunctionApplicator<Src, Subsource, Subtarget>{

	private final VFunction<Subsource, Subtarget> function;
	private final Function<Src, Subsource> extractor;
	
	public BasicFunctionApplicator(VFunction<Subsource, Subtarget> function, Function<Src, Subsource> extractor) {
		this.function = function;
		this.extractor = extractor;
	}
	
	@Override
	public VFunction<Subsource, Subtarget> function() {
		return function;
	}

	@Override
	public Function<Src, Subsource> extractor() {
		return extractor;
	}

}
