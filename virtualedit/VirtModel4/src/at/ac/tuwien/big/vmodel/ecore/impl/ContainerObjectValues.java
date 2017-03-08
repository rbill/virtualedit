package at.ac.tuwien.big.vmodel.ecore.impl;

import java.util.Objects;
import java.util.Iterator;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VFunc;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.vmodel.ecore.VObjectValues;
import at.ac.tuwien.big.vmodel.general.EditableIntegerValueElement;
import at.ac.tuwien.big.vmodel.general.VAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableAssoc;
import at.ac.tuwien.big.vmodel.general.VEditableBag;
import at.ac.tuwien.big.vmodel.general.VEntryIterableFunc;
import at.ac.tuwien.big.vmodel.general.VList;
import at.ac.tuwien.big.vmodel.general.impl.SimpleAbstractDelegatingVAssoc;
import at.ac.tuwien.big.vmodel.general.impl.SimpleBag;

public class ContainerObjectValues implements VObjectValues {
	
	
	public ContainerObjectValues(VContainer root) {
		this.root = root;
		{
			VContainer child = root.createChild("objectToClass");
			VObject ret = child.object();
			if (ret == null) {
				child.initObject(ret = SimpleAbstractDelegatingVAssoc.createBasicAssoc(child));
			}
			if (ret instanceof VEntryIterableFunc) {
				this.objectToClass = VEditableAssoc.ensureEditableAssoc((VEntryIterableFunc)ret);
			}
		}
		{
			VContainer child = root.createChild("instances");
			VObject ret = child.object();
			if (ret == null) {
				child.initObject(ret = SimpleBag.createBasicBag(child));
			}
			if (ret instanceof VEntryIterableFunc) {
				this.existingObjects = VEditableBag.ensureBag((VEntryIterableFunc)ret);
			}
		}
	}
	
	private VContainer root;
	
	private VEditableAssoc<String, String, ? extends EditableIntegerValueElement> objectToClass;
	
	private VEditableBag<String, EditableIntegerValueElement> existingObjects;

	@Override
	public String getClass(String objectId) {
		VEditableBag<String, ? extends EditableIntegerValueElement> bag = VEditableBag.ensureBag(objectToClass.get(objectId));
		for (Entry<? extends String,? extends EditableIntegerValueElement> entr: bag.getExistingEntries()) {
			return entr.getKey();
		}
		return null;
	}

	@Override
	public void setClass(String objectId, String classId) {
		VEditableBag<String, ? extends EditableIntegerValueElement> bag = VEditableBag.ensureBag(objectToClass.get(objectId));
		bag.setTo(classId);
		/*for (Entry<? extends String,? extends EditableIntegerValueElement> entr: bag.getExistingEntries()) {
			if (!Objects.equals(entr.getKey(), classId)) {
				entr.getValue().clear();
			} else {
				entr.getValue().setMin(1);
				added = true;
			}
		}
		if (!added) {
			bag.insert(classId);
		}*/
	}

	@Override
	public boolean exists(String objectId) {
		return existingObjects.contains(objectId);
	}

	@Override
	public void add(String objectId) {
		existingObjects.insert(objectId);
	}

	@Override
	public void remove(String objectId) {
		existingObjects.removeAll(objectId);
	}

	@Override
	public Iterator<String> iterator() {
		return (Iterator<String>)existingObjects.getExistingKeys().iterator();
	}

	@Override
	public Iterable<? extends ElementSourceInfo> getSource(String uuid) {
		return existingObjects.get(uuid).getSourceInfos();
	}

	@Override
	public void selfClear() {
		this.objectToClass.selfClear();
		this.existingObjects.selfClear();
	}

	@Override
	public void nullifyClear() {
		this.objectToClass.nullifyClear();
		this.existingObjects.nullifyClear();
	}
}
