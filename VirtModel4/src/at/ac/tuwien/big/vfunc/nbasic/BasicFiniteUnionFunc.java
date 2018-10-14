package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.IterableScopeChange;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChange;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.ScopeNotifyer;
import at.ac.tuwien.big.vfunc.basic.impl.AbstractFiniteScope;
import at.ac.tuwien.big.vfunc.basic.impl.AbstractScope;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.ValueList;

public class BasicFiniteUnionFunc<Src,Target> extends AbstractFunc< Src, Target, QueryResult<Src,Target>> {

	private class UnionChangeListenable implements ChangeListenable<FunctionNotifyer<?, Src, Target>,Src, Target> {
		
		@Override
		public void changed(Change<? extends FunctionNotifyer<?, Src, Target>, ? extends Src, ? extends Target> change) {
			QueryResult<Src, Target> qr = getCacheIfExists(change.source());
			if (qr != null) {
				qr.refresh();
			}
		}
		
	} 
	
	private class UnionScope extends AbstractFiniteScope<Src> {
		
		Map<Src,Set<Object>> scopeNumb = new HashMap<>();
		
		private void add(Object source, Src src) {
			Set<Object> cur = this.scopeNumb.computeIfAbsent(src,x->new HashSet<>());
			if (cur.isEmpty()) {
				if (cur.add(source)) {
					recalcElement(src);
				}
				notifyAdded(src);
			} else {
				if (cur.add(source)) {
					recalcElement(src);
				}
			}
		}
		
		
		public void apply(IterableScopeChange<?, Src> isc) {
			//TODO: For large instances, better handle them together ...
			for (Src added: isc.getAdded()) {
				add(isc.source(), added);
			}
			for (Src deleted: isc.getDeleted()) {
				remove(isc.source(), deleted);
			}
		}


		@Override
		public boolean contains(Src src) {
			return !this.scopeNumb.getOrDefault(src, Collections.emptySet()).isEmpty();
		}
		
		@Override
		public Class<Src> getSourceClass() {
			return BasicFiniteUnionFunc.this.sourceClass;
		}

		@Override
		public Iterator<Src> iterator() {
			return this.scopeNumb.entrySet().stream().filter(x->!x.getValue().isEmpty()).map(x->x.getKey()).iterator();
		}

		private void remove(Object source, Src src) {
			boolean[] removed = new boolean[]{false};
			this.scopeNumb.computeIfPresent(src,(key,val)->{
				if (val.remove(source)) {
					if (val.isEmpty()) {
						removed[0]=true;
					}			
					recalcElement(src);		
				}
				
				return val.isEmpty()?null:val;
			});
			if (removed[0]) {
				notifyDeleted(src);
			}
		}
	}
	
	private static Function<List<Object>, Object> SIMPLE_MERGE_FUNC = (list)->{
		Optional<Object> obj = list.stream().filter(x->x!=null).findFirst();
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	};
	
	public static<Target> Function<List<Target>, Target> SIMPLE_MERGE_FUNC() {
		return (Function)SIMPLE_MERGE_FUNC;
	}
	
	private List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>>> baseFunc = new ArrayList<>();
	
	private Class<Src> sourceClass;
	private List<FixedFinitScope<Src>> subScopes = new ArrayList<>();
	
	private ScopeChangeListenable<Scope<Src>, Src> scl = new ScopeChangeListenable<Scope<Src>, Src>() {

		@Override
		public void changed(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			if (change instanceof IterableScopeChange) {
				IterableScopeChange<?, Src> isc = (IterableScopeChange)change;
				BasicFiniteUnionFunc.this.myScope.apply(isc);
			} else {
				//This is really not good
				throw new RuntimeException("For now, I can only parse iterablescopechanges");
			}
		}
	};
	
	private UnionChangeListenable myListenable = new UnionChangeListenable();
	
	private Function<? super List<Target>, ? extends Target> mergeFunc;
	
	private UnionScope myScope = new UnionScope();
	
