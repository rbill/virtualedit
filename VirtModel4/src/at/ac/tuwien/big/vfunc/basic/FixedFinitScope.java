package at.ac.tuwien.big.vfunc.basic;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Scope.FilteredScope;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public interface FixedFinitScope<Src> extends Scope<Src>, Iterable<Src> {

	@Override
	public Iterator<Src> iterator();

	public static class FilteredFinitScope<Src> extends Scope.FilteredScope<Src> implements FixedFinitScope<Src> {

		public FilteredFinitScope(Function<Src, Boolean> filter, FixedFinitScope<Src> baseScope) {
			super(filter, baseScope);
		}
		
		private FixedFinitScope<Src> scope() {
			return (FixedFinitScope<Src>)super.baseScope;
		}

		@Override
		public Iterator<Src> iterator() {
			return IteratorUtils.filterType(scope().iterator(), filter);
		}
		
	}
	

	public default FilteredScope<Src> filter(Function<Src,Boolean> filter) {
		return new FilteredFinitScope<>(filter, this);
	}
	
}
