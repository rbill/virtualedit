package at.ac.tuwien.big.school.editor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;

import com.google.common.io.Files;

import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VOMTest;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatus;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatusImpl;
import at.ac.tuwien.big.vfunc.nbasic.xtext.CompleteFileHandler;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;
/*import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.NoInverse;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationSource;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ResourceInfo;
import at.ac.tuwien.big.vmod.registry.ViewState;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;*/
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.MyEcoreUtilInstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.impl.ParentChildModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.DocumentChanger;
import at.ac.tuwien.big.xtext.util.IteratorUtils;
import at.ac.tuwien.big.xtext.util.ui.AnnotationTree;

public class VMXtextEditor extends XtextEditor {
	
	
	public static final String ANNOTATION_TYPE_TARGET = "GENERATED_MODEL_ANNOTATION_TARGET";
	public static final String ANNOTATION_TYPE_GENERATED = "GENERATED_MODEL_ANNOTATION_GENERATED";
	public static final String ANNOTATION_TYPE_FULLGENERATED = "GENERATED_MODEL_ANNOTATION_FULLGENERATED";
	public static final String ANNOTATION_TYPE_NONGENERATED = "GENERATED_MODEL_ANNOTATION_NONGENERATED";
	public static final String MARKER_TYPE_TARGET = "simplejava.isgenerated.target";
	public static final String MARKER_TYPE_GENERATED = "simplejava.isgenerated.generated";
	public static final String MARKER_TYPE_FULLGENERATED = "simplejava.isgenerated.fullgenerated";
	public static final String MARKER_TYPE_NONGENERATED = "simplejava.isgenerated.nongenerated";

	private static Object watchObject;
	
	static {
		System.out.println("I am used!");
	}
	
	private static MethodHandle getStore;
	
	public static final int MAX_ANNOTATION_COLORS = 10;
	public static Resource getEcoreRes(Resource my) {
		//TODO: W???re es nicht viel gescheiter, die ECore-Resource irgendwo statisch zu hinterlegen?
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
	
	private static URI nrm(java.net.URI from)  {
		return nrm (URI.createURI(from.toString()));
	}
	
	private static URI nrm(URI from)  {
		return URIConverter.INSTANCE.normalize(from);
	}
	
	public static URI switchFile(URI fromFile, String newFile) {
		String str = fromFile.toString();
		int lastInd = str.lastIndexOf('/');
		if (lastInd >= 0) {
			return URIConverter.INSTANCE.normalize(URI.createURI(str.substring(0,lastInd+1)+newFile)); 			
		}
		return null;
				
	}
	
	/*private ModelProvider completeModelProv;
	private ModelProvider viewModelProv;
	private ModelProvider baseModelProv;
	private VModelView completeModel;
	private VModelView viewModel;
	private VModelView baseModel;
	private ViewState resourceViewState;
	private VEcoreFile ecoreFile;*/
	private String basicModelText;
	private String fullModelText;
	private long lastAspectChange = -1;
	
	
	//CompleteFile must be loaded ...
	private CompleteFileHandler completeFile;
	
	
	
	/*private ResourceSetInfo curInfo;
	
	private ResourceInfo curResourceInfo;*/
	
	
	private List<EObject> myResourceList = new ArrayList<>();
	
	private boolean inInit = false;
	
	/*IXtextModelListener listener = new IXtextModelListener() {
		
		@Override
		public void modelChanged(XtextResource resource) {
			refreshMarkers();
		}
	};*/
	
	private boolean ignore = false;
	
	private IXtextDocument lastDoc = null;
	
	private List<Annotation> toRemove = new ArrayList<>();
	
	Resource fake;
	
	Map<Resource,Integer> usedIntegers = new HashMap<>();
	
	public SimpleModelCorrespondance xtextToViewCorrespondance = new SimpleModelCorrespondance();
	
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
					long mod = ifile.getModificationStamp();
					this.lastAspectChange = Math.max(mod, this.lastAspectChange);
					String fn = ifile.getName();
					/*if (fn.startsWith("simple") && fn.endsWith(".xmi")) {
						//take it
						toAdd.add(rs.getResource(nrm(ifile.getLocationURI()),true));
					}*/
					if (fn.endsWith(".vaspect")) {
						toAdd.add(rs.getResource(nrm(ifile.getLocationURI()),true));
					}
					if (fn.endsWith(".henshin")) {
						toAdd.add(rs.getResource(nrm(ifile.getLocationURI()),true));
					}
					
				} else {
					System.err.println("Unknown resource "+res);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
	}
	
