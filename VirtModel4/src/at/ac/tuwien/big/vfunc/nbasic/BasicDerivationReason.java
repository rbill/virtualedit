package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Set;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public class BasicDerivationReason implements Reason {

	private DerivationStatus status;
	
	public BasicDerivationReason(DerivationStatus status) {
		this.status = status;
	}
	
	@Override
	public void addDerivationStatus(Set<DerivationStatus> status) {
		if (this.status != null) {
			status.add(this.status);
		}
	}

}
