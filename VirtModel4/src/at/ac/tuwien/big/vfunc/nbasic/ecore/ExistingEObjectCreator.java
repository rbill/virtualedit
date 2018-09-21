package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.JavaValue;
import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.virtmod.ecore.VirtualModel;


public class ExistingEObjectCreator implements EObjectCreator {
	
	private Set<Resource> knownResources = new HashSet<>();
	private Map<String, EObject> existingObjects = new HashMap<>();
	private Map<EObject,String> existingObjectsId = new HashMap<>();
	private Map<EObject, DeltaVMEObject> existingObjectMap = new HashMap<>();
	private Map<Identifier, EObject> realObjects = new HashMap<>();
	
	private Map<Resource, Map<String,Integer>> objectCount = new HashMap<>();
	private EObjectManager manager;
	private CreatorId cid;
	
	public ExistingEObjectCreator(EObjectManager manager, CreatorId cid) {
		this.manager = manager;
		this.cid = cid;
	}

	@Override
	public VMEObject createEObject(Identifier ide, Object... parameters) {
		String id = String.valueOf(parameters[0]);
		EObject eobj = this.existingObjects.get(id);
		if (eobj == null) {
			System.err.println("EObject with id "+id+" not found");
		}
		DeltaVMEObject ret = getVMEObject(ide, eobj, Arrays.asList(parameters));
		return ret;
	}
	
	public VMEObject getFakeVirtual(EObject real) {
		String name = getName(real);
		Identifier id = VObjectModelFactory.eINSTANCE.createIdentifier();
		id.setCreatorid(EcoreUtil.copy(getName()));
		JavaValue jv = VObjectModelFactory.eINSTANCE.createJavaValue();
		jv.setValue(name);
		id.getIdentifierreforcmp().add(jv);
		id.init();
		VMEObject ret = getVMEObject(id, real, Arrays.asList(name));
		return ret;
	}
	
	@Override
	public CreatorId getName() {
		return this.cid;
	}

	public String getName(EObject x) {
		return this.existingObjectsId.computeIfAbsent(x, z->{
			//Man kann leider keine Annotations dazuf�gen ...
			String ecn = z.eClass().getName();
			
			String id = x.eResource().getURI().toString()+ecn+"_"+this.objectCount.computeIfAbsent(x.eResource(),a->new HashMap<>()).merge(ecn, 1, (a,b)->a+b);
			this.existingObjects.put(id, z);
			return id;
		});
	}
	


	public EObject getReal(Identifier identificator) {
		return this.realObjects.get(identificator);
	}
	
	private DeltaVMEObject getVMEObject(Identifier ide, EObject eeobj, List<?> parameters) {
		return this.existingObjectMap.computeIfAbsent(eeobj, (eobj)->{ 
		EClass ecl = eobj.eClass();
		DeltaVMEObject ret = new DeltaVMEObject(this.manager, this, ide, ecl, parameters);
		ecl.getEAllStructuralFeatures().forEach(esf->{
			ret.addBasicSingletonFeature(esf, eobj, esf);
		});
		this.realObjects.put(ide, eobj);
		return ret;
		});
	}
	

	public void knowResource(Resource res) {
		if (res == null || !this.knownResources.add(res)) {
			return;
		}
		res.getAllContents().forEachRemaining(x->{
			if (x != null) {
				getName(x);
				x.eCrossReferences().forEach(z->{
					knowResource(z.eResource());
				});
			}
		});
	}
	
	public void putReal(EObject y, VMEObject x) {
		this.realObjects.put(x.getIdentificator(), y);
		if (x instanceof DeltaVMEObject) {
			this.existingObjectMap.put(y, (DeltaVMEObject)x);
			String id = String.valueOf(x.getIdentificator().getIdentifierreforcmp().get(0));
			this.existingObjectsId.put(y, id);
			this.existingObjects.put(id, y);
		} else {
			System.err.println("Wrong object type "+x);
		}
	}

	
	

}
