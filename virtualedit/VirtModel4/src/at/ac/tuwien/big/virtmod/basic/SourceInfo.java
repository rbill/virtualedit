package at.ac.tuwien.big.virtmod.basic;

import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo.GeneratedState;

public class SourceInfo {

	public static boolean isGenerated(Object source)  {
		if (source instanceof Source) {
			return ((Source) source).isGenerated();
		}
		if (source instanceof ElementSourceInfo) {
			GeneratedState state = ((ElementSourceInfo) source).isGenerated();
			return state != null && state != GeneratedState.FULL_MANUAL; 
		}
		return false;
	}
	
	public static int betterUserEdit(Object a, Object b) {
		return Boolean.compare(isGenerated(a), isGenerated(b));
	}
}
