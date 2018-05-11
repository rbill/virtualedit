package at.ac.tuwien.big.vfunc.basic;

import java.util.NoSuchElementException;

import org.sat4j.tools.FullClauseSelectorSolver;

public interface VFunction<Src,Target> {
	
	public default Target evaluateReduced(Src source) throws NoSuchElementException {
		CompleteResult<Src, Target> evaluate = evaluate(source);
		if (evaluate == null) {
			throw new NoSuchElementException("Element "+source+" not found!");
		} else {
			return evaluate.value();
		}
	}
	
	/**Must also augment the cache, I think
	 * Should not be called at any time (only as part of evaluate in the default method)
	 * */
	public CompleteResult<Src,Target> priv_calcResult(Src source);
	
	public ValueCache<Src, Target> cache();
	
	public Scope<Src> getScope();
	
	public FunctionType<Src,Target> getType();
	
	public default CompleteResult<Src,Target> evaluate(Src source) {
		ValueCache<Src, Target> cache  = cache();
		if (cache != null) {
			CompleteResult<Src, Target> ret = cache.getOrNull(source);
			if (ret != null) {
				return ret;
			}
		}
		return priv_calcResult(source);
	}

}
