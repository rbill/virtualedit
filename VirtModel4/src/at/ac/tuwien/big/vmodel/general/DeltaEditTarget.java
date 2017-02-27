package at.ac.tuwien.big.vmodel.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import at.ac.tuwien.big.vmodel.general.EditPerformer.ApplicationState;
import at.ac.tuwien.big.vmodel.general.impl.SimpleEditPerformer;

public interface DeltaEditTarget<T> extends Editable<T> {
	
	/**Edit application. should NOT change the list of pending edits!*/
	public default void applyEdit(Edit<? super T> edit) {
		recalcDelta();
	}
	
	/**Edit application. should NOT change the list of pending edits!*/
	public default void unapplyEdit(Edit<? super T> edit) {
		recalcDelta();
	}
	
	/**Edit modification. should NOT change the list of pending edits!*/
	public default void modifyEdit(Edit<? super T> edit) {
		recalcDelta();
	}
	
	/**This should be called if the pending edit collection has been called externally*/
	public void recalcDelta();
	
	/**May chose to use a completely different edit to perform the requested edit
	 * and automatically retract any number of edits
	 * 
	 * May return null if nothing was added
	 */
	public default EditPerformer<? super T> addEdit(Edit<? super T> edit) {
		//Look for conflicting edits and retract them
		//Problem: Es könnte ja welche geben, die nur teilweise konfliktär sind ...
		List<EditPerformer<? super T>> pendingEdits = getPendingEdits();
		ListIterator<EditPerformer<? super T>> performer = pendingEdits.listIterator(pendingEdits.size());
		boolean hasConflicting = false;
		List<EditPerformer<?>> modified = new ArrayList<>();
		List<EditPerformer<?>> retracted = new ArrayList<>();
		while (performer.hasPrevious()) {
			EditPerformer<? super T> perf = performer.previous();
			Edit<?> perfEdit = perf.mainEdit();
			if (edit.mayMerge(perfEdit)) {
				Edit<? super T>[] newEdits = edit.merge(perfEdit);
				//TODO: Unterscheiden: geändert oder "intern" geändert?
				if (newEdits[0] == null || newEdits[0].isNull()) {
					//Hopefully this works well with unapply ... if it redoes everything and modifies the list
					performer.remove();
					retracted.add(perf);
				} else if (newEdits[0] != perf.mainEdit()) {
					performer.set(createPerformer(newEdits[0]));
					retracted.add(perf);
				} else {
					modified.add(perf);
				}
				if (newEdits[1] == null || newEdits[1].isNull()) {
					return null;
				}
				perfEdit = newEdits[0];
				edit = newEdits[1];
			}
			if (!hasConflicting) {
				hasConflicting |= (edit != null && perfEdit != null && edit.conflictsWith(perfEdit));
			}
		}
		if (edit == null || edit.isNull()) {
			return null;
		}
		if (!modified.isEmpty() || !retracted.isEmpty()) {
			recalcDelta();
		}
		EditPerformer<? super T> ret = createPerformer(edit);
		ApplicationState state = ret.tryApply();
		if (state == ApplicationState.SUCCESSFUL) {
			//You don't need to apply it
			getEditLog().add(edit);
		} else {
			ret.init();
			pendingEdits.add(ret);
		}
		return ret;
	}
	
	public default EditPerformer<? super T> createPerformer(Edit<? super T> forEdit) {
		return new SimpleEditPerformer<T>(forEdit, this);
	}
	
	/**Must be modifiable by the EditPerformer, but should not be edited else*/
	public List<EditPerformer<? super T>> getPendingEdits();
	
	/**Must be modifiable by the EditPerformer, but should not be edited else.
	 * May be cleared at any time*/
	public List<Edit<? super T>> getEditLog();
	
	public default void clearLog() {
		getEditLog().clear();
	}

}
