package at.ac.tuwien.big.vfunc.nbasic;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.vfunc.basic.Refreshable;

public class DependentResultDesc<Target> {

	private static class CalculatedResultSlot<T> extends ResultSlot<T> {
		private Function<? super Object[], ? extends BasicValuedChangeNotifyer<T>> calculation;
	}

	public class DependentResult<Source> extends BasicResultImpl<Target> {

		private Source source;
		private SlotResult<?>[] slotResults;
		private SlotResult<Target> resultSlot;

		public DependentResult(MetaInfo mi, Source source, boolean initialize) {
			super(mi);
			this.source = source;
			// Add dependencies
			this.slotResults = new SlotResult[DependentResultDesc.this.allResultSlots.size()];
			ConstantValue<Source> sourceValue = new ConstantValue<>(source);
			Function<Object, ConstantValue<Source>> initialSlotFunc = (x) -> sourceValue;
			for (int i = 0; i < DependentResultDesc.this.allResultSlots.size(); ++i) {
				ResultSlot<?> rs = DependentResultDesc.this.allResultSlots.get(i);
				if (rs instanceof FinalCalculatedResultSlot) {
					FinalSlotResult<Source> isr = new FinalSlotResult();
					isr.calculationFunc = ((FinalCalculatedResultSlot) rs).calculation;
				} else {
					IntermediateSlotResult<Source> isr = new IntermediateSlotResult<>();
					this.slotResults[i] = isr;
					if (rs instanceof CalculatedResultSlot) {
						isr.calculationFunc = ((CalculatedResultSlot) rs).calculation;
					} else if (rs instanceof InitialResultSlot) {
						isr.calculationFunc = initialSlotFunc;
					} else {
						throw new UnsupportedOperationException("Some slot result is not yet implemented!: " + rs);
					}
				}
			}
			for (int i = 0; i < DependentResultDesc.this.allResultSlots.size(); ++i) {
				ResultSlot<?> rs = DependentResultDesc.this.allResultSlots.get(i);
				for (int j = 0; j < rs.sourceIndex.length; ++j) {
					this.slotResults[i].dependent.add(this.slotResults[rs.sourceIndex[j]]);
				}
				for (int j = 0; j < rs.targetIndex.length; ++j) {
					this.slotResults[i].notified.add(this.slotResults[rs.targetIndex[j]]);
				}
			}
			this.resultSlot = (SlotResult<Target>) this.slotResults[DependentResultDesc.this.finalResultSlot.index];
			Refreshable thisRefreshes = () -> {
				Target newValue = this.resultSlot.value();
				setValue(newValue);
			};
			this.resultSlot.notified.add(thisRefreshes);
			if (initialize) {
				initCalc();
			}
			Reason reason = getMetaInfo().getReason();
			if (reason instanceof ComposedReason) {
				ComposedReason cr = (ComposedReason)reason;
				Supplier<? extends List<? extends BasicValuedChangeNotifyer<?>>> sourceInfos = ()->{
					List<BasicValuedChangeNotifyer<?>> ret = new ArrayList<>();
					for (SlotResult<?> sr: this.slotResults) {
						if (sr != null) {
							ret.addAll(sr.getSources());
						}
					}
					return ret;
				};
				cr.initSourceInfos(sourceInfos);
			}
		}

		@Override
		public Target calcValue() {
			initCalc();
			return this.resultSlot.value();
		}

		@Override
		public Object evaluateNew(Replacer replacer, boolean[] changed) {
			// I assume that if I am in this state, it is already final
			return this;
		}

		private void initCalc() {
			for (SlotResult<?> sr : this.slotResults) {
				sr.recalc(false);
			}
		}

	}

	private static class FinalCalculatedResultSlot<T> extends ResultSlot<T> {
		private Function<? super Object[], ? extends T> calculation;
	}
	
	private static class FinalSlotResult<Type> extends SlotResult<Type> {
		private Function<? super Object[], ? extends Type> calculationFunc;
		private Type curValue;

		@Override
		public void finalize() throws Throwable {
			super.finalize();
		}

		@Override
		protected void recalc(Object[] newSource, boolean notifyTargets) {
			Type oldValue = this.curValue;
			Type nextValue = this.calculationFunc.apply(newSource);
			this.curValue = nextValue;

			if (!Objects.equals(oldValue, this.curValue)) {
				if (notifyTargets) {
					notifyTargets();
				}
			}
		}

		@Override
		protected Type value() {
			return this.curValue;
		}

	}

	private static class InitialResultSlot<T> extends ResultSlot<T> {

	}

	private static class IntermediateSlotResult<Type> extends SlotResult<Type> {
		private Function<? super Object[], ? extends BasicValuedChangeNotifyer<Type>> calculationFunc;
		private BasicValuedChangeNotifyer<Type> curValue;

