package at.ac.tuwien.big.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;

public class TreeposMapContent<U> {
	private TreeposMapContent<U> parent;
	private TreeposMap<U> mainMap;
	private Treepos myPos;
	private int myLevel;
	private List<TreeposMapContent<U>> forwardContent = new ArrayList<>();
	private List<TreeposMapContent<U>> backwardContent = new ArrayList<>();
	private TreeposIteratorNodeImpl<U> iteratorNode = new TreeposIteratorNodeImpl<U>(this, false);
	
	public TreeposIteratorNodeImpl<U> getLastNode() {
		//Vom Forward das letzte
		for (int i = forwardContent.size()-1; i >= 0; --i) {
			TreeposMapContent<U> cont = forwardContent.get(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> last = cont.getLastNode();
				if (last != null) {
					return last;
				}
			}
		}
		if (iteratorNode.doesExist()) {
			return iteratorNode;
		}
		for (int i = 0; i < backwardContent.size(); ++i) {
			TreeposMapContent<U> cont = backwardContent.get(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> last = cont.getLastNode();
				if (last != null) {
					return last;
				}
			}
		}
		return null;
	}
	
	public TreeposIteratorNodeImpl<U> getFirstNode() {
		//Vom Backward das letzte
		for (int i = backwardContent.size()-1; i >= 0; --i) {
			TreeposMapContent<U> cont = backwardContent.get(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> last = cont.getFirstNode();
				if (last != null) {
					return last;
				}
			}
		}
		if (iteratorNode.doesExist()) {
			return iteratorNode;
		}
		for (int i = 0; i < forwardContent.size(); ++i) {
			TreeposMapContent<U> cont = forwardContent.get(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> last = cont.getFirstNode();
				if (last != null) {
					return last;
				}
			}
		}
		return null;
	}
	
	/*public TreeposIteratorNodeImpl<U> getPreviousSubNode() {
		//Vom backward das erste
		for (int i = 0; i < backwardContent.size(); ++i) {
			TreeposMapContent<U> cont = backwardContent.get(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> last = cont.getLastNode();
				if (last != null) {
					return last;
				}
			}
		}
		return null;
	}
	
	public TreeposIteratorNodeImpl<U> getNextSubNode() {
		//Vom backward das erste
		for (int i = 0; i < forwardContent.size(); ++i) {
			TreeposMapContent<U> cont = forwardContent.get(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> last = cont.getFirstNode();
				if (last != null) {
					return last;
				}
			}
		}
		return null;
	}*/
	
	/*public TreeposIteratorNodeImpl<U> getNextNode(int startIndex) {
		int myPos = startIndex;
		for (int i = myPos+1; i < forwardContent.size(); ++i) {
			if (i == 0 && iteratorNode.doesExist()) {
				//self node
				return iteratorNode;
			}
			TreeposMapContent<U> cont = getContent(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> first = cont.getFirstNode();
				if (first != null) {
					return first;
				}
			}
		}
		if (startIndex < 0 && iteratorNode.doesExist()) {
			return iteratorNode;
		}
		return null;
	}
	
	public TreeposIteratorNodeImpl<U> getPreviousNode(int startIndex) {
		for (int i = startIndex -1; i >= -backwardContent.size(); --i) {
			
			TreeposMapContent<U> cont = getContent(i);
			if (cont != null) {
				TreeposIteratorNodeImpl<U> first = cont.getLastNode();
				if (first != null) {
					return first;
				}
			}
			if (i == 0 && iteratorNode.doesExist()) {
				//self node
				return iteratorNode;
			}
		}
		if (backwardContent.size() == 0 && iteratorNode.doesExist()) {
			return iteratorNode;
		}
		return null;
	}*/
	
