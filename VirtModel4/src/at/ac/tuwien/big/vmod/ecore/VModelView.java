package at.ac.tuwien.big.vmod.ecore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

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
import at.ac.tuwien.big.vmod.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.impl.SimpleDeltaModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.SimpleEcoreModelProviderImpl;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.registry.SymbolRegistryImpl;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.impl.ModelProviderTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.SymbolRegistryTypeImpl;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.xtext.equalizer.Creater;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
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
	
	public VMEObject getEObject(Symbol x);
	
	public ModelProvider getMainProvider();
	
	//Assume that functions are static
	//If things have changd, you have to reload
	public void reload();

	public default EObject getContainingObject(Symbol uuid) {
		Symbol ret = getContainingObjectUuid(uuid);
		if (ret != null) {
			return getEObject(ret);
		}
		return null;
	}
	
	public Symbol getContainingObjectUuid(Symbol uuid);

	public EReference getContainingFeature(Symbol uuid);

	public default List<EObject> wrapObjects(List<Symbol> base) {
		return new ConvertingListImpl<EObject,Symbol>(base,
				(x)->{if (x instanceof VMEObject) {
						return ((VMEObject) x).getUUID();
					  } else {
						throw new RuntimeException("Adding real EObjects to Virtual Resource not yet implemented");
					  }
				},(x)->getEObject(x));
	}
	

	public default String toContentString() {
		StringBuilder ret = new StringBuilder();
		for (EObject eobj: getAllEObjects()) {
			if (eobj.eContainer() != null) {continue;}
			if (eobj instanceof VMEObject) {
				VMEObject vme = (VMEObject)eobj;
				if (ret.length()>0) {ret.append("\n");}
				ret.append(vme.fullString());
			} else {
				System.err.println("Wrong type!");
			}
		}
		return ret.toString();
	}
	
	public default void printModel(StringBuilder toString) {
		Map<Symbol,String> eobjNames = new HashMap<>();
		Map<EClass,Integer> curNames = new HashMap<>();
		VObjectValues vov = getInstances();
		for (Symbol uuid: vov.existing()) {
			EClass cl = vov.getClass(uuid);
			Integer curInd = curNames.getOrDefault(cl, 1);
			eobjNames.put(uuid, (cl==null?"UnknownClass":cl.getName())+curInd);
			curNames.put(cl, curInd+1);
		}
		Set<Symbol> haveInstances = new HashSet<>();
		
		Map<Symbol,VMEObject> eobj = new HashMap<>();
		for (Symbol uuid: getInstances().existing()) {
			
			eobj.put(uuid, (VMEObject)getEObject(uuid));
		}
		List<VMEObject> containerless = new ArrayList<>();
		for (VMEObject so: eobj.values()) {
			if (so.eContainer() == null) {
				containerless.add(so);
			}
		}
		
		List<Symbol> sorted = new ArrayList<>();
		Set<Symbol> sortedSet = new HashSet<>();
		Stack<Symbol> next = new Stack<>();
		for (VMEObject str: containerless) {
			next.add(str.getUUID());
		}
		while (!next.isEmpty()) {
			Symbol uuid = next.pop();
			sorted.add(uuid);
			VMEObject veobj = (VMEObject) getEObject(uuid);
			EClass cl = getInstances().getClass(uuid);
			if (cl == null) {
				System.err.println("Null "+uuid);
				continue;
			}
			for (EReference esf: cl.getEAllReferences()) {
				if (!esf.isContainment()) {
					continue;
				}
				List<Symbol> strings = new ArrayList<>((List<Symbol>)(List)getFeatureValues(esf).getValueValue(uuid));
				Collections.reverse(strings);
				for (Symbol s: strings) {
					if (sortedSet.add(s)) {
						next.add(s);
					}
				}
			}
		}
		
		
		for (Symbol uuid: sorted) {
			EClass cl = getInstances().getClass(uuid);
			toString.append("Object "+eobjNames.get(uuid)+ " [uuid: "+uuid+"]:\n");
			if (cl == null) {
				continue;
			}
			for (EAttribute esf: cl.getEAllAttributes()) {
				List li = getFeatureValues(esf).getEcoreValue(uuid);
				String toAppend = esf.getName()+": " +Arrays.toString(li.toArray())+"\n";
				li.toArray();
				toString.append(toAppend);
			}
			for (EReference esf: cl.getEAllReferences()) {
				List<Symbol> strings = (List<Symbol>)(List)getFeatureValues(esf).getValueValue(uuid);
				List<Object> objects = new ArrayList<Object>();
				for (Symbol str: strings) {
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
	

	public default List<EObject> getAllEObjects() {
		initModelForEdit();
		//Now everything should be added, time to figure our what to add as root: Everything without container
		List<EObject> ret = new ArrayList<>();
		Set<Symbol> retS = new HashSet<>();
		for (Symbol uuid: getInstances().existing()) {
			if (retS.add(uuid)) {
				ret.add(getEObject(uuid));
			}
		}
		return ret;
	}
	
	public default List<EObject> allInstances(EClass cl) {
		List<EObject> ret = new ArrayList<>();
		Set<EObject> retS = new HashSet<EObject>(); 
		for (EObject eobj: getAllEObjects()) {
			if (eobj != null && eobj.eClass() != null && cl.isSuperTypeOf(eobj.eClass()) && retS.add(eobj)) {
				ret.add(eobj);
			}
		}
		return ret;
	}
	
	public default List<EObject> exposeContents() {
		initModelForEdit();
		//Now everything should be added, time to figure our what to add as root: Everything without container
		Map<Symbol,EObject> eobj = new HashMap<>();
		List<EObject> containerless = new ArrayList<EObject>();
		for (Symbol uuid: getInstances().existing()) {
			eobj.put(uuid, getEObject(uuid));
		}
		for (EObject so: eobj.values()) {
			//System.out.println("Container of "+so+": "+so.eContainer());
			if (so.eContainer() == null) {
				containerless.add(so);
			}
		}
		return containerless;
	}
	
	public default List<EObject> saveContents(Creater<EObject, EClass> creater, SimpleModelCorrespondance corr) {

		//Create "real" objects
		Map<Symbol,EObject> eobj = new HashMap<>();
		List<EObject> containerless = new ArrayList<EObject>();
		
		for (Symbol uuid: getInstances().existing()) {
			EClass cl = getInstances().getClass(uuid);
			//System.out.println(uuid+" has class "+(cl==null?"null":cl.getName()));
			if (cl == null) {
				//TODO: This is a bug ...
				System.err.println("Null class ..."+uuid);
				continue;
			}
			EObject neweobj = creater.create(cl);
			eobj.put(uuid, neweobj);
			if (corr != null) {
				corr.putCorrespondence(getEObject(uuid), neweobj);
			}
		}
		for (Symbol symb: getInstances().getRootObjects()) {
			containerless.add(eobj.get(symb));
		}
		
		for (Entry<Symbol,EObject> entry: eobj.entrySet()) {
			EClass cl = entry.getValue().eClass();
			Symbol uuid = entry.getKey();
			for (EAttribute attr: cl.getEAllAttributes()) {
				List<?> curValues = getFeatureValues(attr).getEcoreValue(uuid);
				if (attr.isMany()) {
					entry.getValue().eSet(attr, new ArrayList<>(curValues));
				} else {
					if (!curValues.isEmpty()) {
						entry.getValue().eSet(attr, curValues.iterator().next());
					} 
				}
			}
			for (EReference ref: cl.getEAllReferences()) {
				List<?> curValues = getFeatureValues(ref).getEcoreValue(uuid);
				if (ref.isMany()) {
					List<EObject> targets = new ArrayList<EObject>();
					for (Object o: curValues) {
						if (o instanceof VMEObject) {
							VMEObject vm = (VMEObject)o;
							if (vm.contExists()) {
								EObject target = eobj.get(vm.getUUID());
								if (target == null) {
									System.err.println("Null target from "+o+" with symbol");
								} else {
									targets.add(target);
								}
							}
						} else {
							List<?> newValues = getFeatureValues(ref).getEcoreValue(uuid);
							System.err.println("Wrong type: "+o+" is not a VMEObject!");
						}
					}
					EList<EObject> savedValues = FakeEListImpl.ensureEList((List<EObject>)entry.getValue().eGet(ref));
					if (savedValues.isEmpty()) {
						//Just redo
						try {
							noInverseAddAll(savedValues,targets);
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
						System.out.println(targets + " VS "+savedValues);
					}
				} else {
					if (!curValues.isEmpty()) {
						Object curV = curValues.iterator().next();
						if (curV instanceof VMEObject) {
							VMEObject vm = (VMEObject)curV;
							if (vm.contExists()) {
								EObject trg = eobj.get(vm.getUUID());
								entry.getValue().eSet(ref, trg);
							}
							//System.out.println("Set "+ref.getEContainingClass().getName()+"."+ref.getName()+" = "+trg + " (from "+curV+") for "+entry.getValue());
						} else {
							//System.err.println("Wrong type: "+curV+" is not a VMEObject!");
						}
						
					} else {
						//System.out.println("Set "+ref.getEContainingClass().getName()+"."+ref.getName()+" to null for "+entry.getValue());
					}
				}
			}
		}
		//Now everything should be added, time to figure our what to add as root: Everything without container
		
		return containerless;
	}
	
	public static  void noInverseAddAll(EList<EObject> savedValues, List<EObject> targets) {
		if (savedValues instanceof NoInverse) {
			((NoInverse<List>)savedValues).noInverse().addAll(targets);
		} else {
			savedValues.addAll(targets);
		}
	}

	public default SimpleModelCorrespondance saveResource(Resource xmiResource) {
		MyResource res = MyResource.get(xmiResource);
		SimpleModelCorrespondance ret = new SimpleModelCorrespondance();
		List<EObject> eobj = saveContents((x)->res.createInstance(x),ret);
		xmiResource.getContents().addAll(eobj);
		return ret;
	}
	
	public default List<EObject> getResourceEObjects() {
		Iterable<Symbol> symbols = getInstances().getRootObjects();
		List<EObject> ret = new ArrayList<>();
		for (Symbol sym: symbols) {
			ret.add(getEObject(sym));
		}
		return ret;
	}
	
	//Before you call synchronizeWithResource, then you change the xmiResource with that
	public default void changeResource(Resource xmiResource, SimpleModelCorrespondance correspondance) {
		List<EObject> sourceEObjects = getResourceEObjects();
		//TODO: just to check things
		//TODO: Own file for the things ... then you don't have this mixture problem
		correspondance.removeResourceLess();
		SimpleModelCorrespondance otherCorr = new SimpleModelCorrespondance();
		//Works here, so the correspondance is wrong
		SimpleModelEqualizer eq = new SimpleModelEqualizer(sourceEObjects, xmiResource.getContents(),
				correspondance, otherCorr, 
				InstanceCreator.DEFAULT);
		eq.equalize();
	}
	
	public default SimpleModelCorrespondance synchronizeWithResource(Resource xmiResource, SimpleModelCorrespondance correspondance) {
		List<EObject> targetEObjects = getResourceEObjects();
		List<EObject> oldEObjects = new ArrayList<>(targetEObjects);
		Map<EObject,Symbol> reuseSymbol = new HashMap<EObject, Symbol>();
		Map<EObject,VMEObject> oldObj = new HashMap<EObject, VMEObject>();
		for (EObject eobj: (Iterable<EObject>)()->xmiResource.getAllContents()) {
			VMEObject oldObject = (VMEObject)correspondance.getLeftObject(eobj);
			//Jetzt br?uchte ich aber
			if (oldObject != null) {
				//Es gab das objekt schon fr?her, benutzte die ID nocheinmal
				oldObj.put(eobj, oldObject);
				reuseSymbol.put(eobj, oldObject.getUUID());
			} else {
				oldObject = (VMEObject)createEObject(eobj.eClass());
				oldObj.put(eobj, oldObject);
				correspondance.putCorrespondence(oldObject, eobj);
			}
			//newCorr.putCorrespondence(thingWhichChange, thingWhichShouldBeSynchronized);
		}
		SimpleModelCorrespondance empty = new SimpleModelCorrespondance();
		//Es ist so ?hnlich: Ich muss equalizen ...
		SimpleModelEqualizer eq = new SimpleModelEqualizer(xmiResource.getContents(), targetEObjects, correspondance.inverse(), 
				empty, (cont,cl)->{					
					throw new RuntimeException("Objects should have been created!");
				});
		eq.equalize();
		Set<EObject> noMoreRoot = new HashSet<>(oldEObjects);
		Set<EObject> newRoot = new HashSet<>(targetEObjects);
		noMoreRoot.removeAll(targetEObjects);
		newRoot.removeAll(oldEObjects);
		for (EObject eobj: noMoreRoot) {
			if (eobj instanceof VMEObject) {
				getInstances().makeUncontainedInRoot(((VMEObject) eobj).getUUID());
			} else {
				throw new RuntimeException();
			}
		}
		for (EObject eobj: newRoot) {
			if (eobj instanceof VMEObject) {
				getInstances().makeContainedInRoot(((VMEObject) eobj).getUUID());
			} else {
				throw new RuntimeException();
			}
		}
		//retCorr is the inverse of newCorr
		for (Entry<EObject,EObject> entry: empty.getEntriesR2L()) {
			correspondance.putCorrespondence(entry.getKey(), entry.getValue());
		}
		return correspondance;
	}
	
	/**Loads the resource. Correspondance: Real Object --> Virtual Object*/
	public default SimpleModelCorrespondance loadResource(Resource xmiResource) {
		Map<EObject, Symbol> assignedIds = new HashMap<>();
		VObjectValues instances = getInstances();
		SimpleModelCorrespondance ret = new SimpleModelCorrespondance();
		for (EObject eobj: (Iterable<EObject>)()->xmiResource.getAllContents()) {
			Symbol myId = getMainProvider().newSymbol((eobj==null || eobj.eClass() == null)?null:eobj.eClass().getName());
			assignedIds.put(eobj, myId);
			instances.add(myId);
			instances.setClass(myId, eobj.eClass());
			ret.putCorrespondence(eobj, getEObject(myId));
		}
		for (EObject eobj: xmiResource.getContents()) {
			Symbol myId = assignedIds.get(eobj);
			getInstances().makeContainedInRoot(myId);
		}
		for (EObject eobj: (Iterable<EObject>)()->xmiResource.getAllContents()) {
			Symbol myId = assignedIds.get(eobj);
			for (EReference ref: eobj.eClass().getEAllReferences()) {
				Collection<EObject> subEobjs = MyEcoreUtil.getAsCollection(eobj, ref);
				VFeatureValues fv = getFeatureValues(ref);
				List<Symbol> toAdd = new ArrayList<>();
				for (EObject subEobj: subEobjs) {
					Symbol uuid = assignedIds.get(subEobj);
					toAdd.add(uuid);
				}
				List originalObjects = fv.getValueValue(myId);
				//So wie ich das lade, werden automatisch die Inversen Sachen eingef?gt. Damit ich doppeltes einf?gen vermeide, l?sche ich die Liste
				//So wie die Liste funktioniert, sollte es sein, dass beim indirekten hinzuf?gen durch die andere Liste die korrekte Reihenfolge wiederhergestellt wird
				if (originalObjects instanceof NoInverse) {
					List l2 = (List)((NoInverse)originalObjects).noInverse();
					l2.addAll(toAdd);
				} else {
					throw new RuntimeException("Can only handle noInverse!");
				}
			}
			for (EAttribute attr: eobj.eClass().getEAllAttributes()) {
				Collection<Object> subEobjs = MyEcoreUtil.getAsCollection(eobj, attr);
				VFeatureValues fv = getFeatureValues(attr);
				List originalObjects = fv.getEcoreValue(myId);
				//Attributes are values, so you can directly insert them
				originalObjects.addAll(subEobjs);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		//Test ...
		SymbolRegistry registry = new SymbolRegistryImpl(new SymbolRegistryTypeImpl());
		Resource ecoreRes = OclExtractor.getEcore("model/router.ecore");
		Resource xmiRes = OclExtractor.getXMI("model/router.xmi", ecoreRes);
		ModelProviderType provType = new ModelProviderTypeImpl();
		ModelProvider prov = new SimpleEcoreModelProviderImpl(provType,"routerXmi", ecoreRes);
		
		ModelProvider delta = new SimpleDeltaModelProviderImpl("routerXmiDelta", ecoreRes, prov);
		registry.addProvider(prov);
		registry.addProvider(delta);
		
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
			SimpleModelView smv = new SimpleModelView(prov, ecore);
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

	public default InstanceCreator getTransformationCreater(Symbol prefix, ModelCorrespondance parent, ModelCorrespondance sub) {
		InstanceCreator creator = new InstanceCreator() {
			
			Map<Symbol,Map<EClass,Integer>> usedSymbols = new HashMap<>();
			
			
			public Symbol getSymbol(EObject container, EClass cl) {
				EObject vme = sub.getRightObject(container);
				if (vme == null) {
					vme = parent.getRightObject(container);
				}
				Symbol symbol = null;
				if (vme instanceof VMEObject) {
					VMEObject vmeo = (VMEObject)vme;
					symbol = vmeo.getUUID();
				}
				Map<EClass,Integer> usedMap = usedSymbols.get(symbol);
				if (usedMap == null) {
					usedSymbols.put(symbol, usedMap = new HashMap<>());
				}
				Integer curInt = usedMap.getOrDefault(cl,1);
				usedMap.put(cl, curInt+1);
				Symbol postfix;
				if (symbol == null) {
					postfix = Symbol.buildFrom("post", cl.getName(), curInt);
				} else {
					postfix = Symbol.buildFrom("post", symbol, cl.getName(), curInt); 
				}
				return Symbol.buildFrom(getMainProvider().getMainSymbol(), prefix,postfix);
			}
			
			@Override
			public EObject createInstance(EObject cont, EClass cl) {
				ModelProvider prov = getMainProvider();
				Symbol newSymbol = getSymbol(cont, cl); //Alles was erzeugt wird landed hier TODO: ?ndern, so dass es passt ... wie ist das?
				VObjectValues val = getInstances();
				val.add(newSymbol);
				val.setClass(newSymbol, cl);
				//System.out.println("Creating "+ cl.getName()+" for id "+newSymbol);
				//if ("EClass".equals(cl.getName())) {
//					System.err.println("Creating eclass?!");
				//}
				return getEObject(newSymbol);
			}
		};
		return creator;
	}

	public default EObject createEObject(Symbol newAttribute, EClass parameter) {
		if (parameter == null) {
			System.err.println("Wanting to create NULL class "+newAttribute);
		}
		getInstances().add(newAttribute);
		getInstances().setClass(newAttribute, parameter);
		return getEObject(newAttribute);
	}

	public default EObject createEObject(EClass parameter) {
		if (parameter == null) {
			System.err.println("Wanting to create NULL class!");
		}
		Symbol newAttribute = getMainProvider().newSymbol(parameter==null?null:parameter.getName());
		getInstances().add(newAttribute);
		getInstances().setClass(newAttribute, parameter);
		return getEObject(newAttribute);
	}

}
