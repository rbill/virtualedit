package at.ac.tuwien.big.virtmod.structure.impl;

import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.StaticElement;

public class EditElementInfo implements ElementSourceInfo {
	
	private GlobalSource<?> source;
	
	public EditElementInfo(GlobalSource<?> source) {
		this.source = source;
	}

	@Override
	public GlobalSource<?> getSource() {
		return source;
	}

	@Override
	public VObject getObject() {
		return null;
	}

	@Override
	public GeneratedState isGenerated() {
		return GeneratedState.FULL_MANUAL;
	}

	@Override
	public boolean isRelevant() {
		return true;
	}

}
