package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.List;

import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;

public class IdentifierInfo {

	private EObjectCreator creator;
	private List<?> parameters;
	
	public IdentifierInfo(EObjectCreator creator2, List<?> parameters) {
		this.creator = creator2;
		this.parameters = parameters;
	}
	
	public EObjectCreator getCreator() {
		return creator;
	}
	
	public List<?> getParameters() {
		return parameters;
	}
	
}
