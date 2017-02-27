package at.ac.tuwien.big.vmodel.general.impl;

import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.AbstractDelegatingVBag;
import at.ac.tuwien.big.vmodel.general.Chooser;
import at.ac.tuwien.big.vmodel.general.DelegatingFunc;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.ParameterInvertibleFunc;
import at.ac.tuwien.big.vmodel.general.SimpleDualFunc;
import at.ac.tuwien.big.vmodel.general.VAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.xtext.equalizer.Creater;

public interface SimpleDualBagFunc<X,Y> extends SimpleDualFunc<X, Y> {
	
	public VFunc<X, ? extends VEntryIterableFunc<Y, ? extends EditableIntegerValueElement>> baseFunc();
	
	public VFunc<Y, ? extends VEntryIterableFunc<X, ? extends EditableIntegerValueElement>> baseFuncInv();
	
	public Chooser<Y,X> chooserY();
	
	public Chooser<X,Y> chooserX();
	
	public static<X,Y> SimpleDualBagFunc<X,Y> getFunc(ParameterInvertibleFunc<X, Y, ? extends EditableIntegerValueElement> baseFunc, Chooser<Y,X> chooserY, Chooser<X,Y> chooserX) {
		return new SimpleDualBagFunc<X, Y>() {
			@Override
			public VFunc<X, ? extends VEntryIterableFunc<Y, ? extends EditableIntegerValueElement>> baseFunc() {
				return baseFunc;
			}

			@Override
			public VFunc<Y, ? extends VEntryIterableFunc<X, ? extends EditableIntegerValueElement>> baseFuncInv() {
				return baseFunc.parameterInvert();
			}

			@Override
			public Chooser<Y, X> chooserY() {
				return chooserY;
			}

			@Override
			public Chooser<X, Y> chooserX() {
				return chooserX;
			}
		};
	}
	
	public static<X> SimpleDualBagFunc<X, Treepos> idTreeposFuncRev(VEntryIterableFunc<X, ? extends VEntryIterableFunc<Treepos, ? extends EditableIntegerValueElement>> base,
			Creater<X, Treepos> creater) {
		ParameterInvertibleFunc<X, Treepos, ? extends EditableIntegerValueElement> piv = ParameterInvertibleFunc.ensureInvertible(base);
		VEditableList<X, ? extends EditableIntegerValueElement> list = VEditableList.ensureEditableList(piv.parameterInvert());
		return SimpleDualBagFunc.<X, Treepos>getFunc(piv,new Chooser<Treepos,X>() {
			
					@Override
					public Treepos chooseOrNull(X forValue, Iterable<? extends Treepos> iterable) {
						Treepos ret = null;
						for (Treepos cmp: iterable) {
							if (ret == null || cmp.compareTo(ret) < 0) {
								ret = cmp;
							}
						}						
						return ret;
					}
					
					@Override
					public Treepos create(X forValue) {
						Treepos ret = list.append(forValue);
						System.out.println("Created "+ret+" for "+forValue);
						return ret;
					}
			
		},new Chooser<X, Treepos>() {

					@Override
					public X chooseOrNull(Treepos forValue, Iterable<? extends X> iterable) {
						//Return an arbitrary position?
						for (X ret: iterable) {
							return ret;
						}
						
						return null;
					}
					
					@Override
					public X create(Treepos forValue) {
						X ret = creater.create(forValue);
						System.out.println("Created "+ret+" for "+forValue);
						return ret;
					}
				});
	}
	
	public static<X> SimpleDualBagFunc<X, Treepos> idTreeposFunc(VEntryIterableFunc<Treepos, ? extends VEntryIterableFunc<X, ? extends EditableIntegerValueElement>> base,
			Creater<X, Treepos> creater) {
		VEditableList<X, ? extends EditableIntegerValueElement> list = VEditableList.ensureEditableList(base);
		return SimpleDualBagFunc.<X, Treepos>getFunc(list.parameterInvert(),new Chooser<Treepos,X>() {

			@Override
			public Treepos chooseOrNull(X forValue, Iterable<? extends Treepos> iterable) {
				Treepos ret = null;
				for (Treepos cmp: iterable) {
					if (ret == null || cmp.compareTo(ret) < 0) {
						ret = cmp;
					}
				}						
				return ret;
			}
			
			@Override
			public Treepos create(X forValue) {
				Treepos ret = list.append(forValue);
				System.out.println("In " + this+": Created "+ret+" for "+forValue);
				return ret;
			}
				},new Chooser<X, Treepos>() {

					@Override
					public X chooseOrNull(Treepos forValue, Iterable<? extends X> iterable) {
						//Return an arbitrary position?
						for (X ret: iterable) {
							return ret;
						}
						
						return null;
					}
					
					@Override
					public X create(Treepos forValue) {
						X ret = creater.create(forValue);
						System.out.println("In " + this+": Created "+ret+" for "+forValue);
						return ret;
					}
				});
	}
	
	public default X getInv(Y val)  {
		VEditableBag<X, ?> bag = VEditableBag.ensureBag(baseFuncInv().get(val));
		X ret = chooserX().chooseOrNull(val,bag.getExistingKeys());
		return ret;
	}
	
	public default Y get(X x) {
		VEditableBag<Y, ?> bag = VEditableBag.ensureBag(baseFunc().get(x));		
		Y ret = chooserY().chooseOrNull(x,bag.getExistingKeys());
		return ret;
	}
	
	public default void set(X x, Y y) {
		VEditableBag.ensureBag(baseFunc().get(x)).setTo(y);
	}


}
