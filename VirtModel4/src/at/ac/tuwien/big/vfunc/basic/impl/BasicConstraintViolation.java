package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.ConstraintViolation;

public class BasicConstraintViolation<Src, Target> implements ConstraintViolation<Src, Target> {

	private CompleteResult<Src, Target> assignmentResult;
	private CompleteResult<Src, Target> alternateFunctionResult;
	
	
	BasicConstraintViolation(CompleteResult<Src, Target> assignmentResult, CompleteResult<Src, Target> alternateFunctionResult) {
		this.assignmentResult = assignmentResult;
		this.alternateFunctionResult = alternateFunctionResult;
	}
	
	@Override
	public CompleteResult<Src, Target> assignmentResult() {
		return assignmentResult;
	}

	@Override
	public CompleteResult<Src, Target> alternateFunctionResult() {
		return alternateFunctionResult;
	}

	public String toString() {
		return "Had f("+assignmentResult.source()+") = "+assignmentResult.value()+" when it should be "+alternateFunctionResult.value();
	}
}
