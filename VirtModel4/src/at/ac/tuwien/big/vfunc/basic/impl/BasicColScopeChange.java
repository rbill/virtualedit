package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Collection;

import com.google.inject.Scopes;

import at.ac.tuwien.big.vfunc.basic.IterableScopeChange;

public class BasicColScopeChange<This,Src> extends BasicScopeChange<This, Src> implements IterableScopeChange<This, Src> {

	private Iterable<? extends Src> added;
	private Iterable<? extends Src> deleted;
	
	
	public BasicColScopeChange(This source, Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
		super(source);
		this.added = added;
		this.added = deleted;
	}

	@Override
	public Iterable<? extends Src> getAdded() {
		return added;
	}

	@Override
	public Iterable<? extends Src> getDeleted() {
		return deleted;
	}

}
