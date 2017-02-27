package at.ac.tuwien.big.vmod.impl;

import java.util.Objects;
import java.util.Stack;

import at.ac.tuwien.big.vmod.DelegateBuilt;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.FakeDeltaBuilt;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.GeneralType;

public abstract class SimpleDelegateGeneralElement<Type extends GeneralType, Base> extends SimpleGeneralElement<Type> implements DelegateBuilt<Base>{
	
	private Base base;
	private boolean isUserEdit = false;
	

	public SimpleDelegateGeneralElement(Type type, Base base, boolean isUserEdit) {
		super(type);
		this.base = base;
		this.isUserEdit = isUserEdit;
	}
	

	public void setBase(Base base) {
		this.base = base;
	}
	
	public Base getBase() {
		return base;
	}
	
	
	public boolean isUserEdit() {
		return isUserEdit;
	}
	
	@Override
	public Object getMetaInfo(String key) {
		if ("base".equals(key)) {
			return getBase();
		} else if ("isUserEdit".equals(key)) {
			return isUserEdit;
		}
		return super.getMetaInfo(key);
	}
	
	public Object getUserEditObject() {
		return getObjectInProvider(getUserEditProvider());
	}
	
	public Object getTransformationEditObject() {
		return getObjectInProvider(getTransformationEditProvider());
	}
	
	public<T> T getEditObject() {
		if (isUserEdit) {
			return (T)getUserEditObject();
		} else {
			return (T)getTransformationEditObject();
		}
	}
	
	public Object getObjectInProvider(ModelProvider prov) {
		if (prov == null) {
			return null;
		}
		if (isUserEditObject(prov)) {
			return this;
		}
		Stack<Object> considerObjects = new Stack<>();
		considerObjects.push(base);
		while (!considerObjects.isEmpty()) {
			Object cur = considerObjects.pop();
			if (cur instanceof GeneralElement) {
				GeneralElement ge = (GeneralElement)cur;
				if (ge.isUserEditObject(prov)) {
					return ge;
				}
			}
			if (cur instanceof DeltaBuilt) {
				DeltaBuilt db = (DeltaBuilt)cur;
				considerObjects.push(db.getEdit());
				considerObjects.push(db.getBase());
			} else if (cur instanceof FakeDeltaBuilt) {
				FakeDeltaBuilt db = (FakeDeltaBuilt)cur;
				considerObjects.push(db.getFakeEdit());
				considerObjects.push(db.getFakeBase());
			} else if (cur instanceof DelegateBuilt) {
				DelegateBuilt db = (DelegateBuilt)cur;
				considerObjects.push(db.getBase());
			}
		}
		return null;
	}

}
