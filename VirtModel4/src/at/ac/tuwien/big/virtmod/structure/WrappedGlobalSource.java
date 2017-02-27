package at.ac.tuwien.big.virtmod.structure;

import at.ac.tuwien.big.vmodel.general.StaticElement;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class WrappedGlobalSource<T extends ElementSourceInfo> implements GlobalSource<T> {
	private Iterable<? extends GlobalSource<? extends T>> base;
	
	public WrappedGlobalSource(Iterable<? extends GlobalSource<? extends T>> base) {
		this.base = base;
	}
	

	@Override
	public Iterable<? extends T> getInfos(VObject obj) {
		return IteratorUtils.flatten(base, (x)->x.getInfos(obj));
	}
	

}