	public void bla() {
		super.getDocumentProvider();
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
			//mit etwas gl???ck ist das mit dem offset nichts komplett anderes sondern noch immer
			//in der datei und damit nur etwas kleiner und hat eine h???here Wahrscheinlichkeit, eine passende Annotation zu erhalten
			
			//Suche: kleinste Annotation, die das vollst???ndig enth???lt
			List<MarkerAnnotation> candidates = fakeTree.getMostSpecificAnnotations(start, end);
			List<Identifier> uuids = new ArrayList<>();
			for (MarkerAnnotation annot: candidates) {
				Identifier uuid = getReferencedUUID(annot);
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
				Identifier pickedStr = pickDeepest(uuids);
				if (pickedStr != null) {
					EObject pickedView = getEManager().getObject(pickedStr);
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
	

	@Override
	protected IAnnotationAccess createAnnotationAccess() {
		
			return new DefaultMarkerAnnotationAccess() {
				
				{
					
				}
			};
		
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
	public void doSave(IProgressMonitor monitor) {
		try {
			refreshMarkers();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.basicModelText = getBasicModelText();
		this.fullModelText = getFullModelText();
		super.doSave(monitor);
		{
			IPath path = getResource().getRawLocation();
			path = path.addFileExtension("java");
			try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
				fos.write(this.fullModelText.getBytes());
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		{
			IPath path = getResource().getRawLocation();
			path = path.addFileExtension("basic");
			try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
				fos.write(this.basicModelText.getBytes());
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void doSaveAs() {
		super.doSaveAs();
	}	
	
	public Map<MarkerAnnotation,Integer> getAnnotationSizeUpdateRemove() {
		IAnnotationModel annotationmodel = getSourceViewer().getAnnotationModel();
		Map<MarkerAnnotation,Integer> annotationSize = new HashMap<>();
		this.toRemove = new ArrayList<>();
		
		{
			Iterator<?> it = annotationmodel.getAnnotationIterator();
			//Sortiere zuerst nach Gr??????e
			while (it.hasNext()) {
				Object o  = it.next();
				if (o instanceof MarkerAnnotation ) {

					MarkerAnnotation ann = (MarkerAnnotation)o;
					String type = ann.getType();
					if (type == null) {continue;}
					if (type.startsWith(ANNOTATION_TYPE_GENERATED) || type.startsWith(ANNOTATION_TYPE_FULLGENERATED) ||  
							type.startsWith(ANNOTATION_TYPE_NONGENERATED) || type.startsWith(ANNOTATION_TYPE_TARGET)) {
						this.toRemove.add(ann);
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
	
	public String getBasicModelText() {
		if (this.ignore) {
			return "";
		}		
		Resource fake = getFakeXtextResource();
		fake.getContents().clear();
		System.err.println("get basic model text not implemented!");
		/*SimpleModelCorrespondance smi = baseModel.saveResource(fake);
		
		Map<Symbol,EObject> symbolToSaved =new HashMap<>();
		for (Entry<EObject,EObject> entry: smi.getEntriesL2R()) {
			VMEObject vme = (VMEObject)entry.getKey();
			symbolToSaved.put(vme.getUUID(), entry.getValue());
		}*/
		//TODO: Add Annotations ...
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			fake.save(bos, Collections.emptyMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.basicModelText = bos.toString();
		System.out.println("Converted result string: "+this.basicModelText);
		return this.basicModelText;
	}

	public Identifier getContainingIdentifier(Identifier sub) {
		EObjectManager eman = getEManager();
		VMEObject vmeo = eman.getObject(sub);
		if (vmeo != null) {
			EObject econt = vmeo.eContainer();
			if (econt instanceof VMEObject) {
				return ((VMEObject)econt).getIdentificator();
			}
		}
		return null;
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
	
	@Override
	public IXtextDocument getDocument() {
		IXtextDocument doc = super.getDocument();
		if (doc != this.lastDoc && doc != null && !this.inInit) {
			initModel(doc);
			this.lastDoc = super.getDocument();
		}
		/*if (doc != null) {
			doc.addModelListener(listener);
		}*/
		return doc;
	}
	
	private EObjectManager getEManager() {
		return this.completeFile.getEManager();
	}
	
	public Resource getFakeXtextResource() {
		if (this.fake == null) {
			String thisExtension = getResource().getFileExtension();
			this.fake = getXtextResource().getResourceSet().createResource(URI.createURI("test://tempresource/temp."+thisExtension));
		}
		return this.fake;
	}
	
	public String getFullModelText() {
		if (this.ignore) {
			return "";
		}		
		Resource fake = getFakeXtextResource();
		fake.getContents().clear();
		System.err.println("Not implemented!");
		/*SimpleModelCorrespondance smi = completeModel.saveResource(fake);
		
		Map<Identifier,EObject> symbolToSaved =new HashMap<>();
		for (Entry<EObject,EObject> entry: smi.getEntriesL2R()) {
			VMEObject vme = (VMEObject)entry.getKey();
			symbolToSaved.put(vme.getIdentificator(), entry.getValue());
		}*/
		//TODO: Add Annotations ...
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			fake.save(bos, Collections.emptyMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.fullModelText = bos.toString();
		System.out.println("Converted result string: "+this.fullModelText);
		return this.fullModelText;
	}
	
	private Identifier getIdentifierFromString(String str) {
		return getEManager().getIdentifier(str);
	}
	
	public int getImageIndex(Resource aspectResource) {
		return getInteger(aspectResource);
	}
	
	private int getInteger(Resource myRes) {
		if (myRes == null) {
			return -1;
		}
		Integer ret = this.usedIntegers.get(myRes);
		if (ret != null) {
			return ret;
		}
		boolean[] usedIntegersB = new boolean[MAX_ANNOTATION_COLORS]; 
		for (Integer val: this.usedIntegers.values()) {
			if (val != null && val >= 0 && val < usedIntegersB.length) {
				usedIntegersB[val] = true;
			}
		}
		for (int i = 0; i < usedIntegersB.length; ++i) {
			if (!usedIntegersB[i]) {
				this.usedIntegers.put(myRes, i);
				return i;
			}
		}
		this.usedIntegers.put(myRes, -1);
		return -1;
	}
	
	public Identifier getReferencedUUID(MarkerAnnotation annotation) {
		Object ret;
		try {
			ret = annotation.getMarker().getAttribute("uuid");
			if (ret == null) {
				return null;
			}
			if (ret instanceof Identifier) {
				return (Identifier)ret;
			} else {
				return getIdentifierFromString(String.valueOf(ret)); 
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/*
	public ResourceSetInfo getResourceInfo() {
		return this.curInfo;
	}*/
	
	public IXtextDocument getSuperDocument() {
		return super.getDocument();
	}
	
	public XtextResource getXtextResource() {
		IXtextDocument doc = super.getDocument();
		return doc.readOnly((x)->x);
	}
	
	public void initModel(IXtextDocument doc) { 
		if (this.inInit) {return;}
		this.inInit = true;
		boolean[] needUpdateXtext = new boolean[1];

		IPath mainpath = getResource().getRawLocation();
		final IPath path = mainpath.addFileExtension("basic");
		File basicFile = path.toFile();
		if (basicFile.exists()  && (basicFile.lastModified() == 0 || this.lastAspectChange < basicFile.lastModified())) {
			try {
				doc.set(Files.toString(basicFile, Charset.forName("UTF-8")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			basicFile.delete();
		}
		try {
		
		boolean wantModel = doc.readOnly((res)->{
			//DeltaManager manager = SimpleDeltaManager.createDefaultManager();
			Resource ecoreRes = getEcoreRes(res);
	
			if (ecoreRes == null) {
				System.err.println("Did not find any ecore ... exiting");
				return false;
			}
			ResourceSet rs = res.getResourceSet();
			//Add resources ...
			IContainer cont;
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot root = workspace.getRoot();
			List<Resource> toAdd = new ArrayList<>();
			addFilesToResourceSet(rs,root,toAdd);
			
			EObjectManager man = new EObjectManager();
			man.addKnown(VObjectModelPackage.eINSTANCE);
			
			
			final IPath cfilePath = mainpath.addFileExtension("cfile.xmi");
			File cfile = cfilePath.toFile();
			CompleteFile cf = VObjectModelFactory.eINSTANCE.createCompleteFile();
			if (false && cfile.exists()) {
				try {
					Resource cfileRes = res.getResourceSet().getResource(URI.createFileURI(cfile.getCanonicalPath()), true);
					cf = (CompleteFile)cfileRes.getContents().get(0);
				} catch (Exception e) {
					System.err.println("Could not load "+cfile.getCanonicalPath()+": "+e.getMessage());
					
				}
			} else {
				Resource cfileRes = res.getResourceSet().createResource(URI.createFileURI(cfile.getCanonicalPath()));
				cfileRes.getContents().add(cf);
				//TODO: ...
				VOMTest.buildVOMFile(cf);
			}
			this.completeFile = new CompleteFileHandler(cf);
			
			/*
			ecoreFile = new VEcoreFileImpl(ecoreRes);
			this.curInfo = ResourceSetInfo.getResourceSetInfo(rs, ecoreRes);
			this.curResourceInfo = this.curInfo.getResourceInfo(res);
			if (!this.curInfo.getBaseModels().contains(res)) {
				return false;
			}
			
			if (basicFile.exists() && (basicFile.lastModified() == 0 || this.lastAspectChange < basicFile.lastModified())) {
				Resource fake = getFakeXtextResource();
				fake.load(new FileInputStream(basicFile), Collections.emptyMap());
				this.curResourceInfo.resetBasicContent(fake);
				fake.getContents().clear();
				needUpdateXtext[0] = false;
				//you can't use it, have to rely on desparate assoc!
				this.xtextToViewCorrespondance = new SimpleModelCorrespondance();
			} else {
				this.xtextToViewCorrespondance = this.curResourceInfo.getBaseCorresponcance();
				needUpdateXtext[0] = true;
			}
			try {
				Resource asXmi = rs.createResource(URI.createURI(res.getURI().toString()+".xmi"));
				asXmi.getContents().addAll(EcoreUtil.copyAll(res.getContents()));
				//asXmi.save(Collections.emptyMap());
			} catch (Exception e) {
				
			}

			baseModelProv = this.curInfo.getBaseProvider(res);
			baseModel = baseModelProv.simpleModelView(ecoreFile);*/
			
			return true;
		});
		if (!wantModel) {
			//It is intentional that isInit remains false to make getDocument not call initModel again!
			this.ignore = true;
			return;
		}
		} catch (Throwable t) {
			t.printStackTrace();
			System.err.println("Error: "+t.getMessage());
		}
		if (!needUpdateXtext[0]) {
			rerunTransformation();
			updateVirtualModel(getXtextResource());
		} else {
			getAnnotationSizeUpdateRemove();
		}
		rerunTransformation();
		updateXtext(getDocument());
		this.inInit = false;
	}

	public Identifier pickDeepest(List<Identifier> str) {
		Identifier ret = pickDeepestUuid(str);
		if (ret != null) {
			return ret;
		}
		return null;
	}
	
	public Identifier pickDeepestUuid(List<Identifier> uuids) {
		Set<Identifier> possible = new HashSet<>(uuids);
		for (Identifier sub: uuids) {
			possible.remove(getContainingIdentifier(sub));
		}
		if (!possible.isEmpty()) {
			return possible.iterator().next();
		}
		return null;
	}
	
	public void recalculateFile(boolean reruntrafo) {
		if (this.inInit) {
			return;
		}
		this.inInit = true;
		IXtextDocument doc = getDocument();
		if (reruntrafo) {
			updateModelProvs();
			doc.readOnly((state)->{ 
				updateVirtualModel(state);
				return null;
			});
			rerunTransformation();
		} else {
			getAnnotationSizeUpdateRemove();
		}
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
		recalculateFile(true);
	}
	
	
	public void rerunTransformation() {
		//this.curInfo.thingSaved(getXtextResource());
		updateModelProvs();
	} 

	public void updateModelProvs() {
		getDocument().readOnly((res)->{
			/*viewModelProv = this.curInfo.getViewProvider(res, this.curInfo.getContainedViewState());
			completeModelProv = this.curInfo.getCompleteProvider(res);
			ViewState state = this.curInfo.createDefaultViewState();
			state.deleteFromView(this.curInfo.getChangeModels());
			baseModelProv = this.curInfo.getViewProvider(res, state);
			viewModel = viewModelProv.simpleModelView(ecoreFile);
			completeModel = completeModelProv.simpleModelView(ecoreFile);			
			baseModel = baseModelProv.simpleModelView(ecoreFile);*/
			return null;
		});
	}

	public void updateVirtualModel(XtextResource state) {
		
		this.xtextToViewCorrespondance = buildCorrespondanceFromXtext(this.xtextToViewCorrespondance,state);
		//TODO: Clear from time to time
		//Build correspondance map based on annotations
		
		SimpleModelCorrespondance nullcorr = new SimpleModelCorrespondance();
		
		//F???r die doch nicht existierenden
		InstanceCreator creator = new InstanceCreator() {
			
			@Override
			public EObject createInstance(EObject cont, EClass cl) {
				CompleteFileHandler fileHandler = VMXtextEditor.this.completeFile;
				/*if (cont != null && cont instanceof VMEObject) {
					VMEObject vme = (VMEObject)cont;
					Symbol symbol = vme.getUUID();
					ModelProvider alternative = baseModelProv.getRegistry().getProvider(symbol);
					if (alternative != null) {
						prov = alternative;
					}
				}
				Symbol newSymbol = prov.newSymbol(cl!=null?cl.getName():null); //Alles was erzeugt wird landed hier TODO: ???ndern, so dass es passt ... wie ist das?
				VObjectValues val = viewModel.getInstances();
				val.add(newSymbol);
				val.setClass(newSymbol, cl);
				//System.out.println("Creating "+ cl.getName()+" for id "+newSymbol);
				//if ("EClass".equals(cl.getName())) {
//					System.err.println("Creating eclass?!");
				//}
				return viewModel.getEObject(newSymbol);*/
				return getEManager().getNewObject(cl);
			}
		};
		System.out.println("Root objects init: "+this.myResourceList+" VS "+state.getContents());
		
		
		/*Resource test1 = new ResourceImpl();
		viewModel.saveResource(test1);
		System.out.println("View model before equalizing");*/
		
		this.myResourceList = this.completeFile.exposeContents();
		
		SimpleModelEqualizer equalizer = new SimpleModelEqualizer(
				state.getContents(), this.myResourceList,
				nullcorr, this.xtextToViewCorrespondance, creator);
		
		equalizer.equalize();
		this.completeFile.save();
		/*
		System.out.println("Equalized model: "+viewModel);
		
		System.out.println("Base model: "+baseModel);*/
	}

	public void updateXtext(IXtextDocument doc) {
		updateModelProvs();
		try {
		System.out.println("Basic model text: "+getBasicModelText());
		SimpleModelCorrespondance newlyCreated = new SimpleModelCorrespondance();
		SimpleModelCorrespondance nullcorr = new SimpleModelCorrespondance();
		ParentChildModelCorrespondance original = new ParentChildModelCorrespondance(nullcorr, this.xtextToViewCorrespondance);
		ModelCorrespondance inverse = original.inverse();
		Map<String,EObject> oldObjects = new HashMap<>();
		XtextResource[] lastState = new XtextResource[1];
		boolean cont = doc.readOnly((state)->{
			lastState[0] = state;
			
			InstanceCreator myEcoreCreater = new MyEcoreUtilInstanceCreator();
			
			/*
			System.out.println("Regenerated model: "+viewModel);
			
			Resource test = new ResourceImpl();
			viewModel.saveResource(test); 
			
			EObject simpleJava = null;
			for (EObject eobj: test.getContents()) {
//				if (eobj.eClass() != null && "SimpleJava".equals(eobj.eClass().getName())) {
					//simpleJava = eobj;
				//}
			}*/
						
			//Now there are new things ... regenerate the model and annotations
			//Use the inverse correspondance map

			this.myResourceList = this.completeFile.exposeContents();
			
			
			
			//System.out.println("Root objects before rev: "+myResourceList+" VS "+state.getContents());
			SimpleModelEqualizer reverseEqualizer = new SimpleModelEqualizer(
					this.myResourceList, state.getContents(), 
					inverse, newlyCreated, myEcoreCreater);
			for (Entry<EObject,EObject> entry: newlyCreated.getEntriesR2L()) {
				this.xtextToViewCorrespondance.putCorrespondence(entry.getKey(), entry.getValue());
			}
			
			String oldCont = getDocument().get();
			reverseEqualizer.equalize();
			String newContent;
			try {
				newContent = getContent(state);				
				//System.out.println("New content: "+newContent);
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
			System.out.println("Root objects After execute: "+this.myResourceList+" VS "+state.getContents());
			return true;
		});
		
		
		
		//RunAfter

		 doc.modify(new IUnitOfWork<Object, XtextResource>(){	

				@Override
				public Object exec(XtextResource state) throws Exception {
					
					//System.out.println("Root objects After execute II: "+myResourceList+" VS "+state.getContents());
					for (EObject eobj: state.getContents()) {
						try {
							//System.out.println("Contained in Resource: "+state.getSerializer().serialize(eobj));
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
				
				Map<Annotation,Position> newAnnotations = new HashMap<>();
				List<EObject> targetEObject = new ArrayList<>();
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
					Identifier uuid = uuidObj.getIdentificator();
					String uuidString = getEManager().getIdentifierString(uuid);
					IMarker marker = res.createMarker(MARKER_TYPE_TARGET);
					marker.setAttribute(IMarker.MESSAGE, "Target Object: "+uuid);
					marker.setAttribute("uuid", uuidString);
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
					marker.setAttribute(IMarker.CHAR_START, start);
					marker.setAttribute(IMarker.CHAR_END, end);
					SimpleMarkerAnnotation annotation = new SimpleMarkerAnnotation(ANNOTATION_TYPE_TARGET, marker);
					newAnnotations.put(annotation, new Position(start, end-start));
					
					//node.getChildren()
					
					
					EClass cl = eobj.eClass();
					//List<ModelResource> userModelResources = completeModelProv.getUserEditModels();
					//How to calculate?
					
					
					for (EStructuralFeature esf: cl.getEAllStructuralFeatures()) {
						List<INode> inodes = NodeModelUtils.findNodesForFeature(eobj, esf);
						/*VFeatureValues vfv = viewModel.getFeatureValues(esf);
						List<Object> vfvList = vfv.getValueValue(uuid);*/
						
						
						
						//System.out.println("Values: "+Arrays.toString(vfvList.toArray())+ " For feature "+esf.getEContainingClass().getName()+"."+esf.getName());
						//if (esf.getName().equals("source")) {
							//watchObject = vfv;
							//System.out.print("xx");
						//}
						/*List<ResourceSetInfo.ExactDerivationStatus> derivationStatus = new ArrayList<>();
						if (vfvList instanceof NoInverse) {
							derivationStatus = ((NoInverse) vfvList).getDerivationStatus(userModelResources);
						}*/
						
						List<BasicDerivationStatus> derivationStatus = new ArrayList<>();
						derivationStatus.addAll(VMXtextEditor.this.completeFile.getDerivationStatus(uuidObj,esf));
						int index = 0;
						for (INode supnode: inodes) {
							Iterable<ILeafNode> leafNodes;
							if (supnode instanceof ILeafNode) {
								leafNodes = Collections.singleton((ILeafNode)supnode);
							} else {
								leafNodes = supnode.getLeafNodes();
								//Eigentlich nur die Leaf-Nodes, die nicht von Unteren erzeugt werden ...
							}

							BasicDerivationStatus fullgenstate = derivationStatus.size()<=index?new BasicDerivationStatusImpl(DerivationStatus.UNSPECIFIED):derivationStatus.get(index);
							ResourceSetInfo.DerivationStatus genstate = fullgenstate.getStatus(); 
							boolean isGenerated = genstate != ResourceSetInfo.DerivationStatus.NONDERIVED && genstate != DerivationStatus.UNSPECIFIED;
							boolean isFullGenerated = genstate == DerivationStatus.DERIVED;
							if (isGenerated) {
								//derivationStatus = ((NoInverse) vfvList).getDerivationStatus(userModelResources);
							}
							String markerType = isGenerated?(isFullGenerated?MARKER_TYPE_FULLGENERATED:MARKER_TYPE_GENERATED):MARKER_TYPE_NONGENERATED;		

							Resource symbolResource = null;
							int symbolIndex = -1; //I need to check what that means
							/*
							for (DerivationSource ds: fullgenstate.getTransformationProviders()) {
								Resource symbolResource_ = VMXtextEditor.this.curInfo.getAspectResource(ds.resource);
								if (symbolResource != null && symbolResource != symbolResource_) {
									symbolResource = null;
									break;
								} else {
									symbolResource = symbolResource_;
								}
							}
							int symbolIndex = getInteger(symbolResource);
							if (symbolIndex != -1 && isGenerated) {
								markerType = markerType+symbolIndex; 
							}*/
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

								//System.out.println("Feature "+esf.getEContainingClass().getName()+"."+esf.getName()+": "+genstate+" from "+nstart+" to "+nend+
								//		", index: "+symbolIndex);
								//System.out.println(inode.getStartLine()+" - "+inode.getEndLine());
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
				ext.replaceAnnotations(VMXtextEditor.this.toRemove.toArray(new Annotation[]{}),newAnnotations);
			} else {
				System.err.println("I want an extension!");
			}
			return null;
				
			}});
		} catch (InvalidConcreteSyntaxException e) {
			System.err.println("Invalid concrete syntax: "+e.getMessage());
		}
		this.xtextToViewCorrespondance = new SimpleModelCorrespondance(); //New correspondance, old might yield to strange results!
		this.completeFile.save();
	}

}
