package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditableList;
import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;

public class SimpleFeature<A,T> implements Feature<A,T>{
	
	private Map<A,FeaturePropertyValue<T>> map = new HashMap<>();
	

	@Override
	public FeaturePropertyValue<T> getValue(A object) {
		FeaturePropertyValue<T> ret = map.get(object);
		if (ret == null) {
			map.put(object, ret = new SimpleFeaturePropertyValue<T>(new SimpleEditableList<T>()));
		}
		return ret;
	}

}
