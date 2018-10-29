package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.http.client.fluent.Request;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import Citizen.Alle;
import Citizen.CitizenPackage;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyValue;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;
import at.ac.tuwien.big.example.reqLang.RequirementsLangStandaloneSetup;
import at.ac.tuwien.big.school.SchoolTextStandaloneSetup;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ObjectCreatorGenerator;
import at.ac.tuwien.big.vfunc.nbasic.xtext.CompleteFileHandler;
import at.ac.tuwien.big.virtlang.VirtLangStandaloneSetup;
import at.ac.tuwien.big.virtlang.virtLang.VirtLangFactory;
import at.ac.tuwien.big.virtlang.virtLang.VirtualModel;
import at.ac.tuwien.big.vmod.ecore.impl.SimpleVMEObject;
import at.ac.tuwien.big.vobjlang.VObjectLangStandaloneSetup;
import at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicValidator;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.DocumentChanger;
import requirements.RequirementsPackage;
import router.RouterPackage;
import school.Pupil;
import school.School;
import school.SchoolFactory;
import school.SchoolPackage;

public class VOMTest {
	
	
	private static File rootVFile = new File("E:\\patrick\\");
	static {
		if (!rootVFile.exists()) {
			rootVFile = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\");
		}
		rootVFile = new File(rootVFile.getAbsolutePath()+File.separator+"\\virtualedit\\");
	}

	private static Map<Class<? extends ISetup>, String> setupExtension = new HashMap<>();
	
