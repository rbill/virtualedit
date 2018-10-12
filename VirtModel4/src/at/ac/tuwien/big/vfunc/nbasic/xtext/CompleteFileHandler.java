package at.ac.tuwien.big.vfunc.nbasic.xtext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.ConvertToXmi;
import at.ac.tuwien.big.vfunc.nbasic.ecore.DeltaVMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VMEObject;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VOMTest;
import at.ac.tuwien.big.vfunc.nbasic.ecore.VirtualResource;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;

public class CompleteFileHandler {
	
	public static String getIdentifierString(Identifier id) {
		return VOMTest.getIdentifierString(id);
	}
	private CompleteFile cf;

	private CEobjectManager cmanager;
	
	public CompleteFileHandler(CompleteFile cf) {
		this.cf = cf;
		init();
	}
	
	public List<EObject> exposeContents() {
		//TODO: Ich glaube ich möchte die cf aktualisieren, wenn sich da was ändert, oder?
		return this.cmanager.getContents();
	}
	
	public CEobjectManager getCManager() {
		return this.cmanager;
	}
	
	public Collection<? extends BasicDerivationStatus> getDerivationStatus(VMEObject uuidObj, EStructuralFeature esf) {
		List<BasicDerivationStatus> ret = new ArrayList<>();
		if (uuidObj instanceof DeltaVMEObject) {
			return ((DeltaVMEObject)uuidObj).getDerivationStatus(esf);
		}
		return ret;
	}
	
	public EObjectManager getEManager() {
		return this.cmanager.getEObjectManager();
	}

	private void init() {
		CompleteFile file = this.cf;
		String currentText = file.getCurrentModelText();
		VObjDeltaModel deltaModel = file.getDeltamodel();
		if (file.getDeltamodel() == null) {
			deltaModel = VObjectModelFactory.eINSTANCE.createVObjDeltaModel();
			file.setDeltamodel(deltaModel);
		}
		List<EcoreDef> ecD = file.getEcoredef();
		EObjectManager manager = new EObjectManager();
		for (EcoreDef ed: ecD)  {
			String fp = ed.getFactoryPackage();
			String pp = ed.getPackagePackage();
			try {
				Class<?> cl = Class.forName(pp);
				Field f = cl.getField("eINSTANCE");
				manager.addKnown((EPackage)f.get(null));
			} catch (Exception e) {
				System.err.println("Could not load ePackage "+pp+": "+e.getMessage());
			}
		} 
		for (String vm: file.getVirtModels()) {
			File virtFile = new File(vm);
			if (!virtFile .exists()) {
				System.err.println("Could not find: "+vm);
				continue;
			}

			Resource vl;
			try {
				vl = EObjectManager.getVirtLangResource(virtFile);
				manager.knowVirtualDefinition((at.ac.tuwien.big.virtlang.virtLang.VirtualModel)vl.getContents().get(0));
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Could not load virtual file "+vm+": "+e.getMessage());
			}
		}
		
		for (String im: file.getInputModels()) {
			File inputFile = new File(im);
			if (!inputFile .exists()) {
				System.err.println("Could not find: "+im);
				continue;
			}

			try {
			Resource r = ConvertToXmi.getXmiResource(inputFile);
			manager.knowResource(r);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not load input model file "+im+": "+e.getMessage());
		}
		}
		manager.loadDelta(deltaModel);
		VirtualResource vr = new VirtualResource(manager);
		for (Identifier id: file.getRootObjects()) {
			String str = getIdentifierString(id);
			System.out.println("Identifier: "+str);
			System.out.println("Rebuilt: "+EObjectManager.getIdentifier(str));
			id.init();
			vr.addRoot(manager.getObject(id));
		}
		this.cmanager = new CEobjectManager(manager);
		this.cmanager.initWith(vr);
		
		for (EObject eobj: this.cmanager.getContents()) {
			System.out.println("Loaded: "+eobj);			
		}
		
	}
	
	public void load(Resource from) {
		try {
			this.cf = (CompleteFile)from.getContents().get(0);
			init();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not load complete file: "+e.getMessage());
		}
	}

	public void save() {
		VObjDeltaModel dm = this.cf.getDeltamodel();
		if (dm == null) {
			this.cf.setDeltamodel(dm = VObjectModelFactory.eINSTANCE.createVObjDeltaModel());
		}
		getCManager().getEObjectManager().storeDelta(dm);
		Resource res = this.cf.eResource();
		if (res != null) {
			try {
				res.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
