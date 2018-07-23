package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;

public class AbstractFunctionNotifyer<This extends FunctionNotifyer<This,Source,Target>, Source, Target> implements FunctionNotifyer<This, Source, Target>   {
	
	List<WeakReference<ChangeListenable<? super This, ? super Source, ? super Target>>> changeListeners = new ArrayList<WeakReference<ChangeListenable<? super This,? super Source,? super Target>>>();

	@Override
	public List<WeakReference<ChangeListenable<? super This, ? super Source, ? super Target>>> getChangeListeners() {
		return changeListeners;
	}
	
	

}
