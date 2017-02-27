package at.ac.tuwien.big.virtmod.structure.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VGlobalSourceContainer;
import at.ac.tuwien.big.virtmod.structure.VLocation;
import at.ac.tuwien.big.virtmod.structure.VObject;

public class VSimpleContainer implements VGlobalSourceContainer {
	
	private VLocation parentLoc;
	private Map<String,VLocation> childLocs = new HashMap<>();
	private VObject object;
	private GlobalSource<? extends ElementSourceInfo> globalSource;
	
	public VSimpleContainer(GlobalSource<? extends ElementSourceInfo> globalSource) {
		this.globalSource = globalSource;
	}
	
	public VSimpleContainer(VLocation parentLoc) {
		this.parentLoc = parentLoc;
	}
	
	@Override
	public VLocation parentLoc() {
		return parentLoc;
	}

	@Override
	public VLocation childLoc(String name) {
		return childLocs.get(name);
	}

	@Override
	public VObject object() {
		return object;
	}

	@Override
	public void removeChild(String name) {
		childLocs.remove(name);
	}

	@Override
	public VLocation getOrCreateChild(String name) {
		VLocation ret = childLocs.get(name);
		if (ret == null) {
			childLocs.put(name,ret = new VSimpleLocation(this, name));
		}
		return ret;
	}

	@Override
	public void initObject(VObject object) {
		this.object = object;
	}


	@Override
	public GlobalSource<? extends ElementSourceInfo> getGlobalSource() {
		return globalSource;
	}

}
