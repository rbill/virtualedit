package at.ac.tuwien.big.vfunc.nbasic;


import at.ac.tuwien.big.vfunc.basic.Value;

public interface BasicValuedChangeNotifyer<Target> extends BasicChangeNotifyer, Value<Target>/*, PartialResult*/ {

	/**May be null*/
	public MetaInfo getMetaInfo();
	
}
