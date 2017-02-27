package at.ac.tuwien.big.virtmod.basic.impl.delta;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.delta.DeltaTreeposList;

public class SimpleDeltaTreeposList implements DeltaTreeposList {
	
	private TreeposList baseList;
	private TreeposList deltaList;
	private Editstate editState;
	
	public SimpleDeltaTreeposList(TreeposList baseList, TreeposList deltaList, Editstate editState) {
		this.baseList = baseList;
		this.deltaList = deltaList;
		this.editState = editState;
	}


	@Override
	public TreeposList baseList() {
		return baseList;
	}

	@Override
	public TreeposList deltaList() {
		return deltaList;
	}


	@Override
	public Editstate editState() {
		return editState;
	}

	public void clearAll(Treepos tl) {
		deltaList().clearAll(tl);
	}





}
