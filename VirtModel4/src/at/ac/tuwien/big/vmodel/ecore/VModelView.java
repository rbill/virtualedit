package at.ac.tuwien.big.vmodel.ecore;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.UUID;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.autoedit.ecore.util.MyResource;
import at.ac.tuwien.big.autoedit.test.OclExtractor;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.ecore.impl.FakeEListImpl;
import at.ac.tuwien.big.virtmod.ecore.impl.VirtualModelImpl;
import at.ac.tuwien.big.virtmod.structure.DeltaManager;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.impl.SimpleDeltaManager;
import at.ac.tuwien.big.virtmod.structure.impl.VDeltaContainer;
import at.ac.tuwien.big.virtmod.structure.impl.VSimpleContainer;
import at.ac.tuwien.big.vmodel.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmodel.ecore.impl.VEObjectImpl;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.xtext.annotation.SourcedEObject;
import at.ac.tuwien.big.xtext.equalizer.Creater;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public interface VModelView {
	
	public VFeatureValues getFeatureValues(String classname, String featureName);
	
	public default VFeatureValues getFeatureValues(EStructuralFeature feat) {
		return getFeatureValues(feat.getEContainingClass().getName(), feat.getName());
	}
	
	
	public default void initModelForEdit() {
		getInstances();
		for (EStructuralFeature feat: getEcore().getAllFeatures()) {
			getFeatureValues(feat);
		}
	}
	
	public VObjectValues getInstances();
	
	public VEcoreFile getEcore();
	
	public SourcedEObject getEObject(String uuid);
	
	//Assume that functions are static
	//If things have changd, you have to reload
	public void reload();

	public default EObject getContainingObject(String uuid) {
		String ret = getContainingObjectUuid(uuid);
		if (ret != null) {
			return getEObject(ret);
		}
		return null;
	}
	
	public String getContainingObjectUuid(String uuid);

	public EReference getContainingFeature(String uuid);

	public default List<EObject> wrapObjects(List<String> base) {
		return new ConvertingListImpl<EObject,String>(base,
				(x)->{if (x instanceof VEObject) {
						return ((VEObject) x).getUUID();
					  } else {
						throw new RuntimeException("Adding real EObjects to Virtual Resource not yet implemented");
					  }
				},(x)->getEObject(x));
	}
	

	public default void printModel(StringBuilder toString) {
		Map<String,String> eobjNames = new HashMap<>();
		Map<String,Integer> curNames = new HashMap<>();
		for (String uuid: getInstances()) {
			String cl = getInstances().getClass(uuid);
			Integer curInd = curNames.getOrDefault(cl, 1);
			eobjNames.put(uuid, cl+curInd);
			curNames.put(cl, curInd+1);
		}
		Set<String> haveInstances = new HashSet<>();
		
		Map<String,VEObject> eobj = new HashMap<>();
		for (String uuid: getInstances()) {
			eobj.put(uuid, (VEObject)getEObject(uuid));
		}
		List<VEObject> containerless = new ArrayList<>();
		for (VEObject so: eobj.values()) {
			if (so.eContainer() == null) {
				containerless.add(so);
			}
		}
		
		List<String> sorted = new ArrayList<String>();
		Set<String> sortedSet = new HashSet<String>();
		Stack<String> next = new Stack<>();
		for (VEObject str: containerless) {
			next.add(str.getUUID());
		}
		while (!next.isEmpty()) {
			String uuid = next.pop();
			sorted.add(uuid);
			VEObject veobj = (VEObject) getEObject(uuid);
			String clString = getInstances().getClass(uuid);
			EClass cl = getEcore().getClass(clString);
			if (cl == null) {
				System.err.println("Null "+uuid);
				continue;
			}
			for (EReference esf: cl.getEAllReferences()) {
				if (!esf.isContainment()) {
					continue;
				}
				List<String> strings = new ArrayList<>((List<String>)(List)getFeatureValues(esf).getValueList(uuid));
				Collections.reverse(strings);
				for (String s: strings) {
					if (sortedSet.add(s)) {
						next.add(s);
					}
				}
			}
		}
		
		
		for (String uuid: sorted) {
			String clString = getInstances().getClass(uuid);
			EClass cl = getEcore().getClass(clString);
			toString.append("Object "+eobjNames.get(uuid)+ " [uuid: "+uuid+"]:\n");
			if (cl == null) {
				continue;
			}
			for (EAttribute esf: cl.getEAllAttributes()) {
				toString.append(esf.getName()+": " +Arrays.toString(getFeatureValues(esf).getValueList(uuid).toArray())+"\n");
			}
			for (EReference esf: cl.getEAllReferences()) {
				List<String> strings = (List<String>)(List)getFeatureValues(esf).getValueList(uuid);
				List<Object> objects = new ArrayList<Object>();
				for (String str: strings) {
					objects.add(eobjNames.get(str));
				}
				toString.append(esf.getName()+": " +Arrays.toString(objects.toArray())+"\n");
			}
		}
	}
	
	public default String printModel() {
		StringBuilder ret = new StringBuilder();
		printModel(ret);
		return ret.toString();
	}
	
	public default List<EObject> exposeContents() {
		initModelForEdit();
		//Now everything should be added, time to figure our what to add as root: Everything without container
		Map<String,EObject> eobj = new HashMap<String, EObject>();
		for (String uuid: getInstances()) {
			eobj.put(uuid, getEObject(uuid));
		}
		List<EObject> containerless = new ArrayList<EObject>();
		for (EObject so: eobj.values()) {
			if (so.eContainer() == null) {
				containerless.add(so);
			}
		}
		return containerless;
	}
	
	public default List<EObject> saveContents(Creater<EObject, EClass> creater) {

		//Create "real" objects
		Map<String,EObject> eobj = new HashMap<String, EObject>();
		for (String uuid: getInstances()) {
			String cl = getInstances().getClass(uuid);
			System.out.println(uuid+" has class "+cl);
			eobj.put(uuid, creater.create(getEcore().getClass(cl)));
		}
		for (Entry<String,EObject> entry: eobj.entrySet()) {
			EClass cl = entry.getValue().eClass();
			String uuid = entry.getKey();
			for (EAttribute attr: cl.getEAllAttributes()) {
				List<Object> curValues = getFeatureValues(attr).getValueList(uuid);
				if (attr.isMany()) {
					entry.getValue().eSet(attr, new ArrayList<>(curValues));
				} else {
					if (!curValues.isEmpty()) {
						entry.getValue().eSet(attr, curValues.iterator().next());
					}
				}
			}
			for (EReference ref: cl.getEAllReferences()) {
				List<Object> curValues = getFeatureValues(ref).getValueList(uuid);
				if (ref.isMany()) {
					List<EObject> targets = new ArrayList<EObject>();
					for (Object o: curValues) {
						EObject target = eobj.get(o);
						if (target == null) {
							System.err.println("Null target from "+o);
						} else {
							targets.add(eobj.get(o));
						}
					}
					EList<EObject> savedValues = FakeEListImpl.ensureEList((List<EObject>)entry.getValue().eGet(ref));
					if (savedValues.size() < targets.size()) {
						//Just redo
						try {
						savedValues.clear();
						savedValues.addAll(targets);
						} catch (Exception e) {
							System.err.println("Exception occurred when trying to assign "+ref.getEContainingClass().getName()+"."+ref.getName()+": "+Arrays.toString(targets.toArray())+": "+e.getMessage());
							
							throw e;
						}
					} else {
						//Reorder
						for (int i = 0; i < targets.size(); ++i) {
							boolean complete = false;
							for (int j = i; j < targets.size(); ++j) {
								if (Objects.equals(targets.get(i), savedValues.get(j))) {
									if (i != j) {
										savedValues.move(i, j);
									}
									complete = true;
									break;
								}
							}
							if (!complete) {
								savedValues.add(i, targets.get(i));
							}
						}
						while (savedValues.size() > targets.size()) {
							savedValues.remove(savedValues.size()-1);
						}
					}
				} else {
					if (!curValues.isEmpty()) {
						Object curV = curValues.iterator().next();
						Object trg = eobj.get(curV);
						entry.getValue().eSet(ref, trg);
						System.out.println("Set "+ref.getEContainingClass().getName()+"."+ref.getName()+" = "+trg + " (from "+curV+") for "+entry.getValue());
					} else {
						System.out.println("Set "+ref.getEContainingClass().getName()+"."+ref.getName()+" to null for "+entry.getValue());
					}
				}
			}
		}
		//Now everything should be added, time to figure our what to add as root: Everything without container
		List<EObject> containerless = new ArrayList<EObject>();
		for (EObject so: eobj.values()) {
			if (so.eContainer() == null) {
				containerless.add(so);
			}
		}
		return containerless;
	}
	
	public default void saveResource(Resource xmiResource) {
		MyResource res = MyResource.get(xmiResource);
		xmiResource.getContents().addAll(saveContents((x)->res.createInstance(x)));
	}
	
	public default void loadResource(Resource xmiResource) {
		Map<EObject, String> assignedIds = new HashMap<EObject, String>();
		VObjectValues instances = getInstances();
		for (EObject eobj: (Iterable<EObject>)()->xmiResource.getAllContents()) {
			String myId = UUID.randomUUID().toString();
			assignedIds.put(eobj, myId);
			instances.add(myId);
			instances.setClass(myId, eobj.eClass().getName());
		}
		for (EObject eobj: (Iterable<EObject>)()->xmiResource.getAllContents()) {
			String myId = assignedIds.get(eobj);
			for (EReference ref: eobj.eClass().getEAllReferences()) {
				Collection<EObject> subEobjs = MyEcoreUtil.getAsCollection(eobj, ref);
				VFeatureValues fv = getFeatureValues(ref);
				List<String> toAdd = new ArrayList<String>();
				for (EObject subEobj: subEobjs) {
					String uuid = assignedIds.get(subEobj);
					toAdd.add(uuid);
				}
				List<Object> originalObjects = fv.getValueList(myId);
				//So wie ich das lade, werden automatisch die Inversen Sachen eingefügt. Damit ich doppeltes einfügen vermeide, lösche ich die Liste
				//So wie die Liste funktioniert, sollte es sein, dass beim indirekten hinzufügen durch die andere Liste die korrekte Reihenfolge wiederhergestellt wird
				originalObjects.clear();
				originalObjects.addAll(toAdd);
			}
			for (EAttribute attr: eobj.eClass().getEAllAttributes()) {
				Collection<Object> subEobjs = MyEcoreUtil.getAsCollection(eobj, attr);
				VFeatureValues fv = getFeatureValues(attr);
				List<Object> originalObjects = fv.getValueList(myId);
				//Attributes are values, so you can directly insert them
				originalObjects.addAll(subEobjs);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		//Test ...
		Resource ecoreRes = OclExtractor.getEcore("model/router.ecore");
		Resource xmiRes = OclExtractor.getXMI("model/router.xmi", ecoreRes);
		VContainer root = new VSimpleContainer((GlobalSource)null);
		VContainer editableroot = new VSimpleContainer((GlobalSource)null);
		DeltaManager manager = SimpleDeltaManager.createDefaultManager();
		VDeltaContainer delta = new VDeltaContainer(null, editableroot, root, manager);
		
		VEcoreFile ecore = new VEcoreFileImpl(ecoreRes);
//		{
//			SimpleModelView smv = new SimpleModelView(root, ecore);
//			smv.loadResource(xmiRes);
//			
//			Resource newResource = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_saved.xmi"));
//			smv.saveResource(newResource);
//			newResource.save(new HashMap<>());
//		}
		{
			SimpleModelView smv = new SimpleModelView(root, ecore);
			smv.loadResource(xmiRes);
			
			Resource newResource = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_saved.xmi"));
			
			SimpleModelView deltaV = new SimpleModelView(delta, ecore);
			Resource deltaResource = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_deltasaved.xmi"));
			List<EObject> exposed = deltaV.exposeContents();
			for (EObject eobjRoot: exposed) {
				for (EObject eobj: (Iterable<EObject>)()->eobjRoot.eAllContents()) {
					EClass cl = eobj.eClass();
					EStructuralFeature esf = cl.getEStructuralFeature("name");
					if (esf != null) {
						eobj.eSet(esf, "Bla"+eobj.eGet(esf));
					}
				}
			}
			deltaV.saveResource(deltaResource);
			deltaResource.save(new HashMap<>());
			
			SimpleModelView pureDelta = new SimpleModelView(editableroot, ecore);
			Resource pureDeltaRes = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_delta_saved.xmi"));
			pureDelta.saveResource(pureDeltaRes);
			pureDeltaRes.save(new HashMap<>());
			
			smv.saveResource(newResource);
			newResource.save(new HashMap<>());	
			
			
		}
		
	}

	public void selfClear();

	public default Map<String, Map<String, Map<String, String>>> getContainmentNameMap() {
		Map<String, Map<String, Map<String, String>>> ret = new HashMap<>();
//		for (String inst: getInstances()) {
//			Set<String> names = getNames(inst);
//			for (String name: names) {
//				
//			}
//		}		
		return ret;
	}

}

