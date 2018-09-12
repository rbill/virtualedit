package at.ac.tuwien.big.vfunc.nbasic;

import java.util.ArrayList;
import java.util.List;

public class RecurseResult<Source>  extends BasicResultImpl<Source> {

	private AbstractFunc<Source, Source, ? extends QueryResult<Source,Source>> recursion;
	private AbstractFunc<Source, Source, ? extends QueryResult<Source,Source>> thisFunc;
	private Source src;
	
	public RecurseResult(MetaInfo mi, Source source, AbstractFunc<Source, Source, ? extends QueryResult<Source,Source>> thisFunc,
			AbstractFunc<Source, Source, ? extends QueryResult<Source,Source>> recursion) {
		super(mi);
		this.recursion = recursion;
		this.thisFunc = thisFunc;
		this.src = source;
	}
	
	
	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		List<BasicValuedChangeNotifyer<? extends Source>> newSources = new ArrayList<>();
		boolean[] subChanged = new boolean[1];
		for (BasicValuedChangeNotifyer<? extends Source> bvc: sources) {
			if (bvc != null) {
				BasicValuedChangeNotifyer<? extends Source> newCN = bvc.evaluate(replacer, subChanged, BasicValuedChangeNotifyer.class);
				newSources.add(newCN);
			} else {
				newSources.add(null);
			}
		}
		if (!subChanged[0]) {
			return this;
		}
		//TODO: Implement creating new meta info
		MetaInfo newMetaInfo = getMetaInfo();
		OperationBasedResult<AllSource,Target> ret = new OperationBasedResult<AllSource,Target>(this.function, newSources, newMetaInfo);
		return ret;
	}

	@Override
	public Source calcValue() {
		QueryResult<Source, Source> qr = recursion.evaluate(src);
		Source val = qr.value();
		if (val == null) { 
			return src;
		}
		QueryResult<Source, Source> newResult = thisFunc.evaluate(val);
		return newResult.value();
	}

}
