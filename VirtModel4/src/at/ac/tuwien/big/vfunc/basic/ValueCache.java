package at.ac.tuwien.big.vfunc.basic;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface ValueCache<Src,Target> extends FunctionNotifyer<ValueCache<Src,Target>, Src, Target> {
	
	public boolean isSorted();
	
	public VFunction<Src, Target> function();

	public CompleteResult<Src, Target> put(Src src, CompleteResult<Src, Target> result);
	
	public CompleteResult<Src, Target> getOrNull(Src src);
	
	public CompleteResult<Src, Target> getOrCreate(Src src);
	
	//Not to be edited!
	public default Map<Src, CompleteResult<Src,Target>> getDirectMap() {
		return Collections.emptyMap();
	}
	
	/*public default CompleteResult<Src, Target> getOrCreate(Src src) {
		CompleteResult<Src, Target> ret = getOrNull(src);
		if (ret == null) {
			ret = put(src, function().fullEvaluate(src));
		}
		return ret;
	}*/
	
	public void getConstraintViolations(List<ConstraintViolation<Src, Target>> violations);
}
