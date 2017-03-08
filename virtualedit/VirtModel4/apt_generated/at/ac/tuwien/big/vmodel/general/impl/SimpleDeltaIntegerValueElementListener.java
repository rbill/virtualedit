package at.ac.tuwien.big.vmodel.general.impl;

public interface SimpleDeltaIntegerValueElementListener<U1,U2> extends at.ac.tuwien.big.virtmod.structure.VListener, 
			at.ac.tuwien.big.virtmod.structure.ChangeListener<SimpleDeltaIntegerValueElement<U1,U2>> {

	public default void ontoString(SimpleDeltaIntegerValueElement<U1,U2> $This) {}

	public default void onselfClear(SimpleDeltaIntegerValueElement<U1,U2> $This) {}

	public default void onadd(SimpleDeltaIntegerValueElement<U1,U2> $This, int value) {}

	public default void onchange(SimpleDeltaIntegerValueElement<U1,U2> changed) {}

}
