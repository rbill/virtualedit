package at.ac.tuwien.big.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.management.MXBean;
import javax.naming.event.ObjectChangeListener;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IEventConsumer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.IAnnotationModelExtension2;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.IElementStateListener;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import at.ac.tuwien.big.oclgen.OclExtractor;
import at.ac.tuwien.big.virtmod.structure.DeltaManager;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo.GeneratedState;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.impl.EditGlobalSource;
import at.ac.tuwien.big.virtmod.structure.impl.SimpleDeltaManager;
import at.ac.tuwien.big.virtmod.structure.impl.TransformationGlobalSource;
import at.ac.tuwien.big.virtmod.structure.impl.VDeltaContainer;
import at.ac.tuwien.big.virtmod.structure.impl.VSimpleContainer;
import at.ac.tuwien.big.vmodel.deltageneration.DeltaGenerator;
import at.ac.tuwien.big.vmodel.deltageneration.impl.AddGettersAndSetters;
import at.ac.tuwien.big.vmodel.deltageneration.impl.RuleApplicationDeltaGenerator;
import at.ac.tuwien.big.vmodel.ecore.VEObject;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.VFeatureValues;
import at.ac.tuwien.big.vmodel.ecore.VModelView;
import at.ac.tuwien.big.vmodel.ecore.VObjectValues;
import at.ac.tuwien.big.vmodel.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.vmodel.general.WrappedElementSource;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.MyEcoreUtilInstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.impl.ParentChildModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.DocumentChanger;
import at.ac.tuwien.big.xtext.util.ui.AnnotationTree;

public class VXtextEditor extends XtextEditor {
	
	
	public static final String ANNOTATION_TYPE_TARGET = "GENERATED_MODEL_ANNOTATION_TARGET";
	public static final String ANNOTATION_TYPE_GENERATED = "GENERATED_MODEL_ANNOTATION_GENERATED";
	public static final String ANNOTATION_TYPE_NONGENERATED = "GENERATED_MODEL_ANNOTATION_NONGENERATED";
	public static final String MARKER_TYPE_TARGET = "simplejava.isgenerated.target";
	public static final String MARKER_TYPE_GENERATED = "simplejava.isgenerated.generated";
	public static final String MARKER_TYPE_NONGENERATED = "simplejava.isgenerated.nongenerated";

	private static Object watchObject;
	
	private VModelView changeViewModel;
	private VModelView changeBaseModel;
	private VModelView baseModel;
	private VModelView editModel;
	private List<String> virtualRoot = new ArrayList<String>();
	private List<EObject> myResourceList = new ArrayList<EObject>();
	
	public void initModel(XtextResource res) {
		VContainer baseModel = new VSimpleContainer(new EditGlobalSource());
		
		VContainer editModel = new VSimpleContainer(new TransformationGlobalSource());
		
		DeltaManager manager = SimpleDeltaManager.createDefaultManager();
		Resource ecoreRes = null;
		for (Resource subres: res.getResourceSet().getResources()) {
			List<EObject> contents = subres.getContents();
			if (!contents.isEmpty() && contents.iterator().next() instanceof EPackage) {
				//It's an ecore!
				System.out.println("Found ecore!");
				ecoreRes = subres;
			}
		}
		if (ecoreRes == null) {
			for (Resource subres: res.getResourceSet().getResources()) {
				List<EObject> contents = subres.getContents();
				if (!contents.isEmpty()) {
					ecoreRes = contents.iterator().next().eClass().eResource();
					System.out.println("Found ecore with checking file ...");
				}
			}
		} 
		if (ecoreRes == null) {
			System.err.println("Did not find any ecore ... exiting");
			return;
		}
		VEcoreFile ecoreFile = new VEcoreFileImpl(ecoreRes);
		RuleApplicationDeltaGenerator deltaGenerator = new RuleApplicationDeltaGenerator(ecoreFile);
		deltaGenerator.addModification(ecoreFile.getClass("ClassDeclaration"), new AddGettersAndSetters());
		SimpleModelView mv = new SimpleModelView(baseModel,ecoreFile);
		SimpleModelView emv = new SimpleModelView(editModel,ecoreFile);
		mv.initModelForEdit();
		emv.initModelForEdit();

		VDeltaContainer deltaModel = new VDeltaContainer(null, editModel, baseModel, manager);
		VDeltaContainer baseChangeModel = new VDeltaContainer(null, baseModel, editModel, manager);
		setVirtualModel(new SimpleModelView(deltaModel,ecoreFile),
				new SimpleModelView(baseChangeModel, ecoreFile),
				mv,
				emv, deltaGenerator);
	}

	{
	}
	
	private DeltaGenerator deltaGenerator;
	
