package at.ac.tuwien.big.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

public class SetUtils {

	public static<T> List<T> getRecursivelyL(Collection<T> start, Function<T,? extends Iterable<T>> continuation) {
		List<T> ret = new ArrayList<>();
		Set<T> retSet = new HashSet<>();
		Stack<T> stack = new Stack<>();
		stack.addAll(start);
		ret.addAll(start);
		retSet.addAll(start);
		while (!stack.isEmpty()) {
			Iterable<T> col = continuation.apply(stack.pop());
			for (T next: col) {
				if (retSet.add(next)) {
					ret.add(next);
					stack.add(next);
				}
			}
		}
		return ret;
	}
	
	
	public static<T> Set<T> getRecursivelyS(Collection<T> start, Function<T,? extends Iterable<T>> continuation) {
		Set<T> retSet = new HashSet<>();
		Stack<T> stack = new Stack<>();
		stack.addAll(start);
		retSet.addAll(start);
		while (!stack.isEmpty()) {
			Iterable<T> col = continuation.apply(stack.pop());
			for (T next: col) {
				if (retSet.add(next)) {
					stack.add(next);
				}
			}
		}
		return retSet;
	}
}