		@Override
		public void finalize() throws Throwable {
			super.finalize();
			if (this.curValue != null) {
				this.curValue.removeBasicChangeListener(this.changeListenable);
			}
		}
		
		@Override
		public List<? extends BasicValuedChangeNotifyer<Type>> getSources() {
			return Collections.singletonList(this.curValue);
		}
		

		@Override
		protected void recalc(Object[] newSource, boolean notifyTargets) {
			BasicValuedChangeNotifyer<Type> oldValue = this.curValue;
			BasicValuedChangeNotifyer<Type> nextValue = this.calculationFunc.apply(newSource);
			this.curValue = nextValue;

			if (!Objects.equals(oldValue, this.curValue)) {
				if (oldValue != null) {
					oldValue.removeBasicChangeListener(this.changeListenable);
				}
				if (this.curValue != null) {
					this.curValue.addBasicChangeListener(this.changeListenable);
				}
				if (notifyTargets) {
					notifyTargets();
				}
			}
		}

		@Override
		protected Type value() {
			return this.curValue == null ? null : this.curValue.value();
		}

	}
	

	public static class ResultSlot<T> {

		protected int index;
		protected List<ResultSlot<?>> targets = new ArrayList<>();
		protected int[] targetIndex;
		protected int[] sourceIndex;
		protected List<ResultSlot<?>> sources = new ArrayList<>();

		public void addTarget(ResultSlot<?> target) {
			this.targets.add(target);
		}

	}

	private static abstract class SlotResult<Type> implements Refreshable {

		private List<SlotResult<?>> dependent = new ArrayList<>();
		private List<Refreshable> notified = new ArrayList<>();

		protected BasicListenable changeListenable = new BasicListenable() {

			@Override
			public void changed(BasicChangeNotifyer bcm) {
				SlotResult.this.notified.forEach(x -> x.refresh());
			}
		};
		
		public List<? extends BasicValuedChangeNotifyer<Type>> getSources() {
			return Collections.emptyList();
		}

		protected void notifyTargets() {
			this.notified.forEach(x -> x.refresh());
		}

		public void recalc(boolean notifyTargets) {

			Object[] obj = new Object[this.dependent.size()];
			for (int i = 0; i < obj.length; ++i) {
				obj[i] = this.dependent.get(i).value();
			}
			recalc(obj, notifyTargets);
		}

		protected abstract void recalc(Object[] newSource, boolean notifyTargets);

		@Override
		public void refresh() {
			recalc(true);
		}

		protected abstract Type value();

	}
	public static <T> InitialResultSlot<T> createInputSlot() {
		return new InitialResultSlot<>();
	}

	private List<ResultSlot<?>> allResultSlots = new ArrayList<>();

	private ResultSlot<Target> finalResultSlot;

	private void compile() {
		IdentityHashMap<ResultSlot<?>, Integer> counter = new IdentityHashMap<>();
		this.allResultSlots.forEach(x -> counter.computeIfAbsent(x, y -> counter.size()));
		for (ResultSlot<?> slot : this.allResultSlots) {
			slot.index = counter.get(slot);
		}
		for (ResultSlot<?> slot : this.allResultSlots) {
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

	public <T> FinalCalculatedResultSlot<T> createFinalDesc(List<? extends ResultSlot<?>> dependentSlot,
			Function<? super Object[], ? extends T> calculationFunc) {
		FinalCalculatedResultSlot<T> ret = new FinalCalculatedResultSlot<>();
		ret.calculation = calculationFunc;
		ret.sources.addAll(dependentSlot);
		dependentSlot.forEach(x -> x.addTarget(ret));
		return ret;
	}
	
	public <T> CalculatedResultSlot<T> createIntermediateDesc(List<? extends ResultSlot<?>> dependentSlot,
			Function<? super Object[], ? extends BasicValuedChangeNotifyer<T>> calculationFunc) {
		CalculatedResultSlot<T> ret = new CalculatedResultSlot<>();
		ret.calculation = calculationFunc;
		ret.sources.addAll(dependentSlot);
		dependentSlot.forEach(x -> x.addTarget(ret));
		return ret;
	}

	public void finish(ResultSlot<Target> finalSlot) {
		if (finalSlot == null) {
			finalSlot = (ResultSlot<Target>) this.allResultSlots.get(this.allResultSlots.size() - 1);
		}
		this.finalResultSlot = finalSlot;
		compile();
	}

	public <Source> DependentResult<Source> getResult(MetaInfo mi, Source source, boolean initialize) {
		return new DependentResult<>(mi, source, initialize);
	}
}
