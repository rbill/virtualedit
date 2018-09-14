package at.ac.tuwien.big.vfunc.nbasic;

import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Scope;

public class ValueFilteredFunction<Src,Target, QR extends QueryResult<Src,Target>> extends AbstractFunc<Src, Target, QR> {
	
	private AbstractFunc<Target, Boolean, ? extends QueryResult<Target,Boolean>> filter;
	
	private AbstractFunc<Src, Boolean, QueryResult<Src,Boolean>> metaFilter;
	//private AbstractFunc<Src, Target, QueryResult<Src,Target>> chainedFunc;
	
	private Scope<Src> filteredScope;

	public class FilteredBasicResultImpl extends BasicResultImpl<Target> {
		
		
		
		public FilteredBasicResultImpl(MetaInfo mi, BasicValuedChangeNotifyer<Target> ref) {
			super(mi);
			this.ref = ref;
			this.ref.addBasicChangeListener(bl);
			this.filterResult = filter.evaluate(this.ref.value());
			if (this.filterResult != null) {
				this.filterResult.addBasicChangeListener(bl);
			}
		}

		BasicValuedChangeNotifyer<Target> ref;
		QueryResult<Target, Boolean> filterResult;
		
				
		BasicListenable bl = new BasicListenable() {
			
			@Override
			public void changed(BasicChangeNotifyer bcm) {
				refresh();
			}
		};

		@Override
		public Object evaluateNew(Replacer replacer, boolean[] changed) {
			return this;
		}

		@Override
		public Target calcValue() {
			Target ret = ref.value();
			if (ret != null) {
				QueryResult<Target, Boolean> newQueryResult = filter.evaluate(ret);
				if (newQueryResult != this.filterResult) { 
					if (this.filterResult != null) {
						this.filterResult.removeBasicChangeListener(bl);
					}
					if (newQueryResult != null) {
						newQueryResult.addBasicChangeListener(bl);
					}
					this.filterResult = newQueryResult;
				}
			} else {
				if (this.filterResult != null) {
					this.filterResult.removeBasicChangeListener(bl);
				}
				this.filterResult = null;
				
			}
			if (this.filterResult == null || !this.filterResult.isDefined()) {
				return null;
			}
			Boolean filterRes = this.filterResult.value();
			if (filterRes == null || !filterRes) {
				return null;
			}
			return ret;
		}
		
		
		
		public void finalize() throws Throwable {
			super.finalize();
			if (this.ref != null) {
				this.ref.removeBasicChangeListener(bl);
			}
			if (this.filterResult != null) {
				this.filterResult.removeBasicChangeListener(bl);
			}
		}
		
	}
	
	public ValueFilteredFunction(AbstractFunc<Src, Target, QR> base, AbstractFunc<Target, Boolean, ? extends QueryResult<Target,Boolean>> filter) {
		this.filter = filter;
		
		this.metaFilter = new BasicChainedFunc<>(base, filter);
		this.filteredScope = base.getScope().filter(metaFilter);
		// TODO Auto-generated constructor stub
		
		Function<Src, BasicResult<Target>> func = (src)->{
			MetaInfo mi = null;
			return new FilteredBasicResultImpl(mi , base.evaluate(src));
			
		};
		init(func, null);
	}
	
	
	@Override
	public Scope<Src> getScope() {
		return filteredScope;
	}

}
