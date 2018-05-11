package at.ac.tuwien.big.vfunc.basic;

import java.util.List;

public interface ValueCache<Src,Target> extends Notifyer<ValueCache<Src,Target>, Src, Target> {
	
	public boolean isSorted();
	
	public VFunction<Src, Target> function();

	public CompleteResult<Src, Target> put(Src src, CompleteResult<Src, Target> result);
	
	public CompleteResult<Src, Target> getOrNull(Src src);
	
	/*public default CompleteResult<Src, Target> getOrCreate(Src src) {
		CompleteResult<Src, Target> ret = getOrNull(src);
		if (ret == null) {
			ret = put(src, function().fullEvaluate(src));
		}
		return ret;
	}*/
	
	public void getConstraintViolations(List<ConstraintViolation<Src, Target>> violations);
}
