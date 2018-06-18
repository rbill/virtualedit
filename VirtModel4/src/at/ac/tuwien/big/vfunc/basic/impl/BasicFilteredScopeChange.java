package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.function.Function;

import org.eclipse.emf.ecore.util.EContentsEList.FeatureFilter;

import at.ac.tuwien.big.vfunc.basic.FilteredScopeChange;
import at.ac.tuwien.big.vfunc.basic.ScopeChange;

public class BasicFilteredScopeChange<This,Src> extends BasicScopeChange<This, Src> implements FilteredScopeChange<This, Src> {

	private Function<? super Src, Boolean> added;
	private Function<? super Src, Boolean> deleted;
	private Class<Src> clazz;
	
	public BasicFilteredScopeChange(This source, Class<Src> clazz, Function<? super Src, Boolean> added, Function<? super Src, Boolean> deleted) {
		super(source);
		this.added = added;
		this.deleted = deleted;
		this.clazz = clazz;
	}

	@Override
	public boolean wasAdded(Object src) {
		return clazz.isInstance(src) && added.apply((Src)src);
	}

	@Override
	public boolean wasDeleted(Object src) {
		return clazz.isInstance(src) && deleted.apply((Src)src);
	}


}
