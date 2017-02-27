package at.ac.tuwien.big.vmodel.general;

import java.util.Map;

import at.ac.tuwien.big.virtmod.structure.VObject;

public interface DeltaVFunc<T,U,U1 extends VObject,U2 extends VObject> extends VFunc<T, U> {
	 
	VFunc<? super T, ? extends U1> first();
	VFunc<? super T, ? extends U2> second();

	
		
	OwnedFunc<T, U> cache();	
	DeltaCreater<U1,U2,? extends U> creater();
	
	
	@Override
	public default U get(T x) {
		U ret = cache().getOrNull(x);
		if (ret == null) {
			cache().set(x, ret = creater().create(first().get(x), second().get(x)));
		}
		return ret;
	}

	@Override
	public default boolean isSelfEmpty() {
		return first().isSelfEmpty();
	}

	@Override
	public default boolean selfClear() {
		return first().selfClear();
	}


}
