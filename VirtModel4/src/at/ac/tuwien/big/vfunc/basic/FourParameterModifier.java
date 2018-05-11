package at.ac.tuwien.big.vfunc.basic;

public interface FourParameterModifier<Source,Param1,Param2,Param3> extends FourParameterSupplier<Source,Param1, Param2, Param3>, ThreeParameterModifier<Source,Param1,Param2> {

	public void setParam3(Param3 param2);
}
