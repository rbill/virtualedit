package at.ac.tuwien.big.virtualxtext;

import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.*;

import at.ac.tuwien.big.vmod.registry.MultiResourceSetInfo;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo;

public class ResourceListMultiContentProvider 
	implements IStructuredContentProvider
{
	ResourceListMulti input;
	ListViewer viewer;
	static WeakHashMap<Resource,ResourceRef> resourceToRef = new WeakHashMap<>();
	
	public static ResourceRef getRef(Resource res) {
		if (res == null) {
			return null;
		}
		ResourceRef ret = resourceToRef.get(res);
		if (ret == null) {
			String name = res.getURI().path();
			if (name.contains("/")) {
				name = name.substring(name.lastIndexOf('/'));
			}
			ret = new ResourceRef(name, res);
			resourceToRef.put(res, ret);
		}
		return ret;
	}
	
	public ResourceRef[] getRefs(MultiResourceSetInfo info) {
		if (info == null) {
			return new ResourceRef[0];
		}
		List<Resource> aspects = info.getAllViews();
		ResourceRef[] ret = new ResourceRef[aspects.size()];
		{
			for (int i = 0; i < ret.length; ++i) {
				ret[i] = getRef(aspects.get(i)); 
			}
		}
		return ret;
	}

	/**
	 * @see IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object element) {
		if (element == input) {
			return getRefs(input.getResourceInfo());
		}	
		return new Object[0];
	}

	/**
	 * @see IContentProvider#dispose()
	 */
	public void dispose() {
		if (input != null) {
		//input.setListener(null);
		}
		input = null;
		viewer = null;
	}

	/**
	 * @see IContentProvider#inputChanged(Viewer, Object, Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (viewer instanceof ListViewer) {
			this.viewer = (ListViewer)viewer;
		}
		if (newInput instanceof ResourceListMulti) {
			input = (ResourceListMulti)newInput;
			//input.setListener(this);
		}
	}

//	/**
//	 * @see Listener#added()
//	 */
//	public void added(Resource e) {
//		if (viewer != null)
//			viewer.add(e);
//	}
//	
//	/**
//	 * @see Listener#removed()
//	 */
//	public void removed(Word e) {
//		if (viewer != null) {
//			viewer.setSelection(null);
//			viewer.remove(e);
//		}
//	}
}

