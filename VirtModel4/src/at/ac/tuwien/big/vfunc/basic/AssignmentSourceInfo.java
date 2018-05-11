package at.ac.tuwien.big.vfunc.basic;

public interface AssignmentSourceInfo<Src,Target> extends FunctionSourceInfo<Src, Target> {

	public default VFunction<Src,Target> function() {
		return reason().getFunction();
	}
	
	public Assignment<Src,Target> reason();
	
	public Src source(); 
	
	public default CompleteResult<Src, Target> calcResult() {
		return reason().getExpression().apply(this);
	}

}
