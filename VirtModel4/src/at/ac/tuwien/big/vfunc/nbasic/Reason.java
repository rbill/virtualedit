package at.ac.tuwien.big.vfunc.nbasic;

import java.util.HashSet;
import java.util.Set;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public interface Reason {

	public void addDerivationStatus(Set<DerivationStatus> status);

	public default Set<DerivationStatus> getDerivationStatus() {
		Set<DerivationStatus> ret = new HashSet<>();
		addDerivationStatus(ret);
		return ret;
	}
}
