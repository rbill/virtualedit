package at.ac.tuwien.big.vfunc.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface SubResultInfo {

	List<FunctionNotifyer<?,?,?>> subResults();
	
	CompleteResult<?,?> thisResult();
	
	public default void priv_getAllLeafResults(Collection<FunctionNotifyer<?,?,?>> leafResults) {
		if (subResults().isEmpty()) {
			leafResults.add(thisResult());
		} else {
			subResults().forEach(x->{
				if (x instanceof CompleteResult) {
					((CompleteResult)x).usedResults().priv_getAllLeafResults(leafResults);
				} else {
					leafResults.add(x);
				}
			});
		}
	}
	
	public default List<FunctionNotifyer<?,?,?>> getLeafResults() {
		List<FunctionNotifyer<?, ?, ?>> ret = new ArrayList<>();
		priv_getAllLeafResults(ret);
		return ret;
	}

	public default void removeSubChangeListener(ChangeListenable<?,?, ?> cl) {
		subResults().forEach(x->{if (x != null){x.removeChangeListener(cl);}});
	}

	public default void addSubChangeListener(ChangeListenable<FunctionNotifyer<?, Object, Object>,Object, Object> cl) {
		subResults().forEach(x->{if (x != null){((CompleteResult)x).addChangeListener(cl);}});
	}
	
}
