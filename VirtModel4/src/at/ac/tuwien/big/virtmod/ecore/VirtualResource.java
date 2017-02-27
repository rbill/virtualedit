package at.ac.tuwien.big.virtmod.ecore;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotifierImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.ecore.impl.VEObjectImpl;

//Der Link zu meinem Zeugs
public abstract class VirtualResource<A> extends ResourceImpl implements Resource{
	
	public abstract VEditableList<A> getRootContents();
	
	public abstract VirtualModel<A> getModel();
	
	private EList<EObject> lastRet;
	
	private Resource phyiscalResource;
	
	public VirtualResource(Resource physicalResource) {
		this.phyiscalResource = physicalResource;
	}
	
	@Override
	public EList<EObject> getContents() {
		if (lastRet == null) {
			lastRet = new ConvertingListImpl<EObject,A>(getRootContents().asCollection(),
					(x)->{if (x instanceof VEObject) {
							return ((VEObject<A>) x).getUUID();
						  } else {
							throw new RuntimeException("Adding real EObjects to Virtual Resource not yet implemented");
						  }
					},(x)->new VEObjectImpl<A>(x,getModel(),this));
		}
		return lastRet;
	}
	
	private void saveInResource() {
		
		asdf;
	}
	
	private void loadFromResource() {
		asdf;
	}


	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		saveInResource();
		phyiscalResource.save(outputStream, options);
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		phyiscalResource.load(inputStream, options);
		loadFromResourceResource();		
	}

	@Override
	public boolean isLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
