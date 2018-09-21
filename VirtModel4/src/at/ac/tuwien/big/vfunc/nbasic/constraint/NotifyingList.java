package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.ListChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.ListListenable;

public class NotifyingList<T> extends AbstractList<T> implements ListChangeNotifyer<T> {

	private List<T> delegate;
	private List<WeakReference<BasicListenable>> changeListeners = new ArrayList<>();
	private List<WeakReference<ListListenable<T>>> listChangeListeners = new ArrayList<>();
	
	public NotifyingList(List<T> delegate) {
		this.delegate = delegate;
	}
	
	
	@Override
	public void add(int index, T obj) {
		this.delegate.add(index,obj);
		add(index, obj);
	}

	@Override
	public T get(int index) {
		return this.delegate.get(index);
	}
	


	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return this.changeListeners;
	}
	
	@Override
	public List<WeakReference<ListListenable<T>>> getListChangeListeners() {
		return this.listChangeListeners;
	}
	
	@Override
	public T remove(int index) {
		T ret = this.delegate.remove(index);
		removed(index, ret);
		return ret;
	}
	
	
	

	@Override
	public T set(int index, T obj) {
		T old = this.delegate.set(index, obj);
		changed(index, old, obj);
		return old;
	}


	@Override
	public int size() {
		return this.delegate.size();
	}

}