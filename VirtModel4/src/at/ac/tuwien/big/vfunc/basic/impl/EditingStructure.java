package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Collection;
import java.util.Set;
import java.util.Collections;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.Editor;

public class EditingStructure {

	private Editor editor;
	
	public EditingStructure(Editor editor) {
		this.editor = editor;
	}
	
	public<Src,Target> void addBasicAssignment(BasicFunction<Src, Target> func, Src source, Target target, AssignmentType type) {
		addBasicAssignment(func, (Collection<Src>) Collections.singleton(source), target,  type);
	}
	
	public<Src,Target> void addBasicAssignment(BasicFunction<Src, Target> func, Collection<Src> source, Target target, AssignmentType type) {
		BasicAssignment<Src, Target> bas = new BasicAssignment<>(func, source, target, editor, type);
		addAssignment(func, bas, type);
	}

	public<Src,Target> void addAssignment(BasicFunction<Src, Target> func, Assignment<Src, Target> ass, AssignmentType type) {
		func.addAssignment(ass, type);
	}
}
