package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.util.IteratorNode;
import at.ac.tuwien.big.util.MyMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.type.IterableType;

public class SimpleIterablePosition<T,Type extends IterableType> extends AbstractIterablePosition<T,Type> {
	
	protected MyMap<T, ?> baseMap;
	protected IteratorNode<T, ?> node;

	public SimpleIterablePosition(GeneralElement parent, Type type, MyMap<T, ?> baseMap, IteratorNode<T, ?> node) {
		super(type);
		this.baseMap = baseMap;
		this.node = node;
		setParentLoc(new ParentLocationImpl(parent, node.getKey(), this));
	}

	@Override
	public T getObject() {
		return node.getKey();
	}

	@Override
	public boolean hasElement() {
		return true;
	}

	@Override
	public IterablePosition<T> getNextOrNull() {
		IteratorNode<T, ?> next = node.getNextExisting();
		if (next == null) {
			return new EndIterablePosition<>(getParent(),getType(), baseMap);
		}
		return new SimpleIterablePosition<T, Type>(getParent(),getType(), baseMap, next);
	}
	

	public void remove()  {
		node.remove();
	}

	@Override
	public IterablePosition<T> getPreviousOrNull() {
		IteratorNode<T, ?> previous = node.getPreviousExisting();
		if (previous == null) {
			return new StartIterablePosition<>(getParent(),getType(), baseMap);
		}
		return new SimpleIterablePosition<T, Type>(getParent(),getType(), baseMap, previous);
	}

	@Override
	public void add(T obj) {
		baseMap.addKey(obj);
	}


}
