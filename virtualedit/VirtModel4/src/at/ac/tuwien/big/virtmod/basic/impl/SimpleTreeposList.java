package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class SimpleTreeposList extends SimpleAbstractSublist<Treepos, TreeposState> implements TreeposList {

	@Override
	public TreeposState createValueState(long editId, Treepos pos, ContainState state) {
		return new SimpleTreeposState(editId, pos, state);
	}


}
