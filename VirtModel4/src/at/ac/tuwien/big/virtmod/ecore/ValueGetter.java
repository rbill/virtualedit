package at.ac.tuwien.big.virtmod.ecore;

@FunctionalInterface
public interface ValueGetter<T> {
	public T get();
}

