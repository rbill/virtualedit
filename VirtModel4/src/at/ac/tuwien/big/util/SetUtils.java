package at.ac.tuwien.big.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.nbasic.ecore.AbstractVMEObject;
import at.ac.tuwien.big.virtmod.basic.Treepos;

public class SetUtils {

	public static<T> List<List<T>> getAllLists(List<List<T>> admissiblePerParameters) {
		
		int[] max = new int[admissiblePerParameters.size()];
		for (int i = 0; i < admissiblePerParameters.size(); ++i) {
			max[i] = admissiblePerParameters.get(i).size();
			if (max[i] == 0) {
				return new ArrayList<>();
			}
		}
		List<List<T>> ret = new ArrayList<>();
		if (admissiblePerParameters.isEmpty()) {
			ret.add(new ArrayList<>());
			return ret;
		}
		int[] cur = new int[max.length];
		while (cur[0] < max[0]) {
			List<T> addRet = new ArrayList<>();
			for (int i = 0; i < cur.length; ++i) {
				addRet.add(admissiblePerParameters.get(i).get(cur[i]));
			}
			ret.add(addRet);
			++cur[cur.length-1];
			for (int j = cur.length-1; j >= 1; --j) {
				if (cur[j] >= max[j]) {
					cur[j] = 0;
					++cur[j-1];
				} else {
					break;
				}
			}
		}
		return ret;
	}
	
	
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
	
	public static<T> TreeIterator<T> getTreeIterator(T root, Function<T,? extends Iterable<T>> continuation) {

		return new TreeIterator<T>() {

			
			private Set<T> knownSet = new HashSet<>();
			private boolean popped = false;
			private ArrayDeque<T> curStack = new ArrayDeque<>();
			{
				this.curStack.add(root);
			}
			private ArrayDeque<Iterator<? extends T>> curIterStack = new ArrayDeque<>();
			{
				this.curIterStack.add(Collections.singleton(root).iterator());
			}
			
			
			@Override
			public boolean hasNext() {
				//TODO: Stimmt sicher nicht
				while (!this.curIterStack.isEmpty() && !this.curIterStack.peek().hasNext()) {
					this.popped = true;
					this.curIterStack.pop();
				}
				return !this.curIterStack.isEmpty() && this.curIterStack.peek().hasNext();
			}

			@Override
			public T next() {
				if (!hasNext()) {
					return null;
				}
				T next = this.curIterStack.peek().next();
				Iterable<? extends T> iterable = continuation.apply(next);
				this.popped = false;
				this.curIterStack.push(iterable.iterator());
				return next;
			}

			@Override
			public void prune() {
				if (!this.popped) {
					this.popped = true;
					this.curIterStack.pop();
				} 
			}
		};
	}


	public static void main(String[] args) {
		
		List<List<String>> admissiblePerParameters = new ArrayList<>();
		admissiblePerParameters.add(Arrays.asList("1","2","3"));
		admissiblePerParameters.add(Arrays.asList("a","b"));
		admissiblePerParameters.add(Arrays.asList(")","]",">"));
		List<List<String>> strList = getAllLists(admissiblePerParameters)
				;
		strList.forEach(x->System.out.println(x));
		
	}


	public static<T> void addIfIterable(Set<T> everything, Object scope) {
		if (scope instanceof Collection) {
			everything.addAll((Collection)scope);
		} else if (scope instanceof Iterable) {
			for (Object o: (Iterable)scope) {
				everything.add((T)o);
			}
		}
	}
}
