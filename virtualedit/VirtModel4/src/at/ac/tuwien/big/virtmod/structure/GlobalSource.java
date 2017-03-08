package at.ac.tuwien.big.virtmod.structure;

import at.ac.tuwien.big.vmodel.general.StaticElement;

public interface GlobalSource<T extends ElementSourceInfo> {

	public Iterable<? extends T> getInfos(VObject obj);
	
}
