package at.ac.tuwien.big.vfunc.nbasic;

@FunctionalInterface
public interface TriConsumer<A,B,C> {
	
	public void consume(A a, B b, C c);

}
