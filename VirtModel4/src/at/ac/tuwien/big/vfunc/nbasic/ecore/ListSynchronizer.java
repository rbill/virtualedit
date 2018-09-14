package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class ListSynchronizer<T> {
	
	private List<T> unmodified;
	private List<T> modified;
	
	public ListSynchronizer(List<T> unmodified, List<T> modified) {
		this.unmodified = unmodified;
		this.modified = modified;
	}
	
	public void synchronize() {
		PatchUtil.applyPatch(unmodified,modified);
	}
	
	public void reverseSynchronize() {
		PatchUtil.applyPatch(modified,unmodified);
	}

}