	public TreeposIteratorNodeImpl<U> getNextNode(int startIndex) {
		for (int i = Math.max(startIndex,-backwardContent.size()); i < 0; ++i) {
			TreeposMapContent<U> iteratorNode = backwardContent.get(-1-i);
			TreeposIteratorNodeImpl<U> ret = iteratorNode.getFirstNode();
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		if (startIndex <= 0)  {
			//Self
			if (iteratorNode != null && iteratorNode.doesExist()) {
				return iteratorNode;
			}
		}
		for (int i = Math.max(0, startIndex); i < forwardContent.size(); ++i) {
			TreeposMapContent<U> iteratorNode = forwardContent.get(i);
			TreeposIteratorNodeImpl<U> ret = iteratorNode.getFirstNode();
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}

		TreeposMapContent<U> parent = getParent();
		if (parent != null) {
			TreeposIteratorNodeImpl<U> ret = parent.getNextNode(this.myPos.getLevelValue(myLevel-1).value()+1);
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		return null;
	}
	
	public TreeposIteratorNodeImpl<U> getNextNode() {
		for (int i = 0; i < forwardContent.size(); ++i) {
			TreeposMapContent<U> iteratorNode = forwardContent.get(i);
			TreeposIteratorNodeImpl<U> ret = iteratorNode.getFirstNode();
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		TreeposMapContent<U> parent = getParent();
		if (parent != null) {
			TreeposIteratorNodeImpl<U> ret = parent.getNextNode(this.myPos.getLevelValue(myLevel-1).value()+1);
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		return null;
	}
	
	

	public TreeposIteratorNodeImpl<U> getPreviousNode(int endIndex) {
		

		for (int i = Math.min(forwardContent.size()-1, endIndex); i >= 0; --i) {
			TreeposMapContent<U> iteratorNode = forwardContent.get(i);
			TreeposIteratorNodeImpl<U> ret = iteratorNode.getLastNode();
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		if (endIndex >= -1) {
			//Self
			if (iteratorNode != null && iteratorNode.doesExist()) {
				return iteratorNode;
			}
		}
		for (int i = Math.max(0,-1-endIndex); i < backwardContent.size(); ++i) {
			TreeposMapContent<U> iteratorNode = backwardContent.get(i);
			TreeposIteratorNodeImpl<U> ret = iteratorNode.getLastNode();
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}

		TreeposMapContent<U> parent = getParent();
		if (parent != null) {
			TreeposIteratorNodeImpl<U> ret = parent.getPreviousNode(this.myPos.getLevelValue(myLevel-1).value()-1);
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		return null;
	}
	
	public TreeposIteratorNodeImpl<U> getPreviousNode() {
		for (int i = 0; i < backwardContent.size(); ++i) {
			TreeposMapContent<U> iteratorNode = backwardContent.get(i);
			TreeposIteratorNodeImpl<U> ret = iteratorNode.getLastNode();
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		TreeposMapContent<U> parent = getParent();
		if (parent != null) {
			TreeposIteratorNodeImpl<U> ret = parent.getPreviousNode(this.myPos.getLevelValue(myLevel-1).value()-1);
			if (ret != null && ret.doesExist()) {
				return ret;
			}
		}
		return null;
	}
	
	public void removeNode() {
		iteratorNode.remove();
	}
	
	public String toString() {
		return myPos+" => "+getValueOrNull();
	}
		
	public U initValue(U value) {
		U oldValue = iteratorNode.getValue();
		iteratorNode.setValue(value);
		if (iteratorNode.doesExist()) {
			
		} else {
			TreeposIteratorNodeImpl<U> newNode = iteratorNode;
			TreeposIteratorNodeImpl<U> 
			//It's not so easy, we have to manually find either a previous or a following node.
				//Start with previous, it's easier. Also, if we don't find any, we know we are new first
			cur = getPreviousNode();
			if (cur == null) {
				//This is the first node
				mainMap.setFirst(newNode);
				cur = getNextNode();
				if (cur == null) {
					//This is the first and last node
					mainMap.setLast(newNode);
				} else {
					newNode.setNext(cur);
					assert cur.getPrevious() == null;
					cur.setPrevious(newNode);
				}
			} else {
				TreeposIteratorNodeImpl<U> next = cur.getNext();
				if (next != null) {
					newNode.setNext(next);
					next.setPrevious(newNode);
				} else {
					//This will be the new last!
					mainMap.setLast(newNode);
				}
				newNode.setPrevious(cur);
				cur.setNext(newNode);
			}
			iteratorNode.setExisting();
		}
		return oldValue;
	}
	
	
	
	public TreeposMapContent<U> getParent() {
		return parent;
	}
	
	public Treepos getMyPos() {
		return myPos;
	}
	
	protected TreeposMapContent(TreeposMap<U> mainMap) {
		this.mainMap = mainMap;
		this.myLevel = 0;
		this.myPos = new SimpleTreepos();
	}
	
	private TreeposMapContent(TreeposMapContent<U> parent, int subPos) {
		this.parent = parent;
		this.myLevel = parent.myLevel+1;
		this.myPos = parent.getMyPos().subPos(subPos);
		this.mainMap = parent.getMap();
	}
	
	private TreeposMapContent<U> getListContentOrNull(List<TreeposMapContent<U>> list, int pos) {
		if (list.size() <= pos) {
			return null;
		}
		return list.get(pos);
	}
	
	private TreeposMapContent<U> getListContent(List<TreeposMapContent<U>> list, int pos) {
		while (list.size() <= pos) {
			TreeposMapContent<U> toAdd;
			if (list == forwardContent) {
				toAdd = new TreeposMapContent<>(this, list.size());
			} else {
				toAdd = new TreeposMapContent<>(this, -1-list.size());
			}
			list.add(toAdd);
		}
		return list.get(pos);
	}
	
	public TreeposMapContent<U> getContent(int lv) {
		if (lv  >= 0) {
			return getListContent(forwardContent,lv);
		} else {
			return getListContent(backwardContent,-1-lv);
		} 
	}
	
	public TreeposMapContent<U> getContentOrNull(int lv) {
		if (lv  >= 0) {
			return getListContentOrNull(forwardContent,lv);
		} else {
			return getListContentOrNull(backwardContent,-1-lv);
		} 
	}
	
	
	
	/**The pos must be on or below this one*/
	public TreeposMapContent<U> resolvePos(Treepos pos) {
		if (myLevel >= pos.getLevelSize()) {
			return this;
		} else {
			int lv = pos.getLevelValue(myLevel).value();
			return getContent(lv).resolvePos(pos);
		}
	}
	


	public TreeposMapContent<U> resolvePosOrNull(Treepos pos) {
		if (myLevel >= pos.getLevelSize()) {
			return this;
		} else {
			int lv = pos.getLevelValue(myLevel).value();
			TreeposMapContent<U> con = getContentOrNull(lv);
			if (con != null) {
				return con.resolvePosOrNull(pos);
			}
			return null;
		}
	}
	

	public TreeposMap<U> getMap() {
		return mainMap;
	}

	public void clear() {
		iteratorNode.setNotExisting();
		for (TreeposMapContent<U> sub: backwardContent) {
			sub.clear();
		}
		for (TreeposMapContent<U> sub: forwardContent) {
			sub.clear();
		}
	}

	public boolean hasValue() {
		return iteratorNode.doesExist();
	}

	public boolean hasValueOrSubHasValue(Object value) {
		if (iteratorNode.doesExist() && Objects.equals(iteratorNode.getValue(), value))  {
			return true;
		}
		for (TreeposMapContent<U> sub: backwardContent) {
			if (sub.hasValueOrSubHasValue(value)) {
				return true;
			}
		}
		for (TreeposMapContent<U> sub: forwardContent) {
			if (sub.hasValueOrSubHasValue(value)) {
				return true;
			}
		}
		return false;
	}

	public TreeposIteratorNodeImpl<U> getNode() {
		return iteratorNode;
	}

	public boolean isEmpty() {
		if (iteratorNode.doesExist()) {
			return false;
		}
		for (TreeposMapContent<U> sub: backwardContent) {
			if (!sub.isEmpty()) {
				return false;
			}
		}
		for (TreeposMapContent<U> sub: forwardContent) {
			if (!sub.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public U getValueOrNull() {
		if (iteratorNode.doesExist()) {
			return iteratorNode.getValue();
		}
		return null;
	}
	

}
