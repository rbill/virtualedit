package at.ac.tuwien.big.vfunc.basic;

public interface ChangeListenable<N extends Notifyer<?,Source,Target>,Source,Target> {
	
	public void changed(Change<? extends N,? extends Source,? extends Target> change);

}