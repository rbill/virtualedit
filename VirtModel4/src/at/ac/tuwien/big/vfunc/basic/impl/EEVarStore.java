package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class EEVarStore<S> {
	private final Map<S,Integer> totalVarIndex = new HashMap<>();
	private final List<S> parentVars = new ArrayList<>();
	private final List<S> currentVars = new ArrayList<S>();
	
	public EEVarStore(List<S> currentVariables, List<S> parentVariables) {
		currentVars.addAll(currentVariables);
		parentVars.addAll(parentVariables);
		for (S s: parentVariables) {
			totalVarIndex.put(s, totalVarIndex.size());
		}
		for (S s: currentVariables) {
			totalVarIndex.put(s, totalVarIndex.size()+totalVarIndex.size());
		}
	}
	
	public int getIndex(S var) {
		return totalVarIndex.getOrDefault(var,-1);
	}
	
	public Collection<? extends S> getParentVariables() {
		return parentVars;
	}
	

	public Collection<? extends S> getCurrentVariables() {
		return currentVars;
	}
	
	public int[] getIndices(EEVarStore<S> target) {
		Collection<? extends S> tvar = target.getParentVariables();
		int[] ret = new int[tvar.size()];
		int idx = 0;
		for (S var: tvar) {
			Integer myIndex = totalVarIndex.get(var);
			if (myIndex == null) {
				throw new RuntimeException("Required variable "+var+" not found in parent map!");
			}
			ret[idx] = myIndex;
			++idx;
		}
		return ret;
	}
	
	public Function<BasicEE, BasicEE> wrapFunction(EEVarStore<S> target) {
		int[] indices = getIndices(target);
		
		return (start)->start.extract(indices);
	}

}
