package at.ac.tuwien.big.verocl.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import at.ac.tuwien.big.verocl.SingleParameterDesc;

public class SingleParameterDescImpl<T extends Comparable<T>> implements SingleParameterDesc<T> {
	
	private List<T[]> valueRanges = new ArrayList<>();
	
	public T maxEnd(T first, T second) {
		if (first == null || second == null) {
			return null;
		}
		return first.compareTo(second)<0?second:first;
	}
	
	public T minEnd(T first, T second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		return first.compareTo(second)<0?first:second;
	}
	
	public T minStart(T first, T second) {
		if (first == null || second == null) {
			return null;
		}
		return first.compareTo(second)<0?first:second;
	}
	
	public T maxStart(T first, T second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		return first.compareTo(second)<0?second:first;
	}
	
	public SingleParameterDescImpl(List<T[]> vals) {
		this.valueRanges = vals;
	}
	
	public SingleParameterDescImpl(T[] ... vals) {
		valueRanges = Arrays.asList(vals);
	}
	
	private static<T extends Comparable<T>> boolean smallerEqMin(T first, T second) {
		if (first == null) {
			return true;
		} else {
			if (second == null) {
				return false;
			}
			return first.compareTo(second)<=0;
		}
	}
	
	
	
	private static<T extends Comparable<T>> boolean smallerEqMinMax(T first, T second) {
		if (first == null || second == null) {
			return true;
		} else {
			return first.compareTo(second)<=0;
		}
	}
	
	private static<T extends Comparable<T>> boolean smallerMinMax(T first, T second) {
		if (first == null || second == null) {
			return true;
		} else {
			return first.compareTo(second)<0;
		}
	}
	
	private static<T extends Comparable<T>> boolean smallerEqMax(T first, T second) {
		if (first == null) {
			return second == null;
		} else {
			if (second == null) {
				return true;
			}
			return first.compareTo(second)<=0;
		}
	}
	
	public enum MergeState {
		CONTINUE_FIRST, CONTINUE_SECOND, CONTINUE_BOTH;
	}
	
	public boolean smallerStart(T[] first, T[] second) {
		return smallerEqMin(first[0], second[0]);
	}
	
	@Override
	public SingleParameterDesc<T> union(SingleParameterDesc<T> other) {
		if (other instanceof SingleParameterDescImpl) {
			SingleParameterDescImpl<T> otherS = (SingleParameterDescImpl<T>)other;
			List<T[]> myRanges = valueRanges;
			List<T[]> otherRanges = otherS.valueRanges;
			
			List<T[]> ret = new ArrayList<>();
			if (myRanges.isEmpty()) {
				return otherS;
			} else if (otherRanges.isEmpty()) {
				return this;
			}
			//Both are non-empty
			int curI = 0;
			int curJ = 0;
			T[] curFirst = myRanges.get(curI);
			T[] curSecond = otherRanges.get(curJ);
			for(;;) {
				T[] curAdd;
				if (smallerStart(curFirst, curSecond)) {
					curAdd = Arrays.copyOf(curFirst, curFirst.length);
					++curI;
				} else {
					curAdd = Arrays.copyOf(curSecond, curSecond.length);
					++curJ;
				}
				boolean done;
				do {
					done = false;
					//Merge into
					for (; curI < myRanges.size(); ++curI) {
						T[] cur = myRanges.get(curI);
						if (smallerEqMinMax(cur[0], curAdd[1])) {
							done = true;
							curAdd[1] = maxEnd(cur[1], curAdd[1]);
						} else {
							curFirst = cur;
							break;
						}
					}
					for (; curJ < otherRanges.size(); ++curJ) {
						T[] cur = otherRanges.get(curJ);
						if (smallerEqMax(cur[0], curAdd[1])) {
							done = true;
							curAdd[1] = maxEnd(cur[1], curAdd[1]);
						} else {
							curSecond = cur;
							break;
						}
					}
				} while (done);
				ret.add(curAdd);
				if (curI >= myRanges.size() || curJ >= otherRanges.size()) {
					for (; curJ < otherRanges.size(); ++curJ) {
						ret.add(Arrays.copyOf(otherRanges.get(curJ),2));
					}
					for (; curI < myRanges.size(); ++curI) {
						ret.add(Arrays.copyOf(myRanges.get(curI),2));
					}
					return new SingleParameterDescImpl<T>(ret);
				}
				curFirst = myRanges.get(curI);
				curSecond = otherRanges.get(curJ);
			}
			
			
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public SingleParameterDesc<T> intersection(SingleParameterDesc<T> other) {
		if (other instanceof SingleParameterDescImpl) {
			SingleParameterDescImpl<T> otherS = (SingleParameterDescImpl<T>)other;
			
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public SingleParameterDesc<T> without(SingleParameterDesc<T> other) {
		if (other instanceof SingleParameterDescImpl) {
			SingleParameterDescImpl<T> otherS = (SingleParameterDescImpl<T>)other;
			
		}
		throw new UnsupportedOperationException();
	}
	
	public void shorten() {
		T[] last = null;
		Iterator<T[]> iter = valueRanges.iterator();
		if (iter.hasNext()) {
			last = iter.next();
			while (iter.hasNext()) {
				T[] next = iter.next();
				if ((last[1] == null)?(next[0] == null):(next[0] != null && last[1].compareTo(next[0]) >= 0)) {
					last[1] = next[1];
					iter.remove();
				} else {
					last = next;
				}
			}
		}
		
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		boolean first = true;
		for (T[] vals: valueRanges) {
			if (first) {first = false;} else {ret.append(", ");}
			if (vals[0] == null) {
				ret.append("No Start");
			} else {
				ret.append(vals[0]);
			}
			ret.append(" to ");
			if (vals[1] == null) {
				ret.append("No End");
			} else {
				ret.append(vals[1]);
			}
		}
		return ret.toString();
	}

	@Override
	public boolean isEmpty() {
		return !valueRanges.isEmpty();
	}

	@Override
	public boolean equals(SingleParameterDesc<T> other) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int overrideHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		SingleParameterDescImpl<Integer> test1 = SingleParameterDescImpl.fromUpDown(1,5,6,7,9,13,20,25);
		SingleParameterDescImpl<Integer> test2 = SingleParameterDescImpl.fromUpDown(2,4,8,12,13,19,28,31);
		System.out.println(test1);
		System.out.println(test2);
		SingleParameterDesc<Integer> union = test1.union(test2); 
		System.out.println(union);
		SingleParameterDesc<Integer> union2 = test2.union(test1); 
		System.out.println(union2);
	}

	private static<T extends Comparable<T>> SingleParameterDescImpl<T> fromUpDown(T... vals) {
		List<T[]> list = new ArrayList<>();
		for (int i = 0; i < vals.length-1; i+=2) {
			T[] arr = Arrays.copyOf(vals, 2);
			arr[0] = vals[i];
			arr[1] = vals[i+1];
			list.add(arr);
		}
		return new SingleParameterDescImpl<T>(list);
	}

}
