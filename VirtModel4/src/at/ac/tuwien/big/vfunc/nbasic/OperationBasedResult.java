package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class OperationBasedResult<Target> extends BasicResultImpl<Target> {
	
	private Function<List<Object>, Target> function;
	private List<? extends BasicValuedChangeNotifyer<?>> sources;
	private List<BasicListenable> listeners = new ArrayList<BasicListenable>();
	
	public OperationBasedResult(Function<List<Object>, Target> function, List<? extends BasicValuedChangeNotifyer<?>> sources, MetaInfo mi) {
		super(mi);
		this.function = function;
		this.sources = sources;
		setSources(sources);
	}
	
	public OperationBasedResult(Function<List<Object>, Target> function, MetaInfo mi, BasicValuedChangeNotifyer<?>... sources) {
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
	
	public void setSources(List<? extends BasicValuedChangeNotifyer<?>> newSources) {
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
		refresh();
	}
	
	public void setFunction(Function<List<Object>, Target> newFunction) {
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
		List<Object> vals = new ArrayList<>();
		for (BasicValuedChangeNotifyer<?> bvc: sources) {
			vals.add(bvc.value());
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
	
	public static void main(String[] args) {
		Function<List<Object>, Integer> sumFunction = FuncWrappers.log(FuncWrappers.reduceFunction((a,b)->a+b, ()->0, Integer.class), (l,t)->"Summed up to "+t);
		Function<List<Object>, Integer> multFunction = FuncWrappers.log(FuncWrappers.reduceFunction((a,b)->a*b, ()->1, Integer.class),(l,t)->"Multiplied to "+t);
		
		ConstantValue<Integer> firstThing = new ConstantValue<Integer>(0);
		ConstantValue<Integer> secondThing = new ConstantValue<Integer>(2);
		ConstantValue<Integer> thirdThing = new ConstantValue<Integer>(1);
		
		OperationBasedResult<Integer> initMultThing = new OperationBasedResult<Integer>(multFunction, new BasicMetaInfo(), firstThing, secondThing);
		OperationBasedResult<Integer> basicSum = new OperationBasedResult<Integer>(sumFunction, new BasicMetaInfo(), initMultThing, thirdThing);
				
		OperationBasedResult<Integer> constantMult = new OperationBasedResult<Integer>(multFunction, new BasicMetaInfo(), new ConstantValue<>(2), basicSum);
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

}
