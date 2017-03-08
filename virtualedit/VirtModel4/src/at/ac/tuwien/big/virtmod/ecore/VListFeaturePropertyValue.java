package at.ac.tuwien.big.virtmod.ecore;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.VBag;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.VList;
import at.ac.tuwien.big.virtmod.basic.VSet;

public interface VListFeaturePropertyValue<T> extends FeaturePropertyValue<T>{
	
	public VEditableList<T> getDelegate();
	
	@Override
	public default EList<T> getDelegateList() {
		//Diese Collection muss leider auch Opposite etc. machen
		return getDelegate().asCollection();
	}
	

}
