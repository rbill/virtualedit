package at.ac.tuwien.big.vmod.impl;

public interface Projector<T extends Iterable<U>,U> {
	public T project(T src, T add);
}
