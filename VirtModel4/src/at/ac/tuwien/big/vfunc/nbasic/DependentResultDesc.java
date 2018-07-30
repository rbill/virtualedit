package at.ac.tuwien.big.vfunc.nbasic;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Refreshable;

public class DependentResultDesc<Target> {

	public static class ResultSlot<T> {

		protected int index;
		protected List<ResultSlot<?>> targets = new ArrayList<DependentResultDesc.ResultSlot<?>>();
		protected int[] targetIndex;
		protected int[] sourceIndex;
		protected List<ResultSlot<?>> sources = new ArrayList<DependentResultDesc.ResultSlot<?>>();

		public void addTarget(ResultSlot<?> target) {
			this.targets.add(target);
		}

	}

	private static class CalculatedResultSlot<T> extends ResultSlot<T> {
		private Function<? super Object[], ? extends BasicValuedChangeNotifyer<T>> calculation;
	}

	private static class FinalCalculatedResultSlot<T> extends ResultSlot<T> {
		private Function<? super Object[], ? extends T> calculation;
	}
	
	private static class InitialResultSlot<T> extends ResultSlot<T> {

	}

	public static <T> InitialResultSlot<T> createInputSlot() {
		return new InitialResultSlot<T>();
	}

	public <T> CalculatedResultSlot<T> createIntermediateDesc(List<? extends ResultSlot<?>> dependentSlot,
			Function<? super Object[], ? extends BasicValuedChangeNotifyer<T>> calculationFunc) {
		CalculatedResultSlot<T> ret = new CalculatedResultSlot<T>();
		ret.calculation = calculationFunc;
		ret.sources.addAll(dependentSlot);
		dependentSlot.forEach(x -> x.addTarget(ret));
		return ret;
	}
	

	public <T> FinalCalculatedResultSlot<T> createFinalDesc(List<? extends ResultSlot<?>> dependentSlot,
			Function<? super Object[], ? extends T> calculationFunc) {
		FinalCalculatedResultSlot<T> ret = new FinalCalculatedResultSlot<T>();
		ret.calculation = calculationFunc;
		ret.sources.addAll(dependentSlot);
		dependentSlot.forEach(x -> x.addTarget(ret));
		return ret;
	}

	private List<ResultSlot<?>> allResultSlots = new ArrayList<>();
	private ResultSlot<Target> finalResultSlot;

	private void compile() {
		IdentityHashMap<ResultSlot<?>, Integer> counter = new IdentityHashMap<ResultSlot<?>, Integer>();
		allResultSlots.forEach(x -> counter.computeIfAbsent(x, y -> counter.size()));
		for (ResultSlot<?> slot : allResultSlots) {
			slot.index = counter.get(slot);
		}
		for (ResultSlot<?> slot : allResultSlots) {
			slot.sourceIndex = new int[slot.sources.size()];
			for (int i = 0; i < slot.sourceIndex.length; ++i) {
				slot.sourceIndex[i] = slot.sources.get(i).index;
			}
			slot.targetIndex = new int[slot.targets.size()];
			for (int i = 0; i < slot.targetIndex.length; ++i) {
				slot.targetIndex[i] = slot.targets.get(i).index;
			}
		}
	}

	public void finish(ResultSlot<Target> finalSlot) {
		if (finalSlot == null) {
			finalSlot = (ResultSlot<Target>) allResultSlots.get(allResultSlots.size() - 1);
		}
		this.finalResultSlot = finalSlot;
		compile();
	}

	private static abstract class SlotResult<Type> implements Refreshable {

		private List<SlotResult<?>> dependent = new ArrayList<>();
		private List<Refreshable> notified = new ArrayList<>();

		protected abstract Type value();

		protected BasicListenable changeListenable = new BasicListenable() {

			@Override
			public void changed(BasicChangeNotifyer bcm) {
				notified.forEach(x -> x.refresh());
			}
		};

		public void refresh() {
			recalc(true);
		}

		protected void notifyTargets() {
			notified.forEach(x -> x.refresh());
		}

		public void recalc(boolean notifyTargets) {

			Object[] obj = new Object[dependent.size()];
			for (int i = 0; i < obj.length; ++i) {
				obj[i] = dependent.get(i).value();
			}
			recalc(obj, notifyTargets);
		}

		protected abstract void recalc(Object[] newSource, boolean notifyTargets);

	}

