package at.ac.tuwien.big.virtmod.structure.impl;

import java.util.Collections;

import at.ac.tuwien.big.virtmod.structure.DeltaManager;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VLocation;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class VDeltaContainer implements VContainer {
	
	private VLocation parentLoc;
	private VContainer edit;
	private VContainer base;
	private VObject object;
	private DeltaManager manager;
	
	public VContainer getEdit() {
		return edit;
	}
	
	public VContainer getBase() {
		return base;
	}
	
	public VDeltaContainer(VLocation parentLoc, VContainer edit, VContainer base, DeltaManager manager) {
		this.parentLoc = parentLoc;
		this.edit = edit;
		this.base = base;
		this.manager = manager;
		this.object = manager.createObject(this,edit, base);
	}

	@Override
	public VLocation parentLoc() {
		return parentLoc;
	}
	
	public class VDeltaLocation implements VLocation {
		
		private String name;
		
		public VDeltaLocation(String name) {
			this.name = name;
		}

		@Override
		public VDeltaContainer parent() {
			return VDeltaContainer.this;
		}

		@Override
		public String name() {
			return name;
		}

		@Override
		public VDeltaContainer child() {
			return new VDeltaContainer(this, edit==null?null:edit.createChild(name), base==null?null:base.child(name), manager);
		}
		
	}

	@Override
	public VLocation childLoc(String name) {
		VLocation editChild = edit==null?null:edit.childLoc(name);
		VLocation baseChild = base==null?null:base.childLoc(name);
		if (editChild == null && baseChild == null) {
			return null;
		}
		if (editChild == null && baseChild != null && edit != null) {
			editChild = edit.createChild(name).parentLoc();
		}
		return new VDeltaLocation(name);
	}

	@Override
	public VObject object() {
		return this.object;
	}

	@Override
	public void removeChild(String name) {
		if (edit != null) {
			edit.removeChild(name);
		}
		System.err.println("RemoveChild was called ...");
	}

	@Override
	public VLocation getOrCreateChild(String name) {
		edit.createChild(name);
		VLocation editChild = edit==null?null:edit.childLoc(name);
		VLocation baseChild = base==null?null:base.childLoc(name);
		if (editChild == null && baseChild == null) {
			return null;
		}
		return new VDeltaLocation(name);
	}

	@Override
	public void initObject(VObject basicVObject) {
		this.object = basicVObject;
		if (edit != null && edit.object() == null) {
			//edit.initObject(basicVObject)
		}
	}

	@Override
	public Iterable<? extends ElementSourceInfo> getElementSource() {
		if (base == null)  {
			if (edit == null) {
				return Collections.emptyList();
			} else {
				return edit.getElementSource();
			}
		} else {
			if (edit == null) {
				return base.getElementSource();
			} else {
				return IteratorUtils.shallowUnion(base.getElementSource(),edit.getElementSource());	
			}
		}
		
	}

}