	public BasicFiniteUnionFunc(Class<Src> sourceClass, List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>> baseFunc) {
		this(sourceClass,baseFunc,SIMPLE_MERGE_FUNC());
	}

	
	public BasicFiniteUnionFunc(Class<Src> sourceClass, List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>> baseFunc, 
			Function<? super List<Target>, ? extends Target> mergeFunc) {
		this.baseFunc = baseFunc;
		this.sourceClass = sourceClass;
		this.mergeFunc = mergeFunc;
		
		for (AbstractFunc<Src, ? extends Target, ? extends QueryResult<Src,Target>> func: baseFunc) {
			addBaseNoRefresh(func);
		}
		
		Function<Src, BasicResult<Target>> func = (src)->{
			return createResult(src);

		};
		setBasicMetaInfoCreater(CREATE_COMPOSED_REASON);
		//I think you can directly initialize that
		init(func, null);
	}
	
	public void addBase(AbstractFunc<Src, ? extends Target, ? extends QueryResult<Src,Target>> func) {
		FixedFinitScope<Src> ffs = addBaseNoRefresh(func);
		((List)this.baseFunc).add(func);
		ffs.forEach(x->{
			this.myScope.add(ffs, x);
		});
	}
	
	public void removeBase(AbstractFunc<Src, ? extends Target, ? extends QueryResult<Src,Target>> func) {
		FixedFinitScope<Src> ffs = removeBaseNoRefresh(func);
		((List)this.baseFunc).remove(func);
		ffs.forEach(x->{
			this.myScope.remove(ffs, x);
		});
	}
	
	private FixedFinitScope<Src> addBaseNoRefresh(AbstractFunc<Src, ? extends Target, ? extends QueryResult<Src,Target>> func) {
		Scope<Src> subScope = func.getScope();
		if (!(subScope instanceof FixedFinitScope))  {
			throw new RuntimeException("Union can only be built from functions with finite scope");
		}
		FixedFinitScope<Src> ffs = (FixedFinitScope<Src>)subScope;
		this.subScopes.add(ffs);
		ffs.addChangeListener(this.scl);
		return ffs;
	}
	
	private FixedFinitScope<Src> removeBaseNoRefresh(AbstractFunc<Src, ? extends Target, ? extends QueryResult<Src,Target>> func) {
		Scope<Src> subScope = func.getScope();
		if (!(subScope instanceof FixedFinitScope))  {
			throw new RuntimeException("Union can only be built from functions with finite scope");
		}
		FixedFinitScope<Src> ffs = (FixedFinitScope<Src>)subScope;
		this.subScopes.remove(ffs);
		ffs.removeChangeListener(this.scl);
		return ffs;
	}
	
	private OperationBasedResult<Target, Target> createResult(Src src) {
		//TODO: Better meta info
		MetaInfo mi = createMetaInfo(src);
		Function<? super List<Target>, ? extends Target> function = this.mergeFunc;
		
		List<BasicValuedChangeNotifyer<? extends Target>> sources = new ArrayList<>();
		
		for (AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>> s: this.baseFunc) {
			//TODO: Eigentlich sollte es reichen, das von getScope zu benutzen
			
			//Nimmt das nicht an, dass sich der Scope nicht �ndert? - vermutlich egal, weil es recalct wird
			if (s.contains(src)) {
				sources.add(s.evaluate(src));
			}
		}
		Reason reason = mi.getReason();
		if (reason instanceof ComposedReason) {
			ComposedReason cr = (ComposedReason)reason;
			cr.initSourceInfos(()->sources);
		}
		
		OperationBasedResult<Target, Target> ret = new OperationBasedResult<>(function, sources, mi, true);
		//ret.refresh();
		return ret;
	};
	
	public List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>>>  getBases() {
		return this.baseFunc;
	}
	
	@Override
	public Scope<Src> getScope() {
		return this.myScope;
	}


	private void recalcElement(Src src) {
		QueryResult<Src, Target> cacheIfExists = getCacheIfExists(src);
		if (cacheIfExists == null) {
			return;
		}
		BasicQueryResult<Src, Target> qr = ensure(cacheIfExists,BasicQueryResult.class);
		qr.setResult(createResult(src));
	}

}
