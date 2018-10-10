package at.ac.tuwien.big.vfunc.nbasic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public class ComposedReason implements Reason {
	
	private Supplier<? extends List<? extends BasicValuedChangeNotifyer<?>>> sourceInfos = ()->new ArrayList<>();
	private Set<DerivationStatus> addDerivationStatus = new HashSet<>();
	
	public ComposedReason() {
		
	}
	
	public ComposedReason(Supplier<? extends List<? extends BasicValuedChangeNotifyer<?>>> sourceInfos) {
		this.sourceInfos = sourceInfos;
	}
			
	
	@Override
	public void addDerivationStatus(Set<DerivationStatus> status) {
		status.addAll(this.addDerivationStatus);
		for (BasicValuedChangeNotifyer<?> sub: getSourceInfos()) {
			if (sub instanceof QueryResult) {
				QueryResult<?, ?> qr = (QueryResult<?, ?>)sub;
				qr.getMetaInfo().getReason().addDerivationStatus(status);
			}
		}
	}
	
	public List<? extends BasicValuedChangeNotifyer<?>> getSourceInfos() {
		return this.sourceInfos.get();
	}

	public void initSourceInfos(Supplier<? extends List<? extends BasicValuedChangeNotifyer<?>>> sourceInfos) {
		this.sourceInfos = sourceInfos;
	}

}
