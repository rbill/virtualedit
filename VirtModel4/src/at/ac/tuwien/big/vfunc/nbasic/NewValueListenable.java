package at.ac.tuwien.big.vfunc.nbasic;

public interface NewValueListenable<T> {
	
	public void changed(T oldValue, T newValue);

}
