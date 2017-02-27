package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.SimpleEntry;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.TreeposValue;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposValue;

public class IntegerTreePos implements Treepos {
	
	private final int index;
	private final Set<Entry<Integer, TreeposValue>> entrySet;
	private final SimpleTreeposValue stv;
	
	public IntegerTreePos(int index) {
		this.index = index;
		this.stv = new SimpleTreeposValue(TreeposType.PREPEND_NEAR, index);
		this.entrySet = Collections.singleton(new SimpleEntry<>(0, stv));
		
	}


	@Override
	public Set<Entry<Integer, TreeposValue>> getEntries() {
		return entrySet;
	}

	@Override
	public TreeposValue getValueOrNull(Integer i) {
		if (i == index) {
			return stv;
		}
		return null;
	}

	@Override
	public void setValue(Integer i, TreeposValue val) {
		//Don't do anything ...
	}

	private static List<IntegerTreePos> basicList = new ArrayList<>();
	static {
		for (int i = 0; i < 128; ++i) {
			basicList.add(new IntegerTreePos(i));
		}
	}

	public static Treepos forValue(int i) {
		if (i < basicList.size() && i >= 0) {
			return basicList.get(i);
		}
		return new IntegerTreePos(i);
	}


	public int getValue() {
		return index;
	}

}
