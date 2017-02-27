package at.ac.tuwien.big.virtmod.structure;

public interface InitializerAction<T extends VObject> {

	public T initialize(VContainer cont);
}
