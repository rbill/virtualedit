package at.ac.tuwien.big.vmod.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.IterableType;

public class ParametizedTreeposIterablePosition<W> extends SimpleGeneralElement<IterableType> implements TreeposIterablePosition {

	public ParametizedTreeposIterablePosition(GeneralElement parent, IterableType type,List<Pair<W, TreeposIterablePosition>> startingPositions) {
		super(type);
		Object name = null;
		for (Pair<W,TreeposIterablePosition> pair: startingPositions) {
			ParentLocation pl = pair.getB().getParentLoc();
			if (pl != null && pl.getValue() != null) {
				name = pl.getValue();
			}
			curPos.add(pair.clone());
		}
		setParentLoc(new ParentLocationImpl(parent,name,this));
	}
	
	private ParametizedTreeposIterablePosition(ParametizedTreeposIterablePosition<W> copyFrom) {
		super(copyFrom.type);
		
		for (Pair<W,TreeposIterablePosition> pair: copyFrom.prevPos) {
			prevPos.add(pair.clone());
		}
		ParentLocation parentLoc = copyFrom.getParentLoc();
		setParentLoc(new ParentLocationImpl(parentLoc.getParent(), parentLoc.getValue(), parentLoc.getChild()));
		for (Pair<W,TreeposIterablePosition> pair: copyFrom.curPos) {
			curPos.add(pair.clone());
		}
		for (Pair<W,TreeposIterablePosition> pair: copyFrom.nextPos) {
			nextPos.add(pair.clone());
		}
	}
	

	private List<Pair<W,TreeposIterablePosition>> prevPos = new ArrayList<>();
	private List<Pair<W,TreeposIterablePosition>> curPos = new ArrayList<>();;
	private List<Pair<W,TreeposIterablePosition>> nextPos = new ArrayList<>();;
	
	private void updateParentLocValue(GeneralElement parent) {
		Object value = null;
		for (Pair<W,TreeposIterablePosition> pair: curPos) {
			ParentLocation pl = pair.getB().getParentLoc();
			if (pl != null && pl.getValue() != null) {
				value = pl.getValue();
			}
		}
		ParentLocation curLoc = getParentLoc();
		setParentLoc(new ParentLocationImpl(parent, value, this));
	}

