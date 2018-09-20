package at.ac.tuwien.big.vfunc.nbasic;

public interface SetValueModificator<Func extends AbstractFunc<Src, Trg, ?>, Src,Trg> extends FunctionModificator {

	public void setValue(Func func, Src src, Trg newValue);
	
	public void unsetValue(Func func, Src src);
}
 