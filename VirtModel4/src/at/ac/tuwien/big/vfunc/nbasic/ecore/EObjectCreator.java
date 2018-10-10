package at.ac.tuwien.big.vfunc.nbasic.ecore;

import org.eclipse.emf.ecore.util.EcoreUtil;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;

public interface EObjectCreator {

	
	public VMEObject createEObject(Identifier ide, Object... parameters);
	
	public CreatorId getName();
	
	public default CreatorId getNewName() {
		return EcoreUtil.copy(getName());
	}
	
}
