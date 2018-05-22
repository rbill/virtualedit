package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.op.BasicObjectLoader;
import at.ac.tuwien.big.vfunc.op.BasicOperationManager;

public class GeneralParseContainer {
	
	private final BasicOperationManager loader;
	private final EditingStructure editingStructor = new EditingStructure(new Editor() {
	});
	
	public GeneralParseContainer(BasicOperationManager loader) {
		this.loader = loader;
	}
	
	
	public BasicOperationManager loader() {
		return loader;
	}
	
	public Editor getEditor() {
		return editingStructor.getEditor();
	}


	public EditingStructure getEditingStructure() {
		return editingStructor;
	}
	
	

}
