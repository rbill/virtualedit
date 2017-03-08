package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.TreeposValue;

public class SimpleTreepos implements Treepos {
	private List<TreeposValue> values = new ArrayList<TreeposValue>();
	

	public SimpleTreepos(int... values) {
		for (int i = 0; i < values.length; ++i) {
			this.values.add(new SimpleTreeposValue(values[i]));
		}
	}
	
	public boolean equals(Object o) {
		return (o instanceof Treepos) && compareTo((Treepos)o) == 0;
	}
	
	public int hashCode() {
		int ret = 0;
		for (TreeposValue val: values) {
			ret*= 177;
			ret+= val.value();
		}
		return ret;
	}

	public String toString() {
		return Arrays.toString(values.toArray());
	}

	
	public void set(int level, TreeposValue value) {
		if (values.size() <= level) {
			while (values.size() < level) {
				values.add(new SimpleTreeposValue(0));
			}
			values.add(value);	
		} else {
			values.set(level, value);	
		}
			
	}
	

	@Override
	public int getLevelSize() {
		return values.size();
	}

	@Override
	public TreeposValue getLevelValue(int level) {
		return values.get(level);
	}

	@Override
	public Treepos subPos(int subPos) {
		int[] ar = new int[values.size()+1];
		for (int i = 0; i < values.size(); ++i) {
			ar[i] = values.get(i).value();
		}
		ar[ar.length-1] = subPos;
		return new SimpleTreepos(ar);
	}

}
