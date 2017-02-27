package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.util.IteratorNode;
import at.ac.tuwien.big.util.MyMap;
import at.ac.tuwien.big.util.TreeposIteratorNode;
import at.ac.tuwien.big.util.TreeposMap;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.type.IterableType;
import at.ac.tuwien.big.vmod.type.impl.IterableTypeImpl;

public class SimpleTreeposIterablePosition extends SimpleIterablePosition<Treepos,IterableType> implements TreeposIterablePosition {

	
	public SimpleTreeposIterablePosition(GeneralElement parent, IterableType type, TreeposMap<?> baseMap, TreeposIteratorNode<?> node) {
		super(parent,type,baseMap,node);
	}

	@Override
	public TreeposIterablePosition getNextOrNull() {
		TreeposIteratorNode next = (TreeposIteratorNode)node.getNextExisting();
		if (next == null) {
			return new EndTreeposIterablePosition(getParent(),getType(), (TreeposMap)baseMap);
		}
		return new SimpleTreeposIterablePosition(getParent(),getType(), (TreeposMap)baseMap, next);
	}

	@Override
	public TreeposIterablePosition getPreviousOrNull() {
		TreeposIteratorNode previous = (TreeposIteratorNode)node.getPreviousExisting();
		if (previous == null) {
			return new StartTreeposIterablePosition(getParent(),getType(), (TreeposMap)baseMap);
		}
		return new SimpleTreeposIterablePosition(getParent(),getType(), (TreeposMap)baseMap, previous);
	}

	public Treepos delete()  {
		Treepos ret = getObject();
		remove();
		return ret;
	}


	@Override
	public TreeposIterablePosition endPos() {
		return new EndTreeposIterablePosition(getParent(), getType(), (TreeposMap)baseMap);
	}

	@Override
	public TreeposIterablePosition startPos() {
		return new StartTreeposIterablePosition(getParent(), getType(), (TreeposMap)baseMap);
	}
	

}
