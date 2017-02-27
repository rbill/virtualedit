package at.ac.tuwien.big.virtmod.structure.impl;

import java.util.Collections;

import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.StaticElement;

public class EditGlobalSource implements GlobalSource<EditElementInfo> {
	
	private final EditElementInfo eei = new EditElementInfo(this);

	@Override
	public Iterable<? extends EditElementInfo> getInfos(VObject obj) {
		return Collections.singleton(eei);
	}

}
