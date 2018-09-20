package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;

import Citizen.CitizenPackage;
import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.IdentifierRef;
import VObjectModel.VObjectModelFactory;
import school.SchoolPackage;
import uk.ac.york.cs.ecss.ecss2xtext.ConvertToXmi;

public class OclTest {


	public static void main(String[] args) throws IOException {
		EObjectManager manager = new EObjectManager();
		EPackageRegistryImpl.INSTANCE.put(SchoolPackage.eINSTANCE.getNsURI(), SchoolPackage.eINSTANCE);
		EPackageRegistryImpl.INSTANCE.put(CitizenPackage.eINSTANCE.getNsURI(), CitizenPackage.eINSTANCE);
		Resource vl = EObjectManager.getVirtLangResource(new File("C:\\Users\\Robert\\Documents\\eclipse-modeling-neon-2-win32-x86_64\\eclipse\\runtime-EclipseXtext\\Test\\test.virt"));
		manager.knowVirtualDefinition((at.ac.tuwien.big.virtlang.virtLang.VirtualModel)vl.getContents().get(0));
		
		
		/*Resource r = ConvertToXmi.getXmiResource(new File("C:\\Users\\Robert\\Documents\\eclipse-modeling-neon-2-win32-x86_64\\eclipse\\workspacePatrickMaven\\at.ac.tuwien.big.virtlang.examples.school\\model\\School.xmi"));
		manager.knowResource(r);*/
		
		Resource r = ConvertToXmi.getXmiResource(new File("C:\\Users\\Robert\\Documents\\eclipse-modeling-neon-2-win32-x86_64\\eclipse\\workspacePatrickMaven\\at.ac.tuwien.big.virtlang.examples.citizen\\model\\Citizen.xmi"));
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

	} 
}
