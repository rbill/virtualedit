package at.ac.tuwien.big.vmod.type;

public interface IterableType extends GeneralType {
	
	public boolean isTreeposIterator();
	
	public boolean isExtensible();

	public GeneralType getRange();
}
