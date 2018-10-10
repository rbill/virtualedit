package at.ac.tuwien.big.vfunc.nbasic;

public class BasicMetaInfo implements MetaInfo {

	private Reason reason;
	private ConstraintViolations constraintViolations;
	
	public BasicMetaInfo() {
	}
	

	public BasicMetaInfo(Reason reason) {
		this.reason = reason;
	}
	
	@Override
	public ConstraintViolations getConstraintViolations() {
		return this.constraintViolations;
	}

	@Override
	public Reason getReason() {
		return this.reason;
	}

}
