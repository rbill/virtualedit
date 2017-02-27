package at.ac.tuwien.big.virtmod.basic.wrapper.impl;

import java.util.Arrays;
import java.util.Iterator;

public class Test {

	
	public static void main(String[] args) {
		Integer lastInt = null;
		Integer prevInt = null;
		Iterator<? extends Integer> iter = Arrays.asList(1,3).iterator();
		String ret = "";
		while (iter.hasNext()) {
			if (lastInt != null) {
				ret = "";
			}
			prevInt = lastInt;
			lastInt = iter.next();
		}
		if (prevInt != null) {
			for (; prevInt < lastInt-1; ++prevInt) {
				System.out.println("Bla");
			}	
		}
	}
}
