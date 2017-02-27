package at.ac.tuwien.big.vmodel.general.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Set;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.DeltaBuilt;
import at.ac.tuwien.big.vmodel.general.DeltaCreater;
import at.ac.tuwien.big.vmodel.general.DeltaVFunc;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.IntegerValueElement;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.OwnedFunc.OnCreatedListener;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class SimpleDeltaVFunc<T,U,U1 extends VObject,U2 extends VObject,TF extends VFunc<? super T, ? extends U1>, UF extends VFunc<? super T, ? extends U2>> 
	extends BasicVObject
implements DeltaVFunc<T, U,U1,U2>, OwnedFunc<T, U>,
	VEntryIterableFunc<T,U>, DeltaBuilt<TF,UF>{

	public String toString() {
		return "Delta between (" + String.valueOf(first)+") and ("+String.valueOf(second)+")";
	}
	
	private TF first;
	private UF second;
	private OwnedFunc<T, U> cache;
	private DeltaCreater<U1,U2,? extends U> creater;
	
	private Editstate editState;
	
	public Editstate getEditState() {
		return editState;
	}
	
	private OnCreatedListener<T, U> listener;
	
	public void setOnCreatedListener(OnCreatedListener<T, U> listener) {
		this.listener = listener;
	}
	

	@Override
	public U get(T x) {
		U ret = cache().getOrNull(x);
		if (ret == null) {
			cache().set(x, ret = creater().create(first().get(x), second().get(x)));
			if (listener != null) {
				listener.onCreated(this, x, ret);
			}
		}
		return ret;
	}
		
	public static<X,Y,U1 extends IntegerValueElement,U2 extends EditableIntegerValueElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,U1>>,G extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,U2>>>
		SimpleDeltaVFunc<X,VEntryIterableFunc<Y,SimpleDeltaIntegerValueEditableView<U1,U2>>,VEntryIterableFunc<Y,U1>,VEntryIterableFunc<Y,U2>,?,?> simpleEditableViewDF(VContainer cont, 
				F base, 
				G view) {
		 return new SimpleDeltaVFunc<X,VEntryIterableFunc<Y,SimpleDeltaIntegerValueEditableView<U1,U2>>,VEntryIterableFunc<Y,U1>,VEntryIterableFunc<Y,U2>,
		 	F,G>(
					cont,base,view, new SimpleVFunc<X,VEntryIterableFunc<Y,SimpleDeltaIntegerValueEditableView<U1,U2>>>(cont.createChild("cache"),
							(x)->simpleEditableView(cont.createChild("sub"),base.get(x),view.get(x))),
					new DeltaCreater<VEntryIterableFunc<Y, U1>, VEntryIterableFunc<Y, U2>, SimpleDeltaVFunc<Y, SimpleDeltaIntegerValueEditableView<U1,U2>,
					U1,U2,
					VEntryIterableFunc<Y,U1>,VEntryIterableFunc<Y,U2>>>() {

						@Override
						public SimpleDeltaVFunc<Y, SimpleDeltaIntegerValueEditableView<U1, U2>, U1, U2, VEntryIterableFunc<Y, U1>, VEntryIterableFunc<Y, U2>> create(VEntryIterableFunc<Y,U1> u1,VEntryIterableFunc<Y,U2> u2) {
							return simpleEditableView(cont.createChild("sub"),u1,u2);
						}
						
					});
	}
	
	//Base: first is editable
	public static SimpleDeltaVFunc simpleEditableBaseDynamic(VContainer cont, 
			VEntryIterableFunc first, 
			VEntryIterableFunc second) {
	 return new SimpleDeltaVFunc(
				cont,first,second, new SimpleVFunc(cont.createChild("cache"),
						(x)-> {
							Object fobj = first.get(x);
							Object sobj = second.get(x);
							if (fobj instanceof VEntryIterableFunc && sobj instanceof VEntryIterableFunc) {
								return simpleEditableBaseDynamic(cont.createChild("sub"),(VEntryIterableFunc)fobj, (VEntryIterableFunc)sobj);
							} else if (fobj instanceof EditableIntegerValueElement && sobj instanceof IntegerValueElement) {
								return new SimpleDeltaIntegerValueElement(cont.createChild("sub"),(EditableIntegerValueElement)fobj,(IntegerValueElement)sobj);
							} else {
								throw new RuntimeException("Incompatible types "+fobj+", "+sobj);
							}
						}),
				new DeltaCreater() {

					@Override
					public DeltaBuilt create(VObject fobj, VObject sobj) {
						if (fobj instanceof VEntryIterableFunc && sobj instanceof VEntryIterableFunc) {
							return simpleEditableBaseDynamic(cont.createChild("sub"),(VEntryIterableFunc)fobj, (VEntryIterableFunc)sobj);
						} else if (fobj instanceof EditableIntegerValueElement && sobj instanceof IntegerValueElement) {
							return new SimpleDeltaIntegerValueElement(cont.createChild("sub"),(EditableIntegerValueElement)fobj,(IntegerValueElement)sobj);
						} else {
							throw new RuntimeException("Incompatible types "+fobj+", "+sobj);
						}
					}
					
				});
	}
	
	
	//Base: first is editable
	public static SimpleDeltaVFunc simpleEditableViewDynamic(VContainer cont, 
			VEntryIterableFunc first, 
			VEntryIterableFunc second) {
	 return new SimpleDeltaVFunc(
				cont,first,second, new SimpleVFunc(cont.createChild("cache"),
						(x)-> {
							Object fobj = first.get(x);
							Object sobj = second.get(x);
							if (fobj instanceof VEntryIterableFunc && sobj instanceof VEntryIterableFunc) {
								return simpleEditableViewDynamic(cont.createChild("sub"),(VEntryIterableFunc)fobj, (VEntryIterableFunc)sobj);
							} else if (fobj instanceof IntegerValueElement && sobj instanceof EditableIntegerValueElement) {
								return new SimpleDeltaIntegerValueEditableView(cont.createChild("sub"),(IntegerValueElement)fobj,(EditableIntegerValueElement)sobj);
							} else {
								throw new RuntimeException("Incompatible types "+fobj+", "+sobj);
							}
						}),
				new DeltaCreater() {

					@Override
					public DeltaBuilt create(VObject fobj, VObject sobj) {
						if (fobj instanceof VEntryIterableFunc && sobj instanceof VEntryIterableFunc) {
							return simpleEditableViewDynamic(cont.createChild("sub"),(VEntryIterableFunc)fobj, (VEntryIterableFunc)sobj);
						} else if (fobj instanceof IntegerValueElement && sobj instanceof EditableIntegerValueElement) {
							return new SimpleDeltaIntegerValueEditableView(cont.createChild("sub"),(IntegerValueElement)fobj,(EditableIntegerValueElement)sobj);
						} else {
							throw new RuntimeException("Incompatible types "+fobj+", "+sobj);
						}
					}
					
				});
	}

	public static<X,Y,U1 extends EditableIntegerValueElement,U2 extends IntegerValueElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,U1>>,G extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,U2>>>
		SimpleDeltaVFunc<X,VEntryIterableFunc<Y,SimpleDeltaIntegerValueElement<U1,U2>>,VEntryIterableFunc<Y,U1>,VEntryIterableFunc<Y,U2>,?,?> simpleEditableBaseDF(VContainer cont, 
				F first, 
				G second) {
		 return new SimpleDeltaVFunc<X,VEntryIterableFunc<Y,SimpleDeltaIntegerValueElement<U1,U2>>,VEntryIterableFunc<Y,U1>,VEntryIterableFunc<Y,U2>,
		 	F,G>(
					cont,first,second, new SimpleVFunc<X,VEntryIterableFunc<Y,SimpleDeltaIntegerValueElement<U1,U2>>>(cont.createChild("cache"),
							(x)->simpleEditableBase(cont.createChild("sub"),first.get(x),second.get(x))),
					new DeltaCreater<VEntryIterableFunc<Y, U1>, VEntryIterableFunc<Y, U2>, SimpleDeltaVFunc<Y, SimpleDeltaIntegerValueElement<U1,U2>,
					U1,U2,
					VEntryIterableFunc<Y,U1>,VEntryIterableFunc<Y,U2>>>() {

						@Override
						public SimpleDeltaVFunc<Y, SimpleDeltaIntegerValueElement<U1, U2>, U1, U2, VEntryIterableFunc<Y, U1>, VEntryIterableFunc<Y, U2>> create(VEntryIterableFunc<Y,U1> u1,VEntryIterableFunc<Y,U2> u2) {
							return simpleEditableBase(cont.createChild("sub"),u1,u2);
						}
						
					});
	}
	
	public static<X,U1 extends IntegerValueElement,U2 extends EditableIntegerValueElement>
		SimpleDeltaVFunc<X,SimpleDeltaIntegerValueEditableView<U1,U2>,U1,U2,VEntryIterableFunc<X,U1>,VEntryIterableFunc<X,U2>> 
		simpleEditableView(VContainer cont, VEntryIterableFunc<X,U1> first, VEntryIterableFunc<X,U2> second) {
		return new SimpleDeltaVFunc<X,SimpleDeltaIntegerValueEditableView<U1,U2>,U1,U2,VEntryIterableFunc<X,U1>,VEntryIterableFunc<X,U2>>(
				cont,first,second, new SimpleVFunc<X,SimpleDeltaIntegerValueEditableView<U1,U2>>(cont.createChild("cache"),
						(x)->new SimpleDeltaIntegerValueEditableView<U1,U2>(cont.createChild("sub"),(U1)first.get(x),(U2)second.get(x))),
				new DeltaCreater<U1,U2,SimpleDeltaIntegerValueEditableView<U1,U2>>() {

					@Override
					public SimpleDeltaIntegerValueEditableView<U1, U2> create(U1 u1, U2 u2) {
						return new SimpleDeltaIntegerValueEditableView<U1,U2>(cont.createChild("sub"),(U1)u1,(U2)u2);
					}
					
				});
	}
	

	
	public static<X,U1 extends EditableIntegerValueElement,U2 extends IntegerValueElement>
		SimpleDeltaVFunc<X,SimpleDeltaIntegerValueElement<U1,U2>,U1,U2,VEntryIterableFunc<X,U1>,VEntryIterableFunc<X,U2>> 
		simpleEditableBase(VContainer cont, VEntryIterableFunc<X,U1> first, VEntryIterableFunc<X,U2> second) {
		return new SimpleDeltaVFunc<X,SimpleDeltaIntegerValueElement<U1,U2>,U1,U2,VEntryIterableFunc<X,U1>,VEntryIterableFunc<X,U2>>(
				cont,first,second, new SimpleVFunc<X,SimpleDeltaIntegerValueElement<U1,U2>>(cont.createChild("cache"),
						(x)->new SimpleDeltaIntegerValueElement<U1,U2>(cont.createChild("sub"),(U1)first.get(x),(U2)second.get(x))),
				new DeltaCreater<U1,U2,SimpleDeltaIntegerValueElement<U1,U2>>() {

					@Override
					public SimpleDeltaIntegerValueElement<U1, U2> create(U1 u1, U2 u2) {
						return new SimpleDeltaIntegerValueElement<U1,U2>(cont.createChild("sub"),(U1)u1,(U2)u2);
					}
					
				});
	}
	
	
	public SimpleDeltaVFunc(VContainer cont, TF first, UF second, OwnedFunc<T, U> cache, DeltaCreater<U1,U2,? extends U> creater) {
		super(cont);
		this.first = first;
		this.second = second;
		this.cache = cache;
		this.creater = creater;
		this.editState = Editstate.merge(first.getEditState(),second.getEditState());
	}
	
	
	@Override
	public TF first() {
		return first;
	}

	@Override
	public UF second() {
		return second;
	}

	@Override
	public OwnedFunc<T, U> cache() {
		return cache;
	}

	@Override
	public DeltaCreater<U1,U2,? extends U> creater() {
		return creater;
	}


	@Override
	public void set(T t, U u) {
		cache.set(t, u);
	}

	@Override
	public U getOrNull(T t) {
		return cache.get(t);
	}
	@Override
	public Iterable<Entry<T, U>> getEntries() {
		return()->new Iterator<Entry<T,U>>() {
			Set<T> haveSet = new HashSet<>();
			Iterator<? extends Entry<? extends T,? extends U>> editIterator = ((VEntryIterableFunc<T, U>) first).getEntries().iterator();
			Iterator<? extends Entry<? extends T,? extends U>> baseIterator = null;
			T nextKey = null;
			U nextValue = null;

			@Override
			public boolean hasNext() {
				if (nextKey == null) {
					while (editIterator.hasNext()) {
						nextKey = editIterator.next().getKey();
						haveSet.add(nextKey);
						nextValue = get(nextKey);
						return true;
					}
					//Wenn amn das zuerst macht, dann führt das get() dazu, dass der Cache vom baseIterator oben verändert wird und es gibt eine Exception!
					if (baseIterator == null) {
						baseIterator = ((VEntryIterableFunc<T, U>) second).getEntries().iterator();
					}
					while (baseIterator.hasNext()) {
						//System.out.println("Accessing next of "+second.getClass()+"@"+System.identityHashCode(second));
						T tryKey = baseIterator.next().getKey();
						if (haveSet.add(tryKey)) {
							nextKey = tryKey;
							nextValue = get(nextKey);
							return true;
						}
					}
				}
				return nextKey != null;
			}

			@Override
			public Entry<T, U> next() {
				try {
					if (hasNext()) {
						return new FakeEntry<>(nextKey,nextValue);
					} else {
						throw new NoSuchElementException();
					}
				} finally {
					nextKey = null;
				}
			}
			
		};
	}

	@Override
	public TF getEdit() {
		return first;
	}


	@Override
	public UF getBase() {
		return second;
	}

}
