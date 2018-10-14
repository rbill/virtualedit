package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public class OperationBasedResult<AllSource,Target> extends BasicResultImpl<Target> {

	public static void main(String[] args) {
		Function<List<Object>, Integer> sumFunction = FuncWrappers.log(FuncWrappers.reduceFunction((a,b)->a+b, ()->0, Integer.class), (l,t)->"Summed up to "+t);
		Function<List<Object>, Integer> multFunction = FuncWrappers.log(FuncWrappers.reduceFunction((a,b)->a*b, ()->1, Integer.class),(l,t)->"Multiplied to "+t);
		
		ConstantValue<Integer> firstThing = new ConstantValue<>(0);
		ConstantValue<Integer> secondThing = new ConstantValue<>(2);
		ConstantValue<Integer> thirdThing = new ConstantValue<>(1);
		
		OperationBasedResult<?,Integer> initMultThing = new OperationBasedResult<>(multFunction, new BasicMetaInfo(), false, firstThing, secondThing);
		OperationBasedResult<?,Integer> basicSum = new OperationBasedResult<>(sumFunction, new BasicMetaInfo(), false,initMultThing, thirdThing);
				
		OperationBasedResult<?,Integer> constantMult = new OperationBasedResult<>(multFunction, new BasicMetaInfo(), false,new ConstantValue<>(2), basicSum);
		System.out.println("Initial: "+constantMult.value());
		secondThing.setValue(0);
		System.out.println("Set second value to 0");
		thirdThing.setValue(8);
		System.out.println("Set third value to 8");
		firstThing.setValue(5);
		System.out.println("Set first value to 5");
		secondThing.setValue(7);
		System.out.println("Set second value to 7");
	}
	private Function<? super List<AllSource>, ? extends Target> function;
	private List<? extends BasicValuedChangeNotifyer<? extends AllSource>> sources;
	

	/*public static<Trg> OperationBasedResult<Trg,Trg> getMergeOperation() {
		static Function<? super List<? extends Trg>, Trg> source2Target = (list)->{
			if (list.isEmpty()) {
				return null;
			}
			Iterator<? extends Trg> iter = list.iterator();
			Trg ret = iter.next();
			while (iter.hasNext()) {
				Object next = iter.next();
				if (!Objects.equals(next, ret)) {
					System.err.println("Constraint violation: "+ret+" VS "+next);
					break;
				}
			}
			return ret;
		};
		
	}*/
	
	private List<BasicListenable> listeners = new ArrayList<>();
	private boolean acceptUndefined;
	
	public OperationBasedResult(Function<? super List<AllSource>, ? extends Target> function, List<? extends BasicValuedChangeNotifyer<? extends AllSource>> sources, MetaInfo mi, boolean acceptUndefined) {
		super(mi);
		
		this.function = function;
		this.sources = sources;
		setSources(sources);
		this.acceptUndefined = acceptUndefined;
		Reason r = mi.getReason();
		if (r instanceof ComposedReason) {
			ComposedReason cr = (ComposedReason)r;
			cr.addDefaultDerivation(DerivationStatus.DERIVED);
		}
	}
	
	
	
	public OperationBasedResult(Function<? super List<AllSource>, ? extends Target> function, MetaInfo mi, boolean acceptUndefined, BasicValuedChangeNotifyer<? extends AllSource>... sources) {
		this(function,Arrays.asList(sources), mi, acceptUndefined);
	}
	
	@Override
	public Target calcValue() {
		List<AllSource> vals = new ArrayList<>();
		for (BasicValuedChangeNotifyer<? extends AllSource> bvc: this.sources) {
			if (this.acceptUndefined || bvc.isDefined()) {
				vals.add(bvc.value());
			} else {
				return null;
			}
		}
		Target ret = this.function.apply(vals);
		return ret;
	}
	
	private void changed(int index) {
		refresh();
	}
	
	private void ensureListenerSize(int ls) {
		while (this.listeners.size() < ls) {
			int myIndex = this.listeners.size();
			this.listeners.add((changedObj)->{
				changed(myIndex);
			});
		}
	}
	
	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		List<BasicValuedChangeNotifyer<? extends AllSource>> newSources = new ArrayList<>();
		boolean[] subChanged = new boolean[1];
		for (BasicValuedChangeNotifyer<? extends AllSource> bvc: this.sources) {
			if (bvc != null) {
				/*BasicValuedChangeNotifyer<? extends AllSource> newCN = bvc.evaluate(replacer, subChanged, BasicValuedChangeNotifyer.class);
				newSources.add(newCN);*/
				throw new UnsupportedOperationException();
			} else {
				newSources.add(null);
			}
		}
		if (!subChanged[0]) {
			return this;
		}
		//TODO: Implement creating new meta info
		MetaInfo newMetaInfo = getMetaInfo();
		OperationBasedResult<AllSource,Target> ret = new OperationBasedResult<>(this.function, newSources, newMetaInfo, this.acceptUndefined);

		return ret;
	}

	@Override
	public void finalize() throws Throwable {
		if (this.sources != null) {
			removeListeners();
		}
		super.finalize();	
	}

	private void removeListeners() {
		for (int i = 0; i < Math.min(this.sources.size(),this.listeners.size()); ++i) {
			this.sources.get(i).removeBasicChangeListener(this.listeners.get(i));
		}
		this.listeners.clear();
	}
	
	public void replaceBy(OperationBasedResult<AllSource,Target> newResult) {
		if (this != newResult) {
			this.function = newResult.function;
			if (!Objects.equals(this.sources, newResult.sources)) {
				setSourcesNoRefresh(newResult.sources);
			}
			Target newValue = newResult.value();
			setValue(newValue);
		}
	}
	
	public void setFunction(Function<? super List<AllSource>, ? extends Target> newFunction) {
		this.function = newFunction;
		refresh();
	}
	

	private void setOrNull(List<Object> list, int index, Object newObj) {
		while (list.size() < index) {
			list.add(null);
		}
		if (list.size() == index) {
			list.add(newObj);
		} else {
			list.set(index, newObj);
		}
	}
	
	
	public void setSources(List<? extends BasicValuedChangeNotifyer<? extends AllSource>> newSources) {
		setSourcesNoRefresh(newSources);
		refresh();
	}

	private void setSourcesNoRefresh(List<? extends BasicValuedChangeNotifyer<? extends AllSource>> newSources) {
		if (this.sources != null) {
			removeListeners();
		}
		this.sources = newSources;
		if (newSources != null) {
			ensureListenerSize(this.sources.size());
			for (int i = 0; i < this.sources.size(); ++i) {
				this.sources.get(i).addBasicChangeListener(this.listeners.get(i));
			}
		}
	}

}
