package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.virtmod.basic.Source;
import at.ac.tuwien.big.virtmod.basic.SourceInfo;

public class WrappedSource implements Source {
	
	private boolean isGenerated;
	private Iterable<Object>  baseSources;
	
	public WrappedSource(Iterable<Object> baseSources) {
		this.baseSources = baseSources;
		isGenerated = false;
		for (Object o: baseSources) {
			isGenerated|= SourceInfo.isGenerated(o);
		}
	}
	
	public Iterable<Object> baseSource() {
		return baseSources;
	}
	

	@Override
	public boolean isGenerated() {
		return isGenerated;
	}

}
