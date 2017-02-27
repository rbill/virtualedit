package at.ac.tuwien.big.virtmod.structure;

public interface ConverterAction<T extends VObject> extends InitializerAction<T> {

	public boolean matches(Object edit, Object base);
	
	public T convert(DeltaManager manager, VContainer delta, VContainer edit, VContainer base, Object editObj, Object baseObj);
	
}
