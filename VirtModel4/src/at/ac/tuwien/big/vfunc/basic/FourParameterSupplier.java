package at.ac.tuwien.big.vfunc.basic;

public interface FourParameterSupplier<Source,Param1,Param2,Param3> extends ThreeParameterSupplier<Source,Param1,Param2> {

	public Param3 getParam3();
}
