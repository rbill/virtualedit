package at.ac.tuwien.big.virtmod.structure.impl;

import at.ac.tuwien.big.virtmod.structure.CannotCreateUrlException;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObjectRef;
import at.ac.tuwien.big.virtmod.structure.VResource;
import at.ac.tuwien.big.virtmod.structure.VRootObjectRef;
import at.ac.tuwien.big.virtmod.structure.VUrlCreatorObjectRef;

public class VResourceObjectRef implements VRootObjectRef, VUrlCreatorObjectRef {
	
	private VResource res;
	
	public VResourceObjectRef(VResource res) {
		this.res = res;
	}


	@Override
	public VResource resource() {
		return res;
	}
	
	@Override
	public void createUrl(StringBuilder url) throws CannotCreateUrlException {
		url.append(res.url()+"#");
	}

}
