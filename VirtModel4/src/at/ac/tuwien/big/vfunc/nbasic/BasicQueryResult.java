package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

import javax.sound.midi.Soundbank;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.Refreshable;
import at.ac.tuwien.big.vfunc.basic.impl.BasicChange;

public class BasicQueryResult<Source,Target> extends WeakChangeFuncNotifyer<BasicQueryResult<Source, Target>, Source, Target> implements QueryResult<Source, Target>, Refreshable, 
	NewValueListenable<Target>,
	FunctionNotifyer<BasicQueryResult<Source,Target>, Source, Target>  {

	//Comes from function
	private BasicResult<Target> result;
	
	public BasicQueryResult(QueryResultCache<Source, ? extends WeakObject<Source>> container, Source src, BasicResult<Target> result) {
		this.result = result;
		this.result.addChangeListener(this);
		init(src, container);
	}

	@Override
	public void changed(Target oldValue, Target newValue) {
		notifyChanged(source(), oldValue, newValue);
	}
	
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		return this;
	}
	 
	@Override
	public void finalize() {
		super.finalize();
	}

	@Override
	public MetaInfo getMetaInfo() {
		return this.result==null?null:this.result.getMetaInfo();
	}

	public BasicResult<Target> getResult() {
		return this.result;
	}

	@Override
	public void refresh() {
		//Moeglicherweise stimmt das nicht
		if (this.result != null) {
			this.result.refresh();
		}
	}

	public void setResult(BasicResult<Target> newResult) {
		if (this.result != newResult) {
			if (this.result != null) {
				this.result.removeChangeListener(this);
			}
			Target oldVal = value();
			this.result = newResult;
			if (this.result != null) {
				this.result.addChangeListener(this);
			}
			Target newVal = value();
			if (!Objects.equals(oldVal, newVal)) {
				changed(oldVal, newVal);
			}
		}
	}

	@Override
	public Target value() {
		return this.result==null?null:this.result.value();
	}
	
}
