package at.ac.tuwien.big.vfunc.basic.impl;

public class ParseState<Source, Target, S, T, U> {
	
	private BasicEEManager<Source, Target> manager;
	private RecManager<S, T, U> recManager;
	
	public ParseState(BasicEEManager<Source, Target> manager, RecManager<S, T, U> recManager) {
		this.manager = manager;
		this.recManager = recManager;
	}

	public BasicEEManager<Source, Target> getManager() {
		return manager;
	}
	
	public RecManager<S, T, U> getRecManager() {
		return recManager;
	}
	
	
	public ParseState<Source, Target, S, T, U> push(S variable, U value) {
		RecManager<S, T, U> newRecManager = recManager.push(variable, value);
		return new ParseState<>(manager, newRecManager);
	}
}
