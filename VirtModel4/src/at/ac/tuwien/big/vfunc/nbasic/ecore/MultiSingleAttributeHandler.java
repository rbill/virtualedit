package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.eclipse.jdt.annotation.NonNull;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;

public class MultiSingleAttributeHandler<T> implements SingleAttributeHandler<T> {
	
	MultiAttributeHandler<T> multiHandler;
	List<T> list;

	
	public MultiSingleAttributeHandler(@NonNull MultiAttributeHandler<T> multiHandler) {
		this.multiHandler = multiHandler;
		this.list = multiHandler.exposeList();
	}

	@Override
	public T get() {
		if (this.list.isEmpty()) {
			return null;
		}
		return this.list.get(0);
	}

	@Override
	public List<WeakReference<BasicListenable>> getBasicChangeListeners() {
		return this.multiHandler.getBasicChangeListeners();
	}

	@Override
	public List<BasicListenable> getLocalBasicChangeListeners() {
		return this.multiHandler.getLocalBasicChangeListeners();
	}

	@Override
	public AbstractFunc<?, ?, ? extends QueryResult<?, ?>> getTreeposFuncOrNull() {
		return this.multiHandler.getTreeposFuncOrNull();
	}

	@Override
	public boolean isSet() {
		return !this.list.isEmpty();
	}

	@Override
	public void set(T newObj) {
		if (newObj == null) {
			//Clear
			this.list.clear();
		} else {
			if (this.list.isEmpty()) {
				this.list.add(newObj);
			} else {
				if (Objects.equals(this.list.get(0), newObj)) {
					return;
				} else {
					if (this.list.contains(newObj)) {
						//Remove everything except it
						Iterator<T> iter = this.list.iterator();
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
						this.list.set(0, newObj);
					}
				}
			}
		}
	}

	@Override
	public void unset() {
		this.multiHandler.unset();
	}

}
