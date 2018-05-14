package at.ac.tuwien.big.vfunc.basic;

import java.util.Collection;

public interface BasicFunctionForUpdate<Src,Trg> {

	
	public Trg getValue(Src src, Collection<? super Notifyer<?, ?, ?>> usedThings);
}
