package at.ac.tuwien.big.vfunc.op;

import at.ac.tuwien.big.vfunc.basic.AnyParameterModifier;

public interface SimpleBasicFunction extends BasicFunction {


	
	public Object process(Object... inputs);
	
	public default void process(AnyParameterModifier modifier) {
		Object[] input = new Object[getRequiredInputs().size()];
		for (int i = 0; i < input.length; ++i) {
			if (modifier.has(i)) {
				input[i] = modifier.get(i);
			}
		}
		Object ret = process(input);
		//TODO: ... das gefällt mir nicht so ganz
		modifier.set(input.length, ret);
	}
	
}
