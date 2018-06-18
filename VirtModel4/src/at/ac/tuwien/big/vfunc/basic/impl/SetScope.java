package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ValueCache;
import at.ac.tuwien.big.vmod.type.impl.FunctionTypeImpl;

public class SetScope<Src> implements FixedFinitScope<Src> {
	
	//TODO: ...
	private FunctionType<Src, Boolean> scopeFunctionType = (FunctionType)new BasicFunctionType<>(Object.class, Boolean.class);
	
	private BasicValueCache<Src, Boolean> bvc;
	
	EditingStructure edS = new EditingStructure(new Editor() {
	});
	
	public SetScope(Collection<Src> scope) {
		bvc = new BasicValueCache<Src, Boolean>(false);
		for (Src src: scope) {
			edS.addBasicAssignment(this, bvc, src, true, AssignmentType.HARD);
		}
	}
	
	public void addToScope(Src src) {
		edS.addBasicAssignment(this, bvc, src, true, AssignmentType.HARD);
	}

	@Override
	public boolean contains(Src src) {
		return evaluateReduced(src);
	}
	
	@Override
	public Collection<? extends Src> getValues() {
		Set<Src> ret = new HashSet<>();
		bvc.getDirectMap().forEach((k,v)->{
			Boolean b = v.value();
			if (b != null && b) {
				ret.add(k);
			}
		});
		return ret;
	}
	
	private List<WeakReference<ChangeListenable<? super Scope<Src>, ? super Src, ? super Boolean>>> changeListeners = new ArrayList<>();

	@Override
	public List<WeakReference<ChangeListenable<? super Scope<Src>, ? super Src, ? super Boolean>>> getChangeListeners() {
		return changeListeners;
	}

	@Override
	public CompleteResult<Src, Boolean> priv_calcResult(Src source) {
		return bvc.getOrCreate(source);
	}

	@Override
	public ValueCache<Src, Boolean> cache() {
		return bvc;
	}

	@Override
	public Scope<Src> getScope() {
		return this;
	}

	@Override
	public FunctionType<Src, Boolean> getType() {
		return scopeFunctionType;
	}

}
