package at.ac.tuwien.big.vmod.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.col.ConvertingList;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.IterableType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.FakeInternalEList;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;

public class VFakeEList<T> extends FakeInternalEList<T> implements EList<T>, NoInverse<VFakeEList<T>> {
	
	private Function<Treepos, ? extends Function<T, ? extends Counter>> mainFunction;
	private boolean isContainment;
	private EStructuralFeature thisRef;
	private Function<Symbol, Function<Treepos, ? extends Function<T, ? extends Counter>>> inverseFunction;
	private VModelView model;
	private Symbol myValue;
	
	public VFakeEList(Symbol myValue, Function<Treepos, ? extends Function<T, ? extends Counter>> function, Filter<T> instanceFilter, VModelView model, EStructuralFeature thisRefNoOpposite, boolean isContainment) {
		this.mainFunction = function;
		this.instanceFilter = instanceFilter;
		this.startPos = new FilteredTreeposIterablePosition(((TreeposIterablePosition)mainFunction.getIterableOrNull()));
		this.model = model;
		this.myValue = myValue;
		this.isContainment = isContainment;
		this.basicList = this;
		this.thisRef = thisRefNoOpposite;
	}
	
	
	
	private VFakeEList<T> basicList;
	
	private VFakeEList(VFakeEList<T> copy, boolean useInverse) {
		this.mainFunction = copy.mainFunction;
		this.instanceFilter = copy.instanceFilter;
		this.startPos = copy.startPos;
		this.myValue = copy.myValue;
		this.model = copy.model;
		this.thisRef = copy.thisRef;
		this.isContainment = copy.isContainment;
		this.inverseFunction = useInverse?copy.inverseFunction:null;
		this.basicList = copy.basicList;
	}
	
	public VFakeEList<T> noInverse() {
		if (inverseFunction == null) {
			return this;
		}
		return new VFakeEList(this,false);
	}
	
	public VFakeEList(Symbol myValue, Function<Treepos, ? extends Function<T, ? extends Counter>> function, Filter<T> instanceFilter, VModelView model, boolean isContainment, EStructuralFeature thisRef) {
		this.mainFunction = function;
		this.instanceFilter = instanceFilter;
		this.startPos = new FilteredTreeposIterablePosition((TreeposIterablePosition)mainFunction.getIterableOrNull());
		this.model = model;
		this.myValue = myValue;
		this.thisRef = thisRef;
		this.isContainment = isContainment;
		if (thisRef instanceof EReference) {
			EReference ref = (EReference)thisRef;
			if (ref.getEOpposite() != null) {
				inverseFunction = model.getFeatureValues(ref.getEOpposite()).getFunction();
			}
		}
		this.basicList = new VFakeEList<>(myValue, function, instanceFilter, model, thisRef, isContainment);
	}
	
	public static final Filter NO_FILTER = (x)->true;
	
	private Filter<T> instanceFilter;
	
	private TreeposIterablePosition startPos;
	
	private class FilteredTreeposIterablePosition implements TreeposIterablePosition {
		
		private TreeposIterablePosition oriPos;
		
		public FilteredTreeposIterablePosition(TreeposIterablePosition oriPos) {
			this.oriPos = oriPos;
		}
		
		public T getEntryValue() {
			return anyValue(mainFunction.getValue(oriPos.getObject()));
		}

		@Override
		public IterableType getType() {
			return oriPos.getType();
		}

		@Override
		public Treepos getObject() {
			return oriPos.getObject();
		}

		@Override
		public boolean hasElement() {
			return oriPos.hasElement();
		}

		@Override
		public Treepos delete() {
			Treepos ret = oriPos.getObject();
			Function<T, ? extends Counter> func = mainFunction.getValue(ret);
			func.clear();

			oriPos.remove();
			return ret;
		}

		@Override
		public void add(Treepos obj) {
			oriPos.add(obj);
		}

		@Override
		public Object getMetaInfo(String key) {
			return oriPos.getMetaInfo(key);
		}
		
		/*@Override
		public Treepos afterPos() {
			return oriPos.afterPos();
		}
		
		@Override
		public Treepos beforePos() {
			return oriPos.beforePos();
		}*/

		@Override
		public ParentLocation getParentLoc() {
			return oriPos.getParentLoc();
		}

