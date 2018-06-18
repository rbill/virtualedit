package at.ac.tuwien.big.vfunc.basic;

import at.ac.tuwien.big.vfunc.basic.impl.SingleFunction;

public interface Assignment<Src, Target> {

	VFunction<Src, Target> getFunction();
	
	Scope<Src> getScope();
	
	Expression<Src,Target> getExpression();
	
	Editor getEditor();
	
	public ValueCache<Src, Target> getCacheIfExists();
	
	public SingleFunction<Src, Target> getFunctionIfExists();
	
	/**Hard assignment: := - Only for fixed Scopes ...
	 * Soft assignment: =
	 * ?? Supersoft assignment (pure constraint): ==
	 */
	public AssignmentType getType();

	public default CompleteResult<Src, Target> evaluateIfApplicable(Src src) {
		if (getScope().contains(src)) {
			return getExpression().apply(this,src);
		}
		return null;
	}
	
}
