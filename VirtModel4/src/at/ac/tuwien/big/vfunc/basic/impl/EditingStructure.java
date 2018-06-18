package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Collection;
import java.util.Set;
import java.util.Collections;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.virtmodel.vLang.FunctionScope;

public class EditingStructure {

	private Editor editor;
	
	public EditingStructure(Editor editor) {
		this.editor = editor;
	}
	

	public<Src,Target> void addBasicExpression(BasicFunction<Src, Target> func, Scope<Src> source, Expression<Src,Target> expression, AssignmentType type) {
		BasicAssignment<Src, Target> bas = new BasicAssignment<Src, Target>(func, source, expression, editor, type);
		addAssignment(func, bas,  type);
	}
	
	public<Src,Target> void addBasicAssignment(BasicFunction<Src, Target> func, Src source, Target target, AssignmentType type) {
		addBasicAssignment(func, (Collection<Src>) Collections.singleton(source), target,  type);
	}
	

	public<Src,Target> void addBasicAssignment(VFunction<Src,Target> forFunc, BasicValueCache<Src, Target> func, Src source, Target target, AssignmentType type) {
		addBasicAssignment(forFunc, func, (Collection<Src>) Collections.singleton(source), target,  type);
	}
	
	public<Src,Target> void addBasicAssignment(BasicFunction<Src, Target> func, Collection<Src> source, Target target, AssignmentType type) {
		BasicAssignment<Src, Target> bas = new BasicAssignment<>(func, source, target, editor, type);
		addAssignment(func, bas, type);
	}

	public<Src,Target> void addBasicAssignment(VFunction<Src,Target> forFunc, BasicValueCache<Src, Target> func, Collection<Src> source, Target target, AssignmentType type) {
		BasicAssignment<Src, Target> bas = new BasicAssignment<>(forFunc, source, target, editor, type);
		addAssignment(func, bas, type);
	}
	
	public<Src,Target> void addAssignment(BasicFunction<Src, Target> func, Assignment<Src, Target> ass, AssignmentType type) {
		func.addAssignment(ass, type);
	}
	

	public<Src,Target> void addAssignment(BasicValueCache<Src, Target> func, Assignment<Src, Target> ass, AssignmentType type) {
		func.addAssignment(ass, type);
	}


	public Editor getEditor() {
		return editor;
	}


	public void removeDefinition(BasicFunction existingFunction, Scope<?> scope) {
		existingFunction.removeAssignments(scope);
	}
}
