package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import Citizen.CitizenPackage;
import VObjectModel.CompleteFile;
import VObjectModel.CreatorId;
import VObjectModel.EcoreDef;
import VObjectModel.Identifier;
import VObjectModel.IdentifierRef;
import VObjectModel.LanguageDef;
import VObjectModel.VObjDeltaModel;
import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.school.SchoolTextStandaloneSetup;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ObjectCreatorGenerator;
import at.ac.tuwien.big.virtlang.VirtLangStandaloneSetup;
import at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicValidator;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.DocumentChanger;
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
			file.setLastModelText("School {	pupils {		Pupil bla {			grades { Grade  { grade 4 course c1  } }		}	}	courses {		Course c1 , Course c2	}");
			LanguageDef ld = VObjectModelFactory.eINSTANCE.createLanguageDef();
			ld.setLangStandaloneSetup(SchoolTextStandaloneSetup.class.getCanonicalName());
			file.setXtextlanguage(ld);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doThingsWithVOM(file);
	}
	
	private static Map<Class<? extends ISetup>, String> setupExtension = new HashMap<>();
	
	public static String getExtension(ISetup setup) {
		return setupExtension.computeIfAbsent(setup.getClass(), (cl)->{
			//OK, this is much more difficult than expected, unfortunately
			Map<String,Object> existingMap = new HashMap<>(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
			Injector injector = setup.createInjectorAndDoEMFRegistration();
			//Just find out what has changed due to the registration ...
			for (Entry<String, Object> entr: Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().entrySet()) {
				if (existingMap.get(entr.getKey()) != entr.getValue()) {
					return entr.getKey();
				}
			}
			System.err.println("Could not find extension for "+setup+"!");
			return "??";
		});
		
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
		
		SchoolTextStandaloneSetup setup = new SchoolTextStandaloneSetup();
		Injector injector = setup.createInjectorAndDoEMFRegistration(); 
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		LanguageDef xtextlanguage = file.getXtextlanguage();
		if (xtextlanguage != null && xtextlanguage.getLangStandaloneSetup() != null) {
			Class<? extends ISetup> setupClass;
			try {
				setupClass = (Class<? extends ISetup>)Class.forName(xtextlanguage.getLangStandaloneSetup());
				XtextResource res = (XtextResource) getVirtLangResource(file.getLastModelText(), setupClass);
				for (EObject cont: (Iterable<EObject>)(()->res.getAllContents())) {
					System.out.println("loaded: "+cont);
				}
				ModelCorrespondance corr = new SimpleModelCorrespondance();
				;
				SimpleModelCorrespondance subCor = new SimpleModelCorrespondance();
				//We don't need to create any virtual objects here
				InstanceCreator creator = InstanceCreator.DEFAULT;
				//Zuerst der Modellbasierte, dann der Textbasierte Patch
				SimpleModelEqualizer sme = new SimpleModelEqualizer(new ArrayList<>(vr.getRoots()), res.getContents(), corr, subCor, creator);
				sme.equalize();
				String newText = DocumentChanger.getContent(res);
				System.out.println("New text: "+newText);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public static XtextResource getVirtLangResource(File ecsslFile, Class<? extends ISetup> setupClass) throws IOException {
		
		try {
			ISetup standaloneSetup= setupClass.newInstance();
			Injector injector = standaloneSetup.createInjectorAndDoEMFRegistration();
			IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
			//XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
			//XtextResource ecsslResource = (XtextResource)rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
			Resource ecsslResource = resourceFactory.createResource(URI.createFileURI(ecsslFile.getCanonicalPath()));
			return (XtextResource)ecsslResource; 
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static XtextResource getVirtLangResource(String text, Class<? extends ISetup> setupClass) throws IOException {
		
		try {
			ISetup standaloneSetup= setupClass.newInstance();
			Injector injector = standaloneSetup.createInjectorAndDoEMFRegistration();
			XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
			String extension = getExtension(standaloneSetup);
			URI uri = URI.createURI("temp://bla."+extension);
			System.out.println("Temp file: "+uri.toString());
			IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
			//XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
			//XtextResource ecsslResource = (XtextResource)rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
			XtextResource res = (XtextResource) resourceFactory.createResource(uri);
			//XtextResource res = (XtextResource)rs.createResource(uri);
			if (text != null) {
				ByteArrayInputStream bis = new ByteArrayInputStream(text.getBytes());
				try {
					res.load(bis, Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return res; 
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
