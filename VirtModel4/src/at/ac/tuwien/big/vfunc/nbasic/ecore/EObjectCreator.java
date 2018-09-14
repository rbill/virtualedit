package at.ac.tuwien.big.vfunc.nbasic.ecore;

public interface EObjectCreator {

	
	public VMEObject createEObject(Object... parameters);
	
	public String getName();
	
}
