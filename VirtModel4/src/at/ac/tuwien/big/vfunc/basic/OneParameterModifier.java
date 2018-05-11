package at.ac.tuwien.big.vfunc.basic;

public interface OneParameterModifier<Source> extends OneParameterSupplier<Source> {

	public void setSource(Source source);
}
