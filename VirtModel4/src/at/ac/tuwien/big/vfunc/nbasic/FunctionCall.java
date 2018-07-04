package at.ac.tuwien.big.vfunc.nbasic;

import javax.sound.midi.SoundbankResource;

public interface FunctionCall<Source, Target> {
	
	public AbstractFunc<Source, Target, ? extends QueryResult<Source, Target>> function();
	
	public Source source();
	
	public default QueryResult<Source, Target> getTarget() {
		return function().evaluate(source());
	}

}
