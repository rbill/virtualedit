package at.ac.tuwien.big.sat.problem;

import java.util.Collections;

import at.ac.tuwien.big.sat.problem.impl.Sat4JSolver;

public interface Solver {
	
	public SatSolution solve(SatProblem problem);
	
	public static Solver createDefaultSolver() {
		return new Sat4JSolver();
	}
	
	public default Iterable<SatSolution> solveMultiple(SatProblem problem) {
		SatSolution ret = solve(problem);
		if (ret == null) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(ret);
		}
	}

}
