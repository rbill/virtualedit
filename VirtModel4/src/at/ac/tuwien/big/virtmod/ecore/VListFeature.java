package at.ac.tuwien.big.virtmod.ecore;

public interface VListFeature<ObjId,T> extends Feature<ObjId,T> {

	public VListFeaturePropertyValue<T> getValue(ObjId object);
}
