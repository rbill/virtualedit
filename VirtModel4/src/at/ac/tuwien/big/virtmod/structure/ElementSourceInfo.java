package at.ac.tuwien.big.virtmod.structure;

import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.vmodel.general.StaticElement;

public interface ElementSourceInfo {
	
	public enum GeneratedState {
		FULL_GENERATED, PARTIAL_GENERATED, FULL_MANUAL;
	}
	
	public GlobalSource<?> getSource();
	
	//If the source info is object-specific, the object, else null
	public VObject getObject();
	
	public GeneratedState isGenerated();
	
	public boolean isRelevant();
	
	//TODO: So einfach passt das nicht, in wirklichkeit müsste
	//man sowas wie "Welche Editieroperationen gehen hier?" anbieten
	//public boolean isChangeable();

}
