package at.ac.tuwien.big.vmodel.general;

import at.ac.tuwien.big.xtext.equalizer.Creater;

public interface Chooser<X,Y> extends Creater<X, Y> {
	
	public X chooseOrNull(Y forValue, Iterable<? extends X> iterable);
	

}
