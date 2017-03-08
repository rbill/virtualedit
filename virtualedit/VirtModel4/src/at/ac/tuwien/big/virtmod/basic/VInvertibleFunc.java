package at.ac.tuwien.big.virtmod.basic;

public interface VInvertibleFunc<T,U> extends VFunc<T, U> {
	
	public VInvertibleFunc<U,T> inverse();

}
