package at.ac.tuwien.big.virtualxtext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IEventConsumer;
import org.eclipse.jface.text.ITextStore;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.IAnnotationModelExtension2;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

import com.google.inject.Injector;

import at.ac.tuwien.big.multimodeldesc.MMDescStandaloneSetup;
import at.ac.tuwien.big.multimodeldesc.mMDesc.MMDesc;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRef;
import at.ac.tuwien.big.verocl.parameterdesc.PseudoModelRefImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiModelPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiPointImpl;
import at.ac.tuwien.big.virtmod.multiref.ConvertMMDesc;
import at.ac.tuwien.big.virtmod.multiref.ModelRef;
import at.ac.tuwien.big.virtmod.multiref.ConvertMMDesc.MMDescWrapper;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.NoInverse;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.ecore.VProjectedModelView;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.SimpleModelProvider;
import at.ac.tuwien.big.vmod.provider.impl.SimpleEcoreModelProviderImpl;
import at.ac.tuwien.big.vmod.registry.MultiLoader;
import at.ac.tuwien.big.vmod.registry.MultiResourceSetInfo;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationSource;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ResourceInfo;
import at.ac.tuwien.big.vmod.registry.ViewState;
import at.ac.tuwien.big.vmod.registry.ViewStateImpl;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.MyEcoreUtilInstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.impl.ParentChildModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.DocumentChanger;
import at.ac.tuwien.big.xtext.util.IteratorUtils;
import at.ac.tuwien.big.xtext.util.ui.AnnotationTree;

public class MultiXtextEditor extends XtextEditor {
	
	
	public static final String ANNOTATION_TYPE_TARGET = "GENERATED_MODEL_ANNOTATION_TARGET";
	public static final String ANNOTATION_TYPE_GENERATED = "GENERATED_MODEL_ANNOTATION_GENERATED";
	public static final String ANNOTATION_TYPE_FULLGENERATED = "GENERATED_MODEL_ANNOTATION_FULLGENERATED";
	public static final String ANNOTATION_TYPE_NONGENERATED = "GENERATED_MODEL_ANNOTATION_NONGENERATED";
	public static final String MARKER_TYPE_TARGET = "simplejava.isgenerated.target";
	public static final String MARKER_TYPE_GENERATED = "simplejava.isgenerated.generated";
	public static final String MARKER_TYPE_FULLGENERATED = "simplejava.isgenerated.fullgenerated";
	public static final String MARKER_TYPE_NONGENERATED = "simplejava.isgenerated.nongenerated";

	private static Object watchObject;
	
	//Wird startend mit der aktuellen Datei eingelesen --> Garantiert die eindeutigkeit des Roots!
	private List<ModelRef> allModelRoots = new ArrayList<ModelRef>();
	private VProjectedModelView completeModel;
	private VProjectedModelView projectedModel;
	private FakeProjector projector = (x)->true;

	
	private Map<Object,XtextResource> readModels = new HashMap<>();
	
	/*private ResourceSetInfo curInfo;
	private ResourceInfo curResourceInfo;
	*/
	private List<EObject> myResourceList = new ArrayList<EObject>();
	
	static {
		System.out.println("MultiXtextEditor is used!");
		
	}
	
	ViewState curView;
	
	public Collection<ModelRef> allModels() {
		Set<ModelRef> ret = new HashSet<ModelRef>(allModelRoots);
		Stack<ModelRef> add = new Stack<ModelRef>();
		for (ModelRef r: allModelRoots) {
			for (ModelRef sub: r) {
				ret.add(sub);
			}
		}
		return ret;
	}
	
	public void reproject() {
		List<PseudoModelRef> pmr = new ArrayList<PseudoModelRef>();
		ViewState state = curInfo.getContainedViewState();
		boolean empty = state.enabledViews().isEmpty();
		for (ModelRef ref: allModels()) {
			String uri = ref.getURI();
			if (empty || state.resourceUriEnabled(uri)) {
				pmr.add(new PseudoModelRefImpl(ref.getURI(), ref.getURI()));
				pmr.add(new PseudoModelRefImpl(ref.getURI(), ref.getPoints().getValues()));
			}
		}
		MultiModelPointImpl mmpi = new MultiModelPointImpl(PointDesc.SINGLESTRING,pmr);
		projectedModel = completeModel.project(mmpi);
		
	}
	
	public static Resource getEcoreRes(Resource my) {
		//TODO: Wäre es nicht viel gescheiter, die ECore-Resource irgendwo statisch zu hinterlegen?
		Resource ecoreRes = null;
		/*for (Resource subres: my.getResourceSet().getResources()) {
			List<EObject> contents = subres.getContents();
			if (!contents.isEmpty() && contents.iterator().next() instanceof EPackage) {
				//It's an ecore!
				System.out.println("Found ecore!");
				ecoreRes = subres;
			}
		}*/
		if (ecoreRes == null) {
			List<EObject> contents = my.getContents();
			if (!contents.isEmpty()) {
				ecoreRes = contents.iterator().next().eClass().eResource();
				System.out.println("Found ecore with checking file ...");
			}
		} 
		return ecoreRes;
	}
	
	public static URI switchFile(URI fromFile, String newFile) {
		String str = fromFile.toString();
		int lastInd = str.lastIndexOf('/');
		if (lastInd >= 0) {
			return URIConverter.INSTANCE.normalize(URI.createURI(str.substring(0,lastInd+1)+newFile)); 			
		}
		return null;
				
	}
	
