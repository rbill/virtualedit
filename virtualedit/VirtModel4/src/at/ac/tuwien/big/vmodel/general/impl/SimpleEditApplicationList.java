package at.ac.tuwien.big.vmodel.general.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import at.ac.tuwien.big.vmodel.general.Edit;
import at.ac.tuwien.big.vmodel.general.EditApplicationList;

public class SimpleEditApplicationList<T> implements EditApplicationList<T> {
	
	private List<Edit<T>> baseEdits = new ArrayList<Edit<T>>();
	private Map<Edit<T>, Edit<T>> mapToBase = new WeakHashMap<Edit<T>, Edit<T>>();
	private Map<Edit<T>, Collection<Edit<T>>> conflictSet = new WeakHashMap<Edit<T>, Collection<Edit<T>>>();
	private Set<Edit<T>> knownEdits = new HashSet<>();

	@Override
	public List<Edit<T>> getAllBaseEdits() {
		return baseEdits;
	}

	@Override
	public Map<Edit<T>, Collection<Edit<T>>> getConflictSet() {
		return conflictSet;
	}

	@Override
	public Edit<T> getBaseOrNull(Edit<T> from) {
		return mapToBase.get(from);
	}

	@Override
	public synchronized void addEdit(Edit<T> edit) {
		if (!knownEdits.add(edit)) {
			return;
		}
		//Check if you should map it
		for (Edit<T> ledit: baseEdits) {
			if (ledit.localEquals(edit)) {
				mapToBase.put(edit, ledit);
				return;
			}
		}
		//Check conflicts
		List<Edit<T>> conflicts = new ArrayList<Edit<T>>();
		for (Edit<T> bedit: baseEdits) {
			if (bedit.conflictsWith(edit) || edit.conflictsWith(bedit)) {
				conflicts.add(bedit);
				Collection<Edit<T>> curConflicts = conflictSet.get(bedit);
				curConflicts.add(edit);
			}
		}
		conflictSet.put(edit, conflicts);
		baseEdits.add(edit);
	}

}
