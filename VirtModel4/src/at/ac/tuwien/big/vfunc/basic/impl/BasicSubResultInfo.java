package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;

import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.SubResultInfo;

public class BasicSubResultInfo implements SubResultInfo {

	List<CompleteResult<?, ?>> subResults;
	CompleteResult<?, ?> thisResult;
	
	public BasicSubResultInfo(List<CompleteResult<?,?>> subResults) {
		this.subResults = subResults;
	}
	
	public void initThisResult(CompleteResult<?, ?> thisResult) {
		this.thisResult = thisResult;
	}
	
	@Override
	public List<CompleteResult<?, ?>> subResults() {
		return subResults;
	}

	@Override
	public CompleteResult<?, ?> thisResult() {
		return thisResult;
	}

}
