package at.ac.tuwien.big.vmod.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;

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

	public default boolean resourceUriEnabled(String uri) {
		if (uri == null) {
			for (Resource disabled: disabledViews()) {
				if (disabled.getURI() == null) {
					return false;
				}
			}
			return true;
		} else {
			URI uuri = URIConverter.INSTANCE.normalize(URI.createURI(uri));
			for (Resource disabled: disabledViews()) {
				if (uuri.equals(disabled.getURI())) {
					return false;
				}
			}
			return true;
		}
		 
	}

	public default void setShownViews(List<Resource> res) {
		Set<Resource> curDisabled = disabledViews();
		Set<Resource> curEnabled = enabledViews();
		Set<Resource> all = new HashSet<Resource>(curDisabled);
		all.addAll(curEnabled);
		all.removeAll(res);
		addToView(res);
		deleteFromView(all);
	}

}
