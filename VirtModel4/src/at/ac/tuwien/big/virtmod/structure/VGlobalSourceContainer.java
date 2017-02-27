package at.ac.tuwien.big.virtmod.structure;

import java.util.Collections;

public interface VGlobalSourceContainer extends VContainer {

	public GlobalSource<? extends ElementSourceInfo> getGlobalSource();
	

	@Override
	public default Iterable<? extends ElementSourceInfo> getElementSource() {
		GlobalSource<? extends ElementSourceInfo> globalSource = getGlobalSource();
		
		if (globalSource == null) {
			VContainer cur = parent();
			while (cur != null && cur instanceof VGlobalSourceContainer) {
				globalSource = ((VGlobalSourceContainer)cur).getGlobalSource();
				if (globalSource != null) {
					break;
				}
				cur = cur.parent();
			} 
		}
		if (globalSource != null) {
			return globalSource.getInfos(object());
		} else {
			return Collections.emptyList();
		}
	}
}
