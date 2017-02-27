package at.ac.tuwien.big.sat.problem.encoding;

import at.ac.tuwien.big.sat.problem.SatProblem;
import at.ac.tuwien.big.sat.problem.SatSolution;
import at.ac.tuwien.big.sat.problem.Solver;

public interface SatEncoding<T> {

	public SatProblem getProblem();
	
	public T getSolution(SatSolution solution);
	
	public default T solve(Solver solver) {
		SatSolution sol = solver.solve(getProblem());
		if (sol == null) {
			return null;
		}
		return getSolution(sol);
	}
	
	public default T solveDefault() {
		return solve(Solver.createDefaultSolver());
	}
}
