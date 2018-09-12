package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class OperationBasedResult<AllSource,Target> extends BasicResultImpl<Target> {

	private Function<? super List<AllSource>, ? extends Target> function;
	private List<? extends BasicValuedChangeNotifyer<? extends AllSource>> sources;
	private List<BasicListenable> listeners = new ArrayList<BasicListenable>();
	
	public static<Trg> OperationBasedResult<Trg,Trg> getMergeOperation() {
		Function<? super List<? extends Trg>, Trg> source2Target = (list)->{
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
		
	}
	
	public OperationBasedResult(Function<? super List<AllSource>, ? extends Target> function, List<? extends BasicValuedChangeNotifyer<? extends AllSource>> sources, MetaInfo mi) {
		super(mi);
		this.function = function;
		this.sources = sources;
		setSources(sources);
	}
	
	public OperationBasedResult(Function<? super List<AllSource>, ? extends Target> function, MetaInfo mi, BasicValuedChangeNotifyer<? extends AllSource>... sources) {
		this(function,Arrays.asList(sources), mi);
	}
	
	
	
	private void ensureListenerSize(int ls) {
		while (listeners.size() < ls) {
			int myIndex = listeners.size();
			listeners.add((changedObj)->{
				changed(myIndex);
			});
		}
	}
	
	private void changed(int index) {
		refresh();
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
			ensureListenerSize(sources.size());
			for (int i = 0; i < sources.size(); ++i) {
				sources.get(i).addBasicChangeListener(listeners.get(i));
			}
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

	@Override
	public Target calcValue() {
		List<AllSource> vals = new ArrayList<>();
		for (BasicValuedChangeNotifyer<? extends AllSource> bvc: sources) {
			if (bvc.isDefined()) {
				vals.add(bvc.value());
			} else {
				return null;
			}
		}
		Target ret = function.apply(vals);
		return ret;
	}
	
	private void removeListeners() {
		for (int i = 0; i < Math.min(sources.size(),listeners.size()); ++i) {
			sources.get(i).removeBasicChangeListener(listeners.get(i));
		}
		listeners.clear();
	}
	
	public void finalize() throws Throwable {
		if (sources != null) {
			removeListeners();
		}
		super.finalize();	
	}
	

	public void replaceBy(OperationBasedResult<AllSource,Target> newResult) {
		if (this != newResult) {
			this.function = newResult.function;
			if (!Objects.equals(sources, newResult.sources)) {
				setSourcesNoRefresh(newResult.sources);
			}
			Target newValue = newResult.value();
			setValue(newValue);
		}
	}
	
	
	public static void main(String[] args) {
		Function<List<Object>, Integer> sumFunction = FuncWrappers.log(FuncWrappers.reduceFunction((a,b)->a+b, ()->0, Integer.class), (l,t)->"Summed up to "+t);
		Function<List<Object>, Integer> multFunction = FuncWrappers.log(FuncWrappers.reduceFunction((a,b)->a*b, ()->1, Integer.class),(l,t)->"Multiplied to "+t);
		
		ConstantValue<Integer> firstThing = new ConstantValue<Integer>(0);
		ConstantValue<Integer> secondThing = new ConstantValue<Integer>(2);
		ConstantValue<Integer> thirdThing = new ConstantValue<Integer>(1);
		
		OperationBasedResult<?,Integer> initMultThing = new OperationBasedResult<Object,Integer>(multFunction, new BasicMetaInfo(), firstThing, secondThing);
		OperationBasedResult<?,Integer> basicSum = new OperationBasedResult<Object,Integer>(sumFunction, new BasicMetaInfo(), initMultThing, thirdThing);
				
		OperationBasedResult<?,Integer> constantMult = new OperationBasedResult<Object,Integer>(multFunction, new BasicMetaInfo(), new ConstantValue<>(2), basicSum);
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

	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		List<BasicValuedChangeNotifyer<? extends AllSource>> newSources = new ArrayList<>();
		boolean[] subChanged = new boolean[1];
		for (BasicValuedChangeNotifyer<? extends AllSource> bvc: sources) {
			if (bvc != null) {
				BasicValuedChangeNotifyer<? extends AllSource> newCN = bvc.evaluate(replacer, subChanged, BasicValuedChangeNotifyer.class);
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

}
