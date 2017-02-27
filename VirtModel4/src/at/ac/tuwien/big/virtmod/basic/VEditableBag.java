package at.ac.tuwien.big.virtmod.basic;

public interface VEditableBag<T> extends VBag<T> {

	public Editstate getEditState();
	
	
	public boolean addSet(T entry);
	
	public void removeAll(T entry);
	
	public void clear();
	
	/**Call when you are sure nothing of your properties is floating around*/
	public void clean();
	
	public boolean addDefault(T value);
	
	public default VEditableBag<T> getBaseEditableBag() {
		return this;
	}
	
	public void ensure(T forValue, ContainState state);



}
