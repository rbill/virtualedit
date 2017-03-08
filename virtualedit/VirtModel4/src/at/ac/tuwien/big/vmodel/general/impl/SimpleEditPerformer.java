package at.ac.tuwien.big.vmodel.general.impl;

import at.ac.tuwien.big.vmodel.general.DeltaEditTarget;
import at.ac.tuwien.big.vmodel.general.Edit;
import at.ac.tuwien.big.vmodel.general.EditPerformer;

public class SimpleEditPerformer<T> implements EditPerformer<T> {
	
	private Edit<? super T> mainEdit;
	private DeltaEditTarget<T> deltaEditable;
	private int recalcState;
	
	public SimpleEditPerformer(Edit<? super T> mainEdit, DeltaEditTarget<T> deltaEditable) {
		this.mainEdit = mainEdit;
		this.deltaEditable = deltaEditable;
	}

	@Override
	public Edit<? super T> mainEdit() {
		return mainEdit;
	}

	@Override
	public DeltaEditTarget<T> getDeltaEditable() {
		return deltaEditable;
	}

	@Override
	public int advRecalcState() {
		return ++recalcState;
	}

}
