package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.List;

import at.ac.tuwien.big.vfunc.nbasic.ListChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.ListListenable;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class ListRepeater<T> implements ListListenable<T> {

	List<T> repeatList;
	
	public ListRepeater(List<T> repeatList) {
		this.repeatList = repeatList;
	}

	@Override
	public void added(int index, T object, ListChangeNotifyer<T> lcn) {
		if (index <= this.repeatList.size()) {
			this.repeatList.add(index, object);
		}
		PatchUtil.applyPatch(this.repeatList, lcn);
	}

	@Override
	public void changed(int index, T oldObject, T newObject, ListChangeNotifyer<T> lcn) {
		if (index < this.repeatList.size()) {
			this.repeatList.set(index, newObject);
		}
		PatchUtil.applyPatch(this.repeatList, lcn);
	}

	@Override
	public void changed(ListChangeNotifyer<T> lcn) {
		PatchUtil.applyPatch(this.repeatList, lcn);
	}

	@Override
	public void removed(int index, T object, ListChangeNotifyer<T> lcn) {
		if (index < this.repeatList.size()) {this.repeatList.remove(index);}
		PatchUtil.applyPatch(this.repeatList, lcn);
	}
	
	
}
