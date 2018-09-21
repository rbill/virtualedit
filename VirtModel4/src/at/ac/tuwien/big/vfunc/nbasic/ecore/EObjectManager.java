package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.values.TupleValue;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import VObjectModel.AnyValue;
import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.IdentifierCmp;
import VObjectModel.IdentifierRef;
import VObjectModel.IdentifierRefOrCmp;
import VObjectModel.JavaValue;
import VObjectModel.StoredFuncs;
import VObjectModel.VObjDeltaModel;
import VObjectModel.VObjectModelFactory;
import VObjectModel.VObjectModelPackage;
import at.ac.tuwien.big.vfunc.nbasic.DeltaVMEObjectStore;
import at.ac.tuwien.big.vfunc.nbasic.ecore.BasicCache.CacheType;
import at.ac.tuwien.big.vfunc.nbasic.ocl.OclEvaluationList;
import at.ac.tuwien.big.virtlang.VirtLangStandaloneSetup;
import at.ac.tuwien.big.virtlang.virtLang.ClassRef;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.virtlang.virtLang.UseModel;
import at.ac.tuwien.big.virtmod.ecore.VirtualModel;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.impl.MyEcoreUtilInstanceCreator;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;
import school.Grade;
import school.SchoolPackage;
 
public class EObjectManager {
	 
	//Creator --> Identifier --> EObject
	
	
	private static VObjectModelFactory vfact = VObjectModelFactory.eINSTANCE;
	public static Resource getVirtLangResource(File ecsslFile) throws IOException {
		Injector injector = new VirtLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		Resource ecsslResource = rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
		return ecsslResource; 
	}


	
	public static void main(String[] args) throws IOException {
		//EObjectManager mana
		EObjectManager manager = new EObjectManager();
		File file = new File("C:\\Users\\Robert\\Documents\\eclipse-modeling-neon-2-win32-x86_64\\eclipse\\workspacePatrickMaven\\at.ac.tuwien.big.virtlang.examples.school\\model\\School.xmi");
		if (!file.exists()) {
			file =  new File("E:\\patrick\\virtualedit\\at.ac.tuwien.big.virtlang.examples.school\\model\\School.xmi");
		}
		Resource r = ConvertToXmi.getXmiResource(file);
		manager.knowResource(r);
		EPackage.Registry.INSTANCE.put(VObjectModelPackage.eINSTANCE.getNsURI(), VObjectModelPackage.eINSTANCE);
		Resource delta = ConvertToXmi.getOrCreateXmiResource(new File("delta.xmi"));
		List<VObjDeltaModel> deltaModel = new ArrayList<>();
		if (!delta.getContents().isEmpty()) {
			delta.getAllContents().forEachRemaining(x->{
				if (x instanceof VObjDeltaModel) {
					VObjDeltaModel vo = (VObjDeltaModel)x;
					deltaModel.add(vo);
					manager.loadDelta(vo);
				}
			});
		}
		List<VMEObject> allObjs = new ArrayList<>();
		r.getAllContents().forEachRemaining(x->{
			allObjs.add(manager.getFakeVirtual(x));
		});
		for (VMEObject eobj: allObjs) {
			System.out.println("Read object: "+eobj+"\n\tcontained in "+eobj.eContainer()+"\n");
			EClass ecl = eobj.eClass();
			if (ecl.getName().equals("Grade")) {
				//((SingleVMEObject)eobj).setEClass(SchoolPackage.eINSTANCE.getGrade2());	
				EStructuralFeature year = ecl.getEStructuralFeature("year");
				eobj.eSet(year, ((BigInteger)eobj.eGet(year)).add(BigInteger.TEN));
				System.out.println("Modified object: "+eobj);
			}
		}
		r.getAllContents().forEachRemaining(x->{
			if (x.eClass().getName().equals("Grade")) {
				System.out.println("Grade year: "+x.eGet(x.eClass().getEStructuralFeature("year")));
			}
		});
		VObjDeltaModel model;
		if (deltaModel.isEmpty()) {
			model = VObjectModelFactory.eINSTANCE.createVObjDeltaModel();
			delta.getContents().add(model);
		} else {
			model = deltaModel.get(0);
		}
		manager.storeDelta(model);
		delta.save(Collections.emptyMap());
	}
	
	private ResourceSet rs = new ResourceSetImpl();
	
