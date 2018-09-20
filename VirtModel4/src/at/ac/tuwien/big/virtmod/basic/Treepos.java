package at.ac.tuwien.big.virtmod.basic;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposValue;
import at.ac.tuwien.big.virtmod.basic.impl.UnspecifiedTreeposValue;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public interface Treepos extends Comparable<Treepos>, Serializable {
	

	
	public static Treepos augmentIndex(Treepos pos, int myIndex) {
		if (pos.getLevelSize() == 0 || Math.abs(pos.getLevelValue(pos.getLevelSize()-1).value()) != myIndex) {
			return pos.simpleAugment(myIndex);
		}
		return pos;
	}
	
	public static Treepos FOR_PREFIX(int ind) {
		return new SimpleTreepos(ind,0);
	}
	
	public static Treepos ROOT() {
		return new SimpleTreepos();
	}
	
	public default Treepos after() {
		return modified(1);
	}
	
	public default Treepos before() {
		return modified(-1);
	}
	
	@Override
	public default int compareTo(Treepos other) {
		int bothLevel = Math.min(getLevelSize(), other.getLevelSize());
		for (int i = 0; i < bothLevel; ++i) {
			TreeposValue first = getLevelValue(i);
			TreeposValue second = other.getLevelValue(i);
			int ret = first.compareTo(second);
			if (ret != 0) {
				return ret;
			}
		}
		for (int i = bothLevel; i < getLevelSize(); ++i) {
			int ret = getLevelValue(i).value();
			if (ret != 0) {
				return ret;
			}
		}
		for (int i = bothLevel; i < other.getLevelSize(); ++i) {
			int ret = other.getLevelValue(i).value();
			if (ret != 0) {
				return -ret;
			}
		}
		return 0;
	}
	
	public default boolean equalTreepos(Treepos other) {
		return compareTo(other)==0;
	}
	
	public default boolean equalTreeposMap(Treepos other) {
		return compareTo(other)==0;
	}
	
	public default boolean equalTreeposValue(Treepos other) {
		return compareTo(other)==0;
	}
	 
	public int getLevelSize();
	
	public TreeposValue getLevelValue(int level);
	
	public default Treepos middle(Treepos neighbor, int myIndex) {		
		int possiblyEqual = Math.min(getLevelSize(), neighbor.getLevelSize());
		for (int i = 0; i < possiblyEqual; ++i) {
			TreeposValue mySub = getLevelValue(i);
			TreeposValue neighborSub = neighbor.getLevelValue(i);
			int cmp = mySub.compareTo(neighborSub);
			if (cmp != 0) {
				//Difference
				//Check if neighbors
				TreeposValue middle = mySub.simpleMiddle(neighborSub);
				SimpleTreepos ret = new SimpleTreepos();
				for (int j = 0; j < i; ++j) {
					ret.set(j, getLevelValue(j));
				}
				if (middle != null) {					
					ret.set(i, middle);
					return ret.simpleAugment(myIndex);
				} else {
					//They are neighbors, add a level
					ret.set(i, mySub);
					if (cmp < 0) { //Ist kleiner, mache größer
						ret.set(i+1, new SimpleTreeposValue(myIndex));
					} else { //cmp > 0 // Ist größer, mache kleiner
						ret.set(i+1, new SimpleTreeposValue(-myIndex));
					}
					return ret;
				}
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public default Treepos modified(int value) {
		if (getLevelSize() == 0) {
			SimpleTreepos ret = new SimpleTreepos();
			ret.set(0, new SimpleTreeposValue(value));
			return ret;
		} else {
			SimpleTreepos ret = new SimpleTreepos();
			for (int i = 0; i < getLevelSize()-1; ++i) {
				ret.set(i, getLevelValue(i));
			}
			TreeposValue last = getLevelValue(getLevelSize()-1);
			ret.set(getLevelSize()-1, new SimpleTreeposValue(last.value()+value));
			return ret;
		}
	}
	
	public default Treepos simpleAugment(int myIndex) {
		SimpleTreepos ret = new SimpleTreepos();
		for (int i = 0; i  < getLevelSize(); ++i) {
			ret.set(i, getLevelValue(i));
		}
		ret.set(getLevelSize(), new SimpleTreeposValue(myIndex));
		return ret;
	}
	
	public Treepos subPos(int subPos);
	
	public default Treepos superAfter(int myIndex) {
		return augmentIndex(topmost(1),myIndex);
	}
	
	public default Treepos superBefore(int myIndex) {
		return augmentIndex(topmost(-1),myIndex);
	}

	public default SimpleTreepos topmost(int value) {
		if (getLevelSize() == 0) {
			SimpleTreepos ret = new SimpleTreepos();
			ret.set(0, new SimpleTreeposValue(value));
			return ret;
		} else {
			TreeposValue last = getLevelValue(0);
			SimpleTreepos ret = new SimpleTreepos();
			ret.set(0, new SimpleTreeposValue(last.value()+value));
			return ret;
		}
	}
}
