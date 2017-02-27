package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import at.ac.tuwien.big.sat.problem.SatProblem;
import at.ac.tuwien.big.sat.problem.Solver;
import at.ac.tuwien.big.sat.problem.encoding.EditApplicationEncoding;
import at.ac.tuwien.big.sat.problem.encoding.EditApplicationProblem;
import at.ac.tuwien.big.vmodel.general.impl.SimpleEditApplicationList;

public interface EditPerformer<T> {

	
	public Edit<? super T> mainEdit();
		
	public DeltaEditTarget<T> getDeltaEditable();
	
	public int advRecalcState();
	
	/**Successful: Has been applied, everything fine
	 * Retry: Could not apply it now, but maybe later
	 * Fail: Will not be able to apply it, you need that search process
	 *
	 */
	public enum ApplicationState {
		SUCCESSFUL, RETRY, FAIL;
	}
	
	public default EditApplicationProblem calcProblem() {
		int curRecalc = advRecalcState();
		Map<Edit<?>,EditPropagationList> editPropagationMap = new HashMap<>();
		Map<Editable<?>,EditApplicationList<?>> editApplicationList = new HashMap<>();
		Stack<Edit<?>> editStack = new Stack<Edit<?>>();
		editStack.push(mainEdit());
		while (!editStack.isEmpty()) {
			Edit<?> edit = editStack.pop();
			EditApplicationList curApplicationList = editApplicationList.get(edit.getTarget());
			if (curApplicationList == null) {
				editApplicationList.put(edit.getTarget(), curApplicationList = new SimpleEditApplicationList<>());
			}
			curApplicationList.addEdit(edit);
			if (!editPropagationMap.containsKey(edit)) {
				EditPropagationList propList = edit.getContinuation(curRecalc);
				editPropagationMap.put(edit, propList);
				for (EditWish<?,?> nextEdit: propList.getAllEdits()) {
					editStack.push(nextEdit);
				}
			}
		}
		return new EditApplicationProblem(curRecalc,mainEdit(),
				editPropagationMap, editApplicationList, this);
	}
	
	public default boolean isNull() {
		return mainEdit().isNull();
	}
	
	public default ApplicationState tryApply() {		
		EditApplicationProblem prob = calcProblem();
		EditApplicationEncoding encoding = new EditApplicationEncoding(prob);
		Collection<Edit<?>> edits = encoding.solveDefault();
		
		if (edits == null) {
			return ApplicationState.FAIL;
		}
		boolean ret = true;
		for (Edit<?> ed: edits) {
			ret&= ed.precommit(prob.getState());
		}
		if (!ret) {
			return ApplicationState.RETRY;
		}
		for (Edit<?> ed: edits) {
			ed.commit();
			System.out.println("Applied "+ed);
		}
		return ApplicationState.SUCCESSFUL;		
	}
	
	public default ApplicationState tryReApply() {
		ApplicationState ret = tryApply();
		if (ret == ApplicationState.SUCCESSFUL) {
			onApply();
		}
		return ret;
	}
	
	public default void init() {
		getDeltaEditable().applyEdit(mainEdit());
	}
	
	public default void onApply() {
		getDeltaEditable().unapplyEdit(mainEdit());
		System.out.println("Downpropagated "+mainEdit());
		getDeltaEditable().getPendingEdits().remove(this);
		getDeltaEditable().getEditLog().add(mainEdit());
	}
	
	public default void retract() {
		getDeltaEditable().unapplyEdit(mainEdit());
		System.out.println("Retracted "+mainEdit());
		getDeltaEditable().getPendingEdits().remove(this);
	}
}
