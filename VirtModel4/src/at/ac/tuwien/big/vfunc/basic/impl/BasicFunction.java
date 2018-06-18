package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.ValueCache;
import at.ac.tuwien.big.vmod.Function;

public class BasicFunction<Src,Target> implements VFunction<Src, Target>{
	
	private BasicValueCache<Src, Target> bvc;
	private FunctionType<Src, Target> type;
	
	public BasicFunction(boolean isSorted, FunctionType<Src, Target> type) {
		bvc = new BasicValueCache<Src,Target>(isSorted);
		bvc.initFunction(this);
		this.type = type;
	}

	@Override
	public CompleteResult<Src, Target> priv_calcResult(Src source) {
		//1. Calculate the result of each subfunction
		//We probably know that the value is not assigned as then the cache would not have returned null
		//2. 
		
		//I think when the assignment is added, the values should be calculated already??
		
		// TODO Auto-generated method stub
		return bvc.getOrCreate(source);
	}

	@Override
	public ValueCache<Src, Target> cache() {
		return bvc;
	}
	
	public void addBasicConstraint(java.util.function.Function<Src,Boolean> scopeFunc, java.util.function.Function<Src,Target> targetFunc, Editor editor) {
		Scope<Src> scope = new BasicInfiniteScope<>(scopeFunc); 
		Expression<Src, Target> target = new BasicExpression<>(targetFunc);
		BasicAssignment<Src, Target> bas = new BasicAssignment<>(this, scope, target, editor, AssignmentType.CONSTRAINT);
		addAssignment(bas, AssignmentType.CONSTRAINT);
	}
	
	public void addBasicConstraint(java.util.function.Function<Src,Target> funcOrNull, Editor editor) {
		java.util.function.Function<Src,Boolean> scopeFunc = (x)->{try {
			return funcOrNull.apply(x)!=null;
		} catch (Exception e) {
			return false;
		}};
		addBasicConstraint(scopeFunc, funcOrNull, editor);
	}

	public void addBasicAssignment(Src source, Target target, Editor editor, AssignmentType type) {
		addBasicAssignment(Collections.singleton(source), target, editor, type);
	}
	
	public void addBasicAssignment(Collection<Src> source, Target target, Editor editor, AssignmentType type) {
		BasicAssignment<Src, Target> bas = new BasicAssignment<>(this, source, target, editor, type);
		addAssignment(bas, type);
	}

	public void addAssignment(Assignment<Src, Target> ass, AssignmentType type) {
		bvc.addAssignment(ass, type);
	}

	@Override
	public FixedFinitScope<Src> getScope() {
		return bvc.getScope();
	}

	@Override
	public FunctionType<Src, Target> getType() {
		return type;
	}

	public List<ConstraintViolation<Src, Target>> getConstraintViolations() {
		List<ConstraintViolation<Src, Target>> violations = new ArrayList<>();
		bvc.getConstraintViolations(violations);
		return violations;
	}

	public void removeAssignments(Scope<?> scope) {
		throw new UnsupportedOperationException("Deleting things not yet supported!");
	}
}
