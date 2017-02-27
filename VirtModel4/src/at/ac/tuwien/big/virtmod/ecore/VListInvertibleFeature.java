package at.ac.tuwien.big.virtmod.ecore;

public interface VListInvertibleFeature<A,B> extends VListFeature<A,B> {

	
	public VListInvertibleFeature<B,A> inverse();
}
