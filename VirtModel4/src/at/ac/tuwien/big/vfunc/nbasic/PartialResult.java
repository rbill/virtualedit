package at.ac.tuwien.big.vfunc.nbasic;

import java.util.IdentityHashMap;

//Eigentlich so etwas wie ein PartialResult
public interface PartialResult {
	
	public Object evaluateNew(Replacer replacer, boolean[] changed);
	
	
	public default Object evaluate(Replacer replacer, boolean[] changed) {
		Object ret = replacer.get(this, (from)->from.evaluateNew(replacer, changed));
		changed[0] |= ret != this;
		return ret;
	}
	
	public default<T> T evaluate(Replacer replacer, boolean[] changed,
			Class<T> class1) {
		Object ret = evaluate(replacer, changed);
		if (class1.isInstance(ret)) {
			return (T)ret;
		}
		throw new RuntimeException("Expected class "+class1.getCanonicalName()+" when evaluating, got: "+((ret==null)?"null":ret.getClass().getCanonicalName()));
	}
}
