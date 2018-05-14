package at.ac.tuwien.big.vfunc.op;

public interface BasicOperation<U> {

	public Class<? extends U> getRequiredClass();
	
	public void process(U object, Object... parameters);
}
