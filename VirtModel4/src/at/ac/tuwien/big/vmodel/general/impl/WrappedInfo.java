package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.vmodel.general.StaticElement;
import at.ac.tuwien.big.vmodel.general.WrappedElementSource;

public class WrappedInfo implements WrappedElementSource {

	private Iterable<? extends ElementSourceInfo> base;
	
	public WrappedInfo(Iterable<? extends ElementSourceInfo> base) {
		this.base = base;
	}
	
	public Iterable<? extends ElementSourceInfo> base() {
		return base;
	}

	@Override
	public boolean isRelevant() {
		for (ElementSourceInfo b: base) {
			if (b.isRelevant()) {
				return true;
			}
		}
		return false;
	}
	

}