	private ExistingEObjectCreator eobjReader;
	//private ExistingSingleEObjectCreator eobjReader;
	
	{
		CreatorId creatorid = VObjectModelFactory.eINSTANCE.createCreatorId();
		creatorid.setName("eobj");
		this.eobjReader = new ExistingEObjectCreator(this, creatorid);
		//this.eobjReader = new ExistingSingleEObjectCreator(this, creatorid);
	}

	//Namespace --> name --> thing
	private Map<String, Map<String, EObjectCreator>> eobjectCreators = new HashMap<>();
	
	{
		addCreator(this.eobjReader);
	}
	
	private BasicCache<Identifier, VMEObject> createdObjects = new BasicCache<>(Identifier.class,
			CacheType.FIX,
			new Function<Identifier, VMEObject>() {

				@Override
				public VMEObject apply(Identifier t) {
					CreatorId creatorid = t.getCreatorid();
					//Get creator
					EObjectCreator creator = EObjectManager.this.eobjectCreators.computeIfAbsent(creatorid.getNamespace(), x->new HashMap<>()).get(creatorid.getName());
					if (creator == null) {
						System.err.println("Creator "+creatorid.getNamespace()+"::"+creatorid.getName()+" not found!");
						return null;
					}
					//First create all sub-things
					Object[] subVals = new Object[t.getIdentifierreforcmp().size()];
					{
						int idx = 0;
						for (AnyValue val: t.getIdentifierreforcmp()) {
							subVals[idx] = convert(val);
							++idx;
						}
					}
					VMEObject ret = creator.createEObject(t, subVals);
					return ret;
				}
			}
			);
	private Map<Identifier, DeltaVMEObjectStore> storeMap = new HashMap<>();
	private Map<UseModel, EPackage> knownModels = new HashMap<>();
	
	private void addCreator(EObjectCreator creator) {
		this.eobjectCreators.computeIfAbsent(creator.getName().getNamespace(), x->new HashMap<>()).
			put(creator.getName().getName(), creator);
		//Double-put
		this.eobjectCreators.computeIfAbsent(null, x->new HashMap<>()).
			put(creator.getName().getName(), creator);
	}
	
	/*
	public VMEObject getOrCreate(EObjectCreator creator, Object... params) {
		return createdObjects.computeIfAbsent(creator, x->new HashMap<>()).computeIfAbsent(params, cr->creator.createEObject(params));
	}
	
	public VMEObject getOrCreate(String creatorName, Object... params) {
		EObjectCreator creator = eobjectCreators.get(creatorName);
		if (creator == null) {
			throw new UnsupportedOperationException("Could not find creator " + creator);
		}
		return getOrCreate(creator, params);
	}*/
	
	public void addCreator(String namespace, String name, EObjectCreator creator) {
		this.eobjectCreators.computeIfAbsent(namespace, x->new HashMap<>()).put(name, creator);
	}
	
	public Object convert(AnyValue val) {
		if (val == null) {
			return null;
		}
		if (val instanceof IdentifierRefOrCmp) {
			Identifier id = null;
			if (val instanceof IdentifierRef) {
				id = ((IdentifierRef)val).getS_identifier();
			} else if (val instanceof IdentifierCmp) {
				id = ((IdentifierCmp)val).getS_identifier();
			}
			if (id != null) {
				return getObject(id);
			}
		} else if (val instanceof JavaValue) {
			return ((JavaValue)val).getValue();
		}
		throw new UnsupportedOperationException("Cannot convert "+val+"!");
	}
	
	
	//private Map<EObjectCreator, Map<Object[], VMEObject>> createdObjects = new HashMap<>();
	
	private <T> void getAllReferenced(EObject start, Set<T> functions, Class<T> type) {
		start.eAllContents().forEachRemaining(x->{
			for (EObject eobj: x.eCrossReferences()) {
				if (type.isInstance(eobj)) {
					functions.add((T)eobj);
				}
			}
		});
	}
	
	
	/**Only for my things, is specific*/
	
	

	public DeltaVMEObjectStore getDeltaStore(Identifier id) {
		return this.storeMap.computeIfAbsent(id, x->new DeltaVMEObjectStore());
	}
	
	public EClass getEClass(ClassRef cr) {
		String cn = cr.getClassname();
		UseModel n = cr.getNs();
		return getEClass(n, cn);
	}
	
