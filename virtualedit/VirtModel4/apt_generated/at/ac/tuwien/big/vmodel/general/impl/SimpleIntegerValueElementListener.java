package at.ac.tuwien.big.vmodel.general.impl;

public interface SimpleIntegerValueElementListener extends at.ac.tuwien.big.virtmod.structure.VListener, 
			at.ac.tuwien.big.virtmod.structure.ChangeListener<SimpleIntegerValueElement> {

	public default void onselfClear(SimpleIntegerValueElement $This) {}

	public default void onadd(SimpleIntegerValueElement $This, int value) {}

	public default void ontoString(SimpleIntegerValueElement $This) {}

	public default void onchange(SimpleIntegerValueElement changed) {}

}
