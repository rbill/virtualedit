package at.ac.tuwien.big.vmodel.general;

import java.util.Map.Entry;
import java.util.UUID;
import java.util.Arrays;
import java.util.List;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.impl.EditGlobalSource;
import at.ac.tuwien.big.virtmod.structure.impl.VSimpleContainer;
import at.ac.tuwien.big.vmodel.general.impl.FakeEntry;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleDualBagFunc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleVFunc;
import at.ac.tuwien.big.xtext.equalizer.Creater;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public abstract class MergedFunc<X,Y,Y1,Y2> implements VEntryIterableFunc<X, Y> {
	
	abstract VEntryIterableFunc<X, ? extends Y1> mainFunc();
	
	abstract VEntryIterableFunc<X, ? extends Y2> helperFunc();
	
	abstract DoubleCreater<? super Y1, ? super Y2, ? extends Y> creater();
	
	public static<X> VEditableBag<Treepos, ?> bagExtension(VReusableBag<X, ?> bag,
			VEntryIterableFunc<X, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>> y
			) { 
		Creater<X, Treepos> locationCreater = new Creater<X, Treepos>() {
			@Override
			public X create(Treepos forValue) {
				return bag.insertEntry();
			}
		};
		SimpleDualBagFunc<X,Treepos> dualFunc = SimpleDualBagFunc.idTreeposFuncRev(y, locationCreater);
		VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement> vl = 
		
		//Z ist ein Filter
		new VEditableBag<Treepos, EditableIntegerValueElement>() {

			@Override
			public EditableIntegerValueElement get(Treepos pos) {
				X x = dualFunc.getInv(pos);
				if (x == null) {
					//Soll NICHT eingefügt werden
					//dualFunc.set(dualFunc.chooserX().create(pos),pos);
					//Ich brauche einen Index, den ich noch nicht kenne
					for (Entry<? extends X, ? extends EditableIntegerValueElement> entr: bag.getEntries()) {
						Treepos tp = dualFunc.get(entr.getKey());
						if (tp == null) {
							//index gefunden!
							dualFunc.set(entr.getKey(), pos);
							return entr.getValue();
						}
					}
					//Es gibt keinen Index, den ich noch nicht kenne
					for (;;) {
						X entr = bag.insertEntry();
						Treepos tp = dualFunc.get(entr);
						if (tp == null) {
							//index gefunden!
							dualFunc.set(entr, pos);
							return bag.get(entr);
						}
					}
					
				}
				return bag.get(x);
			}

			@Override
			public boolean isSelfEmpty() {
				return bag.isSelfEmpty();
			}

			@Override
			public boolean selfClear() {
				return bag.selfClear();
			}

			@Override
			public Editstate getEditState() {
				return bag.getEditState();
			}

			@Override
			public VContainer store() {
				return bag.store().createChild("sub");
			}

			@Override
			public void destroy() {
				bag.destroy();
			}

			@Override
			public Iterable<? extends Entry<? extends Treepos, ? extends EditableIntegerValueElement>> getEntries() {
				return IteratorUtils.<Entry<? extends X,? extends EditableIntegerValueElement>,
						Entry<? extends Treepos, ? extends EditableIntegerValueElement>>convert(bag.getEntries(),
						(entr)->{
					Treepos realPos = dualFunc.get(entr.getKey());
					if (realPos == null) {
						//Hier ist es ok: Wenn ich keine Position habe, dann lege ich mir eine an, aber das heißt nicht, dass ich etwas hinzufüge!
						realPos = dualFunc.chooserY().create(entr.getKey());
						dualFunc.set(entr.getKey(), realPos);
					}
					return new FakeEntry<>(realPos,entr.getValue()); 
				});						
			}
			

			@Override
			public Iterable<? extends Entry<? extends Treepos, ? extends EditableIntegerValueElement>> getExistingEntries() {
				return IteratorUtils.<Entry<? extends X,? extends EditableIntegerValueElement>,
						Entry<? extends Treepos, ? extends EditableIntegerValueElement>>convert(bag.getExistingEntries(),
						(entr)->{
					Treepos realPos = dualFunc.get(entr.getKey());
					return new FakeEntry<>(realPos,entr.getValue()); 
				});
						
			}

		};
		return VEditableBag.ensureBag(vl);
	}
	
	
	
	public static<Y,Z> VEditableList<Y,?> listExtension(
				VEntryIterableFunc<Y,? extends VEntryIterableFunc<Z, ? extends EditableIntegerValueElement>> bag,
				VEntryIterableFunc<Y, ? extends VEntryIterableFunc<Z, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>>> position,
				Creater<Creater<Z,Void>,Void> zcreatercreater		
			
			) {
		VEntryIterableFunc<Y, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>> retFunc = 
				MergedFunc.<Y,VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>,
				VEntryIterableFunc<Z, ? extends EditableIntegerValueElement>,VEntryIterableFunc<Z, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>>>
		mergedFunc(
				bag,position,(x,y)->bagExtension(VReusableBag.ensureReusableBag(x,zcreatercreater.create(null)), y));
		return VEditableList.ensureEditableList(ParameterInvertibleFunc.ensureInvertible(retFunc).parameterInvert());
	}
	
	/*;*/
	
				
	
	public static<X,Y,Y1,Y2> MergedFunc<X,Y,Y1,Y2> 
	mergedFunc(VEntryIterableFunc<X, ? extends Y1> mainFunc, VEntryIterableFunc<X, ? extends Y2> helperFunc, DoubleCreater<? super Y1, ? super Y2, ? extends Y> creater) {
		return new MergedFunc<X, Y, Y1, Y2>() {
			
			@Override
			VEntryIterableFunc<X, ? extends Y1> mainFunc() {
				return mainFunc;
			}
			
			@Override
			VEntryIterableFunc<X, ? extends Y2> helperFunc() {
				return helperFunc;
			}
			
			@Override
			DoubleCreater<? super Y1, ? super Y2, ? extends Y> creater() {
				return creater;
			}
		};
	}
		
			
	
	public static<X,Y,Z,Z1,Z2> MergedFunc<X,VEntryIterableFunc<Y, Z>,VEntryIterableFunc<Y, Z1>, VEntryIterableFunc<Y, Z2>> 
		nestedFunc(VEntryIterableFunc<X, ? extends VEntryIterableFunc<Y, Z1>> mainFunc, VEntryIterableFunc<X, ? extends VEntryIterableFunc<Y, Z2>> helperFunc,
				DoubleCreater<Z1, Z2, Z> creater) {
					return new MergedFunc<X, VEntryIterableFunc<Y,Z>, VEntryIterableFunc<Y,Z1>, VEntryIterableFunc<Y,Z2>>() {
						
						@Override
						VEntryIterableFunc<X, VEntryIterableFunc<Y, Z1>> mainFunc() {
							return (VEntryIterableFunc)mainFunc;
						}
						
						@Override
						VEntryIterableFunc<X, VEntryIterableFunc<Y, Z2>> helperFunc() {
							return (VEntryIterableFunc)helperFunc;
						}
						
						@Override
						DoubleCreater<VEntryIterableFunc<Y, Z1>, VEntryIterableFunc<Y, Z2>, VEntryIterableFunc<Y, Z>> creater() {
							return (f1,f2)->mergedFunc(f1,f2,creater);
						}
					};
	}
		
	
	@Override
	public Y get(X x) {
		return creater().create(mainFunc().get(x), helperFunc().get(x));
	}

	@Override
	public boolean isSelfEmpty() {
		return mainFunc().isSelfEmpty();
	}

	@Override
	public boolean selfClear() {
		return mainFunc().selfClear();
	}

	@Override
	public Editstate getEditState() {
		return mainFunc().getEditState();
	}

	@Override
	public VContainer store() {
		return mainFunc().store();
	}

	@Override
	public void destroy() {
		mainFunc().destroy();
	}

	@Override
	public Iterable<? extends Entry<? extends X, Y>> getEntries() {
		return IteratorUtils.convert(mainFunc().getEntries(), (x)->new FakeEntry<>(x.getKey(), get(x.getKey())));
	}

	public static Creater<Creater<Long,Void>,Void> DEFAULT_CREATER = (z)->new Creater<Long,Void>() {
		long curIndex = 0;
		@Override
		public Long create(Void forValue) {
			return ++curIndex;
		}
	};
	
	public static<X> VEditableList<String, ?> defaultExtension(VEditableAssoc<String, Long, ? extends EditableIntegerValueElement> bagAssoc, VContainer cont) {
		 VEntryIterableFunc<String, VEntryIterableFunc<Long, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>>> extension1 = new SimpleVFunc<>(cont,
				 new Creater<VEntryIterableFunc<Long, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>>, String>() {

					@Override
					public VEntryIterableFunc<Long, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>> create(String forValue) {
						return SimpleAbstractDelegatingVList.<Long>createBasicList(cont.createChild(forValue)).parameterInvert();
					}
				});
		return MergedFunc.listExtension(bagAssoc, 
				extension1, DEFAULT_CREATER);
	}
	
	public static void main(String[] args) {

		 GlobalSource gs = new EditGlobalSource();
		 VContainer rootCont = new VSimpleContainer(gs);
		 VEditableAssoc<String, Long, EditableIntegerValueElement> bagAssoc = SimpleAbstractDelegatingVAssoc.createBasicAssoc(rootCont.createChild("assoc"));
		 VContainer childCont1 = rootCont.createChild("extension1");
		 VContainer childCont2 = rootCont.createChild("extension2");

		 VEditableList<String, ?> ext1List = defaultExtension(bagAssoc, childCont1);
		 VEditableList<String, ?> ext2List = defaultExtension(bagAssoc, childCont2);
		 List<String> ext1L = ext1List.asList();
		 List<String> ext2L = ext2List.asList();
		 ext1L.add("Hallo!");
		 System.out.println("Ext1: " +Arrays.toString(ext1L.toArray()));
		 ext1L.add("Hallo2!");
		 System.out.println("Ext1: " +Arrays.toString(ext1L.toArray()));
		 ext1L.remove("Hallo!");
		 System.out.println("Ext1: " +Arrays.toString(ext1L.toArray()));
		 ext1L.add("Hallo3!");
		 System.out.println("Ext1: " +Arrays.toString(ext1L.toArray())); 

		 System.out.println("Ext2: " +Arrays.toString(ext2L.toArray()));
		 ext2L.add("Added!");
		 System.out.println("Ext1: " +Arrays.toString(ext1L.toArray()));
		 System.out.println("Ext2: " +Arrays.toString(ext2L.toArray()));
		 ext2L.add("Added2!");
		 System.out.println("Ext1: " +Arrays.toString(ext1L.toArray()));
		 System.out.println("Ext2: " +Arrays.toString(ext2L.toArray()));
		 
	}
	
}
