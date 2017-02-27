package at.ac.tuwien.big.virtmod.structure.impl;

import java.util.Collections;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.IntegerValueElement;
import at.ac.tuwien.big.vmodel.general.StaticElement;

public class TransformationGlobalSource implements GlobalSource<ElementSourceInfo> {

	@Override
	public Iterable<? extends ElementSourceInfo> getInfos(VObject obj) {
		if (obj instanceof IntegerValueElement) {
			IntegerValueElement iv = (IntegerValueElement)obj;
			return Collections.singleton(new TransformationElementSourceInfo(this,iv,iv.getValue()!=0));
		}
		return Collections.emptyList();
	}

}