	private void makePrevious() {
		//Add the next of the cur to the next
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			pos.setB(pos.getB().getPrevious());
			prevPos.add(pos);
		}
		curPos.clear();
		//Add the minimum of the next as curPos
		List<Pair<W,TreeposIterablePosition>> max = new ArrayList<>();
		for (Pair<W,TreeposIterablePosition> next: prevPos) {
			if (max.isEmpty()) {
				max.add(next);
			} else {
				for (Pair<W,TreeposIterablePosition> curMax: max) {
					int compare = curMax.getB().compareTo(next.getB());
					if (compare < 0) { //curMin < next
						max.clear();
						max.add(curMax);
						break;
					} else if (compare == 0) { //Assume all are equal
						max.add(next);
						break;
					} else { //curMin > 0
						break;
					}
				}
			}
		}
		prevPos.removeAll(max);
		curPos.addAll(max);
		updateParentLocValue(getParent());
	}
	 
	private void makeNext() {
		//Add the next of the cur to the next
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			pos.setB(pos.getB().getNext());
			nextPos.add(pos);
		}
		curPos.clear();
		//Add the minimum of the next as curPos
		List<Pair<W,TreeposIterablePosition>> min = new ArrayList<>();
		for (Pair<W,TreeposIterablePosition> next: nextPos) {
			if (min.isEmpty()) {
				min.add(next);
			} else {
				for (Pair<W,TreeposIterablePosition> curMin: min) {
					int compare = curMin.getB().compareTo(next.getB());
					if (compare > 0) { //curMin > next
						min.clear();
						min.add(curMin);
						break;
					} else if (compare == 0) { //Assume all are equal
						min.add(next);
						break;
					} else { //curMin < 0
						break;
					}
				}
			}
		}
		nextPos.removeAll(min);
		curPos.addAll(min);
		updateParentLocValue(getParent());
	}
	
	public boolean isStart() {
		if (curPos.isEmpty() && nextPos.isEmpty()) {
			return true;
		}
		if (!nextPos.isEmpty()) {
			return false;
		}
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			if (!pos.getB().isStart()) {
				return false;
			}
		}
		return true;
	} 
	
	public boolean isEnd() {
		if (curPos.isEmpty() && prevPos.isEmpty()) {
			return true;
		}
		if (!prevPos.isEmpty()) {
			return false;
		}
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			if (!pos.getB().isEnd()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void remove() {
		//Remove from everything
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			pos.getB().remove();
		}
	}
	
	public void setParent(GeneralElement parent) {
		updateParentLocValue(parent);
	}

	@Override
	public TreeposIterablePosition getNextOrNull() {
		if (nextPos.isEmpty()) {
			if (curPos.isEmpty()) {
				return null;
			}
			boolean allEnd = true;
			for (Pair<W,TreeposIterablePosition> pos: curPos) {
				allEnd&= pos.getB().isEnd();
			}
			if (allEnd)  {
				return null;
			}
		}
		ParametizedTreeposIterablePosition<W> ret = clone();
		ret.makeNext();
		return ret;
	}

	@Override
	public TreeposIterablePosition getPreviousOrNull() {
		if (prevPos.isEmpty()) {
			if (curPos.isEmpty()) {
				return null;
			}
			boolean allStart = true;
			for (Pair<W,TreeposIterablePosition> pos: curPos) {
				allStart&= pos.getB().isStart();
			}
			if (allStart)  {
				return null;
			}
		}
		ParametizedTreeposIterablePosition<W> ret = clone();
		ret.makePrevious();
		return ret;
	}

	@Override
	public void add(Treepos obj) {
		// Add to every sub
		for (Pair<W,TreeposIterablePosition> pos: prevPos) {
			pos.getB().add(obj);
		}
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			pos.getB().add(obj);
		}
		for (Pair<W,TreeposIterablePosition> pos: nextPos) {
			pos.getB().add(obj);
		}
	}

	@Override
	public ParametizedTreeposIterablePosition<W> clone() {
		return new ParametizedTreeposIterablePosition<>(this);
	}

	@Override
	public TreeposIterablePosition endPos() {
		List<Pair<W,TreeposIterablePosition>> endPos = new ArrayList<>();
		for (Pair<W,TreeposIterablePosition> pos: prevPos) {
			endPos.add(new Pair<>(pos.getA(),pos.getB().endPos()));
		}
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			endPos.add(new Pair<>(pos.getA(),pos.getB().endPos()));
		}
		for (Pair<W,TreeposIterablePosition> pos: nextPos) {
			endPos.add(new Pair<>(pos.getA(),pos.getB().endPos()));
		}
		return new ParametizedTreeposIterablePosition<>(getParent(),getType(),endPos);
	}

	@Override
	public TreeposIterablePosition startPos() {
		List<Pair<W,TreeposIterablePosition>> startPos = new ArrayList<>();
		for (Pair<W,TreeposIterablePosition> pos: prevPos) {
			startPos.add(new Pair<>(pos.getA(),pos.getB().startPos()));
		}
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			startPos.add(new Pair<>(pos.getA(),pos.getB().startPos()));
		}
		for (Pair<W,TreeposIterablePosition> pos: nextPos) {
			startPos.add(new Pair<>(pos.getA(),pos.getB().startPos()));
		}
		return new ParametizedTreeposIterablePosition<>(getParent(),getType(),startPos);
	}

	@Override
	public Treepos delete() {
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			pos.getB().delete();
		}
		return getObject();
	}

	@Override
	public Treepos getObject() {
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			Treepos ret = pos.getB().getObject();
			if (ret != null) {
				return ret;
			}
		}
		return null;
	}

	@Override
	public boolean hasElement() {
		for (Pair<W,TreeposIterablePosition> pos: curPos) {
			if (pos.getB().hasElement()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		Object obj = getObject();
		if (obj == null) {
			if (isEnd()) {
				return "End";
			} else if (isStart()) {
				return "Start";
			}
		}
		return String.valueOf(obj);
	}

	
}
