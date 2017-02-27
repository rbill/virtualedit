package at.ac.tuwien.big.virtmod.structure.impl;

import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.StaticElement;

public class TransformationElementSourceInfo implements ElementSourceInfo {
	
	private GlobalSource<?> source;
	private VObject obj;
	private boolean isRelevant;
	
	public TransformationElementSourceInfo(GlobalSource<?> source, VObject obj, boolean isRelevant) {
		this.source = source;
		this.obj = obj;
		this.isRelevant = isRelevant;
	}

	@Override
	public GlobalSource<?> getSource() {
		return source;
	}

	@Override
	public VObject getObject() {
		return obj;
	}

	@Override
	public GeneratedState isGenerated() {
		return GeneratedState.FULL_GENERATED;
	}

	@Override
	public boolean isRelevant() {
		return isRelevant;
	}

}
