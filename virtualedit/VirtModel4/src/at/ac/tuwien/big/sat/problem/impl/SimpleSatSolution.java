package at.ac.tuwien.big.sat.problem.impl;

import java.util.Arrays;

import at.ac.tuwien.big.sat.problem.SatSolution;

public class SimpleSatSolution implements SatSolution {
	private boolean[] trueVariables;
	private boolean[] falseVariables;
	
	public SimpleSatSolution(int varSize, int... literals) {
		for (int i = 0; i < literals.length; ++i) {
			varSize = Math.max(Math.abs(literals[i]), varSize);
		}
		trueVariables = new boolean[varSize];
		falseVariables = new boolean[varSize];
		for (int i = 0; i < literals.length; ++i) {
			if (literals[i] < 0) {
				falseVariables[-literals[i]] = true;
			} else {
				trueVariables[literals[i]] = true;
			}
		}
	}
	
	public SimpleSatSolution(boolean[] trueVar, boolean[] falseVar) {
		this.trueVariables = trueVar;
		this.falseVariables = falseVar;
	}
	
	public SimpleSatSolution(boolean... variables) {		
		this.trueVariables = variables;
		this.falseVariables = Arrays.copyOf(trueVariables, trueVariables.length);
		for (int i = 0; i < falseVariables.length; ++i) {
			falseVariables[i] = !falseVariables[i];
		}
	}

	@Override
	public boolean isTrue(int varIndex) {
		return trueVariables[varIndex];
	}

	@Override
	public boolean isFalse(int varIndex) {
		return falseVariables[varIndex];
	}

}
