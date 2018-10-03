package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import Citizen.CitizenPackage;
import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.IdentifierRef;
import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ClassGenerationManager;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ObjectCreatorGenerator;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.xmlintelledit.intelledit.xtext.DynamicValidator;
import school.SchoolPackage;

public class OclTest {


	public static void main(String[] args) throws IOException {
		
		ObjectCreatorGenerator.generateRoot = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\virtualedit\\VirtModel4\\src");
		
		EObjectManager manager = new EObjectManager();
		manager.addKnown(SchoolPackage.eINSTANCE);
		manager.addKnown(CitizenPackage.eINSTANCE);
		File virtFile = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\virtualedit\\Test\\test.virt");
		if (!virtFile.exists()) {
			virtFile = new File("E:\\patrick\\virtualedit\\Test\\test.virt");
		}
		Resource vl = EObjectManager.getVirtLangResource(virtFile);
		manager.knowVirtualDefinition((at.ac.tuwien.big.virtlang.virtLang.VirtualModel)vl.getContents().get(0));
		
		
		/*Resource r = ConvertToXmi.getXmiResource(new File("C:\\Users\\Robert\\Documents\\eclipse-modeling-neon-2-win32-x86_64\\eclipse\\workspacePatrickMaven\\at.ac.tuwien.big.virtlang.examples.school\\model\\School.xmi"));
		manager.knowResource(r);*/
		File citFile = new File("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\virtualedit\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		if (!citFile.exists()) {
			citFile = new File("E:\\patrick\\virtualedit\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi");
		}
		Resource r = ConvertToXmi.getXmiResource(citFile);
		manager.knowResource(r);
		
		VMEObject testCit = manager.getFakeVirtual(r.getContents().get(0));
		
		Identifier id = VObjectModelFactory.eINSTANCE.createIdentifier();
		CreatorId cid = VObjectModelFactory.eINSTANCE.createCreatorId();
		cid.setName("CitizenPupils");
		id.setCreatorid(cid);
		IdentifierRef ir = VObjectModelFactory.eINSTANCE.createIdentifierRef();
		ir.setS_identifier(testCit.getIdentificator());
		id.getIdentifierreforcmp().add(ir);
		id.init();
		
		VMEObject testPup = manager.getObject(id);
		System.out.println("Citizen: "+testCit);
		System.out.println("Pupil: "+testPup);
		
		testCit.eSet(testCit.eClass().getEStructuralFeature("name"), "blabla");
		

		System.out.println("Citizen: "+testCit);
		System.out.println("Pupil: "+testPup);
		
		CEobjectManager cmanager = new CEobjectManager(manager);
		//cmanager.addContents(r.getContents());
		VirtualResource vr = new VirtualResource(manager);
		vr.addRoot(testPup);
		cmanager.initWith(vr);
		
		for (EObject eobj: cmanager.getContents()) {
			System.out.println("Converted to: "+eobj);
			try {
			Field checkName = eobj.getClass().getDeclaredField("check_nameCorrect");
			ClassLoader cl = eobj.getClass().getClassLoader();
			if (checkName != null) {
				checkName.setAccessible(true);
				System.out.println("check name: "+checkName.getBoolean(eobj));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		/*
		ClassGenerationManager cgm = new ClassGenerationManager();
		cgm.knowPackage(SchoolPackage.eINSTANCE);
		cgm.knowPackage(CitizenPackage.eINSTANCE);
		ObjectCreatorGenerator ocg = new ObjectCreatorGenerator(cmanager, cgm);
		for (ObjectCreator creator: manager.getCreators()) {
			System.out.println("For "+creator.getName()+":");
			System.out.println(ocg.generate(creator));
		}
		System.out.println(ocg.generate(SchoolPackage.eINSTANCE.getPupil()));
		System.out.println(ocg.generate(CitizenPackage.eINSTANCE.getBurger()));
		*/
		DynamicValidator dv = new DynamicValidator();
		ResourceImpl tempRes = new ResourceImpl();
		tempRes.getContents().addAll(cmanager.getContents());
		dv.checkFile(tempRes);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DynamicValidator finished!");
	} 
}
