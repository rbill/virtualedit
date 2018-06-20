package at.ac.tuwien.big.vfunc.basic;

public interface Value<T> {
	
	public T value();

	public default boolean isDefined() {
		return value() != null;
	}
}
