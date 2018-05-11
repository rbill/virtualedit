package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Collection;

import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;

public class SetScope<Src> implements FixedFinitScope<Src> {
	
	private Collection<Src> scope;
	
	public SetScope(Collection<Src> scope) {
		this.scope = scope;
	}

	@Override
	public Collection<Src> getValues() {
		return scope;
	}

}
