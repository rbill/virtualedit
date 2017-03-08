package at.ac.tuwien.big.vmodel.general.impl;

public interface SimpleDeltaIntegerValueEditableViewListener<U1,U2> extends at.ac.tuwien.big.virtmod.structure.VListener, 
			at.ac.tuwien.big.virtmod.structure.ChangeListener<SimpleDeltaIntegerValueEditableView<U1,U2>> {

	public default void ontoString(SimpleDeltaIntegerValueEditableView<U1,U2> $This) {}

	public default void onselfClear(SimpleDeltaIntegerValueEditableView<U1,U2> $This) {}

	public default void onadd(SimpleDeltaIntegerValueEditableView<U1,U2> $This, int value) {}

	public default void onchange(SimpleDeltaIntegerValueEditableView<U1,U2> changed) {}

}
