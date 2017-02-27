package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.PosEditState;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposType;
import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleListEditState;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposValue;import at.ac.tuwien.big.virtmod.basic.impl.SimpleVEditableVSet;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.impl.EditGlobalSource;
import at.ac.tuwien.big.virtmod.structure.impl.VSimpleContainer;
import at.ac.tuwien.big.vmodel.general.AbstractDelegatingEditableVAssoc;
import at.ac.tuwien.big.vmodel.general.AbstractParameterInvertibleFuncBase;
import at.ac.tuwien.big.vmodel.general.DoubleParameterIFace;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.ParameterInvertibleFunc;
import at.ac.tuwien.big.vmodel.general.VEditableAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;
import at.ac.tuwien.big.vmodel.general.WrappedEditableIntegerValueElement;
import at.ac.tuwien.big.xtext.equalizer.Creater;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class SimpleAbstractDelegatingVList<X,E extends EditableIntegerValueElement, 
	F extends VEntryIterableFunc<Treepos,? extends VEntryIterableFunc<X,E>>> extends 
	SimpleAbstractDelegatingVAssoc<Treepos,X,E,F>
	implements VEditableList<X,E>, AbstractDelegatingEditableVAssoc<Treepos,X,E,F> {
	
	public String toString() {
		return String.valueOf(base1Func());
	}
	
	private ListEditState editState;

	public SimpleAbstractDelegatingVList(
			VContainer cont,
			F func1) {
		super(cont,func1);
		editState = new SimpleListEditState();
	}
	

	public static<X,E extends EditableIntegerValueElement,F extends VEntryIterableFunc<Treepos,? extends VEntryIterableFunc<X,E>>> 
		SimpleAbstractDelegatingVList<X,E,F> createListFrom(F func) {
		return new SimpleAbstractDelegatingVList<>(func.store(),func);
	}
	

	public static<X> SimpleAbstractDelegatingVList<X,EditableIntegerValueElement,?> createBasicList(VContainer cont) {
		VFunc<?, ?> func[] = new VFunc[3];
		VEntryIterableFunc<Treepos,VEditableBag<X,EditableIntegerValueElement>> func1 = 
				new SimpleVFunc<Treepos,VEditableBag<X,EditableIntegerValueElement>>(cont.createChild("func1"), 
						(x)->{
							//System.out.println("Cont: "+cont);
							return new SimpleBag<X,EditableIntegerValueElement>(cont.createChild("bag1"+func[0].getEditState().advEditId()),
									(y)->new SimpleIntegerValueElement(cont.createChild("func1int"+func[0].getEditState().advEditId())));
						});
							
		func[0] = func1;/*
		VEntryIterableFunc<X,VPosEditBag<EditableIntegerValueElement>> func2 = null;
		func2 = new SimpleVFunc<X,VPosEditBag<EditableIntegerValueElement>>(cont.createChild("func2"), 
							(x)->new SimplePosEditBag<EditableIntegerValueElement>(
									cont.createChild("bag2"+func[1].getEditState().advEditId()),
									((VEditableList<?,?>)func[2]),
									(y)->new SimpleIntegerValueElement(cont.createChild("func1int"+func[1].getEditState().advEditId()))));
		
		func[1] = func2;*/
		SimpleAbstractDelegatingVList<X, EditableIntegerValueElement,?> ret = new SimpleAbstractDelegatingVList<>(cont,
				func1);
		func[2] = ret; 
		return ret; 
	}
	
	@Override
	public ListEditState getEditState() {
		return editState;
	}

	/*
	public static<X> VEditableList<X,?> getSimpleVList(VContainer cont) {
		return VEditableList.ensureEditableList(new SimpleVFunc<>(cont, (x)->new SimpleVFunc<>(cont.createNewChild(), (y)->new SimpleIntegerValueElement(cont.createNewChild()))));
	}*/


	/**Size von der Assoc*/
	public static<X> VEditableList<X,?> getExtension(VContainer cont, 
			VEntryIterableFunc<X, ? extends EditableIntegerValueElement> prescribedContent) {
		
		VEditableBag<X, ? extends EditableIntegerValueElement> baseBag = VEditableBag.ensureBag(prescribedContent);
		
		VEditableList<X, ?>[] retList = new VEditableList[1];
		
		VEntryIterableFunc<X, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>> func =
				new SimpleWrapFunc<>(cont.createChild("wrapper"),
						new DoubleParameterIFace<X, EditableIntegerValueElement, VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>>() {

							@Override
							public VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement> get(X x,
									EditableIntegerValueElement y) {
								//TODO: Die Methode muss man speichern können
								return new VEntryIterableFunc<Treepos, EditableIntegerValueElement>() {
									
									private Treepos mine;
									private int curMax = 0;
									private HashMap<Treepos, EditableIntegerValueElement> cache = new HashMap<>();
									{
										
									}
									
									public String toString() {
										return "Value "+y+", treepos: "+String.valueOf(mine);
									}
									
									SimpleIntegerValueElement recallE = new SimpleIntegerValueElement(store().createNewChild());

									@Override
									public EditableIntegerValueElement get(Treepos x) {
										EditableIntegerValueElement ret = cache.get(x);
										if (ret == null) {
										ret = new EditableIntegerValueElement() {
											
											private int fakeValue;
											
											public String toString() {
												return fakeValue+" ("+y.toString()+")";
											}
											
											VContainer store = y.store().createNewChild();
											
											@Override
											public VContainer store() {
												return store;
											}
											
											@Override
											public void destroy() {
											}
											
											@Override
											public boolean selfClear() {
												return false;
											}
											
											@Override
											public boolean isSelfEmpty() {
												return false;
											}
											
											@Override
											public Editstate getEditState() {
												return y.getEditState();
											}
											
											@Override
											public int getValue() {
												if (mine == null || (x != null && x.equalTreeposValue(mine))) {
													return y.getValue();
												}
												return Math.min(y.getValue(), 0);
											}
											
											@Override
											public void add(int value) {
												if (mine == null || mine.equalTreeposValue(x)) {
													y.add(value);
												}
												if (curMax == fakeValue) {
													fakeValue+= value;
													curMax+= value;
												}
												if ((mine == null && fakeValue > 0) || (fakeValue > curMax)) {
													mine = x;
													curMax = fakeValue;
												}
											}
										};
									}
									cache.put(x,ret);
									return ret;
									}

									@Override
									public boolean isSelfEmpty() {
										return false;
									}

									@Override
									public boolean selfClear() {
										return false;
									}

									@Override
									public Editstate getEditState() {
										return y.getEditState();
									}

									@Override
									public VContainer store() {
										return y.store();
									}

									@Override
									public void destroy() {
										
									}
									
									private boolean recall = false;

									@Override
									public Iterable<? extends Entry<? extends Treepos, ? extends EditableIntegerValueElement>> getEntries() {
										synchronized(this) {
											if (mine == null && !recall) {
												recall = true;
												if (y.getValue() <= 0) {
													return Collections.emptyList();
												} else {
													mine = retList[0].positionForAppend();
												}
												recall = false;
											}
										}
										return ()->new Iterator<Entry<? extends Treepos, ? extends EditableIntegerValueElement>>() {
											boolean hasNext = true;

											@Override
											public boolean hasNext() {
												return hasNext;
											}

											@Override
											public Entry<? extends Treepos, ? extends EditableIntegerValueElement> next() {
												hasNext = false;
												return new FakeEntry(mine, y);
											}
										};
									}
								};
							}
						}, baseBag);
				;
		
		VEditableList<X, ?> ret = retList[0] = VEditableList.ensureEditableList(ParameterInvertibleFunc.ensureInvertible(func).parameterInvert());
		return ret;
		
		/*VEditableList<X,WrappedEditableIntegerValueElement>[] baseList_ = new VEditableList[1]; 

		SimpleVFunc<?, ?>[] func = new SimpleVFunc[2];
		
		
		SimpleVFunc<X, VPosEditBag<WrappedEditableIntegerValueElement>> func2 = new 
				SimpleVFunc<X, VPosEditBag<WrappedEditableIntegerValueElement>>(cont.createChild("func2"), 
						(x)->{
							//The inner list is just a normal list
							Creater<EditableIntegerValueElement,Object> bagCreater = (k)->new SimpleIntegerValueElement(baseList_[0].store().createChild("creater"+baseList_[0].getEditState().advEditId()));
							
							VPosEditBag<EditableIntegerValueElement> baseFunc = new SimplePosEditBag<EditableIntegerValueElement>(cont.createChild("bag"+func[1].getEditState().advEditId()),baseList_[0],
									bagCreater);
							
							//The outer function uses the inner function and edits it
							Creater<Treepos, VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>> treeposCreater
								= (iterableFunc)-> {
									//BaseFunc contains my bag. Search for existing ones
									Treepos chosen = null;
									for (Entry<? extends Treepos, ?> entr: baseFunc.getEntries()) {
										chosen = entr.getKey();
										break;
									}
									if (chosen == null) {
										//Unfortunately it is not contained, just go somewhere
										chosen = VList.ROOT;
									}
									int idx = baseFunc.getEditState().getEditState(chosen).popIndex(TreeposType.APPEND_NEAR);
									return SimpleTreepos.staticAugmented(chosen, new SimpleTreeposValue(TreeposType.APPEND_NEAR, idx));
								};
							ParameterInvertibleFunc bla = baseList_[0].parameterInvert();
							Object paramX = x;
							VPosEditBag<WrappedEditableIntegerValueElement> xyz = VPosEditBag.ensurePosEditBag((VEntryIterableFunc)bla.get(x),baseList_[0].getEditState());
							EditableIntegerMerger<Treepos> merger = new EditableIntegerMerger<Treepos>(prescribedSize.get(x), 
									baseFunc,
									xyz,
									treeposCreater);
							
							DoubleParameterIFace<Treepos, EditableIntegerValueElement, WrappedEditableIntegerValueElement> mergeCreator = new 
									DoubleParameterIFace<Treepos, EditableIntegerValueElement, WrappedEditableIntegerValueElement>() {

										@Override
										public WrappedEditableIntegerValueElement get(Treepos x, EditableIntegerValueElement y) {
											WrappedEditableIntegerValueElement ret = 
													new WrappedEditableIntegerValueElement(cont.createChild("wrappedIntEle"+baseList_[0].getEditState().advEditId()), y);
											ret.setMerger(merger);
											return ret;
										}
									};
							
							PosMergerWrapFunc<EditableIntegerValueElement, WrappedEditableIntegerValueElement, EditableIntegerValueElement> ret = 
									new PosMergerWrapFunc<EditableIntegerValueElement, WrappedEditableIntegerValueElement, EditableIntegerValueElement>(
									cont.createChild("merger"+baseFunc.getEditState().advEditId()),
									baseFunc, baseList_[0].parameterInvert().get(x), merger, prescribedSize.get(x), mergeCreator, baseFunc.getEditState());
							
							return ret;
							
						}) {
			@Override
			public Iterable<Entry<X, VPosEditBag<WrappedEditableIntegerValueElement>>> getEntries() {
				return IteratorUtils.convert(prescribedSize.getEntries(), (x)->new FakeEntry<>(x.getKey(), get(x.getKey())));
			}
			
		};
		
		SimpleVFunc<Treepos, VEditableBag<X, WrappedEditableIntegerValueElement>> func1 = new 
				SimpleVFunc<Treepos, VEditableBag<X,WrappedEditableIntegerValueElement>>(cont.createChild("func1"), 
						(tp)->{
							return new SimpleBag<X,WrappedEditableIntegerValueElement>(cont.createChild("f1bag"+func[0].getEditState().advEditId()), 
									(x)->func2.get(x).get(tp)
									);
							
							
							
						}){
			
			@Override
			public Iterable<Entry<Treepos, VEditableBag<X, WrappedEditableIntegerValueElement>>> getEntries() {
				return super.getEntries();
			} 
			
		};
		
		func[0] = func1;
		func[1] = func2;
		
		VEditableList<X,WrappedEditableIntegerValueElement> baseList = SimpleAbstractDelegatingVList.fromInverted(cont.createChild("baseList"), 
				func2);
		baseList_[0] = baseList;
		
		return baseList;		
		//public MergerWrapFunc(VContainer cont, VEntryIterableFunc<X, Y1> base, Merger<X,Y1,YO> merger, YO target, Creater<Y2, Y1> creator) {
		*/
		
	}


	public static<X,E extends EditableIntegerValueElement>  VEditableList<X, E> fromInverted(VContainer createChild,
			VEntryIterableFunc<X, ? extends VEntryIterableFunc<Treepos, E>> func) {
		return new SimpleAbstractDelegatingVList<>(func.store(),ParameterInvertibleFunc.ensureInvertible(func).parameterInvert());
	}




	public static void main(String[] args) {
		VContainer root = new VSimpleContainer(new EditGlobalSource());
		VEditableBag<String, EditableIntegerValueElement> simpleAssoc = new SimpleBag<String, EditableIntegerValueElement>(root,
				(x)->new SimpleIntegerValueElement(root.createChild("bla")));
		VEditableList<String, ?> vlist = getExtension(root.createChild("$vlist"), simpleAssoc);
		List<String> list = vlist.asList();
		simpleAssoc.insert("Hallo!");
		System.out.println("Assoc: " + simpleAssoc.ToString());
		System.out.println(Arrays.toString(list.toArray()));
		list.remove("Hallo!");
		System.out.println("Assoc: " + simpleAssoc.ToString());
		System.out.println(Arrays.toString(list.toArray()));
		list.add("Hallo!");
		list.add("Hallo2!");
		System.out.println("Assoc: " + simpleAssoc.ToString());
		System.out.println(Arrays.toString(list.toArray()));
		
		VEditableList<String,?> blist = createBasicList(root.createNewChild());
		VEditableList<String,?> vedit = VEditableList.buildEditableDeltaList(root.createChild("bla"), vlist, blist);
		VEditableList<String,?> bedit = VEditableList.buildEditableDeltaList(root.createChild("bla"), blist, vlist);
		List<String> thenList = vedit.asList();
		List<String> thenList2 = bedit.asList();
		thenList.add("Added!");
		thenList.add("Added2!");
		System.out.println(Arrays.toString(thenList.toArray()));
		System.out.println(Arrays.toString(thenList2.toArray()));
		thenList2.remove("Added2!");
		System.out.println(Arrays.toString(thenList.toArray()));
		System.out.println(Arrays.toString(thenList2.toArray()));
		thenList.remove("Added2!");
		System.out.println(Arrays.toString(thenList.toArray()));
		System.out.println(Arrays.toString(thenList2.toArray()));
		vlist.clear();
		System.out.println(Arrays.toString(thenList.toArray()));
		System.out.println(Arrays.toString(thenList2.toArray()));
		thenList.add("Added!");
		thenList.add("Added2!");
		System.out.println(Arrays.toString(thenList.toArray()));
		System.out.println(Arrays.toString(thenList2.toArray()));
		
	}
}
