package at.ac.tuwien.big.vmod.impl;

import java.util.Objects;
import java.util.Stack;

import at.ac.tuwien.big.util.TreeposMap;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.DelegateBuilt;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.FakeDeltaBuilt;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.IterableType;

public class DelegateTreeposIterablePosition<Type extends IterableType,T> extends SimpleGeneralElement<Type> implements TreeposIterablePosition, DelegateBuilt<TreeposIterablePosition>{
	
	private boolean isUserEdit;
	private TreeposIterablePosition base;

	public DelegateTreeposIterablePosition(
			GeneralElement parent,
			Type type, 
			TreeposIterablePosition base,
			boolean isUserEdit) {
		super(type);
		this.isUserEdit = isUserEdit;
		this.base = base;
		if (hasElement()) {
			setParentLoc(new ParentLocationImpl(parent,getObject(), this));
		} else {
			if (isStart()) {
				setParentLoc(new ParentLocationImpl(parent,"start", this));
			} else {
				setParentLoc(new ParentLocationImpl(parent,"end", this));
			}
		}
	}

	@Override
	public Treepos getObject() {
		if (base != null && base.hasElement()) {
			return base.getObject();
		}
		return null;
	}

	@Override
	public boolean hasElement() {
		return (base != null && base.hasElement());
	}
	
	public TreeposIterablePosition getBase() {
		TreeposIterablePosition baseComp = base;
		return baseComp;
	}
	
	
	public TreeposIterablePosition getUserEditObject() {
		return getObjectInProvider(getUserEditProvider());
	}
	
	public TreeposIterablePosition getTransformationEditObject() {
		return getObjectInProvider(getTransformationEditProvider());
	}
	
	public TreeposIterablePosition getEditObject() {
		if (isUserEdit) {
			return getUserEditObject();
		} else {
			return getTransformationEditObject();
		}
	}
	
	private TreeposIterablePosition getObjectInProvider(ModelProvider prov) {
		if (prov == null) {
			return null;
		}
		if (isUserEditObject(prov)) {
			return this;
		}
		Stack<TreeposIterablePosition> considerObjects = new Stack<>();
		considerObjects.push(base);
		while (!considerObjects.isEmpty()) {
			TreeposIterablePosition cur = considerObjects.pop();
			if (cur.isUserEditObject(prov)) {
				return cur;
			}
			
			if (cur instanceof DeltaBuilt) {
				DeltaBuilt db = (DeltaBuilt)cur;
				if (db.getEdit() instanceof TreeposIterablePosition) {
					considerObjects.push((TreeposIterablePosition)db.getEdit());
				}
				if (db.getBase() instanceof TreeposIterablePosition) {
					considerObjects.push((TreeposIterablePosition)db.getBase());
				}
			} else if (cur instanceof DelegateBuilt) {
				DelegateBuilt db = (DelegateBuilt)cur;
				if (db.getBase() instanceof TreeposIterablePosition) {
					considerObjects.push((TreeposIterablePosition)db.getBase());
				}
			} 
			if (cur instanceof FakeDeltaBuilt) {
				FakeDeltaBuilt db = (FakeDeltaBuilt)cur;
				considerObjects.push((TreeposIterablePosition)db.getFakeEdit());
				considerObjects.push((TreeposIterablePosition)db.getFakeBase());
			}
		}
		return null;
	}

	@Override
	public void add(Treepos obj) {
		TreeposIterablePosition pos = getEditObject();
		pos.add(obj);
	}

	@Override
	public TreeposIterablePosition getNextOrNull() {
		TreeposIterablePosition nextBase;
		nextBase = base.getNextOrNull();
		if (nextBase == null) {
			return null;
		}
		return new DelegateTreeposIterablePosition<>(getParent(), getType(), nextBase, isUserEdit);
	}

	@Override
	public TreeposIterablePosition getPreviousOrNull() {
		TreeposIterablePosition previousBase = base.getPreviousOrNull();
		if (previousBase == null) {
			return null;
		}
		return new DelegateTreeposIterablePosition<>(getParent(), getType(), previousBase, isUserEdit);
	}

	@Override
	public Treepos delete() {
		/*TreeposIterablePosition pos = getEditObject();
		Treepos cmp = pos.getObject();
		if (cmp != null && cmp.equals(getObject())) {
			return pos.delete();
		}*/ //Cannot delete: If you don't delete everything, things might remain. However, you should not delete everything ...
		return getObject();
	}
	

	@Override
	public TreeposIterablePosition endPos() {
		return new DelegateTreeposIterablePosition<>(getParent(), getType(), getBase().endPos(), isUserEdit);
	}

	@Override
	public TreeposIterablePosition startPos() {
		return new DelegateTreeposIterablePosition<>(getParent(), getType(), getBase().startPos(), isUserEdit);
	}
	
}
