package at.ac.tuwien.big.virtmod.basic;

public interface VListEntry<T> {

	public long editId();
	
	public T value();
	
	public Treepos treepos();
}
