package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EditApplicationList<T> {
	
	public List<Edit<T>> getAllBaseEdits();
	
	public Map<Edit<T>, Collection<Edit<T>>> getConflictSet();
	
	public Edit<T> getBaseOrNull(Edit<T> from);
	
	public void addEdit(Edit<T> edit);

}
