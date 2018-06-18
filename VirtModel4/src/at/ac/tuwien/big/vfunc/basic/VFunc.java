package at.ac.tuwien.big.vfunc.basic;

import java.util.NoSuchElementException;

import org.sat4j.tools.FullClauseSelectorSolver;

public interface VFunc<Src,Target> {
	
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
	
	
	public Scope<Src> getScope();
	
	public FunctionType<Src,Target> getType();
	

	public CompleteResult<Src, Target> getOrNull(Src src);
	
	public default CompleteResult<Src,Target> evaluate(Src source) {
		CompleteResult<Src, Target> ret = getOrNull(source);
		if (ret != null) {
			return ret;
		}
		return priv_calcResult(source);
	}

	public default boolean containsKey(Src src) {
		return getScope().contains(src);
	}

}
