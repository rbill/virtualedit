package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DualUnorderedMapImpl<X,Y> implements at.ac.tuwien.big.virtmod.ecore.DualUnorderedMap<X, Y> {
	
	private Map<X,Set<Y>> xToY = new HashMap<>();
	private Map<Y,Set<X>> yToX = new HashMap<>();

	@Override
	public Set<X> getX(Y forY) {
		return yToX.getOrDefault(forY, Collections.emptySet());
	}

	@Override
	public Set<Y> getY(X forX) {
		return xToY.getOrDefault(forX, Collections.emptySet());
	}

	@Override
	public boolean add(X x, Y y) {
		Set<Y> curY = xToY.get(x);
		if (curY == null) {
			xToY.put(x, curY = new HashSet<Y>());
		}
		boolean ret = curY.add(y);
		Set<X> curX = yToX.get(y);
		if (curX == null) {
			yToX.put(y, curX = new HashSet<X>());
		}
		curX.add(x);
		return ret;
	}

	@Override
	public boolean remove(X x, Y y) {
		xToY.getOrDefault(x, Collections.emptySet()).remove(y);
		return yToX.getOrDefault(y, Collections.emptySet()).remove(x);
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		boolean first = true;
		for (Entry<X,Set<Y>> entry: xToY.entrySet()) {
			if (first) {first = false;} else {ret.append(",\n");}
			ret.append(entry.getKey());
			ret.append(": {");
			boolean sndfirst = true;
			for (Y y: entry.getValue()) {
				if (sndfirst) {sndfirst = false;} else {ret.append(", ");}
				ret.append(y);
			}
			ret.append("}");
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		Collections.emptySet().remove(2);
	}
}
