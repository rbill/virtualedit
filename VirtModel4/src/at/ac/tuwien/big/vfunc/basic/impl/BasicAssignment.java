package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Collection;
import java.util.Collections;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.ValueCache;

public class BasicAssignment<Src,Target> implements Assignment<Src, Target> {

	private SingleFunction<Src, Target> sf;
	private VFunction<Src, Target> parentFunction;
	private Expression<Src, Target> expression;
	private Editor editor;
	private AssignmentType type;
	private Scope<Src> scope;
	
	public BasicAssignment(VFunction<Src, Target> parentFunction, Scope<Src> scope, Expression<Src, Target> expression, Editor editor, AssignmentType at) {
		this.parentFunction = parentFunction;
		this.expression = expression;
		this.editor = editor;
		this.type = at;
		this.scope = scope;
		this.sf = new SingleFunction<>(this);
	}
	
	private BasicAssignment(Expression<Src, Target> expression, AssignmentType type) {
		this(BasicInfiniteScope.EVERYTHING(),expression,Editor.NO_EDITOR,type);
	}
	
	public static<Src,Target> BasicAssignment<Src, Target> getSoftAssignment(Expression<Src, Target> expression) {
		return new BasicAssignment<Src, Target>(expression, AssignmentType.SOFT);
	}
	
	private BasicAssignment(Scope<Src> scope, Expression<Src, Target> expression, Editor editor, AssignmentType at) {
		this.expression = expression;
		this.editor = editor;
		this.type = at;
		this.scope = scope;
		this.sf = new SingleFunction<>(this);
		this.parentFunction = this.sf;
	}
	
	public BasicAssignment(VFunction<Src, Target> parentFunction, Collection<Src> scope, Target target, Editor editor, AssignmentType type) {
		this(parentFunction,new SetScope<Src>(scope), new ConstantExpression<Src, Target>(target), editor,type);
	}
	


	public BasicAssignment(VFunction<Src, Target> parentFunction, Src source, Target target, Editor editor, AssignmentType type) {
		this(parentFunction,Collections.singleton(source), target, editor,type);
	}	
	
	
	@Override
	public VFunction<Src, Target> getFunction() {
		return parentFunction;
	}

	@Override
	public Scope<Src> getScope() {
		return scope;
	}

	@Override
	public Expression<Src, Target> getExpression() {
		return expression;
	}

	@Override
	public Editor getEditor() {
		return editor;
	}

	//Der cache hier muss der eigene sein ...
	@Override
	public ValueCache<Src, Target> getCacheIfExists() {
		return sf.cache();
	}

	//Der cache hier muss der eigene sein ...
	@Override
	public SingleFunction<Src, Target> getFunctionIfExists() {
		return sf;
	}

	@Override
	public AssignmentType getType() {
		return type;
	}
	
	public SingleFunction<Src, Target> getSingleFunction() {
		return sf;
	}
	

}
