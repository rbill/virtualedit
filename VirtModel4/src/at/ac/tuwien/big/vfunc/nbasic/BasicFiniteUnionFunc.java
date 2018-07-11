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

public class BasicFiniteUnionFunc<Src,Target> extends AbstractFunc< Src, Target, QueryResult<Src,Target>> {

	private List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>>> baseFunc = new ArrayList<>(); 
	
	private Class<Src> sourceClass;
	
	private List<FixedFinitScope<Src>> subScopes = new ArrayList<>();
	private ScopeChangeListenable<Scope<Src>, Src> scl = new ScopeChangeListenable<Scope<Src>, Src>() {

		@Override
		public void changed(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			if (change instanceof IterableScopeChange) {
				IterableScopeChange<?, Src> isc = (IterableScopeChange)change;
				myScope.apply(isc);
			} else {
				//This is really not good
				throw new RuntimeException("For now, I can only parse iterablescopechanges");
			}
		}
	};
	
	private class UnionChangeListenable implements ChangeListenable<FunctionNotifyer<?, Src, Target>,Src, Target> {
		
		@Override
		public void changed(Change<? extends FunctionNotifyer<?, Src, Target>, ? extends Src, ? extends Target> change) {
			QueryResult<Src, Target> qr = getCacheIfExists(change.source());
			if (qr != null) {
				qr.refresh();
			}
		}
		
	}
	
	private UnionChangeListenable myListenable = new UnionChangeListenable();
	private Function<? super List<Target>, ? extends Target> mergeFunc;
	
	private static Function<List<Object>, Object> SIMPLE_MERGE_FUNC = (list)->{
		Optional<Object> obj = list.stream().filter(x->x!=null).findAny();
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	};
	
	public static<Target> Function<List<Target>, Target> SIMPLE_MERGE_FUNC() {
		return (Function)SIMPLE_MERGE_FUNC;
	}
	
	public BasicFiniteUnionFunc(Class<Src> sourceClass, List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>> baseFunc) {
		this(sourceClass,baseFunc,SIMPLE_MERGE_FUNC());
	}
	
	public BasicFiniteUnionFunc(Class<Src> sourceClass, List<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>> baseFunc, 
			Function<? super List<Target>, ? extends Target> mergeFunc) {
		this.baseFunc = baseFunc;
		this.sourceClass = sourceClass;
		this.mergeFunc = mergeFunc;
		
		for (AbstractFunc<Src, ? extends Target, ? extends QueryResult<Src,Target>> func: baseFunc) {
			Scope<Src> subScope = func.getScope();
			if (!(subScope instanceof FixedFinitScope))  {
				throw new RuntimeException("Union can only be built from functions with finite scope");
			}
			FixedFinitScope<Src> ffs = (FixedFinitScope<Src>)subScope;
			subScopes.add(ffs);
			ffs.addChangeListener(scl);
		}
		
		Function<Src, BasicResult<Target>> func = (src)->{
			return createResult(src);

		};
		init(func);
	}
	
	private OperationBasedResult<Target, Target> createResult(Src src) {
		//TODO: Better meta info
		MetaInfo mi = new BasicMetaInfo();
		Function<? super List<Target>, ? extends Target> function = mergeFunc;
		
		List<BasicValuedChangeNotifyer<? extends Target>> sources = new ArrayList<BasicValuedChangeNotifyer<? extends Target>>();
		
		for (AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>> s: baseFunc) {
			//TODO: Eigentlich sollte es reichen, das von getScope zu benutzen
			if (s.contains(src)) {
				sources.add(s.evaluate(src));
			}
		}
		
		OperationBasedResult<Target, Target> ret = new OperationBasedResult<Target, Target>(function, sources, mi);
		
		return ret;
	}

	
	private void recalcElement(Src src) {
		BasicQueryResult<Src, Target> qr = ensure(getCacheIfExists(src),BasicQueryResult.class);
		qr.setResult(createResult(src));
	}
	
	
	private class UnionScope extends AbstractFiniteScope<Src> {
		
		Map<Src,Set<Object>> scopeNumb = new HashMap<>();
		
		private void add(Object source, Src src) {
			Set<Object> cur = scopeNumb.computeIfAbsent(src,x->new HashSet<>());
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
			for (Src deleted: isc.getAdded()) {
				remove(isc.source(), deleted);
			}
		}


		private void remove(Object source, Src src) {
			boolean[] removed = new boolean[]{false};
			scopeNumb.computeIfPresent(src,(key,val)->{
				if (val.remove(key)) {
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
		
		@Override
		public boolean contains(Src src) {
			return !scopeNumb.getOrDefault(src, Collections.emptySet()).isEmpty();
		}

		@Override
		public Class<Src> getSourceClass() {
			return sourceClass;
		}

		@Override
		public Iterator<Src> iterator() {
			return scopeNumb.entrySet().stream().filter(x->!x.getValue().isEmpty()).map(x->x.getKey()).iterator();
		}
	};
	
	private UnionScope myScope = new UnionScope();
	
	@Override
	public Scope<Src> getScope() {
		return myScope;
	}

}
