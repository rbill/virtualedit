package at.ac.tuwien.big.vmodel.ecore;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.util.InternalEList;

public abstract class FakeInternalEList<T> extends AbstractEList<T> implements InternalEList<T> {

	@Override
	public Object[] basicToArray() {
		return basicList().toArray();
	}

	@Override
	public <T> T[] basicToArray(T[] array) {
		return basicList().toArray(array);
	}

	@Override
	public int basicIndexOf(Object object) {
		return basicList().indexOf(object);
	}

	@Override
	public int basicLastIndexOf(Object object) {
		return basicList().lastIndexOf(object);
	}

	@Override
	public boolean basicContains(Object object) {
		return basicList().contains(object);
	}

	@Override
	public boolean basicContainsAll(Collection<?> collection) {
		return basicList().containsAll(collection);
	}

	@Override
	public NotificationChain basicRemove(Object object, NotificationChain notifications) {
		//TODO: This is wrong ...
		basicList().remove(object);
		return notifications;
	}

	@Override
	public NotificationChain basicAdd(T object, NotificationChain notifications) {
		basicList().add(object);
		return notifications;
	}

	@Override
	public T primitiveGet(int index) {
		return basicList().get(index);
	}

	@Override
	public T basicGet(int index) {
		return basicList().get(index);
	}
	
	@Override
	public Iterator<T> basicIterator() {
		return basicList().iterator();
	}

	@Override
	public ListIterator<T> basicListIterator() {
		return basicList().listIterator();
	}

	@Override
	public ListIterator<T> basicListIterator(int index) {
		return basicList().listIterator(index);
	}

	@Override
	public boolean addAllUnique(Collection<? extends T> collection) {
		boolean ret = false;
		for (T o: collection) {
			ret|= basicList().add(o);
		}
		return ret;
	}

	@Override
	public boolean addAllUnique(int index, Collection<? extends T> collection) {
		return basicList().addAll(index,collection);
	}

	@Override
	public boolean addAllUnique(Object[] objects, int start, int end) {
		boolean ret = false;
		for (int i = start; i< end; ++i) {
			ret|= basicList().add((T)objects[i]);
		}
		return ret;
	}

	@Override
	public boolean addAllUnique(int index, Object[] objects, int start, int end) {
		boolean ret = false;
		for (int i = end-1; i >= start; --i) {
			basicList().add(i,(T)objects[i]);
			ret = true;
		}
		return ret;
	}
	@Override
	public abstract List<T> basicList();

	@Override
	public T setUnique(int index, T object) {
		System.out.println("This: "+this.getClass()+", BasicList: "+basicList().getClass());
		return basicList().set(index, object);
	}

	@Override
	public void addUnique(T object) {
		basicList().add(object);
	}

	@Override
	public void addUnique(int index, T object) {
		basicList().add(index,object);
	}



}
