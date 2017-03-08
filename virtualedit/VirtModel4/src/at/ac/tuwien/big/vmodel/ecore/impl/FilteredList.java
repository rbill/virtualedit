package at.ac.tuwien.big.vmodel.ecore.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.vmodel.general.SourcedList;
import at.ac.tuwien.big.xtext.util.IteratorUtils;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;

public class FilteredList<T> extends AbstractList<T> implements List<T>, SourcedList{

	
	private List<T> baseList;
	private Filter<T> filter;
	
	public FilteredList(List<T> baseList, Filter<T> filter) {
		this.baseList = baseList;
		this.filter = filter;
	}
	

	@Override
	public T get(int index) {
		for (T t: baseList) {
			if (filter.matches(t)) {
				if (index-- == 0) {
					return t;
				}
			}
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	@Override
	public Iterator<T> iterator() {
		return IteratorUtils.filterType(baseList.iterator(), filter);
	}

	@Override
	public int size() {
		int ret = 0;
		for (T t: baseList) {
			if (filter.matches(t)) {
				++ret;
			}
		}
		return ret;
	}
	
	public T set(int index, T element) {
		ListIterator<T> iter = baseList.listIterator();
		int idx = 0;
		while (iter.hasNext()) {
			T t = iter.next();
			if (filter.matches(t)) {
				if (idx == index) {
					iter.set(element);
					return t;
				}
				++idx;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean addAll(int index, Collection<? extends T> c) {
		ListIterator<T> iter = baseList.listIterator();
		int idx = 0;
		int subIndex = 0;
		while (iter.hasNext()) {
			T t = iter.next();
			if (filter.matches(t)) {
				if (idx == index) {
					return baseList.addAll(subIndex,c);
				}
				++idx;
			}
			++subIndex;
		}
		if (idx == index) {
			return baseList.addAll(c);
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public void add(int index, T element) {
		ListIterator<T> iter = baseList.listIterator();
		int idx = 0;
		while (iter.hasNext()) {
			T t = iter.next();
			if (filter.matches(t)) {
				if (idx == index) {
					iter.previous();
					iter.add(element);
					return;
				}
				++idx;
			}
		}
		if (idx == index) {
			baseList.add(element);
			return;
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public boolean add(T element) {
		return baseList.add(element);
	}
	
	public boolean remove(Object o) {
		return baseList.remove(o);
	}
	
	public T remove(int index) {
		ListIterator<T> iter = baseList.listIterator();
		int idx = 0;
		while (iter.hasNext()) {
			T t = iter.next();
			if (filter.matches(t)) {
				if (idx == index) {
					iter.remove();
					return t;
				}
				++idx;
			}
		}
		throw new ArrayIndexOutOfBoundsException();
	}


	@Override
	public List<? extends Iterable<? extends ElementSourceInfo>> getSources() {
		if (baseList instanceof SourcedList) {
			List<? extends Iterable<? extends ElementSourceInfo>> baseRet = ((SourcedList) baseList).getSources();
			if (baseRet == null) {
				return null;
			}
			List<Iterable<? extends ElementSourceInfo>> ret = new ArrayList<>();
			Iterator<? extends Iterable<? extends ElementSourceInfo>> iter = baseRet.iterator();
			for (T t: baseList) {
				if (filter.matches(t) && iter.hasNext()) {
					ret.add(iter.next());
				} else if (iter.hasNext()) {
					iter.next();
				}
			}
			return ret;
		}
		return null;
	}

}
