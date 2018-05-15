package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.HashMap;
import java.util.HashSet;

import at.ac.tuwien.big.vfunc.op.BasicObjectLoader;
import at.ac.tuwien.big.vfunc.op.BasicOperationManager;

public class ParseState<Source, Target> {
	
	private GeneralParseContainer manager;
	private VariableRecManager recManager;
	
	public ParseState(GeneralParseContainer manager, VariableRecManager recManager) {
		this.manager = manager;
		this.recManager = recManager;
	}

	public GeneralParseContainer getManager() {
		return manager;
	}
	
	public BasicOperationManager getLoader() {
		return manager.loader();
	}
	
	public VariableRecManager getRecManager() {
		return recManager;
	}
	
	
	public void addFunction(String variable, String newFunctionType, Object... newParam) {
		BasicOperationManager loader = getLoader();
		Object content = loader.createNew(newFunctionType, newParam);
		VariableTypeContent vtc = new VariableTypeContent();
		vtc.setValue(content);
		add(variable, vtc);
	}


	public void addSet(String variable) {
		Object content = new HashSet<>();
		VariableTypeContent vtc = new VariableTypeContent();
		vtc.setValue(content);
		add(variable, vtc);
	}
	
	public Object getContent(String variable) {
		VariableTypeContent value = recManager.getValue(variable);
		if (value == null) {
			System.err.println("Variable "+variable+" not declared!");
		}
		return value.getAssignExpression();
	}
	
	
	public void add(String variable, VariableTypeContent initValue) {
		recManager.createDirect(variable);
		if (initValue != null) {
			recManager.setValue(variable, initValue);
		}
	}
	
	public void reset(String variable, VariableTypeContent newValue) {
		recManager.setValue(variable, newValue);
	}
	
	//Ich brauche Placeholder-Variablen
	public ParseState<Source, Target> push(String variable, VariableTypeContent value) {
		VariableRecManager newRecManager = recManager.push(variable, value);
		return new ParseState<>(manager, newRecManager);
	}
	
	//Mit dem sollte ich dann bestimmte Sachen resolven können
	//eigentlich sollte ich niemals auf eine Variable zugreifen können die nicht definiert ist
	public VariableTypeContent accessOrFail(String name) {
		VariableTypeContent ret = recManager.getValue(name);
		if (ret == null) {
			throw new NullPointerException("Variable "+name+" not defined!");
		}
		return ret;
	}
}
