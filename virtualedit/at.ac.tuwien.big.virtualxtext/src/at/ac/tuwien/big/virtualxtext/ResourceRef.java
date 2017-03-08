package at.ac.tuwien.big.virtualxtext;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IActionFilter;
import org.eclipse.ui.articles.views.WordActionFilter;

import at.ac.tuwien.big.vmod.registry.ViewState;

public class ResourceRef implements IAdaptable {

	private String str;
	private Resource res;
	
	public ResourceRef(String str, Resource res) {
		super();
		this.str = str;
		this.res = res;
	}
	
	public Resource getResource() {
		return res;
	}
	
	public String toString() {
		return str;
	}

	public Object getAdapter(Class adapter) {
		if (adapter == IActionFilter.class) {
			return WordActionFilter.getSingleton();
		}
		return null;
	}

}

