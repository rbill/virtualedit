package at.ac.tuwien.big.vmod.registry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.internal.core.ast.util.Injector;
import org.eclipse.ocl.util.Tuple;

import at.ac.tuwien.big.autoedit.test.OclExtractor;
import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.verocl.parameterdesc.MultiModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRef;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRefImpl;
import at.ac.tuwien.big.verocl.parameterdesc.SingleParameterDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiModelPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.SinglePointImpl;
import at.ac.tuwien.big.virtmod.multiref.ModelRef;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VProjectedModelView;
import at.ac.tuwien.big.vmod.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmod.ecore.impl.VSimpleProjectedModelView;
import at.ac.tuwien.big.vmod.impl.EcoreModelResource;
import at.ac.tuwien.big.vmod.impl.ParametizedGenerator;
import at.ac.tuwien.big.vmod.impl.ParametizedModelResource;
import at.ac.tuwien.big.vmod.impl.Projector;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.impl.SimpleDeltaModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.SimpleEcoreModelProviderImpl;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import net.sourceforge.ufoai.UFOScriptStandaloneSetup;

public class MultiLoader {
	
	private ModelRef root;
	private Map<ModelRef,ModelProvider> loadedModels = new HashMap<>();
	private VEcoreFile ecore;
	private Resource ecoreRes;
	private ModelResource parameterResource;
	private VProjectedModelView modelView;
	
	public MultiLoader(Resource ecoreRes) {
		this.ecore = new VEcoreFileImpl(ecoreRes);
		this.ecoreRes = ecoreRes;
	}
	
	public MultiLoader(VEcoreFile ecore, Resource ecoreRes) {
		this.ecore = ecore;
		this.ecoreRes = ecoreRes;
	}
	
	public Resource getResource(ModelProvider prov) {
		return provToResource.get(prov);
	}
	
	private Map<EObject,Symbol> eobjectSymbolMap = new HashMap<>();
	private Map<ModelRef,Resource> refToResource = new HashMap<>();
	private Map<ModelRef,SimpleModelView> storedModelViews = new HashMap<>();
	private Map<ModelProvider,Resource> provToResource = new HashMap<>();
	private Map<ModelRef,SimpleModelCorrespondance> correspondanceToReal = new HashMap<>();
	
	public void addToEObjectSymbolMap(SimpleModelCorrespondance mc, Map<EObject,Symbol> symbolMap) {
		for (Entry<EObject,EObject> entr: mc.getEntriesL2R()) {
			EObject left = entr.getKey();
			EObject right = entr.getValue();
			if (left instanceof VMEObject) {
				symbolMap.put(right, ((VMEObject) left).getUUID());
			}
			if (right instanceof VMEObject) {
				symbolMap.put(left, ((VMEObject) right).getUUID());
			}
		}
	}
	
	ModelResourceType type = null;
	
	Map<SinglePoint,ModelResource> resourceMap = new HashMap<SinglePoint, ModelResource>();
	
	public Collection<ModelResource> getModelResources() {
		return resourceMap.values();
	}
	
	public int getModelResourceCount() {
		return resourceMap.size();
	}
	
	public Set<ModelProvider> getProviders() {
		return provToResource.keySet();
	}
	
	public void resyncResources() {
		for (Entry<ModelRef,Resource> entr: refToResource.entrySet()) {
			ModelRef ref = entr.getKey();
			ModelProvider prov = loadedModels.get(ref);
			Resource res = entr.getValue();
			SimpleModelView loadedModel = storedModelViews.get(ref);
			SimpleModelCorrespondance smc = correspondanceToReal.get(ref);
			//Wenn es die aktuelle Ressource ist, wurde die vielleicht im Xtext-Editor schon geaendert.
			loadedModel.changeResource(res, smc);
		}
	}
	

