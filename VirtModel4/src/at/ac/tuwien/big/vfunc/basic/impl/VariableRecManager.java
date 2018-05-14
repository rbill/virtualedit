package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class VariableRecManager extends RecManager<String, VariableType, VariableTypeContent> {	
	
	public VariableRecManager(VariableRecManager parent) {
		super(parent, (x)->new VariableType(), (x)->x.getContent(), (x,y)->x.setContent(y), "$ret");
	}

	public VariableRecManager push() {
		return new VariableRecManager((VariableRecManager) getParent());
	}
	
	@Override
	public VariableRecManager push(String variable, VariableTypeContent value) {
		return (VariableRecManager)super.push(variable, value);
	}	
}
