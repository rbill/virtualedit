package at.ac.tuwien.big.vmodel.ecore.impl;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import at.ac.tuwien.big.vmodel.general.VFunc;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.ecore.VFeatureValues;
import at.ac.tuwien.big.vmodel.ecore.VObjectValues;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.MergedFunc;
import at.ac.tuwien.big.vmodel.general.ParameterInvertibleFunc;
import at.ac.tuwien.big.vmodel.general.SourcedList;
import at.ac.tuwien.big.vmodel.general.VAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEditableList;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleVFunc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleVListList;

public class ContainerFeatureValue<T> implements VFeatureValues {
	
	private VContainer cont;
	private ParameterInvertibleFunc<String, String, 
		VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>> assoc;
	private VFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>> contFunc;
	private boolean isInverse;
	private boolean isContainment;
	
	
	
	public ContainerFeatureValue(VContainer cont, VContainer assocCont, boolean isInverse, boolean isContainment) {
		this.cont = cont;
		if (assocCont != null) {
			if (assocCont.object() != null) {
				this.assoc = ParameterInvertibleFunc.ensureInvertible((VEntryIterableFunc)assocCont.object());
			} else {
				this.assoc = SimpleAbstractDelegatingVAssoc.createTokenAssoc(assocCont);
				if (isInverse){
					this.assoc = this.assoc.parameterInvert();
				}
			}
		}
		if (cont != null) {
			if (cont.object() != null) {
				contFunc = (VFunc)cont.object();
			} else {
				contFunc = (VFunc)(VFunc<String, VEditableList<String, ? extends EditableIntegerValueElement>>) 
						new SimpleVFunc<String,VEditableList<String, ? extends EditableIntegerValueElement>>(cont, (uuid)-> {
					VContainer child = cont.createChild(uuid);
					if (assoc != null) {
						return MergedFunc.defaultExtension(VEditableAssoc.<String,Long,EditableIntegerValueElement>ensureEditableAssocE(this.assoc.get(uuid)), child);
						//return (VEditableList)SimpleAbstractDelegatingVList.<String>getExtension(child, this.assoc.get(uuid));
					} else {
						return SimpleAbstractDelegatingVList.createBasicList(child);
					}
				});
			}
		}
		this.isInverse = isInverse;
		this.isContainment = isContainment;
	}
	
	
	private VObject getVList(String uuid) {
		return contFunc.get(uuid);
	}
	
	@Override
	public List<Object> getValueList(String uuid) {
		VObject ret = getVList(uuid);
		if (ret instanceof VEntryIterableFunc) {
			return VEditableList.ensureEditableList(((VEntryIterableFunc) ret)).asList();
		}
		System.err.println("Expected VList, got " + ret+ " for uuid "+uuid);
		return Collections.emptyList();
	}

	@Override
	public Iterable<? extends String> getValueListInv(String uuid) {
		return assoc.parameterInvert().get(uuid).getKeys();
	}

	@Override
	public List<? extends Iterable<? extends ElementSourceInfo>> getSource(String uuid) {
		List<Iterable<? extends ElementSourceInfo>> ret = new ArrayList<Iterable<? extends ElementSourceInfo>>();
		List<Object> vll = getValueList(uuid);
		if (vll instanceof SourcedList) {
			return ((SourcedList)vll).getSources();
		}
		return ret;
	}

	@Override
	public void selfClear(Set<String> allIds) {
		if (assoc != null) {
			assoc.selfClear();
		}
		for (String uuid: allIds) {
			((VEditableList)getVList(uuid)).selfClear();
		}
	}


	@Override
	public void selfClear() {
		if (assoc != null) {
			assoc.selfClear();
		}
		/*
		if (contFunc instanceof VEntryIterableFunc) {
			VEntryIterableFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>> vfunc = (VEntryIterableFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>>)contFunc;
			for (VEditableList<T, ? extends EditableIntegerValueElement> vl: vfunc.getValues()) {
				vl.selfClear();
			}
		} else {
			System.err.println("Could not clear: contFunc is no list!");
		}*/
	}


	@Override
	public void removeClear() {
		if (assoc != null) {
			for (VEntryIterableFunc<?, VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>> entr: assoc.getValues()) {
				for (VEntryIterableFunc<Long, ? extends EditableIntegerValueElement> func: entr.getValues()) {
					VEditableBag.ensureBag(func).clear();
				}
			}
		}/*
		if (contFunc instanceof VEntryIterableFunc) {
			VEntryIterableFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>> vfunc = (VEntryIterableFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>>)contFunc;
			for (VEditableList<T, ? extends EditableIntegerValueElement> vl: vfunc.getValues()) {
				vl.removeClear();
			}
		} else {
			System.err.println("Could not clear: contFunc is no list!");
		}*/
	}
	

	@Override
	public void nullifyClear() {
		if (assoc != null) {
			for (VEntryIterableFunc<?, VEntryIterableFunc<Long, ? extends EditableIntegerValueElement>> entr: assoc.getValues()) {
				for (VEntryIterableFunc<Long, ? extends EditableIntegerValueElement> func: entr.getValues()) {
					VEditableBag.ensureBag(func).nullifyClear();
				}
			}
		}/*
		if (contFunc instanceof VEntryIterableFunc) {
			VEntryIterableFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>> vfunc = (VEntryIterableFunc<String, VEditableList<T, ? extends EditableIntegerValueElement>>)contFunc;
			for (VEditableList<T, ? extends EditableIntegerValueElement> vl: vfunc.getValues()) {
				vl.nullifyClear();
			}
		} else {
			System.err.println("Could not clear: contFunc is no list!");
		}*/
	}
}
