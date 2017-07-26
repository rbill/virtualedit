package at.ac.tuwien.big.vmod;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;

/**This iterable is guaranteed to return each element only once
 * Problem noch: Bootstrapping ...
 * */
public interface TreeposIterablePosition extends IterablePosition<Treepos>, Comparable<TreeposIterablePosition> {

	public TreeposIterablePosition getNextOrNull();


	public default TreeposIterablePosition getNext() {
		TreeposIterablePosition ret = getNextOrNull();
		if (ret == null) {
			return this;
		}
		return ret;		
	}
	
	public TreeposIterablePosition endPos();
	
	public TreeposIterablePosition startPos();
	
	public TreeposIterablePosition getPreviousOrNull();
	
	public default TreeposIterablePosition getPrevious() {
		TreeposIterablePosition ret = getPreviousOrNull();
		if (ret == null) {
			return this;
		}
		return ret;		
	}
		
	public default Treepos insertBefore() {
		Treepos ret = beforePos();
		add(ret);
		return ret;
	}
	
	public default Treepos insertAfter() {
		Treepos ret = afterPos();
		add(ret);
		return ret;
	}
	
	public default void remove() {
		delete();
	}
	
	@Override	
	public default int compareTo(TreeposIterablePosition nextEdit) {
		if (nextEdit == null) {
			return 1;
		}
		Object prev = this.getObject();
		Object next = nextEdit.getObject();
				
		int compareNext = 0;
		if (this.isEnd()) {
			if (nextEdit.isEnd()) {
				compareNext = 0;
			} else {
				compareNext = 1;
			}
		} else {
			if (nextEdit.isEnd()) {
				compareNext = -1;
			} else {
				if (this.isStart()) {
					if (nextEdit.isStart()) {
						compareNext = 0;
					} else {
						compareNext = -1;
					}
				} else {
					if (nextEdit.isStart()) {
						compareNext = 1;
					} else {
						if (prev == null && next == null) {
							compareNext = 0;
						} else if (prev == null) {
							compareNext = -1;
						} else if (next == null) {
							compareNext = 1;
						} else {
							compareNext = this.getObject().compareTo(nextEdit.getObject());
						}
					}
				}
			}
		}
		return compareNext;
	}
	
	public Treepos delete();
	
	public default Treepos beforePos() {
		TreeposIterablePosition previous = getPreviousOrNull();
		int myIndex = getProvider().getIndex();
		Treepos ret;
		if (hasElement()) {
			if (previous != null && previous.hasElement()) {
				ret = getObject().middle(previous.getObject(),myIndex);
			} else {
				ret = getObject().superBefore(myIndex);
			}
		} else {
			if (previous != null && previous.hasElement()) {
				ret = previous.getObject().superAfter(myIndex);
			} else {
				ret = new SimpleTreepos(0,myIndex);
			}
		}
		if (ret == null) {
			if (hasElement()) {
				if (previous != null && previous.hasElement()) {
					ret = getObject().middle(previous.getObject(),myIndex);
				} else {
					ret = getObject().superBefore(myIndex);
				}
			} else {
				if (previous != null && previous.hasElement()) {
					ret = previous.getObject().superAfter(myIndex);
				} else {
					ret = new SimpleTreepos(0,myIndex);
				}
			}
		}
		return ret;
	}
	
	public default Treepos afterPos() {
		TreeposIterablePosition next = getNextOrNull();
		int myIndex = getProvider().getIndex();
		if (hasElement()) {
			if (next != null && next.hasElement()) {
				return getObject().middle(next.getObject(),myIndex);
			} else {
				return getObject().superAfter(myIndex);
			}
		} else {
			if (next != null && next.hasElement()) {
				return next.getObject().superAfter(myIndex);
			}
			return new SimpleTreepos(0,myIndex);
		}
	}
	

}
