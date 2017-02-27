package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.virtmod.basic.VEditableBag;
import at.ac.tuwien.big.virtmod.basic.VEditableFunc;
import at.ac.tuwien.big.virtmod.basic.VFunc;
import at.ac.tuwien.big.virtmod.basic.delta.AugmentingEditState;
import at.ac.tuwien.big.virtmod.basic.delta.ListAugmentingVList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditableList;
import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VListFeature;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;

public class AssociationFeature<A,T> implements VListFeature<A,T> {

	private Map<A,VListFeaturePropertyValue<T>> map = new HashMap<>();
	private VEditableFunc<A,T> base;
	
	public AssociationFeature(VEditableFunc<A,T> base) {
		this.base = base;
	}
	

	@Override
	public VListFeaturePropertyValue<T> getValue(A object) {
		VListFeaturePropertyValue<T> ret = map.get(object);
		if (ret == null) {
			map.put(object, ret = new SimpleFeaturePropertyValue<T>(new ListAugmentingVList<T>(base.getValueBag(object), new SimpleEditableList<T>())));
		}
		return ret;
	}

}
