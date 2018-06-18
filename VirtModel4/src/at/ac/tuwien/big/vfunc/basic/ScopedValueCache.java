package at.ac.tuwien.big.vfunc.basic;

public interface ScopedValueCache<Src,Target> extends ValueCache<Src, Target> {

	
	public FixedFinitScope<Src> getScope();
}
