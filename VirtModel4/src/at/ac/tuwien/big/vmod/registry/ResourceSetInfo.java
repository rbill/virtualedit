package at.ac.tuwien.big.vmod.registry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import at.ac.tuwien.big.autoedit.test.OclExtractor;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmod.impl.EcoreModelResource;
import at.ac.tuwien.big.vmod.provider.DerivationModelProvider;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.SimpleModelProvider;
import at.ac.tuwien.big.vmod.provider.impl.SimpleDeltaModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.SimpleEcoreModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.TransformationExecutor;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.vmod.type.impl.ModelProviderTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.SymbolRegistryTypeImpl;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class ResourceSetInfo {
	private ResourceSet rs;
	private List<Resource> baseModels = new ArrayList<>();
	private List<Resource> changeModels = new ArrayList<>();
	private Map<Resource,ResourceInfo> resourceInfos = new HashMap<>();
	private boolean changeDone = true;
	private SymbolRegistry symbolRegistry;
	private VEcoreFile ecoreFile;
	private Map<Symbol, Resource> symbolNameToResource = new HashMap<>(); //TODO: Memory leak ...
	
	
	
	public ResourceSet getResourceSet() {
		return rs;
	}
	

	private void loadResources() {
		for (Resource res: baseModels) {
			ResourceInfo ri = resourceInfos.get(res);
			ri.resetBasicContent(res);
		}
		changeDone = true;
	}
	
	public List<ModelResource> userInfoResources() {
		List<ModelResource> ret = new ArrayList<>();
		for (ResourceInfo info: resourceInfos.values()) {
			ret.add(info.getBaseProvider().getUserEditModel());
			for (TransformationModelProviderImpl tpi: info.getCompleteTransformationModelProviders()) {
				ret.add(tpi.getUserEditModel());
			}
		}
		return ret;
	}
	
	public enum DerivationStatus {
		UNSPECIFIED, DERIVED, PARTLY_DERIVED, NONDERIVED;
	}
	
	public static class DerivationSource {
		public DerivationSource(ModelResource resource, GeneralElement value) {
			this.resource = resource;
			this.value = value;
		}
		public final ModelResource resource;
		public final GeneralElement value;
		
		public int hashCode() {
			return (resource==null?0:resource.hashCode())*127+(value==null?0:value.hashCode());
		}
		
		public boolean equals(Object o) {
			if (!(o instanceof DerivationSource)) {
				return false;
			}
			DerivationSource d = (DerivationSource)o;
			return Objects.equals(resource, d.resource) && Objects.equals(value, d.value);
		}
	}
	
	public static class ExactDerivationStatus {
		
		
		
		private List<DerivationSource> userProviders = new ArrayList<>();
		private List<DerivationSource> transformationProviders = new ArrayList<>();
		
		public void addUserProvider(GeneralElement value) {
			addUserProvider(value.getResource(),value);
		}
		
		public void addUserProvider(ModelResource prov, GeneralElement value) {
			userProviders.add(new DerivationSource(prov, value));
		}

		public void addTransformationProvider(GeneralElement value) {
			addTransformationProvider(value.getResource(),value);
		}
		
		public void addTransformationProvider(ModelResource prov, GeneralElement value) {
			transformationProviders.add(new DerivationSource(prov, value));
		}
		
		public DerivationStatus getStatus() {
			if (userProviders.isEmpty()) {
				if (transformationProviders.isEmpty()) {
					return DerivationStatus.UNSPECIFIED;
				} else {
					return DerivationStatus.DERIVED;
				}
			} else {
				if (transformationProviders.isEmpty()) {
					return DerivationStatus.NONDERIVED;
				} else {
					return DerivationStatus.PARTLY_DERIVED;
				}
			}
		}

		public List<DerivationSource> getTransformationProviders() {
			return transformationProviders;
		}
		
		public List<DerivationSource> getUserProviders() {
			return userProviders;
		}
		
		
		
		

		/*public DerivationStatus mergeWith(DerivationStatus part) {
			if (part == UNSPECIFIED) {return this;}
			switch(this) {
			case UNSPECIFIED: return part;
			case DERIVED: return part==DERIVED?DERIVED:PARTLY_DERIVED;
			case PARTLY_DERIVED: return PARTLY_DERIVED;
			case NONDERIVED: return part==NONDERIVED?NONDERIVED:PARTLY_DERIVED;
			default:
				throw new RuntimeException("Should not happen");
			}
		}*/
	}
	
	
	/**A change is done: If a resource is saved or a resource has been changed on disk (?)*/
	public void setChangeDone(boolean changeDone) {
		this.changeDone = changeDone;
	}
	
	public class ResourceInfo {
		private Resource resource;
		private ModelProvider baseProvider;
		private Map<Resource, ModelResource> transformationUserDelta = new HashMap<>();
		private List<Resource> deltaResources = new ArrayList<>();
		private List<ModelProvider> deltaResourceProviders = new ArrayList<>();
		private List<TransformationModelProviderImpl> tpis = new ArrayList<>();
		private List<TransformationModelProviderImpl> weaktpis = new ArrayList<>();
		private ModelProvider completeProvider;
		private ModelProvider selectiveProvider;
		private long lastChangeDate;
		private SimpleModelCorrespondance corr;
		
		public List<TransformationModelProviderImpl> getTransformationModelProviders() {
			return weaktpis;
		}
		
		public List<TransformationModelProviderImpl> getCompleteTransformationModelProviders() {
			return tpis;
		}
		
		public void setBaseCorrespondance(SimpleModelCorrespondance corr) {
			this.corr = corr;
		}
		
		public SimpleModelCorrespondance getBaseCorresponcance() {
			if (corr == null) {
				corr = new SimpleModelCorrespondance();
			}
			return corr;
		}

		public ResourceInfo(Resource res) {
			this.resource = res;
			this.baseProvider = SimpleEcoreModelProviderImpl.createModelProvider(res.getURI().toString(), ecore);
			//Check delta
			for (int i = 1; ; ++i) {
				try {
					Resource deltaRes = res.getResourceSet().getResource(
							URI.createURI(res.getURI().toString()+"."+i+".delta."+res.getURI().fileExtension()),true);
					if (deltaRes != null) {
						String symb = res.getURI().toString()+"."+i+".delta."+res.getURI().fileExtension();
						SimpleEcoreModelProviderImpl semp = SimpleEcoreModelProviderImpl.createModelProvider(symb, deltaRes);
						SimpleModelView smv = new SimpleModelView(semp, ecoreFile);
						smv.loadResource(deltaRes);
						deltaResources.add(deltaRes);
						deltaResourceProviders.add(semp);
					} else {
						break;
					}
				} catch (RuntimeException e) {
					e.printStackTrace();
					break;
				}
			}
			
		}
		
		public ModelResource getTransformationDelta(Resource forTransformation) {
			return transformationUserDelta.get(forTransformation);
		}
		

		public void resetBasicContent(Resource res) {
			ModelProvider baseProv = getBaseProvider();
			baseProv.clear();
			SimpleModelView smv = new SimpleModelView(baseProv, ecoreFile);
			SimpleModelCorrespondance corr = smv.loadResource(res);
			setBaseCorrespondance(corr);
		}
		
		public ModelProvider calcSelectiveProvider(Set<Resource> includeAspects, Set<Resource> excludeAspects) {
			if (excludeAspects.isEmpty()) {
				if (needRecalc) {
					recalc();
				}
				return completeProvider;
			}
			ModelProvider curProvider = baseProvider;
			List<TransformationModelProviderImpl> newtpis = new ArrayList<>();
			Map<ModelProvider,ModelProvider> transferMap = new HashMap<>();
			for (int i = 0; i < deltaResources.size(); ++i) {
				Resource dr = deltaResources.get(i);
				boolean include = !excludeAspects.contains(dr);
				if (include) {
					SymbolImpl newSymbol = new SymbolImpl(baseProvider.getMainSymbol().getName()+"_delta"+(i+1));
					newSymbol.subObjects().addAll(baseProvider.getMainSymbol().subObjects());
				curProvider = new SimpleDeltaModelProviderImpl(newSymbol,
						deltaResources.get(i),curProvider,deltaResourceProviders.get(i).getResultModel());
				}
			}
			for (int i = 0; i < transformationExecutors.size(); ++i) {
				TransformationExecutionInfo tei = transformationExecutors.get(i);
				TransformationModelProviderImpl tpi = tpis.get(i);
				Resource res = tei.getResource();
				boolean include = !excludeAspects.contains(res);
				List<ModelProvider> newInputs = IteratorUtils.convert(tpi.getPrevious(),transferMap);
				TransformationModelProviderImpl newtpi = tpi.withRedirectedInput(newInputs, !include);
				transferMap.put(tpi, newtpi);
				newtpis.add(newtpi);
				curProvider = newtpi;
			}
			weaktpis = newtpis;
			selectiveProvider = curProvider;
			return selectiveProvider;
		}
		
		private boolean needRecalc;
		
		/**Dangerous: rests transformation!!*/
		private void recalc() {
			ModelProvider curProvider = baseProvider;
			symbolRegistry.removeProviders(tpis);
			tpis = new ArrayList<>();
			ViewState state = getContainedViewState();
			needRecalc = false;
			for (int i = 0; i < deltaResources.size(); ++i) {
				Resource dr = deltaResources.get(i);
				boolean include = !state.disabledViews().contains(dr);
				if (include) {
					SymbolImpl newSymbol = new SymbolImpl(baseProvider.getMainSymbol().getName()+"_delta"+(i+1));
					newSymbol.subObjects().addAll(baseProvider.getMainSymbol().subObjects());
				curProvider = new SimpleDeltaModelProviderImpl(newSymbol,
						deltaResources.get(i),curProvider,deltaResourceProviders.get(i).getResultModel());
						symbolNameToResource.put(curProvider.getMainSymbol(), dr);
				} else {
					needRecalc = true;
				}
			}
			for (TransformationExecutionInfo tei: transformationExecutors) {
				ModelResource res = transformationUserDelta.get(tei.getResource());
				SymbolImpl newSymbol = new SymbolImpl(baseProvider.getMainSymbol().getName()+"_"+tei.getSymbol());
				newSymbol.subObjects().addAll(baseProvider.getMainSymbol().subObjects());
				TransformationModelProviderImpl tmpi = new TransformationModelProviderImpl(baseProvider.getType(),
						newSymbol, ecore, curProvider, tei.getExecutor(), res);
				symbolNameToResource.put(tmpi.getMainSymbol(), tei.getResource());
				tpis.add(tmpi);
				symbolRegistry.addProvider(tmpi);;
				transformationUserDelta.put(tei.getResource(), res = tmpi.getUserEditModel());
				curProvider = tmpi;
			}
			completeProvider = curProvider;
		}
		
		public void reexecuteTransformation(int startTrafo) {
			recalc();
			for (int i = startTrafo; i < tpis.size(); ++i) {
				TransformationModelProviderImpl tmpi = tpis.get(i);
				tmpi.recalc();
			}
		}
		
		public ModelProvider getBaseProvider() {
			return baseProvider;
		}
		
		public void setBaseProvider(ModelProvider base) {
			this.baseProvider = base;
		}
		
		public ModelProvider getCompleteProvider() {
			return completeProvider;
		}		
		
		public void setCompleteProvider(ModelProvider base) {
			this.completeProvider = base;
		}
		
		public void calculatedResource() {
			lastChangeDate = resource.getTimeStamp();
		}
		
		public boolean resourceChanged() {
			return lastChangeDate < resource.getTimeStamp();
		}

	}
	
	
	private List<TransformationExecutionInfo> transformationExecutors = new ArrayList<>();
	private Map<Resource,TransformationExecutionInfo> curTeiMap = new HashMap<>();
	private Resource ecore; 
	
	public Resource getEcoreResource() {
		return ecore;
	}
	
	
	
	private static Map<String, TransformatorGeneratorGenerator> transformatorGeneratorGenerators = new HashMap<>();
	{
		addTransformatorGeneratorGenerator("ultrasimpletrafo", new TransformatorGeneratorGenerator() {
			
			@Override
			public TransformationExecutor getExecutor(Resource res) {
				EObject main = res.getContents().get(0);
				String prefix = (String)main.eGet(main.eClass().getEStructuralFeature("prefix"));
				TransformationExecutor blaNameExecutor = new TransformationExecutor() {

					@Override
					public void executeOn(VModelView view) {
						List<EObject> eobjs = view.getAllEObjects();
						for (EObject eobj: eobjs) {
							EClass cl = eobj.eClass();
							if (cl == null) {
								continue;
							}
							EStructuralFeature feat = cl.getEStructuralFeature("name");
							if (!(feat instanceof EAttribute) || feat.getEType().getInstanceClass() != String.class || feat.getUpperBound() != 1) {
								continue;
							}
							eobj.eSet(feat, prefix+eobj.eGet(feat));
						}
					}
				};
				return blaNameExecutor;
			}
		});
		
		addTransformatorGeneratorGenerator("http://www.ac.at/tuwien/big/simpleaspect/SimpleAspect",new SimpleJavaGenerator());
		addTransformatorGeneratorGenerator("http://www.eclipse.org/emf/2011/Henshin", new HenshinGenerator());
	}
	
	
	public static void addTransformatorGeneratorGenerator(String epackageName, TransformatorGeneratorGenerator generator) {
		transformatorGeneratorGenerators.put(epackageName, generator);
	}
	
	public static TransformatorGeneratorGenerator getGeneratorOrNull(String epackage) {
		return transformatorGeneratorGenerators.get(epackage);
	}
	
	
	private static WeakHashMap<ResourceSet,ResourceSetInfo> resourceSetMap = new WeakHashMap<>();
	
	public static ResourceSetInfo getResourceSetInfo(ResourceSet rs, Resource ecore) {
		ResourceSetInfo ret = resourceSetMap.get(rs);
		if (ret != null) {
			if (!Objects.equals(ret.getEcoreResource(), ecore)) {
				System.err.println("Non-matching ecore resource for resource info: "+ret.getEcoreResource()+" VS "+ecore);
			}
		} else {
			resourceSetMap.put(rs, ret = new ResourceSetInfo(rs, ecore));
			ret.recalcBase();
			ret.loadResources();
			ret.recalcResources();
			
		}
		return ret;
	}
	
	public ResourceSetInfo(ResourceSet rs, Resource ecore) {
		this.rs = rs;
		this.ecore = ecore;
		this.ecoreFile = new VEcoreFileImpl(ecore);
		this.symbolRegistry = new SymbolRegistryImpl(new SymbolRegistryTypeImpl());
	}
	
	
	private static class TransformationExecutionInfo {
		public final String symbol;
		public final TransformationExecutor executor;
		public long resourceChangeTime;
		public final Resource res;
		
		public TransformationExecutionInfo(TransformationExecutor executor, String symbol, long resourceChangeTime, Resource res) {
			this.executor = executor;
			this.symbol = symbol;
			this.resourceChangeTime = resourceChangeTime;
			this.res = res;
		}
		
		public Resource getResource() {
			return res;
		}

		public String getSymbol() {
			return symbol;
		}
		
		public TransformationExecutor getExecutor() {
			return executor;
		}
		
		public long getResourceChangeTime() {
			return resourceChangeTime;
		}
	}
	
	private ModelProvider getModelProvider(ModelProvider base) {
		for (TransformationExecutionInfo executorInfo: transformationExecutors) {
			
			TransformationModelProviderImpl tpi = new TransformationModelProviderImpl(base.getType(),
					executorInfo.getSymbol(), ecore, base, executorInfo.getExecutor());
			base = tpi;
		}
		SymbolImpl newSymbol = new SymbolImpl("userDeltafor_"+base.getMainSymbol().getName());
		newSymbol.subObjects().addAll(base.getMainSymbol().subObjects());
		return new SimpleDeltaModelProviderImpl(newSymbol, ecore, base);
	}
	
	public ResourceSetInfo(ResourceSet rs) {
		this.rs = rs;
	}
	
	protected List<Resource> getBaseModelsInternal() {
		return baseModels;
	}
	
	private synchronized void recalcBase() {
		if (!changeDone) {
			return;
		}
		changeDone = false;
		//Gehe jede resource durch
		Map<String,TransformationExecutionInfo> transExec = new TreeMap<>();
		baseModels = new ArrayList<>();
		changeModels = new ArrayList<>();
		List<Resource> updateModels = new ArrayList<>();
		for (Resource res: new ArrayList<>(rs.getResources())) {
			
			URI uri = res.getURI();
			String[] spl = uri.toString().split("\\.");
			if (spl.length > 2 && "delta".equals(spl[spl.length-2])) {
				continue;
			}
			//Schaue, welcher typ es ist ... hier brauche ich wohl wieder eine Registry
			EPackage parent = null;
			for (EObject eobj: res.getContents()) {
				if (eobj instanceof EPackage) {
					//Ecore file, do not consider that
					break;
				}
				if (eobj.eClass() != null)  {
					parent = eobj.eClass().getEPackage();
					if (parent != null) {
						break;
					}
				}
			}
			if (parent == null) {
				continue;
			}
			String uriStr = uri.toString();
			
			String pkgUri = parent.getNsURI();
			//Je nachdem welcher Typ es ist kann es ein bestimmter Transformator sein
			//TransformatorGenerator
			TransformationExecutionInfo tei = curTeiMap.get(uriStr);
			if (tei == null  || tei.getResourceChangeTime() <= res.getTimeStamp()) {
				TransformatorGeneratorGenerator gen = getGeneratorOrNull(pkgUri);
				if (gen == null) {
					gen = getGeneratorOrNull(parent.getName());
				}
				if (gen != null) {
					//Wohl irgendeine nicht benötigte Resource
					TransformationExecutor executor = gen.getExecutor(res);
					if (executor != null) {
						tei = new TransformationExecutionInfo(executor, uriStr, res.getTimeStamp(), res);
						curTeiMap.put(res, tei);
					}
				} else {
					System.err.println("No generator found for "+pkgUri+" / "+parent.getName());
				}
				
			}
			if (tei != null) {
				changeModels.add(res);
				transExec.put(uriStr, tei);
			} else {
				//Jetzt haben wir mal das Package - schaue nach, was du dazu finden kannst
				//Check if base
				if (Objects.equals(parent.eResource(),ecore)) {
					//Das ganze ist ein Basis-Zeugs!
					baseModels.add(res);
					ResourceInfo prov = resourceInfos.get(res);
					if (prov == null) {					
						prov = new ResourceInfo(res);
						resourceInfos.put(res, prov);
						symbolRegistry.addProvider(prov.getBaseProvider());
					}
					continue;
				}
			}
		}
		resourceInfos.keySet().retainAll(baseModels);
		transformationExecutors = new ArrayList<>(transExec.values());
		//Usually you don't need to change things, you only need that on each save
	}
	
	public void recalcResources() {
		for (Entry<Resource, ResourceInfo> entr: resourceInfos.entrySet()) {
			ResourceInfo ri = entr.getValue();
			ri.recalc();
			ri.reexecuteTransformation(0);
		}
	}
	
	public TransformationExecutionInfo getTransformationInfoOrNull(Resource res) {
		return curTeiMap.get(res);
	}
	
	public ViewState createDefaultViewState() {
		ViewStateImpl ret = new ViewStateImpl();
		for (TransformationExecutionInfo tei: transformationExecutors) {
			ret.addToView(tei.getResource());
		}
		return ret;
	}
	
	public ViewState getContainedViewState() {
		return viewState;
	}
	
	private ViewState viewState = createDefaultViewState();
	
	public ModelProvider getViewProvider(Resource baseResource, ViewState curViewState) {
		ResourceInfo ri = resourceInfos.get(baseResource);
		ModelProvider ret = ri.calcSelectiveProvider(curViewState.enabledViews(), curViewState.disabledViews());
		return ret;
	}
	
	public ResourceInfo getResourceInfo(Resource baseResource) {
		return resourceInfos.get(baseResource);
	}

	public ModelProvider getCompleteProvider(Resource res) {
		ResourceInfo ret = getResourceInfo(res);
		if (ret != null) {
			return ret.getCompleteProvider();
		}
		return null;
	}

	public ModelProvider getBaseProvider(Resource res) {
		ResourceInfo ret = getResourceInfo(res);
		if (ret != null) {
			return ret.getBaseProvider();
		}
		return null;
	}
	
	public void thingSaved(Resource res) {
		changeDone = true;
		recalcBase();
		if (baseModels.contains(res)) {
			modelChanged(res);
		} else {
			TransformationExecutionInfo tei = getTransformationInfoOrNull(res);
			if (tei != null) {
				transformationChanged(tei);
			} else {
				//Do nothing
			}
		}
	}
	
	public void modelChanged(Resource model) {
		//Update the whole model ... incremental transformations would come in handy here btw.
		ResourceInfo ri = resourceInfos.get(model);
		if (ri != null) {
			ri.recalc();
			ri.reexecuteTransformation(0);
		}
		
	}
	
	public void transformationChanged(TransformationExecutionInfo tei) {
		int index = transformationExecutors.indexOf(tei);
		if (index != -1) {
			for (ResourceInfo bi: resourceInfos.values()) {
				bi.recalc();
				bi.reexecuteTransformation(index);
			}
		}
	}
	
	public List<Resource> getBaseModels() {
		recalcBase();
		return getBaseModelsInternal();
	}
	

	protected List<Resource> getChangeModelsInternal() {
		return changeModels;
	}
	
	public List<Resource> getChangeModels() {
		recalcBase();
		return getChangeModelsInternal();
	}
	
	
	

	
	public static void test1(String[] args) throws IOException {
	
		
		ResourceSet completeSet = new ResourceSetImpl();
		
		//Test ...
		Resource ecoreRes = OclExtractor.getEcore("model/router.ecore");
		completeSet.getResources().add(ecoreRes);
		Resource xmiRes = OclExtractor.getXMI("model/router.xmi", ecoreRes);
		completeSet.getResources().add(xmiRes);
		
		Resource trafoEcoreRes = OclExtractor.getEcore("model/ultraSimpleTransformation.ecore");		
		Resource basicTrafo = OclExtractor.getXMI("model/simpletrafo2.xmi", trafoEcoreRes);
		completeSet.getResources().add(basicTrafo);
		
		ResourceSetInfo rsi = ResourceSetInfo.getResourceSetInfo(completeSet, ecoreRes);

		VEcoreFile ecore = new VEcoreFileImpl(ecoreRes);

		ModelProvider completeProv = rsi.getViewProvider(xmiRes, new ViewStateImpl());
		SimpleModelView smv = new SimpleModelView(completeProv, ecore);
		Resource xmiResourceTransformed = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_blatransform.xmi"));
		smv.saveResource(xmiResourceTransformed);
		xmiResourceTransformed.save(new HashMap<>());
		
		ViewState untransformed = rsi.createDefaultViewState();
		untransformed.deleteFromView(basicTrafo);
		
		SimpleModelView smv2 = new SimpleModelView(rsi.getViewProvider(xmiRes, untransformed), ecore);
		Resource xmiResourceTransformed2 = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_blatransform_untransformed.xmi"));
		smv2.saveResource(xmiResourceTransformed2);
		xmiResourceTransformed2.save(new HashMap<>());
		
		ViewState fulltransformed = rsi.createDefaultViewState();
		fulltransformed.addToView(basicTrafo);
		
		SimpleModelView smv3 = new SimpleModelView(rsi.getViewProvider(xmiRes, fulltransformed), ecore);
		Resource xmiResourceTransformed3 = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_blatransform_fulltransformed.xmi"));
		smv3.saveResource(xmiResourceTransformed3);
		xmiResourceTransformed3.save(new HashMap<>());
		
		ModelProvider completeProv4 = rsi.getViewProvider(xmiRes, new ViewStateImpl());
		SimpleModelView smv4 = new SimpleModelView(completeProv, ecore);
		Resource xmiResourceTransformed4 = xmiRes.getResourceSet().createResource(URI.createFileURI("model/router_blatransform2.xmi"));
		smv4.saveResource(xmiResourceTransformed4);
		xmiResourceTransformed4.save(new HashMap<>());
	}
	
	public static void main(String[] args) throws IOException {

		HenshinResourceSet completeSet = new HenshinResourceSet("model");

		
		//Test ...
		Resource ecoreRes = OclExtractor.getEcore("model/Simplejava.ecore");
		completeSet.getResources().add(ecoreRes);
		Resource xmiRes = OclExtractor.getXMI("model/test.sjava.xmi", ecoreRes);
		completeSet.getResources().add(xmiRes);
		
		//Resource trafoEcoreRes = OclExtractor.getEcore("model/henshin.ecore");		
		//Resource basicTrafo = OclExtractor.getXMI("model/addcondition.henshin", trafoEcoreRes);
		Resource basicTrafo = completeSet.getResource(URI.createFileURI("addcondition.henshin"),true); 
		//completeSet.getResources().add(basicTrafo);
		
		ResourceSetInfo rsi = ResourceSetInfo.getResourceSetInfo(completeSet, ecoreRes);
		VEcoreFile ecore = new VEcoreFileImpl(ecoreRes);
		//rsi.loadResources();
		SimpleModelCorrespondance corr = null;
		{
			ModelProvider basicProv = rsi.getBaseProvider(xmiRes);
			SimpleModelView smv = new SimpleModelView(basicProv, ecore);
			Resource xmiResource = completeSet.createResource("java_saved_init.xmi");
			corr = smv.saveResource(xmiResource);
			xmiResource.save(Collections.emptyMap());
			rsi.recalcResources();
			ModelProvider completeProv = rsi.getViewProvider(xmiRes, new ViewStateImpl());
			SimpleModelView csmv = new SimpleModelView(completeProv, ecore);
			
			SimpleModelCorrespondance subcorr = new SimpleModelCorrespondance();
			//smv.getTransformationCreater(new SymbolImpl("bla"), corr, subcorr)
			SimpleModelEqualizer eq = new SimpleModelEqualizer(csmv.exposeContents(), xmiResource.getContents(), corr, subcorr, 
					InstanceCreator.DEFAULT);
			eq.equalize();
			try (FileOutputStream fos = new FileOutputStream("model/java_saved_init_trafo.xmi")) {
				xmiResource.save(fos, Collections.emptyMap());
			}
		}
		
		
	/*	{
			ModelProvider completeProv = rsi.getViewProvider(xmiRes, new ViewStateImpl());
			SimpleModelView smv = new SimpleModelView(completeProv, ecore);
			Resource xmiResourceTransformed = xmiRes.getResourceSet().createResource(URI.createFileURI("java_transformed.xmi"));
			smv.saveResource(xmiResourceTransformed);
			xmiResourceTransformed.save(new HashMap<>());
		}


		rsi.recalcResources();
		{
			ModelProvider completeProv = rsi.getViewProvider(xmiRes, new ViewStateImpl());
			SimpleModelView smv = new SimpleModelView(completeProv, ecore);
			Resource xmiResourceTransformed = xmiRes.getResourceSet().createResource(URI.createFileURI("java_transformed2.xmi"));
			smv.saveResource(xmiResourceTransformed);
			xmiResourceTransformed.save(new HashMap<>());
		}*/
		
	}


	public List<Resource> getAllViews() {
		List<Resource> ret = new ArrayList<>(changeModels);
		for (ResourceInfo ri: this.resourceInfos.values()) {
			ret.addAll(ri.deltaResources);
		}
		return ret;
	}


	public Resource getAspectResource(ModelResource resource) {
		Symbol symbol = resource.getProvider().getMainSymbol();
		return symbolNameToResource.get(symbol);
	}

	

}
