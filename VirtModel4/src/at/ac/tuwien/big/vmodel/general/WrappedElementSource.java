package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo.GeneratedState;

public interface WrappedElementSource extends ElementSourceInfo {

	public static interface Getter<T,U> {
		public T get(U u);
	}
	
	public Iterable<? extends ElementSourceInfo> base();
	
	
	public default <T> T getEqual(Getter<T,ElementSourceInfo> info, T mixedValue) {
		T ret = null;
		for (ElementSourceInfo el: base()) {
			T tryEl = info.get(el);
			if (ret == null) {
				ret = tryEl;
			} else {
				if (tryEl != null && !ret.equals(tryEl)) {
					return mixedValue;
				}
			}
		}
		return ret;
	}
	
	@Override
	public default GlobalSource<?> getSource() {
		return getEqual((x)->x.getSource(),null);
	}

	@Override
	public default VObject getObject() {
		return getEqual((x)->x.getObject(),null);
	}

	@Override
	public default GeneratedState isGenerated() {
		return getEqual((x)->x.isGenerated(),GeneratedState.PARTIAL_GENERATED);
	}
}
