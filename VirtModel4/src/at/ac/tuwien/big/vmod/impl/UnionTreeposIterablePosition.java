package at.ac.tuwien.big.vmod.impl;

import java.util.Objects;
import java.util.Stack;

import at.ac.tuwien.big.util.TreeposMap;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.FakeDeltaBuilt;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.IterableType;

public class UnionTreeposIterablePosition<Type extends IterableType,T> extends SimpleGeneralElement<Type> implements TreeposIterablePosition, FakeDeltaBuilt<TreeposIterablePosition, TreeposIterablePosition>{
	
	private boolean isUserEdit;
	private TreeposIterablePosition basePrev;
	private TreeposIterablePosition base;
	private TreeposIterablePosition baseNext;
	private TreeposIterablePosition editPrev;
	private TreeposIterablePosition edit;
	private TreeposIterablePosition editNext;

	public UnionTreeposIterablePosition(
			GeneralElement parent,
			Type type, 
			TreeposIterablePosition basePrev,
			TreeposIterablePosition base, 
			 TreeposIterablePosition baseNext,
			TreeposIterablePosition editPrev,
			TreeposIterablePosition edit, 
			TreeposIterablePosition editNext,
			boolean isUserEdit) {
		super(type);
		this.isUserEdit = isUserEdit;
		this.basePrev = basePrev;
		this.base = base;
		this.baseNext = baseNext;
		this.editPrev = editPrev;
		this.edit = edit;
		this.editNext = editNext;
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
	public boolean isEnd() {
		return (base == null || base.isEnd()) && (edit == null || edit.isEnd()) && baseNext == null && editNext == null;
	}
	
	@Override
	public boolean isStart() {
		return (base == null || base.isStart()) && (edit == null || edit.isStart()) && basePrev == null && editPrev == null;
	}
	
	@Override
	public Treepos getObject() {
		if (base != null && base.hasElement()) {
			return base.getObject();
		}
		if (edit != null && edit.hasElement()) {
			return edit.getObject();
		}
		return null;
	}

	@Override
	public boolean hasElement() {
		return (base != null && base.hasElement()) || (edit != null && edit.hasElement());
	}
	
	public TreeposIterablePosition getFakeBase() {
		TreeposIterablePosition baseComp = base;
		if (baseComp == null) {
			baseComp = basePrev;
		}
		if (baseComp == null) {
			baseComp = baseNext;
		}
		return baseComp;
	}
	

	public TreeposIterablePosition getFakeEdit() {
		TreeposIterablePosition editComp = edit;
		if (editComp == null) {
			editComp = editPrev;
		}
		if (editComp == null) {
			editComp = editNext;
		}
		return editComp;
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
		considerObjects.push(getFakeEdit());
		considerObjects.push(getFakeBase());
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
		TreeposIterablePosition nextBase = getNextBase();
		TreeposIterablePosition nextEdit = getNextEdit();
		if (nextBase == null && nextEdit == null) {
			return null;
		}
		if (nextBase == null) {
			nextBase = base;
		}
		if (nextEdit == null) {
			nextEdit = edit;
		}
		//Both nextBase and nextEdit are != null
		Object prev = nextBase.getObject();
		Object next = nextEdit.getObject();
				
		int compareNext = 0;
		if (nextBase.isEnd()) {
			if (nextEdit.isEnd()) {
				compareNext = 0;
			} else {
				compareNext = 1;
			}
		} else {
			if (nextEdit.isEnd()) {
				compareNext = -1;
			} else {
				if (prev == null && next == null) {
					compareNext = 0;
				} else if (prev == null) {
					compareNext = -1;
				} else if (next == null) {
					compareNext = 1;
				} else {
					compareNext = nextBase.getObject().compareTo(nextEdit.getObject());
				}
			}
		}
		
		if (compareNext > 0) { //Base > Edit
			//Take edit, not base
			return new UnionTreeposIterablePosition<>(getParent(), getType(), nextBase.getPrevious(), null, nextBase, null, nextEdit, null, isUserEdit);
		} else if (compareNext < 0) {
			//Take base, not edit
			return new UnionTreeposIterablePosition<>(getParent(), getType(), null, nextBase, null, nextEdit.getPrevious(), null, nextEdit, isUserEdit);
		} else { //disadvance both
			return new UnionTreeposIterablePosition<>(getParent(), getType(), null, nextBase, null, null, nextEdit, null, isUserEdit);
		}
	}
	
	private TreeposIterablePosition getPreviousBase() {
		if (base != null) {
			return base.getPreviousOrNull();
		} else {
			return basePrev;
		}
	}
	
	private TreeposIterablePosition getNextBase() {
		if (base != null) {
			return base.getNextOrNull();
		} else {
			return baseNext;
		}
	}
	
	private TreeposIterablePosition getPreviousEdit() {
		if (edit != null) {
			return edit.getPreviousOrNull();
		} else {
			return editPrev;
		}
	}
	
	private TreeposIterablePosition getNextEdit() {
		if (edit != null) {
			return edit.getNextOrNull();
		} else {
			return editNext;
		}
	}

	@Override
	public TreeposIterablePosition getPreviousOrNull() {
		TreeposIterablePosition previousBase = getPreviousBase();
		TreeposIterablePosition previousEdit = getPreviousEdit();
		if (previousBase == null && previousEdit == null) {
			return null;
		}
		if (previousBase == null) {
			previousBase = base;
		}
		if (previousEdit == null) {
			previousEdit = edit;
		}
		//If anything is at beginning/end, I want the other one which is not there yet

		int compareNext = 0;
		
		
		//Both nextBase and nextEdit are != null
		Object prev = previousBase.getObject();
		Object next = previousEdit.getObject();
		
		if (previousBase.isStart()) {
			if (previousEdit.isStart()) {
				compareNext = 0;
			} else {
				compareNext = -1;
			}
		} else {
			if (previousEdit.isStart()) {
				compareNext = 1;
			} else {
				if (prev == null && next == null) {
					compareNext = 0;
				} else if (prev == null) {
					compareNext = -1;
				} else if (next == null) {
					compareNext = 1;
				} else {
					compareNext = previousBase.getObject().compareTo(previousEdit.getObject());
				}
			}
		}
		if (compareNext > 0) { //Base > Edit
			//Take base, not edit
			return new UnionTreeposIterablePosition<>(getParent(), getType(), null, previousBase, null, previousEdit, null, previousEdit.getNext(), isUserEdit);
		} else if (compareNext < 0) {
			//Take edit, not base
			return new UnionTreeposIterablePosition<>(getParent(), getType(), previousBase, null, previousBase.getNext(), null, previousEdit, null, isUserEdit);
		} else { //disadvance both
			return new UnionTreeposIterablePosition<>(getParent(), getType(), null, previousBase, null, null, previousEdit, null, isUserEdit);
		}
	}

	@Override
	public Treepos delete() {
		/*TreeposIterablePosition pos = getEditObject();
		Treepos cmp = pos.getObject();
		if (cmp != null && cmp.equals(getObject())) {
			return pos.delete(); 
		}*///Cannot delete: If you don't delete everything, things might remain. However, you should not delete everything ...
		return getObject();
	}
	

	@Override
	public TreeposIterablePosition endPos() {
		return new UnionTreeposIterablePosition<>(getParent(), getType(), null, getFakeBase().endPos(), null, null, getFakeEdit().endPos(), null, isUserEdit);
	}

	@Override
	public TreeposIterablePosition startPos() {
		return new UnionTreeposIterablePosition<>(getParent(), getType(), null, getFakeBase().startPos(), null, null, getFakeEdit().startPos(), null, isUserEdit);
	}
	
}
