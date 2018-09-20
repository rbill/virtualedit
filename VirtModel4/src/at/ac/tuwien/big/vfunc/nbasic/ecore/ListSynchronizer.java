package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class ListSynchronizer<T,U> {
	
	private List<T> unmodified;
	private List<U> modified;
	private Function<T,U> convertThere;
	private Function<U,T> convertBack;
	
	public ListSynchronizer(List<T> unmodified, List<U> modified, Function<T,U> convertThere, Function<U,T> convertBack) {
		this.unmodified = unmodified;
		this.modified = modified;
		this.convertBack = convertBack;
		this.convertThere = convertThere;
	}
	
	public void reverseSynchronize() {
		List<U> newModified = new ArrayList<>();
		for (T t: this.unmodified) {
			newModified.add(this.convertThere.apply(t));
		}
		PatchUtil.applyPatch(this.modified,newModified);
	}
	
	public void synchronize() {
		List<T> newModified = new ArrayList<>();
		for (U t: this.modified) {
			newModified.add(this.convertBack.apply(t));
		}
		PatchUtil.applyPatch(this.unmodified,newModified);
	}

}
