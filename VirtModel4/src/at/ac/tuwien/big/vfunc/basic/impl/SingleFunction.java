package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.ValueCache;

public class SingleFunction<Src,Target> implements VFunction<Src, Target> {
	
	private Assignment<Src, Target> assignment;
	private BasicValueCache<Src, Target> bvc;
	
	public SingleFunction(Assignment<Src, Target> assignment) {
		this.assignment = assignment;
		this.bvc = new BasicValueCache<>(assignment.getFunction().cache().isSorted());
	}
	
	
	public SingleFunction(Expression<Src, Target> expression) {
		Scope<Src> scope = new BasicInfiniteScope<>(x->true);
		this.assignment = new BasicAssignment<>(this, scope, expression, Editor.NO_EDITOR, AssignmentType.SOFT);
		this.bvc = new BasicValueCache<>(assignment.getFunction().cache().isSorted());
	}

	@Override
	public CompleteResult<Src, Target> priv_calcResult(Src source) {
		AssignmentSourceInfo<Src, Target> asi = new BasicAssignmentSourceInfo<>(assignment, source);
		return assignment.getExpression().apply(asi);
	}

	@Override
	public ValueCache<Src, Target> cache() {
		return bvc;
	}
	
	public Assignment<Src, Target> getAssignment() {
		return assignment;
	}

	@Override
	public Scope<Src> getScope() {
		return assignment.getScope();
	}

	@Override
	public FunctionType<Src,Target> getType() {
		return assignment.getFunction().getType();
	}
	
	

}
