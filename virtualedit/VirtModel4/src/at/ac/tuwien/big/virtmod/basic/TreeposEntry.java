package at.ac.tuwien.big.virtmod.basic;

import java.util.Map;

public interface TreeposEntry extends Map.Entry<Long,Treepos> {
	
	public ContainState getState();

}
