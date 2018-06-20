package at.ac.tuwien.big.vfunc.nbasic;

public class BasicMetaInfo implements MetaInfo {

	private Reason reason;
	private ConstraintViolations constraintViolations;
	
	@Override
	public Reason getReason() {
		return reason;
	}

	@Override
	public ConstraintViolations getConstraintViolations() {
		return constraintViolations;
	}

}
