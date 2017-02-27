package at.ac.tuwien.big.virtmod.structure;

public interface VRootObjectRef extends VObjectRef {
	
	public default VObjectRef parent() {
		return null;
	}
	
	public VResource resource();
	
	public default VContainer thisContainer() {
		return resource().container();
	}

}
