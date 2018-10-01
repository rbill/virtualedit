package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.ids.TuplePartId;
import org.eclipse.ocl.pivot.ids.TupleTypeId;
import org.eclipse.ocl.pivot.values.TupleValue;

import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectCreator;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.ExistingEObjectCreator;
import at.ac.tuwien.big.vfunc.nbasic.ecore.IdentifierInfo;
import at.ac.tuwien.big.vfunc.nbasic.ecore.ObjectCreatorCreator;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VirtualResource;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.xmlintelledit.util.Spawnable;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;


public class CEobjectManager implements Spawnable<CEobjectManager>{
	
	public static void main(String[] args) {
		MyResource res = MyResource.get(new ResourceImpl());
		System.out.println(res);
	}
	private Resource fakeResource = new ResourceImpl(URI.createURI("fake://myResource/"+Math.random()));
	
	{
	}
	
	private Map<ObjectCreator,  Map<List<?>, SampleEObject>> existingObjects = new HashMap<>();
	
	private EObjectManager emanager;
	private ObjectCreatorGenerator ocg;
	private ClassGenerationManager cgm;
	
	private MyResource myFakeResource;
	
	private static Map<EClass, Supplier<? extends EObject>> eclassGenerator = new HashMap<>();
	
	public static void addSupplier(EClass cl, Supplier<? extends EObject> supplier) {
		eclassGenerator.put(cl, supplier);
	}
	
	private static Resource fakeEClassResource = new ResourceImpl();
	
	private static EPackage fakePackage = EcoreFactory.eINSTANCE.createEPackage();
	
	
	private static EFactoryImpl fakeFactory = new EFactoryImpl() {
		
		
		@Override
		public EObject create(EClass eClass) {
			Supplier<? extends EObject> supplier = CEobjectManager.eclassGenerator.get(eClass);
			if (supplier != null) {
				return supplier.get();
			}
			System.err.println("Unknown eClass: "+eClass.getName());
			return null;
		}
	};
	static {
		fakePackage.setEFactoryInstance(fakeFactory);
		fakeEClassResource.getContents().add(fakePackage);
	}
	
	public static EPackage getFakePackage() {
		return fakePackage;
	}
		
	
	public CEobjectManager spawnNew() {
		CEobjectManager ret = new CEobjectManager(this);
		return ret;
	}
	
	private CEobjectManager(CEobjectManager halfCopy) {
		this.emanager = halfCopy.emanager;
		this.cgm = halfCopy.cgm;
		this.ocg = halfCopy.ocg;
		//TODO: Die Fake-Resourcen auch kopieren oder nicht?
	}
	
	public CEobjectManager(EObjectManager emanager) {
		this.emanager = emanager;
		this.cgm = new ClassGenerationManager();
		emanager.getEPackages().forEach(x->this.cgm.knowPackage(x));
		this.ocg = new ObjectCreatorGenerator(this, this.cgm);
	}
	
	public Object convertOclTuple(Object obj) {
		if (obj instanceof SampleEObject) {
			return obj;
		}
		if (obj instanceof TupleValue) {
			TupleValue tv = (TupleValue)obj;
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
			
			if (name != null) {
				EObjectCreator creator = this.emanager.getBestCreatorOrNull(namespace,name);
				if (creator != null ) { 
					if (creator instanceof ObjectCreatorCreator) {
						SampleEObject ret = getOrCreateBasic(((ObjectCreatorCreator)creator).getCreator(), values);
						return ret;
					} else {
						System.err.println("What?!");
						//TODO: Es könnte ein verlangen sein, ein fake-eobject zu erzeugen, aber warum?
						return obj;
					}
				}
			}
			//Can't change it 
			return obj;
		} else {
			return obj;
		}
	}
	