	public static void buildVOMFile(CompleteFile file) {
		EcoreDef schoolDef = VObjectModelFactory.eINSTANCE.createEcoreDef();
		schoolDef.setPackagePackage(SchoolPackage.class.getCanonicalName());
		EcoreDef citizenDef = VObjectModelFactory.eINSTANCE.createEcoreDef();
		citizenDef.setPackagePackage(CitizenPackage.class.getCanonicalName());
		file.getEcoredef().addAll(Arrays.asList(schoolDef,citizenDef));
		
		file.getInputModels().add(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		file.getVirtModels().add(rootVFile.getAbsolutePath()+"\\Test\\test.virt");
		File 	citFile = new File(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		VMEObject school = null; 
		try {
			EObjectManager manager = new EObjectManager();
			manager.addKnown(SchoolPackage.eINSTANCE);
			manager.addKnown(CitizenPackage.eINSTANCE);
			manager.knowVirtualDefinition((VirtualModel)ConvertToXmi.getVirtLangResource(new File(rootVFile.getAbsolutePath()+"\\Test\\test.virt")).getContents().get(0));
			Resource r = ConvertToXmi.getXmiResource(citFile);
			VMEObject testCit = manager.getFakeVirtual(((Alle)r.getContents().get(0)).getCitizens().get(0));
			Identifier id = VObjectModelFactory.eINSTANCE.createIdentifier();
			CreatorId cid = VObjectModelFactory.eINSTANCE.createCreatorId();
			cid.setName("CitizenPupils");
			id.setCreatorid(cid);
			IdentifierRef ir = VObjectModelFactory.eINSTANCE.createIdentifierRef();
			ir.setS_identifier(testCit.getIdentificator());
			id.getIdentifierreforcmp().add(ir);
			id.init();
			
			ModelDeltaVMEObject newObject = manager.getNewObject(SchoolPackage.eINSTANCE.getPupil());
			VMEObject baseObject = manager.getObject(id);
			newObject.addBaseEObject(baseObject);
			
			school = manager.getNewObject(SchoolPackage.eINSTANCE.getSchool());
			school.eSet(SchoolPackage.eINSTANCE.getSchool_Pupils(), Collections.singleton(newObject));
			
			file.getRootObjects().add(school.getIdentificator());
			VObjDeltaModel deltamodel = file.getDeltamodel();
			if (deltamodel == null) {
				file.setDeltamodel(deltamodel = VObjectModelFactory.eINSTANCE.createVObjDeltaModel());
			}
			manager.storeDelta(deltamodel);
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
	

	public static void buildVOMFileRouter(CompleteFile file) {
		EcoreDef schoolDef = VObjectModelFactory.eINSTANCE.createEcoreDef();
		schoolDef.setPackagePackage(RequirementsPackage.class.getCanonicalName());
		EcoreDef citizenDef = VObjectModelFactory.eINSTANCE.createEcoreDef();
		citizenDef.setPackagePackage(RouterPackage.class.getCanonicalName());
		file.getEcoredef().addAll(Arrays.asList(schoolDef,citizenDef));
		
		file.getInputModels().add(rootVFile.getAbsolutePath()+"\\router\\model\\Router.xmi");
		file.getVirtModels().add(rootVFile.getAbsolutePath()+"\\Test\\testrouter.virt");
		//File 	citFile = new File(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		VMEObject school = null; 
		try {
			EObjectManager manager = new EObjectManager();
			manager.addKnown(RequirementsPackage.eINSTANCE);
			manager.addKnown(RouterPackage.eINSTANCE);
			manager.knowVirtualDefinition((VirtualModel)ConvertToXmi.getVirtLangResource(new File(rootVFile.getAbsolutePath()+"\\Test\\test.virt")).getContents().get(0));
			//Resource r = ConvertToXmi.getXmiResource(citFile);
			
			school = manager.getNewObject(RequirementsPackage.eINSTANCE.getRequirementsSystem());
			
			file.getRootObjects().add(school.getIdentificator());
			VObjDeltaModel deltamodel = file.getDeltamodel();
			if (deltamodel == null) {
				file.setDeltamodel(deltamodel = VObjectModelFactory.eINSTANCE.createVObjDeltaModel());
			}
			manager.storeDelta(deltamodel);
			file.setLastModelText("School {	pupils {		Pupil bla {			grades { Grade  { grade 4 course c1  } }		}	}	courses {		Course c1 , Course c2	}");
			LanguageDef ld = VObjectModelFactory.eINSTANCE.createLanguageDef();
			ld.setLangStandaloneSetup(RequirementsLangStandaloneSetup.class.getCanonicalName());
			file.setXtextlanguage(ld);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doThingsWithVOM(file);
	}

	public static AnyValue containmentAv(AnyValue av) {
		if (av instanceof JavaValue) {
			return EcoreUtil.copy(av);
		} else if (av instanceof IdentifierRef) {
			IdentifierRef ir = (IdentifierRef)av;
			IdentifierCmp ret = VObjectModelFactory.eINSTANCE.createIdentifierCmp();
			ret.setS_identifier(containmentId(ir.getS_identifier()));
			return ret;
		} else if (av instanceof IdentifierCmp) {
			IdentifierCmp ir = (IdentifierCmp)av;
			IdentifierCmp ret = VObjectModelFactory.eINSTANCE.createIdentifierCmp();
			ret.setS_identifier(containmentId(ir.getS_identifier()));
			return ret;
		} else {
			throw new RuntimeException("Unknown "+av);
		}
	}
	
	public static Identifier containmentId(Identifier id) {
		try {
		Identifier ret = EcoreUtil.copy(id);
		ret.getIdentifierreforcmp().replaceAll(x->containmentAv(x));
		ret.init();
		return ret;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not copy "+id+": "+e.getMessage());
			return id;
		}
	}
	
	public static void doThingsWithVOM(CompleteFile file) {
		CompleteFileHandler cfh = new CompleteFileHandler(file);
		SchoolTextStandaloneSetup setup = new SchoolTextStandaloneSetup();
		Injector injector = setup.createInjectorAndDoEMFRegistration(); 
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		LanguageDef xtextlanguage = file.getXtextlanguage();
		if (xtextlanguage != null && xtextlanguage.getLangStandaloneSetup() != null) {
			Class<? extends ISetup> setupClass;
			try {
				setupClass = (Class<? extends ISetup>)Class.forName(xtextlanguage.getLangStandaloneSetup());
				XtextResource res = getVirtLangResource(file.getLastModelText(), setupClass);
				for (EObject cont: (Iterable<EObject>)(()->res.getAllContents())) {
					System.out.println("loaded: "+cont);
				}
				ModelCorrespondance corr = new SimpleModelCorrespondance();
				;
				SimpleModelCorrespondance subCor = new SimpleModelCorrespondance();
				//We don't need to create any virtual objects here
				InstanceCreator creator = InstanceCreator.DEFAULT;
				//Zuerst der Modellbasierte, dann der Textbasierte Patch
				VMEObject testSchool = cfh.getEManager().getNewObject(SchoolPackage.eINSTANCE.getSchool());//new DeltaVMEObject(manager, null, VObjectModelFactory.eINSTANCE.createIdentifier(), , new ArrayList<>());
				//testSchool = new DeltaVMEObject(manager, null, VObjectModelFactory.eINSTANCE.createIdentifier(),SchoolPackage.eINSTANCE.getSchool() , new ArrayList<>());
				Collection<EObject> allObjs = cfh.getEManager().getAllContents();
				((Collection)testSchool.eGet(SchoolPackage.eINSTANCE.getSchool_Pupils())).addAll(allObjs.stream().filter(x->(x.eClass().getName().equals("Pupil"))).collect(Collectors.toList()));
				SimpleModelEqualizer sme = new SimpleModelEqualizer(new ArrayList<>(Arrays.asList(testSchool)), res.getContents(), corr, subCor, creator);
				sme.equalize();
				try {
					String newText = DocumentChanger.getContent(res);
					System.out.println("New text: "+newText);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
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
	
	public static String getIdentifierString(Identifier id) {
		id = containmentId(id);
		//TODO: ....
		ISetup standaloneSetup = new VObjectLangStandaloneSetup();
		Injector injector = standaloneSetup.createInjectorAndDoEMFRegistration();
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		//XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		//XtextResource ecsslResource = (XtextResource)rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
		Resource ecsslResource = resourceFactory.createResource(URI.createFileURI("fake://resource.bla"));
		ecsslResource.getContents().add(id);
		String ret = DocumentChanger.getContent(ecsslResource);
		System.out.println("Ret: "+ret);
		return ret.trim();
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
		CompleteFile sfile = VObjectModelFactory.eINSTANCE.createCompleteFile();
		buildVOMFile(sfile);
		if (true) {return;}
		//ObjectCreatorGenerator.generateRoot = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\virtualedit\\VirtModel4\\src");
		File vomFile = new File(rootVFile.getAbsolutePath()+"\\at.ac.tuwien.big.vobj.VObjectModel\\model\\CompleteFile.xmi");
		
		Resource res = ConvertToXmi.getXmiResource(vomFile);
		
		
		
		CompleteFile file = (CompleteFile)res.getContents().get(0);
		doThingsWithVOM(file);
	}
	
}
