package at.ac.tuwien.big.virtmod.structure;

public interface VListeningProperty<L extends VListener>
 extends VProperty {
	
	public void addListener(L listener);
	
	public void addIncompleteListener(VListener listener);
	
	public void removeListeners(VObject fromObject);

	@SuppressWarnings("unchecked")
	@Override
	public default VListeningProperty<L> toListeningProperty() {
		return this;
	}
}
