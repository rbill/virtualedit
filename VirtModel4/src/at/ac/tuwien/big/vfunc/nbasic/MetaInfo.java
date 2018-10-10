package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Set;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public interface MetaInfo {

	public ConstraintViolations getConstraintViolations();
	
	public Reason getReason();
	
	public default DerivationStatus getTotalDerivationStatus() {
		Reason r = getReason();
		DerivationStatus retAdd = DerivationStatus.UNSPECIFIED;
		if (r != null) {
			Set<DerivationStatus> status = r.getDerivationStatus();
			if (status.contains(DerivationStatus.PARTLY_DERIVED)) {
				retAdd = DerivationStatus.PARTLY_DERIVED;
			} else if (status.contains(DerivationStatus.DERIVED)) {
				if (status.contains(DerivationStatus.NONDERIVED)) {
					retAdd = DerivationStatus.PARTLY_DERIVED;
				} else {
					retAdd = DerivationStatus.DERIVED;
				}
			} else if (status.contains(DerivationStatus.NONDERIVED)) {
				retAdd = DerivationStatus.NONDERIVED;
			}
		}
		return retAdd;
	}
	
}
