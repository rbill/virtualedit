package at.ac.tuwien.big.vmodel.general;

public interface SimpleDualFunc<X,Y> {

	public Y get(X x);
	
	public X getInv(Y y);
	
	public void set(X x, Y y);
}
