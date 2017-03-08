package at.ac.tuwien.big.sat.problem;

public interface SatSolution {

	public boolean isTrue(int varIndex);
	
	public boolean isFalse(int varIndex);
}