	public List convertOclTupleList(Object obj) {
		List ret = new ArrayList<>();
		if (obj instanceof Iterable) {
			for (Object o: (Iterable)obj) {
				ret.add(convertOclTuple(o));
			}
		} else {
			if (obj != null) {
				ret.add(convertOclTuple(obj));
			}
		}
		return ret;
	}
	public SampleEObject generateBasic(EClass ecl) {
		Class<? extends SampleEObject> cl = getCompiledClass(ecl);
		SampleEObject ret = null;
		try {
			ret = cl.newInstance();
			ret.initMyResource(this.myFakeResource, this);
			if (this.myFakeResource != null) {
				this.myFakeResource.objectAdded(ret);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	private Class<? extends SampleEObject> getCompiledClass(EClass cl) {
		return this.ocg.getOrCreate(cl);
	}
	
	private Class<? extends SampleEObject> getCompiledClass(ObjectCreator creator) {
		return this.ocg.getOrCreate(creator);
	}
	
	
	public List<EObject> getContents() {
		return this.fakeResource.getContents();
	}
	
	public EObjectManager getEObjectManager() {
		return this.emanager;
	}
	 
	 
	public SampleEObject getOrCreateBasic(ObjectCreator creator, List<?> parameters) {
		return this.existingObjects.computeIfAbsent(creator, x->new HashMap<>()).computeIfAbsent(parameters, x->{
			SampleEObject ret = null;
			Class<? extends SampleEObject> cl = getCompiledClass(creator);
			try {
				ret = cl.newInstance();
				ret.initParameters(parameters);
				//so.initIdentifier(id);
				ret.initMyResource(this.myFakeResource, this);
				if (this.myFakeResource != null) {
					this.myFakeResource.objectAdded(ret);
				}
				return ret;
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		});
	}

	private Map<EObject,EObject> globalMap = new HashMap<>();
	
	public EObject getOrCreateFull(EObject existing) {
		Function<EObject, EObject> retriever = (y)->{
			return globalMap.computeIfAbsent(y, z->{
			if (z instanceof VMEObject) {
				VMEObject vm = (VMEObject)z;
				Identifier id = vm.getIdentificator();
				IdentifierInfo identifierInfo = vm.getIdentifierInfo();
				List<?> objPars = identifierInfo.getParameters();
				EObjectCreator cr = identifierInfo.getCreator();
				if (cr instanceof ObjectCreatorCreator) {
					ObjectCreatorCreator occ = (ObjectCreatorCreator)cr;
					ObjectCreator oc = occ.getCreator();
					SampleEObject ret = getOrNull(oc, objPars);
					if (ret != null && ret.wasInitialized()) {
						return ret;
					}
					return null;
				} 
			}
			return null;});
		};
		BiConsumer<EObject, EObject> setter = (a,b)->{
			globalMap.put(a,b);
		};
		Function<EObject, EObject> newInstanceProvider = (old)->{
			if (old instanceof VMEObject) {
				VMEObject vm = (VMEObject)old;
				Identifier id = vm.getIdentificator();
				IdentifierInfo identifierInfo = vm.getIdentifierInfo();
				List<?> oldObjPars = identifierInfo.getParameters();
				List<Object> objPars = new ArrayList<>();
				for (Object o: oldObjPars) {
					if (o instanceof EObject) {
						objPars.add(getOrCreateFull((EObject)o));
					} else {
						objPars.add(o);
					}
				}
				EObjectCreator cr = identifierInfo.getCreator();
				if (cr instanceof ExistingEObjectCreator) {
					/*ExistingEObjectCreator eec = (ExistingEObjectCreator)cr;
					//Here I will probably copy them normally
					return MyEcoreUtil.newInstance(vm);*/
					//Nope
					ExistingEObjectCreator eoc = (ExistingEObjectCreator)cr;
					//TODO: Problem if multiple eobjects of multiple classes exist ...
					return generateBasic(vm.eClass()); 
				} else if (cr instanceof ObjectCreatorCreator) {
					ObjectCreatorCreator occ = (ObjectCreatorCreator)cr;
					ObjectCreator oc = occ.getCreator();
					Class<? extends SampleEObject> scl = getCompiledClass(oc);
					SampleEObject subret = getOrCreateBasic(oc, objPars);
					subret.makeInitialized();
					return subret;
				}  else {
					System.err.println("Unknown creator: "+cr+"!");
					return MyEcoreUtil.newInstance(vm);
				}
			} else {
				System.err.println("Why is this called with normal EObjects?");
				return MyEcoreUtil.newInstance(old);
			}
		};
		EObject eret = MyEcoreUtil.nearCopy(existing, retriever, setter, newInstanceProvider);
		if (eret instanceof SampleEObject) {
			SampleEObject seo = (SampleEObject)eret;
			seo.initDerived();
		}
		
		return eret;
	}
	
	public SampleEObject getOrNull(ObjectCreator creator, List<?> parameters) {
		return this.existingObjects.getOrDefault(creator, Collections.emptyMap()).get(parameters);
	}

	public void initWith(VirtualResource vr) {
		
		//Add to fakeResource
		List<VMEObject> allObjs = vr.getAllObjects();
		Set<VMEObject> noncontained = new HashSet<>(allObjs);
		Set<EObject> contained = new HashSet<>();
		for (VMEObject vmeo: noncontained) {
			contained.addAll(vmeo.eContents());
		}
		allObjs.removeAll(contained);
		for (VMEObject existing: allObjs) {
			this.fakeResource.getContents().add(getOrCreateFull(existing));
		}
		this.myFakeResource = MyResource.get(this.fakeResource);
	}

/*
	public void addContents(Collection<EObject> contents) {
		for (EObject eobj: contents) {
			
			EObject basic = emanager.getFakeVirtual(eobj);
			this.fakeResource.getContents().add(getOrCreateFull(basic));
		}
	}*/
}
