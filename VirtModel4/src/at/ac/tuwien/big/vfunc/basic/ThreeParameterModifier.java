package at.ac.tuwien.big.vfunc.basic;

public interface ThreeParameterModifier<Source,Param1,Param2> extends ThreeParameterSupplier<Source,Param1, Param2>, TwoParameterModifier<Source,Param1> {

	public void setParam2(Param2 param2);
}
