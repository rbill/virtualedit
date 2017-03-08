package at.ac.tuwien.big.vmodel.general;

import java.util.List;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;

public interface SourcedList {

	public List<? extends Iterable<? extends ElementSourceInfo>> getSources();
}
