package at.ac.tuwien.big.vfunc.basic;

public interface TwoParameterModifier<Source,Param1> extends OneParameterModifier<Source>, TwoParameterSupplier<Source, Param1> {

	public void setParam1(Param1 param);
}
