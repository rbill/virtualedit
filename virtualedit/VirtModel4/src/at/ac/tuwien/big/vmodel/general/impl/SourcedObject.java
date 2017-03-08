package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Collections;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.StaticElement;
import at.ac.tuwien.big.vmodel.general.OwnedFunc.OnCreatedListener;

public abstract class SourcedObject extends BasicVObject implements StaticElement {
	
	public SourcedObject(VContainer store) {
		super(store);
	}

	private Editstate editState = new SimpleEditState();
	
	public Editstate getEditState() {
		return editState;
	}
	

}
