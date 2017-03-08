package at.ac.tuwien.big.vmodel.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.vmodel.general.WrappedElementSource;
import at.ac.tuwien.big.vmodel.general.impl.WrappedInfo;

public interface VFeatureValues {

	public List<Object> getValueList(String uuid);
	 
	public Iterable<? extends String> getValueListInv(String uuid);

	public List<? extends Iterable<? extends ElementSourceInfo>> getSource(String uuid);

	public default List<? extends WrappedElementSource> getWrappedSource(String uuid) {
		List<WrappedElementSource> ret = new ArrayList<>();
		for (Iterable<? extends ElementSourceInfo> iter: getSource(uuid)) {
			ret.add(new WrappedInfo(iter));
		}
		return ret;
	}

	public void selfClear(Set<String> allIds);

	public void selfClear();

	public void removeClear();

	public void nullifyClear();
}
