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

public class StartTreeposIterablePosition extends SimpleGeneralElement<IterableType> implements TreeposIterablePosition {

	private TreeposMap<?> baseMap;

	public StartTreeposIterablePosition(GeneralElement parent, IterableType type, TreeposMap<?> baseMap) {
		super(type);
		this.baseMap = baseMap;
		setParentLoc(new ParentLocationImpl(parent, "start", this));
	}

	@Override
	public Treepos getObject() {
		return null;
	}

	@Override
	public boolean hasElement() {
		return false;
	}

	@Override
	public TreeposIterablePosition getNextOrNull() {
		TreeposIteratorNode<?> next = baseMap.getFirstNodeOrNull();
		if (next == null) {
			return new EndTreeposIterablePosition(getParent(),getType(), baseMap);
		}
		return new SimpleTreeposIterablePosition(getParent(), getType(), baseMap, next);
	}

	@Override
	public TreeposIterablePosition getPreviousOrNull() {
		return null;
	}
	

	public Treepos delete()  {
		System.err.println("Wanting to remove start element");
		return getObject();
	}

	@Override
	public void add(Treepos obj) {
		baseMap.addKey(obj);
	}
	@Override
	public void clear() {
		System.err.println("Wanting to clear iterable position ..");
	}
	
	@Override
	public TreeposIterablePosition endPos() {
		return new EndTreeposIterablePosition(getParent(), getType(), baseMap);
	}

	@Override
	public TreeposIterablePosition startPos() {
		return new StartTreeposIterablePosition(getParent(), getType(), baseMap);
	}
	

}
