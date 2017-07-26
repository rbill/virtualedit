package at.ac.tuwien.big.verocl.parameterdesc;

public interface SingleModelPoint extends SinglePoint {
	
	public PseudoModelRef getModelRef();
	
	public default Object[] getValues() {
		return getModelRef().getValues();
	}

}
