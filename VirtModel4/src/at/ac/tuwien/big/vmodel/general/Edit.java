package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;

public interface Edit<T> {
	
	public T getTarget();	
	
	
	public default Edit<T> getMappedEdit(EditApplicationList<T> list) {
		Edit<T> ret = list.getBaseOrNull(this);
		if (ret != null) {
			return ret;
		}
		return this;
	}
	
	
	public boolean precommit(int recalcState);
	
	public void commit();
	

	/**Returns true when this edit does not do anything*/
	public boolean isNull();

}
