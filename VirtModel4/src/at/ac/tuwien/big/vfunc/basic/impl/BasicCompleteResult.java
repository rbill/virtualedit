package at.ac.tuwien.big.vfunc.basic.impl;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.vfunc.basic.Assignment;
import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Notifyer;
import at.ac.tuwien.big.vfunc.basic.SubResultInfo;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.Value;

public class BasicCompleteResult<Src,Target> implements CompleteResult<Src, Target> {
	
	Src source; Target target; SubResultInfo usedResults;
	
	private Assignment<Src, Target> reason;
	
	List<WeakReference<ChangeListenable<? super CompleteResult<Src, Target>, ? super Src, ? super Target>>> changeListeners = new ArrayList<>();

	public BasicCompleteResult(Assignment<Src, Target> reason, Src source, Target target, SubResultInfo usedResults) {
		this.reason = reason;
		this.source = source;
		this.target = target;
		this.usedResults = usedResults;
	}
	
	@Override
	public Target value() {
		return target;
	}
	
	@Override
	public Assignment<Src, Target> reason() {
		return reason;
	}

	@Override
	public Src source() {
		return source;
	}

	@Override
	public SubResultInfo usedResults() {
		return usedResults;
	}

	@Override
	public void refresh() {
		//I think the complete result should be reused if possible, but I don't know if I can guarantee it??
		//Probably it is something different ...
		CompleteResult<Src, Target> calcResult = calcResult();
		mergeWithCurrent(calcResult);
	}


	@Override
	public List<WeakReference<ChangeListenable<? super CompleteResult<Src, Target>, ? super Src, ? super Target>>> getChangeListeners() {
		return changeListeners;
	}
	
	public void finalize() throws Throwable {
		super.finalize();
		try {
			usedResults.subResults().forEach(x->{if (x != null){x.removeChangeListener(this);}});
		} catch (Exception e) {
			System.err.println("Error finalizing object: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void mergeWithCurrent(CompleteResult<Src, Target> newResult) {
		if (this != newResult) {
			Target oldTarget = target;
			try {
				usedResults.removeSubChangeListener(this);
			} catch (Exception e) {
				System.err.println("Error removing listeners: "+e.getMessage());
				e.printStackTrace();
			}
			target = newResult.value();
			usedResults = newResult.usedResults();
			usedResults.addSubChangeListener(this);
			if (!Objects.equals(oldTarget,target)) {
				notifyChanged(source,oldTarget,target);
			}
		}
	}

	@Override
	public void changed(Change<? extends Notifyer<?, Object, Object>, ? extends Object, ? extends Object> change) {
		refresh();
	}

}
