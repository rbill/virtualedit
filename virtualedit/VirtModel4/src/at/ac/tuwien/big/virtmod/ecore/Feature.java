package at.ac.tuwien.big.virtmod.ecore;

public interface Feature<ObjId,T> {
	
	public FeaturePropertyValue<T> getValue(ObjId object);

}
