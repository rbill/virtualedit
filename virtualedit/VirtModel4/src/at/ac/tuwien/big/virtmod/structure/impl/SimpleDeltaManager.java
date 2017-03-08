package at.ac.tuwien.big.virtmod.structure.impl;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.virtmod.structure.ConverterAction;
import at.ac.tuwien.big.virtmod.structure.DeltaManager;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.general.DeltaBuilt;
import at.ac.tuwien.big.vmodel.general.DeltaCreater;
import at.ac.tuwien.big.vmodel.general.VAssoc;
import at.ac.tuwien.big.vmodel.general.VBag;
import at.ac.tuwien.big.vmodel.general.VEditableAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleBag;
import at.ac.tuwien.big.vmodel.general.impl.SimpleDeltaVFunc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleVFunc;

public class SimpleDeltaManager implements DeltaManager {

	protected SimpleDeltaManager() {
		
	}
	

	private List<ConverterAction> converterActions = new ArrayList<ConverterAction>();
	
	public void addAction(ConverterAction action) {
		this.converterActions.add(action);
	}
	/*
	public static ConverterAction<VEditableList<?,?>> VLIST_CONVERTER = new ConverterAction<VEditableList<?,?>>() {
		
		@Override
		public boolean matches(Object edit, Object base) {
			return base instanceof VList;
		}
		
		public VEditableList initialize(VContainer root) {
			return SimpleAbstractDelegatingVList.createBasicList(root);
		}
		
		@Override
		public VEditableList<?,?> convert(DeltaManager manager, VContainer delta, VContainer edit, VContainer base, Object editObj, Object baseObj) {
			VEntryIterableFunc baseList = (VEntryIterableFunc)baseObj;
			VEntryIterableFunc editList;
			if (editObj instanceof VEntryIterableFunc) {
				editList = (VEntryIterableFunc)editObj;
			} else {
				//Create new VList
				editList = initialize(edit);
				edit.initObject(editList);
			}
			SimpleDeltaVFunc.simpleEditableBaseDF(delta, editList, baseList));
			return vList;
		}
	};
	
	public static ConverterAction<VEditableAssoc<?,?,?>> VASSOC_CONVERTER = new ConverterAction<VEditableAssoc<?, ?, ?>>() {
		
		@Override
		public boolean matches(Object edit, Object base) {
			return base instanceof VAssoc;
		}
		

		public VEditableAssoc initialize(VContainer root) {
			return SimpleAbstractDelegatingVAssoc.createBasicAssoc(root);
		}
		
		@Override
		public VEditableAssoc<?, ?, ?> convert(DeltaManager manager, VContainer delta, VContainer edit, VContainer base, Object editObj, Object baseObj) {
			VEntryIterableFunc baseList = (VEntryIterableFunc)baseObj;
			VEntryIterableFunc editList;
			if (editObj instanceof VEditableAssoc) {
				editList = (VEditableAssoc)editObj;
			} else {
				//Create new VList
				editList = initialize(edit);
				edit.initObject(editList);
			}
			VEditableAssoc<?, ?, ?> vList = SimpleAbstractDelegatingVAssoc.simpleEditableBase(SimpleDeltaVFunc.simpleEditableBaseDF(delta, editList, baseList));
			return vList;
		}
	}; 
	

	public static ConverterAction<VEditableBag<?,?>> VBAG_CONVERTER = new ConverterAction<VEditableBag<?, ?>>() {
		
		@Override
		public boolean matches(Object edit, Object base) {
			return base instanceof VBag;
		}
		

		public VEditableBag<?,?> initialize(VContainer root) {
			return SimpleBag.createBasicBag(root);
		}
		
		@Override
		public VEditableBag<?, ?> convert(DeltaManager manager, VContainer delta, VContainer edit, VContainer base, Object editObj, Object baseObj) {
			VBag baseList = (VBag)baseObj;
			VEditableBag<?, ?> editList;
			if (editObj instanceof VEditableBag) {
				editList = (VEditableBag)editObj;
			} else {
				//Create new VList
				editList = initialize(edit);
				edit.initObject(editList);
			}
			VEditableBag<?, ?> vList = SimpleDeltaVBag.editableBase(delta, editList, baseList);
			return vList;
		}
	}; */
	public static ConverterAction<VEntryIterableFunc<?,?>> VENTRYITERABLE_CONVERTER = new ConverterAction<VEntryIterableFunc<?, ?>>() {
		
		@Override
		public boolean matches(Object edit, Object base) {
			return base instanceof VEntryIterableFunc;
		}
		

		public VEntryIterableFunc<?,?> initialize(VContainer root) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public VEntryIterableFunc<?, ?> convert(DeltaManager manager, VContainer delta, VContainer edit, VContainer base, Object editObj, Object baseObj) {
			VEntryIterableFunc baseList = (VEntryIterableFunc)baseObj;
			VEntryIterableFunc<?, ?> editList;
			if (editObj instanceof VEntryIterableFunc) {
				editList = (VEntryIterableFunc)editObj;
			} else {
				//TODO: If I would have a metamodel, everything would be fine, then initialization would be redirected to the
				//metamodel
				editList = initialize(edit);
				edit.initObject(editList);
			}
			VEntryIterableFunc<?, ?>  vList = SimpleDeltaVFunc.simpleEditableBaseDynamic(delta, editList, baseList);
			return vList;
		}
	};

