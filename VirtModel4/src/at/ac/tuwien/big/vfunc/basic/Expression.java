package at.ac.tuwien.big.vfunc.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.impl.BasicAssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.impl.BasicCompleteResult;
import at.ac.tuwien.big.vfunc.basic.impl.BasicSubResultInfo;

public interface Expression<Source,Target> extends Function<AssignmentSourceInfo<Source,Target>,CompleteResult<Source, Target>> {
	 
	/**Write sub result infos in subResultInfos*/
	public Target calcResult(AssignmentSourceInfo<Source, Target> src, List<CompleteResult<?, ?>> subResultInfos);
	
	/**Returns only the currently Calculated, but adds every to subResultInfos*/
	public default List<CompleteResult<?, ?>> priv_evaluateAndAdd(List<FunctionSourceInfo<?,?>> inputSources, List<CompleteResult<?, ?>> subResultInfos) {
		List<CompleteResult<?, ?>> ret = new ArrayList<CompleteResult<?,?>>();
		for (FunctionSourceInfo<?, ?> fsi: inputSources) {
			ret.add(fsi.calcResult());
		}
		subResultInfos.addAll(ret);
		return ret;
	}
	
	@Override
	public default CompleteResult<Source, Target> apply(AssignmentSourceInfo<Source, Target> src) {
		List<CompleteResult<?, ?>> sris = new ArrayList<>();
		Target trg = calcResult(src, sris);
		sris.removeIf(x->x == null); //Sometimes this may happen if no result can be found?
		BasicSubResultInfo subResult = new BasicSubResultInfo(sris);
		CompleteResult<Source,Target> ret = buildResult(src.reason(), src.source(), trg, subResult);
		subResult.initThisResult(ret);
		return ret;
	}
	
	public default CompleteResult<Source, Target> apply(Assignment<Source, Target> ass, Source src) {
		AssignmentSourceInfo<Source, Target> asi = new BasicAssignmentSourceInfo<>(ass, src);
		return apply(asi);
	}
	
	
	public default CompleteResult<Source, Target> buildResult(Assignment<Source, Target> reason, Source source, Target basicResult, SubResultInfo subResult) {
		return new BasicCompleteResult<>(reason, source, basicResult, subResult);
	}

}
