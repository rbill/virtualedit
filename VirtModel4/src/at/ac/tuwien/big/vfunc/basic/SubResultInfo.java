package at.ac.tuwien.big.vfunc.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface SubResultInfo {

	List<CompleteResult<?,?>> subResults();
	
	CompleteResult<?,?> thisResult();
	
	public default void priv_getAllLeafResults(Collection<CompleteResult<?,?>> leafResults) {
		if (subResults().isEmpty()) {
			leafResults.add(thisResult());
		} else {
			subResults().forEach(x->x.usedResults().priv_getAllLeafResults(leafResults));
		}
	}
	
	public default List<CompleteResult<?,?>> getLeafResults() {
		List<CompleteResult<?, ?>> ret = new ArrayList<CompleteResult<?,?>>();
		priv_getAllLeafResults(ret);
		return ret;
	}

	public default void removeSubChangeListener(ChangeListenable<?,?, ?> cl) {
		subResults().forEach(x->{if (x != null){x.removeChangeListener(cl);}});
	}

	public default void addSubChangeListener(ChangeListenable<Notifyer<?, Object, Object>,Object, Object> cl) {
		subResults().forEach(x->{if (x != null){((CompleteResult)x).addChangeListener(cl);}});
	}
	
}