		@Override
		public void setParentLoc(ParentLocation parent) {
			oriPos.setParentLoc(parent);
		}
		
		private TreeposIterablePosition from(TreeposIterablePosition ori) {
			return new FilteredTreeposIterablePosition(ori);
		}

		@Override
		public TreeposIterablePosition getNextOrNull() {
			TreeposIterablePosition next = oriPos.getNextOrNull();
			while (next != null && !next.isEnd() &&  !hasAnyValue(mainFunction.getValue(next.getObject()))) {
				next = next.getNextOrNull();
			}
			return next==null?null:from(next);
		}

		@Override
		public TreeposIterablePosition endPos() {
			return from(oriPos.endPos());
		}

		@Override
		public TreeposIterablePosition startPos() {
			return from(oriPos.startPos());
		}

		@Override
		public TreeposIterablePosition getPreviousOrNull() {
			TreeposIterablePosition previous = oriPos.getPreviousOrNull();
			while (previous != null && !previous.isStart() && !hasAnyValue(mainFunction.getValue(previous.getObject()))) {
				previous = previous.getPreviousOrNull();
			}
			return previous==null?null:from(previous);
		}

	}
	
	private boolean hasAnyValue(Function<T, ? extends Counter> func) {
		for (T t: func.keyIterable())  {
			if (instanceFilter.matches(t) && func.getValue(t).exists()) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public boolean add(T e) {
		TreeposIterablePosition lastPos = startPos.endPos();
		return addBeforePos(lastPos,e);
	}
	
	private boolean addBeforePos(TreeposIterablePosition lastPos, T element) {
		Treepos pos = lastPos.beforePos();
		return addAtPos(pos, element);
	}
	
	private boolean addAfterPos(TreeposIterablePosition lastPos, T element) {
		Treepos pos = lastPos.afterPos();
		return addAtPos(pos, element);
	}
	
	private<T> void ensureContains(List<T> l, T element) {

		if (l instanceof ConvertingList) {
			l = ((ConvertingList)l).getDelegate();
		}
		if (l instanceof VFakeEList) {
			VFakeEList fl = (VFakeEList)l;
			fl.simpleAdd(element);
		} else {
			if (!l.contains(element)) {
				l.add(element);
			}
		}
	}
	
	public Counter getCandidate(Function<Treepos,? extends Function<?,? extends Counter>> sfunc, Object element) {
		Counter candidate = null;
		for (Entry<Treepos,? extends Function<?,? extends Counter>> entry: sfunc.entryIterable()) {
			Function<?,? extends Counter> func = entry.getValue();
			boolean hasOtherValue = false;
			Counter subCandidate = null;
			for (Entry<?, ? extends Counter> subentry: func.entryIterable()) {
				if (Objects.equals(subentry.getKey(), element)) {
					if (subentry.getValue().getValue() > 0) {
						return subentry.getValue();
					}
					subCandidate = subentry.getValue();
				} else {
					hasOtherValue = true;
				}
			}
			if (!hasOtherValue && candidate == null) {
				candidate = subCandidate;
			}
		}
		return candidate;
	}
	
	private void simpleAdd(T element) {
		Counter candidate = getCandidate(mainFunction,element);
		if (candidate != null) {
			candidate.setMin(1);
		} else {
			add(element);
		}
	}
	
	

	private boolean addAtPos(Treepos lastPos, T element) {
		Treepos pos = lastPos; 
		startPos.add(pos);
		Function<T, ? extends Counter> func = mainFunction.getValue(pos);
		Counter curC = func.getValue(element);
		boolean ret = curC.getValue()<1;
		if (!curC.exists()) {
			if (isContainment) {
				model.getInstances().informContainer((Symbol)element,(EReference)thisRef,myValue);
			}
			if (inverseFunction != null) {
				List<?> l = model.getFeatureValues(((EReference)thisRef).getEOpposite()).getEcoreValue((Symbol)element);
				ensureContains((List)l,myValue);
			}
		}
		String bla = "Add at pos: "+lastPos+": "+element+ " in "+thisRef.getName()+" of "+myValue;
		System.out.println(bla);
		curC.setMin(1);
		//String bla = String.valueOf(this);
		return ret;
	}

	@Override
	public void add(int index, T element) {
		TreeposIterablePosition pos = getAtIndex(index);
		addBeforePos(pos, element);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean ret = false;
		for (T t: c) {
			ret|= add(t);
		}
		return ret;
	}
	
	private TreeposIterablePosition getAtIndex(int idx) {
		TreeposIterablePosition curPos = startPos;
		for (int i = 0; i <= idx; ++i) {
			curPos = curPos.getNext();
		}
		return curPos;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		TreeposIterablePosition pos = getAtIndex(index);
		boolean ret = false;
		List<T> reverse = new ArrayList<>(c);
		//Collections.reverse(reverse);
		for (T t: reverse) {
			ret|= addBeforePos(pos, t);
		}
		return ret;
	}

	@Override
	public void clear() {
		if (inverseFunction != null) {
			//Collect all existing
			
			for (Entry<Treepos,? extends Function<T,? extends Counter>> entry: mainFunction.entryIterable()) {
				Function<T,? extends Counter> func = entry.getValue();
				for (Entry<T,? extends Counter> s: func.entryIterable()) {
					if (s.getValue().exists()) {
						Function<Treepos,? extends Function<?,? extends Counter>> ifu = inverseFunction.getValue((Symbol)s.getKey());
						Function.ensureNotContains(ifu, myValue);
					}
				}
			}
		}
		if (isContainment) {
			for (Entry<Treepos,? extends Function<T,? extends Counter>> entry: mainFunction.entryIterable()) {
				Function<T,? extends Counter> func = entry.getValue();
				for (T s: Function.getExistingValues(func)) {
					model.getInstances().informNoContainer(myValue, (EReference)thisRef,(Symbol)s);
				}
			}
		}
		mainFunction.clear();
	}

	@Override
	public boolean contains(Object cmp) {
		for (Object o: this) {
			if (Objects.equals(o, cmp)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean ret = true;
		for (Object t: c) {
			ret&= contains(t);
		}
		return ret;
	}
	
	//Tatsächlich die größte ...
	private T anyValue(Function<T,? extends Counter> func) {
		Iterator<? extends T> iter = func.keyIterator();
		int minV = 0;
		T ret = null;
		while (iter.hasNext()) {
			T key = iter.next();
			if (!instanceFilter.matches(key)) {
				continue;
			}
			Counter c = func.getValue(key);
			int cv = c.getValue();
			if (cv >= minV && cv > 0) {
				if (minV > 0) {
					System.out.println("Could return "+ret+" or "+key+" ("+minV+" VS "+cv+")");
				}
				minV = cv;
				ret = key;
			}
		}
		return ret;
	}
	
	private ExactDerivationStatus derivationStatus(Function<T,? extends Counter> func, Collection<ModelResource> userModelResources) {
		Iterator<? extends T> iter = func.keyIterator();
		ExactDerivationStatus status = new ExactDerivationStatus();
		while (iter.hasNext()) {
			T key = iter.next();
			if (!instanceFilter.matches(key)) {
				continue;
			}
			Counter c = func.getValue(key);
			c.getDerivationStatus(userModelResources, status);
		}
		return status;
	}

	@Override
	public T get(int index) {
		return anyValue(mainFunction.getValue(getAtIndex(index).getObject()));
	}

	@Override
	public int indexOf(Object o) {
		int idx = 0;
		for (T cur: this) {
			if (Objects.equals(cur, o)) {
				return idx;
			}
			++idx;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		for (Object o: this) {
			return false;
		}
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		return listIterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		int idx = 0;
		int ret = -1;
		for (T cur: this) {
			if (Objects.equals(cur, o)) {
				ret = idx;
			}
			++idx;
		}
		return ret;
	}

	@Override
	public ListIterator<T> listIterator() {
		return listIterator(0);
	}
	
	public static int getIndex(IterablePosition pos) {
		int ret = -1;
		while (!pos.isStart()) {
			pos = pos.getPrevious();
			++ret;
		}
		return ret;
	}
	
	@Override
	public List<ExactDerivationStatus> getDerivationStatus(Collection<ModelResource> userModels) {
		TreeposIterablePosition itPos = startPos.getNextOrNull();
		List<ExactDerivationStatus> derivationStatus = new ArrayList<>();
		while (itPos != null && itPos.hasElement()) {
			Treepos tp = itPos.getObject();
			ExactDerivationStatus toAdd = derivationStatus(mainFunction.getValue(tp), userModels);
			derivationStatus.add(toAdd);
			itPos = itPos.getNextOrNull();
		}
		return derivationStatus;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		ListIterator<T> ret = new ListIterator<T>() {
			
			TreeposIterablePosition curPos = startPos;
			Treepos lastPos;
			{
				for (int i = 0; i <= index; ++i) {
					curPos = curPos.getNext();
				}
			}

			@Override
			public void add(T e) {
				VFakeEList.this.addBeforePos(curPos, e);
				/*if (isContainment) {
					model.getInstances().informContainer((Symbol)e,(EReference)thisRef,myValue);
				}*/
			}

			@Override
			public boolean hasNext() {
				return curPos.hasElement();
			}

			@Override
			public boolean hasPrevious() {
				return curPos.getPrevious().hasElement();
			}

			@Override
			public T next() {
				try {
					return getAny(lastPos = curPos.getObject());
				} finally {
					curPos = curPos.getNext();
				}
			}

			@Override
			public int nextIndex() {
				return getIndex(curPos);
			}

			@Override
			public T previous() {
				curPos = curPos.getPrevious();
				return getAny(lastPos = curPos.getObject());
			}

			@Override
			public int previousIndex() {
				return getIndex(curPos)-1;
			}

			@Override
			public void remove() {
				if (lastPos != null) {
					if (inverseFunction != null) {
						for (T s: Function.getExistingValues(mainFunction.getValue(lastPos))) {
							Function<Treepos,? extends Function<?,? extends Counter>> ifu = inverseFunction.getValue((Symbol)s);
							Function.ensureNotContains(ifu, myValue);
						}
					}
					if (isContainment) {						
						for (T s: Function.getExistingValues(mainFunction.getValue(lastPos))) {
							model.getInstances().informNoContainer(myValue,(EReference)thisRef,(Symbol)s);
						}
					}
					mainFunction.getValue(lastPos).clear();
					lastPos = null;					
				} else {
					throw new IllegalStateException();
				}
			}

			@Override
			public void set(T e) {
				setTo(mainFunction.getValue(lastPos),e);
			}
		};
		return ret;
	}
	
	private void setTo(Function<T,? extends Counter> func, T element) {
		boolean done = false;
		for (Entry<T,? extends Counter> entr:func.entryIterable()) {
			T key = entr.getKey();
			Counter val = entr.getValue();
			if (Objects.equals(key,element) && !done) {
				if (!val.exists()) {
					if (inverseFunction != null) {
						Function<Treepos,? extends Function<?,? extends Counter>> ifu = inverseFunction.getValue((Symbol)key);
						Counter candidate = getCandidate(ifu,element);
						if (candidate != null) {
							candidate.setMin(1);
						} else {
							TreeposIterablePosition tpi = (TreeposIterablePosition)ifu.getIterableOrNull();
							((Counter)((Function)ifu.getValue(tpi.endPos().beforePos())).getValue(this.myValue)).setMin(1);
						}
					}
					if (isContainment) {
						model.getInstances().informContainer((Symbol)key,(EReference)thisRef,myValue);
					}
					val.setMin(1);
				}
				done = true;
			} else {
				if (val.exists()) {
					if (inverseFunction != null) {
						Function<Treepos,? extends Function<?,? extends Counter>> ifu = inverseFunction.getValue((Symbol)key);
						Function.ensureNotContains(ifu, myValue);
					}
					if (isContainment) {
						model.getInstances().informNoContainer(myValue,(EReference)thisRef,(Symbol)key);
					}
					val.setMax(0);
				}
			}
		};
		if (!done) {
			if (inverseFunction != null) {
				Function<Treepos,? extends Function<?,? extends Counter>> ifu = inverseFunction.getValue((Symbol)element);
				Counter candidate = getCandidate(ifu,element);
				if (candidate != null) {
					candidate.setMin(1);
				} else {
					TreeposIterablePosition tpi = (TreeposIterablePosition)ifu.getIterableOrNull();
					((Counter)((Function)ifu.getValue(tpi.endPos().beforePos())).getValue(this.myValue)).setMin(1);
				}
			}
			if (isContainment) {
				model.getInstances().informContainer((Symbol)element,(EReference)thisRef,myValue);
			}
			func.getValue(element).setMin(1);
		}
	}

	@Override
	public boolean remove(Object o) {
		for (Treepos tp: (Iterable<Treepos>)()->mainFunction.keyIterator()) {
			Function func = mainFunction.getValue(tp);
			Counter c = (Counter)func.getValueOrNull(o);
			if (c != null && c.exists()) {
				c.clear();
				if (inverseFunction != null) {
					Function<Treepos,? extends Function<?,? extends Counter>> ifu = inverseFunction.getValue((Symbol)o);
					Function.ensureNotContains(ifu, myValue);
				}
				if (isContainment) {
					model.getInstances().informNoContainer(myValue,(EReference)thisRef,(Symbol)o);
				}
				return true;
			}
		}
		return false;
	}
	
	public T getAny(Treepos pos) {
		return anyValue(mainFunction.getValue(pos));
	}
	
	public T getAny(TreeposIterablePosition pos) {
		return getAny(pos.getObject());
	}

	@Override
	public T remove(int index) {
		TreeposIterablePosition pos = getAtIndex(index);
		Function<T, ? extends Counter> func = mainFunction.getValue(pos.getObject());
		if (inverseFunction != null) {
			if (inverseFunction != null) {
				for (T s: Function.getExistingValues(func)) {
					Function.ensureNotContains(inverseFunction.getValue((Symbol)s), myValue);
				}
			}
		}
		if (isContainment) {
			for (T s: Function.getExistingValues(func)) {
				model.getInstances().informNoContainer(myValue,(EReference)thisRef,(Symbol)s);
			}
		}
		T ret = anyValue(func);
		func.clear();		
		pos.remove(); //TODO: .... warum geht das nicht, wenn man die Position entfernt? Ist da ein bug? - ja, und zwar darf man bei UnionTreepos natürlich das nicht entfernen, deshalb dort gefiltert
		return ret;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean ret = false;
		for (Object o: c) {
			ret|= remove(o);
		}
		return ret;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean ret = false;
		for (Treepos tp: (Iterable<Treepos>)()->mainFunction.keyIterator()) {
			Function func = mainFunction.getValue(tp);
			for (Object val: (Iterable)()->func.keyIterator()) {
				if (!c.contains(val)) {
					Counter cur = (Counter)func.getValue(val);
					if (cur.exists()) {
						ret = true;
						if (inverseFunction != null) {
							Function.ensureNotContains(inverseFunction.getValue((Symbol)val),myValue);
						}
						if (isContainment) {
							model.getInstances().informNoContainer(myValue,(EReference)thisRef,(Symbol)val);
						}
						cur.clear();
					}
				}
			}
		}
		return ret;
	}
	
	private Function<T, ? extends Counter> getFunction(int pos) {
		return mainFunction.getValue(getAtIndex(pos).getObject());
	}

	@Override
	public T set(int index, T element) {
		Function<T, ? extends Counter> func = getFunction(index);
		T ret = anyValue(func);
		setTo(func,element);
		return ret;
	}
	
	

	@Override
	public int size() {
		int idx = 0;
		for (T t: this) {
			++idx;
		}
		return idx;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		List ret = new ArrayList<>();
		for (Object o: this) {
			ret.add(o);
		}
		return ret.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		List ret = new ArrayList<>();
		for (Object o: this) {
			ret.add(o);
		}
		return (T[])ret.toArray(a);
	}

	@Override
	public void move(int newPosition, T object) {
		//No effect on inverse/containment!
		int idx = indexOf(object);
		move(newPosition,idx);
	}

	@Override
	public T move(int newPosition, int oldPosition) {
		//No effect on inverse/containment!
		if (oldPosition == newPosition) {
			return get(oldPosition);
		}
		TreeposIterablePosition oldPositionI = getAtIndex(oldPosition);
		T ret = getAny(oldPositionI);
		Treepos newPos = getAtIndex(newPosition).beforePos();
		oldPositionI.add(newPos);
		Function<T, ? extends Counter> newFunc = mainFunction.getValue(newPos);
		Function<T, ? extends Counter> func = mainFunction.getValue(oldPositionI.getObject());
		func.forEach((This,key,value)->{
			if (value.exists()) {
				newFunc.getValue(key).setMin(value.getValue());
				value.clear();
			}
		});
		return ret;
	}


	@Override
	public List<T> basicList() {
		return basicList;
	}

}
