package at.ac.tuwien.big.vmod.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;

public interface ViewState {
	
	public Set<Resource> enabledViews();
	
	public Set<Resource> disabledViews();
	
	public default boolean addToView(Iterable<Resource> res) {
		boolean ret = false;
		for (Resource r: res) {
			ret|= addToView(r);
		}
		return ret;
	}
	
	public default boolean addToView(Resource res) {
		boolean ret = enabledViews().add(res);
		ret|= disabledViews().remove(res);
		return ret;
	}
	
	public default boolean deleteFromView(Iterable<Resource> res) {
		boolean ret = false;
		for (Resource r: res) {
			ret|= deleteFromView(r);
		}
		return ret;
	}
	
	public default boolean deleteFromView(Resource res) {
		boolean ret = enabledViews().remove(res);
		ret|= disabledViews().add(res);
		return ret;
	}
	
	public default void setViewState(Resource res, boolean isEnabled) {
		if (isEnabled) {
			addToView(res);
		} else {
			deleteFromView(res);
		}
	}

	public default void setTotalViews(List<Resource> changeModels) {
		Set<Resource> enabled = new HashSet<Resource>(changeModels);
		Set<Resource> curEnabled = enabledViews();
		enabled.removeAll(curEnabled);
		enabled.retainAll(changeModels);
		enabledViews().addAll(enabled);
	}

}
