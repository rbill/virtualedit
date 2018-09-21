package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
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
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;


public class CEobjectManager {
	
	private Resource fakeResource = new ResourceImpl(URI.createURI("fake://myResource/"+Math.random()));
	{
	}
	
	private Map<ObjectCreator,  Map<List<?>, SampleEObject>> existingObjects = new HashMap<>();
	
	private Class<? extends SampleEObject> getClass(ObjectCreator creator) {
		
		//TODO: Implement me
		return null;
	}
	
	private EObjectManager emanager;
	
	
	public Object convertOclTuple(Object obj) {
		if (obj instanceof SampleEObject) {
			return (SampleEObject)obj;
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
				EObjectCreator creator = emanager.getBestCreatorOrNull(namespace,name);
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
	
	public SampleEObject getOrNull(ObjectCreator creator, List<?> parameters) {
		return existingObjects.getOrDefault(creator, Collections.emptyMap()).get(parameters);
	}
	
	public SampleEObject getOrCreateBasic(ObjectCreator creator, List<?> parameters) {
		return existingObjects.computeIfAbsent(creator, x->new HashMap<>()).computeIfAbsent(parameters, x->{
			SampleEObject ret = null;
			Class<? extends SampleEObject> cl = getClass(creator);
			try {
				ret = cl.newInstance();
				ret.initParameters(parameters);
				//so.initIdentifier(id);
				ret.initMyResource(myFakeResource);
				if (myFakeResource != null) {
					myFakeResource.objectAdded(ret);
				}
				return ret;
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		});
	}
	public EObject getOrCreateFull(EObject existing) {
		Map<EObject,EObject> map = new HashMap<>();
		Function<EObject, EObject> retriever = (y)->{
			return map.computeIfAbsent(y, z->{
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
			map.put(a,b);
		};
		Function<EObject, EObject> newInstanceProvider = (old)->{
			if (old instanceof VMEObject) {
				VMEObject vm = (VMEObject)old;
				Identifier id = vm.getIdentificator();
				IdentifierInfo identifierInfo = vm.getIdentifierInfo();
				List<?> objPars = identifierInfo.getParameters();
				EObjectCreator cr = identifierInfo.getCreator();
				if (cr instanceof ExistingEObjectCreator) {
					ExistingEObjectCreator eec = (ExistingEObjectCreator)cr;
					//Here I will probably copy them normally
					return MyEcoreUtil.newInstance(vm);
				} else if (cr instanceof ObjectCreatorCreator) {
					ObjectCreatorCreator occ = (ObjectCreatorCreator)cr;
					ObjectCreator oc = occ.getCreator();
					Class<? extends SampleEObject> scl = getClass(oc);
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
	
	public CEobjectManager(EObjectManager emanager) {
		this.emanager = emanager;
	}
	
	private MyResource myFakeResource;
	 
	 
	public void initWith(VirtualResource vr) {
		
		//Add to fakeResource
		List<VMEObject> allObjs = vr.getAllObjects();
		Set<VMEObject> noncontained = new HashSet<>(allObjs);
		Set<EObject> contained = new HashSet<>();
		for (VMEObject vmeo: noncontained) {
			contained.addAll(vmeo.eContents());
		}
		allObjs.removeAll(contained);
		fakeResource.getContents().addAll(allObjs);
		myFakeResource = MyResource.get(fakeResource);
	}

	public static void main(String[] args) {
		MyResource res = MyResource.get(new ResourceImpl());
		System.out.println(res);
	}
}
