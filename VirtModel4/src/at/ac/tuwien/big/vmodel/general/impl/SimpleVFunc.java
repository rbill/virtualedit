package at.ac.tuwien.big.vmodel.general.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class SimpleVFunc<T,U> extends SourcedObject implements OwnedFunc<T, U>, VEntryIterableFunc<T, U> {
	private Map<T, U> map = new HashMap<T, U>();
	private Creater<? extends U, ? super T> creator;
	private OnCreatedListener<T, U> listener;
	
	public void setOnCreatedListener(OnCreatedListener<T, U> listener) {
		this.listener = listener;
	}
	
	
	
	public SimpleVFunc(VContainer store, Creater<? extends U, ? super T> creator) {
		super(store);
		this.creator = creator;
	}
	
	public SimpleVFunc(VContainer store, Map<T,U> map, Creater<? extends U, ? super T> creator) {
		this(store,creator);
		this.map = map;
	}
	
	public String toString() {
		return ToString();
	}
	

	@Override
	public boolean isSelfEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean selfClear() {
		boolean ret = !map.isEmpty();
		map.clear();
		return ret;
	}

	@Override
	public U get(T x) {
		U ret = map.get(x);
		if (ret == null) {
			//new Exception().printStackTrace();
			//System.out.println("Changing map of "+getClass()+"@"+System.identityHashCode(this));
			map.put(x, ret = creator.create(x));
			if (listener != null) {
				listener.onCreated(this, x, ret);
			}
		}
		return ret;
	}


	@Override
	public void set(T t, U u) {
		map.put(t, u);
	}


	@Override
	public U getOrNull(T t) {
		return map.get(t);
	}

	@Override
	public Iterable<Entry<T, U>> getEntries() {
		return map.entrySet();
	}
	
	

}
