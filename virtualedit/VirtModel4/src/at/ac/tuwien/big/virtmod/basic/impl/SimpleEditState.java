package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.List;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.impl.delta.SimpleDeltaEditableList;

public class SimpleEditState implements Editstate {
	
	private long editId;

	@Override
	public long peekEditId() {
		return editId;
	}

	@Override
	public synchronized long advEditId() {
		return editId++;
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


}
