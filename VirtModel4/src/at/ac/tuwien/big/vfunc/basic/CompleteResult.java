package at.ac.tuwien.big.vfunc.basic;

public interface CompleteResult<Src,Target> extends FunctionBasedValue<Src, Target>, Refreshable, ChangeListenable<FunctionNotifyer<?,Object,Object>, Object, Object>, FunctionNotifyer<CompleteResult<Src, Target>,Src,Target> {
	
	public SubResultInfo usedResults();

	public void mergeWithCurrent(CompleteResult<Src, Target> result);
	
	public Assignment<Src, Target> reason();

	@Override
	public default VFunction<Src, Target> function() {
		return reason().getFunction();
	}

}
