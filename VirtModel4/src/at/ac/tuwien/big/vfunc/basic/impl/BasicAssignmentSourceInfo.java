package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;

public class BasicAssignmentSourceInfo<Src,Target> implements AssignmentSourceInfo<Src, Target>{

	public Assignment<Src, Target> reason;
	public Src source;
	
	public BasicAssignmentSourceInfo(Assignment<Src, Target> reason, Src source) {
		this.reason = reason;
		this.source = source;
	}
	
	@Override
	public Assignment<Src, Target> reason() {
		return reason;
	}

	@Override
	public Src source() {
		return source;
	}

}
