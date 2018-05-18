package at.ac.tuwien.big.vfunc.basic;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

public interface MyCloneable<T extends MyCloneable<?>> {

	public default T cloneNew() {
		return clone(new IdentityHashMap<>());
	}
	
	public default T clone(Map<Object,Object> map) {
		T ret = (T)map.get(this);
		if (ret == null) {
			map.put(this, ret = initClone());
			((MyCloneable)ret).finishClone(this, map);
		}
		return ret;
	}
	
	public T initClone();
	
	public void finishClone(T previous, Map<Object,Object> map);
	
	public default<U> U cloneSub(U obj, Map<Object,Object> map) {
		if (obj == null) {return null;}
		U ret = (U)map.get(obj);
		if (ret == null) {
			boolean finish = false;
			U add = null;
			U x = obj;
			if (obj instanceof MyCloneable) {
				finish = true;
				add = (U)((MyCloneable)x).initClone();
			} else if (x instanceof Collection) {
				Class<?> cl = x.getClass();
				Collection col = null;
				try {
					col = (Collection)cl.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				Collection fcol = col;
				((Collection<?>)x).forEach(y->fcol.add(cloneSub(y,map)));
				add = (U)col;
			} else if (x instanceof Map) {
				//TODO: Doesn't work for TreeMap (same for TreeSet)
				Class<?> cl = x.getClass();
				Map retMap = null;
				try {
					retMap = (Map)cl.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				Map fretMap = retMap;
				((Map<?,?>)x).forEach((k,v)->{fretMap.put(cloneSub(k,map), cloneSub(v,map));});
				add = (U)retMap;
			} else {
				add = (U)x;
			}
			map.put(obj, ret = add);
			if (finish) {
				((MyCloneable)add).finishClone((MyCloneable)obj,map);
			}
		}
		return ret;
	}
}
