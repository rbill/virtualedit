package at.ac.tuwien.big.virtmod.ecore;

@FunctionalInterface
public interface ValueSetter<T> {
	public void set(T val);
}

