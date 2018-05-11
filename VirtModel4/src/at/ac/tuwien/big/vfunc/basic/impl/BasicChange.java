package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.Change;

public class BasicChange<This,Source,Target> implements Change<This, Source, Target> {

	This thisValue;
	Source source;
	Target oldValue;
	Target newValue;
	
	public BasicChange(This thisValue, Source source,	Target oldValue, Target newValue) {
		this.thisValue = thisValue;
		this.source = source;		
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	@Override
	public This getThis() {
		return thisValue;
	}

	@Override
	public Source source() {
		return source;
	}
	
	@Override
	public Target oldValue() {
		return oldValue;
	}

	@Override
	public Target newValue() {
		return newValue;
	}

}
 