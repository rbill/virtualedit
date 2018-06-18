package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.ScopeChange;

public class BasicScopeChange<This,Src> implements ScopeChange<This, Src> {
	
	private This source;
	
	public BasicScopeChange(This source) {
		this.source = source;
	}
	
	@Override
	public This source() {
		return source;
	}

}
