package at.ac.tuwien.big.vfunc.op;

import java.util.List;

import at.ac.tuwien.big.vfunc.basic.AnyParameterModifier;

/**TODO: moechte ich hier sowas verwenden oder lieber den EEModifier?*/
public interface BasicFunction {
	
	
	
	/*public Object process(Object... inputs);*/
	
	public void process(AnyParameterModifier modifier);
	
	public List<Class<?>> getRequiredInputs();
	
	public Class<?> getOutput();

}
