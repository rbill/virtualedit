package at.ac.tuwien.big.vfunc.nbasic;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.util.Util;
import at.ac.tuwien.big.vfunc.basic.FilteredScopeChange;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.IterableScopeChange;
import at.ac.tuwien.big.vfunc.basic.ModifiedScopeChangeListenable;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.ScopeChange;
import at.ac.tuwien.big.vfunc.basic.ScopeChangeListenable;

public class FunctionListWrapper<Func extends AbstractFunc<Src, Trg, ?>, Src,Trg> extends AbstractList<Trg> implements EList<Trg>{
	
	private Func func;
	private TreeMap<Src, BasicEntry<Src, Trg>> map;
	private List<BasicEntry<Src,Trg>> list = new ArrayList<>();
	private BiFunction<? super Src, ? super Src, ? extends Src> newSourceCalculator;
	private TriConsumer<? super Func,? super Src, ? super Trg> valueSetter;
	private ModifiedScopeChangeListenable<Scope<Src>, Src> myScopeListener = new ModifiedScopeChangeListenable<Scope<Src>, Src>() {

		@Override
		public void changeIterable(IterableScopeChange<? extends Scope<Src>, ? extends Src> fsc,
				Iterable<? extends Src> added, Iterable<? extends Src> deleted) {
			for (Src del: deleted) {
				removeSource(del);
			}
			for (Src add: added) {
				addSource(add);
			}
		}

		@Override
		public void changedFiltered(FilteredScopeChange<? extends Scope<Src>, ? extends Src> fsc) {
			System.err.println("FunctionListWrapper does only work if all changes are iterable!");
			fullRecalc();
		}

		@Override
		public void changedGeneric(ScopeChange<? extends Scope<Src>, ? extends Src> change) {
			System.err.println("FunctionListWrapper does only work if all changes are iterable!");
			fullRecalc();
		}


	};
	
	/**Creates an unmodifyable list*/
	public FunctionListWrapper(Func func, Comparator<Src> comparator) {
		this(func,comparator,null,null);
	}
	
	/**I think I only must react to scope changes!*/
	
	private void removeSource(Src src) {
		BasicEntry<Src, Trg> remObj = map.remove(src);
		list.remove(remObj);
	}
	
	private void addSource(Src src) {
		Entry<Src, BasicEntry<Src, Trg>> fe = map.ceilingEntry(src);
		BasicEntry<Src, Trg> be = new BasicEntry<>(src, func.evaluate(src));
		if (fe == null) { //Last entry
			list.add(be);
		} else {
			if (Objects.equals(fe.getKey(), src)) {
				//Don't do anything
			}  else {
				map.put(src, be);
				int idx = list.indexOf(fe.getValue());
				if (idx == -1) {
					throw new RuntimeException("Value "+fe.getValue()+" not found!");
				}
				list.add(idx, be);
			}
		}
		
	}
	
	
	/**Creates a modifyable list*/
	public FunctionListWrapper(Func func, Comparator<Src> comparator, BiFunction<? super Src, ? super Src, ? extends Src> newSourceCalculator, TriConsumer<? super Func,? super Src, ? super Trg> valueSetter) {
		if (comparator == null) {
			comparator = (x,y)->((Comparable)x).compareTo((Comparable)y);
		}
		this.func = func;
		this.func.getScope().addChangeListener(myScopeListener);
		this.map = new TreeMap<>(comparator);
		this.newSourceCalculator = newSourceCalculator;
		this.valueSetter = valueSetter;
		fullRecalc();
	}
	
	private static class BasicEntry<Src,Trg> {
		private Src src;
		private QueryResult<Src, Trg> res;
		
		public BasicEntry(Src src, QueryResult<Src, Trg> res) {
			this.src = src;
			this.res = res;
		}
		
		private Trg value() {
			return (res==null)?null:res.value();
		}
	}
	
	private void fullRecalc() {
		FixedFinitScope<Src> scope = Util.as(func.getScope(), FixedFinitScope.class);
		map.clear();
		for (Src src: scope) {
			map.put(src, new BasicEntry<>(src, func.evaluate(src)));
		}
		list.clear();
		map.forEach((src,val)->{
			list.add(val);
		});
	}
	
	private Src getSrcOrNull(int positiveNumb) {
		if (list.size() >= positiveNumb) {
			return null;
		}
		return list.get(positiveNumb).src;
	}

	@Override
	public void add(int index, Trg value) {
		BiFunction<? super Src, ? super Src, ? extends Src> newSrcCalculator = Util.unsupportedIfNot(this.newSourceCalculator);
		Src leftSrc = getSrcOrNull(index);
		Src rightSrc = getSrcOrNull(index+1);
		Src newSrc = newSrcCalculator.apply(leftSrc, rightSrc);
		Util.unsupportedIfNot(this.valueSetter).consume(this.func, newSrc, value);
	}
	
	@Override
	public Trg remove(int index) {
		BasicEntry<Src, Trg> be = list.get(index);
		Trg ret = be.value();
		Util.unsupportedIfNot(this.valueSetter).consume(this.func, be.src, null);
		return ret;
	}
	
	@Override
	public Trg set(int index, Trg value) {
		BasicEntry<Src, Trg> be = list.get(index);
		Trg ret = be.value();
		Util.unsupportedIfNot(this.valueSetter).consume(this.func, be.src, value);
		return ret;
	}
	
	@Override
	public Trg get(int index) {
		return list.get(index).value();
	}

	@Override
	public int size() {
		return list.size();
	}
	
	public void finalize() throws Throwable {
		super.finalize();
		this.func.getScope().removeChangeListener(myScopeListener);
	}

	@Override
	public void move(int newPosition, Trg object) {
		int idx = indexOf(object);
		if (idx == -1) {
			System.err.println("Can't move nonexistant object, adding ...?");
			add(newPosition, object);
		} else if (idx != newPosition) {
			remove(idx);
			if (newPosition>idx) {
				--newPosition;
			}
			add(newPosition, object);
		}
		
	}

	@Override
	public Trg move(int newPosition, int oldPosition) {
		if (newPosition == oldPosition) {
			return get(newPosition);
		}
		if (newPosition>oldPosition) {
			--newPosition;
		}
		Trg ret = remove(oldPosition);
		add(newPosition, ret);
		return ret;
	}

}
