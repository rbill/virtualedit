package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import Citizen.CitizenPackage;
import VObjectModel.CompleteFile;
import VObjectModel.CreatorId;
import VObjectModel.EcoreDef;
import VObjectModel.Identifier;
import VObjectModel.IdentifierRef;
import VObjectModel.VObjDeltaModel;
import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ObjectCreatorGenerator;
import at.ac.tuwien.big.virtlang.VirtLangStandaloneSetup;
import at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicValidator;
import school.SchoolPackage;

public class VOMTest {
	
	
	private static File rootVFile = new File("E:\\patrick\\");
	static {
		if (!rootVFile.exists()) {
			rootVFile = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\");
		}
		rootVFile = new File(rootVFile.getAbsolutePath()+File.separator+"\\virtualedit\\");
	}


	public static void buildVOMFile() {
		CompleteFile file = VObjectModelFactory.eINSTANCE.createCompleteFile();
		EcoreDef schoolDef = VObjectModelFactory.eINSTANCE.createEcoreDef();
		schoolDef.setPackagePackage(SchoolPackage.class.getCanonicalName());
		EcoreDef citizenDef = VObjectModelFactory.eINSTANCE.createEcoreDef();
		citizenDef.setPackagePackage(SchoolPackage.class.getCanonicalName());
		file.getEcoredef().addAll(Arrays.asList(schoolDef,citizenDef));
		
		file.getInputModels().add(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		file.getVirtModels().add(rootVFile.getAbsolutePath()+"\\Test\\test.virt");
		File 	citFile = new File(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		try {
			EObjectManager manager = new EObjectManager();
			manager.addKnown(CitizenPackage.eINSTANCE);
			Resource r = ConvertToXmi.getXmiResource(citFile);
			VMEObject testCit = manager.getFakeVirtual(r.getContents().get(0));
			Identifier id = VObjectModelFactory.eINSTANCE.createIdentifier();
			CreatorId cid = VObjectModelFactory.eINSTANCE.createCreatorId();
			cid.setName("CitizenPupils");
			id.setCreatorid(cid);
			IdentifierRef ir = VObjectModelFactory.eINSTANCE.createIdentifierRef();
			ir.setS_identifier(testCit.getIdentificator());
			id.getIdentifierreforcmp().add(ir);
			id.init();
			file.getRootObjects().add(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doThingsWithVOM(file);
	}
	
	public static void doThingsWithVOM(CompleteFile file) {
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
			id.init();
			vr.addRoot(manager.getObject(id));
		}
		CEobjectManager cmanager = new CEobjectManager(manager);
		cmanager.initWith(vr);
		
		for (EObject eobj: cmanager.getContents()) {
			System.out.println("Loaded: "+eobj);			
		}
		
		SchoolTextStandaloneSetup setup; 
		
	}
	
	public static Resource getVirtLangResource(File ecsslFile, Class<? extends ISetup> setupClass) throws IOException {
		
		try {
			ISetup standaloneSetup= setupClass.newInstance();
			Injector injector = standaloneSetup.createInjectorAndDoEMFRegistration();
			XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
			Resource ecsslResource = rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
			return ecsslResource; 
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Resource getVirtLangResource(String text, Class<? extends ISetup> setupClass) throws IOException {
		
		try {
			ISetup standaloneSetup= setupClass.newInstance();
			Injector injector = standaloneSetup.createInjectorAndDoEMFRegistration();
			XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
			Resource ecsslResource = rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
			return ecsslResource; 
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		buildVOMFile();
		if (true) {return;}
		//ObjectCreatorGenerator.generateRoot = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\virtualedit\\VirtModel4\\src");
		File vomFile = new File(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.vobj.VObjectModel\\model\\CompleteFile.xmi");
		
		Resource res = ConvertToXmi.getXmiResource(vomFile);
		
		
		
		CompleteFile file = (CompleteFile)res.getContents().get(0);
		doThingsWithVOM(file);
	}
	
}
