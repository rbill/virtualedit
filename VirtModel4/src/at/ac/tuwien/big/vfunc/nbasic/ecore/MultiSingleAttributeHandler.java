package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.eclipse.jdt.annotation.NonNull;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;

public class MultiSingleAttributeHandler<T> implements SingleAttributeHandler<T> {
	
	MultiAttributeHandler<T> multiHandler;
	List<T> list;

	
	public MultiSingleAttributeHandler(@NonNull MultiAttributeHandler<T> multiHandler) {
		this.multiHandler = multiHandler;
		this.list = multiHandler.exposeList();
	}

	@Override
	public boolean isSet() {
		return !list.isEmpty();
	}

	@Override
	public T get() {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public void set(T newObj) {
		if (newObj == null) {
			//Clear
			list.clear();
		} else {
			if (list.isEmpty()) {
				list.add(newObj);
			} else {
				if (Objects.equals(list.get(0), newObj)) {
					return;
				} else {
					if (list.contains(newObj)) {
						//Remove everything except it
						Iterator<T> iter = list.iterator();
						while (iter.hasNext()) {
							if (!Objects.equals(iter.next(), newObj)) {
								iter.remove();
							} else {
								//Found, now it is the first which is returned!
								return;
							}
						}
					} else {
						//Replace an existing value
						list.set(0, newObj);
					}
				}
			}
		}
	}

	@Override
	public void unset() {
		multiHandler.unset();
	}

	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return multiHandler.getBasicChangeListeners();
	}

	@Override
	public List<BasicListenable> getLocalBasicChangeListeners() {
		return multiHandler.getLocalBasicChangeListeners();
	}

}
