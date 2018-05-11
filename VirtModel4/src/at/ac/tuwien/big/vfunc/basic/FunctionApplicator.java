package at.ac.tuwien.big.vfunc.basic;

import java.util.function.Function;

public interface FunctionApplicator<Src,Subsource,Subtarget> {

	public VFunction<Subsource, Subtarget> function();
	
	public Function<Src, Subsource> extractor();
	
	public default CompleteResult<Subsource, Subtarget> getResult(Src src) {
		return function().evaluate(extractor().apply(src));
	}
	 
}
