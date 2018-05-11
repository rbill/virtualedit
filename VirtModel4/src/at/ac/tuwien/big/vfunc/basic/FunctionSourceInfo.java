package at.ac.tuwien.big.vfunc.basic;

public interface FunctionSourceInfo<Src,Target> {

	public VFunction<Src,Target> function();
	
	public Src source(); 
	
	public default CompleteResult<Src, Target> calcResult() {
		return function().evaluate(source());
	}

}