	public static ConverterAction<VFunc<String,?>> VFUNC_CONVERTER = new ConverterAction<VFunc<String, ?>>() {
		
		@Override
		public boolean matches(Object edit, Object base) {
			return base instanceof VFunc;
		}
		
	
		@Override
		public VFunc<String, ? extends VObject> convert(DeltaManager manager, VContainer delta, VContainer edit, VContainer base, Object editObj, Object baseObj) {
			VFunc<String, ? extends VObject> baseList = (VFunc)baseObj;
			VFunc<String, ? extends VObject> editList;
			if (editObj instanceof VFunc) {
				editList = (VFunc)editObj;
			} else {
				//Create new VList
				new Exception().printStackTrace();
				throw new RuntimeException("Unfortunately this is not yet implemented");
				//editList = initialize(manager,edit);
				//edit.initObject(editList);
			}
			VFunc<String, ? extends VObject> vList = new SimpleDeltaVFunc(delta,editList,baseList, new SimpleVFunc<String,VObject>(delta.createChild("$store"),
					(x)->{
				return manager.createObject(delta.createChild(x),
						editList.get(x).store(), baseList.get(x).store());
			}),
						new DeltaCreater<VObject, VObject, DeltaBuilt<VObject,VObject>>() {

							@Override
							public DeltaBuilt<VObject, VObject> create(VObject edit, VObject base) {
								return (DeltaBuilt)manager.createObject(delta.createChild(edit.store().parentLoc().name()),
										edit.store(), base.store());
							}
							
						}
					);
			return vList;
		}


		@Override
		public VFunc<String, ?> initialize(VContainer cont) {
			throw new RuntimeException("Operation not implemented");
		}
	}; 
	
	
	public static SimpleDeltaManager createDefaultManager() {
		SimpleDeltaManager ret = new SimpleDeltaManager();

		ret.addAction(VENTRYITERABLE_CONVERTER);
		
		
		
		return ret;
	}

	@Override
	public VObject createObject(VContainer delta, VContainer edit, VContainer base, VObject editObj, VObject baseObj) {
		if (baseObj == null) {
			return editObj;
		}
		for (ConverterAction<? extends VObject> act: converterActions) {
			if (act.matches(editObj, baseObj)) {
				return act.convert(this,delta,edit, base, editObj, baseObj);
			}
		}
		System.out.println("No match found for edit " + editObj+", base "+baseObj+" in container "+delta.getObjectRef().toString());
		return null;
	}

}
