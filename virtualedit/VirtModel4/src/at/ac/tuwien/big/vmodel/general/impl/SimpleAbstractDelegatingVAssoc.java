package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.AbstractDelegatingEditableVAssoc;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.OwnedFunc;
import at.ac.tuwien.big.vmodel.general.ParameterInvertibleFunc;
import at.ac.tuwien.big.vmodel.general.StaticElement;
import at.ac.tuwien.big.vmodel.general.VEditableAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.VPosEditBag;
import at.ac.tuwien.big.xtext.equalizer.Creater;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class SimpleAbstractDelegatingVAssoc<X,Y,E extends EditableIntegerValueElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,E>>> 
	 extends SourcedObject implements VEditableAssoc<X,Y,E>, AbstractDelegatingEditableVAssoc<X,Y,E,F> {
	
	protected F func;

	public SimpleAbstractDelegatingVAssoc(VContainer cont, F func) {
		super(cont);
		this.func = func;
	}
	
	public F base1Func() {
		return func;
	}

	public static<X,Y,E extends EditableIntegerValueElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,E>>>  
		SimpleAbstractDelegatingVAssoc<X,Y, E,F> createAssocFrom(F func) {
		return new SimpleAbstractDelegatingVAssoc<>(func.store(),func);
	}


	public static<X,Y> SimpleAbstractDelegatingVAssoc<X,Y, EditableIntegerValueElement,?> createBasicAssoc(VContainer cont) {
		VFunc<?, ?> func[] = new VFunc[3];/*
		VEntryIterableFunc<Y,VEditableBag<X,EditableIntegerValueElement>> func2 = 
				new SimpleVFunc<Y,VEditableBag<X,EditableIntegerValueElement>>(cont.createChild("func1"), 
						(x)->{
							//System.out.println("Cont: "+cont);
							return new SimpleBag<X,EditableIntegerValueElement>(cont.createChild("bag1"+func[0].getEditState().advEditId()),
									(y)->new SimpleIntegerValueElement(cont.createChild("func1int"+func[0].getEditState().advEditId())));
						});*/
							
		
		VEntryIterableFunc<X,VEditableBag<Y,EditableIntegerValueElement>> func1 = null;
		func1 = new SimpleVFunc<X,VEditableBag<Y,EditableIntegerValueElement>>(cont.createChild("func2"), 
							(x)->new SimpleBag<Y,EditableIntegerValueElement>(
									cont.createChild("bag2"+func[0].getEditState().advEditId()),
									(y)->new SimpleIntegerValueElement(cont.createChild("func1int"+func[0].getEditState().advEditId()))));
		func[0] = func1;
		//func[1] = func2;
		SimpleAbstractDelegatingVAssoc<X, Y, EditableIntegerValueElement,?> ret = new SimpleAbstractDelegatingVAssoc<>(cont,
				func1);
		func[2] = ret; 
		return ret;
	}

	public static ParameterInvertibleFunc<String, String, VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>> createTokenAssoc(
			VContainer assocCont) {
		VEntryIterableFunc<String,VEntryIterableFunc<String,VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>>> func1 = 
				new SimpleVFunc<>(assocCont, new Creater<VEntryIterableFunc<String,VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>>, String>() {

					@Override
					public VEntryIterableFunc<String, VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>> create(
							String forValue) {
							return new SimpleVFunc<String, VEntryIterableFunc<Long,? extends EditableIntegerValueElement>>(assocCont.createChild(forValue), new Creater<VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>, String>() {

								@Override
								public VEntryIterableFunc<Long, ? extends EditableIntegerValueElement> create(
										String forValue2) {
									return new SimpleVFunc<>(
											assocCont.createChild(forValue).createChild(forValue2), 
											(x)->new SimpleIntegerValueElement(assocCont.createChild(forValue).createChild(forValue2).createChild(String.valueOf(x))));
								}
							
							});
						}
				})
				;
		return ParameterInvertibleFunc.ensureInvertible(func1);
	}
}