	private static class IntermediateSlotResult<Type> extends SlotResult<Type> {
		private Function<? super Object[], ? extends BasicValuedChangeNotifyer<Type>> calculationFunc;
		private BasicValuedChangeNotifyer<Type> curValue;

		@Override
		protected void recalc(Object[] newSource, boolean notifyTargets) {
			BasicValuedChangeNotifyer<Type> oldValue = curValue;
			BasicValuedChangeNotifyer<Type> nextValue = calculationFunc.apply(newSource);
			this.curValue = nextValue;

			if (!Objects.equals(oldValue, curValue)) {
				if (oldValue != null) {
					oldValue.removeBasicChangeListener(changeListenable);
				}
				if (curValue != null) {
					curValue.addBasicChangeListener(changeListenable);
				}
				if (notifyTargets) {
					notifyTargets();
				}
			}
		}

		@Override
		protected Type value() {
			return curValue == null ? null : curValue.value();
		}

		public void finalize() throws Throwable {
			super.finalize();
			if (curValue != null) {
				curValue.removeBasicChangeListener(changeListenable);
			}
		}

	}
	
	private static class FinalSlotResult<Type> extends SlotResult<Type> {
		private Function<? super Object[], ? extends Type> calculationFunc;
		private Type curValue;

		@Override
		protected void recalc(Object[] newSource, boolean notifyTargets) {
			Type oldValue = curValue;
			Type nextValue = calculationFunc.apply(newSource);
			this.curValue = nextValue;

			if (!Objects.equals(oldValue, curValue)) {
				if (notifyTargets) {
					notifyTargets();
				}
			}
		}

		@Override
		protected Type value() {
			return curValue;
		}

		public void finalize() throws Throwable {
			super.finalize();
		}

	}

	public class DependentResult<Source> extends BasicResultImpl<Target> {

		private Source source;
		private SlotResult<?>[] slotResults;
		private SlotResult<Target> resultSlot;

		public DependentResult(MetaInfo mi, Source source, boolean initialize) {
			super(mi);
			this.source = source;
			// Add dependencies
			slotResults = new SlotResult[allResultSlots.size()];
			ConstantValue<Source> sourceValue = new ConstantValue<Source>(source);
			Function<Object, ConstantValue<Source>> initialSlotFunc = (x) -> sourceValue;
			for (int i = 0; i < allResultSlots.size(); ++i) {
				ResultSlot<?> rs = allResultSlots.get(i);
				if (rs instanceof FinalCalculatedResultSlot) {
					FinalSlotResult<Source> isr = new FinalSlotResult();
					isr.calculationFunc = ((FinalCalculatedResultSlot) rs).calculation;
				} else {
					IntermediateSlotResult<Source> isr = new IntermediateSlotResult<>();
					slotResults[i] = isr;
					if (rs instanceof CalculatedResultSlot) {
						isr.calculationFunc = ((CalculatedResultSlot) rs).calculation;
					} else if (rs instanceof InitialResultSlot) {
						isr.calculationFunc = (Function) initialSlotFunc;
					} else {
						throw new UnsupportedOperationException("Some slot result is not yet implemented!: " + rs);
					}
				}
			}
			for (int i = 0; i < allResultSlots.size(); ++i) {
				ResultSlot<?> rs = allResultSlots.get(i);
				for (int j = 0; j < rs.sourceIndex.length; ++j) {
					slotResults[i].dependent.add(slotResults[rs.sourceIndex[j]]);
				}
				for (int j = 0; j < rs.targetIndex.length; ++j) {
					slotResults[i].notified.add(slotResults[rs.targetIndex[j]]);
				}
			}
			this.resultSlot = (SlotResult<Target>) slotResults[finalResultSlot.index];
			Refreshable thisRefreshes = () -> {
				Target newValue = this.resultSlot.value();
				setValue(newValue);
			};
			this.resultSlot.notified.add(thisRefreshes);
			if (initialize) {
				initCalc();
			}
		}

		private void initCalc() {
			for (SlotResult<?> sr : slotResults) {
				sr.recalc(false);
			}
		}

		@Override
		public Object evaluateNew(Replacer replacer, boolean[] changed) {
			// I assume that if I am in this state, it is already final
			return this;
		}

		@Override
		public Target calcValue() {
			initCalc();
			return resultSlot.value();
		}

	}

	public <Source> DependentResult<Source> getResult(MetaInfo mi, Source source, boolean initialize) {
		return new DependentResult<Source>(mi, source, initialize);
	}
}
