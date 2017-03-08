package at.ac.tuwien.big.sat.problem.impl;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.sat.problem.SatProblem;

public class SimpleSatProblem implements SatProblem {
	
	private int varSize;
	private List<int[]> constraints = new ArrayList<int[]>();
	
	public void addConstraint(int... constraint) {
		this.constraints.add(constraint);
		for (int i = 0; i < constraint.length; ++i) {
			varSize = Math.max(varSize, constraint[i]);
		}
	}

	@Override
	public List<int[]> getConstraints() {
		return constraints;
	}

	@Override
	public int getVarSize() {
		return varSize;
	}

}
