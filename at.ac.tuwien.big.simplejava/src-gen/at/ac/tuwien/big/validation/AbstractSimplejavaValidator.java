/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractSimplejavaValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(at.ac.tuwien.big.simplejava.SimplejavaPackage.eINSTANCE);
		return result;
	}
	
}
