package at.ac.tuwien.big.vmodel.general.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.impl.VSimpleContainer;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.SourcedList;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.xtext.annotation.SourcedEObject;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class SimpleVListList<E> implements List<E>, SourcedList {
	
	private VList<E, ?> base;
	
	private List<Entry<Treepos,E>> baseEntries = null;
	
	public SimpleVListList(VList<E, ?> base) {
		this.base = base;
		synchronizeList();
	}
	
	public void synchronizeList() {
		baseEntries = new ArrayList<>();
		for (Entry<Treepos,E> entr: base.getExistingEntries()) {
			baseEntries.add(entr);
		}
		//TODO: Eigentlich sollte es schon so vorliegen ...
		Collections.sort(baseEntries, new Comparator<Entry<Treepos,E>>() {
			@Override
			public int compare(Entry<Treepos, E> o1, Entry<Treepos, E> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
	}

	@Override
	public boolean add(E e) {
		VEditableList<E,?> editable = base.asEditableOrFail();
		editable.append(e);
		synchronizeList();
		return true;
	}

	@Override
	public void add(int index, E element) {
		VEditableList<E,?> editable = base.asEditableOrFail();
		Entry<Treepos,E>[] entries = getEntries(index);
		editable.add(entries[0], entries[1], element);
		synchronizeList();
	}
	
	private Treepos addGetEntry(int index, E element) {
		VEditableList<E,?> editable = base.asEditableOrFail();
		Entry<Treepos,E>[] entries = getEntries(index);
		return editable.add(entries[0], entries[1], element);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean ret = !c.isEmpty();
		VEditableList<E,?> editable = base.asEditableOrFail();
		for (E e: c) {
			editable.append(e);
		}
		synchronizeList();
		return ret;
	}

	private Entry<Treepos,E>[] getEntries(int index) {

		if (index == size()) {
			if (index == 0) {
				return new Entry[2];
			} else {
				return new Entry[]{baseEntries.get(index-1),null};
			}
		} else if (index == 0) {
			return new Entry[]{null,baseEntries.get(0)};
		} else {
			return new Entry[]{baseEntries.get(index-1),baseEntries.get(index)};
		}
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		VEditableList<E,?> editable = base.asEditableOrFail();
		boolean ret = !c.isEmpty();
		Entry<Treepos,E>[] entries = getEntries(index);
		editable.addAll(entries[0], entries[1], c);
		synchronizeList();
		return ret;
	}

	@Override
	public void clear() {
		VEditableList<E,?> editable = base.asEditableOrFail();
		editable.clear();
		synchronizeList();
	}

	@Override
	public boolean contains(Object o) {
		return base.containsAny(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o: c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public E get(int index) {
		synchronizeList();
		return baseEntries.get(index).getValue();
	}

	@Override
	public int indexOf(Object o) {
		synchronizeList();
		int idx = 0;
		for (Entry<?,E> e: baseEntries) {
			if (Objects.equals(o, e.getValue())) {
				return idx;
			}
			++idx;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return baseEntries.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		synchronizeList();
		return IteratorUtils.convert(baseEntries, (x)->x.getValue()).iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		synchronizeList();
		int idx = -1;
		int lind = -1;
		for (Entry<?,E> e: baseEntries) {
			if (Objects.equals(o, e.getValue())) {
				lind = idx;
			}
			++idx;
		}
		return lind;
	}

	@Override
	public ListIterator<E> listIterator() {
		synchronizeList();
		return listIterator(0);
	}

	@Override
	public ListIterator<E> listIterator(int idx) {
		synchronizeList();
		ListIterator<Entry<Treepos,E>> baseIter = baseEntries.listIterator(idx);
		SimpleVListList<E> $This = this; 
		return new ListIterator<E>() {

			@Override
			public void add(E e) {
				baseIter.add(new FakeEntry<>($This.addGetEntry(nextIndex(),e),e));
			}
			
			Entry<Treepos,E> lastEntry;

			@Override
			public boolean hasNext() {
				return baseIter.hasNext();
			}

			@Override
			public boolean hasPrevious() {
				return baseIter.hasPrevious();
			}

			@Override
			public E next() {
				return (lastEntry = baseIter.next()).getValue();
			}

			@Override
			public int nextIndex() {
				return baseIter.nextIndex();
			}

			@Override
			public E previous() {
				return (lastEntry = baseIter.previous()).getValue();
			}

			@Override
			public int previousIndex() {
				return baseIter.previousIndex();
			}

			@Override
			public void remove() {
				baseIter.remove();
				SimpleVListList.this.base.asEditableOrFail().removeAll(lastEntry.getKey(),lastEntry.getValue());
				synchronizeList();
			}

			@Override
			public void set(E e) {
				SimpleVListList.this.base.asEditableOrFail().replace(lastEntry.getKey(),lastEntry.getValue(),e);
				lastEntry.setValue(e);
				synchronizeList();
			}
		};
	}

	@Override
	public boolean remove(Object o) {
		boolean ret = base.containsAny(o);
		base.asEditableOrFail().removeAllY((E)o);
		synchronizeList();
		return ret;
	}

	@Override
	public E remove(int index) {
		synchronizeList();
		Entry<Treepos,E> entr = baseEntries.get(index);
		base.asEditableOrFail().removeAll(entr.getKey(), entr.getValue());
		synchronizeList();
		return entr.getValue();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean ret = false;
		for (Object o: c) {
			ret|= base.containsAny(o);
			base.asEditableOrFail().removeAllY((E)o);
		}
		synchronizeList();
		return ret;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		synchronizeList();
		List<Entry<Treepos,E>> toDelete = new ArrayList<Entry<Treepos,E>>();
		boolean ret = false;
		for (Entry<Treepos,E> entr: baseEntries) {
			if (!c.contains(entr.getValue())) {
				toDelete.add(entr);
				ret = true;
			}
		}
		for (Entry<Treepos,E> entr: toDelete) {
			base.asEditableOrFail().removeAll(entr.getKey(), entr.getValue());
		}
		synchronizeList();
		return true;
	}

	@Override
	public E set(int index, E element) {
		synchronizeList();
		Entry<Treepos,E> entr = baseEntries.get(index);
		base.asEditableOrFail().replace(entr.getKey(), entr.getValue(), element);
		synchronizeList();
		return entr.getValue();
	}

	@Override
	public int size() {
		synchronizeList();
		return baseEntries.size();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		synchronizeList();
		return new AbstractList<E>() {

			@Override
			public E get(int index) {
				return SimpleVListList.this.get(index+fromIndex);
			}
			
			@Override
			public E set(int index, E element) {
				return SimpleVListList.this.set(index+fromIndex,element);
			}
			
			@Override
			public void add(int index, E element) {
				SimpleVListList.this.add(index+fromIndex,element);
			}

			@Override
			public int size() {
				return fromIndex-toIndex;
			}
		};
	}
	
	public List<E> copyList() {
		synchronizeList();
		List<E> ret = new ArrayList<>();
		for (E e: this) {
			ret.add(e);
		}
		return ret;
	}

	@Override
	public Object[] toArray() {
		return copyList().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return copyList().toArray(a);
	}
	
	public String toString() {
		synchronizeList();
		return Arrays.toString(toArray());
	}

	public static void main(String[] args) {
		SimpleAbstractDelegatingVList<String, EditableIntegerValueElement,?> simpleList = 
				SimpleAbstractDelegatingVList.createBasicList(new VSimpleContainer((GlobalSource)null));
		SimpleVListList<String> myList = simpleList.asList();
		myList.add("ASDF");
		myList.add("JKLÖ");
		myList.add(1,"MID");
		myList.add(0,"INIT");
		myList.add(4,"END");
		System.out.println(myList);
		
		SimpleAbstractDelegatingVList<String, EditableIntegerValueElement,?> editList = (SimpleAbstractDelegatingVList)
				SimpleAbstractDelegatingVList.createBasicList(new VSimpleContainer((GlobalSource)null));
		
		VEditableList<String, ?> list = 
				
				VEditableList.buildEditableDeltaList(new VSimpleContainer((GlobalSource)null),simpleList,editList);
		List<String> deltaList = list.asList();
		System.out.println(deltaList);
		deltaList.remove(3);
		deltaList.add(3, "EDITELEMENT");
		
		System.out.println(deltaList);
		System.out.println(myList);
		System.out.println(editList.asList());
	}

	@Override
	public List<? extends Iterable<? extends ElementSourceInfo>> getSources() {
		synchronizeList();
		List<Iterable<? extends ElementSourceInfo>> sources = new ArrayList<>();
		for (Entry<Treepos, E> entr: this.baseEntries) {
			sources.add(base.get(entr.getKey(), entr.getValue()).getRelevantSourceInfos());
		}
		return sources;
	}
}
