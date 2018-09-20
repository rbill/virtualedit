package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import uk.ac.york.cs.ecss.ecss2xtext.ConvertToXmi;

public class DeltaObjectTest {

	
	public static void main(String[] args) throws IOException {
		//EObjectManager mana
		EObjectManager manager = new EObjectManager();
		Resource r = ConvertToXmi.getXmiResource(new File("C:\\Users\\Robert\\Documents\\eclipse-modeling-neon-2-win32-x86_64\\eclipse\\workspacePatrickMaven\\at.ac.tuwien.big.virtlang.examples.school\\model\\School.xmi"));
		manager.knowResource(r);
		List<VMEObject> allObjs = new ArrayList<>();
		r.getAllContents().forEachRemaining(x->{
			allObjs.add(manager.getFakeVirtual(x));
		});
		for (VMEObject eobj: allObjs) {
			System.out.println("Read object: "+eobj+"\n\tcontained in "+eobj.eContainer());
			EClass ecl = eobj.eClass();
			if (ecl.getName().equals("Grade")) {
				EStructuralFeature year = ecl.getEStructuralFeature("year");
				eobj.eSet(year, ((BigInteger)eobj.eGet(year)).add(BigInteger.TEN));
				System.out.println("Modified object: "+eobj);
					
			}
		}
		r.getAllContents().forEachRemaining(x->{
			if (x.eClass().getName().equals("Grade")) {
				System.out.println("Grade year: "+x.eGet(x.eClass().getEStructuralFeature("year")));
			}
		});
	}
	
}
