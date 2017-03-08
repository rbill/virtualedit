package at.ac.tuwien.big.vmod;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;

/**This iterable is guaranteed to return each element only once
 * Problem noch: Bootstrapping ...
 * */
public interface TreeposIterablePosition extends IterablePosition<Treepos> {

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
