package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;

public class BasicFinitUnionScope<Src> extends BasicUnionScope<Src, FixedFinitScope<Src>> implements FixedFinitScope<Src> {

	public BasicFinitUnionScope(Collection<? extends FixedFinitScope<Src>> scopes) {
		super(scopes);
	}

	public Collection<Src> getValues() {
		Set<Src> ret = new HashSet<>();
		for (FixedFinitScope<Src> ffs: scopes) {
			ffs.forEach(x->ret.add(x));
		}
		return ret;
	}

	@Override
	public Iterator<Src> iterator() {
		return getValues().iterator();
	}

}