	public EClass getEClass(UseModel model, String name) {
		EPackage epkg = this.knownModels.get(model);
		if (epkg == null) {
			System.err.println("Class "+name+" in "+model.getUrl()+" not found because no package!");
		}
		EClassifier ecl = epkg.getEClassifier(name);
		if (!(ecl instanceof EClass))  {
			System.err.println("Not an eclass: "+ecl);
			return null;
		}
		return (EClass)ecl;
	
	}
	
	public VMEObject getFakeVirtual(EObject x) {
		VMEObject ret = this.eobjReader.getFakeVirtual(x);
		this.createdObjects.put(ret.getIdentificator(), ret);
		return ret;
	}
	
	public Identifier getIdentifier(String name, CreatorId cid, List<Object> values, OclEvaluationList oel) {
		Identifier ret = vfact.createIdentifier();
		ret.setName(name);
		ret.setCreatorid(EcoreUtil.copy(cid));
		for (Object val: values) {
			AnyValue av = getIdentifierRef(val,oel);
			ret.getIdentifierreforcmp().add(av);
		}
		ret.init();
		return ret;
	}
	
	public Identifier getIdentifier(TupleValue val, OclEvaluationList oel) {
		return ((IdentifierCmp)getIdentifierRef(val, oel)).getS_identifier();
	}
	
	public AnyValue getIdentifierRef(Object start, OclEvaluationList oel) {
		if (start instanceof AnyValue) {
			return (AnyValue)start;
		} else if (start instanceof Identifier) {
			IdentifierRef rret = vfact.createIdentifierRef();
			rret.setS_identifier((Identifier)start);
			return rret;
		} else if (start instanceof VMEObject) {
			//It's ok
			Identifier ret = ((VMEObject)start).getIdentificator();
			IdentifierRef rret = vfact.createIdentifierRef();
			rret.setS_identifier(ret);
			return rret;
		} else if (start instanceof EObject) { //Not vmeobject
			//wrap into VMEobject
			VMEObject converted = getFakeVirtual((EObject)start);
			Identifier ret = converted.getIdentificator();
			IdentifierRef rret = vfact.createIdentifierRef();
			rret.setS_identifier(ret);
			return rret;
		} else if (start instanceof TupleValue) {
			//Tuple, can be something where objects should be created
			TupleValue tv = (TupleValue)start;
			TupleTypeId tti = tv.getTypeId();
			String name = null;
			String namespace = null;
			String ref = null;
			List<Object> values = new ArrayList<>();
			for (TuplePartId tpi: tti.getPartIds()) {
				if ("name".equals(tpi.getName())) {
					name = String.valueOf(tv.getValue(tpi));
				} else if ("namespace".equals(tpi.getName())) {
					namespace = String.valueOf(tv.getValue(tpi));
				} else if ("ref".equals(tpi.getName())) {
					ref = String.valueOf(tv.getValue(tpi));
				} else {
					values.add(tv.getValue(tpi));
				}
			}
			CreatorId cid = null;
			if (name != null) {
				cid = VObjectModelFactory.eINSTANCE.createCreatorId();
				cid.setName(name);
				cid.setNamespace(namespace);
				if (namespace == null) {
					//Maybe choose own
					EObjectCreator cr = getBestCreatorOrNull(namespace, name, oel.getNamespace());
					
					if (cr != null) {
						cid.setNamespace(cr.getName().getNamespace());
					}
				}
			}
			//TODO: Hier muss ich jetzt das korrekte Objekt zusammenbasteln
			//Aber mit hilfe der Identifier, denke ich
			Identifier id = getIdentifier(ref, cid, values, oel);
			IdentifierCmp rret = vfact.createIdentifierCmp();
			rret.setS_identifier(id);
			return rret;
		} else {
			JavaValue jv = vfact.createJavaValue();
			jv.setValue(start);
			return jv;
		}
	}
	
	public EObject getInvVirtual(VMEObject virtObj) {
		return getInvVirtual(virtObj, new HashMap<>());
	}
	
