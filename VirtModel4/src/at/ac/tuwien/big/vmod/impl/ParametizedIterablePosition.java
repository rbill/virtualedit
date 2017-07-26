package at.ac.tuwien.big.vmod.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.IterableType;

public class ParametizedIterablePosition<T,W>
	extends SimpleGeneralElement<IterableType> implements IterablePosition<T> {

	
	public ParametizedIterablePosition(GeneralElement parent, IterableType type, List<Pair<W,IterablePosition<T>>> startingPositions) {
		super(type);
		//Hier sehe ich das erste als curPos, alles andere als nextPos
		if (!startingPositions.isEmpty()) {
			Iterator<Pair<W,IterablePosition<T>>> iter = startingPositions.iterator();
			curPos = iter.next().clone();
			while (iter.hasNext()) {
				nextPos.add(iter.next().clone());
			}
		}
		updateParentLocValue(parent);
	}
	
	private void updateParentLocValue(GeneralElement parent) {
		Object value = null;
		if (curPos != null) {
			for (Pair<W,IterablePosition<T>> pair: Collections.singleton(curPos)) {
				ParentLocation pl = pair.getB().getParentLoc();
				if (pl != null && pl.getValue() != null) {
					value = pl.getValue();
				}
			}
		}
		setParentLoc(new ParentLocationImpl(parent, value, this));
	}
	
	protected ParametizedIterablePosition(ParametizedIterablePosition<T,W> copyFrom) {
		super(copyFrom.type);
		for (Pair<W,IterablePosition<T>> prev: copyFrom.prevPos) {
			prevPos.add(prev.clone());
		}
		if (copyFrom.curPos != null) {
			curPos = copyFrom.curPos.clone();
		}
		for (Pair<W,IterablePosition<T>> prev: copyFrom.nextPos) {
			nextPos.add(prev.clone());
		}
		updateParentLocValue(copyFrom.getParent());
	}

	private List<Pair<W,IterablePosition<T>>> prevPos = new ArrayList<>();
	private Pair<W,IterablePosition<T>> curPos = null;;
	private List<Pair<W,IterablePosition<T>>> nextPos = new ArrayList<>();;
	//Wenn curPos erschöpft ist, nehme ich einfach nächsten usw.
	

	@Override
	public T getObject() {
		
			if (curPos !=  null && curPos.getB().hasElement()) {
				return curPos.getB().getObject();
			}
		return null;
	}

	@Override
	public boolean hasElement() {
		if (curPos !=  null && curPos.getB().hasElement()) {
			return true;
		}
		return false;
	}

	private void makePrevious() {
		boolean setPrevious = false;
		while (curPos ==  null || curPos.getB().isStart()) {
			if (prevPos.isEmpty()) {
				return;
			}
			if (curPos != null) {
				nextPos.add(0,curPos);
			}
			curPos = prevPos.remove(prevPos.size()-1);
			if (curPos.getB().isEnd()) {
				setPrevious = true;
				curPos.setB(curPos.getB().getPrevious());
			}
			//Da wird zweimal getPrevious aufgerufen ... sollte nicht so sein, außer wenn es start ist
		}
		if (!setPrevious) {
			curPos.setB(curPos.getB().getPrevious());
		}
		updateParentLocValue(getParent());
	}
	 
	private void makeNext() {
		boolean setNext = false;
		while (curPos ==  null || curPos.getB().isEnd()) {
			if (nextPos.isEmpty()) {
				return;
			}
			if (curPos != null) {
				prevPos.add(curPos);
			}
			curPos = nextPos.remove(0);
			if (curPos.getB().isStart()) {
				setNext = true;
				curPos.setB(curPos.getB().getNext());
			}
		}
		if (!setNext) {
			curPos.setB(curPos.getB().getNext());
		}
		updateParentLocValue(getParent());
	}
	
	@Override
	public void remove() {
		//Remove from everything
		curPos.getB().remove();
	}

	@Override
	public IterablePosition<T> getNextOrNull() {
		if ((curPos == null || curPos.getB().isEnd()) && nextPos.isEmpty()) {
			return null;
		}
		ParametizedIterablePosition<T, W> ret = clone();
		ret.makeNext();
		return ret;
	}

	@Override
	public IterablePosition<T> getPreviousOrNull() {
		if ((curPos == null || curPos.getB().isStart()) && prevPos.isEmpty()) {
			return null;
		}
		ParametizedIterablePosition<T, W> ret = clone();
		ret.makePrevious();
		return ret;
	}

	@Override
	public void add(T obj) {
		// Add to every sub
		for (Pair<W,IterablePosition<T>> pos: prevPos) {
			pos.getB().add(obj);
		}
		if (curPos != null) {
			curPos.getB().add(obj);
		}
		for (Pair<W,IterablePosition<T>> pos: nextPos) {
			pos.getB().add(obj);
		}
	}

	@Override
	public ParametizedIterablePosition<T, W> clone() {
		return new ParametizedIterablePosition<>(this);
	}

}
