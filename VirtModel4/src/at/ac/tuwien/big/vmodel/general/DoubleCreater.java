package at.ac.tuwien.big.vmodel.general;

public interface DoubleCreater<X,Y,Z> {

	public Z create(X x, Y y);
}
