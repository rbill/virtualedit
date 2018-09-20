package at.ac.tuwien.big.vfunc.nbasic;

public interface ListListenable<T> {
	
	public void added(int index, T object, ListChangeNotifyer<T> lcn);
	
	public void changed(int index, T oldObject, T newObject, ListChangeNotifyer<T> lcn);
	
	public void changed(ListChangeNotifyer<T> lcn);
	
	public void removed(int index, T object, ListChangeNotifyer<T> lcn);

}
