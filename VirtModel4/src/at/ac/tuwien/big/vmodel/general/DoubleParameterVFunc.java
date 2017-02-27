package at.ac.tuwien.big.vmodel.general;

public interface DoubleParameterVFunc<X,Y,Z> extends DoubleParameterFunc<X, Y, Z> {

	public VFunc<X, VFunc<Y, Z>> onParameter1Func();
	
	public VFunc<Y, VFunc<X, Z>> onParameter2Func();
	

	public default Z get(X x, Y y) {
		return onParameter1Func().get(x).get(y);
	}
}
