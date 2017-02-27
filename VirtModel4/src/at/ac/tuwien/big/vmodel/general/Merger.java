package at.ac.tuwien.big.vmodel.general;

public interface Merger<X, Y, YO> {
	
	public void notifyMyChange();
	
	public void notifyOtherChange();
	
	/**This is a constant*/
	public YO getOther();

	public void setBaseFunc(VEntryIterableFunc<X, Y> base, VEntryIterableFunc<X, ? extends Y> edit);
	
	public void setTarget(YO target);

	public void notifyAdd(int i);

}
