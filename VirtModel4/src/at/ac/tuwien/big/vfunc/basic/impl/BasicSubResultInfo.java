package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;

import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.SubResultInfo;

public class BasicSubResultInfo implements SubResultInfo {

	List<FunctionNotifyer<?, ?, ?>> subResults;
	CompleteResult<?, ?> thisResult;
	
	public BasicSubResultInfo(List<FunctionNotifyer<?,?,?>> subResults) {
		this.subResults = subResults;
	}
	
	public void initThisResult(CompleteResult<?, ?> thisResult) {
		this.thisResult = thisResult;
	}
	
	@Override
	public List<FunctionNotifyer<?, ?, ?>> subResults() {
		return subResults;
	}

	@Override
	public CompleteResult<?, ?> thisResult() {
		return thisResult;
	}

}
