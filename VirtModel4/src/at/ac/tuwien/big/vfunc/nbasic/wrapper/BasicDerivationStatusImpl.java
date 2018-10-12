package at.ac.tuwien.big.vfunc.nbasic.wrapper;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public class BasicDerivationStatusImpl implements BasicDerivationStatus {
	
	private DerivationStatus status;

	public BasicDerivationStatusImpl(DerivationStatus status) {
		this.status = status;
	}
	
	@Override
	public DerivationStatus getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return String.valueOf(this.status);
	}
}
