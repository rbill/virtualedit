package at.ac.tuwien.big.vfunc.basic;

public interface TwoParameterSupplier<Source,Param1> extends OneParameterSupplier<Source> {

	public Param1 getParam1();
}
