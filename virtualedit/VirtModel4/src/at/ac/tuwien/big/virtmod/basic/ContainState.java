package at.ac.tuwien.big.virtmod.basic;

public class ContainState {
	
	private ContainState(int value) {
		this.value = value;
	}
	
	public ContainState mergeWith(ContainState other) {
		return new ContainState(value+other.value);
	}
	
	private int value;

	public ContainState inverse() {
		return new ContainState(-value);
	}
	
	public int hashCode() {
		return value;
	}
	
	public boolean equals(ContainState state) {
		return value == state.value;
	}
	
	public boolean equals(Object o) {
		return (o instanceof ContainState && equals((ContainState)o));
	}
	
	/*public static final ContainState CONTAINS = new ContainState(1);
	
	
	public static final ContainState NOT_CONTAINS = new ContainState(-1);*/
}
