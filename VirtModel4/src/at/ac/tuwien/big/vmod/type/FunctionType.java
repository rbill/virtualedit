package at.ac.tuwien.big.vmod.type;

import java.util.List;

public interface FunctionType extends ContainerType {
	
	public ValueType getDomain();
	
	public GeneralType getRange();
	
	/**If true, this method will never return null, else it may return null for undefined keys in the domain*/
	public boolean isAutocreate();
	
	/**@return null if you can't iterate over this collection*/
	public IterableType getIterableTypeOrNull();

}
