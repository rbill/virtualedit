package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.util.SetUtils;
import at.ac.tuwien.big.util.Util;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class VirtualResource {
	
	private List<VMEObject> rootObjects = new ArrayList<>();
	private EObjectManager manager;
	
	public VirtualResource(EObjectManager manager) {
		this.manager = manager;
	}
	
	public void addRoot(VMEObject root) {
		rootObjects.add(root);
	}
	
	public List<VMEObject> getRoots() {
		return rootObjects;
	}
	
	public List<VMEObject> getAllObjects() {
		return SetUtils.getRecursivelyL(rootObjects, x->{
			return ()->IteratorUtils.filterType(IteratorUtils.multiIterator(x.eContents().iterator(),x.eCrossReferences().iterator()),VMEObject.class);
		});
	}
	
 
	public EObjectManager getManager() {
		return manager;
	}
}
