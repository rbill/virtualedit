package at.ac.tuwien.big.sat.problem.encoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.sat.problem.SatProblem;
import at.ac.tuwien.big.sat.problem.SatSolution;
import at.ac.tuwien.big.sat.problem.Solver;
import at.ac.tuwien.big.sat.problem.impl.SimpleSatProblem;
import at.ac.tuwien.big.vmodel.general.Edit;
import at.ac.tuwien.big.vmodel.general.EditApplicationList;
import at.ac.tuwien.big.vmodel.general.EditPropagationList;
import at.ac.tuwien.big.vmodel.general.Editable;

public class EditApplicationEncoding implements SatEncoding<Collection<Edit<?>>> {
	

	private Map<Edit<?>,EditPropagationList<?>> editPropagationMap = new HashMap<>();
	private Map<Editable<?>,EditApplicationList<?>> editApplicationList = new HashMap<>();
	private List<Edit<?>> editList = new ArrayList<>();
	private Map<Edit<?>,Integer> editId = new HashMap<Edit<?>, Integer>();
	private SatProblem problem;
	private Edit<?> mainEdit;
	
	private int getVar(Edit<?> edit) {
		EditApplicationList list = editApplicationList.get(edit.getTarget());
		return editId.get(edit.getMappedEdit(list))+1;
	}
	
	private int getDirectVar(Edit<?> edit) {
		return getVar(edit)+editList.size();
	}
	
	public EditApplicationEncoding(EditApplicationProblem problem) {
		this.editPropagationMap = problem.editPropagationMap();
		this.editApplicationList = problem.editApplicationList();
		
		editList = new ArrayList<Edit<?>>(editPropagationMap.keySet());
		this.mainEdit = problem.mainEdit();
		{
			int index = 0;
			for (Edit<?> edit: editList) {
				editId.put(edit, index);
				++index;
			}
		}
		Map<Edit<?>,Integer> propagationVars = new HashMap<Edit<?>, Integer>();
		Map<Edit<?>,List<Edit<?>>> targetMappings = new HashMap<Edit<?>, List<Edit<?>>>();
		List<int[]> constraints = new ArrayList<int[]>();
		int curVar = editList.size()*2+1; //Variables always start with 1!
		//First: Should edit be applied
		//Second: Should edit be directly applied
		for (Edit<?> edit: editList) {
			//If edit cannot be directly applied, set the variable
			if (!edit.mayDirectApply()) {
				constraints.add(new int[]{-getDirectVar(edit)});
			}
			

			//Edit propagation
			EditPropagationList<?> el = editPropagationMap.get(edit);
			List<? extends Edit<?>> allEdits = el.getAllEdits();
			int startvar = curVar;
			//If this edit is chosen to be applied AND it is not directly applied, THEN one of the propagations must be true
			int[] ar = new int[el.getPossiblePropagations().size()+2];
			ar[0] = -getVar(edit);
			ar[1] = getDirectVar(edit);
			{ 
				int subInd = 2;
				for (List<? extends Edit<?>> pp: el.getPossiblePropagations()) {
					ar[subInd] = curVar;
					++curVar;
					++subInd;
				}
				
				//Assign variables to each propagation-edit
				for (Edit<?> ed: el.getAllEdits()) {
					propagationVars.put(ed, curVar++);
					Edit<?> target = ((Edit)ed).getMappedEdit(editApplicationList.get(ed.getTarget()));
					List<Edit<?>> cur = targetMappings.get(target);
					if (cur == null) {
						targetMappings.put(target, cur = new ArrayList<Edit<?>>());
					}
					cur.add(ed);
				}
			}
			constraints.add(ar);
			
			{
				int baseVar = startvar;
				//If a possible propagation is chosen, then exactly those propagations have to be chosen which are selected
				//But here the variables without mapping are meant!
				for (List<? extends Edit<?>> pp: el.getPossiblePropagations()) {
					int[] literalAr = new int[2];
					//If the specific edit is chosen
					literalAr[0] = -baseVar;
					//Look through all of the base and check whether it is selected or not
					{
						for (Edit<?> ed: allEdits) {
							boolean selected = pp.contains(ed);
							int idx = propagationVars.get(ed);
							//If the specific edit is chosen, take the propagation iff it is selected
							if (selected) {
								literalAr[1] = idx;
							} else {
								literalAr[1] = -idx; 
							}
							constraints.add(Arrays.copyOf(literalAr, literalAr.length));
						}
					}
				}
				
			}			
			
		}
		
		//If any propagation edit is chosen, the target edit must be applied
		for (Entry<Edit<?>, List<Edit<?>>> entr: targetMappings.entrySet()) {
			Edit<?> realEdit = entr.getKey();
			for (Edit<?> propagationTarget: entr.getValue()) {
				constraints.add(new int[]{getVar(realEdit), -propagationVars.get(propagationTarget)});
			}
		}
		
		//Conflicting variables may not be chosen
		for (Entry<Editable<?>, EditApplicationList<?>> entr: editApplicationList.entrySet()) {
			EditApplicationList<?> el = entr.getValue();
			for (Entry<? extends Edit<?>, ? extends Collection<? extends Edit<?>>> conflictSet: el.getConflictSet().entrySet()) {
				Edit<?> base = conflictSet.getKey();
				for (Edit<?> conflicting: conflictSet.getValue()) {
					//Not both of them
					constraints.add(new int[]{-getVar(base),-getVar(conflicting)});
				}
			}
		}
		
		//In total you should now get a set of directly applied constraints, at least I hope that ...
		SimpleSatProblem prob = new SimpleSatProblem();
		this.problem = prob;
		for (int[] ar: constraints) {
			prob.addConstraint(ar);
		}
	}
	
	public SatProblem getProblem() {
		return problem;
	}
	
	public Collection<Edit<?>> getSolution(SatSolution solution) {
		//Take exactly those which are marked as directly applied
		List<Edit<?>> ret = new ArrayList<Edit<?>>();
		for (int i = editList.size()+1,j = 0;j < editList.size(); ++j) {
			if (solution.isTrue(i)) {
				ret.add(editList.get(j));
			}
		}
		return ret;
	}

}
