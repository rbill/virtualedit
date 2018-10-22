package at.ac.tuwien.big.school.validation;

import java.util.ArrayList;
import at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicValidator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

import at.ac.tuwien.big.school.editor.VMXtextEditor;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import at.ac.tuwien.big.vfunc.nbasic.constraint.SampleEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;

public class SchoolTextValidator extends AbstractSchoolTextValidator {
	
	//TODO: should not be static ...
	private static HashMap<String, List<VMEObject>> admissibleObjects = new HashMap<>(); 
	
	public static final String CHANGE_ORIGIN ="CHANGE_ORIGIN";
	public static final String RESET ="RESET_VME";
	public static final String RESET_PARTIAL ="RESET_VME_PARTIAL";
	
	private static long curRunId = 0;
	
	public static VMEObject getEObject(String name, int index) {
		List<VMEObject> ret = admissibleObjects.computeIfAbsent(name, x->new ArrayList<>());
		if (index >= 0 && index < ret.size()) {
			return ret.get(index);
		}
		return null;
	}
	
	public static VMEObject getEObject(String name, String index) {
		try {
			return getEObject(name, Integer.valueOf(index));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private DynamicValidator dv = new DynamicValidator();
	private CEobjectManager cmanager;
	private EObjectManager lastEManager;
	
	private Resource fakeResource = new ResourceImpl();
	
	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		super.acceptError(message, object, feature, index, code, issueData);
	}
	
	@Check(CheckType.NORMAL)
	public void checkFile(EObject eobj) {
		if (eobj.eContainer() != null) {
			//Only do it once
			return;
		}
		if (false) {
			return; //Don't do for now
		}
		EObjectManager instance = EObjectManager.getInstance();
		if (eobj.eClass() != null && eobj.eClass().getEPackage() != null) {
			instance.addKnown(eobj.eClass().getEPackage());
		}
		if (this.cmanager == null || this.lastEManager != instance || true) { //Ich glaube das muss man immer neu machen, wenn sich was ändert
			//Da die Objekte nicht aktualisiert werden im CEobjectManager, wenn sich etwas im EObject ändert
			this.cmanager = new CEobjectManager(instance);
		}
		//Ich brauche nur bestimmte Objekte, nämlich solche, die irgendwo da drin sind
		Set<EObject> myContents = new HashSet<>();
		//eobj.eAllContents().forEachRemaining(x->{myContents.add(x);});
		myContents.add(eobj);
		
		//Assume there is only one root object

		VMXtextEditor xtextEditor = VMXtextEditor.INSTANCE;
		if (xtextEditor == null) {return;}
		xtextEditor.refreshVirtual();
		VMEObject virtualRoot = xtextEditor.getEObject(eobj);
		//TODO: Ich glaube der CManager ändert sich nicht, wenn
		EObject converted = this.cmanager.getOrCreateFull(virtualRoot);
		Set<EObject> contents = EObjectManager.getNoncomposite(converted, EObject.class);
		contents = new HashSet<>(contents);
		contents.add(converted);
		this.fakeResource = new ResourceImpl();
		this.fakeResource.getContents().addAll(contents);
		this.dv.checkFile(this.fakeResource,false);
		Map<EObject, ? extends EObject> cemap = this.cmanager.getGlobalMap();
		Map<EObject,EObject> sampleToThisMap = new HashMap<>();
		//the right obj of cemap to the corresponding of the left
		cemap.forEach((virtual,sample)->{
			
			if (xtextEditor != null) {
				EObject xtextObj = xtextEditor.xtextToViewCorrespondance.getLeftObject(virtual);
				if (xtextObj != null) {
					xtextObj = eobj.eResource().getEObject(xtextObj.eResource().getURIFragment(xtextObj));
					if (xtextObj != null) {
						sampleToThisMap.put(sample, xtextObj);
					} else {
						System.err.println("Could not find xtextObj for "+virtual+"!");
					}
				} else {
					System.err.println("Could not find xtextObj for "+virtual+","+sample+"!");
				}
			}
		});
		this.dv.applyErrorMap(sampleToThisMap, this);
		final long curId = ++curRunId;
		new Thread(()->{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (curId == curRunId) {
			this.dv.stopSearch();
		}
		}).start();;
		
	}
	
	@Check(CheckType.FAST)
	public void offerBindings(EObject eobj) {
		if (eobj == null) {return;}
		try {
			EClass cl = eobj.eClass();
			EObjectManager instance = EObjectManager.getInstance();
			if (instance == null) {
				System.err.println("No EObjectManager found!");
				return;
			}
			List<VMEObject> admissible = instance.getAllAdmissible(cl);
			String name = cl.getEPackage().getName()+"_"+cl.getName();
			admissibleObjects.put(name,admissible);
			int index = 0;
			for (VMEObject vobj: admissible) {
				warning("Set origin to "+vobj.getIdentificator(),eobj,null,CHANGE_ORIGIN,name,""+index,eobj.eResource().getURIFragment(eobj));
				++index;
			}
			warning("Reset custom", eobj, null, RESET, name,""+index,eobj.eResource().getURIFragment(eobj));
			warning("Reset partial custom", eobj, null, RESET_PARTIAL, name,""+index,eobj.eResource().getURIFragment(eobj));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not offer: "+e.getMessage());
		}
	}
}
