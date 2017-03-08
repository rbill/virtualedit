package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.TreeposState;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaEditableList;

public class SimpleEditableList<T> extends SimpleAbstractFunc<T, Treepos, TreeposList> implements AbstractEditableList<T> {
	


	public boolean containsSpecific(Treepos pos, T value, long editId) {
		TreeposList list = map().get(value);
		TreeposState cont = list.getAtEditOrNull(editId);
		if (cont == null || pos == null) {
			return false;
		}
		return cont.treepos().equalTreeposValue(pos);
	}
	

	public Set<Entry<T, TreeposList>> treeposForValues() {
		return map().entrySet();
	}
	
	@Override
	protected TreeposList createValueList(T forValue) {
		return new SimpleTreeposList();
	}
	
	public static void main(String[] args) {
		SimpleEditableList<String> sel = new SimpleEditableList<String>();
		List<String> myList = sel.asCollection();
		for (int i = 0; i < 5; ++i) {
			myList.add("Bla"+(9-i));
			System.out.println(myList);
		}
		System.out.println(myList);
		SimpleEditableList<String> delta = new SimpleEditableList<String>();
		List<String> deltaList = new SimpleDeltaEditableList<String>(sel, delta, "DeltaEdit").asCollection();
		System.out.println(deltaList);
		deltaList.remove("Bla5");
		System.out.println(deltaList+", delta: "+delta+", base: "+sel);
		deltaList.add("ADD1");
		System.out.println(deltaList+", delta: "+delta+", base: "+sel);
		deltaList.add(0,"ADD2");
		System.out.println(deltaList+", delta: "+delta+", base: "+sel);
		deltaList.remove("ADD1");
		System.out.println(deltaList+", delta: "+delta+", base: "+sel);
		myList.remove("Bla8");
		System.out.println(deltaList+", delta: "+delta+", base: "+sel);
		myList.add(2,"ADD3");
		System.out.println(deltaList+", delta: "+delta+", base: "+sel);
	}


	@Override
	public TreeposList getIndices(T forValue) {
		return super.getValues(forValue);
	}



}
