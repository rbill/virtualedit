package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.Merger;
import at.ac.tuwien.big.vmodel.general.VBag;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.WrapEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.WrapFunc;
import at.ac.tuwien.big.vmodel.general.WrappedEditableIntegerValueElement;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public class EditableIntegerMerger<T> implements Merger<T, EditableIntegerValueElement, EditableIntegerValueElement>{

	private EditableIntegerValueElement target;
	private VEntryIterableFunc<T, ? extends EditableIntegerValueElement> baseFunc;
	private VEntryIterableFunc<T, ? extends EditableIntegerValueElement> editFunc;
	private Creater<T,? super VEntryIterableFunc<T, ? extends EditableIntegerValueElement>> creater;
	
	public EditableIntegerMerger(EditableIntegerValueElement target, VEditableBag<T, ? extends EditableIntegerValueElement> baseFunc,
			VEditableBag<T, ? extends EditableIntegerValueElement> editFunc,
			Creater<T,? super VEntryIterableFunc<T, ? extends EditableIntegerValueElement>> creater) {
		this.target = target;
		this.baseFunc = baseFunc;
		this.editFunc = editFunc;
		this.creater = creater;
	}

	private int getCurValue() {
		int curValue = 0;
		for (EditableIntegerValueElement val: baseFunc.getValues()) {
			curValue+= val.getValue();
		}
		return curValue;
	}
	
	@Override
	public void notifyAdd(int value) {
		
		target.add(value);
		int thenVal = target.getValue();
		System.out.println("[EDINT]: Set target to then "+thenVal);
	}
	
	@Override
	public void notifyMyChange() {
		
		//Ich habe mich geändert, passe einfach das andere an
		//Summiere ...
		int curValue = getCurValue();
		//Wenn ich etwas hinzufüge, bin ich hier bei 1 von 0, obwohl es eigentlich etwas gibt, was gar nicht vorhanden sein sollte ...
		System.out.println("[EDINT]: Set Target to "+curValue);
		target.set(curValue);
	}
	
	private boolean recall = false;

	@Override
	public synchronized void notifyOtherChange() {
		if (recall) {return;}
		recall = true;
		try {
			int otherValue = target.getValue();
			int curValue = getCurValue();
			VEntryIterableFunc<T, ? extends EditableIntegerValueElement> myEditFunc = editFunc;
			VEditableBag<T, ? extends EditableIntegerValueElement> bag = VEditableBag.ensureBag(editFunc);
			if (curValue > 0 && otherValue <= 0) {
				bag.clear();
			} else if (curValue <= 0 && otherValue > 0) {
				//Add - first reuse
				//I can have an arbirarily large number
				int toAdd = 1;
				for (Entry<? extends T, ? extends EditableIntegerValueElement> entr: myEditFunc.getEntries()) {
					EditableIntegerValueElement ev = entr.getValue();
					if (ev instanceof WrappedEditableIntegerValueElement) {
						ev = ((WrappedEditableIntegerValueElement) ev).base();
					}
					if (ev.getValue() <= 0) {
						ev.set(1);
						if (--toAdd <= 0) {
							return;
						}
					}
				}
				//Then add additional
				while(toAdd-- > 0) {
					T toInsert = creater.create(editFunc);
					editFunc.get(toInsert).setMin(1);
				}
			}
		} finally {
			recall = false;
		}
	}

	@Override
	public EditableIntegerValueElement getOther() {
		return target;
	}

	@Override
	public void setBaseFunc(VEntryIterableFunc<T, EditableIntegerValueElement> base, VEntryIterableFunc<T, ? extends EditableIntegerValueElement> editFunc) {
		this.baseFunc = base;
		this.editFunc = editFunc;
	}

	@Override
	public void setTarget(EditableIntegerValueElement target) {
		this.target = target;
	}

}
