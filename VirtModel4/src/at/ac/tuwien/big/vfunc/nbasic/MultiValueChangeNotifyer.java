package at.ac.tuwien.big.vfunc.nbasic;

public interface MultiValueChangeNotifyer<Src,Trg> {
	
	public void notifyChanged(Src src, Trg oldValue, Trg newValue);

}
