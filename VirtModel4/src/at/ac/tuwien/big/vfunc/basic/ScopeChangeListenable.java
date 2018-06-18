package at.ac.tuwien.big.vfunc.basic;

public interface ScopeChangeListenable<N extends ScopeNotifyer<?,Source>,Source> {
	
	public void changed(ScopeChange<? extends  N, ? extends Source> change);

}
