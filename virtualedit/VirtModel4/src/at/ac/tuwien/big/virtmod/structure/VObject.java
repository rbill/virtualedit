package at.ac.tuwien.big.virtmod.structure;

import java.util.Collections;

import at.ac.tuwien.big.vmodel.general.WrappedElementSource;
import at.ac.tuwien.big.vmodel.general.impl.WrappedInfo;
import at.tuwien.big.virtmod.datatype.IteratorUtils;
import at.tuwien.big.virtmod.datatype.IteratorUtils.SimpleFunction;

public interface VObject {
	
	public VContainer store();
	
	public void destroy();
	
	public default Iterable<VContainer> sourceStores() {
		return Collections.singleton(store());
	}
	
	public default Iterable<? extends ElementSourceInfo> getSourceInfos() {
		Iterable<? extends VContainer> cont = sourceStores();
		return IteratorUtils.flattenUnknown(cont, new SimpleFunction<VContainer, Iterable<? extends ElementSourceInfo>>(){

			@Override
			public Iterable<? extends ElementSourceInfo> applyTo(VContainer x) {
				return x.getElementSource();
			}});
	}
	
	public default Iterable<? extends ElementSourceInfo> getRelevantSourceInfos() {
		return ()->IteratorUtils.filterType(getSourceInfos().iterator(),(x)->x.isRelevant());
	}
	
	public default WrappedElementSource getWrappedSourceInfos() {
		return new WrappedInfo(getSourceInfos());
	}
	
	public default WrappedElementSource getWrappedRelevantSourceInfos() {
		return new WrappedInfo(getRelevantSourceInfos());
	}
	

}
