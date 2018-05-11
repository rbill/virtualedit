package at.ac.tuwien.big.vfunc.basic;

public interface ThreeParameterSupplier<Source,Param1,Param2> extends TwoParameterSupplier<Source,Param1> {

	public Param2 getParam2();
}