	public void saveResources() {
		for (Entry<ModelRef,Resource> entr: refToResource.entrySet()) {
			ModelRef ref = entr.getKey();
			ModelProvider prov = loadedModels.get(ref);
			Resource res = entr.getValue();
			try {
				res.save(new HashMap<>());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ResourceSet rs;
	
	public ResourceSet getResourceSet() {
		return rs;
	}

	private static int MY_INDEX = 1;
	private static Map<URI,Integer> existingIndices = new HashMap<URI, Integer>();

	/**Loads a resource, but does not add it internally to anything.
	 * Changes to the returned resource may or may not reflect real changes
	 * 
	 * */
	public Resource loadResource(ResourceSet resourceSet, File file) throws IOException {
		URI uri = URIConverter.INSTANCE.normalize(URI.createFileURI(file.getCanonicalPath()));
		Integer index = existingIndices.get(uri);
		if (index == null) {
			existingIndices.put(uri, (index=MY_INDEX));
			++MY_INDEX;
		}
		SimpleEcoreModelProviderImpl prov = SimpleEcoreModelProviderImpl.createModelProvider(uri.toString(), ecoreRes);
		prov.setIndex(index);
		SimpleModelView loadedModel = new SimpleModelView(prov, ecore);
		Resource res = resourceSet.getResource(uri, true);
		ModelResource subRes = new EcoreModelResource(prov, ecoreRes, uri, null);
		type = subRes.getType();
		SimpleModelCorrespondance baseMC = loadedModel.loadResource(res);
		FakeResource ret = new FakeResource(resourceSet, URI.createURI(uri.toString()+"#"), loadedModel.exposeContents());
		return ret;
	}
	
	public void loadRoot(ResourceSet rs, ModelRef root) {
		this.rs = rs;
		this.root = root;
		Queue<Pair<ModelRef,ModelProvider>> loadQueue = new LinkedList<>();
		//Fülle einfach in SCM
		ModelProvider curRoot = loadedModels.get(root);

		SimpleDeltaModelProviderImpl test = null;
		int maxIndex = 0;
		if (curRoot == null) {
			SimpleEcoreModelProviderImpl prov = SimpleEcoreModelProviderImpl.createModelProvider(root.getURI(), ecoreRes);
			prov.setIndex(root.getIndex());
			maxIndex = Math.max(maxIndex, root.getIndex());
			SimpleModelView loadedModel = new SimpleModelView(prov, ecore);
			//Correspondance zwischen "echt" und "Virtual"
			
			Resource res = root.loadResource(rs);
			refToResource.put(root,res);
			provToResource.put(prov, res);
			storedModelViews.put(root, loadedModel);
			ModelResource subRes = new EcoreModelResource(prov, ecoreRes, URI.createURI(root.getURI()), null);
			type = subRes.getType();
			
			SimpleModelCorrespondance baseMC = loadedModel.loadResource(res);
			correspondanceToReal.put(root, baseMC);
			addToEObjectSymbolMap(baseMC, eobjectSymbolMap);
			//Die muss verglichen werden mit allem anderen ...
			loadedModels.put(root, prov);
			loadQueue.add(new Pair(root,loadedModel));
			for (ModelRef next: root.getNext()) {
				loadQueue.add(new Pair<>(next,prov));
			}	
		}
		while (!loadQueue.isEmpty()) {
			Pair<ModelRef,ModelProvider> toLoadPair = loadQueue.poll();
			ModelProvider cur = loadedModels.get(toLoadPair.getA());
			
			if (cur != null) {continue;}
			
			ModelRef mainref = toLoadPair.getA();
			/*SimpleDeltaModelProviderImpl deltaProv = new SimpleDeltaModelProviderImpl(mainref.getURI(),
					ecoreRes, toLoadPair.getB());*/
			SimpleEcoreModelProviderImpl prov = SimpleEcoreModelProviderImpl.createModelProvider(mainref.getURI(), ecoreRes);
			if (test == null) {
				test = new SimpleDeltaModelProviderImpl(Symbol.from("DeltaNr1"),ecoreRes,toLoadPair.getB(),prov.getResultModel());
			} else {
				test = new SimpleDeltaModelProviderImpl(Symbol.from("DeltaNumber"+mainref.getIndex()),ecoreRes,test,prov.getResultModel());
			}
			prov.setIndex(mainref.getIndex());
			maxIndex = Math.max(maxIndex, mainref.getIndex());
			prov.setValue(toLoadPair.getB());
			SimpleModelView loadedModel = new SimpleModelView(prov, ecore);
			Resource newRes = mainref.loadResource(rs);
			refToResource.put(mainref,newRes);
			provToResource.put(prov, newRes);
			storedModelViews.put(mainref, loadedModel);
			Resource xmiRes = provToResource.get(toLoadPair.getB());
			SimpleModelCorrespondance realCorr = SimpleModelCorrespondance.fromEmfCompare(xmiRes, newRes);
			
			//Jetzt weiß ich, wie ich von Alter Real-Ressource auf neue komme.
			//Damit kann ich aber auch 
			SimpleModelCorrespondance correspondance = new SimpleModelCorrespondance();
			SimpleModelView oldView = storedModelViews.get(mainref);
			SimpleModelCorrespondance ctr = correspondanceToReal.get(mainref);
			//Nimm das mit passendem Symbol
			//und assoziere es mit dem
			
			/*SimpleEcoreModelProviderImpl prov_new = SimpleEcoreModelProviderImpl.createModelProvider(mainref.getURI(), ecoreRes);
			SimpleModelView loadedModel_new = new SimpleModelView(prov_new, ecore);
			SimpleModelCorrespondance resource2Stored = loadedModel.loadResource(newRes);*/
			
			for (Entry<EObject,EObject> entr: realCorr.getEntriesL2R()) {
				//From old to new
				EObject oldObj = entr.getKey();
				EObject newRealObject = entr.getValue();
				Symbol oldSymbol = eobjectSymbolMap.get(oldObj);
				if (oldSymbol != null) {
					//Das stimmt natürlich überhaupt nicht ...
					//new real --> new virtual
					correspondance.putCorrespondence(loadedModel.getEObject(oldSymbol),newRealObject);
				}
			}
			//Das darf ich nicht aufrufen ... 
			SimpleModelCorrespondance newMC = loadedModel.synchronizeWithResource(newRes, correspondance);
			System.out.println("Loaded model: "+loadedModel.toContentString());
			addToEObjectSymbolMap(newMC, eobjectSymbolMap);
			correspondanceToReal.put(mainref, newMC);
			
			ModelRef toLoadRef = toLoadPair.getA();
			for (ModelRef next: toLoadRef.getNext()) {
				loadQueue.add(new Pair<>(next,cur));
			}	
		}
		
		SimpleModelView mv = new SimpleModelView(test, ecore);
		Resource deltaResource = new ResourceImpl();
		Object ret = mv.saveResource(deltaResource);
		System.out.println("Delta-Union-Model:" +mv.toContentString());
		
		//Jetzt habe ich dann das geladene Zeugs. Jetzt muss ich irgendwie die unterschiedlichen Modelle vereinen ...
		//Ich weiß, dass die Identifier die gleichen sind und dass im Delta-Modell die richtige Information steht
		//Jetzt müsste man daraus ein gemeinsames Modell berechnen
		
		//Wenn man die Deltas als eigenes im Union haben würde, würde sich ja genau das ergeben ..
		//Jetzt gibt es da so einiges, nutze das!
		
		//U is key, T is List<Key>
		/*ModelResource mRes= storedModelViews.get(root).get
				getMainProvider().
				getResource();
		ModelResourceType type = mRes.
				getType();*/
		
		ParametizedGenerator<Symbol, GeneralElement, MultiPoint, SinglePoint> gen = new ParametizedGenerator<>();
		List<PseudoModelRef> allValues = new ArrayList<>();
		
		for (Entry<ModelRef,SimpleModelView> entry: storedModelViews.entrySet())  {
			allValues.add(new PseudoModelRefImpl(entry.getKey().getURI(),entry.getKey().getPoints().getValues()));
			resourceMap.put(entry.getKey().getPoints(),entry.getValue().getMainProvider().getResultModel());
		}
		FunctionMap<SinglePoint, ModelResource> subFunc = new FunctionMap<SinglePoint, ModelResource>() {

			@Override
			public ModelResource getValue(SinglePoint key) {
				return resourceMap.get(key);
			}
		};
		Projector<MultiPoint, SinglePoint> projector = new Projector<MultiPoint, SinglePoint>() {

			@Override
			public MultiPoint project(MultiPoint src, MultiPoint add) {
				return src.intersectWithOrSame(add);
			}
		};
		ModelProvider provider = new SimpleEcoreModelProviderImpl(storedModelViews.get(root).getMainProvider().getType(),
				"fakeProvider", ecoreRes);
		
		provider.setIndex(maxIndex+1);
		//Jetzt habe ich - glaube ich - die Ressource vollständig geladen
		PseudoModelRefImpl pmr = new PseudoModelRefImpl(root.getURI(), root.getPoints().getValues());
		MultiModelPoint allParam = new MultiModelPointImpl(root.getPoints().getDesc(),allValues);
		ParametizedModelResource<MultiPoint, SinglePoint> parRes = 
				new ParametizedModelResource<MultiPoint, SinglePoint>(type, 
						provider, allParam, projector, subFunc, gen, URI.createURI("http://parametizedtest/root"));
		this.parameterResource = parRes;
		VSimpleProjectedModelView modelView = new VSimpleProjectedModelView(provider, parRes, ecore);
		this.modelView = modelView;
	}
	
	public VProjectedModelView getModelView() {
		return modelView;
	}
	
	public static void main1(String[] args) {
		//ResourceSet rs = new ResourceSetImpl();
		//ResourceSetInfo rsi = new ResourceSetInfo(rs);

		Resource ecoreRes = OclExtractor.getEcore("model/router.ecore");
		MultiLoader test = new MultiLoader(ecoreRes);
		PointDesc desc = new PointDesc();
		desc.addParameterDesc(new SingleParameterDesc("version", Integer.class));
		SinglePoint point1 = new SinglePointImpl(desc, 1);
		SinglePoint point2 = new SinglePointImpl(desc, 2);
		Resource res1 = OclExtractor.getXMI("model/version1.xmi", ecoreRes);
		Resource res2 = OclExtractor.getXMI("model/version2.xmi", ecoreRes);
		int[] index = new int[]{1};
		ModelRef modelRef1 = new ModelRef(index[0]++,res1, point1);
		
		ModelRef modelRef2 = new ModelRef(index[0]++,res2, point2);
		modelRef1.addNext(modelRef2);
		test.loadRoot(ecoreRes.getResourceSet(), modelRef1);
		
		VProjectedModelView modelView = test.getModelView();
		for (EObject eobj: modelView.getAllEObjects()) {
			if (eobj instanceof VMEObject) {
				VMEObject vme = (VMEObject)eobj;
				System.out.println("Union: "+vme.getString());
				VMEObject as1 = vme.project(new MultiPointImpl(desc, point1));
				System.out.println("Only 1: "+as1.getString());
				VMEObject as2 = vme.project(new MultiPointImpl(desc, point2));
				System.out.println("Only 2: "+as2.getString());
			} else {
				System.err.println("Wrong type!");
			}
		}
		
		
		
		for (EObject eobj: modelView.getAllEObjects()) {
			if (eobj instanceof VMEObject) {
				VMEObject vme = (VMEObject)eobj;
				System.out.println("Exploded: "+vme.explodedString());
			} else {
				System.err.println("Wrong type!");
			}
		}
				
	}
	
	public static void main2(String[] args) {
		//ResourceSet rs = new ResourceSetImpl();
		//ResourceSetInfo rsi = new ResourceSetInfo(rs);
		new UFOScriptStandaloneSetup().createInjectorAndDoEMFRegistration();
		Resource ecoreRes = OclExtractor.getEcore("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\workspaceVirt\\at.test.ufoscript\\model\\generated\\UFOScript.ecore");
		MultiLoader test = new MultiLoader(ecoreRes);
		PointDesc desc = new PointDesc();
		desc.addParameterDesc(new SingleParameterDesc("version", Integer.class));
		SinglePoint point1 = new SinglePointImpl(desc, 1);
		SinglePoint point2 = new SinglePointImpl(desc, 2);

		Resource res1 = OclExtractor.getXMI("model/simple.ufo", ecoreRes);
		/*ModelRef modelRef1 = new ModelRef(res1, point1);
		ModelRef modelRef2 = new ModelRef(res2, point2);
		modelRef1.addNext(modelRef2);*/
		PointDesc sdesc = new PointDesc();
		sdesc.addParameterDesc(new SingleParameterDesc("uri", String.class));
		int[] index = new int[]{1};
		ModelRef modelRef1 = ModelRef.modelRefOrNull(index, res1.getResourceSet(), res1.getURI().toString().replace(".ufo", ""), "ufo", sdesc);
		test.loadRoot(ecoreRes.getResourceSet(), modelRef1);
		
		VProjectedModelView modelView = test.getModelView();
		for (EObject eobj: modelView.getAllEObjects()) {
			if (eobj instanceof VMEObject) {
				VMEObject vme = (VMEObject)eobj;
				System.out.println("Union: "+vme.getString());
				VMEObject as1 = vme.project(new MultiPointImpl(desc, point1));
				System.out.println("Only 1: "+as1.getString());
				VMEObject as2 = vme.project(new MultiPointImpl(desc, point2));
				System.out.println("Only 2: "+as2.getString());
				VMEObject as3 = vme.project(new MultiPointImpl(desc, point2));
				System.out.println("Only 3: "+as3.getString());
			} else {
				System.err.println("Wrong type!");
			}
		}
		
		for (EObject eobj: modelView.getAllEObjects()) {
			if (eobj instanceof VMEObject) {
				VMEObject vme = (VMEObject)eobj;
				System.out.println("Exploded: "+vme.explodedString());
			} else {
				System.err.println("Wrong type!");
			}
		}
	
		for (EObject eobj: modelView.getAllEObjects()) {
			if (eobj.eContainer() != null) {continue;}
			if (eobj instanceof VMEObject) {
				VMEObject vme = (VMEObject)eobj;
				System.out.println("Full: \n"+vme.fullString());
				System.out.println("Union: \n"+vme.unionString());
			} else {
				System.err.println("Wrong type!");
			}
		}
	}
	
	public static void main(String[] args) {
		main2(args);
	}

	public Resource getEcoreResource() {
		return ecoreRes;
	}

	


}
