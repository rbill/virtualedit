package at.ac.tuwien.big.vmodel.general.impl;

import java.util.WeakHashMap;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.DoubleParameterIFace;
import at.ac.tuwien.big.vmodel.general.MergedNotifier;
import at.ac.tuwien.big.vmodel.general.Merger;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class MergerWrapFunc<X, Y1, Y2 extends MergedNotifier, YO> extends SourcedObject implements VEntryIterableFunc<X, Y2> {
	
	private VEntryIterableFunc<X, Y1> base;
	private DoubleParameterIFace<X, Y1, Y2> wrapper;
	private YO target;
	private Merger<X,Y1,YO> merger;
	private SimpleVFunc<X, Y2> cache;
	
	public String toString() {
		return ToString();
	}
	
	public MergerWrapFunc(VContainer cont, VEntryIterableFunc<X, Y1> base, VEntryIterableFunc<X, ? extends Y1> edit, Merger<X,Y1,YO> merger, YO target, DoubleParameterIFace<X, Y1, Y2> creator) {
		super(cont);
		this.base = base;
		this.target = target;
		merger.setBaseFunc(base,edit);
		merger.setTarget(target);
		this.merger = merger;
		this.cache = new SimpleVFunc<X, Y2>(cont.createChild("wrapper"),(x)->{
			Y2 ret = creator.get(x,base().get(x));
			ret.setMerger(merger); 
			return ret;
		});
	}
	
	public void setBaseFunc(VEntryIterableFunc<X, Y1> base, VEntryIterableFunc<X, Y1> edit) {
		merger.setBaseFunc(base, edit);
	}
	
	public Merger<X,Y1,YO> getMerger() {
		return merger;
	}

	@Override
	public boolean isSelfEmpty() {
		return cache.isSelfEmpty();
	}

	@Override
	public boolean selfClear() {
		return cache.selfClear();
	}


	public VEntryIterableFunc<X, Y1> base() {
		return base;
	}
	

	@Override
	public Iterable<? extends Entry<? extends X, ? extends Y2>> getEntries() {
		merger.notifyOtherChange();
		return IteratorUtils.convert(base().getEntries(), (x)->new FakeEntry<>(x.getKey(),get(x.getKey())));
	}

	@Override
	public Y2 get(X x) {
		return cache.get(x);
	}

}
