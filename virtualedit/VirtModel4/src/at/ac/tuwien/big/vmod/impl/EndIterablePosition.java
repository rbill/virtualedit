package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.util.IteratorNode;
import at.ac.tuwien.big.util.MyMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.type.IterableType;

public class EndIterablePosition<T,Type extends IterableType> extends AbstractIterablePosition<T,Type> {
	
	private MyMap<T, ?> baseMap;

	public EndIterablePosition(GeneralElement parent, Type type, MyMap<T, ?> baseMap) {
		super(type);
		this.baseMap = baseMap;
		setParentLoc(new ParentLocationImpl(parent, "end", this));
	}

	@Override
	public T getObject() {
		return null;
	}

	@Override
	public boolean hasElement() {
		return false;
	}

	@Override
	public IterablePosition<T> getNextOrNull() {
		return null;
	}


	public void remove()  {
		System.err.println("Wanting to remove end element");
	}

	@Override
	public IterablePosition<T> getPreviousOrNull() {
		IteratorNode<T, ?> previous = baseMap.getLastNodeOrNull();
		if (previous == null) {
			return new StartIterablePosition<>(getParent(),getType(), baseMap);
		}
		return new SimpleIterablePosition<T, Type>(getParent(), getType(), baseMap, previous);
	}

	
	@Override
	public void add(T obj) {
		baseMap.addKey(obj);
	}

	


}
