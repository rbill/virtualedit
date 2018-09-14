package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocal;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;

public interface AttributeHandler<T> extends BasicChangeNotifyerWithLocal {
	
	public void unset();

	public Object getObject();

	public boolean isSet();

	public Collection<? extends T> readOnlyValues();

}
