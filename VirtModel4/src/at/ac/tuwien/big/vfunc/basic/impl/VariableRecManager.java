package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.MyCloneable;

public class VariableRecManager extends RecManager<String, VariableType, VariableTypeContent> implements MyCloneable<VariableRecManager> {	
	
	public static final String RETURN_VAR = "$ret";

	public VariableRecManager(VariableRecManager parent) {
		super(parent, (x)->new VariableType(), (x)->x.getContent(), (x,y)->x.setContent(y), RETURN_VAR);
	}

	public VariableRecManager push() {
		return new VariableRecManager((VariableRecManager) getParent());
	}
	
	@Override
	public VariableRecManager push(String variable, VariableTypeContent value) {
		return (VariableRecManager)super.push(variable, value);
	}	
	
	public void set(String variable, Object newContent) {
		VariableType var = getOrCreate(variable);
		VariableTypeContent vtc = var.getContent();
		if (vtc == null) {
			vtc = new VariableTypeContent();
			var.setContent(vtc);
		}
		vtc.setValue(newContent);
	}

	@Override
	public VariableRecManager initClone() {
		VariableRecManager ret = new VariableRecManager(null);
		return ret;
	}
	
	public void finishClone(VariableRecManager previous, Map<Object,Object> map) {
		this.parent = (VariableRecManager)cloneSub(previous.getParent(), map);
		this.usedVariables = cloneSub(previous.usedVariables, map);
		//TODO: VariableType ist konstant, oder?
		this.subManagers = cloneSub(previous.subManagers, map);
		this.map = cloneSub(previous.map, map);
	}
}
