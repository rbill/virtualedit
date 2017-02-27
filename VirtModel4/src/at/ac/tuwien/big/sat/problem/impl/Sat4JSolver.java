package at.ac.tuwien.big.sat.problem.impl;

import java.util.concurrent.TimeoutException;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;

import at.ac.tuwien.big.sat.problem.SatProblem;
import at.ac.tuwien.big.sat.problem.SatSolution;
import at.ac.tuwien.big.sat.problem.Solver;

public class Sat4JSolver implements Solver {
	
	private static final long timeOutMs = 1000;

	@Override
	public SatSolution solve(SatProblem problem) {
		ISolver solver = SolverFactory.newLight();
		for (int[] cs: problem.getConstraints()) {
			IVecInt intAr = new VecInt(cs);
			try {
				solver.addClause(intAr);
			} catch (ContradictionException e) {
				e.printStackTrace();
				return null;
			}			
		}
		solver.setTimeoutMs(timeOutMs);
		try {
			if (solver.isSatisfiable()) {
				int[] model = solver.primeImplicant();
				return new SimpleSatSolution(problem.getVarSize(),model);
			}
		} catch (org.sat4j.specs.TimeoutException e) {
			System.err.println("Solving timeout!");
		}
		return null;
	}

}
