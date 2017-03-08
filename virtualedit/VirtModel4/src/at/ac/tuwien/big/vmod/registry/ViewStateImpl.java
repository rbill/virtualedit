package at.ac.tuwien.big.vmod.registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;

public class ViewStateImpl implements ViewState {
	
	private Set<Resource> enabledViews = new HashSet<>();
	private Set<Resource> disabledViews = new HashSet<>();
	
	@Override
	public Set<Resource> enabledViews() {
		return enabledViews;
	}

	@Override
	public Set<Resource> disabledViews() {
		return disabledViews;
	}
	
	public String toString() {
		return "exclude: " + disabledViews+", include: "+enabledViews;
	}

}
