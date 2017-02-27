package at.ac.tuwien.big.virtmod.ecore;

import java.util.Set;

import at.ac.tuwien.big.virtmod.structure.VObject;

public interface VClass extends VObject {

	
	public String getName();
	
	public Feature<String,?> getFeature(String name);
	
	public Set<Feature<String,?>> getFeatures();
}
