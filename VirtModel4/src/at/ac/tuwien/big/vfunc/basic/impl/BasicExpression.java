package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Expression;

public class BasicExpression<Source, Target> implements Expression<Source, Target> {
	
	private Function<Source,Target> function;
	
	public BasicExpression(Function<Source, Target> func) {
		this.function = func;
	}

	@Override
	public Target calcResult(AssignmentSourceInfo<Source, Target> src, List<CompleteResult<?, ?>> subResultInfos) {
		return function.apply(src.source());
	}

}
