package at.ac.tuwien.big.util;

import java.util.Map;
import java.util.SortedMap;

import at.ac.tuwien.big.virtmod.basic.Treepos;

public interface TreeposMap<U> extends MyMap<Treepos, U>, SortedMap<Treepos,U> {

	public void increaseSize();
	
	public void decreaseSize();
	
	public void setFirst(TreeposIteratorNodeImpl<U> newNode);
	
	public TreeposIteratorNodeImpl<U> getFirst(); 
	
	public void setLast(TreeposIteratorNodeImpl<U> newNode);
	
	public TreeposIteratorNodeImpl<U> getLast();

	public TreeposIteratorNode<U> getFirstNodeOrNull();

	public TreeposIteratorNode<U> getLastNodeOrNull();

}
