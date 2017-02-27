package at.ac.tuwien.big.virtmod.basic;

public interface ValueState<X> {

	public X value();

	public ContainState state();
	
	public long editId();

}
