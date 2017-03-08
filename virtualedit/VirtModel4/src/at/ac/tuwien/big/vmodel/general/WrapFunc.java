package at.ac.tuwien.big.vmodel.general;

public interface WrapFunc<X,Y1,Y2> extends VFunc<X,Y2> {
	
	public DoubleParameterIFace<? super X, ? super Y1, ? extends Y2> wrapper();
	
	
	public VFunc<X,? extends Y1> base();
	
	public OwnedFunc<X,Y2> cache();
	
	@Override
	public default Y2 get(X x) {
		Y2 ret = cache().get(x);
		if (ret == null) {
			cache().set(x, ret = wrapper().get(x, base().get(x)));
		}
		return ret;
	}
	

}