	public EObject getInvVirtual(VMEObject virtObj, Map<EObject, EObject> addMap) {
		EObject ret = this.eobjReader.getReal(virtObj.getIdentificator());
		if (ret == null) {
			//Create new 
			Map<EObject, EObject> map = addMap;
			ret = MyEcoreUtil.nearCopy(virtObj, (retr)->{
				EObject rret = map.get(retr);
				if (rret == null) {
					if (retr instanceof VMEObject) {
						rret = getInvVirtual((VMEObject)retr);
					}
				}
				return rret;
			}, (x,y)->{
				if (x instanceof VMEObject && !(y instanceof VMEObject))  {
					this.eobjReader.putReal(y, (VMEObject)x);
				}
				map.put(x,y);
			});
		}
		return ret;	
	}
	

	public<T extends EObject> Set<T> getNoncomposite(EObject start, Class<T> type) {
		Set<T> ret = new HashSet<>();
		getAllReferenced(start, ret, type);
		Set<T> included = new HashSet<>();
		start.eAllContents().forEachRemaining(x->{
			if (type.isInstance(x)) {
				included.add((T)x);
			}
		});
		for (T func: ret) {
			func.eAllContents().forEachRemaining(x->{
				if (type.isInstance(x)) {
					included.add((T)x);
				}
			});
		}
		ret.removeAll(included);
		return ret;
	}

	public VMEObject getObject(Identifier id) {
		return this.createdObjects.get(id);
	}

	public String getObjName(EObject obj) {
		return this.eobjReader.getName(obj);
	}

	public void knowResource(Resource r) {
		this.eobjReader.knowResource(r);
	}
		
	public void knowResource(UseModel mod) {
		String uri = mod.getUrl();
		String name = mod.getName();
		Resource resource = this.rs.getResource(URI.createURI(uri), true);
		for (EObject eobj: resource.getContents()) {
			System.out.println("Know "+eobj);
			if (eobj instanceof EPackage) {
				this.knownModels.put(mod, (EPackage)eobj);
			}
		}
	}
	
	public void knowVirtualDefinition(at.ac.tuwien.big.virtlang.virtLang.VirtualModel model) {
		for (UseModel um: model.getUseModels()) {
			knowResource(um);
		}
		for (ObjectCreator oc: model.getObjectCreators()) {
			ObjectCreatorCreator occ = new ObjectCreatorCreator(this, oc);
			addCreator(occ);
		}
	}
	
	public void loadDelta(VObjDeltaModel model) {
		for (StoredFuncs sf: model.getStoredfuncs()) {
			Identifier id = sf.getIdentifier();
			DeltaVMEObjectStore store = getDeltaStore(id);
			store.loadFrom(sf);
		}
	}

	public void storeDelta(VObjDeltaModel model) {
		List<StoredFuncs> sf = model.getStoredfuncs();
		Map<Identifier,StoredFuncs> existingFuncs = new HashMap<>();
		for (StoredFuncs s: sf) {
			existingFuncs.put(s.getIdentifier(), s);
		}
		List<StoredFuncs> addFuncs = new ArrayList<>();
		this.storeMap.forEach((id,store)->{
			StoredFuncs curStore = existingFuncs.get(id);
			if (curStore == null){
				StoredFuncs add  = VObjectModelFactory.eINSTANCE.createStoredFuncs();
				add.setIdentifier(id);
				addFuncs.add(add);
				curStore = add;
			}
			store.augmentStoredFuncs(curStore);
		});
		model.getStoredfuncs().addAll(addFuncs);
		Set<VObjectModel.Function> functions = getNoncomposite(model, VObjectModel.Function.class);
		model.getFunctions().addAll(functions);
		Set<Identifier> identifiers = getNoncomposite(model, Identifier.class);
		model.getIdentifiers().addAll(identifiers);
		
	}


	public EObjectCreator getBestCreatorOrNull(String namespace, String name) {
		return getBestCreatorOrNull(namespace, name, null);
	}
			

	public EObjectCreator getBestCreatorOrNull(String namespace, String name, String altNamespace) {
		//Maybe choose own
		Map<String, EObjectCreator> map = this.eobjectCreators.getOrDefault(namespace, Collections.emptyMap());
		EObjectCreator cr = map.get(name);
		if (cr == null) {
			String newNamespace = altNamespace;
			map = this.eobjectCreators.getOrDefault(newNamespace, Collections.emptyMap());
			cr = map.get(name);
			if (cr != null) {
				return cr;
			}
		}
		return cr;
	}

}
