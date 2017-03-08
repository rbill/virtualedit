package at.ac.tuwien.big.sat.problem;

import java.util.List;

public interface SatProblem {

	/**Int contains variable list, index > 0!*/
	public List<int[]> getConstraints();
	
	public int getVarSize();
}
