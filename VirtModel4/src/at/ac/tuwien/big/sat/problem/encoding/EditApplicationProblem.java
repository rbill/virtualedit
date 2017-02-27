package at.ac.tuwien.big.sat.problem.encoding;

import java.util.Map;

import at.ac.tuwien.big.vmodel.general.Edit;
import at.ac.tuwien.big.vmodel.general.EditApplicationList;
import at.ac.tuwien.big.vmodel.general.EditPerformer;
import at.ac.tuwien.big.vmodel.general.EditPropagationList;
import at.ac.tuwien.big.vmodel.general.Editable;

public class EditApplicationProblem {

	private Edit<?> mainEdit;
	private Map<Edit<?>,EditPropagationList<?>> editPropagationMap;
	private Map<Editable<?>,EditApplicationList<?>> editApplicationList;
	private EditPerformer<?> performer;
	private int state;
	
	public EditApplicationProblem(int state, Edit<?> mainEdit, Map<Edit<?>, EditPropagationList<?>> editPropagationMap, Map<Editable<?>,EditApplicationList<?>> editApplicationList,
			EditPerformer<?> performer) {
		this.mainEdit = mainEdit;
		this.editApplicationList = editApplicationList;
		this.editPropagationMap = editPropagationMap;
		this.performer = performer;
	}
	
	public EditPerformer<?> editPerformer() {
		return performer;
	}
	
	public Edit<?> mainEdit() {
		return mainEdit;
	}
	
	
	public Map<Edit<?>, EditPropagationList<?>> editPropagationMap() {
		return editPropagationMap;
	}
	
	public Map<Editable<?>, EditApplicationList<?>> editApplicationList() {
		return editApplicationList;
	}

	public int getState() {
		return state;
	}
}
