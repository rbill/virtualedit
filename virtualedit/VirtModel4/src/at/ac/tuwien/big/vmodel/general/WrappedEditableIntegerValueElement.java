package at.ac.tuwien.big.vmodel.general;

import java.util.Map;
import java.util.WeakHashMap;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.impl.SourcedObject;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class WrappedEditableIntegerValueElement extends SourcedObject implements EditableIntegerValueElement, MergedNotifier {
	
	private EditableIntegerValueElement base;
	private int last = -Integer.MIN_VALUE;
	private Merger<?, ?, ?> merger;
	
	public WrappedEditableIntegerValueElement(VContainer cont, EditableIntegerValueElement base) {
		super(cont);
		this.base = base;
	}
	

	@Override
	public Iterable<VContainer> sourceStores() {
		return base.sourceStores();
	}
	
	public EditableIntegerValueElement base() {
		return base;
	}
	
	public void setMerger(Merger<?,?,?> merger) {
		this.merger = merger;
	}
	
	public Merger<?, ? , ?> merger() {
		return merger;
	}
	
	public static Map<Object,Integer> privateLastValue = new WeakHashMap<>();

	@Override
	public int getValue() {
		int ret = base().getValue();
		if (ret != last) {
			merger().notifyOtherChange();
		}
		return last = base().getValue();
	}

	@Override
	public void add(int value) {
		if (value != 0) {
			int ret = base().getValue();
			int now = ret+value;
			if (ret <= 0 && now > 0) { //TODO: Das Passt nicht, weil im EDIT von 0 auf -1 gewechselt wird ...
				merger().notifyAdd(1);
			} else if (ret > 0 && now <= 0) {
				merger().notifyAdd(-1);
			}
			base().add(value);
			//merger().notifyMyChange();
			last = base().getValue();
			merger().notifyOtherChange();
			last = base().getValue();
		}
	}

	@Override
	public boolean isSelfEmpty() {
		return base.isSelfEmpty();
	}

	@Override
	public boolean selfClear() {
		boolean ret = base.selfClear();
		//merger().notifyAdd(now-r);
		/*
		if (r <= 0 && now > 0) {
			merger().notifyAdd(1);
		} else if (r > 0 && now <= 0) {
			merger().notifyAdd(-1);
		}*/
		merger().notifyMyChange();
		return ret;
	}

}
