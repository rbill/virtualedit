package at.ac.tuwien.big.vmodel.deltageneration;

import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.vmodel.ecore.VModelView;

public interface EObjectModification {

	public void modify(String uuid, EObject eobj, VModelView baseModel, VModelView editModel, VModelView deltaModel);
}
