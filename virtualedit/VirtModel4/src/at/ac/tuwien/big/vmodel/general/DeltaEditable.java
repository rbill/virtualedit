package at.ac.tuwien.big.vmodel.general;

/**An Editable which can be used as main part to edit things.
 * 
 */
public interface DeltaEditable<T> extends Editable<T> {

	public DeltaEditTarget<T> deltaTarget();
}
