package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;

import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.FunctionSourceInfo;

public class ConstantExpression<Source,Target> implements Expression<Source, Target> {
	
	private final Target target;
	
	public ConstantExpression(Target target) {
		this.target = target;
	}

	@Override
	public Target calcResult(AssignmentSourceInfo<Source, Target> src, List<CompleteResult<?, ?>> subResultInfos) {
		return target;
	}
	
	
}
