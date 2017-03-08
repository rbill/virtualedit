package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface Editable<T> {
	
	public T editable();
	
	public void clearEdits();
	
	/**Somehow I need to find out how to apply edits here ...
	 * 
	 * Apply this edit here - directly for normal Editable, indirectly for Delta-Editable??
	 * */
	public void addEdit(Edit<? super T> edit);
	
	
		
	
}
