package at.ac.tuwien.big.vmod.registry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import at.ac.tuwien.big.virtmod.ecore.impl.FakeEListImpl;

/**Only for the contents ...*/
public class FakeResource implements Resource {

	private ResourceSet rs;
	private URI uri;
	private List<EObject> contents;
	private EList<EObject> fakeContents;
	private long timestamp;
	
	public int hashCode() {
		return Objects.hashCode(uri);
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof FakeResource)) {
			return false;
		}
		FakeResource r = (FakeResource)o;
		return Objects.equals(uri, r.uri) && Objects.equals(contents,r.contents);
	}
	
	
	
	public FakeResource(ResourceSet rs, URI uri, List<EObject> contents) {
		this.rs = rs;
		this.uri = uri;
		this.contents = contents;
		this.fakeContents = new FakeEListImpl<EObject>(contents);
	}
	 
	@Override
	public EList<Adapter> eAdapters() {
		return new BasicEList<Adapter>();
	}

	@Override
	public boolean eDeliver() {
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		throw new RuntimeException("Method not implemented");
	}

	@Override
	public void eNotify(Notification notification) {
		
	}

	@Override
	public ResourceSet getResourceSet() {
		return rs;
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public void setURI(URI uri) {
		this.uri = uri;
	}

	@Override
	public long getTimeStamp() {
		return timestamp;
	}

	@Override
	public void setTimeStamp(long timeStamp) {
		this.timestamp = timeStamp;
	}

	@Override
	public EList<EObject> getContents() {
		return fakeContents;
	}

	@Override
	public TreeIterator<EObject> getAllContents() {
		return new TreeIterator<EObject>() {
			Stack<EObject> ret = new Stack<>();
			Set<EObject> hadRet = new HashSet<>();
			{
				ret.addAll(contents);
				hadRet.addAll(ret);
				Collections.reverse(ret);
			}
			int lastAdd = 0;

			@Override
			public boolean hasNext() {
				return !ret.isEmpty();
			}

			@Override
			public EObject next() {
				List<EObject> toAdd = new ArrayList<EObject>();
				EObject thisRet = ret.pop();
				EClass cl = thisRet.eClass();
				if (thisRet != null && cl != null) {
					for (EReference ref: cl.getEAllReferences()) {
						if (ref.isContainment()) {
							if (FeatureMapUtil.isMany(thisRet, ref)) {
								Collection c = (Collection)thisRet.eGet(ref);
								for (Object o: c) {
									if (o instanceof EObject) {
										EObject eo = (EObject)o;
										if (hadRet.add(eo)) {
											toAdd.add(eo);
										}
									}
								}
							}
						}
					}
				}
				Collections.reverse(toAdd);
				ret.addAll(toAdd);
				lastAdd = toAdd.size();
				return thisRet;
			}

			@Override
			public void prune() {
				for (int i = 0; i < lastAdd; ++i) {
					ret.pop();
				}
				lastAdd = 0;
			}
		};
	}

	@Override
	public String getURIFragment(EObject eObject) {
		System.err.println("GetURIFragment NYI");
		return null;
	}

	@Override
	public EObject getEObject(String uriFragment) {
		System.err.println("GetEObject NYI");
		return null;
	}

	@Override
	public void save(Map<?, ?> options) throws IOException {
		throw new RuntimeException("Save not supported!");
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		throw new RuntimeException("Load not supported!");
	}

	@Override
	public void save(OutputStream outputStream, Map<?, ?> options) throws IOException {
		throw new RuntimeException("Save not supported!");
	}

	@Override
	public void load(InputStream inputStream, Map<?, ?> options) throws IOException {
		throw new RuntimeException("Load not supported!");
	}

	@Override
	public boolean isTrackingModification() {
		return false;
	}

	@Override
	public void setTrackingModification(boolean isTrackingModification) {
		
	}

	@Override
	public boolean isModified() {
		return false;
	}

	@Override
	public void setModified(boolean isModified) {
		
	}

	@Override
	public boolean isLoaded() {
		return true;
	}

	@Override
	public void unload() {
		System.err.println("Unload not supported!");
	}

	@Override
	public void delete(Map<?, ?> options) throws IOException {
		throw new RuntimeException("Delete not supported!");
	}

	@Override
	public EList<Diagnostic> getErrors() {
		System.err.println("GetErrors not supported!");
		return new BasicEList<Resource.Diagnostic>();
	}

	@Override
	public EList<Diagnostic> getWarnings() {
		System.err.println("GetWarnings not supported!");
		return new BasicEList<Resource.Diagnostic>();
	}

}
