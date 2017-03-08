package at.ac.tuwien.big.virtmod.structure.property;

public interface SingleSetVProperty<T> extends SingleGetVProperty<T> {

	public void set(T newVal);
}
