package at.ac.tuwien.big.vfunc.basic.impl;

public class ParseState<Source, Target> {
	
	private BasicEEManager<Source, Target> manager;
	private VariableRecManager recManager;
	
	public ParseState(BasicEEManager<Source, Target> manager, VariableRecManager recManager) {
		this.manager = manager;
		this.recManager = recManager;
	}

	public BasicEEManager<Source, Target> getManager() {
		return manager;
	}
	
	public VariableRecManager getRecManager() {
		return recManager;
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
