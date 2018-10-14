package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;
import at.ac.tuwien.big.virtmod.ecore.VirtualModel;


public class NewEObjectCreator implements EObjectCreator {
	
	private Set<Resource> knownResources = new HashSet<>();
	private Map<List<String>, EObject> existingObjects = new HashMap<>();
	private Map<Identifier, ModelDeltaVMEObject> existingObjectMap = new HashMap<>();
	private Map<Identifier, EObject> realObjects = new HashMap<>();
	
	private Map<Resource, Map<String,Integer>> objectCount = new HashMap<>();
	private EObjectManager manager;
	private CreatorId cid;
	
	public NewEObjectCreator(EObjectManager manager, CreatorId cid) {
		this.manager = manager;
		this.cid = cid;
	}
	
	@Override
	public ModelDeltaVMEObject createEObject(Identifier ide, Object... parameters) {
		String epkgUri = (String)parameters[0];
		String name = (String)parameters[1];
		String subId = (String)parameters[2];
		List<String> strList = Arrays.asList(epkgUri, name, subId);
		EClass cl = getEClass(epkgUri, name);
		ModelDeltaVMEObject ret = getVMEObject(ide, cl, subId, Arrays.asList(parameters));
		return ret;
	}

	private EClass getEClass(String epkgUri, String name) {
		EPackage pkg = this.manager.getEPackage(epkgUri);
		if (pkg != null) {
			return (EClass)pkg.getEClassifier(name);
		}
		return null;
	}
	
	
	@Override
	public CreatorId getName() {
		return this.cid;
	}



	public EObject getReal(Identifier identificator) {
		return this.realObjects.get(identificator);
	}
	
	private ModelDeltaVMEObject getVMEObject(Identifier ide, EClass cl, String subId, List<?> parameters) {
		return this.existingObjectMap.computeIfAbsent(ide, (id)->{ 
		EClass ecl = cl;
		ModelDeltaVMEObject ret = new ModelDeltaVMEObject(this.manager, this, ide, ecl, parameters);
		this.existingObjectMap.put(ide, ret);
		return ret;
		});
	}
	

	public void knowResource(Resource res) {
		if (res == null || !this.knownResources.add(res)) {
			return;
		}
		res.getAllContents().forEachRemaining(x->{
			if (x != null) {
				x.eCrossReferences().forEach(z->{
					knowResource(z.eResource());
				});
			}
		});
	}
	

	
	

}
