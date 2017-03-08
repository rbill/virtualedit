package at.ac.tuwien.big.virtmod.ecore;

public interface Association<A,B>  {


	public VListFeature<A,B> getLeft();
	
	public VListFeature<B,A> getRight();
	
	
	
}