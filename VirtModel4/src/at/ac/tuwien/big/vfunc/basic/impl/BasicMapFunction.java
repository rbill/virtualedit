package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Scope;

public class BasicMapFunction<Src,Target> {

	private Map<Src,CompleteResult<Src,Target>> map = new HashMap<>();
	
	public void put(Src src, Object thing) {
		map.put(src, value);
		myScope.notifyChanged(source, oldValue, newValue);
	}
	
	
	
	private Scope<Src> myScope = new AbstractFiniteScope<Src>() {

		@Override
		public boolean contains(Src src) {
			return map.containsKey(src);
		}

		@Override
		public Collection<Src> getValues() {
			return map.keySet();
		}
	};
	
	public Scope<Src> getScope() {
		return myScope;
	};
}