	public void setVirtualModel(VModelView finalModel, VModelView baseChangeModel, VModelView baseModel, VModelView editModel, DeltaGenerator deltaGenerator) {
		this.changeViewModel = finalModel;
		this.changeBaseModel = baseChangeModel;
		this.baseModel = baseModel;
		this.editModel = editModel;
		this.myResourceList = baseChangeModel.wrapObjects(virtualRoot);
		this.deltaGenerator = deltaGenerator;
	}
	
	private VModelView changeViewModel() {
		return changeViewModel;
	}
	
	/*IXtextModelListener listener = new IXtextModelListener() {
		
		@Override
		public void modelChanged(XtextResource resource) {
			refreshMarkers();
		}
	};*/
	
	private IXtextDocument lastDoc = null;
	
	public IXtextDocument getDocument() {
		IXtextDocument doc = super.getDocument();
		if (doc != lastDoc) {
			doc.readOnly(new IUnitOfWork<Object, XtextResource>(){

				@Override
				public Object exec(XtextResource state) throws Exception {
					initModel(state);
					return null;
				}
				
			});
			lastDoc = doc;
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
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		super.doSave(monitor);
		try {
			refreshMarkers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getReferencedUUID(MarkerAnnotation annotation) {
		return annotation.getMarker().getAttribute("uuid", null);
	}
	

	public String getContainingObjectUUID(String sub) {
		return changeViewModel.getContainingObjectUuid(sub);
	}

	public String pickDeepestUuid(List<String> uuids) {
		Set<String> possible = new HashSet<>(uuids);
		for (String sub: uuids) {
			possible.remove(getContainingObjectUUID(sub));
		}
		if (!possible.isEmpty()) {
			return possible.iterator().next();
		}
		return null;
	}
	
	public String pickDeepest(List<String> str) {
		String ret = pickDeepestUuid(str);
		if (ret != null) {
			return ret;
		}
		return null;
	}	
	
	public void recalculateFile() {
		String[] newDocument = new String[1];
		Runnable[] runAfter = new Runnable[1];
		Map<String,EObject> oldObjects = new HashMap<String, EObject>();
		XtextResource prev = getDocument().readOnly(new IUnitOfWork<XtextResource, XtextResource>(){

			@Override
			public XtextResource exec(XtextResource state) throws Exception {
				SimpleModelCorrespondance viewcorr = new SimpleModelCorrespondance();
				SimpleModelCorrespondance basecorr = new SimpleModelCorrespondance();
				//Build correspondance map based on annotations
				
				//Get positions of elements
				AnnotationTree<MarkerAnnotation> fakeTree = new AnnotationTree<>(null, null, 0, Integer.MAX_VALUE);
				IAnnotationModel annotationmodel = getSourceViewer().getAnnotationModel();
				Map<MarkerAnnotation,Integer> annotationSize = new HashMap<>();
				List<Annotation> toRemove = new ArrayList<Annotation>();
				
				{
					Iterator<?> it = annotationmodel.getAnnotationIterator();
					//Sortiere zuerst nach Größe
					while (it.hasNext()) {
						Object o  = it.next();
						if (o instanceof MarkerAnnotation ) {

							MarkerAnnotation ann = (MarkerAnnotation)o;
							String type = ann.getType();
							if (ANNOTATION_TYPE_GENERATED.equals(type) || ANNOTATION_TYPE_NONGENERATED.equals(type) || ANNOTATION_TYPE_TARGET.equals(type)) {
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
			
				Map<String,Map<String,Map<String,String>>> containmentMap = changeBaseModel.getContainmentNameMap();
				//Type, Container, Name, Object
				
				for (EObject eobj: (Iterable<EObject>)()->state.getAllContents()) {
					ICompositeNode node = NodeModelUtils.findActualNodeFor(eobj);
					int start = node.getTotalOffset();
					int end = node.getTotalEndOffset();
					start = node.getOffset();
					end = node.getEndOffset();
					//mit etwas glück ist das mit dem offset nichts komplett anderes sondern noch immer
					//in der datei und damit nur etwas kleiner und hat eine höhere Wahrscheinlichkeit, eine passende Annotation zu erhalten
					
					//Suche: kleinste Annotation, die das vollständig enthält
					List<MarkerAnnotation> candidates = fakeTree.getMostSpecificAnnotations(start, end);
					List<String> uuids = new ArrayList<String>();
					for (MarkerAnnotation annot: candidates) {
						uuids.add(getReferencedUUID(annot));
					}
					if (uuids.isEmpty()) {
						//No match, that's fine ... - the element has been newly inserted
						System.out.println("NO match for "+eobj+"!");
					} else {
						//You need to pick the correct one, i.e. the most deeply nested one
						String pickedStr = pickDeepest(uuids);
						if (pickedStr != null) {
							EObject pickedView = changeViewModel.getEObject(pickedStr);
							EObject pickedBase = changeBaseModel.getEObject(pickedStr);
							//Check if this is not at the same time a match of a contained object
							EObject curComp = eobj.eContainer();
							//Da muss man nicht irgendwie zwischenspeichern, weil der Iterator zuerst parent, dann child traversiert
							while (curComp != null) {
								if (Objects.equals(viewcorr.getRightObject(curComp),pickedView)) {
									pickedView = null;
									pickedBase = null;
									System.out.println("NO real match for "+eobj+"!");									
									break;
								}
								curComp = curComp.eContainer();
							}
							if (pickedView != null) {
								viewcorr.putCorrespondence(eobj, pickedView);
								System.out.println("Associate: "+Arrays.toString(uuids.toArray())+" --> "+pickedView+ " for "+eobj);
							}
							if (pickedBase!= null) {
								basecorr.putCorrespondence(eobj, pickedBase);
								System.out.println("Associate: "+Arrays.toString(uuids.toArray())+" --> "+pickedBase+ " for "+eobj);
							}
						} else {
							System.err.println("Could not pick deepest!");
						}
					} 
				}
				System.out.println("Initial modell: "+changeViewModel());
				SimpleModelCorrespondance subCor = new SimpleModelCorrespondance();
				//Für die doch nicht existierenden
				InstanceCreator creator = new InstanceCreator() {
					
					@Override
					public EObject createInstance(EClass cl) {
						String uuid = UUID.randomUUID().toString();
						VObjectValues val = changeBaseModel.getInstances();
						val.add(uuid);
						val.setClass(uuid, changeBaseModel.getEcore().getName(cl));
						System.out.println("Creating "+ cl.getName()+" for id "+uuid);
						if ("EClass".equals(cl.getName())) {
							System.err.println("Creating eclass?!");
						}
						return changeBaseModel.getEObject(uuid);
					}
				};
				System.out.println("Root objects init: "+myResourceList+" VS "+state.getContents());
				SimpleModelEqualizer equalizer = new SimpleModelEqualizer(
						state.getContents(), myResourceList,
						basecorr, subCor, creator);
				
				equalizer.equalize();
				
				InstanceCreator myEcoreCreater = new MyEcoreUtilInstanceCreator();
				
				System.out.println("Equalized model: "+changeViewModel());
				
				System.out.println("Base model: "+baseModel);
				
				System.out.println("Edit model: "+editModel);
				/*try {
					System.out.println("Serialized base: "+state.getSerializer().serialize(baseModel.saveContents(myEcoreCreater).iterator().next()));
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Error serializing base: "+e.getMessage());
				}
				try {
					System.out.println("Serialized edit: "+state.getSerializer().serialize(editModel.saveContents(myEcoreCreater).iterator().next()));
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Error serializing edit: "+e.getMessage());
				}*/
				
				deltaGenerator.regenerateDelta(baseModel,editModel,changeViewModel);
				
				System.out.println("Regenerated model: "+changeViewModel());
				
				Resource test = new ResourceImpl();
				changeViewModel.saveResource(test);
				
				EObject simpleJava = null;
				for (EObject eobj: test.getContents()) {
					if (eobj.eClass() != null && "SimpleJava".equals(eobj.eClass().getName())) {
						simpleJava = eobj;
					}
				}
				try {
					System.out.println(state.getSerializer().serialize(simpleJava));
				} catch (Exception e) {
					e.printStackTrace();
					runAfter[0] = ()->{};
					return null;
				}
				
				//Now there are new things ... regenerate the model and annotations
				//Use the inverse correspondance map
				ParentChildModelCorrespondance original = new ParentChildModelCorrespondance(viewcorr, subCor);
				ModelCorrespondance inverse = original.inverse();
				
				SimpleModelCorrespondance newlyCreated = new SimpleModelCorrespondance();
				
				
				System.out.println("Root objects before rev: "+myResourceList+" VS "+state.getContents());
				SimpleModelEqualizer reverseEqualizer = new SimpleModelEqualizer(
						myResourceList, state.getContents(), 
						inverse, newlyCreated, myEcoreCreater);
				
				String oldCont = getDocument().get();
				reverseEqualizer.equalize();
				String newContent;
				try {
					System.out.println(state.getSerializer().serialize(simpleJava));
					System.out.println("Root objects After rev: "+myResourceList+" VS "+state.getContents());
					newContent = state.getSerializer().serialize(state.getContents().get(0));
					System.out.println("New content: "+newContent);
				} catch (Exception e) {
					e.printStackTrace();
					runAfter[0] = ()->{};
					return null;
				}
				
				
				for (EObject eobj: (Iterable<EObject>)()->state.getAllContents()) {
					oldObjects.put(state.getURIFragment(eobj),eobj);
				}
				DocumentChanger.modify(oldCont, newContent, getDocument());
				XtextResource oldState = state;
				System.out.println("Root objects After execute: "+myResourceList+" VS "+state.getContents());
				runAfter[0] = ()->{
					 getDocument().modify(new IUnitOfWork<Object, XtextResource>(){	

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
								
							IXtextDocument doc = getDocument();
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
								int start = node.getOffset();
								int end = node.getEndOffset();
								
								//Targets
								VEObject uuidObj = (VEObject)targetCorrespondance.getLeftObject(eobj);
								EObject searchObj = null;
								if (uuidObj == null) {
									searchObj = oldObjects.get(eobj.eResource().getURIFragment(eobj));
									uuidObj = (VEObject)targetCorrespondance.getLeftObject(searchObj);
								}
								String uriFragment = eobj.eResource().getURIFragment(eobj);
								String uuid = uuidObj.getUUID();
								IMarker marker = res.createMarker(MARKER_TYPE_TARGET);
								marker.setAttribute(IMarker.MESSAGE, "Target Object: "+uuid);
								marker.setAttribute("uuid", uuid);
								marker.setAttribute(IMarker.CHAR_START, start);
								marker.setAttribute(IMarker.CHAR_END, end);
								SimpleMarkerAnnotation annotation = new SimpleMarkerAnnotation(ANNOTATION_TYPE_TARGET, marker);
								newAnnotations.put(annotation, new Position(start, end-start));
								
								//node.getChildren()
								
								
								EClass cl = eobj.eClass();
								for (EStructuralFeature esf: cl.getEAllStructuralFeatures()) {
									List<INode> inodes = NodeModelUtils.findNodesForFeature(eobj, esf);
									VFeatureValues vfv = changeViewModel.getFeatureValues(esf);
									List<Object> vfvList = vfv.getValueList(uuid);
									System.out.println("Values: "+Arrays.toString(vfvList.toArray())+ " For feature "+esf.getEContainingClass().getName()+"."+esf.getName());
									if (esf.getName().equals("attribute")) {
										watchObject = vfv;
										System.out.print("xx");
									}
									List<? extends WrappedElementSource> sources = vfv.getWrappedSource(uuid);
									if (inodes.size() != sources.size()) {
										System.err.println("Inodes size is not nodes.size: "+inodes.size()+" VS "+sources.size()+ " - not associating attributes for "+esf+"!");
										continue;
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

										WrappedElementSource source = sources.get(index);;								
										GeneratedState genstate = source.isGenerated();
										boolean isGenerated = genstate != GeneratedState.FULL_MANUAL;
										
										String markerType = isGenerated?MARKER_TYPE_GENERATED:MARKER_TYPE_NONGENERATED;									
										for (ILeafNode inode: leafNodes) {
											//TODO: Irgendwie besser: Es sollten nur die Leaf-Nodes verwendet werden, die nicht von unteren erzeugt werden ...
											ICompositeNode parent = inode.getParent();
											while (parent != null && parent != supnode && !(parent instanceof CompositeNodeWithSemanticElement)) {
												parent = parent.getParent();
											};
											if (parent != supnode) {
												continue;
											}
											if (inode.isHidden()) {
												continue;
											}
											IMarker featureMarker = res.createMarker(markerType);
											featureMarker.setAttribute(IMarker.MESSAGE, "This feature was " + ((!isGenerated)?"not ":"")+" generated!");
											featureMarker.setAttribute("uuid", uuid);
											featureMarker.setAttribute("featureName", esf.getName());
											featureMarker.setAttribute("featureIndex", index);
											int nstart = inode.getOffset();
											int nend = inode.getEndOffset();
											System.out.println("Feature "+esf.getEContainingClass().getName()+"."+esf.getName()+": "+genstate+" from "+nstart+" to "+nend);
											System.out.println(inode.getStartLine()+" - "+inode.getEndLine());
											featureMarker.setAttribute(IMarker.CHAR_START, nstart);
											featureMarker.setAttribute(IMarker.CHAR_END, nend);
											String annotationType = isGenerated?ANNOTATION_TYPE_GENERATED:ANNOTATION_TYPE_NONGENERATED;
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
							
						}});
				 };
				return state;
			}
		});
		 runAfter[0].run();
	}
	
	public void refreshMarkers() {
		recalculateFile();
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
							if (ANNOTATION_TYPE_GENERATED.equals(((Annotation)o).getType())) {
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

}
