package at.ac.tuwien.big.virtmod.structure.test;

public interface SimplePropertyListener<T> extends at.ac.tuwien.big.virtmod.structure.VListener {

	public default void onset(SimpleProperty<T> $This, T newVal) {}

	public default void onchange(SimpleProperty<T> changed) {}

}
