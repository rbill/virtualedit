package at.ac.tuwien.big.virtmod.basic.col;

public interface Converter<X,Y> {

	public Y convert(X x);
}
