package at.ac.tuwien.big.vfunc.basic;

public interface FilteredScopeChange<This,Src> extends ScopeChange<This,Src> {

	public boolean wasAdded(Object src);
	
	public boolean wasDeleted(Object src);
}
