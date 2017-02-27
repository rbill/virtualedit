package at.ac.tuwien.big.virtmod.structure;

import at.ac.tuwien.big.virtmod.structure.impl.VNamedObjectRef;
import at.ac.tuwien.big.virtmod.structure.impl.VResourceObjectRef;

public interface VResourceRegistry {
	
	public VResource get(String uri);
	
	public VResource put(String uri, VResource res);
	
	public default VContainer resolveContainer(String uri) throws CannotResolveUriException {
		return getRef(uri).thisContainer();
	}
	
	public default VUrlCreatorObjectRef getRef(String uri) throws CannotResolveUriException {
		int firstPartIndex = uri.indexOf('#');
		String firstPart = uri;
		if (firstPartIndex != -1) {
			firstPart = uri.substring(0,firstPartIndex);
			uri = uri.substring(firstPartIndex+1);
		} else {
			uri = "";
		}
		VResource ret = get(firstPart);
		if (ret == null) {
			throw new CannotResolveUriException(uri);
		}
		VUrlCreatorObjectRef current = new VResourceObjectRef(ret);
		if (firstPartIndex == -1) {
			return current;
		}
		String[] spl = uri.split("/");
		for (int i = 0; i < spl.length; ++i) {
			current = new VNamedObjectRef(current, spl[i]);
		}
		return current;
	}

}
