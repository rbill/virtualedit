package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.basic.BasicTextUI.BasicHighlighter;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;

public class WeakChangeFuncNotifyer<This extends WeakChangeFuncNotifyer<This, Source, Target>,Source,Target> extends 
	WeakObjectImpl<Source> implements FunctionNotifyer<This, Source, Target>, BasicChangeNotifyer {

	List<WeakReference<ChangeListenable<? super This, ? super Source, ? super Target>>> changeListeners = new ArrayList<WeakReference<ChangeListenable<? super This,? super Source,? super Target>>>();
	List<WeakReference<BasicListenable>> basicChangeListeners = new ArrayList<WeakReference<BasicListenable>>();
	
	@Override
	public List<WeakReference<ChangeListenable<? super This, ? super Source, ? super Target>>> getChangeListeners() {
		return changeListeners;
	}
	
	@Override
	public void finalize() {
		super.finalize();
		
	}

	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return basicChangeListeners;
	}

	@Override	
	public void notifyChanged(Source source, Target oldValue, Target newValue) {
		FunctionNotifyer.super.notifyChanged(source, oldValue, newValue);
		BasicChangeNotifyer.super.changed();
	}
}
