package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.HashMap;
import java.util.HashSet;

import at.ac.tuwien.big.vfunc.basic.io.SuperBasicFunction;
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
			return null;
		}
		return value.getAssignExpression();
	}
	
	
	public void add(String variable, VariableTypeContent initValue) {
		recManager.createDirect(variable);
		if (initValue != null) {
			recManager.setValue(variable, initValue);
		}
	}
	
	public Object[] execute(SuperBasicFunction sbf, String[] variableNames) {
		Object[] objs = new Object[variableNames.length];
		for (int i = 0; i < variableNames.length; ++i) {
			objs[i] = getContent(variableNames[i]);
		}
		return sbf.execute(objs);
	}
	
	public void set(SuperBasicFunction sbf, String[] inputVariables, String[] outputVariables) {
		Object[] returnValue = execute(sbf, inputVariables);
		if (returnValue == null) {
			if (outputVariables.length>0) {
				System.err.println("Function did not return a value when it was supposed to!");
			}
			return;
		}
		int minLen = Math.min(returnValue.length, outputVariables.length);
		for (int i = 0; i < minLen; ++i) {
			set(outputVariables[i], returnValue[i]);
		}
	}
		
	public void reset(String variable, VariableTypeContent newValue) {
		recManager.setValue(variable, newValue);
	}
	
	public void set(String variable, Object newContent) {
		recManager.set(variable, newContent);
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