	private boolean inInit = false;
	private boolean ignore = false;
	
	private static URI nrm(URI from)  {
		return URIConverter.INSTANCE.normalize(from);
	}
	
	private static URI nrm(java.net.URI from)  {
		return nrm (URI.createURI(from.toString()));
	}
	
	
	private void addFilesToResourceSet(ResourceSet rs, IContainer cont, List<Resource> toAdd) {
		try {
			for (IResource res: cont.members()) {
				if (!res.isAccessible() || res.isHidden()) {
					continue;
				}
				if (res instanceof IProject) {
					IProject proj = (IProject)res;
					if (!proj.isOpen()) {
						continue;
					}
					
				}
				if (res instanceof IContainer) {
					addFilesToResourceSet(rs,(IContainer)res,toAdd);
				} else if (res instanceof IFile){
					IFile ifile = (IFile)res;
					String fn = ifile.getName();
					/*if (fn.startsWith("simple") && fn.endsWith(".xmi")) {
						//take it
						toAdd.add(rs.getResource(nrm(ifile.getLocationURI()),true));
					}
					if (fn.endsWith(".vaspect")) {
					v	toAdd.add(rs.getResource(nrm(ifile.getLocationURI()),true));
					}
					if (fn.endsWith(".henshin")) {
						toAdd.add(rs.getResource(nrm(ifile.getLocationURI()),true));
					}*/
					
				} else {
					System.err.println("Unknown resource "+res);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getModelResourceCount() {
		return loader.getModelResourceCount();
	}
	
	private List<ModelResource> getAllModelResources() {
		if (loader == null) {
			return Collections.emptyList();
		}
		return new ArrayList<>(loader.getModelResources());
	}
	
	private MultiLoader loader;
	private MultiResourceSetInfo curInfo;

	private boolean isVirtualBase() {
		String str = getXtextResource().getURI().toString();
		int lastSep = str.lastIndexOf('/');
		if (lastSep != -1) {
			str = str.substring(lastSep+1);
		}
		String[] parts = str.split("\\.");
		if (parts.length < 3) {
			return false;
		}
		return "virtual".equals(parts[parts.length-2].toLowerCase());
	}
	
	static {
		//new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri(".");
		MMDescStandaloneSetup.doSetup();
	}
	
	public MMDesc loadVirtualDesc(InputStream in) {
		Injector injector = new MMDescStandaloneSetup().createInjectorAndDoEMFRegistration();
		 XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		 resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		 Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.mmdesc"));
		 try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 List<EObject> obj = resource.getContents();
		 if (!obj.isEmpty()) {
			 return (MMDesc)obj.get(0);
		 }
		 return null;
	}
	
	public MMDesc loadVirtualDesc(String str) {
		return loadVirtualDesc( new ByteArrayInputStream(str.getBytes()));
	}
	
	public void initModel(IXtextDocument doc) {
		if (inInit) {return;}

		
		inInit = true;
		
		String firstText;
		Resource[] takenRes = new Resource[1];
		String[] mainText = new String[1];
				
		if (isVirtualBase()) {
			//This is the virtualThing really!
			MMDesc virtualModel = loadVirtualDesc(doc.get());
			doc.readOnly((res)-> {
				ResourceSet rs = getXtextResource().getResourceSet();
				
				//Die resource enthält hier eben NICHT das korrekte Ecore, wenn überhaupt
				//Aber das macht nichts, ich sollte sie bekommen, sobald ich irgendeine Ressource lade ..
				MMDescWrapper wrapper = ConvertMMDesc.convertMMDesc(virtualModel);
				allModelRoots = wrapper.getRootRefs();
				//Get any model and the Ecore resource from there
				Resource ecoreRes = null;
				for (ModelRef model: allModels()) {
					try {
						String uri = model.getURI();
						Resource tempRes = rs.getResource(normalizeURI(uri), true);
						try{
							if (mainText[0] == null) {
								ByteArrayOutputStream os = new ByteArrayOutputStream();
								tempRes.save(os, Collections.emptyMap());
								mainText[0] = os.toString("UTF-8");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						ecoreRes = getEcoreRes(tempRes);
						if (ecoreRes != null) {
							
							break;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
						try {
							URI fileUri = URIConverter.INSTANCE.normalize(URI.createFileURI(new File(model.getURI()).getCanonicalPath()));
							System.out.println("File URI: "+fileUri);
							Resource tempRes = rs.getResource(fileUri, true);
							ecoreRes = getEcoreRes(tempRes);
							if (ecoreRes != null) {
								break;
							}
						} catch (Exception e2) {
							System.err.println(e.getMessage());
							e.printStackTrace();
							e2.printStackTrace();
						}
					}
				}
				
				loader = new MultiLoader(ecoreRes);
				for (ModelRef rootModel: wrapper.getRootRefs()) {
					loader.loadRoot(rs, rootModel);
				}
				
				
				String fullPath = res.getURI().toFileString();
				if (fullPath == null) {
					fullPath = res.getURI().toString();
				}
				
				String[] extRef = new String[1];
				String basePath = ModelRef.withoutExt(fullPath, extRef);
				String ext = extRef[0];
				//read ModelRef - unfortunately it has xtext things !!
				int[] index = new int[]{1};
				curInfo = MultiResourceSetInfo.getResourceSetInfo(loader);
				curView = curInfo.getContainedViewState();
				completeModel = loader.getModelView();
				reproject();
				//You need to set the text! - this is not too difficult, you just need to copy a model and then change it
				//it would also be good to copy the formatting of other resources for their objects ... but we can't have everything
				
				
				return null;
			});
			if (mainText[0] != null) {
				doc.set(mainText[0]);
			}
		} else {

			//Jetzt muss ich aber auch noch die einzelnen Modelle laden
			//Außerdem muss ich berücksichtigen, dass ich ja Xtext-Dateien lade
			//Nicht wirklich, wenn ich ein gutes ResourceSet habe
			doc.readOnly((res)-> {
				ResourceSet rs = getXtextResource().getResourceSet();
				Resource ecoreRes = getEcoreRes(res);
				
				String fullPath = res.getURI().toFileString();
				if (fullPath == null) {
					fullPath = res.getURI().toString();
				}
				
				String[] extRef = new String[1];
				String basePath = ModelRef.withoutExt(fullPath, extRef);
				String ext = extRef[0];
				//read ModelRef - unfortunately it has xtext things !!
				int[] index = new int[]{1};
				ModelRef root = ModelRef.modelRefOrNull(index, rs, basePath, ext, PointDesc.SINGLESTRING);
				
				loader = new MultiLoader(ecoreRes);
				
				loader.loadRoot(rs, root);			
				curInfo = MultiResourceSetInfo.getResourceSetInfo(loader);
				completeModel = loader.getModelView();
				allModelRoots = Collections.singletonList(root);
				reproject();
				return null;
			});
		}
		
		

		getAnnotationSizeUpdateRemove();
		updateXtext(getDocument());
		
		inInit = false;
		
	}
	
	private URI normalizeURI(String uri) {
		return URIConverter.INSTANCE.normalize(URI.createURI(uri));
	}

	/*IXtextModelListener listener = new IXtextModelListener() {
		
		@Override
		public void modelChanged(XtextResource resource) {
			refreshMarkers();
		}
	};*/
	
	private IXtextDocument lastDoc = null;
	
	public XtextResource getXtextResource() {
		IXtextDocument doc = super.getDocument();
		return doc.readOnly((x)->x);
	}
	
	public IXtextDocument getDocument() {
		IXtextDocument doc = super.getDocument();
		if (doc != lastDoc && doc != null && !inInit) {
			initModel(doc);
			lastDoc = super.getDocument();
		}
		/*if (doc != null) {
			doc.addModelListener(listener);
		}*/
		return doc;
	}
	
	public void bla() {
		super.getDocumentProvider();
	}
	
	@Override
	public void doSaveAs() {
		super.doSaveAs();
	}
	
	private static MethodHandle getStore;
	
	public static ITextStore getStore(AbstractDocument doc) {
		if (getStore == null) {
			Method m;
			try {
				m = AbstractDocument.class.getDeclaredMethod("getStore");
				m.setAccessible(true);
				getStore = MethodHandles.lookup().unreflect(m);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		try {
			return (ITextStore)getStore.invoke(doc);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static final PointDesc MAIN_DESC = PointDesc.SINGLESTRING;
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			refreshMarkers();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResourceSet rs = getXtextResource().getResourceSet();
		Map<URI,String> savedText = new HashMap<>();

		//TODO: not a good solution
		/*ViewState oldView = curView;
		curView = new ViewStateImpl();
		reproject();*/
		//super.doSave(monitor);
		/*
		 * 
		 */
		loader.resyncResources();
		loader.saveResources();
		//curView = oldView;
		//reproject();
		
		/*for (ModelRef allRef: allModels) {
			VProjectedModelView vp = completeModel.project(new MultiPointImpl(MAIN_DESC,new String[]{allRef.getURI()}));
			URI uri = URI.createURI(allRef.getURI());
			String modelText = getModelText(vp);
			
			savedText.put(uri, modelText);
		}
		for (Entry<URI,String> entr: savedText.entrySet()) {
			try (OutputStream fos = URIConverter.INSTANCE.createOutputStream(entr.getKey())) {
				fos.write(entr.getValue().getBytes());
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/	
	}
	
	public Symbol getReferencedUUID(MarkerAnnotation annotation) {
		Object ret;
		try {
			ret = annotation.getMarker().getAttribute("uuid");
			if (ret == null) {
				return null;
			}
			if (ret instanceof Symbol) {
				return (Symbol)ret;
			} else {
				return Symbol.fromFull(String.valueOf(ret)); 
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

	public Symbol getContainingObjectUUID(Symbol sub) {
		return completeModel.getContainingObjectUuid(sub);
	}
	
	public String getContainingObjectUUID(String sub) {
		Symbol ret = completeModel.getContainingObjectUuid(Symbol.fromFull(sub));
		if (ret != null) {
			return ret.toString();
		}
		return null;
	}

	public Symbol pickDeepestUuid(List<Symbol> uuids) {
		Set<Symbol> possible = new HashSet<>(uuids);
		for (Symbol sub: uuids) {
			possible.remove(getContainingObjectUUID(sub));
		}
		if (!possible.isEmpty()) {
			return possible.iterator().next();
		}
		return null;
	}
	
	public Symbol pickDeepest(List<Symbol> str) {
		Symbol ret = pickDeepestUuid(str);
		if (ret != null) {
			return ret;
		}
		return null;
	}	
	
	private List<Annotation> toRemove = new ArrayList<>();
	
	public Map<MarkerAnnotation,Integer> getAnnotationSizeUpdateRemove() {
		IAnnotationModel annotationmodel = getSourceViewer().getAnnotationModel();
		Map<MarkerAnnotation,Integer> annotationSize = new HashMap<>();
		toRemove = new ArrayList<Annotation>();
		
		{
			Iterator<?> it = annotationmodel.getAnnotationIterator();
			//Sortiere zuerst nach Größe
			while (it.hasNext()) {
				Object o  = it.next();
				if (o instanceof MarkerAnnotation ) {

					MarkerAnnotation ann = (MarkerAnnotation)o;
					String type = ann.getType();
					if (type == null) {continue;}
					if (type.startsWith(ANNOTATION_TYPE_GENERATED) || type.startsWith(ANNOTATION_TYPE_FULLGENERATED) ||  
							type.startsWith(ANNOTATION_TYPE_NONGENERATED) || type.startsWith(ANNOTATION_TYPE_TARGET)) {
						toRemove.add(ann);
					}
					if (!ANNOTATION_TYPE_TARGET.equals(type)) {
						continue;
					}
					Position pos = annotationmodel.getPosition(ann);
					annotationSize.put(ann, pos.getLength());
				}
			}
		}
		return annotationSize;
	}
	
	public SimpleModelCorrespondance buildCorrespondanceFromXtext(SimpleModelCorrespondance ret, Resource state) {
		//Get positions of elements
		AnnotationTree<MarkerAnnotation> fakeTree = new AnnotationTree<>(null, null, 0, Integer.MAX_VALUE);
		Map<MarkerAnnotation,Integer> annotationSize = getAnnotationSizeUpdateRemove();
		IAnnotationModel annotationmodel = getSourceViewer().getAnnotationModel();
		
		List<MarkerAnnotation> annotationList = new ArrayList<>();
		annotationList.addAll(annotationSize.keySet());
		Collections.sort(annotationList, new Comparator<Annotation>() {

			@Override
			public int compare(Annotation o1, Annotation o2) {
				return -Integer.compare(annotationSize.get(o1), annotationSize.get(o2));
			}
		});

		for (MarkerAnnotation an: annotationList) {
			Position pos = annotationmodel.getPosition(an);
			fakeTree.tryAdd(an, pos.getOffset(), pos.getOffset()+pos.getLength());
		}
	
		//Map<String,Map<String,Map<String,String>>> containmentMap = changeBaseModel.getContainmentNameMap();
		//Type, Container, Name, Object
		
		for (EObject eobj: (Iterable<EObject>)()->state.getAllContents()) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(eobj);
			if (node == null) {
				System.err.println("No node found for "+eobj+"!");
				continue;
			}
			int start = node.getTotalOffset();
			int end = node.getTotalEndOffset();
			start = node.getOffset();
			end = node.getEndOffset();
			//mit etwas glück ist das mit dem offset nichts komplett anderes sondern noch immer
			//in der datei und damit nur etwas kleiner und hat eine höhere Wahrscheinlichkeit, eine passende Annotation zu erhalten
			
			//Suche: kleinste Annotation, die das vollständig enthält
			List<MarkerAnnotation> candidates = fakeTree.getMostSpecificAnnotations(start, end);
			List<Symbol> uuids = new ArrayList<>();
			for (MarkerAnnotation annot: candidates) {
				Symbol uuid = getReferencedUUID(annot);
				if (uuid != null) {
					uuids.add(uuid);
				} else {
					System.err.println("Strange Marker Annotation: "+annot);
					IMarker marker = annot.getMarker();
					Map<String, Object> attrs;
					try {
						attrs = marker.getAttributes();
						System.out.println("Attributes: "+attrs);
						System.out.println("UUID: "+attrs.get("uuid"));
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (uuids.isEmpty()) {
				//No match, that's fine ... - the element has been newly inserted
				System.out.println("NO match for "+eobj+"!");
			} else {
				//You need to pick the correct one, i.e. the most deeply nested one
				//But also the one with the best matching class ...
				
				//find matching class
				int matchingClassQuality = 0;
				Set<EClass> allClasses = new HashSet<EClass>();
				EClass curCl = eobj.eClass();
				allClasses.add(curCl);
				allClasses.addAll(curCl.getEAllSuperTypes());
				List<Symbol> matchingSymbol = new ArrayList<>();
				for (Symbol uuid: uuids) {
					EObject tryObject = completeModel.getEObject(uuid);
					EClass tryClass;
					if (tryObject != null && (tryClass = tryObject.eClass()) != null) {
						Set<EClass> testClasses = new HashSet<EClass>(tryClass.getEAllSuperTypes());
						testClasses.add(tryClass);
						testClasses.retainAll(allClasses);
						int curMatchQuality = testClasses.size();
						if (curMatchQuality > matchingClassQuality) {
							matchingSymbol.clear();
							matchingClassQuality = curMatchQuality;
						}
						if (curMatchQuality >= matchingClassQuality) {
							matchingSymbol.add(uuid);	
						}
					}
				}
				Symbol pickedStr = pickDeepest(matchingSymbol);
				if (pickedStr != null) {
					EObject pickedView = completeModel.getEObject(pickedStr);
					//Check if this is not at the same time a match of a contained object
					EObject curComp = eobj.eContainer();
					//Da muss man nicht irgendwie zwischenspeichern, weil der Iterator zuerst parent, dann child traversiert
					while (curComp != null) {
						if (Objects.equals(ret.getRightObject(curComp),pickedView)) {
							pickedView = null;
							System.out.println("NO real match for "+eobj+"!");									
							break;
						}
						curComp = curComp.eContainer();
					}
					if (pickedView != null) {
						ret.putCorrespondence(eobj, pickedView);
						System.out.println("Associate: "+Arrays.toString(uuids.toArray())+" --> "+pickedView+ " for "+eobj);
					}
				} else {
					System.err.println("Could not pick deepest for "+uuids);
					pickDeepest(uuids);
				}
			} 
		}
		return ret;
	}
	
	private int newObjInd = 0;
	
	public void updateVirtualModel(XtextResource state) {
		xtextToViewCorrespondance = buildCorrespondanceFromXtext(xtextToViewCorrespondance,state);
		//TODO: Clear from time to time
		//TODO: Vielleicht muss man auch bei den Aspekten das so aktualisieren?
		//Build correspondance map based on annotations
		SimpleModelCorrespondance newCorr = new SimpleModelCorrespondance();
		//Replace all EObjects
		for (Entry<EObject,EObject> eobj: xtextToViewCorrespondance.getEntriesL2R()) {
			EObject left = eobj.getKey();
			EObject right = eobj.getValue();
			if (left instanceof VMEObject) {
				left = projectedModel.getEObject(((VMEObject) left).getUUID());
			}
			if (right instanceof VMEObject) {
				right = projectedModel.getEObject(((VMEObject) right).getUUID());
			}
			newCorr.putCorrespondence(left, right);
		}
		xtextToViewCorrespondance = newCorr;
		
		SimpleModelCorrespondance nullcorr = new SimpleModelCorrespondance();
		
		//Für die doch nicht existierenden
		InstanceCreator creator = new InstanceCreator() {
			
			@Override
			public EObject createInstance(EObject cont, EClass cl) {
				
				Symbol newSymbol = Symbol.buildFrom("virtual", ++newObjInd);
				VObjectValues val = projectedModel.getInstances();
				val.add(newSymbol);
				val.setClass(newSymbol, cl);
				System.out.println("Creating "+ cl.getName()+" for id "+newSymbol);
				if ("EClass".equals(cl.getName())) {
					System.err.println("Creating eclass?!");
				}
				return projectedModel.getEObject(newSymbol);
			}
		};
		System.out.println("Root objects init: "+myResourceList+" VS "+state.getContents());
		
		
		/*Resource test1 = new ResourceImpl();
		projectedModel.saveResource(test1);*/
		System.out.println("View model before equalizing");
		
		myResourceList = projectedModel.exposeContents();
		
		SimpleModelEqualizer equalizer = new SimpleModelEqualizer(
				state.getContents(), myResourceList,
				nullcorr, xtextToViewCorrespondance, creator);
		
		equalizer.equalize();
		
		System.out.println("Equalized model: "+projectedModel);
		
		System.out.println("Complete model: "+completeModel);
	}
	
	Resource fake;
	
	public Resource getFakeXtextResource() {
		if (fake == null) {
			String thisExtension = getResource().getFileExtension();
			fake = getXtextResource().getResourceSet().createResource(URI.createURI("http://tempresource/temp."+thisExtension));
		}
		return fake;
	}
	
	public String getModelText(VModelView model) {
		if (ignore) {
			return "";
		}		
		Resource fake = getFakeXtextResource();
		fake.getContents().clear();
		SimpleModelCorrespondance smi = model.saveResource(fake);
		
		Map<Symbol,EObject> symbolToSaved =new HashMap<>();
		for (Entry<EObject,EObject> entry: smi.getEntriesL2R()) {
			VMEObject vme = (VMEObject)entry.getKey();
			symbolToSaved.put(vme.getUUID(), entry.getValue());
		}
		//TODO: Add Annotations ...
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			fake.save(bos, Collections.emptyMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bos.toString();
	}
	
	
	
	public static final int MAX_ANNOTATION_COLORS = 10;
	
	Map<ModelResource,Integer> usedIntegers = new HashMap<>();
	
	private int getInteger(ModelResource myRes) {
		int tryRet = myRes.getProvider().getIndex();
		if (tryRet > 0) {
			return tryRet-1;
		}
		if (myRes == null) {
			return -1;
		}
		Integer ret = usedIntegers.get(myRes);
		if (ret != null) {
			return ret;
		}
		boolean[] usedIntegersB = new boolean[MAX_ANNOTATION_COLORS]; 
		for (Integer val: usedIntegers.values()) {
			if (val != null && val >= 0 && val < usedIntegersB.length) {
				usedIntegersB[val] = true;
			}
		}
		for (int i = 0; i < usedIntegersB.length; ++i) {
			if (!usedIntegersB[i]) {
				usedIntegers.put(myRes, i);
				return i;
			}
		}
		usedIntegers.put(myRes, -1);
		return -1;
	}
	
	public ModelResource getStoredRes(Resource r) {
		List<ModelResource> allRes = getAllModelResources();
		for (ModelResource res: allRes) {
			if (Objects.equals(r.getURI(),res.getURI())) {
				return res;
			}
		}
		return null;
	}
	
	private int getInteger(Resource myRes) {
		ModelResource res = getStoredRes(myRes);
		for (ModelProvider prov: loader.getProviders()) {
			Resource r = loader.getResource(prov);
			if (Objects.equals(r, myRes)) {
				if (prov.getIndex()>  0)
					return prov.getIndex()-1;
				res = prov.getResultModel();
			}
		}
		if (res == null) {
			System.err.println("Could not get integer for resource "+myRes);
			return -1;
		}
		return getInteger(res);
	}
	
	public void updateXtext(IXtextDocument doc) {
		try {
		SimpleModelCorrespondance newlyCreated = new SimpleModelCorrespondance();
		SimpleModelCorrespondance nullcorr = new SimpleModelCorrespondance();
		ParentChildModelCorrespondance original = new ParentChildModelCorrespondance(nullcorr, xtextToViewCorrespondance);
		ModelCorrespondance inverse = original.inverse();
		Map<String,EObject> oldObjects = new HashMap<String, EObject>();
		XtextResource[] lastState = new XtextResource[1];
		boolean cont = doc.readOnly((state)->{
			lastState[0] = state;
			
			InstanceCreator myEcoreCreater = new MyEcoreUtilInstanceCreator();
			
			
			System.out.println("Regenerated model: "+projectedModel);
			
			/*Resource test = new ResourceImpl();
			projectedModel.saveResource(test); 
			
			EObject simpleJava = null;
			for (EObject eobj: test.getContents()) {
				if (eobj.eClass() != null && "SimpleJava".equals(eobj.eClass().getName())) {
					simpleJava = eobj;
				}
			}*/
						
			//Now there are new things ... regenerate the model and annotations
			//Use the inverse correspondance map

			myResourceList = projectedModel.exposeContents();
			
			
			
			System.out.println("Root objects before rev: "+myResourceList+" VS "+state.getContents());
			SimpleModelEqualizer reverseEqualizer = new SimpleModelEqualizer(
					myResourceList, state.getContents(), 
					inverse, newlyCreated, myEcoreCreater);
			for (Entry<EObject,EObject> entry: newlyCreated.getEntriesR2L()) {
				xtextToViewCorrespondance.putCorrespondence(entry.getKey(), entry.getValue());
			}
			System.out.println("Full model: "+projectedModel.toContentString());
			String oldCont = getDocument().get();
			reverseEqualizer.equalize();
			String newContent;
			try {
				newContent = getContent(state);				
				System.out.println("New content: "+newContent);
			} catch (Exception e) {
				e.printStackTrace();
				//runAfter[0] = ()->{};
				return false;
			}
			
			for (EObject eobj: (Iterable<EObject>)()->state.getAllContents()) {
				oldObjects.put(state.getURIFragment(eobj),eobj);
			}
			DocumentChanger.modify(oldCont, newContent, getDocument());
			XtextResource oldState = state;
			System.out.println("Root objects After execute: "+myResourceList+" VS "+state.getContents());
			return true;
		});
		
		
		
		//RunAfter

		 doc.modify(new IUnitOfWork<Object, XtextResource>(){	

				@Override
				public Object exec(XtextResource state) throws Exception {
					
					System.out.println("Root objects After execute II: "+myResourceList+" VS "+state.getContents());
					for (EObject eobj: state.getContents()) {
						try {
							System.out.println("Contained in Resource: "+state.getSerializer().serialize(eobj));
						}  catch (Exception e) {
							e.printStackTrace();
						}
						break;
					} 
					
				String newContent = doc.get();
				System.out.println(newContent);
				//Now you have the new model, set the document to the new Model and update the annotations accordingly
				
				//Change the document now
				//reverseEqualizer.equalize();
				
				//DocumentChanger.modify(doc.get(), doc, ()->reverseEqualizer.equalize(),	state);
				
				//TODO: In principle, you could derive annotations from modifications base --> final
				//It's not as exact, but faster and many aspects can be implemented easier
				
				ParentChildModelCorrespondance targetCorrespondance = new ParentChildModelCorrespondance(inverse, newlyCreated);
				
				//This correspondance will tell you for each EObject the corresponding EObject
				//You can assume that the structure of both models is the same, so you can derive sources
				
				//You need to associate a function ICompositeNode[offset,length] --> Annotation
				//It is easy for Objects (target), but what about features?
				
				Map<Annotation,Position> newAnnotations = new HashMap<Annotation, Position>();
				List<EObject> targetEObject = new ArrayList<EObject>();
				IResource res = getResource();  
				for (EObject eobj: (Iterable<EObject>)()->state.getAllContents()) {
					targetEObject.add(eobj);
					ICompositeNode node = NodeModelUtils.findActualNodeFor(eobj);
					if (node == null) {
						System.err.println("Could not find node for "+eobj);
						continue;
					}
					int start = node.getOffset();
					int end = node.getEndOffset();
					
					//Targets
					VMEObject uuidObj = (VMEObject)targetCorrespondance.getLeftObject(eobj);
					EObject searchObj = null;
					if (uuidObj == null) {
						searchObj = oldObjects.get(eobj.eResource().getURIFragment(eobj));
						uuidObj = (VMEObject)targetCorrespondance.getLeftObject(searchObj);
					}
					if (uuidObj == null) {
						System.err.println("Could not find object for "+eobj);
						continue;
					}
					String uriFragment = eobj.eResource().getURIFragment(eobj);
					Symbol uuid = uuidObj.getUUID();
					IMarker marker = res.createMarker(MARKER_TYPE_TARGET);
					marker.setAttribute(IMarker.MESSAGE, "Target Object: "+uuid);
					marker.setAttribute("uuid", uuid);
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
					marker.setAttribute(IMarker.CHAR_START, start);
					marker.setAttribute(IMarker.CHAR_END, end);
					SimpleMarkerAnnotation annotation = new SimpleMarkerAnnotation(ANNOTATION_TYPE_TARGET, marker);
					newAnnotations.put(annotation, new Position(start, end-start));
					
					//node.getChildren()
					
					
					EClass cl = eobj.eClass();
					List<ModelResource> userModelResources = getAllModelResources();
					//How to calculate?
					
					
					for (EStructuralFeature esf: cl.getEAllStructuralFeatures()) {
						List<INode> inodes = NodeModelUtils.findNodesForFeature(eobj, esf);
						VFeatureValues vfv = projectedModel.getFeatureValues(esf);
						List<Object> vfvList = vfv.getValueValue(uuid);
						System.out.println("Values: "+Arrays.toString(vfvList.toArray())+ " For feature "+esf.getEContainingClass().getName()+"."+esf.getName());
						if (esf.getName().equals("source")) {
							watchObject = vfv;
							System.out.print("xx");
						}
						List<ResourceSetInfo.ExactDerivationStatus> derivationStatus = new ArrayList<>();
						if (vfvList instanceof NoInverse) {
							derivationStatus = ((NoInverse) vfvList).getDerivationStatus(userModelResources);
						}
						
						int index = 0;
						for (INode supnode: inodes) {
							Iterable<ILeafNode> leafNodes;
							if (supnode instanceof ILeafNode) {
								leafNodes = Collections.singleton((ILeafNode)supnode);
							} else {
								leafNodes = supnode.getLeafNodes();
								//Eigentlich nur die Leaf-Nodes, die nicht von Unteren erzeugt werden ...
							}

							ResourceSetInfo.ExactDerivationStatus fullgenstate = derivationStatus.size()<=index?new ExactDerivationStatus():derivationStatus.get(index);
							Set<DerivationSource> src = new HashSet<ResourceSetInfo.DerivationSource>();
							src.addAll(fullgenstate.getTransformationProviders());
							src.addAll(fullgenstate.getUserProviders());
							ResourceSetInfo.DerivationStatus genstate = fullgenstate.getStatus(); 
							boolean isGenerated = genstate != ResourceSetInfo.DerivationStatus.NONDERIVED && genstate != DerivationStatus.UNSPECIFIED;
							boolean isFullGenerated = genstate == DerivationStatus.DERIVED;
							if (isGenerated) {
								derivationStatus = ((NoInverse) vfvList).getDerivationStatus(userModelResources);
							}		
							Set<ModelResource> modelResources = new HashSet<ModelResource>();
							for (DerivationSource s: src) {
								modelResources.add(s.resource);
							}
							modelResources.remove(null);
							int activeModelResources = curView.enabledViews().size();
							if (activeModelResources == 0) {
								activeModelResources = getAllModelResources().size();
							}
							isGenerated = isFullGenerated = modelResources.size() < activeModelResources;
							String markerType = isGenerated?(isFullGenerated?MARKER_TYPE_FULLGENERATED:MARKER_TYPE_GENERATED):MARKER_TYPE_NONGENERATED;

							//TODO: There might be multiple rea
							DerivationSource realSource = null;
							
							Set<DerivationSource> realSources = new HashSet<ResourceSetInfo.DerivationSource>();
							for (DerivationSource ds: fullgenstate.getTransformationProviders()) {
								if (ds.resource != null) {
									realSource = ds;
									realSources.add(ds);
								}
							}
							for (DerivationSource ds: fullgenstate.getUserProviders()) {
								if (ds.resource != null) {
									realSource = ds;
									realSources.add(ds);
								}
							}
							int symbolIndex = -1;
							if (realSource != null && modelResources.size() <= 1) { //TODO: Bei mehreren wäre eigen
								symbolIndex = getInteger(realSource.resource);
							}
							if (symbolIndex != -1 && isGenerated) {
								markerType = markerType+symbolIndex; 
							}
							for (ILeafNode inode: leafNodes) {
								//TODO: Irgendwie besser: Es sollten nur die Leaf-Nodes verwendet werden, die nicht von unteren erzeugt werden ...
								ICompositeNode parent = inode.getParent();
								while (parent != null && parent != supnode && !(parent instanceof CompositeNodeWithSemanticElement || parent instanceof SyntheticCompositeNode)) {
									parent = parent.getParent();
								};
								boolean equal = false;
								if (parent != null && supnode != null && (parent == supnode || (parent.getOffset() == supnode.getOffset() && parent.getLength() == supnode.getLength()))) {
									equal = true;
								}
								if (supnode != null && inode!= null && (inode == supnode || (inode.getOffset() == supnode.getOffset() && inode.getLength() == supnode.getLength()))) {
									equal = true;
								}
								if (!equal && parent != supnode && supnode != inode) {
									continue;
								}
								if (inode.isHidden()) {
									continue;
								}
								IMarker featureMarker = res.createMarker(markerType);
								String postfix = "";
								if (!fullgenstate.getTransformationProviders().isEmpty()) {
									postfix = "by "+IteratorUtils.concat(fullgenstate.getTransformationProviders(),(x)->x.resource.getProvider().getMainSymbol());
								}
								String fn = "A feature ";
								if (esf != null) {
									if (esf.getEContainingClass() != null) {
										fn = esf.getEContainingClass().getName()+"."+esf.getName();
									} else {
										fn = esf.getName();
									}
									if (esf.isMany()) {
										fn = fn +"["+index+"] ";
									}
									
								}
								featureMarker.setAttribute(IMarker.MESSAGE, fn+"was " + ((!isGenerated)?"not ":(isFullGenerated?"fully ":""))+"generated "+postfix+"!");
								featureMarker.setAttribute("uuid", uuid);
								featureMarker.setAttribute("featureName", esf.getName());
								featureMarker.setAttribute("featureIndex", index);
								featureMarker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
								int nstart = inode.getOffset();
								int nend = inode.getEndOffset();
							
								featureMarker.setAttribute(IMarker.CHAR_START, nstart);
								featureMarker.setAttribute(IMarker.CHAR_END, nend);
								
								String annotationType = isGenerated?(isFullGenerated?ANNOTATION_TYPE_FULLGENERATED:ANNOTATION_TYPE_GENERATED):ANNOTATION_TYPE_NONGENERATED;

								System.out.println("Feature "+esf.getEContainingClass().getName()+"."+esf.getName()+": "+genstate+" from "+nstart+" to "+nend+
										", index: "+symbolIndex);
								System.out.println(inode.getStartLine()+" - "+inode.getEndLine());
								if (isGenerated && symbolIndex != -1) {
									annotationType = annotationType+symbolIndex;
								}
								SimpleMarkerAnnotation nannotation = new SimpleMarkerAnnotation(annotationType, marker);
								newAnnotations.put(nannotation, new Position(nstart, nend-nstart));
							}								
							++index;
						}
					}
			}
			IAnnotationModel model = getSourceViewer().getAnnotationModel();
			if (model instanceof IAnnotationModelExtension) {
				IAnnotationModelExtension ext = (IAnnotationModelExtension)model;
				ext.replaceAnnotations(toRemove.toArray(new Annotation[]{}),newAnnotations);
			} else {
				System.err.println("I want an extension!");
			}
			return null;
				
			}

				});
		} catch (InvalidConcreteSyntaxException e) {
			System.err.println("Invalid concrete syntax: "+e.getMessage());
		}
		xtextToViewCorrespondance = new SimpleModelCorrespondance(); //New correspondance, old might yield to strange results!
	}
	
	
	
	private String getContent(XtextResource state) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			state.save(bos, Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bos.toByteArray());
	}

	public SimpleModelCorrespondance xtextToViewCorrespondance = new SimpleModelCorrespondance();
	
	public void recalculateFile(boolean reruntrafo) {
		if (inInit) {
			return;
		}
		this.inInit = true;
		//recheck projection
		updateVirtualModel(getXtextResource());
		reproject();
		IXtextDocument doc = getDocument();
		getAnnotationSizeUpdateRemove();
		updateXtext(getDocument());
		
		this.inInit = false;
		/*XtextResource prev = getDocument().readOnly(new IUnitOfWork<XtextResource, XtextResource>(){

			@Override
			public XtextResource exec(XtextResource state) throws Exception {

				
				runAfter[0] = ()->{
				 };
				return state;
			}
		});
		 runAfter[0].run();
		 if (basicViewState != resourceViewState) {
			 basicViewState = resourceViewState;
			 viewModelProv = curInfo.getViewProvider(getXtextResource(), basicViewState);
			 viewModel = viewModelProv.simpleModelView(ecoreFile);	
		 }*/
	}
	
	public void refreshMarkers() {
		reproject();
		recalculateFile(true);
	}
	
	
	
	@Override
    public void createPartControl(Composite parent) {
		super.createPartControl(parent);
        getSourceViewer().setEventConsumer(new IEventConsumer() {
			
			@Override
			public void processEvent(VerifyEvent event) {
				boolean onlywhite = true;
				if (event.text.trim().isEmpty()) {
					//Only whitespaces inserted
				} else {
					onlywhite = false;
				}
				try {
					String curText = getDocument().get(event.start, event.end-event.start);
					if (!curText.trim().isEmpty()) {
						onlywhite = false;
					}
					boolean subWhite = false;
					if (event.start > 0 && Character.isWhitespace(getDocument().getChar(event.start-1))) {
						subWhite = true;
					}
					if (event.end < getDocument().getLength() && Character.isWhitespace(getDocument().getChar(event.end))) {
						subWhite = true;
					}
					if (!subWhite) {
						onlywhite = false;
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
				if (onlywhite) { //Insertion and deletion of Whitespace always possible
					//TODO: Also support between tokens ...
					return;
				}
				IAnnotationModel model = getSourceViewer().getAnnotationModel();
				if (model instanceof IAnnotationModelExtension) {
					IAnnotationModelExtension mext = (IAnnotationModelExtension)model;
				}
				if (model instanceof IAnnotationModelExtension2) {
					IAnnotationModelExtension2 mext = (IAnnotationModelExtension2)model;
					Iterator anIt = mext.getAnnotationIterator(event.start, event.end-event.start, true, true);
					while (anIt.hasNext()) {
						Object o = anIt.next();
						if (o instanceof Annotation) {
							if (ANNOTATION_TYPE_GENERATED.equals(((Annotation)o).getType()) || ANNOTATION_TYPE_FULLGENERATED.equals(((Annotation)o).getType())) {
								event.doit = false;
								return;
							}
						}
					}
				}
				
			}
		});
	}
	
	
	@Override
	protected IAnnotationAccess createAnnotationAccess() {
		
			return new DefaultMarkerAnnotationAccess() {
				
				{
					
				}
			};
		
	}

	public IXtextDocument getSuperDocument() {
		return super.getDocument();
	}
	
	public int getImageIndex(ModelResource aspectResource) {
		return getInteger(aspectResource);
	}

	public MultiLoader getMultiLoader() {
		return loader;
	}

	public MultiResourceSetInfo getResourceInfo() {
		return curInfo;
	}

	public int getImageIndex(Resource resource) {
		return getInteger(resource);
	}

}
