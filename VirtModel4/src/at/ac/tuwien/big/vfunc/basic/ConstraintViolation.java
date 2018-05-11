package at.ac.tuwien.big.vfunc.basic;

/**Hier muss man aufpassen dass alternateFunctionResult natuerlich nicht automatisch aktualisiert wird
 *
 * 
 * @author Robert
 *
 * @param <Src>
 * @param <Target>
 */
public interface ConstraintViolation<Src,Target> {
	//Eigentlich unterscheiden sich die eher 
	CompleteResult<Src, Target> assignmentResult();
	
	CompleteResult<Src, Target> alternateFunctionResult();
	
	/**Ich glaube nicht, dass man diese methode nutzen kann weil das alternateFunctionResult sich nicht adaptiert
	 * Man kann es also nur nutzen, wenn man weiﬂ, dass die Scopes statisch sind
	 * @return
	 */
	public default boolean isResolved() {
		Target firstValue = assignmentResult().value();
		Target secondValue = assignmentResult().value();
		return firstValue == null || secondValue == null || firstValue.equals(secondValue);
	}

}
